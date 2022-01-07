package com.images_base.backend.controller;

import com.images_base.backend.modal.dto.UserLoginDTO;
import com.images_base.backend.modal.dto.UserRegisterDTO;
import com.images_base.backend.modal.vo.normal.ResponseBodyVO;
import com.images_base.backend.modal.vo.user.UserBriefVO;
import com.images_base.backend.service.UserService;
import com.images_base.backend.util.annotation.ResponseBodyAnnotation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
     * @param user - UserRegisterDTO
     * @return ResponseBodyVO
     */
    @PostMapping("/register")
    @ApiOperation(value = "用户注册接口")
    public ResponseBodyVO userRegister(@RequestBody UserRegisterDTO user) {
        return userService.register(user);
    }

    /**
     * 用户登录接口
     *
     * @param user - LoginUserDTO
     * @return Map<String, String>
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录接口")
    public Map<String, String> userLogin(@Validated @RequestBody UserLoginDTO user) {
        return userService.login(user);
    }

    /**
     * 获取所有用户的信息
     *
     * @return List<UserEntity>
     */
    @GetMapping
    @ApiOperation(value = "获取所有用户的信息")
    @PreAuthorize("hasAnyAuthority('user:browse:*')")
    public List<UserBriefVO> getUsers() {
        return userService.getUsers();
    }

    /**
     * 获取单个用户信息
     *
     * @param id - Long
     * @return UserEntity
     */
    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "获取单个用户信息")
    @PreAuthorize("hasAnyAuthority('user:browse:*')")
    public UserBriefVO getUserInfo(@PathVariable Long id) {
        return userService.getUserInfo(id);
    }

}
