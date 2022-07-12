package com.by.hctm.system.entity;

import java.util.Date;

/**
 * TSysUserOperLog entity. @author MyEclipse Persistence Tools
 */

public class TSysUserOperLog implements java.io.Serializable {

	// Fields

	private Long uolId;
	private String userLoginName;
	private String userChineseName;
	private String ipAddress;
	private Date operDate;
	private Long operModule;
	private String operBrief;
	private String operInfo;
	private String remark;

	// Constructors

	/** default constructor */
	public TSysUserOperLog() {
	}

	/** full constructor */
	public TSysUserOperLog(String userLoginName, String userChineseName,
			String ipAddress, Date operDate, Long operModule,
			String operBrief, String operInfo, String remark) {
		this.userLoginName = userLoginName;
		this.userChineseName = userChineseName;
		this.ipAddress = ipAddress;
		this.operDate = operDate;
		this.operModule = operModule;
		this.operBrief = operBrief;
		this.operInfo = operInfo;
		this.remark = remark;
	}

	// Property accessors

	public Long getUolId() {
		return this.uolId;
	}

	public void setUolId(Long uolId) {
		this.uolId = uolId;
	}

	public String getUserLoginName() {
		return this.userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getUserChineseName() {
		return this.userChineseName;
	}

	public void setUserChineseName(String userChineseName) {
		this.userChineseName = userChineseName;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getOperDate() {
		return this.operDate;
	}

	public void setOperDate(Date operDate) {
		this.operDate = operDate;
	}

	public Long getOperModule() {
		return this.operModule;
	}

	public void setOperModule(Long operModule) {
		this.operModule = operModule;
	}

	public String getOperBrief() {
		return this.operBrief;
	}

	public void setOperBrief(String operBrief) {
		this.operBrief = operBrief;
	}

	public String getOperInfo() {
		return this.operInfo;
	}

	public void setOperInfo(String operInfo) {
		this.operInfo = operInfo;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}