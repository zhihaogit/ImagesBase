package com.images_base.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.images_base.backend.modal.entity.UserEntity;

import java.util.List;

/**
 * @ClassName: UserService
 * @Description:
 * @Author: zhengzhihao
 * @Date: 2021/12/19 21:51
 */
public interface UserService extends IService<UserEntity> {
    /**
     * 获取所有用户的信息
     *
     * @return List<UserEntity>
     */
    List<UserEntity> getUsers();

    /**
     * 获取单个用户信息
     *
     * @param id - Integer
     * @return UserEntity
     */
    UserEntity getUserInfo(Integer id);
}
