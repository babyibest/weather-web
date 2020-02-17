package com.by.hctm.system.entity;

import java.util.Date;

/**
 * TSysRole entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TSysRole implements java.io.Serializable {

	// Fields

	private Long roleId;
	private String roleCode;
	private String roleName;
	private String roleDesc;
	private String isSystemRole;
	private String writer;
	private Date writeDate;
	private String isUsable;

	// Constructors

	/** default constructor */
	public TSysRole() {
	}

	/** full constructor */
	public TSysRole(Long roleId, String roleCode, String roleName,
			String roleDesc, String isSystemRole, String writer,
			Date writeDate, String isUsable) {
		this.roleId = roleId;
		this.roleCode = roleCode;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.isSystemRole = isSystemRole;
		this.writer = writer;
		this.writeDate = writeDate;
		this.isUsable = isUsable;
	}

	// Property accessors

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleCode() {
		return this.roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getIsSystemRole() {
		return this.isSystemRole;
	}

	public void setIsSystemRole(String isSystemRole) {
		this.isSystemRole = isSystemRole;
	}

	public String getWriter() {
		return this.writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getWriteDate() {
		return this.writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getIsUsable() {
		return this.isUsable;
	}

	public void setIsUsable(String isUsable) {
		this.isUsable = isUsable;
	}

}