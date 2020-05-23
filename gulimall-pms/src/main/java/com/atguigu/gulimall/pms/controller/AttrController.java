package com.atguigu.gulimall.pms.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import com.atguigu.gulimall.commons.bean.PageVo;
import com.atguigu.gulimall.commons.bean.QueryCondition;
import com.atguigu.gulimall.commons.bean.Resp;
import com.atguigu.gulimall.pms.entity.AttersAndGroupEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.atguigu.gulimall.pms.entity.AttrEntity;
import com.atguigu.gulimall.pms.service.AttrService;




/**
 * 商品属性
 *
 * @author leifengyang
 * @email lfy@atguigu.com
 * @date 2020-04-19 13:02:00
 */
@Api(tags = "商品属性 管理")
@RestController
@RequestMapping("pms/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    @ApiOperation("保存属性")
    @PostMapping("/save1")
    public Resp<Object> saveAttrEntity(@RequestBody AttrEntity param) {
        attrService.saveAttrEntity(param);

        return Resp.ok("OK");
    }





    @ApiOperation("查出某个属性，以及这个属性所属的分组信息")
    @GetMapping("/info1/{attrId}")
    public Resp<AttersAndGroupEntity> queryGroupAndAttrs(@PathVariable Integer attrId) {
        AttersAndGroupEntity attersAndGroupEntities = attrService.queryGroupAndAttrs(attrId);

        return Resp.ok(attersAndGroupEntities);
    }




    @ApiOperation("查询某个分组下对应的所有属性")
    @GetMapping("/group/list/{groupId}")
    public Resp<PageVo> queryGroupId(QueryCondition queryCondition,@PathVariable Integer groupId) {
        PageVo pageVo = attrService.queryqueryGroupId(queryCondition, groupId);

        return Resp.ok(pageVo);
    }




    @ApiOperation("查询某个三级分类下的所有基本属性")
    @GetMapping("/base/{catId}")
    public Resp<PageVo> queryBaseAttrs(QueryCondition queryCondition,@PathVariable Integer catId) {
        PageVo pageVo = attrService.queryBaseAttrs(queryCondition, catId);

        return Resp.ok(pageVo);
    }



    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('pms:attr:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = attrService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{attrId}")
    @PreAuthorize("hasAuthority('pms:attr:info')")
    public Resp<AttrEntity> info(@PathVariable("attrId") Long attrId){
		AttrEntity attr = attrService.getById(attrId);

        return Resp.ok(attr);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('pms:attr:save')")
    public Resp<Object> save(@RequestBody AttrEntity attr){
		attrService.save(attr);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('pms:attr:update')")
    public Resp<Object> update(@RequestBody AttrEntity attr){
		attrService.updateById(attr);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('pms:attr:delete')")
    public Resp<Object> delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return Resp.ok(null);
    }

}
