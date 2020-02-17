package com.by.hctm.manpower.entity;

import java.sql.Timestamp;

/**
 * Certificates entity. @author MyEclipse Persistence Tools
 */

public class Certificates implements java.io.Serializable {

	// Fields

	private Long certId;
	private Users user;
	private String certName;
	private String certNameCn;//中文名（数据库不存在）
	private String certNumber;
	private String certField;
	private String depName;
	private String certFieldCn;//资质中文名（数据库不存在）
	private String certPar;
	private Timestamp startDate;
	private Timestamp endDate;
	private String isUsable;
	private String remark;
	private String registNumber;//注册编号

	// Constructors

	/** default constructor */
	public Certificates() {
	}

	/** minimal constructor */
	public Certificates(Users user, String certName) {
		this.user = user;
		this.certName = certName;
	}

	/** full constructor */
	public Certificates(Long userId, String certName, String certNumber,
			String certField, String certPar, Timestamp startDate,
			Timestamp endDate, String remark, String isUsable, String certFieldCn,String depName,
			String registNumber, String certNameCn) {
		this.user = user;
		this.certName = certName;
		this.certNumber = certNumber;
		this.certField = certField;
		this.certPar = certPar;
		this.startDate = startDate;
		this.endDate = endDate;
		this.remark = remark;
		this.isUsable = isUsable;
		this.certFieldCn = certFieldCn;
		this.depName = depName;
		this.registNumber = registNumber;
		this.certNameCn = certNameCn;
	}

	// Property accessors

	public Long getCertId() {
		return this.certId;
	}

	public void setCertId(Long certId) {
		this.certId = certId;
	}


	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getCertName() {
		return this.certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}

	public String getCertNumber() {
		return this.certNumber;
	}

	public void setCertNumber(String certNumber) {
		this.certNumber = certNumber;
	}

	public String getCertField() {
		return this.certField;
	}

	public void setCertField(String certField) {
		this.certField = certField;
	}

	public String getCertPar() {
		return this.certPar;
	}

	public void setCertPar(String certPar) {
		this.certPar = certPar;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
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

	public String getCertFieldCn() {
		return certFieldCn;
	}

	public void setCertFieldCn(String certFieldCn) {
		this.certFieldCn = certFieldCn;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getRegistNumber() {
		return registNumber;
	}

	public void setRegistNumber(String registNumber) {
		this.registNumber = registNumber;
	}

	public String getCertNameCn() {
		return certNameCn;
	}

	public void setCertNameCn(String certNameCn) {
		this.certNameCn = certNameCn;
	}
    
}