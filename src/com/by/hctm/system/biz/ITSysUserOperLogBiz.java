package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.TSysUserOperLog;

public interface ITSysUserOperLogBiz {

	/**
	 * 根据主键获得操作日志表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract TSysUserOperLog getTSysUserOperLog(Long id) throws BaseException;

	/**
	 * 获得操作日志表实例
	 * @param tSysUserOperLog 操作日志表实例
	 * @return
	 * @throws BaseException 
	 */
	abstract TSysUserOperLog getTSysUserOperLog(TSysUserOperLog tSysUserOperLog)
			throws BaseException;

	/**
	 * 添加操作日志信息
	 * @param tSysUserOperLog 操作日志表实例
	 * @throws BaseException 
	 */
	abstract void saveTSysUserOperLog(TSysUserOperLog tSysUserOperLog)
			throws BaseException;

	/**
	 * 更新操作日志表实例
	 * @param tSysUserOperLog 操作日志表实例
	 * @throws BaseException 
	 */
	abstract void updateTSysUserOperLog(TSysUserOperLog tSysUserOperLog)
			throws BaseException;

	/**
	 * 删除操作日志表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteTSysUserOperLog(String id) throws BaseException;

	/**
	 * 删除操作日志表实例
	 * @param tSysUserOperLog 操作日志表实例
	 * @throws BaseException 
	 */
	abstract void deleteTSysUserOperLog(TSysUserOperLog tSysUserOperLog)
			throws BaseException;

	/**
	 * 删除操作日志表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteTSysUserOperLogs(String[] id) throws BaseException;

	/**
	 * 获得所有操作日志表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getTSysUserOperLogList(RollPage rollPage)
			throws BaseException;

	/**
	 * 获得所有操作日志表数据集
	 * @param tSysUserOperLog 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getTSysUserOperLogList(TSysUserOperLog tSysUserOperLog)
			throws BaseException;

	/**
	 * 获得所有操作日志表数据集
	 * @param rollPage 分页对象
	 * @param tSysUserOperLog 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getTSysUserOperLogList(RollPage rollPage,
			TSysUserOperLog tSysUserOperLog) throws BaseException;

}