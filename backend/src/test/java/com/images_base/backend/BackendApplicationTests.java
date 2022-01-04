package com.images_base.backend;

import com.images_base.backend.modal.vo.user.UserVO;
import com.images_base.backend.security.util.JwtUtil;
import com.images_base.backend.service.UserService;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@SpringBootTest
class BackendApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void generateJwtToken() {
        String s = JwtUtil.tokenBuilder(1L);
        System.out.println(s);
    }

    @Test
    void parseJwtToken() {
        Claims claims = JwtUtil.tokenParser("eyJhbGciOiJIUzM4NCJ9.eyJ1c2VySWQiOjEsImp0aSI6ImltYWdlc19iYXNlIiwiaWF0IjoxNjQxMjg2NTI2LCJleHAiOjE2NDE1NDU3MjZ9.iLiavVDiSPLnw9nIl5dVlb-wLLywp66ti25_elbBMPpqXfZa6vlfka5gup4Zwi5M");
        System.out.println(claims.get("userId", Long.class));
    }

    @Test
    void generateKeyword() {
        String encode = passwordEncoder.encode("12345");
        System.out.println(encode);
    }

    @Test
    void generateBase64Key() {
        String encode = Base64.getEncoder().encodeToString("images_base_backend_server_v1.0_salt_72_hours_expires".getBytes(StandardCharsets.UTF_8));
        System.out.println(encode);
    }

    @Test
    void contextLoads() {
        UserVO jone = userService.getUserRolesInfo("Jone");
        System.out.println(jone.getId());

    }

}
