package com.images_base.backend.controller;

import com.images_base.backend.modal.entity.UserEntity;
import com.images_base.backend.service.UserService;
import com.images_base.backend.util.annotation.ResponseBodyAnnotation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
     * 获取所有用户的信息
     *
     * @return List<UserEntity>
     */
    @GetMapping
    @ApiOperation(value = "获取所有用户的信息")
    public List<UserEntity> getUsers() {
        return userService.getUsers();
    }

    /**
     * 获取单个用户信息
     *
     * @param id - Integer
     * @return UserEntity
     */
    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "获取单个用户信息")
    public UserEntity getUserInfo(@PathVariable Integer id) {
        return userService.getUserInfo(id);
    }

}
