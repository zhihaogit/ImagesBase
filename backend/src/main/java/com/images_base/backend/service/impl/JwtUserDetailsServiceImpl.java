package com.images_base.backend.service.impl;

import com.images_base.backend.modal.vo.user.UserFeatVO;
import com.images_base.backend.service.UserService;
import com.images_base.backend.util.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/29
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserFeatVO user = userService.getUserFeatsInfo(s);

        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", s));
        } else if (user.getFeats().isEmpty()) {
            throw new UsernameNotFoundException(String.format("Username '%s' is no auth.", s));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
