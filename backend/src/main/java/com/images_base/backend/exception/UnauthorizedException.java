package com.images_base.backend.exception;

import org.springframework.http.HttpStatus;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/23
 */
public class UnauthorizedException extends BaseException {

    public UnauthorizedException() {
    }

    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}
