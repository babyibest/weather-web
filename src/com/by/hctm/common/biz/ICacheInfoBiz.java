package com.by.hctm.common.biz;

import java.util.List;
import java.util.Map;

import com.by.base.exception.BaseException;
import com.by.hctm.common.exception.PersistenceException;

public interface ICacheInfoBiz {

	/**
	 * 取得指定缓存的总数
	 * @param cacheName 缓存名称 
	 * @return
	 */
	abstract int getCacheInfoSize( String cacheName ) ;
	
	/**
	 * 转换缓存信息为Map方式 key: id value: po
	 * @param cacheName 缓存名称 
	 * @return
	 */
	abstract Map convertCacheInfoToMap( Object cacheName ) ;
	
	/**
	 * 转换缓存信息为Map方式 key: id value: po
	 * @param cacheName 缓存名称 
	 * @return
	 */
	abstract Map convertCacheInfoToMap( Object keyValue, Object cacheName ) ;
	
	/**
	 * 初始化数据字典数据同步到内存
	 * @param initType 同步类型 
	 * @author Ted 2010-01-05
	 * @return
	 * @throws BaseException 
	 */
	abstract List initCacheInfos(String initType) throws BaseException;

	/**
	 * 取得SEQUENCE的值
	 * @param seqName  SEQUENCE名称 
	 * @throws BaseException 
	 */
	abstract String findSequenceValue(String seqName) throws BaseException;
	
	/**
	 * 取得流程申请信息
	 * @param billId 单据编号 可为空
	 * @param billType 流程类型（流程编号） 可为空
	 * @param isUsable 是否有效 0 有效 1 无效 可为空
	 * @author dq 2012-11-12
	 * @return
	 * @throws PersistenceException
	 */
	abstract String getProcessInfo(Long billId, String billType, String isUsable ) throws BaseException ;

}