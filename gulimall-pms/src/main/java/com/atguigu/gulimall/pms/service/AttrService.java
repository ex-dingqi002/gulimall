package com.atguigu.gulimall.pms.service;

import com.atguigu.gulimall.pms.entity.AttersAndGroupEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gulimall.pms.entity.AttrEntity;
import com.atguigu.gulimall.commons.bean.PageVo;
import com.atguigu.gulimall.commons.bean.QueryCondition;


/**
 * 商品属性
 *
 * @author leifengyang
 * @email lfy@atguigu.com
 * @date 2020-04-19 13:02:00
 */
public interface AttrService extends IService<AttrEntity> {

    PageVo queryPage(QueryCondition params);

    PageVo queryBaseAttrs(QueryCondition queryCondition, Integer catId);

    PageVo queryqueryGroupId(QueryCondition queryCondition, Integer groupId);

    AttersAndGroupEntity queryGroupAndAttrs(Integer attrId);

    void saveAttrEntity(AttrEntity param);
}

