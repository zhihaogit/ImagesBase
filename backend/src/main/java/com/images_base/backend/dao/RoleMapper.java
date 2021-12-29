package com.images_base.backend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.images_base.backend.modal.entity.RoleEntity;
import com.images_base.backend.modal.vo.role.RoleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/29
 */
@Mapper
public interface RoleMapper extends BaseMapper<RoleEntity> {

    /**
     * 获取用户下的所有角色
     *
     * @param userId - Long
     * @return List<RoleVO>
     */
    List<RoleVO> getRolesByUseId(@Param("userId") Long userId);
}
