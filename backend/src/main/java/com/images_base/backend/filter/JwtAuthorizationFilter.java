package com.images_base.backend.filter;

import com.images_base.backend.exception.UnauthorizedException;
import com.images_base.backend.modal.entity.JwtUser;
import com.images_base.backend.modal.vo.user.UserFeatVO;
import com.images_base.backend.service.UserService;
import com.images_base.backend.util.JwtUserFactory;
import com.images_base.backend.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/28
 */
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");
        if (StringUtils.hasText(token)) {
            try {
                Claims claims = JwtUtil.tokenParser(token);
                Long userId = claims.get("userId", Long.class);
                UserFeatVO user = userService.getUserFeatsInfo(userId);
                JwtUser jwtUser = JwtUserFactory.create(user);
                SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userId, null, jwtUser.getAuthorities()));
            } catch (Exception e) {
                throw new UnauthorizedException("token解析失败");
            }
        }
        // 放行请求
        filterChain.doFilter(request, response);
    }
}
