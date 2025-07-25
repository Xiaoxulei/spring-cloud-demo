package com.xuxiaolei.order;

import com.xuxiaolei.product.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Program: spring-cloud-demo
 * @Description: TODO: BeanOrder
 * @Author: XuXiaoLei
 * @Create: 2025/07/22 23:42
 **/
@Data
public class Order {
    private Long id;
    private BigDecimal totalAmount;
    private Long userId;
    private String nickName;
    private String address;
    private List<Product> productList;
}
