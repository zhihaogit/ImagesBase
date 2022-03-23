package com.images_base.backend.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/3/23
 */
@Component
@ConfigurationProperties(prefix = "images-base-properties.jedis-properties")
public class JedisProperties {

    private String host;

    private int port;

    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
