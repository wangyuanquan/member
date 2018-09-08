package com.rechenggit.core.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
