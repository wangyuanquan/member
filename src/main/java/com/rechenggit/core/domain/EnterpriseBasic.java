package com.rechenggit.core.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;
@Setter
@Getter
@ToString
public class EnterpriseBasic {

    /**
     * 商家id
     */
    @NotNull()
    private String memberId;

    /**
     * 商家地址
     */
    private String address;

    /**
     * 商家地址：市郊
     */
    private String suburb;

    /**
     * 商家地址：州
     */
    private String state;

    /**
     * 商家地址：邮编
     */
    private String postCode;

    /**
     * 商家：联系电话
     */
    private String phone;

    /**
     * 商家：电子邮件地址
     */
    private String email;

    /**
     * 主要联系人：全名
     */
    private String contactName;

    /**
     * 主要联系人：手机号
     */

    private String contactPhone;

    /**
     * 主要联系人：职称
     */
    private String contactTitle;

    /**
     * 账单：用户名
     */
    private String accountName;

    /**
     * 账单：银行名称
     */
    private String bankName;

    /**
     * 账单：BSB账号
     */
    private String bbsNumber;

    /**
     * 账单：上传文件信息
     */
    private String filePath;
    /**
     * 商店信息id
     */
    private String storeInfoId;

    /**
     * 公司信息id
     */
    private String companyInfoId;
    /**
     * 公司注册-名称
     */
    private String companyName;

    /**
     * 公司注册-支持票据(ABN)
     */
    private String companyAbn;

    /**
     * 公司注册-税号(ACN)
     */
    private String companyAcn;

    /**
     * 公司注册-行业
     */
    private String companyIndustry;

    /**
     * 公司注册-地址
     */
    private String companyAddress;

    /**
     * 注册地址-市郊
     */
    private String companySuburb;

    /**
     * 注册地址-州
     */
    private String companyState;

    /**
     * 注册地址-邮政编码
     */
    private String companyPostcode;
    /**
     * 商店信息
     */
    private List<EnterpriseStore> storeInfo;

    /**
     * 公司信息
     */
    private List<EnterpriseCompany> companyInfo;
}
