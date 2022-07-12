package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.TSysRoleRightInfo;

public interface ITSysRoleRightInfoBiz {

	/**
	 * 根据主键获得角色权限表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract TSysRoleRightInfo getTSysRoleRightInfo(Long id) throws BaseException;

	/**
	 * 添加角色权限信息
	 * @param demo 角色权限表实例
	 * @throws BaseException 
	 */
	abstract void saveTSysRoleRightInfo(TSysRoleRightInfo tSysRoleRightInfo) throws BaseException;

	/**
	 * 更新角色权限表实例
	 * @param tSysRoleRightInfo 角色权限表实例
	 * @throws BaseException 
	 */
	abstract void updateTSysRoleRightInfo(TSysRoleRightInfo tSysRoleRightInfo) throws BaseException;

	/**
	 * 删除角色权限表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteTSysRoleRightInfo(String id) throws BaseException;

	/**
	 * 删除角色权限表实例
	 * @param tSysRoleRightInfo 角色权限表实例
	 * @throws BaseException 
	 */
	abstract void deleteTSysRoleRightInfo(TSysRoleRightInfo tSysRoleRightInfo) throws BaseException;

	/**
	 * 删除角色权限表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteTSysRoleRightInfos(String[] id) throws BaseException;

	/**
	 * 获得所有角色权限表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getTSysRoleRightInfoList( RollPage rollPage  ) throws BaseException ;
	
	/**
	 * 获得所有角色权限表数据集
	 * @param tSysRoleRightInfo 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getTSysRoleRightInfoList(  TSysRoleRightInfo tSysRoleRightInfo ) throws BaseException ;
	
	/**
	 * 获得所有角色权限表数据集
	 * @param rollPage 分页对象
	 * @param tSysRoleRightInfo 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getTSysRoleRightInfoList(RollPage rollPage, TSysRoleRightInfo tSysRoleRightInfo)
			throws BaseException;

}