package com.xuxiaolei.product.service.impl;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import com.xuxiaolei.product.Product;
import com.xuxiaolei.product.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @Program: spring-cloud-demo
 * @Description: TODO: ProductServiceImpl
 * @Author: XuXiaoLei
 * @Create: 2025/07/22 23:29
 **/
@Service
public class productServiceImpl implements ProductService {

    @Override
    public Product getProductById(Long productId) {
        Product product = new Product();
        product.setProductId(productId);
        product.setProductPrice(new BigDecimal("99"));
        product.setProductName("苹果" + productId);
        product.setNum(2);
        /*try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        return product;
    }
}
