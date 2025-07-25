package com.xuxiaolei.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Program: spring-cloud-demo
 * @Description: TODO: XTokenRequestInterceptor
 * @Author: XuXiaoLei
 * @Create: 2025/07/23 23:21
 **/
@Component
public class XTokenRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("XTokenRequestInterceptor...... ");
        requestTemplate.header("X-Token", UUID.randomUUID().toString());
    }
}
