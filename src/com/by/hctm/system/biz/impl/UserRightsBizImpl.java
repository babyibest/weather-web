package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.biz.IUserRightsBIZ;
import com.by.hctm.system.entity.UserRights;

public class UserRightsBizImpl extends BaseBizImpl implements IUserRightsBIZ {

	/**
	 * 根据主键获得用户权限表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public UserRights getUserRights(Long id) throws BaseException {
		return (UserRights)this.getObject(UserRights.class, id);
	}
	
	/**
	 * 添加用户权限表信息
	 * @param userRights 用户权限表实例
	 * @throws BaseException 
	 */
	public void saveUserRights(UserRights userRights) throws BaseException{
		this.saveObject( userRights ) ;
	}
	
	/**
	 * 更新用户权限表实例
	 * @param userRights 用户权限表实例
	 * @throws BaseException 
	 */
	public void updateUserRights(UserRights userRights ) throws BaseException{
		this.updateObject( userRights ) ;
	}
	
	/**
	 * 删除用户权限表实例
	 * @param id 主键
	 * @throws BaseException 
	 */
	public void deleteUserRights(String id) throws BaseException {
		this.removeObject( this.getUserRights( new Long(id) ) ) ;
	}
	
	/**
	 * 删除用户权限表实例
	 * @param userRights 用户权限表实例
	 * @throws BaseException 
	 */
	public void deleteUserRights(UserRights userRights) throws BaseException {
		this.removeObject( userRights ) ;
	}
	
	/**
	 * 删除用户权限表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteDemos(String[] id) throws BaseException {
		this.removeBatchObject(UserRights.class, id) ;
	} 
	
	/**
	 * 获得所有用户权限数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List<UserRights> getUserRightsList( RollPage rollPage ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from UserRights ex where 1 = 1 " );

		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有用户权限数据集
	 * @param userRights 用户权限对象
	 * @return
	 * @throws BaseException 
	 */
	public List<UserRights> getUserRightsList( UserRights userRights ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from UserRights sub where 1 = 1 " );

		if( userRights != null ) {
		}
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有用户权限数据集
	 * @param rollPage 分页对象
	 * @param userRights 用户权限对象
	 * @return
	 * @throws BaseException 
	 */
	public List<UserRights> getUserRightsList( RollPage rollPage, UserRights userRights ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from UserRights sub where 1 = 1 " );

		if( userRights != null ) {
		}
		return this.getObjects(rollPage, hql.toString() );
	}
	 
}
