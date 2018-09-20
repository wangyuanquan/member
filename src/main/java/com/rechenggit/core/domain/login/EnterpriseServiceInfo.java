package com.rechenggit.core.domain.login;

import com.rechenggit.core.domain.enums.MemberTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Setter
@Getter
@ToString
public class EnterpriseServiceInfo {
    /**
     * 商户邮箱
     */
    @Email
    private String identity;
    /**
     * 姓名
     */
    @NotBlank
    private String memberName;
    /**
     * 地址
     */
    @NotBlank
    private String address;
    /**
     * 联系人
     */
    @NotBlank
    private String  contactName;
    /**
     * 联系人手机号
     */
    @NotBlank
    private String  contactPhone;
    /**
     * 平台类型：1:企业 2：个人
     */
    private Integer pid;

}
