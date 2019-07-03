
package com.dharbor.set.fusion.dynamicentityservice.config;

import com.dharbor.set.social.common.hystrix.interceptor.FeignHeaderInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author rveizaga
 */
@Configuration
public class FeignHeaderConfig extends AuthorizationPropertiesConfig {

    @Bean
    public FeignHeaderInterceptor addHeaderFeign() {
        return new FeignHeaderInterceptor(this.getHeaders(), this.getType());
    }
}
