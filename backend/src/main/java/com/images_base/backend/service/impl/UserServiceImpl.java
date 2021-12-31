package com.images_base.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.images_base.backend.dao.UserMapper;
import com.images_base.backend.modal.entity.UserEntity;
import com.images_base.backend.modal.vo.user.UserVO;
import com.images_base.backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Description:
 * @Author: zhengzhihao
 * @Date: 2021/12/19 21:52
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<UserEntity> getUsers() {
        return this.getBaseMapper().getUsers();
    }

    @Override
    public UserEntity getUserInfo(Long id) {
        logger.info("Query user id: {}", id);
        return this.getBaseMapper().getUserInfo(id);
    }

    @Override
    public UserVO getUserRolesInfo(String name) {
        return this.getBaseMapper().getUserRolesInfo(name);
    }
}
