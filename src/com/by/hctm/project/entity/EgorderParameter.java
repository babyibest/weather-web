package com.by.hctm.project.entity;

import java.math.BigDecimal;

/**
 * Tyxs213 entity. @author MyEclipse Persistence Tools
 */
public class EgorderParameter extends AbstractTyxs213 implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public EgorderParameter() {
	}

	/** minimal constructor */
	public EgorderParameter(Tyxs213Id id, String mobbh) {
		super(id, mobbh);
	}

	/** full constructor */
	public EgorderParameter(Tyxs213Id id, String itemCode, String itemName,
			String optionValue, BigDecimal itemId, String optionCode,
			String mobbh, String optionAdddata) {
		super(id, itemCode, itemName, optionValue, itemId, optionCode, mobbh,
				optionAdddata);
	}

}
