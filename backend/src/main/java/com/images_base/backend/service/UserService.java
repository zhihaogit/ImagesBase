package com.images_base.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.images_base.backend.modal.entity.JwtUser;
import com.images_base.backend.modal.entity.UserEntity;
import com.images_base.backend.modal.vo.user.UserBriefVO;
import com.images_base.backend.modal.vo.user.UserFeatVO;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserService
 * @Description:
 * @Author: zhengzhihao
 * @Date: 2021/12/19 21:51
 */
public interface UserService extends IService<UserEntity> {

    /**
     * 用户注册
     *
     * @param userToAdd UserEntity
     * @return UserEntity
     */
    UserEntity register(UserEntity userToAdd);

    /**
     * 用户登录
     *
     * @param user JwtUser
     * @return Map<String, String>
     */
    Map<String, String> login(JwtUser user);

    /**
     * 获取所有用户的信息
     *
     * @return List<UserBriefVO>
     */
    List<UserBriefVO> getUsers();

    /**
     * 获取单个用户信息
     *
     * @param id - Long
     * @return UserBriefVO
     */
    UserBriefVO getUserInfo(Long id);

    /**
     * 获取单个用户所有的功能权限
     *
     * @param name - String
     * @return UserFeatVO
     */
    UserFeatVO getUserFeatsInfo(String name);

    /**
     * 获取单个用户所有的功能权限
     *
     * @param id - Long
     * @return UserFeatVO
     */
    UserFeatVO getUserFeatsInfo(Long id);
}
