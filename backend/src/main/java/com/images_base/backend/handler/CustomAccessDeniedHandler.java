package com.images_base.backend.handler;

import com.google.gson.Gson;
import com.images_base.backend.modal.vo.normal.ResponseBodyVO;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/6
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        ResponseBodyVO responseBodyVO = new ResponseBodyVO(e.getMessage(), null);
        Gson gson = new Gson();
        httpServletResponse.getWriter().write(gson.toJson(responseBodyVO));
    }
}
