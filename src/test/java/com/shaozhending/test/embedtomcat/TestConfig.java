package com.shaozhending.test.embedtomcat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TestConfig {
	@Bean
	public RestTemplate getTemplate(){
		return new RestTemplate();
	}
}
