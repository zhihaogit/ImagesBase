package com.images_base.backend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.images_base.backend.modal.entity.UserEntity;
import com.images_base.backend.modal.vo.user.UserBriefVO;
import com.images_base.backend.modal.vo.user.UserFeatVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: UserMapper
 * @Description:
 * @Author: zhengzhihao
 * @Date: 2021/12/19 21:38
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    /**
     * 获取所有用户的信息
     *
     * @return List<UserBriefVO>
     */
    List<UserBriefVO> getUsers();

    /**
     * 获取单个用户信息
     *
     * @param id - Long
     * @return UserBriefVO
     */
    UserBriefVO getUserInfo(@Param("id") Long id);

    /**
     * 获取单个用户所有的功能权限
     *
     * @param id
     * @param name
     * @return
     */
    UserFeatVO getUserFeatsInfo(@Param("id") Long id, @Param("name") String name);
}
