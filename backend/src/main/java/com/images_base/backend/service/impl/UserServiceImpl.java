package com.images_base.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.images_base.backend.dao.UserMapper;
import com.images_base.backend.modal.entity.JwtUser;
import com.images_base.backend.modal.entity.UserEntity;
import com.images_base.backend.modal.vo.user.UserBriefVO;
import com.images_base.backend.modal.vo.user.UserFeatVO;
import com.images_base.backend.service.UserService;
import com.images_base.backend.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserServiceImpl
 * @Description:
 * @Author: zhengzhihao
 * @Date: 2021/12/19 21:52
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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
    public List<UserBriefVO> getUsers() {
        return this.getBaseMapper().getUsers();
    }

    @Override
    public UserBriefVO getUserInfo(Long id) {
        logger.info("Query user id: {}", id);
        return this.getBaseMapper().getUserInfo(id);
    }

    @Override
    public UserFeatVO getUserFeatsInfo(String name) {
        return this.getBaseMapper().getUserFeatsInfo(null, name);
    }

    @Override
    public UserFeatVO getUserFeatsInfo(Long id) {
        return this.getBaseMapper().getUserFeatsInfo(id, null);
    }
}
