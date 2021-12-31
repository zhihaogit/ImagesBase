package com.images_base.backend.security.controller;

import com.images_base.backend.security.service.AuthService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/29
 */
@Api(value = "auth", tags = "认证相关接口")
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;
}
