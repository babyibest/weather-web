package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.Risks;
import com.by.hctm.system.entity.Stages;

public interface IRisksBIZ {

	/**
	 * 根据主键获得风险点表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract Risks getRisks(Long id) throws BaseException;

	/**
	 * 添加风险点表信息
	 * @param risks 风险点表实例
	 * @throws BaseException 
	 */
	abstract void saveRisks(Risks risks) throws BaseException;

	/**
	 * 更新风险点表实例
	 * @param risks 风险点表实例
	 * @throws BaseException 
	 */
	abstract void updateRisks(Risks risks) throws BaseException;

	/**
	 * 删除风险点表实例
	 * @param id 主键
	 * @throws BaseException 
	 */
	abstract void deleteRisks(String id) throws BaseException;

	/**
	 * 删除风险点表实例
	 * @param risks 风险点表实例
	 * @throws BaseException 
	 */
	abstract void deleteRisks(Risks risks) throws BaseException;

	/**
	 * 删除风险点表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteDemos(String[] id) throws BaseException;

	/**
	 * 获得所有风险点数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<Risks> getRisksList(RollPage rollPage) throws BaseException;

	/**
	 * 获得所有风险点数据集
	 * @param risks 风险点对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<Risks> getRisksList(Risks risks) throws BaseException;

	/**
	 * 获得所有风险点数据集
	 * @param rollPage 分页对象
	 * @param risks 风险点对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<Risks> getRisksList(RollPage rollPage, Risks risks)
			throws BaseException;
	/**
	 * 获得所有专业数据集
	 * @return
	 * @throws BaseException 
	 */
	public List getSubjectsList(int id) throws BaseException ;
	/**
	 * 获得所有工序数据集
	 * @return
	 * @throws BaseException 
	 */
	public List<Stages> getStagesList( ) throws BaseException;
	/**
	 * 获得所有专业数据集
	 * @return
	 * @throws BaseException 
	 */
	public Stages getStagesList(Risks risks) throws BaseException;
	/**
	 * 获得根据工序有无子节点
	 * @param
	 * @param Subjects 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public int  getRisksCount(Risks risks ) throws BaseException;

}