package com.by.hctm.system.entity;

import java.util.Date;

/**
 * Messages entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Messages implements java.io.Serializable {

	// Fields

	private Long smsId;
	private String receiverName;
	private String receiverMobil;
	private String sendContent;
	private String ifSucess;
	private String senderUsername;
	private String senderChinesename;
	private Date senderDate;
	private String replyContent;
	private Date replyDate;
	private String smsCode;

	// Constructors

	/** default constructor */
	public Messages() {
	}

	/** minimal constructor */
	public Messages(Long smsId, String sendContent) {
		this.smsId = smsId;
		this.sendContent = sendContent;
	}

	/** full constructor */
	public Messages(Long smsId, String receiverName, String receiverMobil,
			String sendContent, String ifSucess, String senderUsername,
			String senderChinesename, Date senderDate, String replyContent,
			Date replyDate, String smsCode) {
		this.smsId = smsId;
		this.receiverName = receiverName;
		this.receiverMobil = receiverMobil;
		this.sendContent = sendContent;
		this.ifSucess = ifSucess;
		this.senderUsername = senderUsername;
		this.senderChinesename = senderChinesename;
		this.senderDate = senderDate;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.smsCode = smsCode;
	}

	// Property accessors

	public Long getSmsId() {
		return this.smsId;
	}

	public void setSmsId(Long smsId) {
		this.smsId = smsId;
	}

	public String getReceiverName() {
		return this.receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverMobil() {
		return this.receiverMobil;
	}

	public void setReceiverMobil(String receiverMobil) {
		this.receiverMobil = receiverMobil;
	}

	public String getSendContent() {
		return this.sendContent;
	}

	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}

	public String getIfSucess() {
		return this.ifSucess;
	}

	public void setIfSucess(String ifSucess) {
		this.ifSucess = ifSucess;
	}

	public String getSenderUsername() {
		return this.senderUsername;
	}

	public void setSenderUsername(String senderUsername) {
		this.senderUsername = senderUsername;
	}

	public String getSenderChinesename() {
		return this.senderChinesename;
	}

	public void setSenderChinesename(String senderChinesename) {
		this.senderChinesename = senderChinesename;
	}

	public Date getSenderDate() {
		return this.senderDate;
	}

	public void setSenderDate(Date senderDate) {
		this.senderDate = senderDate;
	}

	public String getReplyContent() {
		return this.replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyDate() {
		return this.replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public String getSmsCode() {
		return this.smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

}