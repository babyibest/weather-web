package com.by.hctm.system.entity;

/**
 * TSysRights entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TSysRights implements java.io.Serializable {

	// Fields

	private Long rightId;
	private String rightCode;
	private String rightName;
	private String belongModule;
	private String remark;
	private String isUsable;

	// Constructors

	/** default constructor */
	public TSysRights() {
	}

	/** minimal constructor */
	public TSysRights(Long rightId, String rightCode, String rightName) {
		this.rightId = rightId;
		this.rightCode = rightCode;
		this.rightName = rightName;
	}

	/** full constructor */
	public TSysRights(Long rightId, String rightCode, String rightName,
			String belongModule, String remark, String isUsable) {
		this.rightId = rightId;
		this.rightCode = rightCode;
		this.rightName = rightName;
		this.belongModule = belongModule;
		this.remark = remark;
		this.isUsable = isUsable;
	}

	// Property accessors

	public Long getRightId() {
		return this.rightId;
	}

	public void setRightId(Long rightId) {
		this.rightId = rightId;
	}

	public String getRightCode() {
		return this.rightCode;
	}

	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}

	public String getRightName() {
		return this.rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public String getBelongModule() {
		return this.belongModule;
	}

	public void setBelongModule(String belongModule) {
		this.belongModule = belongModule;
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

}