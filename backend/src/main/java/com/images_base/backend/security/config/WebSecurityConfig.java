package com.images_base.backend.security.config;

import com.images_base.backend.config.properties.ImagesBaseProperties;
import com.images_base.backend.security.filter.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/28
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ImagesBaseProperties imagesBaseProperties;

    /**
     * 使用 Spring Security推荐的加密方式进行登录密码的加密
     *
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthorizationFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthorizationFilter();
    }

    /**
     * 定义安全策略，设置 http访问规则
     *
     * @param http - HttpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] whiteList = imagesBaseProperties.getJwtProperties().getExcludeUrlPatterns().toArray(new String[0]);
        http
                // 不通过 session获取
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 禁用 csrf控制
                .csrf().disable()
                .authorizeRequests(
                        authorize -> authorize.mvcMatchers(whiteList)
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                );
    }
}
