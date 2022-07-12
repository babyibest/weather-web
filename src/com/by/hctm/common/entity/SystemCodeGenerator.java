package com.by.hctm.common.entity;

/**
 * CodeGenerator entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SystemCodeGenerator implements java.io.Serializable {

	// Fields

	private Long cgId;
	private String cgCode;
	private String cgName;
	private Long currentMaxId;
	private Long maxId;
	private String cgDesc;

	// temp
	// 部门编码(下发部门编码/合同签订部门编码)
	private String deptCode01 ;
	
	// 接收部门编码
	private String deptCode02 ;
	
	// Constructors

	/** default constructor */
	public SystemCodeGenerator() {
	}

	public SystemCodeGenerator(String cgCode) {
		super();
		this.cgCode = cgCode;
	}
	
	public SystemCodeGenerator(String cgCode, String deptCode01) {
		super();
		this.cgCode = cgCode;
		this.deptCode01 = deptCode01;
	}

	public SystemCodeGenerator(String cgCode, String deptCode01,
			String deptCode02) {
		super();
		this.cgCode = cgCode;
		this.deptCode01 = deptCode01;
		this.deptCode02 = deptCode02;
	}

	/** full constructor */
	public SystemCodeGenerator(String cgCode, String cgName, Long currentMaxId,
			Long maxId, String cgDesc) {
		this.cgCode = cgCode;
		this.cgName = cgName;
		this.currentMaxId = currentMaxId;
		this.maxId = maxId;
		this.cgDesc = cgDesc;
	}

	// Property accessors

	public Long getCgId() {
		return this.cgId;
	}

	public void setCgId(Long cgId) {
		this.cgId = cgId;
	}

	public String getCgCode() {
		return this.cgCode;
	}

	public void setCgCode(String cgCode) {
		this.cgCode = cgCode;
	}

	public String getCgName() {
		return this.cgName;
	}

	public void setCgName(String cgName) {
		this.cgName = cgName;
	}

	public Long getCurrentMaxId() {
		return this.currentMaxId;
	}

	public void setCurrentMaxId(Long currentMaxId) {
		this.currentMaxId = currentMaxId;
	}

	public Long getMaxId() {
		return this.maxId;
	}

	public void setMaxId(Long maxId) {
		this.maxId = maxId;
	}

	public String getCgDesc() {
		return this.cgDesc;
	}

	public void setCgDesc(String cgDesc) {
		this.cgDesc = cgDesc;
	}

	public String getDeptCode01() {
		return deptCode01;
	}

	public void setDeptCode01(String deptCode01) {
		this.deptCode01 = deptCode01;
	}

	public String getDeptCode02() {
		return deptCode02;
	}

	public void setDeptCode02(String deptCode02) {
		this.deptCode02 = deptCode02;
	}

}