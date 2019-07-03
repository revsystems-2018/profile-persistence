package com.dharbor.set.fusion.dynamicentityservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author rveizaga
 */
@EnableConfigurationProperties
@Component
@ConfigurationProperties(prefix = "persistence.authorization")
public class AuthorizationPropertiesConfig {

    private String type;
    private Map<String, String> headers;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
