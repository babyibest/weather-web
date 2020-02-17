package com.by.hctm.common.biz.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.entity.BaseAttachment;
import com.by.base.exception.BaseException;
import com.by.hctm.common.biz.IAttachmentBiz;
import com.by.hctm.common.entity.Attachment;
import com.by.hctm.common.utils.DateUtil;
import com.by.hctm.common.utils.FtpUtil;
import com.by.hctm.common.utils.GlobalSetting;
import com.by.hctm.common.utils.StringUtil;
public class AttachmentManagerImpl extends BaseBizImpl implements IAttachmentBiz  {
	
	/**
	 * 根据主键获得附件表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public Attachment getAttachment(Long id) throws BaseException {
		return (Attachment)this.getObject(Attachment.class, id);
	}
	
	/**
	 * 添加附件信息
	 * @param Attachment 附件表实例
	 * @throws BaseException 
	 */
	public void saveAttachment(Attachment Attachment) throws BaseException{
		this.saveObject( Attachment ) ;
	}
	
	/**
	 * 更新附件表实例
	 * @param Attachment 附件表实例
	 * @throws BaseException 
	 */
	public void updateAttachment(Attachment Attachment) throws BaseException{
		this.updateObject( Attachment ) ;
	}
	
	/**
	 * 删除附件表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteAttachment(String id) throws BaseException {
		this.removeObject( this.getAttachment( new Long(id) ) ) ;
	}
	
	/**
	 * 删除附件表实例
	 * @param Attachment 附件表实例
	 * @throws BaseException 
	 */
	public void deleteAttachment(Attachment Attachment) throws BaseException {
		this.removeObject( Attachment ) ;
	}
	
	/**
	 * 删除附件表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteAttachments(String[] id) throws BaseException {
		this.removeBatchObject(Attachment.class, id) ;
	}
	
	
	/**
	 * 获得所有附件表数据集
	 * @param Attachment 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getAttachmentList(  Attachment Attachment ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Attachment att where 1 = 1 " );

		if ( !StringUtil.isBlank( Attachment.getAttachmentType() )) {
			hql.append( " and att.attachmentType='" ).append( Attachment.getAttachmentType() ).append( "'" ) ;
		}

		if ( !StringUtil.isBlank( Attachment.getAttachmentField() )) {
			hql.append( " and att.attachmentField='" ).append( Attachment.getAttachmentField() ).append( "'" ) ;
		}

		if ( !StringUtil.isBlank( Attachment.getAttachmentTypeId() )) {
			hql.append(" and att.attachmentTypeId= ").append( Attachment.getAttachmentTypeId() ) ;
		}
		
		hql.append(" order by de.attachmentId asc ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 
	 * @param formFile
	 * @param parentId
	 * @param clazz
	 * @param filed当附件为多种类型时，使用.对象的属性名称
	 * @throws BaseException
	 */
//	public void saveAttachment(FormFile formFile, Long parentId, Class clazz, String filed)
//			throws BaseException {
	public void saveAttachment(File formFile, Long parentId, Class clazz, String filed)
		throws BaseException {
		String tableName = StringUtil.getClassName(clazz);
		try {
			if ( ! StringUtil.isBlank( formFile )) {

			Attachment attachment = new Attachment();
			this.saveAttachment( attachment );

//			attachment.setAttachmenetName(formFile.getFileName());
			//temp
			attachment.setAttachmenetName(filed );
			attachment.setAttachmentType(tableName);
			attachment.setAttachmentTypeId(parentId);
			attachment.setWriteDate(new Date());

			if (!StringUtil.isBlank(filed)) {
				attachment.setAttachmentField("01");
			}

			// 真实环境nas服务器。通过ftp协议上传
			FtpUtil ftpUtil = new FtpUtil();
			String fileName = ftpUtil.upload(getAttachmentPath(attachment), new FileInputStream( formFile ), FtpUtil.getOperatorFileName(attachment), true);
			
//			String fileName = ftpUtil.upload(getAttachmentPath(attachment), formFile
//					.getInputStream(), FtpUtil.getOperatorFileNameNoExtendName(attachment), true);

			this.updateAttachment( attachment );
			}
		} catch (Exception e) {
			throw new BaseException("上传附件错误：" + tableName, e);
		}

	} 

