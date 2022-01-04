package com.images_base.backend.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/27
 */
@Component
@ConfigurationProperties(prefix = "images-base-properties.jwt-properties")
public class JwtProperties {

    private String id;

    private String secret;

    private Integer tokenExpiredTime;

    private String timeUnit;

    private Set<String> urlPatterns;

    private Set<String> excludeUrlPatterns;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Integer getTokenExpiredTime() {
        return tokenExpiredTime;
    }

    public void setTokenExpiredTime(Integer tokenExpiredTime) {
        this.tokenExpiredTime = tokenExpiredTime;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public Set<String> getUrlPatterns() {
        return urlPatterns;
    }

    public void setUrlPatterns(Set<String> urlPatterns) {
        this.urlPatterns = urlPatterns;
    }

    public Set<String> getExcludeUrlPatterns() {
        return excludeUrlPatterns;
    }

    public void setExcludeUrlPatterns(Set<String> excludeUrlPatterns) {
        this.excludeUrlPatterns = excludeUrlPatterns;
    }
}
