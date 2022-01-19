package com.images_base.backend;

import com.google.gson.Gson;
import com.images_base.backend.modal.entity.FeatEntity;
import com.images_base.backend.modal.vo.user.UserFeatVO;
import com.images_base.backend.service.FeatService;
import com.images_base.backend.service.UserService;
import com.images_base.backend.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class BackendApplicationTests {

    static final String username = "Jone";
    static final String password = "12345";

    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    FeatService featService;

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
        String encode = passwordEncoder.encode(password);
        System.out.println(encode);
    }

    @Test
    void generateBase64Key() {
        String encode = Base64.getEncoder().encodeToString("images_base_backend_server_v1.0_salt_72_hours_expires".getBytes(StandardCharsets.UTF_8));
        System.out.println(encode);
    }

    @Test
    void contextLoads() {
    }

    @Test
    void getFeatByRole() {
        List<FeatEntity> l = featService.getFeatByRoleId(1L);
        System.out.println(l.size());
    }

    @Test
    void getUserFeat() {
        UserFeatVO userFeatsInfo = userService.getUserFeatsInfo(username);
        System.out.println(userFeatsInfo.getId());
        System.out.println(userFeatsInfo.getFeats().size());
    }

    @Test
    void generateBase64UsernamePwd() {
        Gson gson = new Gson();
        HashMap<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        String s = gson.toJson(map);
        System.out.println(s);
        String s_base64 = Base64.getEncoder().encodeToString(s.getBytes(StandardCharsets.UTF_8));
        System.out.println(s_base64);
    }


}
