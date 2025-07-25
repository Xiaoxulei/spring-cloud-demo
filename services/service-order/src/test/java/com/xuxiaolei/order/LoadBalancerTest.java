package com.xuxiaolei.order;

import com.alibaba.nacos.shaded.io.grpc.LoadBalancer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

/**
 * @Author: xuxiaolei
 * @Description: TODO: LoadBlanceTest
 * @CreatTime: 2025/07/23 11:40
 **/
@SpringBootTest
public class LoadBalancerTest {
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Test
    void loadBalancerTest() {
        ServiceInstance choose = loadBalancerClient.choose("service-product");
        System.out.println("choose:" + choose.getHost() + ":" + choose.getPort());
        choose = loadBalancerClient.choose("service-product");
        System.out.println("choose:" + choose.getHost() + ":" + choose.getPort());
        choose = loadBalancerClient.choose("service-product");
        System.out.println("choose:" + choose.getHost() + ":" + choose.getPort());
        choose = loadBalancerClient.choose("service-product");
        System.out.println("choose:" + choose.getHost() + ":" + choose.getPort());
        choose = loadBalancerClient.choose("service-product");
        System.out.println("choose:" + choose.getHost() + ":" + choose.getPort());
        choose = loadBalancerClient.choose("service-product");
        System.out.println("choose:" + choose.getHost() + ":" + choose.getPort());
    }
}
