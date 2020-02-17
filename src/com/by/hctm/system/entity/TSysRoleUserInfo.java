package com.by.hctm.system.entity;

/**
 * TSysRoleUserInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TSysRoleUserInfo implements java.io.Serializable {

	// Fields

	private Long ruId;
	private Long roleId;
	private Long userId;

	// Constructors

	/** default constructor */
	public TSysRoleUserInfo() {
	}

	/** minimal constructor */
	public TSysRoleUserInfo(Long ruId) {
		this.ruId = ruId;
	}

	/** full constructor */
	public TSysRoleUserInfo(Long ruId, Long roleId, Long userId) {
		this.ruId = ruId;
		this.roleId = roleId;
		this.userId = userId;
	}

	// Property accessors

	public Long getRuId() {
		return this.ruId;
	}

	public void setRuId(Long ruId) {
		this.ruId = ruId;
	}

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}