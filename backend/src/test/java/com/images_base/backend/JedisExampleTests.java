package com.images_base.backend;

import com.images_base.backend.config.properties.JedisProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

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
}
