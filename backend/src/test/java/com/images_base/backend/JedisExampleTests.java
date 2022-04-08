package com.images_base.backend;

import com.images_base.backend.util.JedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/3/23
 */
@SpringBootTest
class JedisExampleTests {

    @Test
    void testJedisUtils() {
        Jedis redis = JedisUtil.getRedis();
        String name_pool_test = redis.get("name_pool_test");
        System.out.println(name_pool_test);
        redis.close();
    }

}
