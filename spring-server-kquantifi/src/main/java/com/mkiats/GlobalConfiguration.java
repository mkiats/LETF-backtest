package com.mkiats;

import com.mkiats.commons.inteceptors.PayloadSizeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalConfiguration {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}
}

@Configuration
class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
			.addMapping("/**")
			.allowedHeaders("*")
			.allowedMethods("GET", "POST", "PUT", "DELETE")
			.allowedOrigins("http://localhost:3000")
			.allowCredentials(true);
	}

	private PayloadSizeInterceptor payloadSizeInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(payloadSizeInterceptor);
	}

	@Autowired
	public WebConfig(PayloadSizeInterceptor thePayloadSizeInterceptor) {
		this.payloadSizeInterceptor = thePayloadSizeInterceptor;
	}
}
