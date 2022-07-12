package com.by.hctm.system.entity;

/**
 * Stages entity. @author MyEclipse Persistence Tools
 */

public class Stages implements java.io.Serializable {

	// Fields

	private Long stageId;
	private String stageCode;
	private String stageName;
	private String belongStandard;
	private Long belongSubjid;
	private Short dispNumber;
	private String remark;
	private String isUsable;
	

	// Constructors

	/** default constructor */
	public Stages() {
	}

	/** minimal constructor */
	public Stages(String stageCode, String stageName, String belongStandard,
			Long belongSubjid) {
		this.stageCode = stageCode;
		this.stageName = stageName;
		this.belongStandard = belongStandard;
		this.belongSubjid = belongSubjid;
	}

	/** full constructor */
	public Stages(String stageCode, String stageName, String belongStandard,
			Long belongSubjid, Short dispNumber, String remark,String isUsable) {
		this.stageCode = stageCode;
		this.stageName = stageName;
		this.belongStandard = belongStandard;
		this.belongSubjid = belongSubjid;
		this.dispNumber = dispNumber;
		this.remark = remark;
		this.isUsable = isUsable;
	}

	// Property accessors

	public Long getStageId() {
		return this.stageId;
	}

	public void setStageId(Long stageId) {
		this.stageId = stageId;
	}

	public String getStageCode() {
		return this.stageCode;
	}

	public void setStageCode(String stageCode) {
		this.stageCode = stageCode;
	}

	public String getStageName() {
		return this.stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public String getBelongStandard() {
		return this.belongStandard;
	}

	public void setBelongStandard(String belongStandard) {
		this.belongStandard = belongStandard;
	}

	public Long getBelongSubjid() {
		return this.belongSubjid;
	}

	public void setBelongSubjid(Long belongSubjid) {
		this.belongSubjid = belongSubjid;
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