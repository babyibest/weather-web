package com.by.hctm.common.biz;

import com.by.base.exception.BaseException;
import com.by.hctm.system.entity.TSysUserInoutLog;

public interface ITSysUserInoutLogBiz {

	/**
	 * 根据主键获得登录日志表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract TSysUserInoutLog getTSysUserInoutLog(Long id) throws BaseException;

	/**
	 * 添加登录日志信息
	 * @param TSysUserInoutLog 登录日志表实例
	 * @throws BaseException 
	 */
	abstract void saveTSysUserInoutLog(TSysUserInoutLog TSysUserInoutLog)
			throws BaseException;

	/**
	 * 更新登录日志表实例
	 * @param TSysUserInoutLog 登录日志表实例
	 * @throws BaseException 
	 */
	abstract void updateTSysUserInoutLog(TSysUserInoutLog TSysUserInoutLog)
			throws BaseException;

	/**
	 * 删除登录日志表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteTSysUserInoutLog(String id) throws BaseException;

	/**
	 * 删除登录日志表实例
	 * @param TSysUserInoutLog 登录日志表实例
	 * @throws BaseException 
	 */
	abstract void deleteTSysUserInoutLog(TSysUserInoutLog TSysUserInoutLog)
			throws BaseException;

	/**
	 * 删除登录日志表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteTSysUserInoutLogs(String[] id) throws BaseException;

	/**
	 * 记录用户退出日志
	 * @param sessionPath 
	 * @throws BaseException 
	 */
	public void userLogoutLog( String sessionPath )  throws BaseException ;
	
}