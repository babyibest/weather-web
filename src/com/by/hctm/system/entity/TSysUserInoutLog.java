package com.by.hctm.system.entity;

import java.util.Date;

/**
 * TSysUserInoutLog entity. @author MyEclipse Persistence Tools
 */

public class TSysUserInoutLog implements java.io.Serializable {

	// Fields

	private Long uilId;
	private String userLoginName;
	private String userChineseName;
	private String ipAddress;
	private Date loginDate;
	private Date logoutDate;
	private String sessionPath;
	private String lineStatus;
	private String remark;

	// Constructors

	public TSysUserInoutLog(String userLoginName, String userChineseName,
			String ipAddress, String sessionPath, String lineStatus) {
		super();
		this.userLoginName = userLoginName;
		this.userChineseName = userChineseName;
		this.ipAddress = ipAddress;
		this.sessionPath = sessionPath;
		this.lineStatus = lineStatus;
	}

	public TSysUserInoutLog(String userLoginName, String userChineseName,
			String ipAddress, Date loginDate, String sessionPath, String lineStatus) {
		super();
		this.userLoginName = userLoginName;
		this.userChineseName = userChineseName;
		this.ipAddress = ipAddress;
		this.loginDate = loginDate;
		this.sessionPath = sessionPath;
		this.lineStatus = lineStatus;
	}

	/** default constructor */
	public TSysUserInoutLog() {
	}

	/** full constructor */
	public TSysUserInoutLog(String userLoginName, String userChineseName,
			String ipAddress, Date loginDate, Date logoutDate,
			String sessionPath, String lineStatus, String remark) {
		this.userLoginName = userLoginName;
		this.userChineseName = userChineseName;
		this.ipAddress = ipAddress;
		this.loginDate = loginDate;
		this.logoutDate = logoutDate;
		this.sessionPath = sessionPath;
		this.lineStatus = lineStatus;
		this.remark = remark;
	}

	// Property accessors

	public Long getUilId() {
		return this.uilId;
	}

	public void setUilId(Long uilId) {
		this.uilId = uilId;
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

	public Date getLoginDate() {
		return this.loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public Date getLogoutDate() {
		return this.logoutDate;
	}

	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}

	public String getSessionPath() {
		return this.sessionPath;
	}

	public void setSessionPath(String sessionPath) {
		this.sessionPath = sessionPath;
	}

	public String getLineStatus() {
		return this.lineStatus;
	}

	public void setLineStatus(String lineStatus) {
		this.lineStatus = lineStatus;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}