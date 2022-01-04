package com.images_base.backend.controller;

import com.images_base.backend.security.entity.JwtUser;
import com.images_base.backend.security.service.AuthService;
import com.images_base.backend.util.annotation.ResponseBodyAnnotation;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/29
 */
@Api(value = "auth", tags = "认证相关接口")
@ResponseBodyAnnotation
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Map<String, String> userLogin(@RequestBody JwtUser user) {
        return authService.login(user);
    }
}
