package com.dharbor.set.fusion.dynamicentityservice.config;

import com.dharbor.set.social.common.hystrix.feign.HystrixCommandErrorDecoder;
import feign.codec.Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ivan.alban
 */
@Configuration
public class FeignConfig {

    @Bean
    public HystrixCommandErrorDecoder exceptionDecoder() {
        return new HystrixCommandErrorDecoder();
    }

    @Bean
    public Encoder feignEncoder() {
        return new FeignSpringFormEncoder();
    }
}
