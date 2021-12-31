package com.images_base.backend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.images_base.backend.modal.entity.UserEntity;
import com.images_base.backend.modal.vo.user.UserVO;
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
     * @return List<UserEntity>
     */
    List<UserEntity> getUsers();

    /**
     * 获取单个用户信息
     *
     * @param id - Long
     * @return UserEntity
     */
    UserEntity getUserInfo(@Param("id") Long id);

    /**
     * 获取单个用户及角色信息
     *
     * @param name - String
     * @return UserVO
     */
    UserVO getUserRolesInfo(@Param("name") String name);

}
