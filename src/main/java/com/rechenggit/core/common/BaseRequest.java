package com.rechenggit.core.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRequest<T> {
    private String lang;
    private T data;
}
