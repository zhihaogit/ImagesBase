package com.images_base.backend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.images_base.backend.modal.entity.UserRoleAssociation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/7
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRoleAssociation> {
}
