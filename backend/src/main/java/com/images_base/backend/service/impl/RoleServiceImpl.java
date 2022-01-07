package com.images_base.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.images_base.backend.dao.RoleMapper;
import com.images_base.backend.modal.entity.RoleEntity;
import com.images_base.backend.modal.vo.role.RoleVO;
import com.images_base.backend.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/29
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {

    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Override
    public List<RoleVO> getRolesByUseId(Long userId) {
        logger.info("Query role list by user id: {}", userId);
        return this.getBaseMapper().getRolesByUseId(userId);
    }

    @Override
    public Long getVisitorRoleId() {
        return this.getBaseMapper().getVisitorRoleId();
    }
}
