package com.images_base.backend.security.service;

import com.images_base.backend.modal.entity.UserEntity;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/29
 */
public interface AuthService {

    UserEntity register(UserEntity userToAdd);

    String login(String username, String password);

    String refresh(String oldToken);
}
