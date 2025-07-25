package com.xuxiaolei.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Program: spring-cloud-demo
 * @Description: TODO: ProductApplication
 * @Author: XuXiaoLei
 * @Create: 2025/07/22 22:52
 **/
@EnableDiscoveryClient //开启服务发现
@SpringBootApplication
public class ProductMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductMainApplication.class, args);
    }
}
