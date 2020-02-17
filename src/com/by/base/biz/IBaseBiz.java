package com.by.base.biz;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import com.by.base.dao.IBaseDao;
import com.by.base.exception.BaseException;
import com.by.base.utils.Condition;
import com.by.base.utils.RollPage;

public interface IBaseBiz {

	abstract void setDataSource(DataSource dataSource);

	abstract void setBaseDao(IBaseDao dao);

	abstract Connection getConnection();

	/**
	 * 保存对象
	 * 
	 * @param o
	 *            对象
	 * @throws BaseException
	 */
	abstract void saveObject(Object o) throws BaseException;

	/**
	 * 批量保存对象
	 * 
	 * @param list
	 *            对象List
	 * @throws BaseException
	 */
	abstract void saveBatchObject(List list) throws BaseException;

	/**
	 * 更新对象
	 * 
	 * @param o
	 *            对象
	 * @throws BaseException
	 */
	abstract void updateObject(Object o) throws BaseException;
	
	
	/**
	 * 更新对象
	 * 
	 * @param o
	 *            对象
	 * @throws BaseException
	 */
	abstract void updateObject(String entityName,Object entity) throws BaseException;
	
	
	/**
	 * 批量更新对象
	 * 
	 * @param list
	 *            对象List
	 * @throws BaseException
	 */
	abstract void updateBatchObject(List list) throws BaseException;

	/**
	 * 修改或是更新数据
	 */
	abstract void saveOrUpdateObject(Object o) throws BaseException;

	/**
	 * 删除对象
	 */
	abstract void removeObject(Object o) throws BaseException;

	/**
	 * 删除对象
	 * 
	 * @param clazz
	 *            对象Class
	 * @param id
	 *            对象ID
	 * @throws BaseException
	 */
	abstract void removeObject(Class clazz, Serializable id)
			throws BaseException;

	/**
	 * 批量删除对象
	 * 
	 * @param list
	 *            对象ID数组
	 * @throws BaseException
	 */
	abstract void removeBatchObject(Class clazz, Serializable[] id)
			throws BaseException;

	/**
	 * 批量删除数据
	 */
	abstract void removeBatchObject(Class clazz, List list)
			throws BaseException;

	/**
	 * 查询单个对象（对象ID�?
	 * 
	 * @param clazz
	 *            对象Class
	 * @param id
	 *            对象ID
	 * @return Object 对象
	 * @throws BaseException
	 */
	abstract Object getObject(Class clazz, Serializable id)
			throws BaseException;

	/**
	 * 查询�?��对象
	 * 
	 * @param clazz
	 *            对象Class
	 * @return List 对象列表
	 * @throws BaseException
	 */
	abstract List getObjects(Class clazz) throws BaseException;

	/**
	 * 数据查询，查询所有数�?
	 * 
	 * @param clazz 集合中指定对象类�?
	 * @param hql 查询语句
	 */
	abstract List getObjects(Class clazz, String hql) throws BaseException;

	/**
	 * 封装HQL查询
	 * 
	 * @param rollPage
	 *            翻页
	 * @param condition
	 *            条件
	 * @return List 结果�?
	 */
	abstract List getObjects(RollPage rollPage, Condition condition)
			throws BaseException;

	/**
	 * 封装HQL查询
	 * @param rollPage 翻页
	 * @param hql 
	 * @return
	 */
	abstract List getObjects(RollPage rollPage, String hql)
			throws BaseException;

	/**
	 * 封装HQL查询
	 * @param rollPage 翻页
	 * @param hql 
	 * @param paras  
	 * @return
	 */
	abstract List getObjects(RollPage rollPage, String hql, Object[] paras)
			throws BaseException;

	/**
	 * HQL查询 
	 * @param hql 
	 * @return
	 */
	abstract List getObjects(String hql) throws BaseException;

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
	abstract List getObjects(RollPage rollPage, String sql, String[] column)
			throws BaseException;

	/**
	 * 封装HQL查询
	 * 
	 * @param rollPage
	 *            翻页
	 * @param condition
	 *            条件
	 * @return List 结果�?
	 */
	abstract List getObjects(Condition condition) throws BaseException;

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
	abstract List getObjects(String sql, String[] column) throws BaseException;

	/**
	 * 取得SEQUENCE的�?
	 * @param seqName  SEQUENCE名称 
	 * @throws BaseException 
	 */
	abstract String getSequenceValue(String seqName ) throws BaseException ;
	
	/**
	 * 移除Session中的对象
	 * 
	 * @param obj
	 *            对象obj
	 * @throws BaseException
	 */
	abstract void removeSessionObject(Object obj) throws BaseException;

}