package com.xuxiaolei.product;

import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

/**
 * @Program: spring-cloud-demo
 * @Description: TODO: DiscoveryTest
 * @Author: XuXiaoLei
 * @Create: 2025/07/22 23:05
 **/
@SpringBootTest
public class DiscoveryTest {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    NacosServiceDiscovery discoveryServiceDiscovery;

    @Test
    public void discoveryServiceDiscoveryTest() throws NacosException {
        for (String service : discoveryServiceDiscovery.getServices()) {
            System.out.println(service);
            List<ServiceInstance> instances = discoveryServiceDiscovery.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println("ip" + instance.getHost() + "port" + instance.getPort());
            }
        }

    }
    @Test
    void discoveryClientTest() {

        for (String service : discoveryClient.getServices()) {
            System.out.println(service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println("ip" + instance.getHost() + ":" + instance.getPort());
            }
        }


    }
}
