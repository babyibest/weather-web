package com.by.hctm.system.entity;

/**
 * SpuervisionEquips entity. @author MyEclipse Persistence Tools
 */

public class SpuervisionEquips implements java.io.Serializable {

	// Fields

	private Long seId;
	private String seCode;
	private String seName;
	private String seType;
	private String seSet;
	private String remark;

	// Constructors

	/** default constructor */
	public SpuervisionEquips() {
	}

	/** minimal constructor */
	public SpuervisionEquips(String seCode, String seName) {
		this.seCode = seCode;
		this.seName = seName;
	}

	/** full constructor */
	public SpuervisionEquips(String seCode, String seName, String seType,
			String seSet, String remark) {
		this.seCode = seCode;
		this.seName = seName;
		this.seType = seType;
		this.seSet = seSet;
		this.remark = remark;
	}

	// Property accessors

	public Long getSeId() {
		return this.seId;
	}

	public void setSeId(Long seId) {
		this.seId = seId;
	}

	public String getSeCode() {
		return this.seCode;
	}

	public void setSeCode(String seCode) {
		this.seCode = seCode;
	}

	public String getSeName() {
		return this.seName;
	}

	public void setSeName(String seName) {
		this.seName = seName;
	}

	public String getSeType() {
		return this.seType;
	}

	public void setSeType(String seType) {
		this.seType = seType;
	}

	public String getSeSet() {
		return this.seSet;
	}

	public void setSeSet(String seSet) {
		this.seSet = seSet;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}