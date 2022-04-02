package com.images_base.backend.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/3/23
 */
@Component
public class JedisUtil {

    @Autowired
    JedisPool jedisPool;

    /**
     * 返回实例
     *
     * @return
     */
    public Jedis getRedis() {
        return jedisPool.getResource();
    }

    /**
     * 校验用户是否有效
     * '
     *
     * @param userId
     * @return
     */
    public boolean checkUserValid(long userId) {
        Jedis redis = this.getRedis();
        return redis.exists("userId:72h:" + userId);
    }

    /**
     * 在 redis中重新设置 user
     *
     * @param userId
     * @param token
     */
    public void setUser(long userId, String token) {
        Jedis redis = this.getRedis();
        if (this.checkUserValid(userId)) {
            redis.del("userId:72h:" + userId);
        }
        redis.setex("userId:72h:" + userId, 72 * 24 * 60 * 60, token);
    }

    /**
     * redis中踢出用户
     *
     * @param userId
     */
    public void delUser(long userId) {
        Jedis redis = this.getRedis();
        redis.del("userId:72h:" + userId);
    }
}
