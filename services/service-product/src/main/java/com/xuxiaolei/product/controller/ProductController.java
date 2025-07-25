package com.xuxiaolei.product.controller;

import com.alibaba.nacos.api.naming.pojo.healthcheck.impl.Http;
import com.xuxiaolei.product.Product;
import com.xuxiaolei.product.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Program: spring-cloud-demo
 * @Description: TODO: ProductController
 * @Author: XuXiaoLei
 * @Create: 2025/07/22 23:26
 **/
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    //查询商品
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") Long productId, HttpServletRequest request) {
        String header = request.getHeader("X-Token");
        System.out.println("hello token = 【" + header + "】");
        Product product =productService.getProductById(productId);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return product;
    }
}
