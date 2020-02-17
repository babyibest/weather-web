package com.by.hctm.system.entity;

import java.util.Date;

/**
 * QualityCheckKind entity. @author MyEclipse Persistence Tools
 */

public class QualityCheckKind implements java.io.Serializable {

	// Fields

	private Long qckId;
	private String qckCode;
	private String qckName;
	private Long qckOrder;
	private Long parentQckId;
	private String isHaveChild;
	private String selflevCode;
	private String selflevName;
	private Long qckLevel;
	private String isUsable;
	private String createMan;
	private Date createTime;
	private String remark;

	// Constructors

	/** default constructor */
	public QualityCheckKind() {
	}

	/** full constructor */
	public QualityCheckKind(String qckCode, String qckName, Long qckOrder,
			Long parentQckId, String isHaveChild, String selflevCode,
			String selflevName, Long qckLevel, String isUsable,
			String createMan, Date createTime, String remark) {
		this.qckCode = qckCode;
		this.qckName = qckName;
		this.qckOrder = qckOrder;
		this.parentQckId = parentQckId;
		this.isHaveChild = isHaveChild;
		this.selflevCode = selflevCode;
		this.selflevName = selflevName;
		this.qckLevel = qckLevel;
		this.isUsable = isUsable;
		this.createMan = createMan;
		this.createTime = createTime;
		this.remark = remark;
	}

	// Property accessors

	public Long getQckId() {
		return this.qckId;
	}

	public void setQckId(Long qckId) {
		this.qckId = qckId;
	}

	public String getQckCode() {
		return this.qckCode;
	}

	public void setQckCode(String qckCode) {
		this.qckCode = qckCode;
	}

	public String getQckName() {
		return this.qckName;
	}

	public void setQckName(String qckName) {
		this.qckName = qckName;
	}

	public Long getQckOrder() {
		return this.qckOrder;
	}

	public void setQckOrder(Long qckOrder) {
		this.qckOrder = qckOrder;
	}

	public Long getParentQckId() {
		return this.parentQckId;
	}

	public void setParentQckId(Long parentQckId) {
		this.parentQckId = parentQckId;
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

	public String getSelflevName() {
		return this.selflevName;
	}

	public void setSelflevName(String selflevName) {
		this.selflevName = selflevName;
	}

	public Long getQckLevel() {
		return this.qckLevel;
	}

	public void setQckLevel(Long qckLevel) {
		this.qckLevel = qckLevel;
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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}