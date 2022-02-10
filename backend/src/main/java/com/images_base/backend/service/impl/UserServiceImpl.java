package com.images_base.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.images_base.backend.dao.UserMapper;
import com.images_base.backend.exception.BadRequestException;
import com.images_base.backend.modal.dto.UserLoginDTO;
import com.images_base.backend.modal.dto.UserRegisterDTO;
import com.images_base.backend.modal.entity.FeatEntity;
import com.images_base.backend.modal.entity.JwtUser;
import com.images_base.backend.modal.entity.UserEntity;
import com.images_base.backend.modal.vo.normal.ResponseBodyVO;
import com.images_base.backend.modal.vo.user.UserBriefVO;
import com.images_base.backend.modal.vo.user.UserFeatVO;
import com.images_base.backend.modal.vo.user.UserInfoVO;
import com.images_base.backend.service.RoleService;
import com.images_base.backend.service.UserRoleService;
import com.images_base.backend.service.UserService;
import com.images_base.backend.util.CheckPasswordUtil;
import com.images_base.backend.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @ClassName: UserServiceImpl
 * @Description:
 * @Author: zhengzhihao
 * @Date: 2021/12/19 21:52
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public ResponseBodyVO register(UserRegisterDTO user) {
        String password = user.getPassword();
        if (!CheckPasswordUtil.checkPassword(password)) {
            throw new BadRequestException("建议密码长度为8到20位,包含字母和数字，字母区分大小写");
        }
        String name = user.getUsername();
        String email = user.getEmail();
        logger.info("register request username: {}, password: {}, email: {}, age: {}", user.getUsername(), user.getPassword(), user.getEmail(), user.getAge());
        UserEntity one = this.getOne(new QueryWrapper<UserEntity>().eq(UserEntity.NAME_FIELD, name).or().eq(UserEntity.EMAIL_FIELD, email));
        if (!Objects.isNull(one)) {
            throw new BadRequestException("存在同名或同邮箱账户");
        }

        LocalDateTime now = LocalDateTime.now();
        UserEntity newUser = new UserEntity();
        BeanUtils.copyProperties(user, newUser);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setCreatedAt(now);
        newUser.setUpdatedAt(now);
        newUser.setDelete(Boolean.FALSE);
        boolean save = this.save(newUser);
        if (!save) {
            throw new BadRequestException("新建用户失败");
        }

        long userId = newUser.getId();
        long roleId = roleService.getVisitorRoleId();
        boolean isSuccess = userRoleService.createUserRoleAssociation(userId, roleId);
        if (!isSuccess) {
            throw new BadRequestException("注册失败");
        }
        return new ResponseBodyVO("注册成功", null);
    }

    @Override
    public Map<String, String> login(UserLoginDTO user) {
        logger.info("login request username: {}", user.getUsername());
        UsernamePasswordAuthenticationToken userInfo = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(userInfo);
        JwtUser principal = (JwtUser) authenticate.getPrincipal();
        Long userId = principal.getId();
        String token = JwtUtil.tokenBuilder(userId);
        logger.info("login request user-id: {}, token: {}", userId, token);
        Map<String, String> tokenMap = new HashMap<>(1);
        tokenMap.put("token", token);
        return tokenMap;
    }

    @Override
    public List<UserBriefVO> getUsers() {
        return this.getBaseMapper().getUsers();
    }

    @Override
    public UserInfoVO getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long id = (Long) authentication.getPrincipal();
        logger.info("Query user id: {}", id);
        UserFeatVO userFeatsInfo = this.getUserFeatsInfo(id);
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(userFeatsInfo, userInfoVO);
        userInfoVO.setFeats(userFeatsInfo.getFeats().stream().map(FeatEntity::getName).collect(Collectors.toList()));
        return userInfoVO;
    }

    @Override
    public UserFeatVO getUserFeatsInfo(String name) {
        return this.getBaseMapper().getUserFeatsInfo(null, name);
    }

    @Override
    public UserFeatVO getUserFeatsInfo(Long id) {
        return this.getBaseMapper().getUserFeatsInfo(id, null);
    }
}
