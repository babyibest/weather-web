package com.by.hctm.system.entity;

import java.util.Date;

/**
 * Notices entity. @author MyEclipse Persistence Tools
 */

public class Notices implements java.io.Serializable {

	// Fields

	private Long noticeId;
	private String title;
	private String content;
	private String keyword;
	private String type;
	private String publisher;
	private Long publisherDepartment;
	private Date publishDate;
	private String remark;
	private String isUsable;

	// Constructors

	/** default constructor */
	public Notices() {
	}

	/** full constructor */
	public Notices(String title, String content, String keyword, String type,
			String publisher, Long publisherDepartment, Date publishDate,
			String remark,String isUsable) {
		this.title = title;
		this.content = content;
		this.keyword = keyword;
		this.type = type;
		this.publisher = publisher;
		this.publisherDepartment = publisherDepartment;
		this.publishDate = publishDate;
		this.remark = remark;
		this.isUsable = isUsable;
	}

	// Property accessors

	public Long getNoticeId() {
		return this.noticeId;
	}

	public void setNoticeId(Long noticeId) {
		this.noticeId = noticeId;
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

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Long getPublisherDepartment() {
		return this.publisherDepartment;
	}

	public void setPublisherDepartment(Long publisherDepartment) {
		this.publisherDepartment = publisherDepartment;
	}

	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
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
	
}