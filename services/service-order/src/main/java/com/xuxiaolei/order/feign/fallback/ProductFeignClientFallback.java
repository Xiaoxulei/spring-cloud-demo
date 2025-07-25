package com.xuxiaolei.order.feign.fallback;
import java.math.BigDecimal;

import com.xuxiaolei.order.feign.ProductFeignClient;
import com.xuxiaolei.product.Product;
import org.springframework.stereotype.Component;

/**
 * @Program: spring-cloud-demo
 * @Description: TODO: ProductFeignClientFallback
 * @Author: XuXiaoLei
 * @Create: 2025/07/23 23:43
 **/
@Component
public class ProductFeignClientFallback implements ProductFeignClient {

    @Override
    public Product getProductById(Long id) {
        System.out.println("兜底回调");
        Product product = new Product();
        product.setProductId(id);
        product.setProductName("未知商品");
        product.setProductPrice(new BigDecimal("0"));
        product.setNum(0);

        return product;
    }
}
