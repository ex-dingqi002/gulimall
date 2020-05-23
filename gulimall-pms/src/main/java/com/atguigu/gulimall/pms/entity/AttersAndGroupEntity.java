package com.atguigu.gulimall.pms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@ApiModel
@Data
@TableName("pms_attr")
public class AttersAndGroupEntity extends AttrEntity{
    private List<?> group;

    public List<?> getGroup() {
        return group;
    }

    public void setGroup(List<?> group) {
        this.group = group;
    }
}
