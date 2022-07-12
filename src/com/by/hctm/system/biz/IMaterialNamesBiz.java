package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.MaterialNames;
import com.by.hctm.system.entity.MaterialStages;

public interface IMaterialNamesBiz {

	/**
	 * 根据主键获得监理资料名称表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract MaterialNames getMaterialNames(Long id) throws BaseException;

	/**
	 * 添加监理资料名称信息
	 * @param MaterialNames 监理资料名称表实例
	 * @throws BaseException 
	 */
	abstract void saveMaterialNames(MaterialNames materialNames) throws BaseException;

	/**
	 * 更新监理资料名称表实例
	 * @param MaterialNames 监理资料名称表实例
	 * @throws BaseException 
	 */
	abstract void updateMaterialNames(MaterialNames materialNames) throws BaseException;

	/**
	 * 删除监理资料名称表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteMaterialNames(String id) throws BaseException;

	/**
	 * 删除监理资料名称表实例
	 * @param MaterialNames 监理资料名称表实例
	 * @throws BaseException 
	 */
	abstract void deleteMaterialNames(MaterialNames materialNames) throws BaseException;

	/**
	 * 删除监理资料名称表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteMaterialNamess(String[] id) throws BaseException;

	/**
	 * 获得所有监理资料名称表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getMaterialNamesList( RollPage rollPage  ) throws BaseException ;
	
	/**
	 * 获得所有监理资料名称表数据集
	 * @param MaterialNames 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getMaterialNamesList(  MaterialNames materialNames ) throws BaseException ;
	
	/**
	 * 获得所有监理资料名称表数据集
	 * @param rollPage 分页对象
	 * @param MaterialNames 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getMaterialNamesList(RollPage rollPage, MaterialNames materialNames)
			throws BaseException;
	 
	/**
	 * 获得所有资料类别数据集
	 * @return
	 * @throws BaseException 
	 */
	public List getMaterialTypesList() throws BaseException;
	
	
	/**
	 * 获得所有资料类别数据count
	 * @return
	 * @throws BaseException 
	 */
	public int getMaterialNamesCount(MaterialNames materialNames) throws BaseException;
	
	/**
	 * 获得所有表数据集
	 * @param rollPage 分页对象
	 * @param MaterialNames 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List MaterialNameList( RollPage rollPage, MaterialNames materialNames ,MaterialStages materialStages) throws BaseException;
}