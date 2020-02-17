package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.TableStatus;
import com.by.hctm.system.biz.ITSysDictBiz;
import com.by.hctm.system.entity.TSysDict;

public class TSysDictBizImpl extends BaseBizImpl implements ITSysDictBiz  {
	
	/**
	 * 根据主键获得字典信息表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public TSysDict getTSysDict(Long id) throws BaseException {
		return (TSysDict)this.getObject(TSysDict.class, id);
	}
	
	/**
	 * 获得字典信息表实例
	 * @param tSysDict 字典信息表实例
	 * @return
	 * @throws BaseException 
	 */
	public TSysDict getTSysDict( TSysDict tSysDict ) throws BaseException {
		return (TSysDict)this.getObject(TSysDict.class, tSysDict.getDictId() );
	}
	
	/**
	 * 添加字典信息信息
	 * @param tSysDict 字典信息表实例
	 * @throws BaseException 
	 */
	public void saveTSysDict(TSysDict tSysDict) throws BaseException{
		this.saveObject( tSysDict ) ;
	}
	
	/**
	 * 更新字典信息表实例
	 * @param tSysDict 字典信息表实例
	 * @throws BaseException 
	 */
	public void updateTSysDict(TSysDict tSysDict) throws BaseException{
		this.updateObject( tSysDict ) ;
	}
	
	/**
	 * 删除字典信息表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteTSysDict(String id) throws BaseException {
		this.removeObject( this.getTSysDict( new Long(id) ) ) ;
	}
	
	/**
	 * 删除字典信息表实例
	 * @param tSysDict 字典信息表实例
	 * @throws BaseException 
	 */
	public void deleteTSysDict(TSysDict tSysDict) throws BaseException {
		this.removeObject( tSysDict ) ;
	}
	
	/**
	 * 删除字典信息表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteTSysDicts(String[] id) throws BaseException {
		this.removeBatchObject(TSysDict.class, id) ;
	}
	
	/**
	 * 获得所有字典信息表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List getTSysDictList( RollPage rollPage  ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from TSysDict de where 1 = 1 " );
		
		hql.append( " and de.isUsable = '" ).append( TableStatus.COMMON_STATUS_VALID ).append("' ") ;
		
		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有字典信息表数据集
	 * @param tSysDict 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getTSysDictList(  TSysDict tSysDict ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from TSysDict de where 1 = 1 " );
		if( tSysDict != null ) {
			// 父类ID
			if( tSysDict.getParentDictId() != null ) {
				hql.append(" and de.parentDictId = " ).append( tSysDict.getParentDictId() ) ;
			}
		}
		
		hql.append( " and de.isUsable = '" ).append( TableStatus.COMMON_STATUS_VALID ).append("' ") ;
		
		hql.append(" order by de.dictOrder asc ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有字典信息表数据集
	 * @param rollPage 分页对象
	 * @param tSysDict 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getTSysDictList( RollPage rollPage, TSysDict tSysDict ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from TSysDict de where 1 = 1 " );

		if( tSysDict != null ) {
			// 父类ID
			if( tSysDict.getParentDictId() != null ) {
				hql.append(" and de.parentDictId = " ).append( tSysDict.getParentDictId() ) ;
			}
		}
		
		hql.append( " and de.isUsable = '" ).append( TableStatus.COMMON_STATUS_VALID ).append("' ") ;
		
		hql.append(" order by de.dictOrder asc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
}
