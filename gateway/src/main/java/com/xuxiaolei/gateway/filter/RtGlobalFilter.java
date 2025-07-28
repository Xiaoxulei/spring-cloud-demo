package com.xuxiaolei.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * @Author: xuxiaolei
 * @Description: TODO: RtGlobalFilter
 * @CreatTime: 2025/07/28 09:15
 **/
@Component
@Slf4j
public class RtGlobalFilter implements GlobalFilter , Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String uri = request.getURI().toString();
        long start = System.currentTimeMillis();
        log.info("请求【{}】开始：时间【{}】",uri,start);
        //=======================前置逻辑==============
        Mono<Void> filter = chain.filter(exchange)
                .doFinally((result)->{
                    long end = System.currentTimeMillis();
                    log.info("请求【{}】结束：时间{}，耗时【{}】ms",uri , end,end - start);
                });//异步十秒，响应式编程

        return filter;
    }

    //filter的执行顺序
    @Override
    public int getOrder() {
        return 0;
    }
}
