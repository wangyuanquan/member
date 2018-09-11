package com.rechenggit.core.exception;

public class ValidateException extends Exception {
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public ValidateException(String message) {
        super(message);
    }

    public ValidateException(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }
}
