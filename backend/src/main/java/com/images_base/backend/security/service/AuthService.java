package com.images_base.backend.security.service;

import com.images_base.backend.modal.entity.UserEntity;
import com.images_base.backend.security.entity.JwtUser;

import java.util.Map;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/29
 */
public interface AuthService {

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
     * token刷新功能
     *
     * @param oldToken - String
     * @return Map<String, String>
     */
    Map<String, String> refresh(String oldToken);
}
