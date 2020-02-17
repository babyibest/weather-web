package com.by.hctm.manpower.entity;

import java.util.Date;

/**
 * CertificatesKind entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CertificatesKind implements java.io.Serializable {

	// Fields

	private Long certKindId;
	private String certKindCode;
	private String certKindName;
	private Long certKindParentId;
	private String isHaveChild;
	private String selflevCode;
	private Long certKindLevel;
	private String isUsable;
	private Long certOrder;
	private String remark;
	private String createMan;
	private Date createTime;
	private String certKindOrg;

	// Constructors

	/** default constructor */
	public CertificatesKind() {
	}

	/** minimal constructor */
	public CertificatesKind(Long certKindId) {
		this.certKindId = certKindId;
	}

	/** full constructor */
	public CertificatesKind(Long certKindId, String certKindCode,
			String certKindName, Long certKindParentId, String isHaveChild,
			String selflevCode, Long certKindLevel, String isUsable,
			Long certOrder, String remark, String createMan, Date createTime,String certKindOrg) {
		this.certKindId = certKindId;
		this.certKindCode = certKindCode;
		this.certKindName = certKindName;
		this.certKindParentId = certKindParentId;
		this.isHaveChild = isHaveChild;
		this.selflevCode = selflevCode;
		this.certKindLevel = certKindLevel;
		this.isUsable = isUsable;
		this.certOrder = certOrder;
		this.remark = remark;
		this.createMan = createMan;
		this.createTime = createTime;
		this.certKindOrg = certKindOrg;
	}

	// Property accessors

	public Long getCertKindId() {
		return this.certKindId;
	}

	public void setCertKindId(Long certKindId) {
		this.certKindId = certKindId;
	}

	public String getCertKindCode() {
		return this.certKindCode;
	}

	public void setCertKindCode(String certKindCode) {
		this.certKindCode = certKindCode;
	}

	public String getCertKindName() {
		return this.certKindName;
	}

	public void setCertKindName(String certKindName) {
		this.certKindName = certKindName;
	}

	public Long getCertKindParentId() {
		return this.certKindParentId;
	}

	public String getCertKindOrg() {
		return certKindOrg;
	}

	public void setCertKindOrg(String certKindOrg) {
		this.certKindOrg = certKindOrg;
	}

	public void setCertKindParentId(Long certKindParentId) {
		this.certKindParentId = certKindParentId;
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

	public Long getCertKindLevel() {
		return this.certKindLevel;
	}

	public void setCertKindLevel(Long certKindLevel) {
		this.certKindLevel = certKindLevel;
	}

	public String getIsUsable() {
		return this.isUsable;
	}

	public void setIsUsable(String isUsable) {
		this.isUsable = isUsable;
	}

	public Long getCertOrder() {
		return this.certOrder;
	}

	public void setCertOrder(Long certOrder) {
		this.certOrder = certOrder;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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