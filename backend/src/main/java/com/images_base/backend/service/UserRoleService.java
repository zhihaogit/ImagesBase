package com.images_base.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.images_base.backend.modal.entity.UserRoleAssociation;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/7
 */
public interface UserRoleService extends IService<UserRoleAssociation> {

    /**
     * 关联用户和角色
     *
     * @param userId - long
     * @param roleId - long
     * @return boolean
     */
    boolean createUserRoleAssociation(long userId, long roleId);
}
