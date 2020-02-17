package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.TSysRoleUserInfo;

public interface ITSysRoleUserInfoBiz {

	/**
	 * 根据主键获得用户角色表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract TSysRoleUserInfo getTSysRoleUserInfo(Long id) throws BaseException;

	/**
	 * 添加用户角色信息
	 * @param demo 用户角色表实例
	 * @throws BaseException 
	 */
	abstract void saveTSysRoleUserInfo(TSysRoleUserInfo tSysRoleUserInfo) throws BaseException;

	/**
	 * 更新用户角色表实例
	 * @param tSysRoleUserInfo 用户角色表实例
	 * @throws BaseException 
	 */
	abstract void updateTSysRoleUserInfo(TSysRoleUserInfo tSysRoleUserInfo) throws BaseException;

	/**
	 * 删除用户角色表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteTSysRoleUserInfo(String id) throws BaseException;

	/**
	 * 删除用户角色表实例
	 * @param tSysRoleUserInfo 用户角色表实例
	 * @throws BaseException 
	 */
	abstract void deleteTSysRoleUserInfo(TSysRoleUserInfo tSysRoleUserInfo) throws BaseException;

	/**
	 * 删除用户角色表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteTSysRoleUserInfos(String[] id) throws BaseException;

	/**
	 * 获得所有用户角色表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getTSysRoleUserInfoList( RollPage rollPage  ) throws BaseException ;
	
	/**
	 * 获得所有用户角色表数据集
	 * @param tSysRoleUserInfo 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getTSysRoleUserInfoList(  TSysRoleUserInfo tSysRoleUserInfo ) throws BaseException ;
	
	/**
	 * 获得所有用户角色表数据集
	 * @param rollPage 分页对象
	 * @param tSysRoleUserInfo 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getTSysRoleUserInfoList(RollPage rollPage, TSysRoleUserInfo tSysRoleUserInfo)
			throws BaseException;

}