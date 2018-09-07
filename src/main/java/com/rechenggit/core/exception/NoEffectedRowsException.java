package com.rechenggit.core.exception;


import com.rechenggit.core.domain.enums.ResponseCode;

public class NoEffectedRowsException extends MaBizException {

    /**
     *
     */
    private static final long serialVersionUID = -6009735650087149547L;

    public NoEffectedRowsException() {
        super(ResponseCode.DB_NO_EFFECTED_ROWS);
    }

    public NoEffectedRowsException(String message) {
        super(ResponseCode.DB_NO_EFFECTED_ROWS, message);
    }

}
