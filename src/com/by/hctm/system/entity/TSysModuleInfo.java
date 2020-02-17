package com.by.hctm.system.entity;

import java.util.Date;

/**
 * TSysModuleInfo entity. @author MyEclipse Persistence Tools
 */

public class TSysModuleInfo implements java.io.Serializable {

	// Fields

	private Long moduleId;
	private String moduleCode;
	private String moduleName;
	private Long upModuleId;
	private String moduleUrl;
	private Long moduleOrder;
	private String isLeaf;
	private String isModule;
	private String isUsable;
	private String isHaveChild;
	private String selflevCode;
	private Long moduleLevel;
	private String remark;
	private String other;
	private String writer;
	private Date writeDate;

	// Constructors

	/** default constructor */
	public TSysModuleInfo() {
	}

	/** full constructor */
	public TSysModuleInfo(String moduleCode, String moduleName,
			Long upModuleId, String moduleUrl, Long moduleOrder,
			String isLeaf, String isModule, String isUsable,
			String isHaveChild, String selflevCode, Long moduleLevel,
			String remark, String other, String writer, Date writeDate) {
		this.moduleCode = moduleCode;
		this.moduleName = moduleName;
		this.upModuleId = upModuleId;
		this.moduleUrl = moduleUrl;
		this.moduleOrder = moduleOrder;
		this.isLeaf = isLeaf;
		this.isModule = isModule;
		this.isUsable = isUsable;
		this.isHaveChild = isHaveChild;
		this.selflevCode = selflevCode;
		this.moduleLevel = moduleLevel;
		this.remark = remark;
		this.other = other;
		this.writer = writer;
		this.writeDate = writeDate;
	}

	// Property accessors

	public Long getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleCode() {
		return this.moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Long getUpModuleId() {
		return this.upModuleId;
	}

	public void setUpModuleId(Long upModuleId) {
		this.upModuleId = upModuleId;
	}

	public String getModuleUrl() {
		return this.moduleUrl;
	}

	public void setModuleUrl(String moduleUrl) {
		this.moduleUrl = moduleUrl;
	}

	public Long getModuleOrder() {
		return this.moduleOrder;
	}

	public void setModuleOrder(Long moduleOrder) {
		this.moduleOrder = moduleOrder;
	}

	public String getIsLeaf() {
		return this.isLeaf;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getIsModule() {
		return this.isModule;
	}

	public void setIsModule(String isModule) {
		this.isModule = isModule;
	}

	public String getIsUsable() {
		return this.isUsable;
	}

	public void setIsUsable(String isUsable) {
		this.isUsable = isUsable;
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

	public Long getModuleLevel() {
		return this.moduleLevel;
	}

	public void setModuleLevel(Long moduleLevel) {
		this.moduleLevel = moduleLevel;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getWriter() {
		return this.writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getWriteDate() {
		return this.writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

}