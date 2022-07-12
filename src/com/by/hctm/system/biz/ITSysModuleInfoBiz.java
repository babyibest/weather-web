package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.TSysModuleInfo;

public interface ITSysModuleInfoBiz {

	/**
	 * 根据主键获得功能信息表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract TSysModuleInfo getTSysModuleInfo(Long id) throws BaseException;

	/**
	 * 获得功能信息表实例
	 * @param tSysModuleInfo 功能信息表实例
	 * @return
	 * @throws BaseException 
	 */
	abstract TSysModuleInfo getTSysModuleInfo(TSysModuleInfo tSysModuleInfo)
			throws BaseException;

	/**
	 * 添加功能信息信息
	 * @param tSysModuleInfo 功能信息表实例
	 * @throws BaseException 
	 */
	abstract void saveTSysModuleInfo(TSysModuleInfo tSysModuleInfo)
			throws BaseException;

	/**
	 * 更新功能信息表实例
	 * @param tSysModuleInfo 功能信息表实例
	 * @throws BaseException 
	 */
	abstract void updateTSysModuleInfo(TSysModuleInfo tSysModuleInfo)
			throws BaseException;

	/**
	 * 删除功能信息表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteTSysModuleInfo(String id) throws BaseException;

	/**
	 * 删除功能信息表实例
	 * @param tSysModuleInfo 功能信息表实例
	 * @throws BaseException 
	 */
	abstract void deleteTSysModuleInfo(TSysModuleInfo tSysModuleInfo)
			throws BaseException;

	/**
	 * 删除功能信息表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteTSysModuleInfos(String[] id) throws BaseException;

	/**
	 * 获得所有功能信息表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getTSysModuleInfoList(RollPage rollPage) throws BaseException;

	/**
	 * 获得所有功能信息表数据集
	 * @param tSysModuleInfo 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getTSysModuleInfoList(TSysModuleInfo tSysModuleInfo)
			throws BaseException;

	/**
	 * 获得所有功能信息表数据集
	 * @param rollPage 分页对象
	 * @param tSysModuleInfo 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getTSysModuleInfoList(RollPage rollPage,
			TSysModuleInfo tSysModuleInfo) throws BaseException;

}