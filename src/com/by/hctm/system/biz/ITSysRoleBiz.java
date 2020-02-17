package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.TSysRole;

public interface ITSysRoleBiz {

	/**
	 * 根据主键获得角色表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract TSysRole getTSysRole(Long id) throws BaseException;

	/**
	 * 添加角色信息
	 * @param demo 角色表实例
	 * @throws BaseException 
	 */
	abstract void saveTSysRole(TSysRole tSysRole) throws BaseException;

	/**
	 * 更新角色表实例
	 * @param tSysRole 角色表实例
	 * @throws BaseException 
	 */
	abstract void updateTSysRole(TSysRole tSysRole) throws BaseException;

	/**
	 * 删除角色表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteTSysRole(String id) throws BaseException;

	/**
	 * 删除角色表实例
	 * @param tSysRole 角色表实例
	 * @throws BaseException 
	 */
	abstract void deleteTSysRole(TSysRole tSysRole) throws BaseException;

	/**
	 * 删除角色表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteTSysRoles(String[] id) throws BaseException;

	/**
	 * 获得所有角色表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getTSysRoleList( RollPage rollPage ,String userId ) throws BaseException ;
	
	/**
	 * 获得所有角色表数据集
	 * @param tSysRole 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getTSysRoleList(  TSysRole tSysRole ) throws BaseException ;
	
	/**
	 * 获得所有角色表数据集
	 * @param rollPage 分页对象
	 * @param tSysRole 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getTSysRoleList(RollPage rollPage, TSysRole tSysRole)
			throws BaseException;
	
	
	/**
	 * 获得所有角色表数据集
	 * @param rollPage 分页对象
	 * @param tSysRole 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getSysRoleList( RollPage rollPage, TSysRole tSysRole ) throws BaseException;
	
	/**
	 * 获得所有角色表数据集
	 * @param rollPage 分页对象
	 * @param tSysRole 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getQuerySysRoleList( RollPage rollPage, TSysRole sysRole ) throws BaseException;
}