package com.by.hctm.project.entity;

import java.math.BigDecimal;

/**
 * AbstractTyxs213 entity provides the base persistence definition of the
 * Tyxs213 entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTyxs213 implements java.io.Serializable {

	// Fields

	private Tyxs213Id id;
	private String itemCode;
	private String itemName;
	private String optionValue;
	private BigDecimal itemId;
	private String optionCode;
	private String mobbh;
	private String optionAdddata;

	// Constructors

	/** default constructor */
	public AbstractTyxs213() {
	}

	/** minimal constructor */
	public AbstractTyxs213(Tyxs213Id id, String mobbh) {
		this.id = id;
		this.mobbh = mobbh;
	}

	/** full constructor */
	public AbstractTyxs213(Tyxs213Id id, String itemCode, String itemName,
			String optionValue, BigDecimal itemId, String optionCode,
			String mobbh, String optionAdddata) {
		this.id = id;
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.optionValue = optionValue;
		this.itemId = itemId;
		this.optionCode = optionCode;
		this.mobbh = mobbh;
		this.optionAdddata = optionAdddata;
	}

	// Property accessors

	public Tyxs213Id getId() {
		return this.id;
	}

	public void setId(Tyxs213Id id) {
		this.id = id;
	}

	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getOptionValue() {
		return this.optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public BigDecimal getItemId() {
		return this.itemId;
	}

	public void setItemId(BigDecimal itemId) {
		this.itemId = itemId;
	}

	public String getOptionCode() {
		return this.optionCode;
	}

	public void setOptionCode(String optionCode) {
		this.optionCode = optionCode;
	}

	public String getMobbh() {
		return this.mobbh;
	}

	public void setMobbh(String mobbh) {
		this.mobbh = mobbh;
	}

	public String getOptionAdddata() {
		return this.optionAdddata;
	}

	public void setOptionAdddata(String optionAdddata) {
		this.optionAdddata = optionAdddata;
	}

}