package com.images_base.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.images_base.backend.modal.entity.RoleEntity;
import com.images_base.backend.modal.vo.role.RoleVO;

import java.util.List;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/29
 */
public interface RoleService extends IService<RoleEntity> {

    /**
     * 获取用户下的所有角色
     *
     * @param userId - Long
     * @return List<RoleVO>
     */
    List<RoleVO> getRolesByUseId(Long userId);
}
