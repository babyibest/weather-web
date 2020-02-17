package com.by.hctm.system.entity;

import java.util.Date;

/**
 * ConstructionEquips entity. @author MyEclipse Persistence Tools
 */

public class ConstructionEquips implements java.io.Serializable {

	// Fields

	private Long ceId;
	private String ceCode;
	private String ceName;
	private String ceType;
	private String uom;
	private Long csubjId;
	private String standardName;
	private String standardNumber;
	private String publisher;
	private Date publishDate;
	private String isUsable;

	// Constructors

	/** default constructor */
	public ConstructionEquips() {
	}

	/** minimal constructor */
	public ConstructionEquips(String ceCode, String ceName) {
		this.ceCode = ceCode;
		this.ceName = ceName;
		
	}

	/** full constructor */
	public ConstructionEquips(String ceCode, String ceName, String ceType,
			String uom,Long csubjId, String standardName,
			String standardNumber, String publisher, Date publishDate ,String isUsable) {
		this.ceCode = ceCode;
		this.ceName = ceName;
		this.ceType = ceType;
		this.uom = uom;
		this.csubjId=csubjId;
		this.standardName = standardName;
		this.standardNumber = standardNumber;
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.isUsable  = isUsable;
	}

	// Property accessors

	public Long getCeId() {
		return this.ceId;
	}

	public void setCeId(Long ceId) {
		this.ceId = ceId;
	}

	public String getCeCode() {
		return this.ceCode;
	}

	public void setCeCode(String ceCode) {
		this.ceCode = ceCode;
	}

	public String getCeName() {
		return this.ceName;
	}

	public void setCeName(String ceName) {
		this.ceName = ceName;
	}

	public String getCeType() {
		return this.ceType;
	}

	public void setCeType(String ceType) {
		this.ceType = ceType;
	}

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getStandardName() {
		return this.standardName;
	}

	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}

	public String getStandardNumber() {
		return this.standardNumber;
	}

	public void setStandardNumber(String standardNumber) {
		this.standardNumber = standardNumber;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Long getCsubjId() {
		return csubjId;
	}

	public void setCsubjId(Long csubjId) {
		this.csubjId = csubjId;
	}

	public String getIsUsable() {
		return isUsable;
	}

	public void setIsUsable(String isUsable) {
		this.isUsable = isUsable;
	}

	

}