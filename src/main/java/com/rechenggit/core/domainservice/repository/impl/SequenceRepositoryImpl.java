package com.rechenggit.core.domainservice.repository.impl;


import com.rechenggit.core.dal.dataobject.Sequence;
import com.rechenggit.core.dal.mapper.SequenceMapper;
import com.rechenggit.core.domainservice.repository.SequenceRepository;
import com.rechenggit.core.exception.SequenceUpdateException;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@Repository
public class SequenceRepositoryImpl implements SequenceRepository, InitializingBean {

    /**
     * 序列DAO
     */
    @Resource
    private SequenceMapper sequenceMapper;

    /**
     * 缓存队列
     */
    private ConcurrentHashMap<String, ConcurrentLinkedQueue<Long>> sequenceQueue = new ConcurrentHashMap<String, ConcurrentLinkedQueue<Long>>();

    /**
     * 刷新锁
     */
    private ConcurrentHashMap<String, ReentrantLock>               locks         = new ConcurrentHashMap<String, ReentrantLock>();

    /**
     * 计数器
     */
    private ConcurrentHashMap<String, AtomicInteger>               counts        = new ConcurrentHashMap<String, AtomicInteger>();

    /**
     * 异步刷新线程池
     */
    @Resource(name = "unitySequenceFlushTreadPoolTaskExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    /**
     * 阀值
     */
    private Map<String, Integer> thresholds    = new HashMap<String, Integer>();

    /**
     * 总数
     */
    private Map<String, Integer>                                   totals        = new HashMap<String, Integer>();

    /**
     * 事务模板
     */
    @Autowired
    private TransactionTemplate transactionTemplate;

    /* (non-Javadoc)
     * @see com.netfinworks.repository.SequenceRepository#flush(java.util.List)
     */
    @Override
    public void flush(final String sequenceName) {

        //  检查阀值
        if (overThreshold(sequenceName)) {

            //  尝试获取锁
            //  若返回false则已被锁定，当前线程则不做操作
            if (locks.get(sequenceName).tryLock()) {
                try {
                    //  double check
                    if (overThreshold(sequenceName)) {
                        try {
                            //  刷新缓冲区
                            flushBuffer(sequenceName);

                        } catch (SequenceUpdateException e) {
                            //  更新异常则异步线程更新
                            asyncFlush(sequenceName);
                        }
                    }
                } finally {
                    //  释放锁
                    locks.get(sequenceName).unlock();
                }

            }
        }

    }

    /**
     * 刷新缓冲区
     * @param sequenceName
     */
    private void flushBuffer(final String sequenceName) {

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            protected void doInTransactionWithoutResult(TransactionStatus arg0) {
                //  锁取
                Sequence sequence = sequenceMapper.lock(sequenceName);
                //  计算偏移量
                Integer offset = sequence.getIncrement() * totals.get(sequenceName);
                //  计算更新值
                Long beforeValue = sequence.getCurrentValue();
                Long afterValue = beforeValue + offset;
                //  更新
                try {
                    sequenceMapper.update(sequenceName, beforeValue, afterValue);
                } catch (Exception e) {
                    //  更新失败抛出异常准备重试
                    throw new SequenceUpdateException(e);
                }

                //  设置更新后值
                sequence.setAfterValue(afterValue);

                //  清空数据，初始化
                sequenceQueue.put(sequenceName, new ConcurrentLinkedQueue<Long>());

                //  设值
                for (long seq = beforeValue; seq < afterValue; seq = seq + sequence.getIncrement().longValue()) {
                    sequenceQueue.get(sequenceName).add(seq);
                }

                //  计数器初始化
                counts.put(sequenceName, new AtomicInteger(0));

            }

        });
    }

    /* (non-Javadoc)
     * @see com.netfinworks.repository.SequenceRepository#get(java.lang.String)
     */
    @Override
    public Long next(final String sequenceName) {
        Long sequence = sequenceQueue.get(sequenceName).poll();

        //  取到了值
        if (sequence != null) {

            //  计数增长
            counts.get(sequenceName).incrementAndGet();

            //  若达到刷新阀值,异步刷新
            if (overThreshold(sequenceName)) {
                asyncFlush(sequenceName);
            }

            return sequence;
        }

        //  若队列取空
        try {
            //  立即刷新
            flush(sequenceName);
            //  重新抓取
            return next(sequenceName);
        } catch (Exception e) {
            //  目前失败了递归重新取
            return next(sequenceName);
        }

    }

    /**
     * 是否越过刷新阀值
     * @param sequenceName
     * @return
     */
    private boolean overThreshold(final String sequenceName) {
        return counts.get(sequenceName).intValue() >= totals.get(sequenceName) - thresholds.get(sequenceName);
    }

    /**
     * 异步刷新
     * 有较小几率线程池耗尽导致刷新任务丢失
     * @param sequenceName
     */
    private void asyncFlush(final String sequenceName) {

        try {

            threadPoolTaskExecutor.execute(new Runnable() {

                @Override
                public void run() {

                    flush(sequenceName);
                }
            });
        } catch (TaskRejectedException e) {
            // 捕获线程池拒绝异常
            // 不作处理

        }

    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {

        //  初始化queue map
        if (MapUtils.isEmpty(sequenceQueue)) {
            //  获取序列列表
            List<Sequence> sequenceList = sequenceMapper.loadAll();

            for (Sequence sequence : sequenceList) {

                //  置阀值
                thresholds.put(sequence.getName(), sequence.getThreshold());

                //  设总数
                totals.put(sequence.getName(), sequence.getTotal());

                //  初始化锁队列
                locks.put(sequence.getName(), new ReentrantLock());

                //  更新缓冲区
                flushBuffer(sequence.getName());

            }
        }

        System.out.println("-----------------");
    }
}
