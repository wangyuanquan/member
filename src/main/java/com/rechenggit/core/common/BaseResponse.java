package com.rechenggit.core.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Getter
@Setter
@ToString
public class BaseResponse<T> {
    /*
    200  成功
    500  失败
    501  没有商品ID，添加相关信息失败
    502  该商户信息已添加
    503  无相关信息
    504  参数错误
    506  邮件发送失败
    * */
    private int status =200;

    private String message = "operation.success";
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }
    @Override
    public  String  toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
