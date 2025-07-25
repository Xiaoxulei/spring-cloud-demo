package com.xuxiaolei.openai.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: xuxiaolei
 * @Description: TODO: OpenAiFeignConfig
 * @CreatTime: 2025/07/24 16:52
 **/
@Configuration
public class OpenAiFeignConfig {
    @Value("${openai.api.key}")
    private String apiKey;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Bearer " + apiKey);
            requestTemplate.header("Content-Type", "application/json");
        };
    }
}
