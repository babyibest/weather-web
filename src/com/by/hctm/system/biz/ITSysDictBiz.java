package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.TSysDict;

public interface ITSysDictBiz {

	/**
	 * 根据主键获得字典信息表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract TSysDict getTSysDict(Long id) throws BaseException;

	/**
	 * 获得字典信息表实例
	 * @param tSysDict 字典信息表实例
	 * @return
	 * @throws BaseException 
	 */
	abstract TSysDict getTSysDict(TSysDict tSysDict) throws BaseException;

	/**
	 * 添加字典信息信息
	 * @param tSysDict 字典信息表实例
	 * @throws BaseException 
	 */
	abstract void saveTSysDict(TSysDict tSysDict) throws BaseException;

	/**
	 * 更新字典信息表实例
	 * @param tSysDict 字典信息表实例
	 * @throws BaseException 
	 */
	abstract void updateTSysDict(TSysDict tSysDict) throws BaseException;

	/**
	 * 删除字典信息表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteTSysDict(String id) throws BaseException;

	/**
	 * 删除字典信息表实例
	 * @param tSysDict 字典信息表实例
	 * @throws BaseException 
	 */
	abstract void deleteTSysDict(TSysDict tSysDict) throws BaseException;

	/**
	 * 删除字典信息表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteTSysDicts(String[] id) throws BaseException;

	/**
	 * 获得所有字典信息表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getTSysDictList(RollPage rollPage) throws BaseException;

	/**
	 * 获得所有字典信息表数据集
	 * @param tSysDict 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getTSysDictList(TSysDict tSysDict) throws BaseException;

	/**
	 * 获得所有字典信息表数据集
	 * @param rollPage 分页对象
	 * @param tSysDict 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getTSysDictList(RollPage rollPage, TSysDict tSysDict)
			throws BaseException;

}