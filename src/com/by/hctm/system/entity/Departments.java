package com.by.hctm.system.entity;

import java.util.Date;

/**
 * Departments entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Departments implements java.io.Serializable {

	// Fields

	private Long depId;
	private String deptCode;
	private String deptName;
	private String deptDesc;
	private Long deptOrder;
	private String deptOffice;
	private Long parentDeptId;
	private String isHaveChild;
	private String selflevCode;
	private String selflevName;
	private Long deptLevel;
	private String deptTel;
	private String deptFax;
	private String createMan;
	private Date createTime;
	private String depLeaderEn;
	private String depLeaderCn;
	private String compLeaderEn;
	private String compLeaderCn;
	private String remark;
	private String isUsable;
	private String isProject ;
	
	// 操作信息
	private String operType ;
	// 提示信息
	private String message ;
	
	// Constructors

	/** default constructor */
	public Departments() {
	}

	/** minimal constructor */
	public Departments(Long depId) {
		this.depId = depId;
	}

	/** full constructor */
	public Departments(Long depId, String deptCode, String deptName, String deptDesc,
			Long deptOrder, String deptOffice, Long parentDeptId,
			String isHaveChild, String selflevCode, String selflevName,
			Long deptLevel, String deptTel, String deptFax, String createMan,
			Date createTime, String depLeaderEn, String depLeaderCn,
			String compLeaderEn, String compLeaderCn, String remark,
			String isUsable) {
		this.depId = depId;
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.deptDesc = deptDesc;
		this.deptOrder = deptOrder;
		this.deptOffice = deptOffice;
		this.parentDeptId = parentDeptId;
		this.isHaveChild = isHaveChild;
		this.selflevCode = selflevCode;
		this.selflevName = selflevName;
		this.deptLevel = deptLevel;
		this.deptTel = deptTel;
		this.deptFax = deptFax;
		this.createMan = createMan;
		this.createTime = createTime;
		this.depLeaderEn = depLeaderEn;
		this.depLeaderCn = depLeaderCn;
		this.compLeaderEn = compLeaderEn;
		this.compLeaderCn = compLeaderCn;
		this.remark = remark;
		this.isUsable = isUsable;
	}

	// Property accessors

	public Long getDepId() {
		return this.depId;
	}

	public void setDepId(Long depId) {
		this.depId = depId;
	}

	public String getDeptCode() {
		return this.deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptDesc() {
		return this.deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	public Long getDeptOrder() {
		return this.deptOrder;
	}

	public void setDeptOrder(Long deptOrder) {
		this.deptOrder = deptOrder;
	}

	public String getDeptOffice() {
		return this.deptOffice;
	}

	public void setDeptOffice(String deptOffice) {
		this.deptOffice = deptOffice;
	}

	public Long getParentDeptId() {
		return this.parentDeptId;
	}

	public void setParentDeptId(Long parentDeptId) {
		this.parentDeptId = parentDeptId;
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

	public Long getDeptLevel() {
		return this.deptLevel;
	}

	public void setDeptLevel(Long deptLevel) {
		this.deptLevel = deptLevel;
	}

	public String getDeptTel() {
		return this.deptTel;
	}

	public void setDeptTel(String deptTel) {
		this.deptTel = deptTel;
	}

	public String getDeptFax() {
		return this.deptFax;
	}

	public void setDeptFax(String deptFax) {
		this.deptFax = deptFax;
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

	public String getDepLeaderEn() {
		return this.depLeaderEn;
	}

	public void setDepLeaderEn(String depLeaderEn) {
		this.depLeaderEn = depLeaderEn;
	}

	public String getDepLeaderCn() {
		return this.depLeaderCn;
	}

	public void setDepLeaderCn(String depLeaderCn) {
		this.depLeaderCn = depLeaderCn;
	}

	public String getCompLeaderEn() {
		return this.compLeaderEn;
	}

	public void setCompLeaderEn(String compLeaderEn) {
		this.compLeaderEn = compLeaderEn;
	}

	public String getCompLeaderCn() {
		return this.compLeaderCn;
	}

	public void setCompLeaderCn(String compLeaderCn) {
		this.compLeaderCn = compLeaderCn;
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

	public String getIsProject() {
		return isProject;
	}

	public void setIsProject(String isProject) {
		this.isProject = isProject;
	}

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}