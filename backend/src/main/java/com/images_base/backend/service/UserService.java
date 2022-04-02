package com.images_base.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.images_base.backend.modal.dto.UserLoginDTO;
import com.images_base.backend.modal.dto.UserRegisterDTO;
import com.images_base.backend.modal.entity.UserEntity;
import com.images_base.backend.modal.vo.normal.ResponseBodyVO;
import com.images_base.backend.modal.vo.user.UserBriefVO;
import com.images_base.backend.modal.vo.user.UserFeatVO;
import com.images_base.backend.modal.vo.user.UserInfoVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserService
 * @Description:
 * @Author: zhengzhihao
 * @Date: 2021/12/19 21:51
 */
public interface UserService extends IService<UserEntity> {

    /**
     * 用户注册
     *
     * @param user UserRegisterDTO
     * @return ResponseBodyVO
     */
    @Transactional(rollbackFor = Exception.class)
    ResponseBodyVO register(UserRegisterDTO user);

    /**
     * 用户登录
     *
     * @param user LoginUserDTO
     * @return Map<String, String>
     */
    Map<String, String> login(UserLoginDTO user);

    /**
     * 获取所有用户的信息
     *
     * @return List<UserBriefVO>
     */
    List<UserBriefVO> getUsers();

    /**
     * 获取单个用户信息及权限信息
     *
     * @return UserInfoVO
     */
    UserInfoVO getUserInfo();

    /**
     * 获取单个用户所有的功能权限
     *
     * @param name - String
     * @return UserFeatVO
     */
    UserFeatVO getUserFeatsInfo(String name);

    /**
     * 获取单个用户所有的功能权限
     *
     * @param id - Long
     * @return UserFeatVO
     */
    UserFeatVO getUserFeatsInfo(Long id);

    /**
     * 用户登出接口
     *
     * @return
     */
    boolean logout();
}
