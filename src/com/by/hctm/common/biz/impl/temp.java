package com.by.hctm.common.biz.impl;


public class temp {
//	/**
//	 * 获取页面附件的URL地址
//	 * @param attachments 附件
//	 * @param viewType 显示类型 0 查看 1 修改
//	 * @param request 
//	 * @author ted Ted 2011-01-05 
//	 * @return
//	 */
//	public String getAttachmentPageUrl( List attachments, String viewType, HttpServletRequest request ) {
//		String attachmentName = "" ;
//		
//		if( attachments !=null && attachments.size()>0 ){
//			for(int i=0; i<attachments.size(); i++){
//				Attachment attachment = (Attachment)attachments.get(i);
//				Long attachmentId 		= attachment.getAttachmentId(); 
//				
//				if( "0".equals( viewType ) ) { // 查看
//					if(i>0 ){
//						attachmentName+="<br>";
//					}
//					attachmentName += "&nbsp;<a href=\""+this.getAttachmentUrl(attachment,request)+"\" target=\"_blank\">"+attachment.getAttachmenetName()+"</a>" ;
//				}else if( "a".equals( viewType ) ){  //已上传  dq add 2011-06-11
//					if(i>0 ){
//						attachmentName+="<br>";
//					}
//					attachmentName += "<a href=\""+this.getAttachmentUrl(attachment,request)+"\" target=\"_blank\">"+"已上传"+"</a>" ;
//				}else if( "b".equals( viewType ) ){  //供方管理授权书 BY-2011年7月20日 09:46:16
//  					if(i>0 ){
//						attachmentName+="<br>";
//					}
//					attachmentName += "<a href=\""+this.getAttachmentUrl(attachment,request)+"\" target=\"_blank\">"+"授权书"+"</a>" ;
//				}
//				
//				else { // 修改
//					attachmentName	+= " <div id=\"" + attachmentId + "\"> <a href=\"" + this.getAttachmentUrl(attachment,request) + "\">" + attachment.getAttachmenetName() + "</a>&nbsp;" ;
//					attachmentName	+= " <a href='#' onClick=\"removeAttachment('" + attachmentId + "');\">" + " <font color=#ff0000>删除</font></a> </div> " ;
//				}
//			}
//		}
//		
//		return attachmentName ;
//	
//	}
//	
//	/**
//	 * 获取页面附件的URL地址 (多个附件类型增加删除方法类型)
//	 * @param attachments 附件
//	 * @param viewType 显示类型 0 查看 1 修改
//	 * @param methodType 删除方法(js) 
//	 * @param request 
//	 * @author ted Ted 2011-01-05 
//	 * @return
//	 */
//	public String getAttachmentPageUrl( List attachments, String viewType, String methodType, HttpServletRequest request ) {
//		String attachmentName = "" ;
//		
//		if( attachments !=null && attachments.size()>0 ){
//			for(int i=0; i<attachments.size(); i++){
//				Attachment attachment = (Attachment)attachments.get(i);
//				Long attachmentId 		= attachment.getAttachmentId(); 
//				
//				if( "0".equals( viewType ) ) { // 查看
//					if(i>0 ){
//						attachmentName+="<br>";
//					}
//					attachmentName += "&nbsp;<a href=\""+this.getAttachmentUrl(attachment,request)+"\" target=\"_blank\">"+attachment.getAttachmenetName()+"</a>" ;
//				
//				}else { // 修改
//					attachmentName	+= " <div id=\"" + attachmentId + "\"> <a href=\"" + this.getAttachmentUrl(attachment,request) + "\">" + attachment.getAttachmenetName() + "</a>&nbsp;" ;
//					attachmentName	+= " <a href='#' onClick=\"" + methodType + "('" + attachmentId + "');\">" + " <font color=#ff0000>删除</font></a> </div> " ;
//				}
//			}
//		}
//		
//		return attachmentName ;
//	
//	}
//
//	/**
//	 * 保存上传附件
//	 * @param dto 附件相关参数 附件formfiles、对象IDobjectId、
//	 * 	附件代码attcode、附件类型class、相对路径abspath
//	 * @author ted ted 2011-05-28 
//	 * @throws BaseException
//	 */
//	public void saveAttachment( AttachmentDTO dto )
//			throws BaseException {
//		
//		String objectName = "" ;
//		if( dto != null ) {
//			if( dto.getFormFiles() != null && dto.getFormFiles().size()> 0 ) {
//				
//				for (int i = 0; i < dto.getFormFiles().size(); i++) {
//					FormFile file = (FormFile) dto.getFormFiles().get(i);
//					objectName = StringUtil.getClassName( dto.getClazz() );
//					
//					if (dto.getFormFiles() == null || file.getFileName() == null
//							|| file.getFileName().equals("")) {
//						return;
//					}
//					
//					if( dto.getObjectId() != null && dto.getObjectId().length()>0
//							&& dto.getAttCode() != null && dto.getAttCode().length()>0 ) {
//						Attachment attachment = new Attachment();
//						save(attachment);
//
//						attachment.setAttachmenetName(file.getFileName());
//						attachment.setAttachmentType( objectName );
//						attachment.setAttachmentTypeId( new Long( dto.getObjectId() ) );
//						attachment.setWriteDate(new Date());
//
//						attachment.setAttachmentField( dto.getAttCode() );
//
//						// 上传到本机，如果没有环境是，开发时可用这代替
//						// String fileName = FileUtil.writeFile(formFile.getInputStream(),
//						// getAttachmentRealPath(attachment)+attachment.getAttachmenetName(),
//						// true);
//						// 过ftp协议上传
//						FtpUtil ftpUtil = new FtpUtil();
//						String fileName = ftpUtil.upload( getAttachmentRealPath( attachment, dto.getAbsPath() ), file
//								.getInputStream(), FtpUtil.getOperatorFileName(attachment), true);
//
//						this.updateAttachment( attachment );
//					}
//				}
//			}
//		} 
//	}
}
