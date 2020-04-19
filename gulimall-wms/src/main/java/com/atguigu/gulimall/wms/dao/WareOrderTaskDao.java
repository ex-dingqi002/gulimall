package com.atguigu.gulimall.wms.dao;

import com.atguigu.gulimall.wms.entity.WareOrderTaskEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 库存工作单
 * 
 * @author leifengyang
 * @email lfy@atguigu.com
 * @date 2020-04-19 13:29:44
 */
@Mapper
public interface WareOrderTaskDao extends BaseMapper<WareOrderTaskEntity> {
	
}
