package com.atguigu.gulimall.oms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import javax.xml.soap.Name;

@FeignClient(name="gulimall-pms")
public interface WorldService {

    @GetMapping("/world")
    public String world();



}
