package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.Subjects;

public interface ISubjectsBIZ {

	/**
	 * 根据主键获得项目专业表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract Subjects getSubjects(Long id) throws BaseException;

	/**
	 * 添加项目专业表信息
	 * @param subjects 项目专业表实例
	 * @throws BaseException 
	 */
	abstract void saveSubjects(Subjects subjects) throws BaseException;

	/**
	 * 更新项目专业表实例
	 * @param subjects 项目专业表实例
	 * @throws BaseException 
	 */
	abstract void updateSubjects(Subjects subjects) throws BaseException;

	/**
	 * 删除项目专业表实例
	 * @param id 主键
	 * @throws BaseException 
	 */
	abstract void deleteSubjects(String id) throws BaseException;

	/**
	 * 删除项目专业表实例
	 * @param subjects 项目专业表实例
	 * @throws BaseException 
	 */
	abstract void deleteSubjects(Subjects subjects) throws BaseException;

	/**
	 * 删除项目专业表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteSubjects(String[] id) throws BaseException;

	/**
	 * 获得所有项目专业数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<Subjects> getSubjectsList(RollPage rollPage)
			throws BaseException;

	/**
	 * 获得所有项目专业数据集
	 * @param subjects 项目专业对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<Subjects> getSubjectsList(Subjects subjects)
			throws BaseException;

	/**
	 * 获得所有项目专业数据集
	 * @param rollPage 分页对象
	 * @param subjects 项目专业对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<Subjects> getSubjectsList(RollPage rollPage, Subjects subjects)
			throws BaseException;
	/**
	 * DWR远程验证根据专业编码判断有无，确保专业编码唯一
	 * 
	 */
	public List<Subjects> getSubjectsCodeList( Subjects subjects ) throws BaseException;
	
	
	
	public Subjects getSubjectsb(Subjects subjects) throws BaseException;
	
	
	/**
	 * 获得根据标准查询专业数据集
	 * @param subjects 项目专业对象
	 * @return
	 * @throws BaseException 
	 */
	public int getSubjectsCount( Subjects subjects ) throws BaseException;

}