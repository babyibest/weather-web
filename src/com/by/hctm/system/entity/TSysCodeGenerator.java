package com.by.hctm.system.entity;

/**
 * TSysCodeGenerator entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TSysCodeGenerator implements java.io.Serializable {

	// Fields

	private Long cgId;
	private String cgCode;
	private String cgName;
	private Long currentMaxId;
	private Long maxId;
	private String cgDesc;

	// Constructors

	/** default constructor */
	public TSysCodeGenerator() {
	}

	/** minimal constructor */
	public TSysCodeGenerator(Long cgId) {
		this.cgId = cgId;
	}

	/** full constructor */
	public TSysCodeGenerator(Long cgId, String cgCode, String cgName,
			Long currentMaxId, Long maxId, String cgDesc) {
		this.cgId = cgId;
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

}