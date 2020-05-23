package com.atguigu.gulimall.pms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品属性
 * 
 * @author leifengyang
 * @email lfy@atguigu.com
 * @date 2020-04-19 13:02:00
 */
@ApiModel
@Data
@TableName("pms_attr")
public class AttrEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 属性id
	 */
	@TableId
	@ApiModelProperty(name = "attrId",value = "属性id")
	private Long attrId;
	/**
	 * 属性名
	 */
	@ApiModelProperty(name = "attrName",value = "属性名")
	private String attrName;
	/**
	 * 是否需要检索[0-不需要，1-需要]
	 */
	@ApiModelProperty(name = "searchType",value = "是否需要检索[0-不需要，1-需要]")
	private Integer searchType;
	/**
	 * 值类型[0-为单个值，1-可以选择多个值]
	 */
	@ApiModelProperty(name = "valueType",value = "值类型[0-为单个值，1-可以选择多个值]")
	private Integer valueType;
	/**
	 * 属性图标
	 */
	@ApiModelProperty(name = "icon",value = "属性图标")
	private String icon;
	/**
	 * 可选值列表[用逗号分隔]
	 */
	@ApiModelProperty(name = "valueSelect",value = "可选值列表[用逗号分隔]")
	private String valueSelect;
	/**
	 * 属性类型[0-销售属性，1-基本属性]
	 */
	@ApiModelProperty(name = "attrType",value = "属性类型[0-销售属性，1-基本属性]")
	private Integer attrType;
	/**
	 * 启用状态[0 - 禁用，1 - 启用]
	 */
	@ApiModelProperty(name = "enable",value = "启用状态[0 - 禁用，1 - 启用]")
	private Long enable;
	/**
	 * 所属分类
	 */
	@ApiModelProperty(name = "catelogId",value = "所属分类")
	private Long catelogId;
	/**
	 * 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
	 */
	@ApiModelProperty(name = "showDesc",value = "快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整")
	private Integer showDesc;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getAttrId() {
		return attrId;
	}

	public void setAttrId(Long attrId) {
		this.attrId = attrId;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public Integer getSearchType() {
		return searchType;
	}

	public void setSearchType(Integer searchType) {
		this.searchType = searchType;
	}

	public Integer getValueType() {
		return valueType;
	}

	public void setValueType(Integer valueType) {
		this.valueType = valueType;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getValueSelect() {
		return valueSelect;
	}

	public void setValueSelect(String valueSelect) {
		this.valueSelect = valueSelect;
	}

	public Integer getAttrType() {
		return attrType;
	}

	public void setAttrType(Integer attrType) {
		this.attrType = attrType;
	}

	public Long getEnable() {
		return enable;
	}

	public void setEnable(Long enable) {
		this.enable = enable;
	}

	public Long getCatelogId() {
		return catelogId;
	}

	public void setCatelogId(Long catelogId) {
		this.catelogId = catelogId;
	}

	public Integer getShowDesc() {
		return showDesc;
	}

	public void setShowDesc(Integer showDesc) {
		this.showDesc = showDesc;
	}
}
