package com.images_base.backend.controller;

import com.google.gson.Gson;
import com.images_base.backend.modal.dto.UserLoginDTO;
import com.images_base.backend.modal.dto.UserRegisterDTO;
import com.images_base.backend.modal.vo.normal.ResponseBodyVO;
import com.images_base.backend.modal.vo.user.UserBriefVO;
import com.images_base.backend.modal.vo.user.UserInfoVO;
import com.images_base.backend.service.UserService;
import com.images_base.backend.util.annotation.ResponseBodyAnnotation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserContoller
 * @Description:
 * @Author: zhengzhihao
 * @Date: 2021/12/19 21:56
 */
@Api(value = "user", tags = "用户相关")
@RestController
@ResponseBodyAnnotation
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册接口
     *
     * @param param - String
     * @return ResponseBodyVO
     */
    @PostMapping("/register")
    @ApiOperation(value = "用户注册接口")
    public ResponseBodyVO userRegister(@RequestBody @Validated @ApiParam("Base64编码后的请求体") String param) {
        String s = new String(Base64.getDecoder().decode(param), StandardCharsets.UTF_8);
        UserRegisterDTO user = new Gson().fromJson(s, UserRegisterDTO.class);
        return userService.register(user);
    }

    /**
     * 用户登录接口
     *
     * @param param - String
     * @return Map<String, String>
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录接口")
    public Map<String, String> userLogin(@RequestBody @Validated @ApiParam("Base64编码后的请求体") String param) {
        byte[] bytes = Base64.getDecoder().decode(param);
        String s = new String(bytes, StandardCharsets.UTF_8);
        Gson gson = new Gson();
        UserLoginDTO user = gson.fromJson(s, UserLoginDTO.class);
        return userService.login(user);
    }

    /**
     * 获取所有用户的信息
     *
     * @return List<UserEntity>
     */
    @GetMapping("/list")
    @ApiOperation(value = "获取所有用户的信息")
    @PreAuthorize("hasAnyAuthority('user:browse:*')")
    public List<UserBriefVO> getUsers() {
        return userService.getUsers();
    }

    /**
     * 获取单个用户信息及权限信息
     *
     * @return UserInfoVO
     */
    @GetMapping("/info")
    @ApiOperation(value = "获取单个用户信息及权限信息")
    public UserInfoVO getUserInfo() {
        return userService.getUserInfo();
    }

}
