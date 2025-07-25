package com.xuxiaolei.order.comfig;

import feign.Logger;
import feign.Retryer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: xuxiaolei
 * @Description: TODO: ProductServiceConfig
 * @CreatTime: 2025/07/23 11:08
 **/
@Configuration
public class OrderServiceConfig {

    /*@Bean*/
    Retryer retryer() {
        return new Retryer.Default();
    }
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
