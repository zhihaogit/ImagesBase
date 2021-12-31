package com.images_base.backend.security.service.impl;

import com.images_base.backend.modal.entity.UserEntity;
import com.images_base.backend.security.service.AuthService;
import com.images_base.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/29
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;

    @Override
    public UserEntity register(UserEntity userToAdd) {
        return null;
    }

    @Override
    public String login(String username, String password) {
        return null;
    }

    @Override
    public String refresh(String oldToken) {
        return null;
    }
}
