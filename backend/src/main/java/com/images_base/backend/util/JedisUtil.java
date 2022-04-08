package com.images_base.backend.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/3/23
 */
@Component
public class JedisUtil {

    public static final String USER_TOKEN_KEY = "userId::72h::";

    public static final String IMAGE_KEY = "pictureId::4h::";

    public static final long SECONDS_72H = 259200L;

    public static final long SECONDS_4H = 14400L;

    private static final Logger logger = LoggerFactory.getLogger(JedisUtil.class);

    public static String url;

    public static int maxTotal;

    public static int maxWait;

    public static int maxIdle;

    public static int minIdle;

    private static JedisPool pool = null;

    private static JedisPool createJedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        // 最大连接数
        jedisPoolConfig.setMaxTotal(JedisUtil.maxTotal);
        // 当池内没有可用连接时，最大等待时间
        jedisPoolConfig.setMaxWait(Duration.ofMillis(JedisUtil.maxWait));
        // 最大空闲连接数
        jedisPoolConfig.setMaxIdle(JedisUtil.maxIdle);
        // 最小空闲连接数
        jedisPoolConfig.setMinIdle(JedisUtil.minIdle);

        return new JedisPool(
                jedisPoolConfig,
                JedisUtil.url
        );
    }

    /**
     * 返回实例
     *
     * @return
     */
    public static Jedis getRedis() {
        Jedis jedis = null;
        try {
            if (null == pool) {
                pool = createJedisPool();
            }
            jedis = pool.getResource();
        } catch (Exception e) {
            if (null != jedis) {
                pool.returnBrokenResource(jedis);
            }
            logger.error(e.getMessage(), e);
            throw e;
        }
        return jedis;
    }

    @Value("${images-base-properties.jedis-properties.url}")
    public void setUrl(String url) {
        JedisUtil.url = url;
    }
    
    @Value("${images-base-properties.jedis-properties.max-total}")
    public void setMaxTotal(int maxTotal) {
        JedisUtil.maxTotal = maxTotal;
    }

    @Value("${images-base-properties.jedis-properties.max-wait}")
    public void setMaxWait(int maxWait) {
        JedisUtil.maxWait = maxWait;
    }

    @Value("${images-base-properties.jedis-properties.max-idle}")
    public void setMaxIdle(int maxIdle) {
        JedisUtil.maxIdle = maxIdle;
    }

    @Value("${images-base-properties.jedis-properties.min-idle}")
    public void setMinIdle(int minIdle) {
        JedisUtil.minIdle = minIdle;
    }
}
