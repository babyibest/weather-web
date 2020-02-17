package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.system.biz.ITSysRoleRightInfoBiz;
import com.by.hctm.system.entity.TSysRoleRightInfo;


public class TSysRoleRightInfoBizImpl extends BaseBizImpl implements ITSysRoleRightInfoBiz  {
	
	/**
	 * 根据主键获得角色权限表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public TSysRoleRightInfo getTSysRoleRightInfo(Long id) throws BaseException {
		return (TSysRoleRightInfo)this.getObject(TSysRoleRightInfo.class, id);
	}
	
	/**
	 * 获得角色权限表实例
	 * @param tSysRoleRightInfo 角色权限表实例
	 * @return
	 * @throws BaseException 
	 */
	public TSysRoleRightInfo getTSysRoleRightInfo( TSysRoleRightInfo tSysRoleRightInfo ) throws BaseException {
		return (TSysRoleRightInfo)this.getObject(TSysRoleRightInfo.class, tSysRoleRightInfo.getRrId() );
	}
	
	/**
	 * 添加角色权限信息
	 * @param tSysRoleRightInfo 角色权限表实例
	 * @throws BaseException 
	 */
	public void saveTSysRoleRightInfo(TSysRoleRightInfo tSysRoleRightInfo) throws BaseException{
		this.saveObject( tSysRoleRightInfo ) ;
	}
	
	/**
	 * 更新角色权限表实例
	 * @param tSysRoleRightInfo 角色权限表实例
	 * @throws BaseException 
	 */
	public void updateTSysRoleRightInfo(TSysRoleRightInfo tSysRoleRightInfo) throws BaseException{
		this.updateObject( tSysRoleRightInfo ) ;
	}
	
	/**
	 * 删除角色权限表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteTSysRoleRightInfo(String id) throws BaseException {
		this.removeObject( this.getTSysRoleRightInfo( new Long(id) ) ) ;
	}
	
	/**
	 * 删除角色权限表实例
	 * @param tSysRoleRightInfo 角色权限表实例
	 * @throws BaseException 
	 */
	public void deleteTSysRoleRightInfo(TSysRoleRightInfo tSysRoleRightInfo) throws BaseException {
		this.removeObject( tSysRoleRightInfo ) ;
	}
	
	/**
	 * 删除角色权限表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteTSysRoleRightInfos(String[] id) throws BaseException {
		this.removeBatchObject(TSysRoleRightInfo.class, id) ;
	}
	
	/**
	 * 获得所有角色权限表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List getTSysRoleRightInfoList( RollPage rollPage  ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from TSysRoleRightInfo de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有角色权限表数据集
	 * @param tSysRoleRightInfo 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getTSysRoleRightInfoList(  TSysRoleRightInfo tSysRoleRightInfo ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from TSysRoleRightInfo de where 1 = 1 " );
		if(tSysRoleRightInfo!=null){
			if(!StringUtil.isBlank(tSysRoleRightInfo.getRoleId())){
				hql.append(" and de.roleId = ").append(tSysRoleRightInfo.getRoleId());
			}
		}
		hql.append(" order by de.id desc ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有角色权限表数据集
	 * @param rollPage 分页对象
	 * @param tSysRoleRightInfo 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getTSysRoleRightInfoList( RollPage rollPage, TSysRoleRightInfo tSysRoleRightInfo ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from TSysRoleRightInfo de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
}
