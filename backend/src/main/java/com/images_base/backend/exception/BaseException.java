package com.images_base.backend.exception;

import org.springframework.http.HttpStatus;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/23
 */
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = 41L;

    protected BaseException() {
    }

    protected BaseException(String message) {
        super(message);
    }

    protected BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract HttpStatus getStatus();
}
