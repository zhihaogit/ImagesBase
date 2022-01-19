package com.images_base.backend.handler;

import com.images_base.backend.exception.BaseException;
import com.images_base.backend.modal.vo.normal.ResponseBodyVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/23
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 基础异常处理
     *
     * @param e
     * @param response
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public ResponseBodyVO runtimeExceptionHandler(BaseException e, HttpServletResponse response) {
        logger.warn("运行时错误：{}", e.getLocalizedMessage());
        e.printStackTrace();
        response.setStatus(e.getStatus().value());
        return new ResponseBodyVO(e.getLocalizedMessage(), null);
    }

    /**
     * sql相关异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseBodyVO sqlExceptionHandler(SQLException e) {
        logger.info("SQL错误：{}", e.getMessage());
        return new ResponseBodyVO(e.getMessage(), null);
    }

    /**
     * 缺少参数异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseBodyVO missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException e) {
        logger.info("请求缺少参数：{}", e.getParameterName());
        return new ResponseBodyVO(String.format("请求缺少参数：%s", e.getParameterName()), null);
    }
}
