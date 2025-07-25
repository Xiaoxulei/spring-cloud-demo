package com.xuxiaolei.product.service;


import com.xuxiaolei.product.Product;

/**
 * @Program: spring-cloud-demo
 * @Description: TODO: ProductSerevice
 * @Author: XuXiaoLei
 * @Create: 2025/07/22 23:28
 **/
public interface ProductService{
    Product getProductById(Long productId);
}
