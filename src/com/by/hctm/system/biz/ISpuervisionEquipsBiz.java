package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.SpuervisionEquips;

public interface ISpuervisionEquipsBiz {

	/**
	 * 根据主键获得监理装备表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract SpuervisionEquips getSpuervisionEquips(Long id) throws BaseException;

	/**
	 * 添加监理装备信息
	 * @param SpuervisionEquips 监理装备表实例
	 * @throws BaseException 
	 */
	abstract void saveSpuervisionEquips(SpuervisionEquips spuervisionEquips) throws BaseException;

	/**
	 * 更新监理装备表实例
	 * @param SpuervisionEquips 监理装备表实例
	 * @throws BaseException 
	 */
	abstract void updateSpuervisionEquips(SpuervisionEquips spuervisionEquips) throws BaseException;

	/**
	 * 删除监理装备表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteSpuervisionEquips(String id) throws BaseException;

	/**
	 * 删除监理装备表实例
	 * @param SpuervisionEquips 监理装备表实例
	 * @throws BaseException 
	 */
	abstract void deleteSpuervisionEquips(SpuervisionEquips spuervisionEquips) throws BaseException;

	/**
	 * 删除监理装备表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteSpuervisionEquipss(String[] id) throws BaseException;

	/**
	 * 获得所有监理装备表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getSpuervisionEquipsList( RollPage rollPage  ) throws BaseException ;
	
	/**
	 * 获得所有监理装备表数据集
	 * @param SpuervisionEquips 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getSpuervisionEquipsList(  SpuervisionEquips spuervisionEquips ) throws BaseException ;
	
	/**
	 * 获得所有监理装备表数据集
	 * @param rollPage 分页对象
	 * @param SpuervisionEquips 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getSpuervisionEquipsList(RollPage rollPage, SpuervisionEquips spuervisionEquips,String seId)
			throws BaseException;

}