	/**
	 * 获取附件的上传路径-相对 
	 * @param attachment
	 * @return
	 */
	public String getAttachmentPath(Attachment attachment) {

		StringBuffer path = new StringBuffer( GlobalSetting.getAttachmentUploadLoaction() ) ;

		String year  = DateUtil.getYear(attachment.getWriteDate());
		String month = DateUtil.getMonth(attachment.getWriteDate());

		// 附件存放在以时间命名的文件夹中,
		path.append( File.separator ) ;
		path.append( attachment.getAttachmentType() ) ;
		path.append( File.separator ) ;
		path.append( year ) ;
		path.append( File.separator ) ;
		path.append( month ) ;
		path.append( File.separator ) ;
		
		return path.toString() ;
	}

	/**
	 * 获取ftp附件下载的url
	 * @param attachmentId
	 * @return
	 */
	public String getFtpAttachmentUrl(Attachment attachment, HttpServletRequest request) {

		StringBuffer url = new StringBuffer( request.getContextPath() ) ;
		
		url.append( "/download_down.action" ) ;
		url.append( "?attach.attachmentId=" ) ;
		url.append( attachment.getAttachmentId() ) ;
		
		if( attachment.getAttachmentField() != null ) {
			url.append( "&attach.attachmentField=" + attachment.getAttachmentField() ) ;
		}
		
		return url.toString() ;
	}

	/**
	 * 获取http附件下载的url
	 * @param attachment 
	 * @return
	 */
	public String getHttpAttachmentUrl(Attachment attachment) {
		
		String year = DateUtil.getYear(attachment.getWriteDate());
		String month = DateUtil.getMonth(attachment.getWriteDate());
		String fileName = attachment.getAttachmenetName() ;
		int temp = fileName.lastIndexOf(".") ;
		
		StringBuffer path = new StringBuffer( GlobalSetting.getAttachdmentPlacedHttpAddress() ) ;
		
		path.append( GlobalSetting.getAttachmentUploadLoaction() ) ;
		
		path.append( attachment.getAttachmentType() ) ;
		path.append( "/" ) ;
		path.append( year ) ;
		path.append( "/" ) ;
		path.append( month ) ;
		path.append( "/" ) ;
		path.append( attachment.getAttachmentId() + fileName.substring(temp) ) ;
		
		return path.toString() ;
	}
	
	/**
	 * 获取附件的真实路径 上传到本机需要知道真实路径
	 * @param attachment 附件对象实例 
	 * @param abspath 相对开始路径, 从配置文件中取
	 * @author ted 2011-05-28 
	 * @return String 完整的真实路径
	 */
	public String getAttachmentRealPath(Attachment attachment, String abspath) {

		//GlobalSetting.getAttachmentRealUploadLocation()
		StringBuffer path = new StringBuffer( ""  ) ;
		
		if( abspath != null && abspath.length()>0 ) {
			path.append( abspath ) ;
			
		}else { // 默认值
			path.append( GlobalSetting.getAttachmentUploadLoaction() ) ;
		}
		
		// 年份
		String year = DateUtil.getYear(attachment.getWriteDate());
		
		// 月份
		String month = DateUtil.getMonth(attachment.getWriteDate());

		// 附件存放在以时间命名的文件夹中
		path.append( File.separator ) ;
		path.append( attachment.getAttachmentType() ) ;
		path.append( File.separator ) ;
		path.append( year ) ;
		path.append( File.separator ) ;
		path.append( month ) ;
		path.append( File.separator ) ;
		
		return path.toString() ;
	}
	
	public void saveAttachmentAndUpload( BaseAttachment att ) throws FileNotFoundException, Exception {
		if ( att != null ) {
			
			if( att.getUploadFilesFileName() != null ) {
			
				for(int i=0; i<att.getUploadFilesFileName().length; i++ ){
					
					Attachment attachment= new Attachment() ;
					
					attachment.setAttachmenetName( att.getUploadFilesFileName()[i] ) ;
					attachment.setAttachmentField( att.getAttachmentField() ) ;
					attachment.setAttachmentType( att.getAttachmentType() ) ;
					attachment.setAttachmentTypeId( att.getAttachmentTypeId() ) ;
					attachment.setWriteDate( att.getWriteDate() ) ;
					attachment.setWriter( att.getWriter() ) ;
					
					System.out.println( att.getUploadFiles()[i].length() )  ;
					this.saveAttachment( attachment );
			
					
					// 真实环境nas服务器。通过ftp协议上传
					FtpUtil ftpUtil = new FtpUtil();
					String fileName = ftpUtil.upload(getAttachmentPath(attachment), new FileInputStream( att.getUploadFiles()[i] ), FtpUtil.getOperatorFileName(attachment), true);
					
			//		String fileName = ftpUtil.upload(getAttachmentPath(attachment), formFile
			//				.getInputStream(), FtpUtil.getOperatorFileNameNoExtendName(attachment), true);
			
					this.updateAttachment( attachment );
				}
			}
		}
	}
}
