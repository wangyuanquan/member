package com.anole.core.exception;


import com.anole.core.domain.enums.ResponseCode;

/**
 *
 * <p>MA 业务异常</p>
 * @author netfinworks
 * @version $Id: MaBaseBizException.java, v 0.1 2011-3-24 下午01:15:09 netfinworks Exp $
 */
public class MaBizException extends Exception {
    private static final long serialVersionUID = 5558419943675631531L;

    /**
     * 应答码
     */
    private ResponseCode responseCode;

    /**
     * 构造方法
     * @param responseCode
     */
    public MaBizException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.responseCode = responseCode;
    }

    /**
     * 构造方法
     * @param responseCode
     * @param message
     */
    public MaBizException(ResponseCode responseCode, String message) {
        super(message);
        this.responseCode = responseCode;
    }

    /**
     * 构造方法
     * @param responseCode
     * @param message
     * @param cause
     */
    public MaBizException(ResponseCode responseCode, String message, Throwable cause) {
        super(message, cause);
        this.responseCode = responseCode;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public Integer getCode() {
        return responseCode.getCode();
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }
}
