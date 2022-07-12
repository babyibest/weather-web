package com.by.hctm.manpower.entity;

/**
 * CertAttachments entity. @author MyEclipse Persistence Tools
 */

public class CertAttachments implements java.io.Serializable {

	// Fields

	private Long attachId;
	private Long certId;
	private String attachFilename;
	private String saveFilename;

	// Constructors

	/** default constructor */
	public CertAttachments() {
	}

	/** minimal constructor */
	public CertAttachments(Long certId) {
		this.certId = certId;
	}

	/** full constructor */
	public CertAttachments(Long certId, String attachFilename,
			String saveFilename) {
		this.certId = certId;
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

	public Long getCertId() {
		return this.certId;
	}

	public void setCertId(Long certId) {
		this.certId = certId;
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