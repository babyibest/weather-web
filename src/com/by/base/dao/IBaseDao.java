package com.by.base.dao;

import java.io.Serializable;
import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.Condition;
import com.by.base.utils.RollPage;

public interface IBaseDao {

	/**
	 * 保存数据
	 */
	public void saveObject(Object o) throws BaseException ;

	/**
	 * 批量保存数据
	 * @param list
	 */
	public void saveBatchObject(List list) throws BaseException ;
	
	/**
	 * 更新数据
	 */
	public void updateObject(Object o) throws BaseException ;
	
	/**
	 * 更新数据
	 */
	public void updateObject(String entityName,Object entity) throws BaseException ;
	
	/**
	 * 更新数据
	 */
	public void updateObjectByHql(String hql) throws BaseException;
	/**
	 * 批量更新数据
	 * 
	 * @param list
	 */
	public void updateBatchObject(List list) throws BaseException ;
	
	/**
	 * 修改或是更新数据
	 */
	public void saveOrUpdateObject(Object o)throws BaseException ;
	
	/**
	 * 删除数据
	 */
	public void removeObject( Object o) throws BaseException ;
	
	/**
	 * 删除数据
	 */
	public void removeObject(Class clazz, Serializable id) throws BaseException ;

	/**
	 * 批量删除数据
	 */
	public void removeBatchObject(Class clazz, Serializable[] id) throws BaseException ;

	/**
	 * 批量删除数据
	 */
	public void removeBatchObject(Class clazz, List list) throws BaseException ;

	/**
	 * 统计数据条数
	 * 
	 * @param hql
	 * @return
	 * @throws BaseException
	 */
	public int count(String hql) throws BaseException ;
	
	/**
	 * 数据查询（根据ID查询�?
	 */
	public Object getObject(Class clazz, Serializable id) throws BaseException ;

	/**
	 * 数据查询，查询所有数�?
	 */
	public List getObjects(Class clazz)throws BaseException ;

	/**
	 * 数据查询，查询所有数�?
	 * 
	 * @param clazz 集合中指定对象类�?
	 * @param hql 查询语句
	 */
	public List getObjects(Class clazz, String hql )throws BaseException ;
	
	/**
	 * 封装HQL查询
	 * 
	 * @param rollPage
	 *            翻页
	 * @param condition
	 *            条件
	 * @return List 结果�?
	 */
	public List getObjects(RollPage rollPage, Condition condition) throws BaseException ;

	/**
	 * 封装HQL查询
	 * @param rollPage 翻页
	 * @param hql 
	 * @return
	 */
	public List getObjects(RollPage rollPage, String hql) throws BaseException ;

	/**
	 * 封装HQL查询
	 * @param rollPage 翻页
	 * @param hql 
	 * @param paras  
	 * @return
	 */
	public List getObjects(RollPage rollPage, String hql, Object[] paras) throws BaseException ;

	/**
	 * HQL查询 
	 * @param hql 
	 * @return
	 */
	public List getObjects(String hql)  throws BaseException ;

	/**
	 * 未经封装的SQL查询
	 * 
	 * @param rollPage
	 *            翻页
	 * @param sql
	 *            SQL语句
	 * @param column
	 *            列名
	 * @return List 结果�?
	 */
	public List getObjects(RollPage rollPage, String sql, String[] column) throws BaseException ;

	/**
	 * 封装HQL查询
	 * 
	 * @param rollPage
	 *            翻页
	 * @param condition
	 *            条件
	 * @return List 结果�?
	 */
	public List getObjects(Condition condition) throws BaseException ;
	
	/**
	 * 未经封装的SQL查询
	 * 
	 * @param rollPage
	 *            翻页
	 * @param sql
	 *            SQL语句
	 * @param column
	 *            列名
	 * @return List 结果�?
	 * @throws BaseException 
	 */
	public List getObjects(String sql, String[] column) throws BaseException ;

	/**
	 * 取得SEQUENCE的�?
	 * @param seqName  SEQUENCE名称 
	 * @throws BaseException 
	 */
	public String getSequenceValue(String seqName ) throws BaseException ;
	
	/**
	 * 移除Session中的对象
	 * 
	 * @param obj
	 *            对象obj
	 * @throws BaseException
	 */
	public void removeSessionObject(Object obj) throws BaseException ;
}