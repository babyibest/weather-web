package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.MaterialTypes;

public interface IMaterialTypesBIZ {

	/**
	 * 根据主键获得物资类别表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract MaterialTypes getMaterialTypes(Long id) throws BaseException;

	/**
	 * 添加物资类别表信息
	 * @param MaterialTypes 物资类别表实例
	 * @throws BaseException 
	 */
	abstract void saveMaterialTypes(MaterialTypes materialTypes)
			throws BaseException;

	/**
	 * 更新物资类别表实例
	 * @param materialTypes 物资类别表实例
	 * @throws BaseException 
	 */
	abstract void updateMaterialTypes(MaterialTypes materialTypes)
			throws BaseException;

	/**
	 * 删除物资类别表实例
	 * @param id 主键
	 * @throws BaseException 
	 */
	abstract void deleteMaterialTypes(Long id) throws BaseException;

	/**
	 * 删除物资类别表实例
	 * @param materialTypes 物资类别表实例
	 * @throws BaseException 
	 */
	abstract void deleteMaterialTypes(MaterialTypes materialTypes)
			throws BaseException;

	/**
	 * 删除物资类别表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteDemos(String[] id) throws BaseException;

	/**
	 * 获得所有物资类别数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<MaterialTypes> getMaterialTypesList(RollPage rollPage)
			throws BaseException;

	/**
	 * 获得所有物资类别数据集
	 * @param materialTypes 物资类别对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<MaterialTypes> getMaterialTypesList(
			MaterialTypes materialTypes) throws BaseException;

	/**
	 * 获得所有物资类别数据集
	 * @param rollPage 分页对象
	 * @param materialTypes 物资类别对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<MaterialTypes> getMaterialTypesList(RollPage rollPage,
			MaterialTypes materialTypes) throws BaseException;

}