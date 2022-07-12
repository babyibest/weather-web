package com.by.hctm.common.biz.impl;

import java.util.Date;
import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.hctm.common.TableStatus;
import com.by.hctm.common.biz.ITSysUserInoutLogBiz;
import com.by.hctm.system.entity.TSysUserInoutLog;
public class TSysUserInoutLogImpl extends BaseBizImpl implements ITSysUserInoutLogBiz   {
	
	/**
	 * 根据主键获得登录日志表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public TSysUserInoutLog getTSysUserInoutLog(Long id) throws BaseException {
		return (TSysUserInoutLog)this.getObject(TSysUserInoutLog.class, id);
	}
	
	/**
	 * 添加登录日志信息
	 * @param TSysUserInoutLog 登录日志表实例
	 * @throws BaseException 
	 */
	public void saveTSysUserInoutLog(TSysUserInoutLog TSysUserInoutLog) throws BaseException{
		this.saveObject( TSysUserInoutLog ) ;
	}
	
	/**
	 * 更新登录日志表实例
	 * @param TSysUserInoutLog 登录日志表实例
	 * @throws BaseException 
	 */
	public void updateTSysUserInoutLog(TSysUserInoutLog TSysUserInoutLog) throws BaseException{
		this.updateObject( TSysUserInoutLog ) ;
	}
	
	/**
	 * 删除登录日志表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteTSysUserInoutLog(String id) throws BaseException {
		this.removeObject( this.getTSysUserInoutLog( new Long(id) ) ) ;
	}
	
	/**
	 * 删除登录日志表实例
	 * @param TSysUserInoutLog 登录日志表实例
	 * @throws BaseException 
	 */
	public void deleteTSysUserInoutLog(TSysUserInoutLog TSysUserInoutLog) throws BaseException {
		this.removeObject( TSysUserInoutLog ) ;
	}
	
	/**
	 * 删除登录日志表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteTSysUserInoutLogs(String[] id) throws BaseException {
		this.removeBatchObject(TSysUserInoutLog.class, id) ;
	}
	
	/**
	 * 记录用户退出日志
	 * @param sessionPath 
	 * @throws BaseException 
	 */
	public void userLogoutLog( String sessionPath )  throws BaseException {
		
		StringBuffer hql = new StringBuffer(" From TSysUserInoutLog log where 1=1 and log.sessionPath = '" + sessionPath + "' " );
		List gList = this.getObjects( hql.toString() );
			
		if( gList != null && gList.size()>0 ) {
			TSysUserInoutLog userLog = (TSysUserInoutLog) gList.get( 0 ) ;
			userLog.setLogoutDate( new Date() ) ;
			userLog.setLineStatus( TableStatus.COMMON_STATUS_INVALID ) ;
			
			this.updateTSysUserInoutLog( userLog ) ;
		}
			
	}
	
}
