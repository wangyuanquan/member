package com.rechenggit.core.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class PageResponse<T>{

    private Page pagination;

    /**
     * 应答码
     */
    private int  status ;

    /**
     * 应答数据
     */
    @JSONField(serialzeFeatures = {SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty})
    private T list;

    private String message;


}
