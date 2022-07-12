package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.biz.ITSysModuleInfoBiz;
import com.by.hctm.system.entity.TSysModuleInfo;

public class TSysModuleInfoBizImpl extends BaseBizImpl implements ITSysModuleInfoBiz  {
	
	/**
	 * 根据主键获得功能信息表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public TSysModuleInfo getTSysModuleInfo(Long id) throws BaseException {
		return (TSysModuleInfo)this.getObject(TSysModuleInfo.class, id);
	}
	
	/**
	 * 获得功能信息表实例
	 * @param tSysModuleInfo 功能信息表实例
	 * @return
	 * @throws BaseException 
	 */
	public TSysModuleInfo getTSysModuleInfo( TSysModuleInfo tSysModuleInfo ) throws BaseException {
		return (TSysModuleInfo)this.getObject(TSysModuleInfo.class, tSysModuleInfo.getModuleId() );
	}
	
	/**
	 * 添加功能信息信息
	 * @param tSysModuleInfo 功能信息表实例
	 * @throws BaseException 
	 */
	public void saveTSysModuleInfo(TSysModuleInfo tSysModuleInfo) throws BaseException{
		this.saveObject( tSysModuleInfo ) ;
	}
	
	/**
	 * 更新功能信息表实例
	 * @param tSysModuleInfo 功能信息表实例
	 * @throws BaseException 
	 */
	public void updateTSysModuleInfo(TSysModuleInfo tSysModuleInfo) throws BaseException{
		this.updateObject( tSysModuleInfo ) ;
	}
	
	/**
	 * 删除功能信息表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteTSysModuleInfo(String id) throws BaseException {
		this.removeObject( this.getTSysModuleInfo( new Long(id) ) ) ;
	}
	
	/**
	 * 删除功能信息表实例
	 * @param tSysModuleInfo 功能信息表实例
	 * @throws BaseException 
	 */
	public void deleteTSysModuleInfo(TSysModuleInfo tSysModuleInfo) throws BaseException {
		this.removeObject( tSysModuleInfo ) ;
	}
	
	/**
	 * 删除功能信息表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteTSysModuleInfos(String[] id) throws BaseException {
		this.removeBatchObject(TSysModuleInfo.class, id) ;
	}
	
	/**
	 * 获得所有功能信息表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List getTSysModuleInfoList( RollPage rollPage  ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from TSysModuleInfo de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有功能信息表数据集
	 * @param tSysModuleInfo 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getTSysModuleInfoList(  TSysModuleInfo tSysModuleInfo ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from TSysModuleInfo de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有功能信息表数据集
	 * @param rollPage 分页对象
	 * @param tSysModuleInfo 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getTSysModuleInfoList( RollPage rollPage, TSysModuleInfo tSysModuleInfo ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from TSysModuleInfo de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
}
