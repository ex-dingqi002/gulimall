package com.atguigu.gulimall.pms.service.impl;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gulimall.commons.bean.PageVo;
import com.atguigu.gulimall.commons.bean.Query;
import com.atguigu.gulimall.commons.bean.QueryCondition;

import com.atguigu.gulimall.pms.dao.SpuInfoDao;
import com.atguigu.gulimall.pms.entity.SpuInfoEntity;
import com.atguigu.gulimall.pms.service.SpuInfoService;


@Service("spuInfoService")
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoDao, SpuInfoEntity> implements SpuInfoService {
    @Autowired
    SpuInfoDao spuInfoDao;


    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SpuInfoEntity> page = this.page(
                new Query<SpuInfoEntity>().getPage(params),
                new QueryWrapper<SpuInfoEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public PageVo queryGoods(QueryCondition queryCondition, Integer catId) {
        QueryWrapper<SpuInfoEntity> wrapper = new QueryWrapper<>();
        if (catId != 0) {
            //查全站的
            // catalog_id = 227 and (spu_name like ss or id = 1)
            wrapper.eq("catalog_id", catId);
            if (!StringUtils.isEmpty(queryCondition.getKey())) {
                wrapper.and(obj -> {
                    obj.like("spu_name", queryCondition.getKey());
                    obj.or().like("id", queryCondition.getKey());
                    return obj;
                });
        }

    }
        IPage<SpuInfoEntity> page = new Query<SpuInfoEntity>().getPage(queryCondition);

        IPage<SpuInfoEntity> data = this.page(page, wrapper);


        PageVo pageVo = new PageVo(data.getRecords(), data.getTotal(), data.getSize(), data.getCurrent());
        PageVo vo = new PageVo(data);

        return vo;

}

    @Override
    public void updateStatus(Integer status, Integer[] spuIds) {
        QueryWrapper<SpuInfoEntity> spuInfoEntityQueryWrapper = new QueryWrapper<>();
        spuInfoEntityQueryWrapper.in("id",spuIds);
        SpuInfoEntity spuInfoEntity = new SpuInfoEntity();
        spuInfoEntity.setPublishStatus(status);
        spuInfoDao.update(spuInfoEntity,spuInfoEntityQueryWrapper);

    }

    @Override
    public void updateStatus1(Integer status, Integer spuId) {
        QueryWrapper<SpuInfoEntity> spuInfoEntityQueryWrapper = new QueryWrapper<>();
        spuInfoEntityQueryWrapper.eq("id",spuId);
        SpuInfoEntity spuInfoEntity = new SpuInfoEntity();
        spuInfoEntity.setPublishStatus(status);
        spuInfoDao.update(spuInfoEntity,spuInfoEntityQueryWrapper);
    }
}