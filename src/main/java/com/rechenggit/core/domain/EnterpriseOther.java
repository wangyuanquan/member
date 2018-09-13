package com.rechenggit.core.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@ToString
public class EnterpriseOther {
    private Integer id;
    private String memberId;
    /**
     * 行业特定资格类型
     */
    private Integer qualificationType;

    /**
     * 行业特定资格文件
     */
    private String qualificationFile;

    /**
     * 商标
     */
    private String tradeMarkLogo;

    /**
     * 相片
     */

    private String tradeMarkPhoto;

    /**
     * 协议文件
     */

    private String protocolFile;

    private Date createTime;

    private Date updateTime;

    private String uploadingFiles;

    private String settlementCycle;

    private Integer profitDistribution;

    private Integer column13;

    private String type;

    private Integer rate;
}