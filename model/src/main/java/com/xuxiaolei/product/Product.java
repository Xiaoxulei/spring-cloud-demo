package com.xuxiaolei.product;

/**
 * @Program: spring-cloud-demo
 * @Description: TODO: ProductBean
 * @Author: XuXiaoLei
 * @Create: 2025/07/22 23:22
 **/
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private Long productId;

    private String productName;

    private BigDecimal productPrice;

    /*private String getProductName;*/

    private int num;
}
