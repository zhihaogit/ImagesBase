package com.images_base.backend.security.util;

import com.images_base.backend.modal.vo.role.RoleVO;
import com.images_base.backend.modal.vo.user.UserVO;
import com.images_base.backend.security.entity.JwtUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/29
 */
public class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(UserVO user) {
        return new JwtUser(
                user.getId(),
                user.getName(),
                user.getPassword(),
                user.getEmail(),
                mapToGrantedAuthorities(user.getRoles())
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<RoleVO> roles) {
        return roles.stream()
                .map(RoleVO::getRoleName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
