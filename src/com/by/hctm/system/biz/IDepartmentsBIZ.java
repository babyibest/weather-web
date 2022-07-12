package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.manpower.entity.Users;
import com.by.hctm.system.entity.Departments;

public interface IDepartmentsBIZ {

	/**
	 * 根据主键获得部门表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract Departments getDepartments(Long id) throws BaseException;

	/**
	 * 添加部门表信息
	 * @param Departments 部门表实例
	 * @throws BaseException 
	 */
	abstract void saveDepartments(Departments departments) throws BaseException;

	/**
	 * 更新部门表实例
	 * @param departments 部门表实例
	 * @throws BaseException 
	 */
	abstract void updateDepartments(Departments departments)
			throws BaseException;

	/**
	 * 更新部门表实例-修改本级和本级所有子节点为不可用
	 * @param departments 部门表实例
	 * @throws BaseException 
	 */
	abstract void updateDepartmentsBySelflevCode(  Departments departments  )
		throws BaseException;
	
	/**
	 * 删除部门表实例
	 * @param id 主键
	 * @throws BaseException 
	 */
	abstract void deleteDepartments(Long id) throws BaseException;
		
	/**
	 * 删除部门表实例
	 * @param departments 部门表实例
	 * @throws BaseException 
	 */
	abstract void deleteDepartments(Departments departments)
			throws BaseException;

	/**
	 * 删除部门表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteDemos(String[] id) throws BaseException;

	/**
	 * 获得所有部门数量
	 * @param departments 部门对象
	 * @return
	 * @throws BaseException 
	 */
	public int getDepartmentsCount( Departments departments ) throws BaseException ;
	
	/**
	 * 获得所有部门数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<Departments> getDepartmentsList(RollPage rollPage)
			throws BaseException;

	/**
	 * 获得所有部门数据集
	 * @param departments 部门对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<Departments> getDepartmentsList(Departments departments)
			throws BaseException;

	/**
	 * 获得所有部门数据集
	 * @param rollPage 分页对象
	 * @param departments 部门对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<Departments> getDepartmentsList(RollPage rollPage,
			Departments departments) throws BaseException;
	

	/**
	 * 获得所有部门数据集
	 * @param 
	 * @param 
	 * @return List对象
	 * @throws BaseException 
	 */
	public List<Departments> getTreeDepartmentsList() throws BaseException ;
	/**
	 * 获得所有人员表数据集
	 * @param 
	 * @param 
	 * @return List对象
	 * @throws BaseException 
	 */
	public List<Users> getUsersList( RollPage rollPage) throws BaseException ;
	/**
	 * 获得根据部门编号数据集
	 * @param 
	 * @param 
	 * @return List对象
	 * @throws BaseException 
	 */
	public List<Departments> getDepartmentsCodeList(Departments departments ) throws BaseException ;
	/**
	 * 获得上级部门编号数据集，如果有下级部门，上级部门不允许删除
	 * @return
	 * @throws BaseException 
	 */
	public List<Departments> getDepartmentsupDepIdList(Departments departments ) throws BaseException;
	
	/**
	 * 获得所有部门人员视图
	 * @return
	 * @throws BaseException 
	 */
	abstract List getAllDeptRoot() throws BaseException ;
}