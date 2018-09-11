package com.rechenggit.core.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class EnterpriseBasic {

    /**
     * 商家名称
     */
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
    private String billName;

    /**
     * 账单：银行名称
     */
    private String billBank;

    /**
     * 账单：BSB账号
     */
    private String billBbsAccount;

    /**
     * 账单：上传文件信息
     */
    private String billFilePath;

    /**
     * 商店信息
     */
    private List<EnterpriseStore> storeInfo;

    /**
     * 公司信息
     */
    private List<EnterpriseCompany> companyInfo;


}
