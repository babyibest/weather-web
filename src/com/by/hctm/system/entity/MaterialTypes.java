package com.by.hctm.system.entity;

/**
 * MaterialTypes entity. @author MyEclipse Persistence Tools
 */

public class MaterialTypes implements java.io.Serializable {

	// Fields

	private Long mtId;
	private String mtCode;
	private String mtName;
	private String mtDetail;
	private Short dispNumber;
	private String remark;
	private String isUsable;

	// Constructors

	/** default constructor */
	public MaterialTypes() {
	}

	/** minimal constructor */
	public MaterialTypes(String mtCode, String mtName) {
		this.mtCode = mtCode;
		this.mtName = mtName;
	}

	/** full constructor */
	public MaterialTypes(String mtCode, String mtName, String mtDetail,
			Short dispNumber, String remark ,String isUsable) {
		this.mtCode = mtCode;
		this.mtName = mtName;
		this.mtDetail = mtDetail;
		this.dispNumber = dispNumber;
		this.remark = remark;
		this.isUsable = isUsable;
	}

	// Property accessors

	public Long getMtId() {
		return this.mtId;
	}

	public void setMtId(Long mtId) {
		this.mtId = mtId;
	}

	public String getMtCode() {
		return this.mtCode;
	}

	public void setMtCode(String mtCode) {
		this.mtCode = mtCode;
	}

	public String getMtName() {
		return this.mtName;
	}

	public void setMtName(String mtName) {
		this.mtName = mtName;
	}

	public String getMtDetail() {
		return this.mtDetail;
	}

	public void setMtDetail(String mtDetail) {
		this.mtDetail = mtDetail;
	}

	public Short getDispNumber() {
		return this.dispNumber;
	}

	public void setDispNumber(Short dispNumber) {
		this.dispNumber = dispNumber;
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