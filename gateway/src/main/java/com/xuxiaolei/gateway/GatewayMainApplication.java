package com.xuxiaolei.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: xuxiaolei
 * @Description: TODO: GatewayMainApplication
 * @CreatTime: 2025/07/25 11:40
 **/
@EnableDiscoveryClient //开启服务发现
@SpringBootApplication
public class GatewayMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMainApplication.class, args);
    }
}
