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
@ConfigurationProperties(prefix = "persistence.data")
public class DataPropertiesConfig {

    private Map<String, String> user;

    public Map<String, String> getUser() {
        return user;
    }

    public void setUser(Map<String, String> user) {
        this.user = user;
    }
}
