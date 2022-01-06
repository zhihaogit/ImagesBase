package com.images_base.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.images_base.backend.dao.FeatMapper;
import com.images_base.backend.modal.entity.FeatEntity;
import com.images_base.backend.service.FeatService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/6
 */
@Service
public class FeatServiceImpl extends ServiceImpl<FeatMapper, FeatEntity> implements FeatService {
    @Override
    public List<FeatEntity> getFeatByRoleId(Long roleId) {
        return this.getBaseMapper().getFeatByRoleId(roleId);
    }
}
