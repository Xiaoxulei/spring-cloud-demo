package com.xuxiaolei.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xuxiaolei.order.Order;
import com.xuxiaolei.order.properties.OrderProperties;
import com.xuxiaolei.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Program: spring-cloud-demo
 * @Description: TODO: OrderController
 * @Author: XuXiaoLei
 * @Create: 2025/07/22 23:41
 **/
//@RefreshScope
@Slf4j
@EnableFeignClients  //开启Feign远程调用功能
@RestController
//@RequestMapping("/api/order")
public class OrderController {
    /*@Value("${order.timeout}")
    private String orderTimeout;
    @Value("${order.auto-confirm}")
    private String orderConfirm;*/
    @Autowired
    private OrderProperties  orderProperties;
    @Autowired
    private OrderService orderService;

    @GetMapping("config")
    public String config() {
        return "order.timeout:" + orderProperties.getTimeout() +"," +
                "order.auto-confirm:" + orderProperties.getAutoConfirm();
    }
    @GetMapping("/create")
    public Order createOrder(@RequestParam("userId") Long userId ,
                             @RequestParam("productId") Long  productId) {

        return orderService.createOrder(productId,userId);

    }

    @GetMapping("/secKill")
    @SentinelResource(value = "secKill-order",fallback = "secKillFallback")
    public Order secKill(@RequestParam(value = "userId",required = false) Long userId ,
                             @RequestParam(value = "productId",required = false) Long  productId) {
        Order order = orderService.createOrder(productId, userId);
        order.setId(Long.MAX_VALUE);
        return order;

    }
    public Order secKillFallback(Long userId , Long  productId , Throwable exception) {
        System.out.println("secKillFallback....");
        Order order = new Order();
        order.setAddress("异常信息" + exception.getClass());
        order.setId(userId);
        order.setNickName(productId.toString());
        return order;

    }

    @GetMapping("config1")
    public String config1() {
        return "order.name:" + orderProperties.getName() +"," +
                "order.age:" + orderProperties.getAge();
    }

    @GetMapping("writeDb")
    public String writeDb() {
        log.info("writeDb...");
        return "writeDb success";
    }

    @GetMapping("readDb")
    public String readDb() {
        log.info("readDb...");
        return "readDb success";
    }
}
