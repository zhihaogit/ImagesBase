package com.images_base.backend.util;

import com.images_base.backend.config.properties.ImagesBaseProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/28
 */
@Component
public class JwtUtil {

    private static ImagesBaseProperties imagesBaseProperties;

    /**
     * 解析 token
     *
     * @param token - String
     * @return Claims
     */
    public static Claims tokenParser(@NonNull String token) {
        SecretKey key = secretKeyBuilder();
        Claims claims;
        try {
            claims = Jwts
                    .parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 创建 jwt
     *
     * @param userId - Integer
     * @return String
     */
    public static String tokenBuilder(Long userId) {
        long nowTimeMills = System.currentTimeMillis();
        Date nowDate = new Date(nowTimeMills);
        return Jwts.builder()
                .setClaims(claimsBuilder(userId))
                .setId(imagesBaseProperties.getJwtProperties().getId())
                .setIssuedAt(nowDate)
                .signWith(secretKeyBuilder())
                .setExpiration(expireMillisBuilder(nowTimeMills))
                .compact();
    }

    /**
     * 生成秘钥
     *
     * @return SecretKey
     */
    private static SecretKey secretKeyBuilder() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(imagesBaseProperties.getJwtProperties().getSecret()));
    }

    /**
     * 计算 token过期时间
     *
     * @param nowTimeMills - long
     * @return Date
     */
    private static Date expireMillisBuilder(long nowTimeMills) {
        TimeUnit timeUnit = TimeUnit.valueOf(imagesBaseProperties.getJwtProperties().getTimeUnit());
        long expireInMilliTime = timeUnit.toMillis(imagesBaseProperties.getJwtProperties().getTokenExpiredTime());
        long expireTimeMillis = nowTimeMills + expireInMilliTime;
        return new Date(expireTimeMillis);
    }

    /**
     * 生成 payload
     *
     * @param userId - Long
     * @return Map<String, Long>
     */
    private static Map<String, Long> claimsBuilder(Long userId) {
        Map<String, Long> map = new HashMap<>(1);
        map.put("userId", userId);
        return map;
    }

    @Autowired
    public void setImagesBaseProperties(ImagesBaseProperties imagesBaseProperties) {
        JwtUtil.imagesBaseProperties = imagesBaseProperties;
    }
}
