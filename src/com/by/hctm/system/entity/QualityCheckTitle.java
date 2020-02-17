package com.by.hctm.system.entity;

import java.util.Date;

/**
 * QualityCheckTitle entity. @author MyEclipse Persistence Tools
 */

public class QualityCheckTitle implements java.io.Serializable {

	// Fields

	private Long qctId;
	private Long qckId;
	private String qctCode;
	private String qctName;
	private Long qctOrder;
	private String titleFlag;
	private String isUsable;
	private String createMan;
	private Date createTime;
	private String remark;
	private String qctOrderCn;
	// Constructors

	/** default constructor */
	public QualityCheckTitle() {
	}

	/** minimal constructor */
	public QualityCheckTitle(Long qckId) {
		this.qckId = qckId;
	}

	/** full constructor */
	public QualityCheckTitle(Long qckId, String qctCode, String qctName,
			Long qctOrder, String titleFlag, String isUsable, String createMan,
			Date createTime, String remark) {
		this.qckId = qckId;
		this.qctCode = qctCode;
		this.qctName = qctName;
		this.qctOrder = qctOrder;
		this.titleFlag = titleFlag;
		this.isUsable = isUsable;
		this.createMan = createMan;
		this.createTime = createTime;
		this.remark = remark;
	}

	// Property accessors

	public Long getQctId() {
		return this.qctId;
	}

	public void setQctId(Long qctId) {
		this.qctId = qctId;
	}

	public Long getQckId() {
		return this.qckId;
	}

	public void setQckId(Long qckId) {
		this.qckId = qckId;
	}

	public String getQctCode() {
		return this.qctCode;
	}

	public void setQctCode(String qctCode) {
		this.qctCode = qctCode;
	}

	public String getQctName() {
		return this.qctName;
	}

	public void setQctName(String qctName) {
		this.qctName = qctName;
	}

	public Long getQctOrder() {
		return this.qctOrder;
	}

	public void setQctOrder(Long qctOrder) {
		this.qctOrder = qctOrder;
	}

	public String getTitleFlag() {
		return this.titleFlag;
	}

	public void setTitleFlag(String titleFlag) {
		this.titleFlag = titleFlag;
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

	public String getQctOrderCn() {
		return qctOrderCn;
	}

	public void setQctOrderCn(String qctOrderCn) {
		this.qctOrderCn = qctOrderCn;
	}

}