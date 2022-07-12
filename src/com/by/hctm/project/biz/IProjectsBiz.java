package com.by.hctm.project.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.project.entity.Egorder;
import com.by.hctm.project.entity.EgorderDetail;
import com.by.hctm.project.entity.Projects;
import com.by.hctm.project.entity.Tyxs212Id;



public interface IProjectsBiz {
	/**
	 * 获得亿格订单表数据集
	 * @author by 2015年3月11日09:27:41  
	 * @return
	 * @throws BaseException 
	 */
	public  List getOrdersList()
			throws BaseException;
	
	
	
	/**
	 * 获得所有亿格订单表数据集 
	 * @param Egorder 查询参数对象
	 * @return
	 * @author by 2015年3月11日20:20:58
	 * @throws BaseException 
	 */
	public List getOrdersList(   Egorder egorder ) throws BaseException;
	
	/**
	 * 根据主键获得标准表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract Egorder getEgorder(String id) throws BaseException;

	/**
	
	/**
	 * 根据主键获得项目台账表实例
	 * @param id 主键
	 * @return
	 * @author by 2015年3月12日10:50:35
	 * @throws BaseException 
	 */
	public EgorderDetail getEgorderDetail(Egorder  egorder) throws BaseException;
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 根据主键获得标准表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract Projects getProject(Long id) throws BaseException;

	/**
	 * 添加标准信息
	 * @param Projects 标准表实例
	 * @throws BaseException 
	 */
	abstract void saveProjects(Projects projects) throws BaseException;

	/**
	 * 更新标准表实例
	 * @param Projects 标准表实例
	 * @throws BaseException 
	 */
	abstract void updateProjects(Projects projects) throws BaseException;

	/**
	 * 删除标准表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteProjects(String id) throws BaseException;

	/**
	 * 删除标准表实例
	 * @param Projects 标准表实例
	 * @throws BaseException 
	 */
	abstract void deleteProjects(Projects projects) throws BaseException;

	/**
	 * 删除标准表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteProjectss(String[] id) throws BaseException;

	/**
	 * 获得所有标准表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getProjectsList(RollPage rollPage) throws BaseException;

	/**
	 * 获得所有标准表数据集
	 * @param Projects 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getProjectsList(Projects projects) throws BaseException;

	/**
	 * 获得所有标准表数据集
	 * @param rollPage 分页对象
	 * @param Projects 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getProjectsList(RollPage rollPage, Projects projects)
			throws BaseException;

	/**
	 * 关闭项目台账表实例
	 * @param projectId
	 * @throws BaseException
	 */
	abstract void updateByHql(Long projectId) throws BaseException;

}


