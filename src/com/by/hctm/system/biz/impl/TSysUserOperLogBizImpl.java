package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.biz.ITSysUserOperLogBiz;
import com.by.hctm.system.entity.TSysUserOperLog;

public class TSysUserOperLogBizImpl extends BaseBizImpl implements ITSysUserOperLogBiz  {
	
	/**
	 * 根据主键获得操作日志表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public TSysUserOperLog getTSysUserOperLog(Long id) throws BaseException {
		return (TSysUserOperLog)this.getObject(TSysUserOperLog.class, id);
	}
	
	/**
	 * 获得操作日志表实例
	 * @param tSysUserOperLog 操作日志表实例
	 * @return
	 * @throws BaseException 
	 */
	public TSysUserOperLog getTSysUserOperLog( TSysUserOperLog tSysUserOperLog ) throws BaseException {
		return (TSysUserOperLog)this.getObject(TSysUserOperLog.class, tSysUserOperLog.getUolId() );
	}
	
	/**
	 * 添加操作日志信息
	 * @param tSysUserOperLog 操作日志表实例
	 * @throws BaseException 
	 */
	public void saveTSysUserOperLog(TSysUserOperLog tSysUserOperLog) throws BaseException{
		this.saveObject( tSysUserOperLog ) ;
	}
	
	/**
	 * 更新操作日志表实例
	 * @param tSysUserOperLog 操作日志表实例
	 * @throws BaseException 
	 */
	public void updateTSysUserOperLog(TSysUserOperLog tSysUserOperLog) throws BaseException{
		this.updateObject( tSysUserOperLog ) ;
	}
	
	/**
	 * 删除操作日志表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteTSysUserOperLog(String id) throws BaseException {
		this.removeObject( this.getTSysUserOperLog( new Long(id) ) ) ;
	}
	
	/**
	 * 删除操作日志表实例
	 * @param tSysUserOperLog 操作日志表实例
	 * @throws BaseException 
	 */
	public void deleteTSysUserOperLog(TSysUserOperLog tSysUserOperLog) throws BaseException {
		this.removeObject( tSysUserOperLog ) ;
	}
	
	/**
	 * 删除操作日志表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteTSysUserOperLogs(String[] id) throws BaseException {
		this.removeBatchObject(TSysUserOperLog.class, id) ;
	}
	
	/**
	 * 获得所有操作日志表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List getTSysUserOperLogList( RollPage rollPage  ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from TSysUserOperLog de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有操作日志表数据集
	 * @param tSysUserOperLog 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getTSysUserOperLogList(  TSysUserOperLog tSysUserOperLog ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from TSysUserOperLog de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有操作日志表数据集
	 * @param rollPage 分页对象
	 * @param tSysUserOperLog 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getTSysUserOperLogList( RollPage rollPage, TSysUserOperLog tSysUserOperLog ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from TSysUserOperLog de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
}
