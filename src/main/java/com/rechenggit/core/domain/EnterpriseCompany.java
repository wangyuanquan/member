package com.rechenggit.core.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EnterpriseCompany {

    private String memberId;

    /**
     * 公司注册：名称
     */
    private String companyName;

    /**
     * 页面展示序号
     */
    private Byte displayNum;

    /**
     * 注册信息：經理名称
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
