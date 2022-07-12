package com.by.base.entity;

import java.io.File;
import java.io.Serializable;

/**
 * Base class for Model objects. Child objects should implement toString(),
 * equals() and hashCode();
 */
public abstract class BaseObject implements Serializable {

	private File []   uploadFiles ;
	
	private String [] uploadFilesContentType ;
	
	private String [] uploadFilesFileName ;
	
	public File[] getUploadFiles() {
		return uploadFiles;
	}

	public void setUploadFiles(File[] uploadFiles) {
		this.uploadFiles = uploadFiles;
	}

	public String[] getUploadFilesContentType() {
		return uploadFilesContentType;
	}

	public void setUploadFilesContentType(String[] uploadFilesContentType) {
		this.uploadFilesContentType = uploadFilesContentType;
	}

	public String[] getUploadFilesFileName() {
		return uploadFilesFileName;
	}

	public void setUploadFilesFileName(String[] uploadFilesFileName) {
		this.uploadFilesFileName = uploadFilesFileName;
	}
	
}
