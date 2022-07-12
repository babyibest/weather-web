package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.ConstructionSubjects;
@SuppressWarnings("unchecked")
public interface IConstructionSubjectsBIZ {

	/**
	 * 根据主键获得监造专业表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract ConstructionSubjects getConstructionSubjects(Long id) throws BaseException;

	/**
	 * 添加监造专业信息
	 * @param demo 监造专业表实例
	 * @throws BaseException 
	 */
	abstract void saveConstructionSubjects(ConstructionSubjects constructionSubjects) throws BaseException;

	/**
	 * 更新监造专业表实例
	 * @param ConstructionSubjects 监造专业表实例
	 * @throws BaseException 
	 */
	abstract void updateConstructionSubjects(ConstructionSubjects constructionSubjects) throws BaseException;

	/**
	 * 删除监造专业表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteConstructionSubjects(String id) throws BaseException;

	/**
	 * 删除监造专业表实例
	 * @param ConstructionSubjects 监造专业表实例
	 * @throws BaseException 
	 */
	abstract void deleteConstructionSubjects(ConstructionSubjects constructionSubjects) throws BaseException;

	/**
	 * 删除监造专业表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteConstructionSubjectss(String[] id) throws BaseException;

	/**
	 * 获得所有监造专业表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getConstructionSubjectsList( RollPage rollPage  ) throws BaseException ;
	
	/**
	 * 获得所有监造专业表数据集
	 * @param ConstructionSubjects 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getConstructionSubjectsList(ConstructionSubjects constructionSubjects ) throws BaseException ;
	
	/**
	 * 获得所有监造专业表数据集
	 * @param rollPage 分页对象
	 * @param ConstructionSubjects 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getConstructionSubjectsList(RollPage rollPage, ConstructionSubjects constructionSubjects)
			throws BaseException;
	/**
	 * 获得所有监造专业表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getConstructionSubjectsAllList() throws BaseException ;
}