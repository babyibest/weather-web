package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.system.biz.ITSysRoleBiz;
import com.by.hctm.system.entity.TSysRole;

public class TSysRoleBizImpl extends BaseBizImpl implements ITSysRoleBiz  {
	
	/**
	 * 根据主键获得角色表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public TSysRole getTSysRole(Long id) throws BaseException {
		return (TSysRole)this.getObject(TSysRole.class, id);
	}
	
	/**
	 * 获得角色表实例
	 * @param demo 角色表实例
	 * @return
	 * @throws BaseException 
	 */
	public TSysRole getTSysRole( TSysRole tSysRole ) throws BaseException {
		return (TSysRole)this.getObject(TSysRole.class, tSysRole.getRoleId() );
	}
	
	/**
	 * 添加角色信息
	 * @param tSysRole 角色表实例
	 * @throws BaseException 
	 */
	public void saveTSysRole(TSysRole tSysRole) throws BaseException{
		this.saveObject( tSysRole ) ;
	}
	
	/**
	 * 更新角色表实例
	 * @param tSysRole 角色表实例
	 * @throws BaseException 
	 */
	public void updateTSysRole(TSysRole tSysRole) throws BaseException{
		this.updateObject( tSysRole ) ;
	}
	
	/**
	 * 删除角色表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteTSysRole(String id) throws BaseException {
		this.removeObject( this.getTSysRole( new Long(id) ) ) ;
	}
	
	/**
	 * 删除角色表实例
	 * @param tSysRole 角色表实例
	 * @throws BaseException 
	 */
	public void deleteTSysRole(TSysRole tSysRole) throws BaseException {
		this.removeObject( tSysRole ) ;
	}
	
	/**
	 * 删除角色表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteTSysRoles(String[] id) throws BaseException {
		this.removeBatchObject(TSysRole.class, id) ;
	}
	
	/**
	 * 获得所有角色表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List getTSysRoleList( RollPage rollPage  ,String userId ) throws BaseException {
		StringBuffer hql = new StringBuffer("  from TSysRole t where t.roleId not in (select s.roleId from TSysRoleUserInfo s where s.userId = " );
			hql.append( new Long(userId ) );
		hql.append(") order by t.roleId desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	
	
	/**
	 * 获得所有角色表数据集
	 * @param tSysRole 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getTSysRoleList(  TSysRole tSysRole ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from TSysRole de where 1 = 1 " );
		hql.append(" and isUsable ='0' order by de.roleId desc ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有角色表数据集
	 * @param tSysRole 查询参数对象
	 * @return
	 * @throws BaseException 
	 */		//	getSysRoleList
	public List getTSysRoleList(  RollPage rollPage, TSysRole tSysRole ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from TSysRole de where 1 = 1 " );
		if(tSysRole!=null){
			if(!StringUtil.isBlank(tSysRole.getRoleName())){
				hql.append(" and de.roleName like '%").append(tSysRole.getRoleName()).append("%'");
			}
		}
//		if(!tSysRole.getRoleName().equals("") || tSysRole.getRoleName()!=null){
//			hql.append("de.roleName like '%").append(tSysRole.getRoleName()).append("'") ;
//		}if(tSysRole==null){
		//	hql.append(" order by de.id desc ");
//		}
		hql.append(" and isUsable = '0' order by de.roleCode ASC desc ");
		return this.getObjects( hql.toString() );
	}
	
	
	/**
	 * 获得所有角色表数据集
	 * @param rollPage 分页对象
	 * @param tSysRole 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getSysRoleList( RollPage rollPage, TSysRole tSysRole ) throws BaseException {
		StringBuffer hql = new StringBuffer(" select t.ruId,s.roleCode,s.roleName,s.roleDesc,s.isUsable from TSysRoleUserInfo t ," +
				"TSysRole s where s.roleId = t.roleId " );
		if(tSysRole != null){
			if(!StringUtil.isBlank(tSysRole.getRoleId())){
			hql.append(" and t.userId = ").append(tSysRole.getRoleId());
		}
		}
		hql.append(" and s.isUsable =0  order by t.userId desc ");
		return this.getObjects(rollPage, hql.toString() );
	}

	public List getQuerySysRoleList(RollPage rollPage, TSysRole sysRole)
			throws BaseException {
		StringBuffer hql = new StringBuffer(" from TSysRole de where 1 = 1 " );
		if(!sysRole.getRoleName().equals("") || sysRole.getRoleName()!=null){
			hql.append(" and de.roleName like '%").append(sysRole.getRoleName()).append("%'") ;
		}
		hql.append(" and isUsable = '0'  order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}

	
	
}
