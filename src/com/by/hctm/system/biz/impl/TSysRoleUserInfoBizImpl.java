package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.system.biz.ITSysRoleUserInfoBiz;
import com.by.hctm.system.entity.TSysRoleUserInfo;

public class TSysRoleUserInfoBizImpl extends BaseBizImpl implements ITSysRoleUserInfoBiz  {
	
	/**
	 * 根据主键获得角色用户表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public TSysRoleUserInfo getTSysRoleUserInfo(Long id) throws BaseException {
		return (TSysRoleUserInfo)this.getObject(TSysRoleUserInfo.class, id);
	}
	
	/**
	 * 获得用户角色管理表实例
	 * @param tSysRoleUserInfo 用户角色管理表实例
	 * @return
	 * @throws BaseException 
	 */
	public TSysRoleUserInfo getTSysRoleUserInfo( TSysRoleUserInfo tSysRoleUserInfo ) throws BaseException {
		return (TSysRoleUserInfo)this.getObject(TSysRoleUserInfo.class, tSysRoleUserInfo.getRuId() );
	}
	
	/**
	 * 添加用户角色管理信息
	 * @param tSysRoleUserInfo 用户角色管理表实例
	 * @throws BaseException 
	 */
	public void saveTSysRoleUserInfo(TSysRoleUserInfo tSysRoleUserInfo) throws BaseException{
		this.saveObject( tSysRoleUserInfo ) ;
	}
	
	/**
	 * 更新用户角色管理表实例
	 * @param tSysRoleUserInfo 用户角色管理表实例
	 * @throws BaseException 
	 */
	public void updateTSysRoleUserInfo(TSysRoleUserInfo tSysRoleUserInfo) throws BaseException{
		this.updateObject( tSysRoleUserInfo ) ;
	}
	
	/**
	 * 删除用户角色管理表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteTSysRoleUserInfo(String id) throws BaseException {
		this.removeObject( this.getTSysRoleUserInfo( new Long(id) ) ) ;
	}
	
	/**
	 * 删除用户角色管理表实例
	 * @param tSysRoleUserInfo 用户角色管理表实例
	 * @throws BaseException 
	 */
	public void deleteTSysRoleUserInfo(TSysRoleUserInfo tSysRoleUserInfo) throws BaseException {
		this.removeObject( tSysRoleUserInfo ) ;
	}
	
	/**
	 * 删除用户角色管理表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteTSysRoleUserInfos(String[] id) throws BaseException {
		this.removeBatchObject(TSysRoleUserInfo.class, id) ;
	}
	
	/**
	 * 获得所有用户角色管理表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List getTSysRoleUserInfoList( RollPage rollPage  ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from TSysRoleUserInfo de where 1 = 1 " );
			
		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有用户角色管理表数据集
	 * @param tSysRoleUserInfo 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getTSysRoleUserInfoList(  TSysRoleUserInfo tSysRoleUserInfo ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from TSysRoleUserInfo de where 1 = 1 " );
			if(tSysRoleUserInfo != null){
				if(!StringUtil.isBlank(tSysRoleUserInfo.getRoleId())){
					//hql.append("").append(tSysRoleUserInfo.getRoleId());
				}
			}
		hql.append(" order by de.id desc ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有用户角色管理表数据集
	 * @param rollPage 分页对象
	 * @param tSysRoleUserInfo 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getTSysRoleUserInfoList( RollPage rollPage, TSysRoleUserInfo tSysRoleUserInfo ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from TSysRoleUserInfo de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
}
