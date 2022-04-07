package com.images_base.backend;

import com.images_base.backend.config.properties.JedisProperties;
import com.images_base.backend.util.JedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/3/23
 */
@SpringBootTest
class JedisExampleTests {

    @Autowired
    JedisProperties jedisProperties;

    @Test
    void testJedisConnect() {
        Jedis jedis = new Jedis(jedisProperties.getHost(), jedisProperties.getPort());
        jedis.auth(jedisProperties.getPassword());

        jedis.set("name_test1", "demo");
        String nameTest = jedis.get("name_test");
        System.out.println(nameTest);
        jedis.close();
    }

    @Test
    void testJedisPoolConnect() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,
                jedisProperties.getHost(),
                jedisProperties.getPort(),
                jedisProperties.getUser(),
                jedisProperties.getPassword());

        Jedis resource = jedisPool.getResource();

        resource.set("name_pool_test", "pool");

        String name_pool_test = resource.get("name_pool_test");
        System.out.println(name_pool_test);

        resource.close();
    }

    @Test
    void testJedisUtils() {
        Jedis redis = JedisUtil.getRedis();
        String name_pool_test = redis.get("name_pool_test");
        System.out.println(name_pool_test);
        redis.close();
    }

}
