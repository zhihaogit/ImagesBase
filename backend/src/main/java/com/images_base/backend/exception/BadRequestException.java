package com.images_base.backend.exception;

import org.springframework.http.HttpStatus;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/23
 */
public class BadRequestException extends BaseException {

    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
