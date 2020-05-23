package com.atguigu.gulimall.oms.controller;

import com.atguigu.gulimall.oms.beproperties.beproperties;
import com.atguigu.gulimall.oms.entity.OrderEntity;
import com.atguigu.gulimall.oms.feign.WorldService;
import com.atguigu.gulimall.oms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class HelloController {
    @Autowired
    WorldService worldService;

    @Autowired
    private OrderService orderService;


    @Value("${my.value}")
    String content;

    @Autowired
    com.atguigu.gulimall.oms.beproperties.beproperties beproperties;


    @Transactional
    @GetMapping("/hello")
    public String hello() {
        String msg = worldService.world();

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setMemberUsername("丁奇");
        orderService.save(orderEntity);

        return "hello" + msg + content + "" + beproperties.getLover();

    }
}
