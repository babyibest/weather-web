package com.by.hctm.system.entity;

/**
 * EquipWitness entity. @author MyEclipse Persistence Tools
 */

public class EquipWitness implements java.io.Serializable {

	// Fields

	private Long ewId;
	private String ceId;
	private String witType;
	private String witItem;
	private String witContent;
	private String witWay;
	private String witMethod;
	private String remark;

	// Constructors

	/** default constructor */
	public EquipWitness() {
	}

	/** minimal constructor */
	public EquipWitness(String ceId) {
		this.ceId = ceId;
	}

	/** full constructor */
	public EquipWitness(String ceId, String witType, String witItem,
			String witContent, String witWay, String witMethod, String remark) {
		this.ceId = ceId;
		this.witType = witType;
		this.witItem = witItem;
		this.witContent = witContent;
		this.witWay = witWay;
		this.witMethod = witMethod;
		this.remark = remark;
	}

	// Property accessors

	public Long getEwId() {
		return this.ewId;
	}

	public void setEwId(Long ewId) {
		this.ewId = ewId;
	}

	public String getCeId() {
		return this.ceId;
	}

	public void setCeId(String ceId) {
		this.ceId = ceId;
	}

	public String getWitType() {
		return this.witType;
	}

	public void setWitType(String witType) {
		this.witType = witType;
	}

	public String getWitItem() {
		return this.witItem;
	}

	public void setWitItem(String witItem) {
		this.witItem = witItem;
	}

	public String getWitContent() {
		return this.witContent;
	}

	public void setWitContent(String witContent) {
		this.witContent = witContent;
	}

	public String getWitWay() {
		return this.witWay;
	}

	public void setWitWay(String witWay) {
		this.witWay = witWay;
	}

	public String getWitMethod() {
		return this.witMethod;
	}

	public void setWitMethod(String witMethod) {
		this.witMethod = witMethod;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}