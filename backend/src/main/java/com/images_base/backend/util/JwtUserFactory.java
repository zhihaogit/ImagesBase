package com.images_base.backend.util;

import com.images_base.backend.modal.entity.FeatEntity;
import com.images_base.backend.modal.entity.JwtUser;
import com.images_base.backend.modal.vo.user.UserFeatVO;
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

    public static JwtUser create(UserFeatVO user) {
        return new JwtUser(
                user.getId(),
                user.getName(),
                user.getPassword(),
                user.getEmail(),
                mapToGrantedAuthorities(user.getFeats())
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<FeatEntity> feats) {
        return feats.stream()
                .map(feat -> new SimpleGrantedAuthority(feat.getName()))
                .collect(Collectors.toList());
    }
}
