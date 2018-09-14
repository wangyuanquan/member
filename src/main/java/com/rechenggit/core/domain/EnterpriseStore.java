package com.rechenggit.core.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EnterpriseStore {

    /**
     * 商店名称
     */
    private String storeName;

    /**
     * 页面展示序号
     */
    private Byte displayNum;

    /**
     * 商店地址
     */
    private String storeAddress;

    /**
     * 商店地址：市郊
     */
    private String storeSuburb;

    /**
     * 商店地址：州
     */
    private String storeState;

    /**
     * 商店地址：邮编
     */
    private String storePostCode;

    /**
     * 商店：联系电话
     */
    private String storePhone;

    /**
     * 商店：电子邮件地址
     */
    private String storeEmail;

}
