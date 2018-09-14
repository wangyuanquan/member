package com.rechenggit.core.domain;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
public class EnterpriseMemberServiceDomain  extends JSONObject {
    private String memberId;


    @NotEmpty(message ="{memberId.empty.error}")
    public String getMemberId() {

        return this.getString("memberId");
    }


}
