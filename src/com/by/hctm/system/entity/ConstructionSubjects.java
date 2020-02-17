package com.by.hctm.system.entity;

/**
 * ConstructionSubjects entity. @author MyEclipse Persistence Tools
 */

public class ConstructionSubjects implements java.io.Serializable {

	// Fields

	private Long csubjId;
	private String csubjCode;
	private String csubjName;
	private String remark;
	private String isUsable;

	// Constructors

	/** default constructor */
	public ConstructionSubjects() {
	}

	/** minimal constructor */
	public ConstructionSubjects(String csubjCode, String csubjName) {
		this.csubjCode = csubjCode;
		this.csubjName = csubjName;
	}

	/** full constructor */
	public ConstructionSubjects(String csubjCode, String csubjName,
			String remark, String isUsable) {
		this.csubjCode = csubjCode;
		this.csubjName = csubjName;
		this.remark = remark;
		this.isUsable = isUsable;
	}

	// Property accessors

	public Long getCsubjId() {
		return this.csubjId;
	}

	public void setCsubjId(Long csubjId) {
		this.csubjId = csubjId;
	}

	public String getCsubjCode() {
		return this.csubjCode;
	}

	public void setCsubjCode(String csubjCode) {
		this.csubjCode = csubjCode;
	}

	public String getCsubjName() {
		return this.csubjName;
	}

	public void setCsubjName(String csubjName) {
		this.csubjName = csubjName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIsUsable() {
		return isUsable;
	}

	public void setIsUsable(String isUsable) {
		this.isUsable = isUsable;
	}
	

}