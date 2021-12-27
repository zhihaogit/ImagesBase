package com.images_base.backend.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/27
 */
@Component
@ConfigurationProperties(prefix = "images-base-properties.jwt")
public class JwtProperties {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
