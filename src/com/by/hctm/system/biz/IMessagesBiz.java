package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.Messages;

public interface IMessagesBiz {

	/**
	 * 根据主键获得短信表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract Messages getMessages(Long id) throws BaseException;

	/**
	 * 添加短信信息
	 * @param messages 短信表实例
	 * @throws BaseException 
	 */
	abstract void saveMessages(Messages messages) throws BaseException;

	/**
	 * 更新短信表实例
	 * @param messages 短信表实例
	 * @throws BaseException 
	 */
	abstract void updateMessages(Messages messages) throws BaseException;

	/**
	 * 删除短信表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteMessages(String id) throws BaseException;

	/**
	 * 删除短信表实例
	 * @param messages 短信表实例
	 * @throws BaseException 
	 */
	abstract void deleteMessages(Messages messages) throws BaseException;

	/**
	 * 删除短信表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteMessagess(String[] id) throws BaseException;

	/**
	 * 获得所有短信表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getMessagesList( RollPage rollPage  ) throws BaseException ;
	
	/**
	 * 获得所有短信表数据集
	 * @param messages 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getMessagesList(  Messages messages ) throws BaseException ;
	
	/**
	 * 获得所有短信表数据集
	 * @param rollPage 分页对象
	 * @param messages 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getMessagesList(RollPage rollPage, Messages messages)
			throws BaseException;

}