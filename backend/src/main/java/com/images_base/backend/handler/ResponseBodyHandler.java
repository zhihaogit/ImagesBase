package com.images_base.backend.handler;

import com.images_base.backend.modal.vo.normal.ResponseBodyVO;
import com.images_base.backend.util.annotation.ResponseBodyAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/20
 */
@RestControllerAdvice(annotations = ResponseBodyAnnotation.class)
public class ResponseBodyHandler implements ResponseBodyAdvice<Object> {

    private static final Logger logger = LoggerFactory.getLogger(ResponseBodyHandler.class);

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        logger.debug("获取响应体：{}", body);
        if (body instanceof byte[] || body instanceof ResponseBodyVO) {
            return body;
        }
        return new ResponseBodyVO(body);
    }
}
