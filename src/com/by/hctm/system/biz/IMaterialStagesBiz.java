package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.MaterialNames;
import com.by.hctm.system.entity.MaterialStages;

public interface IMaterialStagesBiz {

	/**
	 * 根据主键获得资料工序表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract MaterialStages getMaterialStages(Long id) throws BaseException;

	/**
	 * 添加资料工序信息
	 * @param MaterialStages 资料工序表实例
	 * @throws BaseException 
	 */
	abstract void saveMaterialStages(MaterialStages materialStages) throws BaseException;

	/**
	 * 更新资料工序表实例
	 * @param MaterialStages 资料工序表实例
	 * @throws BaseException 
	 */
	abstract void updateMaterialStages(MaterialStages materialStages) throws BaseException;

	/**
	 * 删除资料工序表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteMaterialStages(String id) throws BaseException;

	/**
	 * 删除资料工序表实例
	 * @param MaterialStages 资料工序表实例
	 * @throws BaseException 
	 */
	abstract void deleteMaterialStages(MaterialStages materialStages) throws BaseException;

	/**
	 * 删除资料工序表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteMaterialStagess(String[] id) throws BaseException;

	/**
	 * 获得所有资料工序表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getMaterialStagesList( RollPage rollPage  ) throws BaseException ;
	
	/**
	 * 获得所有资料工序表数据集
	 * @param MaterialStages 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getMaterialStagesList(  MaterialStages materialStages ) throws BaseException ;
	
	/**
	 * 获得所有监理资料工序对应表数据集
	 * @param rollPage 分页对象
	 * @param MaterialStages 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getMaterialStagesList(RollPage rollPage, MaterialStages materialStages)
			throws BaseException;

	/**
	 * 获得所有监理资料工序对应表数据集
	 * @param MaterialStages 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public int getMaterialStagesCount(  MaterialStages materialStages ) throws BaseException ;

	/**
	 * 获得所有监理资料工序对应表数据集
	 * @param MaterialStages 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public int getMaterialStagesNmae(  MaterialStages materialStages ) throws BaseException ;

/**
 * 获得所有名称表数据集
 * @param rollPage 分页对象
 * @param MaterialNames 查询参数对象
 * @return
 * @throws BaseException 
 */
	public List gMaterialStagesList( RollPage rollPage, MaterialStages materialStages,MaterialNames materialNames ) throws BaseException;
	


	
}
	