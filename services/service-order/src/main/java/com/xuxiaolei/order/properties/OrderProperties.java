package com.xuxiaolei.order.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: xuxiaolei
 * @Description: TODO: OrderPropertied
 * @CreatTime: 2025/07/23 15:14
 **/
@ConfigurationProperties(prefix = "order") //配置批量绑定在nacos下，可以无需@RefreshScope就能实现自动刷新
@Component
@Data
public class OrderProperties {

    private String timeout;

    private String autoConfirm;

    private String name;

    private Integer age;

}
