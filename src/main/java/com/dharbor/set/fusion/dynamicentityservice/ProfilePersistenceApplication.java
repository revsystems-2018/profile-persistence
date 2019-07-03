package com.dharbor.set.fusion.dynamicentityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@Import({
		com.dharbor.set.social.common.hystrix.Application.class,
})
public class ProfilePersistenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfilePersistenceApplication.class, args);
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}
}
