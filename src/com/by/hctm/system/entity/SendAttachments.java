package com.by.hctm.system.entity;

/**
 * SendAttachments entity. @author MyEclipse Persistence Tools
 */

public class SendAttachments implements java.io.Serializable {

	// Fields

	private Long attachId;
	private Long sendId;
	private String attachFilename;
	private String saveFilename;

	// Constructors

	/** default constructor */
	public SendAttachments() {
	}

	/** minimal constructor */
	public SendAttachments(Long sendId) {
		this.sendId = sendId;
	}

	/** full constructor */
	public SendAttachments(Long sendId, String attachFilename,
			String saveFilename) {
		this.sendId = sendId;
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

	public Long getSendId() {
		return this.sendId;
	}

	public void setSendId(Long sendId) {
		this.sendId = sendId;
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