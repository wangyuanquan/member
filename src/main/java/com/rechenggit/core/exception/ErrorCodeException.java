package com.rechenggit.core.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * <p>错误码异常类</p>
 * @author Your name
 * @version $Id: ErrorCodeException.java, v 0.1 2013-11-18 下午4:20:12 lilun Exp $
 */
@Setter
@Getter
@ToString
public class ErrorCodeException extends Exception {

    private static final long serialVersionUID = 4005358808809902012L;

    private String            errorCode;
    private String            errorMsg;
    private String            memo;

    public ErrorCodeException(String errorCode, String errorMsg) {
        super();
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public static class CommonException extends ErrorCodeException {

        private static final long serialVersionUID = -3004891288021568474L;

        public CommonException(String errorCode, String errorMsg) {
            super(errorCode, errorMsg);
        }

    }

}
