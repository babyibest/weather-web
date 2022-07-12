package com.by.hctm.common.utils;

import java.io.FileInputStream;

import net.sf.jftp.net.ConnectionListener;

import com.by.base.utils.FtpUtilBase;
import com.by.hctm.common.entity.Attachment;

public class FtpUtil extends FtpUtilBase implements ConnectionListener  {

	 
	/**
	 * 
	 * @param attachment
	 * @return
	 */
	public static String getOperatorFileName(Attachment attachment) {
		if (attachment == null) {
			return "file.file";

		}
		String extendName = "";
		int index = attachment.getAttachmenetName().lastIndexOf(".");
		if (index > -1) {
			extendName = attachment.getAttachmenetName().substring(index);

		}
		return attachment.getAttachmentId() + extendName;

	}
	
	/**
	 * 
	 * @param attachment
	 * @return
	 */
	public static String getOperatorFileNameNoExtendName(Attachment attachment) {
		if (attachment == null) {
			return "file.file";

		}
//		String extendName = "";
//		int index = attachment.getAttachmenetName().lastIndexOf(".");
//		if (index > -1) {
//			extendName = attachment.getAttachmenetName().substring(index);
//
//		}
		return attachment.getAttachmentId().toString() ;

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileInputStream ss;
		try {
			ss = new FileInputStream("D:\\导出.rar");

			FtpUtilBase ftp = new FtpUtil();
			ftp.connectServer();
			ftp.uploadfile("/第一/第二/三/斯/五/", ss, "导出.rar", true);
			ftp.closeConnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
