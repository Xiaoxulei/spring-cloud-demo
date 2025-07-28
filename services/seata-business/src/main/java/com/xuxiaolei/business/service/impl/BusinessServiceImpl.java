package com.xuxiaolei.business.service.impl;

import com.xuxiaolei.business.feign.OrderFeignClient;
import com.xuxiaolei.business.feign.StorageFeignClient;
import com.xuxiaolei.business.service.BusinessService;
import org.apache.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    StorageFeignClient storageFeignClient;

    @Autowired
    OrderFeignClient orderFeignClient;




    @GlobalTransactional
    @Override
    public void purchase(String userId, String commodityCode, int orderCount) {
        //1. 扣减库存
        storageFeignClient.deduct(commodityCode, orderCount);

        //2. 创建订单
        orderFeignClient.create(userId, commodityCode, orderCount);
    }
}
