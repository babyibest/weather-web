package com.by.hctm.system.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * TSysDict entity. @author MyEclipse Persistence Tools
 */

public class TSysDict implements java.io.Serializable {

	// Fields

	private Long dictId;
	private String dictCode;
	private String dictName;
	private Short dictOrder;
	private Long parentDictId;
	private String parentDictCode;
	private String isHaveChild;
	private String selflevCode;
	private Long dictLevel;
	private String remark;
	private String isUsable;
	private String createMan;
	private Date createTime;

	// Constructors

	/** default constructor */
	public TSysDict() {
	}

	/** full constructor */
	public TSysDict(String dictCode, String dictName, Short dictOrder,
			Long parentDictId, String isHaveChild, String selflevCode,
			Long dictLevel, String remark, String isUsable, String createMan,
			Date createTime) {
		this.dictCode = dictCode;
		this.dictName = dictName;
		this.dictOrder = dictOrder;
		this.parentDictId = parentDictId;
		this.isHaveChild = isHaveChild;
		this.selflevCode = selflevCode;
		this.dictLevel = dictLevel;
		this.remark = remark;
		this.isUsable = isUsable;
		this.createMan = createMan;
		this.createTime = createTime;
	}

	// Property accessors

	public Long getDictId() {
		return this.dictId;
	}

	public void setDictId(Long dictId) {
		this.dictId = dictId;
	}

	public String getDictCode() {
		return this.dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	public String getDictName() {
		return this.dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public Short getDictOrder() {
		return this.dictOrder;
	}

	public void setDictOrder(Short dictOrder) {
		this.dictOrder = dictOrder;
	}

	public Long getParentDictId() {
		return parentDictId;
	}

	public void setParentDictId(Long parentDictId) {
		this.parentDictId = parentDictId;
	}

	public String getParentDictCode() {
		return parentDictCode;
	}

	public void setParentDictCode(String parentDictCode) {
		this.parentDictCode = parentDictCode;
	}

	public String getIsHaveChild() {
		return this.isHaveChild;
	}

	public void setIsHaveChild(String isHaveChild) {
		this.isHaveChild = isHaveChild;
	}

	public String getSelflevCode() {
		return this.selflevCode;
	}

	public void setSelflevCode(String selflevCode) {
		this.selflevCode = selflevCode;
	}

	public Long getDictLevel() {
		return this.dictLevel;
	}

	public void setDictLevel(Long dictLevel) {
		this.dictLevel = dictLevel;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIsUsable() {
		return this.isUsable;
	}

	public void setIsUsable(String isUsable) {
		this.isUsable = isUsable;
	}

	public String getCreateMan() {
		return this.createMan;
	}

	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}