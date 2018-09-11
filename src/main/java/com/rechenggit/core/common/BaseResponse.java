package com.rechenggit.core.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseResponse<T> {
    /*
    200 ： 成功
    500 ： 失败
    501 ： 没有商品ID，添加相关信息失败
    502 ： 该商户信息已添加

    * */
    private int status =200;

    private String message = "成功";

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
}
