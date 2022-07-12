package com.by.hctm.system.entity;

/**
 * NoticeAttachments entity. @author MyEclipse Persistence Tools
 */

public class NoticeAttachments implements java.io.Serializable {

	// Fields

	private Long attachId;
	private Long noticeId;
	private String attachFilename;
	private String saveFilename;

	// Constructors

	/** default constructor */
	public NoticeAttachments() {
	}

	/** minimal constructor */
	public NoticeAttachments(Long noticeId) {
		this.noticeId = noticeId;
	}

	/** full constructor */
	public NoticeAttachments(Long noticeId, String attachFilename,
			String saveFilename) {
		this.noticeId = noticeId;
		this.attachFilename = attachFilename;
		this.saveFilename = saveFilename;
	}

	// Property accessors

	public Long getAttachId() {
		return this.attachId;
	}

	public void setAttachId(Long attachId) {
		this.attachId = attachId;
	}

	public Long getNoticeId() {
		return this.noticeId;
	}

	public void setNoticeId(Long noticeId) {
		this.noticeId = noticeId;
	}

	public String getAttachFilename() {
		return this.attachFilename;
	}

	public void setAttachFilename(String attachFilename) {
		this.attachFilename = attachFilename;
	}

	public String getSaveFilename() {
		return this.saveFilename;
	}

	public void setSaveFilename(String saveFilename) {
		this.saveFilename = saveFilename;
	}

}