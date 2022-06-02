package com.digiwin.demo.assess.exception;

import java.text.MessageFormat;

public class BusinessException extends RuntimeException {
    public static final int UNAUTHORIZED = 401;
    public static final int ERROR = 500;
    private static final long serialVersionUID = 8065583911104112360L;
    private final Integer code;
    private Object[] args;

    public BusinessException(String message) {
        super(message);
        this.code = 500;
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Integer code, String message, Object... args) {
        super(MessageFormat.format(message, args));
        this.code = code;
        this.args = args;
    }

    public Integer getCode() {
        return this.code;
    }

    public Object[] getArgs() {
        return this.args;
    }
}
