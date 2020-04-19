package com.atguigu.gulimall.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gulimall.oms.entity.OrderOperateHistoryEntity;
import com.atguigu.gulimall.commons.bean.PageVo;
import com.atguigu.gulimall.commons.bean.QueryCondition;


/**
 * 订单操作历史记录
 *
 * @author leifengyang
 * @email lfy@atguigu.com
 * @date 2020-04-19 13:15:01
 */
public interface OrderOperateHistoryService extends IService<OrderOperateHistoryEntity> {

    PageVo queryPage(QueryCondition params);
}

