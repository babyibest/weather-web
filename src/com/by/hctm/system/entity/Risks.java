package com.by.hctm.system.entity;

/**
 * Risks entity. @author MyEclipse Persistence Tools
 */

public class Risks implements java.io.Serializable {

	// Fields

	private Long riskId;
	private Long stageId;
	private String stageType;
	private String riskName;
	private String econtent;
	private String position;
	private String elevel;
	private String preventMeasure;
	private String isUsable;

	// Constructors

	/** default constructor */
	public Risks() {
	}

	/** minimal constructor */
	public Risks(Long stageId) {
		this.stageId = stageId;
	}

	/** full constructor */
	public Risks(Long stageId, String stageType, String riskName,
			String econtent, String position, String elevel,
			String preventMeasure,String isUsable) {
		this.stageId = stageId;
		this.stageType = stageType;
		this.riskName = riskName;
		this.econtent = econtent;
		this.position = position;
		this.elevel = elevel;
		this.preventMeasure = preventMeasure;
		this.isUsable = isUsable;
	}

	// Property accessors

	public Long getRiskId() {
		return this.riskId;
	}

	public void setRiskId(Long riskId) {
		this.riskId = riskId;
	}

	public Long getStageId() {
		return this.stageId;
	}

	public void setStageId(Long stageId) {
		this.stageId = stageId;
	}

	public String getStageType() {
		return this.stageType;
	}

	public void setStageType(String stageType) {
		this.stageType = stageType;
	}

	public String getRiskName() {
		return this.riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public String getEcontent() {
		return this.econtent;
	}

	public void setEcontent(String econtent) {
		this.econtent = econtent;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getElevel() {
		return this.elevel;
	}

	public void setElevel(String elevel) {
		this.elevel = elevel;
	}

	public String getPreventMeasure() {
		return this.preventMeasure;
	}

	public void setPreventMeasure(String preventMeasure) {
		this.preventMeasure = preventMeasure;
	}

	public String getIsUsable() {
		return isUsable;
	}

	public void setIsUsable(String isUsable) {
		this.isUsable = isUsable;
	}

}