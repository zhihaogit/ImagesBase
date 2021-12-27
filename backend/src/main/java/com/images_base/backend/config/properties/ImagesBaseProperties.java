package com.images_base.backend.config.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/27
 */
@Component
@ConfigurationProperties(prefix = "images-base-properties")
public class ImagesBaseProperties {

    @Autowired
    @NestedConfigurationProperty
    private SwaggerProperties swaggerProperties;

    @Autowired
    @NestedConfigurationProperty
    private JwtProperties jwtProperties;

    public SwaggerProperties getSwaggerProperties() {
        return swaggerProperties;
    }

    public void setSwaggerProperties(SwaggerProperties swaggerProperties) {
        this.swaggerProperties = swaggerProperties;
    }

    public JwtProperties getJwtProperties() {
        return jwtProperties;
    }

    public void setJwtProperties(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }
}
