package com.atguigu.gulimall.oms.beproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
@RefreshScope
@Component
public class beproperties {
    @Value("${my.lover}")
    private String lover;

    public String getLover() {
        return lover;
    }

    public void setLover(String lover) {
        this.lover = lover;
    }
}
