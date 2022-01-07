package com.images_base.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.images_base.backend.dao.UserRoleMapper;
import com.images_base.backend.modal.entity.UserRoleAssociation;
import com.images_base.backend.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/7
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRoleAssociation> implements UserRoleService {
    @Override
    public boolean createUserRoleAssociation(long userId, long roleId) {
        UserRoleAssociation association = new UserRoleAssociation();
        association.setRoleId(roleId);
        association.setUserId(userId);
        return this.save(association);
    }
}
