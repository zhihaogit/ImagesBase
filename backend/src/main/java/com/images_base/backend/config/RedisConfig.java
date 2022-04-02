package com.images_base.backend.config;

import com.images_base.backend.config.properties.JedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/3/27
 */
@Configuration
public class RedisConfig {

    @Autowired
    JedisProperties jedisProperties;

    @Bean
    JedisPool redisPoolFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大连接数
        jedisPoolConfig.setMaxTotal(jedisProperties.getMaxTotal());
        // 当池内没有可用连接时，最大等待时间
        // jedisPoolConfig.setMaxWaitMillis(jedisProperties.getMaxWait());
        // 最大空闲连接数
        jedisPoolConfig.setMaxIdle(jedisProperties.getMaxIdle());
        // 最小空闲连接数
        jedisPoolConfig.setMinIdle(jedisProperties.getMinIdle());

        return new JedisPool(jedisPoolConfig,
                jedisProperties.getHost(),
                jedisProperties.getPort(),
                jedisProperties.getUser(),
                jedisProperties.getPassword());
    }

}
