package com.atguigu.gulimall.pms.dao;

import com.atguigu.gulimall.pms.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author leifengyang
 * @email lfy@atguigu.com
 * @date 2020-04-19 13:01:05
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
