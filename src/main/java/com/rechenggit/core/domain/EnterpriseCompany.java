package com.rechenggit.core.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class EnterpriseCompany {

    private String memberId;

    /**
     * 公司注册：名称
     */
    private String companyName;

    /**
     * 公司注册支持票据（ABN）
     */
    private String companyAbn;

    /**
     * 公司注册：税号（ACN）
     */
    private String companyAcn;

    /**
     * 公司注册：行业
     */
    private String companyIndustry;

    /**
     * 公司注册：地址
     */
    private String companyAddress;

    /**
     * 注册地址：市郊
     */
    private String companySuburb;

    /**
     * 注册地址：州
     */
    private String companyState;

    /**
     * 注册地址：邮政编码
     */
    private String companyPostcode;

    /**
     * 注册信息：直接名称
     */
    private String directerName;

    /**
     * 图片（照片，执照，驾照）
     */
    private String photoId;

    /**
     * 图片类型
     */
    private Byte photoIdType;


}
