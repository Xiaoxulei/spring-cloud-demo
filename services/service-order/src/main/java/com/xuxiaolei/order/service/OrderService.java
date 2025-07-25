package com.xuxiaolei.order.service;


import com.xuxiaolei.order.Order;

/**
* @Program: spring-cloud-demo
* @Description: TODO: OrderService
* @Author: XuXiaoLei
* @Create: 2025/07/22 23:47
 *
**/
public interface OrderService {
    Order createOrder(Long productId, Long userId);
}
