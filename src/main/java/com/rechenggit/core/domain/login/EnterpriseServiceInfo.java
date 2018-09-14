package com.rechenggit.core.domain.login;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EnterpriseServiceInfo {
    /**
     * 商户邮箱
     */
    private String identity;
    /**
     * 姓名
     */
    private String memberName;
    /**
     * 地址
     */
    private String address;

    /**
     * 联系人
     */
    private String  contactName;
    /**
     * 联系人手机号
     */
    private String  contactPhone;
    /**
     * 密码
     */
    private String  password;

}
