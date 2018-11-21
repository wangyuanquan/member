package com.anole.core.dal.dataobject;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tm_settlements_info")
public class SettlementsInfo {
    @Id
    private Integer id;

    /**
     * 商家id
     */
    @Column(name = "member_id")
    private String memberId;

    /**
     * 对商人费率
     */
    private Float merchant;

    /**
     * 对消费者费率
     */
    private Float consumer;

    /**
     * 结算服务类型
     */
    @Column(name = "settlement_type")
    private Integer settlementType;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商家id
     *
     * @return member_id - 商家id
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * 设置商家id
     *
     * @param memberId 商家id
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * 获取对商人费率
     *
     * @return merchant - 对商人费率
     */
    public Float getMerchant() {
        return merchant;
    }

    /**
     * 设置对商人费率
     *
     * @param merchant 对商人费率
     */
    public void setMerchant(Float merchant) {
        this.merchant = merchant;
    }

    /**
     * 获取对消费者费率
     *
     * @return consumer - 对消费者费率
     */
    public Float getConsumer() {
        return consumer;
    }

    /**
     * 设置对消费者费率
     *
     * @param consumer 对消费者费率
     */
    public void setConsumer(Float consumer) {
        this.consumer = consumer;
    }

    /**
     * 获取结算服务类型
     *
     * @return settlement_type - 结算服务类型
     */
    public Integer getSettlementType() {
        return settlementType;
    }

    /**
     * 设置结算服务类型
     *
     * @param settlementType 结算服务类型
     */
    public void setSettlementType(Integer settlementType) {
        this.settlementType = settlementType;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}