package com.images_base.backend.security.service.impl;

import com.images_base.backend.modal.entity.UserEntity;
import com.images_base.backend.security.entity.JwtUser;
import com.images_base.backend.security.service.AuthService;
import com.images_base.backend.security.util.JwtUtil;
import com.images_base.backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/29
 */
@Service
public class AuthServiceImpl implements AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserEntity register(UserEntity userToAdd) {
        return null;
    }

    @Override
    public Map<String, String> login(JwtUser user) {
        logger.info("login request username: {}", user.getUsername());
        UsernamePasswordAuthenticationToken userInfo = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(userInfo);
        JwtUser principal = (JwtUser) authenticate.getPrincipal();
        Long userId = principal.getId();
        String token = JwtUtil.tokenBuilder(userId);
        logger.info("login request user-id: {}, token: {}", userId, token);
        Map<String, String> tokenMap = new HashMap<>(1);
        tokenMap.put("token", token);
        return tokenMap;
    }

    @Override
    public Map<String, String> refresh(String oldToken) {
        return null;
    }
}
