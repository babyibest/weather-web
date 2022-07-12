package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.ConstructionEquips;

public interface IConstructionEquipsBiz {

	/**
	 * 根据主键获得表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract ConstructionEquips getConstructionEquips(Long id) throws BaseException;

	/**
	 * 添加监理大纲信息
	 * @param ConstructionEquips 监理大纲表实例
	 * @throws BaseException 
	 */
	abstract void saveConstructionEquips(ConstructionEquips constructionEquips) throws BaseException;

	/**
	 * 更新监理大纲表实例
	 * @param ConstructionEquips 监理大纲表实例
	 * @throws BaseException 
	 */
	abstract void updateConstructionEquips(ConstructionEquips constructionEquips) throws BaseException;

	/**
	 * 删除监理大纲表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteConstructionEquips(String id) throws BaseException;

	/**
	 * 删除监理大纲表实例
	 * @param ConstructionEquips 监理大纲表实例
	 * @throws BaseException 
	 */
	abstract void deleteConstructionEquips(ConstructionEquips constructionEquips) throws BaseException;

	/**
	 * 删除监理大纲表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteConstructionEquipss(String[] id) throws BaseException;

	/**
	 * 获得所有监理大纲表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getConstructionEquipsList( RollPage rollPage  ) throws BaseException ;
	
	/**
	 * 获得所有监理大纲表数据集
	 * @param ConstructionEquips 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getConstructionEquipsList(  ConstructionEquips constructionEquips ) throws BaseException ;
	
	/**
	 * 获得所有监理大纲表数据集
	 * @param rollPage 分页对象
	 * @param ConstructionEquips 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getConstructionEquipsList(RollPage rollPage, ConstructionEquips constructionEquips)
			throws BaseException;
	
	
	
	public List getConstructionEquipsAllList() throws BaseException;

}