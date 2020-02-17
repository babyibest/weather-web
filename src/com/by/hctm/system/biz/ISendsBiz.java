package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.Sends;

public interface ISendsBiz {

	/**
	 * 根据主键获得发文表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract Sends getSends(Long id) throws BaseException;

	/**
	 * 添加发文信息
	 * @param demo 发文表实例
	 * @throws BaseException 
	 */
	abstract void saveSends(Sends sends) throws BaseException;

	/**
	 * 更新发文表实例
	 * @param sends 发文表实例
	 * @throws BaseException 
	 */
	abstract void updateSends(Sends sends) throws BaseException;

	/**
	 * 删除发文表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteSends(String id) throws BaseException;

	/**
	 * 删除发文表实例
	 * @param sends 发文表实例
	 * @throws BaseException 
	 */
	abstract void deleteSends(Sends sends) throws BaseException;

	/**
	 * 删除发文表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteSendss(String[] id) throws BaseException;

	/**
	 * 获得所有发文表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getSendsList( RollPage rollPage  ) throws BaseException ;
	
	/**
	 * 获得所有发文表数据集
	 * @param sends 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getSendsList(  Sends sends ) throws BaseException ;
	
	/**
	 * 获得所有发文表数据集
	 * @param rollPage 分页对象
	 * @param sends 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getSendsList(RollPage rollPage, Sends sends)
			throws BaseException;

}