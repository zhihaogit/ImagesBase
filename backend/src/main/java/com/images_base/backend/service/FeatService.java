package com.images_base.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.images_base.backend.modal.entity.FeatEntity;

import java.util.List;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/6
 */
public interface FeatService extends IService<FeatEntity> {

    /**
     * 获取角色下面所有的功能
     *
     * @param roleId
     * @return
     */
    List<FeatEntity> getFeatByRoleId(Long roleId);
}
