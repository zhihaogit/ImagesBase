package com.images_base.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.images_base.backend.modal.entity.UserEntity;
import com.images_base.backend.modal.vo.user.UserVO;

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
     * @param id - Long
     * @return UserEntity
     */
    UserEntity getUserInfo(Long id);

    /**
     * 获取单个用户及角色信息
     *
     * @param name - String
     * @return UserVO
     */
    UserVO getUserRolesInfo(String name);
}
