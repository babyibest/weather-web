package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.Stages;
import com.by.hctm.system.entity.Subjects;
@SuppressWarnings("unchecked")
public interface IStagesBiz {

	/**
	 * 根据主键获得工序表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract Stages getStages(Long id) throws BaseException;

	/**
	 * 添加工序信息
	 * @param Stages 工序表实例
	 * @throws BaseException 
	 */
	abstract void saveStages(Stages stages) throws BaseException;

	/**
	 * 更新工序表实例
	 * @param Stages 工序表实例
	 * @throws BaseException 
	 */
	abstract void updateStages(Stages stages) throws BaseException;

	/**
	 * 删除工序表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteStages(Long id) throws BaseException;

	/**
	 * 删除工序表实例
	 * @param Stages 工序表实例
	 * @throws BaseException 
	 */
	abstract void deleteStages(Stages stages) throws BaseException;

	/**
	 * 删除工序表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteStagess(String[] id) throws BaseException;

	/**
	 * 获得所有工序表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getStagesList( RollPage rollPage  ) throws BaseException ;
	
	/**
	 * 获得所有工序表数据集
	 * @param Stages 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getStagesList(  Stages stages ) throws BaseException ;
	
	/**
	 * 获得所有工序表数据集
	 * @param rollPage 分页对象
	 * @param Stages 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getStagesList(RollPage rollPage, Stages stages)
			throws BaseException;
	/**
	 * 获得所有专业表数据集
	 * @param 
	 * @param standardId 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getSubjectsList(int id) throws BaseException;
	/**
	 * 获得所有工序表数据集
	 * @param rollPage 分页对象
	 * @param Stages 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	
	public List getSubStagesList( RollPage rollPage, Stages stages ) throws BaseException;
	/**
	 * 获得根据专业编码获专业数据集
	 * @param
	 * @param Subjects 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public Subjects getSubjects(Stages stages ) throws BaseException;
	
	

	public List<Subjects>  getSubjects(Subjects subjects ) throws BaseException;
	/**
	 * 根据主键获得项目专业表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public Subjects getSubjectsId(Long id) throws BaseException;
	
	/**
	 * 根据主键获得项目工序表数量
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public int getStagesCount(Stages stages) throws BaseException;
}