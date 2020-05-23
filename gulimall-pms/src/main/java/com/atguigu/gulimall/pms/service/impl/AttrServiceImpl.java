package com.atguigu.gulimall.pms.service.impl;

import com.atguigu.gulimall.pms.dao.AttrAttrgroupRelationDao;
import com.atguigu.gulimall.pms.dao.AttrGroupDao;
import com.atguigu.gulimall.pms.entity.AttersAndGroupEntity;
import com.atguigu.gulimall.pms.entity.AttrAttrgroupRelationEntity;
import com.atguigu.gulimall.pms.entity.AttrGroupEntity;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gulimall.commons.bean.PageVo;
import com.atguigu.gulimall.commons.bean.Query;
import com.atguigu.gulimall.commons.bean.QueryCondition;

import com.atguigu.gulimall.pms.dao.AttrDao;
import com.atguigu.gulimall.pms.entity.AttrEntity;
import com.atguigu.gulimall.pms.service.AttrService;

import java.util.ArrayList;
import java.util.List;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {
    @Autowired
    AttrDao attrDao;

    @Autowired
    AttrAttrgroupRelationDao attrAttrgroupRelationDao;

    @Autowired
    AttrGroupDao attrGroupDao ;

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public PageVo queryBaseAttrs(QueryCondition queryCondition, Integer catId) {
        //1、获取分页条件
        IPage<AttrEntity> page = new Query<AttrEntity>().getPage(queryCondition);

        //2、构造查询条件
        QueryWrapper<AttrEntity> wrapper = new QueryWrapper<AttrEntity>()
                .eq("catelog_id", catId);


        IPage<AttrEntity> data = this.page(page, wrapper);
        return new PageVo(data);
    }

    @Override
    public PageVo queryqueryGroupId(QueryCondition queryCondition, Integer groupId) {
        QueryWrapper<AttrAttrgroupRelationEntity> attr_group_id = new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_group_id", groupId);
        List<AttrAttrgroupRelationEntity> attrAttrgroupRelationEntities = attrAttrgroupRelationDao.selectList(attr_group_id);

        ArrayList<Long> integers = new ArrayList<>(attrAttrgroupRelationEntities.size());
        for (AttrAttrgroupRelationEntity attrAttrgroupRelationEntity : attrAttrgroupRelationEntities) {
            integers.add(attrAttrgroupRelationEntity.getAttrId());
        }


        //1、获取分页条件
        IPage<AttrEntity> page = new Query<AttrEntity>().getPage(queryCondition);

        QueryWrapper<AttrEntity> wrapper = new QueryWrapper<AttrEntity>();
        //2、构造查询条件
        if(integers.size()>0){
            wrapper.in("attr_id",integers);
            IPage<AttrEntity> data = this.page(page, wrapper);
            return new PageVo(data);
        }

        return new PageVo(new Page<AttrEntity>());


    }

    @Override
    public AttersAndGroupEntity queryGroupAndAttrs(Integer attrId) {
        AttersAndGroupEntity attersAndGroupEntity = new AttersAndGroupEntity();

        AttrEntity attrEntity = attrDao.selectOne(new QueryWrapper<AttrEntity>().eq("attr_id",attrId));
        if(null==attrEntity){
            return new AttersAndGroupEntity();
        }
        BeanUtils.copyProperties(attrEntity,attersAndGroupEntity);

        QueryWrapper<AttrGroupEntity> catelog_id = new QueryWrapper<AttrGroupEntity>().eq("catelog_id", attrEntity.getCatelogId());
        List<AttrGroupEntity> attrGroupEntities = attrGroupDao.selectList(catelog_id);

        attersAndGroupEntity.setGroup(attrGroupEntities);


        return attersAndGroupEntity;
    }

    @Override
    public void saveAttrEntity(AttrEntity param) {
        attrDao.insert(param);
    }

}