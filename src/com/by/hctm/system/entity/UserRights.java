package com.by.hctm.system.entity;

/**
 * UserRights entity. @author MyEclipse Persistence Tools
 */

public class UserRights implements java.io.Serializable {

	// Fields

	private Long userId;
	private String userChinesename;
	private String rightId;
	private String rightName;
	private String belongModule;

	// Constructors

	/** default constructor */
	public UserRights() {
	}

	/** full constructor */
	public UserRights(String userChinesename, String rightId, String rightName,
			String belongModule) {
		this.userChinesename = userChinesename;
		this.rightId = rightId;
		this.rightName = rightName;
		this.belongModule = belongModule;
	}

	// Property accessors

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserChinesename() {
		return this.userChinesename;
	}

	public void setUserChinesename(String userChinesename) {
		this.userChinesename = userChinesename;
	}

	public String getRightId() {
		return this.rightId;
	}

	public void setRightId(String rightId) {
		this.rightId = rightId;
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

}