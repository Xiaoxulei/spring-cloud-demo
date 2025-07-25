package com.xuxiaolei.order;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Program: spring-cloud-demo
 * @Description: TODO: OrderMainApplication
 * @Author: XuXiaoLei
 * @Create: 2025/07/22 22:44
 **/
@EnableFeignClients //开启Feign远程调用功能
@EnableDiscoveryClient //开启服务发现
@SpringBootApplication
public class OrderMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainApplication.class, args);
    }


    /*1.项目启动就监听配置文件变化
     * 2.发生变化后拿到变化值
     * 3.发送邮件
     * */
    @Bean
    ApplicationRunner applicationRunner(NacosConfigManager nacosConfigManager) {
        return args -> {
            //获得服务
            ConfigService configService = nacosConfigManager.getConfigService();
            configService.addListener("service-order.yaml","DEFAULT_GROUP",new Listener() {
                @Override
                public Executor getExecutor() {
                    return Executors.newFixedThreadPool(4);
                }

                @Override
                public void receiveConfigInfo(String s) {
                    System.out.println("变化为配置信息为：" + s);
                    System.out.println("邮件通知....");
                }
            });
            System.out.println("==========");
            };
    }
    //原方法
    /*@Bean
    ApplicationRunner applicationRunner(){
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {

            }
        };
    }*/
}


