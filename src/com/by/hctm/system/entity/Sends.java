package com.by.hctm.system.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Sends entity. @author MyEclipse Persistence Tools
 */

public class Sends implements java.io.Serializable {

	// Fields

	private Long sendId;
	private String title;
	private String content;
	private String ifSms;
	private String sender;
	private Date sendDate;
	private String status;
	private String isUsable;
	private Set <SendReceivers> sendReceivers=new HashSet(0);
	 

	// Constructors

	/** default constructor */
	public Sends() {
	}

	/** full constructor */
	public Sends(String title, String content, String ifSms, String sender,
			Date sendDate, String status,String isUsable) {
		this.title = title;
		this.content = content;
		this.ifSms = ifSms;
		this.sender = sender;
		this.sendDate = sendDate;
		this.status = status;
		this.isUsable = isUsable;
		
	}

	// Property accessors

	public Long getSendId() {
		return this.sendId;
	}

	public void setSendId(Long sendId) {
		this.sendId = sendId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIfSms() {
		return this.ifSms;
	}

	public void setIfSms(String ifSms) {
		this.ifSms = ifSms;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Date getSendDate() {
		return this.sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<SendReceivers> getSendReceivers() {
		return sendReceivers;
	}

	public void setSendReceivers(Set<SendReceivers> sendReceivers) {
		this.sendReceivers = sendReceivers;
	}

	public String getIsUsable() {
		return isUsable;
	}

	public void setIsUsable(String isUsable) {
		this.isUsable = isUsable;
	}

}