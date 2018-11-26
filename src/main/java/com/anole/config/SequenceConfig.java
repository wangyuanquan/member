package com.anole.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class SequenceConfig {
    @Bean(name = "unitySequenceFlushTreadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        //线程池维护线程的最少数量
        threadPoolTaskExecutor.setCorePoolSize(5);
        //线程池维护线程的最大数量
        threadPoolTaskExecutor.setMaxPoolSize(10);
        //缓存队列
        threadPoolTaskExecutor.setQueueCapacity(100);
        //允许的空闲时间
        threadPoolTaskExecutor.setKeepAliveSeconds(100);
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return threadPoolTaskExecutor;
    }
}
