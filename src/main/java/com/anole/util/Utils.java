package com.anole.util;

import java.io.UnsupportedEncodingException;

import com.anole.core.common.BaseResponse;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * <p>公用小方法/p>
 * @author netfinworks
 * @version $Id: Utils.java, v 0.1 2011-3-24 下午04:19:35 netfinworks Exp $
 */
public class Utils {
    public static String DEFAULT_CHARSET = "UTF-8";
    private static final Logger logger = LoggerFactory.getLogger(Utils.class);
    private Utils() {

    }

    public static int getByteLen(String s) {
        if (s == null) {
            return 0;
        }
        try {
            return s.getBytes("GBK").length;
        } catch (UnsupportedEncodingException e) {
            return s.getBytes().length;
        }
    }

    /**
     * 打印java 对象
     * @param obj
     * @return
     */
    public static String toString(Object obj) {
        return ToStringBuilder.reflectionToString(obj, ToStringStyle.SHORT_PREFIX_STYLE);
    }
    public static String hashSignContent(String txt) {
        try {
            return DigestUtils.sha256Hex(txt.getBytes(DEFAULT_CHARSET));
        } catch (UnsupportedEncodingException ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        }
    }
    //解密
    public static String decryPwd(String param)
    {
        String pwd= StringUtils.substring(param,64);
        return pwd;
    }

    public static void main(String[] args) {

        System.out.println(hashSignContent("1111111"));
    }

}

