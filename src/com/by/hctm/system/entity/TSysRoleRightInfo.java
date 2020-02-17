package com.by.hctm.system.entity;

/**
 * TSysRoleRightInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TSysRoleRightInfo implements java.io.Serializable {

	// Fields

	private Long rrId;
	private Long roleId;
	private Long rightId;

	// Constructors

	/** default constructor */
	public TSysRoleRightInfo() {
	}

	/** minimal constructor */
	public TSysRoleRightInfo(Long rrId) {
		this.rrId = rrId;
	}

	/** full constructor */
	public TSysRoleRightInfo(Long rrId, Long roleId, Long rightId) {
		this.rrId = rrId;
		this.roleId = roleId;
		this.rightId = rightId;
	}

	// Property accessors

	public Long getRrId() {
		return this.rrId;
	}

	public void setRrId(Long rrId) {
		this.rrId = rrId;
	}

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getRightId() {
		return this.rightId;
	}

	public void setRightId(Long rightId) {
		this.rightId = rightId;
	}

}