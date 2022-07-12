package com.by.hctm.common.biz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.by.base.entity.BaseAttachment;
import com.by.base.exception.BaseException;
import com.by.hctm.common.entity.Attachment;

public interface IAttachmentBiz {

	/**
	 * 根据主键获得附件表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract Attachment getAttachment(Long id) throws BaseException;

	/**
	 * 添加附件信息
	 * @param Attachment 附件表实例
	 * @throws BaseException 
	 */
	abstract void saveAttachment(Attachment Attachment) throws BaseException;

	/**
	 * 更新附件表实例
	 * @param Attachment 附件表实例
	 * @throws BaseException 
	 */
	abstract void updateAttachment(Attachment Attachment) throws BaseException;

	/**
	 * 删除附件表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteAttachment(String id) throws BaseException;

	/**
	 * 删除附件表实例
	 * @param Attachment 附件表实例
	 * @throws BaseException 
	 */
	abstract void deleteAttachment(Attachment Attachment) throws BaseException;

	/**
	 * 删除附件表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteAttachments(String[] id) throws BaseException;

	/**
	 * 获得所有附件表数据集
	 * @param Attachment 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getAttachmentList(Attachment Attachment) throws BaseException;

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
	abstract void saveAttachment(File formFile, Long parentId, Class clazz,
			String filed) throws BaseException;

	/**
	 * 获取附件的上传路径-相对 
	 * @param attachment
	 * @return
	 */
	abstract String getAttachmentPath(Attachment attachment);

	/**
	 * 获取ftp附件下载的url
	 * @param attachmentId
	 * @return
	 */
	abstract String getFtpAttachmentUrl(Attachment attachment,
			HttpServletRequest request);

	/**
	 * 获取http附件下载的url
	 * @param attachment 
	 * @return
	 */
	abstract String getHttpAttachmentUrl(Attachment attachment);

	/**
	 * 获取附件的真实路径 上传到本机需要知道真实路径
	 * @param attachment 附件对象实例 
	 * @param abspath 相对开始路径, 从配置文件中取
	 * @author ted 2011-05-28 
	 * @return String 完整的真实路径
	 */
	abstract String getAttachmentRealPath(Attachment attachment, String abspath);

	abstract void saveAttachmentAndUpload( BaseAttachment att ) throws FileNotFoundException, Exception ;
	
}