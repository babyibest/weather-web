package com.by.hctm.common.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.TableStatus;
import com.by.hctm.common.biz.IAttachmentBiz;
import com.by.hctm.common.entity.Attachment;
import com.by.hctm.common.utils.FtpUtil;

public class AttachmentDownloadAction extends BaseAction {
						
	private static final Log log = LogFactory.getLog(AttachmentDownloadAction.class);
	private IAttachmentBiz iAttachmentBiz ;
	private Attachment attach ;
	
	private File uploadify;   
	private String uploadifyContentType;   
	private String uploadifyFileName; 
	
	/**   
	  * 配合uploadify插件使用的上传方法。   
	  * @author ted   
	  * @return   
	  * @throws Exception    
	*/   
    private String uploadify() throws Exception {   
    	Date date = new Date();   
    	DateFormat df = new SimpleDateFormat("yyyy-M-d");   
    	String today = df.format(date);   
    	String path = "/upload/audio/powerword/" + today;  
    	
    	File folder = new File(ServletActionContext.getServletContext().getRealPath(path));   
    	String filePath = path + "/" + UUID.randomUUID().toString().replaceAll("-", "") + ".mp3";   
    	if (!folder.exists())   
    		folder.mkdirs();   
 
    	File outFile = new File( this.getServletContext().getRealPath(filePath));   
    	FileOutputStream outStream = new FileOutputStream(outFile);   
    	FileInputStream inStream = new FileInputStream(uploadify);   
    	
    	byte[] buffer = new byte[1024];   
    	int l = 0;   
    	while ((l = inStream.read(buffer)) > 0) {   
    		outStream.write(buffer, 0, l);   
    	}   
    	inStream.close();   
    	outStream.close();   
    	return filePath;   
    }   
	
	/**
	 * 下载附件-公用方法
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws Exception
	 */
	public String download( ) throws BaseException { 
		
		// http://localhost:8084/jbzx/download_down.action?attach.attachmentId=11&attach.attachmentField=01
		FtpUtil ftpUtil = new FtpUtil();
		try {
			
			this.getRequest().setCharacterEncoding("utf-8");
			
			String filerealpath = "";
			String filename = "";
			// -------------------------下载普通附件----------------------------------------------------
//			String attachmentId = this.getRequest().getParameter("attachmentId");
			
			// 文件相对路径 Ted 2011-06-02
//			String attcode = StringUtil.convertNullToBlank(  this.getRequest().getParameter("execPath") );
			
			// 附件存放在attachment标中，
			if ( attach != null) {
				
				// 如果执行的是下载操作
				Attachment attachment = iAttachmentBiz.getAttachment( attach.getAttachmentId() ) ; 
				
				if( TableStatus.ATTACHMENT_CODE_07.equals( attach.getAttachmentField() ) ) { // 回标-供方原始报价清单
//					filerealpath = iAttachmentBiz.getAttachmentRealPath( attachment, GlobalSetting.getNetbidprice_srcfile_upload_location() );
					
				}else if( TableStatus.ATTACHMENT_CODE_08.equals( attach.getAttachmentField() ) ) { // 回标-供方加密后报价清单 
//					filerealpath = iAttachmentBiz.getAttachmentRealPath( attachment, GlobalSetting.getNetbidprice_encryptfile_upload_location() );
					
				}else if( TableStatus.ATTACHMENT_CODE_09.equals( attach.getAttachmentField() ) ) { // 回标-供方解密后报价清单
//					filerealpath = iAttachmentBiz.getAttachmentRealPath( attachment, GlobalSetting.getNetbidprice_decryptfile_upload_location() );
					
				}else{
					filerealpath = iAttachmentBiz.getAttachmentPath( attachment );
				}
				
				filename = FtpUtil.getOperatorFileName(attachment);
//					filename = FtpUtil.getOperatorFileNameNoExtendName(attachment);
//					System.out.println(" filename = " + filename  ) ;
				
				if(!ftpUtil.download(filerealpath, filename,attachment.getAttachmenetName(), this.getResponse() )){
					//下载失败，文件不存在
					getResponse().sendError(404, "文件不存在");
				}
				
			}
			
			log.debug("开始返回 了");
		} catch (Exception iox) {
			log(" 下载附件错误！", iox);
			throw new BaseException(" 下载附件错误！", iox);

		}
		
		return null ;
	}

	public IAttachmentBiz getIAttachmentBiz() {
		return iAttachmentBiz;
	}

	public void setIAttachmentBiz(IAttachmentBiz attachmentBiz) {
		iAttachmentBiz = attachmentBiz;
	}

	public Attachment getAttach() {
		return attach;
	}

	public void setAttach(Attachment attach) {
		this.attach = attach;
	}
	
}