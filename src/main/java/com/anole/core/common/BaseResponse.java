package com.anole.core.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseResponse<T> {
    /*
    200  成功
    500  失败
    * */
    private int status = 200;

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

}
