package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.biz.IRightsBIZ;
import com.by.hctm.system.entity.Rights;
@SuppressWarnings("unchecked")
public class RightsBizImpl extends BaseBizImpl implements IRightsBIZ   {
	/**
	 * 根据主键获得权限表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public Rights getRights(Long id) throws BaseException {
		return (Rights)this.getObject(Rights.class, id);
	}
	
	/**
	 * 添加权限表信息
	 * @param Rights 权限表实例
	 * @throws BaseException 
	 */
	public void saveRights(Rights rights) throws BaseException{
		this.saveObject( rights ) ;
	}
	
	/**
	 * 更新权限表实例
	 * @param rights 权限表实例
	 * @throws BaseException 
	 */
	public void updateRights(Rights rights ) throws BaseException{
		this.updateObject( rights ) ;
	}
	
	/**
	 * 删除权限表实例
	 * @param id 主键
	 * @throws BaseException 
	 */
	public void deleteRights(Long id) throws BaseException {
		this.removeObject( this.getRights( new Long(id) ) ) ;
	}
	
	/**
	 * 删除权限表实例
	 * @param rights 权限表实例
	 * @throws BaseException 
	 */
	public void deleteRights(Rights rights) throws BaseException {
		this.removeObject( rights ) ;
	}
	
	/**
	 * 删除权限表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteDemos(String[] id) throws BaseException {
		this.removeBatchObject(Rights.class, id) ;
	} 
	
	/**
	 * 获得所有权限数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List<Rights> getRightsList( RollPage rollPage ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Rights ex where 1 = 1 " );

		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有权限数据集
	 * @param rights 权限对象
	 * @return
	 * @throws BaseException 
	 */
	public List<Rights> getRightsList( Rights rights ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Rights sub where 1 = 1 " );
		hql.append(" and isUsable = '0' order by sub.rightCode ASC ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有权限数据集
	 * @param rollPage 分页对象
	 * @param rights 权限对象
	 * @return
	 * @throws BaseException 
	 */
	public List<Rights> getRightsList( RollPage rollPage, Rights rights ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Rights sub where 1 = 1 " );
		hql.append(" and isUsable = '0' order by sub.rightCode ASC");
		return this.getObjects(rollPage, hql.toString() );
	}

}
