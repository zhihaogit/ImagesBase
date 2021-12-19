package com.images_base.backend.controller;

import com.images_base.backend.modal.entity.UserEntity;
import com.images_base.backend.service.UserService;
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
@RestController
@RequestMapping(path = "/user")
public class UserContoller {

    @Autowired
    private UserService userService;

    /**
     * 获取所有用户的信息
     *
     * @return List<UserEntity>
     */
    @GetMapping
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
    public UserEntity getUserInfo(@PathVariable Integer id) {
        return userService.getUserInfo(id);
    }

}