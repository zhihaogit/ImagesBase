package com.images_base.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.images_base.backend.dao.UserMapper;
import com.images_base.backend.modal.entity.UserEntity;
import com.images_base.backend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Description:
 * @Author: zhengzhihao
 * @Date: 2021/12/19 21:52
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
    @Override
    public List<UserEntity> getUsers() {
        return this.getBaseMapper().getUsers();
    }

    @Override
    public UserEntity getUserInfo(Integer id) {
        log.info("Query user id: {}", id);
        return this.getBaseMapper().getUserInfo(id);
    }
}
