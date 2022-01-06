package com.images_base.backend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.images_base.backend.modal.entity.FeatEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/6
 */
@Mapper
public interface FeatMapper extends BaseMapper<FeatEntity> {

    /**
     * 获取角色下面所有的功能
     *
     * @param roleId
     * @return
     */
    List<FeatEntity> getFeatByRoleId(@Param("roleId") Long roleId);
}
