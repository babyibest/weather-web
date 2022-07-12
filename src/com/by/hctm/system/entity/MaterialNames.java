package com.by.hctm.system.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * MaterialNames entity. @author MyEclipse Persistence Tools
 */

public class MaterialNames implements java.io.Serializable {

	// Fields

	private Long mnId;
	private String mnCode;
	private String mnName;
	private String mnDetail;
	private Short dispNumber;
	private String comeFrom;
	private String ifApprove;
	private String approveId;
	private String ifReply;
	private String ifInput;
	private String inputName;
	private Short amounts;
	private String ifArchive;
	private Long subjId;
	private String subName;
	private Long mtId;
	private String remark;
	private String mtIdName;
	private String inputNameCn;
	private String comeFromCn;
	

	// Constructors



	/** default constructor */
	public MaterialNames() {
	}



	/** minimal constructor */
	public MaterialNames(String mnCode, String mnName) {
		this.mnCode = mnCode;
		this.mnName = mnName;
	}

	/** full constructor */
	public MaterialNames(String mnCode, String mnName, String mnDetail,
			Short dispNumber, String comeFrom, String ifApprove,
			String approveId, String ifReply, String ifInput, String inputName,
			Short amounts, String ifArchive, Long msnId, Long subjId,
			Long mtId, String remark,String mtIdName,String inputNameCn,String comeFromCn) {
		this.mnCode = mnCode;
		this.mnName = mnName;
		this.mnDetail = mnDetail;
		this.dispNumber = dispNumber;
		this.comeFrom = comeFrom;
		this.ifApprove = ifApprove;
		this.approveId = approveId;
		this.ifReply = ifReply;
		this.ifInput = ifInput;
		this.inputName = inputName;
		this.amounts = amounts;
		this.ifArchive = ifArchive;

		this.subjId = subjId;
		this.mtId = mtId;
		this.remark = remark;
		this.mtIdName = mtIdName;
		this.inputNameCn = inputNameCn;
		this.comeFromCn =comeFromCn;
	}

	// Property accessors

	public Long getMnId() {
		return this.mnId;
	}

	public void setMnId(Long mnId) {
		this.mnId = mnId;
	}

	public String getMnCode() {
		return this.mnCode;
	}

	public void setMnCode(String mnCode) {
		this.mnCode = mnCode;
	}

	public String getMnName() {
		return this.mnName;
	}

	public void setMnName(String mnName) {
		this.mnName = mnName;
	}

	public String getMnDetail() {
		return this.mnDetail;
	}

	public void setMnDetail(String mnDetail) {
		this.mnDetail = mnDetail;
	}

	public Short getDispNumber() {
		return this.dispNumber;
	}

	public void setDispNumber(Short dispNumber) {
		this.dispNumber = dispNumber;
	}

	public String getComeFrom() {
		return this.comeFrom;
	}

	public void setComeFrom(String comeFrom) {
		this.comeFrom = comeFrom;
	}

	public String getIfApprove() {
		return this.ifApprove;
	}

	public void setIfApprove(String ifApprove) {
		this.ifApprove = ifApprove;
	}

	public String getApproveId() {
		return this.approveId;
	}

	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}

	public String getIfReply() {
		return this.ifReply;
	}

	public void setIfReply(String ifReply) {
		this.ifReply = ifReply;
	}

	public String getIfInput() {
		return this.ifInput;
	}

	public void setIfInput(String ifInput) {
		this.ifInput = ifInput;
	}

	public String getInputName() {
		return this.inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public Short getAmounts() {
		return this.amounts;
	}

	public void setAmounts(Short amounts) {
		this.amounts = amounts;
	}

	public String getIfArchive() {
		return this.ifArchive;
	}

	public void setIfArchive(String ifArchive) {
		this.ifArchive = ifArchive;
	}


	public Long getSubjId() {
		return this.subjId;
	}

	public void setSubjId(Long subjId) {
		this.subjId = subjId;
	}

	public Long getMtId() {
		return this.mtId;
	}

	public void setMtId(Long mtId) {
		this.mtId = mtId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getMtIdName() {
		return mtIdName;
	}

	public void setMtIdName(String mtIdName) {
		this.mtIdName = mtIdName;
	}

	public String getInputNameCn() {
		return inputNameCn;
	}

	public void setInputNameCn(String inputNameCn) {
		this.inputNameCn = inputNameCn;
	}

	public String getComeFromCn() {
		return comeFromCn;
	}

	public void setComeFromCn(String comeFromCn) {
		this.comeFromCn = comeFromCn;
	}

}