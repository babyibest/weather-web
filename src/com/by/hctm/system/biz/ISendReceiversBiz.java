package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.SendReceivers;

public interface ISendReceiversBiz {

	/**
	 * 根据主键获得发文表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract SendReceivers getSendReceivers(Long id) throws BaseException;

	/**
	 * 添加发文信息
	 * @param sendReceivers 发文表实例
	 * @throws BaseException 
	 */
	abstract void saveSendReceivers(SendReceivers sendReceivers) throws BaseException;

	/**
	 * 更新发文表实例
	 * @param sendReceivers 发文表实例
	 * @throws BaseException 
	 */
	abstract void updateSendReceivers(SendReceivers sendReceivers) throws BaseException;

	/**
	 * 删除发文表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteSendReceivers(String id) throws BaseException;

	/**
	 * 删除发文表实例
	 * @param sendReceivers 发文表实例
	 * @throws BaseException 
	 */
	abstract void deleteSendReceivers(SendReceivers sendReceivers) throws BaseException;

	/**
	 * 删除发文表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteSendReceiverss(String[] id) throws BaseException;

	/**
	 * 获得所有发文表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getSendReceiversList( RollPage rollPage  ) throws BaseException ;
	
	/**
	 * 获得所有发文表数据集
	 * @param sendReceivers 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getSendReceiversList(  SendReceivers sendReceivers ) throws BaseException ;
	
	/**
	 * 获得所有发文表数据集
	 * @param rollPage 分页对象
	 * @param sendReceivers 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getSendReceiversList(RollPage rollPage, SendReceivers sendReceivers)
			throws BaseException;

}