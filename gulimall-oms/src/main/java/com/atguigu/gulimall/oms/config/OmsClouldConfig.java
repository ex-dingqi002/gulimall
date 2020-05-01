package com.atguigu.gulimall.oms.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
@EnableFeignClients(basePackages = "com.atguigu.gulimall.oms.feign")
@Configuration
@EnableDiscoveryClient
public class OmsClouldConfig {
}
