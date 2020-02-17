package com.by.hctm.system.entity;

/**
 * Subjects entity. @author MyEclipse Persistence Tools
 */

public class Subjects implements java.io.Serializable {

	// Fields

	private Long subjId;
	private String subjCode;
	private String subjName;
	private String belongStandard;
	private String remark;
	private Long standardId;
	private String isUsable;
	private Short dispNumber;

	// Constructors

	/** default constructor */
	public Subjects() {
	}

	/** minimal constructor */
	public Subjects(String subjCode, String subjName) {
		this.subjCode = subjCode;
		this.subjName = subjName;
	}

	/** full constructor */
	public Subjects(String subjCode, String subjName, String belongStandard,
			String remark, Long standardId,String isUsable,Short dispNumber) {
		this.subjCode = subjCode;
		this.subjName = subjName;
		this.belongStandard = belongStandard;
		this.remark = remark;
		this.standardId = standardId;
		this.isUsable = isUsable;
		this.dispNumber =dispNumber;
	}

	// Property accessors

	public Long getSubjId() {
		return this.subjId;
	}

	public void setSubjId(Long subjId) {
		this.subjId = subjId;
	}

	public String getSubjCode() {
		return this.subjCode;
	}

	public void setSubjCode(String subjCode) {
		this.subjCode = subjCode;
	}

	public String getSubjName() {
		return this.subjName;
	}

	public void setSubjName(String subjName) {
		this.subjName = subjName;
	}

	public String getBelongStandard() {
		return this.belongStandard;
	}

	public void setBelongStandard(String belongStandard) {
		this.belongStandard = belongStandard;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getStandardId() {
		return this.standardId;
	}

	public void setStandardId(Long standardId) {
		this.standardId = standardId;
	}

	public String getIsUsable() {
		return isUsable;
	}

	public void setIsUsable(String isUsable) {
		this.isUsable = isUsable;
	}

	public Short getDispNumber() {
		return dispNumber;
	}

	public void setDispNumber(Short dispNumber) {
		this.dispNumber = dispNumber;
	}
	
}