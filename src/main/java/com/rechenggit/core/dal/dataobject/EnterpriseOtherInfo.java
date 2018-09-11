package com.rechenggit.core.dal.dataobject;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tm_enterprise_other_info")
public class EnterpriseOtherInfo {
    @Id
    private Integer id;

    @Column(name = "member_id")
    private String memberId;

    /**
     * 行业特定资格类型
     */
    @Column(name = "qualification_type")
    private Integer qualificationType;

    /**
     * 行业特定资格文件
     */
    @Column(name = "qualification_file")
    private String qualificationFile;

    /**
     * 商标
     */
    @Column(name = "trade_mark_logo")
    private String tradeMarkLogo;

    /**
     * 相片
     */
    @Column(name = "trade_mark_photo")
    private String tradeMarkPhoto;

    /**
     * 协议文件
     */
    @Column(name = "protocol_file")
    private String protocolFile;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "uploading_files")
    private String uploadingFiles;

    @Column(name = "settlement_cycle")
    private String settlementCycle;

    @Column(name = "profit_distribution")
    private Integer profitDistribution;

    @Column(name = "column_13")
    private Integer column13;

    private String type;

    private Integer rate;

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
     * @return member_id
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * @param memberId
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * 获取行业特定资格类型
     *
     * @return qualification_type - 行业特定资格类型
     */
    public Integer getQualificationType() {
        return qualificationType;
    }

    /**
     * 设置行业特定资格类型
     *
     * @param qualificationType 行业特定资格类型
     */
    public void setQualificationType(Integer qualificationType) {
        this.qualificationType = qualificationType;
    }

    /**
     * 获取行业特定资格文件
     *
     * @return qualification_file - 行业特定资格文件
     */
    public String getQualificationFile() {
        return qualificationFile;
    }

    /**
     * 设置行业特定资格文件
     *
     * @param qualificationFile 行业特定资格文件
     */
    public void setQualificationFile(String qualificationFile) {
        this.qualificationFile = qualificationFile == null ? null : qualificationFile.trim();
    }

    /**
     * 获取商标
     *
     * @return trade_mark_logo - 商标
     */
    public String getTradeMarkLogo() {
        return tradeMarkLogo;
    }

    /**
     * 设置商标
     *
     * @param tradeMarkLogo 商标
     */
    public void setTradeMarkLogo(String tradeMarkLogo) {
        this.tradeMarkLogo = tradeMarkLogo == null ? null : tradeMarkLogo.trim();
    }

    /**
     * 获取相片
     *
     * @return trade_mark_photo - 相片
     */
    public String getTradeMarkPhoto() {
        return tradeMarkPhoto;
    }

    /**
     * 设置相片
     *
     * @param tradeMarkPhoto 相片
     */
    public void setTradeMarkPhoto(String tradeMarkPhoto) {
        this.tradeMarkPhoto = tradeMarkPhoto == null ? null : tradeMarkPhoto.trim();
    }

    /**
     * 获取协议文件
     *
     * @return protocol_file - 协议文件
     */
    public String getProtocolFile() {
        return protocolFile;
    }

    /**
     * 设置协议文件
     *
     * @param protocolFile 协议文件
     */
    public void setProtocolFile(String protocolFile) {
        this.protocolFile = protocolFile == null ? null : protocolFile.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return uploading_files
     */
    public String getUploadingFiles() {
        return uploadingFiles;
    }

    /**
     * @param uploadingFiles
     */
    public void setUploadingFiles(String uploadingFiles) {
        this.uploadingFiles = uploadingFiles == null ? null : uploadingFiles.trim();
    }

    /**
     * @return settlement_cycle
     */
    public String getSettlementCycle() {
        return settlementCycle;
    }

    /**
     * @param settlementCycle
     */
    public void setSettlementCycle(String settlementCycle) {
        this.settlementCycle = settlementCycle == null ? null : settlementCycle.trim();
    }

    /**
     * @return profit_distribution
     */
    public Integer getProfitDistribution() {
        return profitDistribution;
    }

    /**
     * @param profitDistribution
     */
    public void setProfitDistribution(Integer profitDistribution) {
        this.profitDistribution = profitDistribution;
    }

    /**
     * @return column_13
     */
    public Integer getColumn13() {
        return column13;
    }

    /**
     * @param column13
     */
    public void setColumn13(Integer column13) {
        this.column13 = column13;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * @return rate
     */
    public Integer getRate() {
        return rate;
    }

    /**
     * @param rate
     */
    public void setRate(Integer rate) {
        this.rate = rate;
    }
}