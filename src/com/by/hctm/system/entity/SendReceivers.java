package com.by.hctm.system.entity;

import java.util.Date;

/**
 * SendReceivers entity. @author MyEclipse Persistence Tools
 */

public class SendReceivers implements java.io.Serializable {

	// Fields

	private Long srId;
	private Long sendId;
	private String receiver;
	private String receiverType;
	private String replyContent;
	private Date replyDate;
	private Sends sends;
	private String isUsable;

	// Constructors

	/** default constructor */
	public SendReceivers() {
	}

	/** minimal constructor */
	public SendReceivers(Long sendId) {
		this.sendId = sendId;
	}

	/** full constructor */
	public SendReceivers(Long sendId, String receiver, String receiverType,
			String replyContent, Date replyDate,String isUsable) {
		this.sendId = sendId;
		this.receiver = receiver;
		this.receiverType = receiverType;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.isUsable = isUsable;
	}

	// Property accessors

	public Long getSrId() {
		return this.srId;
	}

	public void setSrId(Long srId) {
		this.srId = srId;
	}

	public Long getSendId() {
		return this.sendId;
	}

	public void setSendId(Long sendId) {
		this.sendId = sendId;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getReceiverType() {
		return this.receiverType;
	}

	public void setReceiverType(String receiverType) {
		this.receiverType = receiverType;
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

	public Sends getSends() {
		return sends;
	}

	public void setSends(Sends sends) {
		this.sends = sends;
	}

	public String getIsUsable() {
		return isUsable;
	}

	public void setIsUsable(String isUsable) {
		this.isUsable = isUsable;
	}

	

}