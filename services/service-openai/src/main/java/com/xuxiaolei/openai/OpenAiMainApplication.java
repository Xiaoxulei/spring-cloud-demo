package com.xuxiaolei.openai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: xuxiaolei
 * @Description: TODO: OpenAiMainApplication
 * @CreatTime: 2025/07/24 16:49
 **/
@EnableFeignClients
@SpringBootApplication
public class OpenAiMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenAiMainApplication.class, args);
    }
}
