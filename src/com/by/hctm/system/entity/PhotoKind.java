package com.by.hctm.system.entity;

import java.util.Date;

/**
 * PhotoKind entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class PhotoKind implements java.io.Serializable {

	// Fields

	private Long pkId;
	private String pkCode;
	private String pkName;
	private Long pkOrder;
	private Long parentId;
	private String isHaveChild;
	private String selflevCode;
	private Long pkLevel;
	private String remark;
	private String isUsable;
	private String createMan;
	private Date createTime;
	private Long standardId;

	// Constructors

	/** default constructor */
	public PhotoKind() {
	}

	/** minimal constructor */
	public PhotoKind(Long pkId) {
		this.pkId = pkId;
	}

	/** full constructor */
	public PhotoKind(Long pkId, String pkCode, String pkName, Long pkOrder,
			Long parentId, String isHaveChild, String selflevCode,
			Long pkLevel, String remark, String isUsable, String createMan,
			Date createTime,Long standardId) {
		this.pkId = pkId;
		this.pkCode = pkCode;
		this.pkName = pkName;
		this.pkOrder = pkOrder;
		this.parentId = parentId;
		this.isHaveChild = isHaveChild;
		this.selflevCode = selflevCode;
		this.pkLevel = pkLevel;
		this.remark = remark;
		this.isUsable = isUsable;
		this.createMan = createMan;
		this.createTime = createTime;
		this.standardId = standardId;
	}

	// Property accessors

	public Long getPkId() {
		return this.pkId;
	}

	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}

	public String getPkCode() {
		return this.pkCode;
	}

	public void setPkCode(String pkCode) {
		this.pkCode = pkCode;
	}

	public String getPkName() {
		return this.pkName;
	}

	public void setPkName(String pkName) {
		this.pkName = pkName;
	}

	

	public Long getPkOrder() {
		return pkOrder;
	}

	public void setPkOrder(Long pkOrder) {
		this.pkOrder = pkOrder;
	}

	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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

	public Long getPkLevel() {
		return this.pkLevel;
	}

	public void setPkLevel(Long pkLevel) {
		this.pkLevel = pkLevel;
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

	public Long getStandardId() {
		return standardId;
	}

	public void setStandardId(Long standardId) {
		this.standardId = standardId;
	}

}