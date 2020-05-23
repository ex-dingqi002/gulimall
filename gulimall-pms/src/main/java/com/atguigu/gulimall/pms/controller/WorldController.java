package com.atguigu.gulimall.pms.controller;

import com.atguigu.gulimall.pms.entity.BrandEntity;
import com.atguigu.gulimall.pms.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/world")
    public String world() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setDescript("丁奇");
        brandService.save(brandEntity);

        return "world";
    }

}
