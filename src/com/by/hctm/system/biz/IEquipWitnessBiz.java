package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.EquipWitness;

public interface IEquipWitnessBiz {

	/**
	 * 根据主键获得监造物资见证信息表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract EquipWitness getEquipWitness(Long id) throws BaseException;

	/**
	 * 添加监造物资见证信息信息
	 * @param EquipWitness 监造物资见证信息表实例
	 * @throws BaseException 
	 */
	abstract void saveEquipWitness(EquipWitness equipWitness) throws BaseException;

	/**
	 * 更新监造物资见证信息表实例
	 * @param EquipWitness 监造物资见证信息表实例
	 * @throws BaseException 
	 */
	abstract void updateEquipWitness(EquipWitness equipWitness) throws BaseException;

	/**
	 * 删除监造物资见证信息表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteEquipWitness(String id) throws BaseException;

	/**
	 * 删除监造物资见证信息表实例
	 * @param EquipWitness 监造物资见证信息表实例
	 * @throws BaseException 
	 */
	abstract void deleteEquipWitness(EquipWitness equipWitness) throws BaseException;

	/**
	 * 删除监造物资见证信息表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteEquipWitnesss(String[] id) throws BaseException;

	/**
	 * 获得所有监造物资见证信息表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getEquipWitnessList( RollPage rollPage  ) throws BaseException ;
	
	/**
	 * 获得所有监造物资见证信息表数据集
	 * @param EquipWitness 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getEquipWitnessList(  EquipWitness equipWitness ) throws BaseException ;
	
	/**
	 * 获得所有监造物资见证信息表数据集
	 * @param rollPage 分页对象
	 * @param EquipWitness 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getEquipWitnessList(RollPage rollPage, EquipWitness equipWitness)
			throws BaseException;

}