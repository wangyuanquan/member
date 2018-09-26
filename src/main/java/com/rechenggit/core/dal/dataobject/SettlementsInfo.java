package com.rechenggit.core.dal.dataobject;

import java.math.BigDecimal;
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
     * 微信
     */
    @Column(name = "we_chat")
    private BigDecimal weChat;

    /**
     * 支付宝
     */
    private BigDecimal alipay;

    /**
     * 结算服务类型(1:商家2：消费者)
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
     * 获取微信
     *
     * @return we_chat - 微信
     */
    public BigDecimal getWeChat() {
        return weChat;
    }

    /**
     * 设置微信
     *
     * @param weChat 微信
     */
    public void setWeChat(BigDecimal weChat) {
        this.weChat = weChat;
    }

    /**
     * 获取支付宝
     *
     * @return alipay - 支付宝
     */
    public BigDecimal getAlipay() {
        return alipay;
    }

    /**
     * 设置支付宝
     *
     * @param alipay 支付宝
     */
    public void setAlipay(BigDecimal alipay) {
        this.alipay = alipay;
    }

    /**
     * 获取结算服务类型(1:商家2：消费者)
     *
     * @return settlement_type - 结算服务类型(1:商家2：消费者)
     */
    public Integer getSettlementType() {
        return settlementType;
    }

    /**
     * 设置结算服务类型(1:商家2：消费者)
     *
     * @param settlementType 结算服务类型(1:商家2：消费者)
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