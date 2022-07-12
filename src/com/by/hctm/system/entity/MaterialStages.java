package com.by.hctm.system.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * MaterialStages entity. @author MyEclipse Persistence Tools
 */

public class MaterialStages implements java.io.Serializable {

	// Fields

	private Long msId;
	private Long stageId;
	private Long mnId;
	private Short dispNumber;
	
	//private MaterialNames  materialNames;
	//private MaterialNames materialNames;


	// Constructors

	

	/** default constructor */
	public MaterialStages() {
	}


	/** full constructor */
	public MaterialStages(Long stageId, Long mnId, Short dispNumber  ) {
		this.stageId = stageId;
		this.mnId = mnId;
		this.dispNumber = dispNumber;
		
	
	}

	// Property accessors

	public Long getMsId() {
		return this.msId;
	}

	public void setMsId(Long msId) {
		this.msId = msId;
	}

	public Long getStageId() {
		return this.stageId;
	}

	public void setStageId(Long stageId) {
		this.stageId = stageId;
	}

	public Long getMnId() {
		return this.mnId;
	}

	public void setMnId(Long mnId) {
		this.mnId = mnId;
	}

	public Short getDispNumber() {
		return this.dispNumber;
	}

	public void setDispNumber(Short dispNumber) {
		this.dispNumber = dispNumber;
	}

	


	
}