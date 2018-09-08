package com.rechenggit.core.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseResponse<T> {
    private int status;

    private String message;

    private T data;

}
