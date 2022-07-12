package com.by.base.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.by.base.dao.IBaseDao;
import com.by.base.exception.BaseException;
import com.by.base.exception.ExceptionRescoure;
import com.by.base.utils.Column;
import com.by.base.utils.Condition;
import com.by.base.utils.Group;
import com.by.base.utils.Operator;
import com.by.base.utils.Parameter;
import com.by.base.utils.RollPage;

public class BaseDaoHibernateImpl extends HibernateDaoSupport implements IBaseDao {

	protected final Log log = LogFactory.getLog(getClass());
	
	/**
	 * 保存数据
	 */
	public void saveObject(Object o) throws BaseException {
		try {
			getHibernateTemplate().save(o);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new BaseException(ExceptionRescoure.HIBERNATE_SAVE_EXCEPTION);
		}
	}

	/**
	 * 批量保存数据
	 * @param list
	 */
	public void saveBatchObject(List list) throws BaseException {
		Session session = getSession();
		//Transaction tx = session.beginTransaction();
		try {
			int i = 0;
			Iterator it = list.iterator();
			while (it.hasNext()) {
				session.save(it.next());
				// 当记录数达到20条时，将数据写入数据库，并清理内存
				if (i != 0 && i + 1 % 20 == 0) {
					session.flush();
					session.clear();
				}
			}

			session.flush();
			session.clear();

			//tx.commit();
		} catch (Exception ex) {
			//tx.rollback();
			log.error(ex.getMessage());
			throw	new BaseException(ExceptionRescoure.HIBERNATE_BATCH_SAVE_EXCEPTION);
		}
	}
	
	/**
	 * 更新数据
	 */
	public void updateObject(Object o) throws BaseException{
		try {
			getHibernateTemplate().update(o);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw	new BaseException(ExceptionRescoure.HIBERNATE_UPDATE_EXCEPTION);
		}
	}
	
	/**
	 * 更新数据
	 */
	public void updateObject(String entityName, Object entity) throws BaseException{
		try {
			getHibernateTemplate().update(entityName, entity);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw	new BaseException(ExceptionRescoure.HIBERNATE_UPDATE_EXCEPTION);
		}
	}

	/**
	 * 更新数据
	 */
	public void updateObjectByHql(String hql) throws BaseException{
		try {
			super.getSession().createQuery(hql).executeUpdate();
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw	new BaseException(ExceptionRescoure.HIBERNATE_UPDATE_EXCEPTION);
		}
	}

	/**
	 * 批量更新数据
	 * 
	 * @param list
	 */
	public void updateBatchObject(List list) throws BaseException {
		Session session = getSession();
//		Transaction tx = session.beginTransaction();
		try {
			int i = 0;
			Iterator it = list.iterator();
			while (it.hasNext()) {
				session.update(it.next());
				// 当记录数达到20条时，将数据写入数据库，并清理内存
				if (i != 0 && i + 1 % 20 == 0) {
					session.flush();
					session.clear();
				}
			}

			session.flush();
			session.clear();

//			tx.commit();
		} catch (Exception ex) {
//			tx.rollback();
			log.error(ex.getMessage());
			throw	new BaseException(
					ExceptionRescoure.HIBERNATE_BATCH_UPDATE_EXCEPTION);
		}
	}
	
	/**
	 * 修改或是更新数据
	 */
	public void saveOrUpdateObject(Object o)throws BaseException {
		try {
			getHibernateTemplate().saveOrUpdate(o);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new BaseException(ExceptionRescoure.HIBERNATE_SAVE_EXCEPTION);
		}
	}
	
	/**
	 * 删除数据
	 */
	public void removeObject( Object o) throws BaseException {
		try {
			getHibernateTemplate().delete( o );
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw	new BaseException(ExceptionRescoure.HIBERNATE_DELETE_EXCEPTION);
		}
	}
	
	/**
	 * 删除数据
	 */
	public void removeObject(Class clazz, Serializable id) throws BaseException {
		try {
			getHibernateTemplate().delete(getObject(clazz, id));
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw	new BaseException(ExceptionRescoure.HIBERNATE_DELETE_EXCEPTION);
		}
	}

	/**
	 * 批量删除数据
	 */
	public void removeBatchObject(Class clazz, Serializable[] id) throws BaseException {
		Session session = getSession();
//		Transaction tx = session.beginTransaction();
		try {
			for (int i = 0; i < id.length; i++) {
				session.delete(getObject(clazz, Long.valueOf(id[i].toString())));
				// 当记录数达到20条时，将数据写入数据库，并清理内存
				if (i != 0 && i + 1 % 20 == 0) {
					session.flush();
					session.clear();
				}
			}

			session.flush();
			session.clear();

//			tx.commit();
		} catch (Exception ex) {
//			tx.rollback();
			log.error(ex.getMessage());
			throw	new BaseException(
					ExceptionRescoure.HIBERNATE_BATCH_DELETE_EXCEPTION);
		}
	}

	/**
	 * 批量删除数据
	 */
	public void removeBatchObject(Class clazz, List list) throws BaseException {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		try {
			for (int i = 0; i < list.size(); i++) {
				session.delete(list.get(i));
				// 当记录数达到20条时，将数据写入数据库，并清理内存
				if (i != 0 && i + 1 % 20 == 0) {
					session.flush();
					session.clear();
				}
			}

			session.flush();
			session.clear();

			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			log.error(ex.getMessage());
			throw	new BaseException(
					ExceptionRescoure.HIBERNATE_BATCH_DELETE_EXCEPTION);
		}
	}

	/**
	 * 统计数据条数
	 * 
	 * @param hql
	 * @return
	 * @throws BaseException
	 */
	public int count(String hql) throws BaseException {
		int count = 0;
		try {
			Iterator iter = getHibernateTemplate().iterate( hql );
			if( iter.hasNext() ) {
				count = ( (Long) iter.next() ).intValue();
			}
//			count = ((Integer) .next()).intValue() ;
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new BaseException(ExceptionRescoure.HIBERNATE_QUERY_EXCEPTION);
		}
		
		return count;
		
	}
	
	/**
	 * 数据查询（根据ID查询）
	 */
	public Object getObject(Class clazz, Serializable id) throws BaseException {
		try {
			Object o = getHibernateTemplate().get(clazz, id);
			if (o == null) {
				throw new BaseException(ExceptionRescoure.HIBERNATE_NOT_FIND);
			}
			return o;
		} catch (Exception ex) {
			log.error(ex.getMessage());
			ex.printStackTrace() ;
			throw new BaseException(ExceptionRescoure.HIBERNATE_QUERY_EXCEPTION);
		}

	}

	/**
	 * 数据查询，查询所有数据
	 */
	public List getObjects(Class clazz)throws BaseException {
		try {
//			((Integer) getHibernateTemplate().iterate("").next()).intValue() ;
			return getHibernateTemplate().loadAll(clazz);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new BaseException(ExceptionRescoure.HIBERNATE_QUERY_EXCEPTION);
		}
	}

	/**
	 * 数据查询，查询所有数据
	 * 
	 * @param clazz 集合中对象的类型
	 * @param hql 查询语句
	 */
	public List getObjects(Class clazz, String hql )throws BaseException {
		try {
			Query q = getSession().createQuery(hql).setResultTransformer(
					Transformers.aliasToBean ( clazz ) );
			return q.list();
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new BaseException(ExceptionRescoure.HIBERNATE_QUERY_EXCEPTION);
		}
	}
	
	/**
	 * 封装HQL查询
	 * 
	 * @param rollPage
	 *            翻页
	 * @param condition
	 *            条件
	 * @return List 结果集
	 */
	public List getObjects(RollPage rollPage, Condition condition) throws BaseException {
		Group group = condition.getGroup();
		if (group == null) {
			try {
				// 解析参数
				Criteria crt = parseCriteriaCondition(condition);
				// 设置翻页
				settingRollPage(rollPage, crt);
				List list = crt.list();
			
				return list != null && list.size() > 0 ? list : new ArrayList();
			} catch (Exception ex) {
				log.error(ex.getMessage());
				throw new BaseException(ExceptionRescoure.HIBERNATE_QUERY_EXCEPTION);
			}
			
		} else {
			try{
				// 解析参数
				Query query = parseQueryCondition(condition);
				// 设置翻页
				settingRollPage(rollPage, query);
				List list = query.list();
				return list != null && list.size() > 0 ? list : new ArrayList();
			} catch (Exception ex) {
				log.error(ex.getMessage());
				throw new BaseException(ExceptionRescoure.HIBERNATE_QUERY_EXCEPTION);
			}
		}
	}

	/**
	 * 封装HQL查询
	 * @param rollPage 翻页
	 * @param hql 
	 * @return
	 */
	public List getObjects(RollPage rollPage, String hql) throws BaseException {
		try{
			Query crt = getSession().createQuery(hql);
			// 翻页设置
			settingRollPage(rollPage, crt);
			List list = crt.list();
			return list != null && list.size() > 0 ? list : new ArrayList() ;
		} catch (Exception ex) {
			log.error(ex.getMessage());
			ex.printStackTrace() ;
			
			throw new BaseException(ExceptionRescoure.HIBERNATE_QUERY_EXCEPTION);
		}
	}

	/**
	 * 封装HQL查询
	 * @param rollPage 翻页
	 * @param hql 
	 * @param paras  
	 * @return
	 */
	public List getObjects(RollPage rollPage, String hql, Object[] paras) throws BaseException {
		try{
			Query crt = getSession().createQuery(hql);
			//使用hql的预编译机制
			if(paras!=null){
				for(int i=0;i<paras.length;i++){
					crt.setParameter(i, paras[i]);
				}
			}
			// 翻页设置
			settingRollPage(rollPage, crt);
			List list = crt.list();
			return list != null && list.size() > 0 ? list : new ArrayList();
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new BaseException(ExceptionRescoure.HIBERNATE_QUERY_EXCEPTION);
		}
	}

	/**
	 * HQL查询 
	 * @param hql 
	 * @return
	 */
	public List getObjects(String hql)  throws BaseException {
		try{
			Query crt = getSession().createQuery(hql);
			List list = crt.list();
			return list != null && list.size() > 0 ? list : new ArrayList();
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new BaseException(ExceptionRescoure.HIBERNATE_QUERY_EXCEPTION);
		}
	}

	/**
	 * 未经封装的SQL查询
	 * 
	 * @param rollPage
	 *            翻页
	 * @param sql
	 *            SQL语句
	 * @param column
	 *            列名
	 * @return List 结果集
	 */
	public List getObjects(RollPage rollPage, String sql, String[] column) throws BaseException {
		List list = new ArrayList();

		try {
			ResultSet rs = settingRollPage(rollPage, sql);
			while (rs.next()) {
				List tempList = null;
				for (int i = 0; i < column.length; i++) {
					tempList = new ArrayList();
					tempList.add(rs.getString(column[i]));
				}
				if (tempList != null) {
					list.add(tempList);
				}
			}
			
			return list.size() > 0 ? list : new ArrayList();
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new BaseException(ExceptionRescoure.HIBERNATE_QUERY_EXCEPTION);
		}
	}

	/**
	 * 封装HQL查询
	 * 
	 * @param rollPage
	 *            翻页
	 * @param condition
	 *            条件
	 * @return List 结果集
	 */
	public List getObjects(Condition condition) throws BaseException {
		Group group = condition.getGroup();
		if (group == null) {
			try{
				// 解析参数
				Criteria crt = parseCriteriaCondition(condition);
				List list = crt.list();
				return list != null && list.size() > 0 ? list : new ArrayList();
			} catch (Exception ex) {
				log.error(ex.getMessage());
				throw new BaseException(ExceptionRescoure.HIBERNATE_QUERY_EXCEPTION);
			}
		} else {
			try{
				// 解析参数
				Query query = parseQueryCondition(condition);
				List list = query.list();
				return list != null && list.size() > 0 ? list : new ArrayList();
			} catch (Exception ex) {
				log.error(ex.getMessage());
				throw new BaseException(ExceptionRescoure.HIBERNATE_QUERY_EXCEPTION);
			}
		}
	}
	
	public List getObjects(RollPage rollPage, List list )
	{
		if (rollPage != null) {
			
			// 设置记录总数
			rollPage.setRowCount(list.size());
			// 初始化
			rollPage.init();
			// 设置查找记录的起始位置
			rollPage.getPageFirst();
			// 设置查找记录的最大条数
			rollPage.getPagePer();
			
		}
		return list != null && list.size() > 0 ? list : new ArrayList();
	}

	/**
	 * 未经封装的SQL查询
	 * 
	 * @param rollPage
	 *            翻页
	 * @param sql
	 *            SQL语句
	 * @param column
	 *            列名
	 * @return List 结果集
	 * @throws BaseException 
	 */
	public List getObjects(String sql, String[] column) throws BaseException {
		List list = new ArrayList();

		try {
			ResultSet rs = settingRollPage(null, sql);
			while (rs.next()) {
				List tempList = null;
				for (int i = 0; i < column.length; i++) {
					tempList = new ArrayList();
					tempList.add(rs.getString(column[i]));
				}
				if (tempList != null) {
					list.add(tempList);
				}
			}
			
			return list.size() > 0 ? list : new ArrayList();
			
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new BaseException(ExceptionRescoure.HIBERNATE_QUERY_EXCEPTION);
		}

	}

	/**
	 * 取得SEQUENCE的值
	 * @param seqName  SEQUENCE名称 
	 * @throws BaseException 
	 */
	public String getSequenceValue(String seqName ) throws BaseException {
		
		String rValue = "0" ;
		
		String hql = " select " + seqName + ".nextval from dual ";
		String[] arr = new String[0] ;
		
		List gList = this.getObjects( hql,  arr ) ;
		
		if( gList != null && gList.size()>0 ) {
			Object[] obj = (Object[]) gList.get( 0 ) ;
			if( obj != null && obj.length>0 )
				rValue = obj[0].toString() ;
		}
		
		return rValue;

	}
	
	/**
	 * 移除Session中的对象
	 * 
	 * @param obj
	 *            对象obj
	 * @throws BaseException
	 */
	public void removeSessionObject(Object obj) throws BaseException {
		if (getSession().contains(obj)) {
			getSession().evict(obj);
		}
	}

	/**
	 * 
	 * 用Criteria实现翻页(Hql)
	 * 
	 * @param rollPage
	 *            翻页类
	 * @param Criteria
	 * 
	 */
	protected void settingRollPage(RollPage rollPage, Criteria crt) {
		// 翻页设置
		if (rollPage != null) {
			List list = crt.list();
			// 设置记录总数
			rollPage.setRowCount(list.size());
			// 初始化
			rollPage.init();
			// 设置查找记录的起始位置
			crt.setFirstResult(rollPage.getPageFirst());
			// 设置查找记录的最大条数
			crt.setMaxResults(rollPage.getPagePer());
		}
	}

	/**
	 * 
	 * 用Query实现翻页(Hql)
	 * 
	 * @param rollPage
	 *            翻页类
	 * @param Query
	 * 
	 */
	protected void settingRollPage(RollPage rollPage, Query crt) {
		// 翻页设置
		if (rollPage != null) {
			List list = crt.list();
			// 设置记录总数
			rollPage.setRowCount(list.size());
			// 初始化
			rollPage.init();
			// 设置查找记录的起始位置
			crt.setFirstResult(rollPage.getPageFirst());
			// 设置查找记录的最大条数
			crt.setMaxResults(rollPage.getPagePer());
		}
	}

	/**
	 * 
	 * 用java.sql实现翻页(sql)
	 * 
	 * @param rollPage
	 *            翻页类
	 * @param sql
	 *            查询语句
	 * 
	 */
	protected ResultSet settingRollPage(RollPage rollPage, String sql)
			throws BaseException {

		try {
			// 获取连接
			Connection conn = getSession().connection();

			Statement stat = conn
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);

			ResultSet res = stat.executeQuery(sql);

			int i = 0;
			while (res.next()) {
				i++;
			}
			// 设置总页数
			rollPage.setRowCount(i);
			// 初始化
			rollPage.init();
			// 设置翻页
			String hsql = getRollPageString(rollPage, sql);

			System.out.println(hsql);

			res = stat.executeQuery(hsql);

			return res;
		} catch (Exception e) {
			BaseException ex = new BaseException();
			ex.setMessageKey("settingRollPage分页查询错误(SQL)！");
			throw ex;
		}
	}

	// 进行SQL分页设置
	private String getRollPageString(RollPage rollPage, String sql) {
		StringBuffer pagingSelect = new StringBuffer();

		pagingSelect
				.append("select * from ( select row_.*, rownum rownum_ from ( ");
		pagingSelect.append(sql);
		pagingSelect.append(" ) row_ where rownum <= ");
		pagingSelect.append(rollPage.getPageFirst());
		pagingSelect.append(") where rownum_ > ");
		pagingSelect.append(rollPage.getPagePer());

		return pagingSelect.toString();
	}

	// ***************************** Query *******************************//
	private Query parseQueryCondition(Condition con) {

		// 查询条件以And做连接（既满足所有条件）
		List and = con.getParameterAnd();
		// 查询条件以Or做连接（既满足所有条件中的任意一个）
		List or = con.getParameterOr();
		// 分组查询类
		Class obj = con.getObjectClass();
		// 分组参数
		Group group = con.getGroup();
		// 排序参数
		com.by.base.utils.Order order = con.getOrder();

		// 查询的HQL
		StringBuffer hql = new StringBuffer();
		// 临时的SQL
		StringBuffer col = new StringBuffer();
		// 迭代器
		Iterator it = null;
		if (group != null) {
			// 查询列
			List column = group.getColumn();
			if (column.size() > 0) {

				it = column.iterator();
				col = new StringBuffer();
				while (it.hasNext()) {
					col.append(getGroupColumnString((Column) it.next()));
					if (it.hasNext()) {
						col.append(",");
					}
				}
				hql.append("SELECT " + col + " FROM " + obj.getName());
			}
		} else {
			hql.append("FROM " + obj.getName());
		}

		// 分组条件
		boolean boolAnd = false;
		boolean boolOr = false;
		// 条件AND
		col = new StringBuffer();
		if (and.size() > 0) {
			boolAnd = true;
			it = and.iterator();
			while (it.hasNext()) {
				Parameter para = (Parameter) it.next();
				col.append(getCriterionString(para));
				if (it.hasNext()) {
					col.append(" AND ");
				}
			}
		}
		// 条件OR
		if (or.size() > 0) {
			boolOr = true;
			it = or.iterator();
			if (boolAnd) {
				col.append(" OR ");
			}
			while (it.hasNext()) {
				Parameter paro = (Parameter) it.next();
				col.append(getCriterionString(paro));
				if (it.hasNext()) {
					col.append(" OR ");
				}

			}
		}

		if (boolAnd || boolOr) {
			hql.append(" WHERE " + col);
		}

		if (group != null) {
			// 分组查询条件以And做连接（既满足所有条件）
			List groupAnd = group.getParameterAnd();
			// 分组查询条件以Or做连接（既满足所有条件中的任意一个）
			List groupOr = group.getParameterOr();

			// 分组列
			List par = group.getGroupColumn();
			if (par.size() > 0) {
				it = par.iterator();
				col = new StringBuffer();
				while (it.hasNext()) {
					col.append((String) it.next());
					if (it.hasNext()) {
						col.append(",");
					}
				}
				hql.append(" GROUP BY " + col);
			}

			// 分组条件
			boolAnd = false;
			boolOr = false;

			// 条件AND
			col = new StringBuffer();
			if (groupAnd.size() > 0) {
				boolAnd = true;
				it = groupAnd.iterator();
				while (it.hasNext()) {
					Parameter para = (Parameter) it.next();
					col.append(getCriterionString(para));
					if (it.hasNext()) {
						col.append(" AND ");
					}
				}
			}
			// 条件OR
			if (groupOr.size() > 0) {
				boolOr = true;
				it = groupOr.iterator();
				if (boolAnd) {
					col.append(" OR ");
				}
				while (it.hasNext()) {
					Parameter paro = (Parameter) it.next();
					col.append(getCriterionString(paro));
					if (it.hasNext()) {
						col.append(" OR ");
					}

				}
			}

			if (boolAnd || boolOr) {
				hql.append(" HAVING " + col);
			}
		}
		// 排序
		if (order != null) {
			List corder = order.getColumn();
			if (corder.size() > 0) {
				it = corder.iterator();
				col = new StringBuffer();
				while (it.hasNext()) {
					Column o = (Column) it.next();
					col.append(o.getColumn());
					if (o.getOperator() == com.by.base.utils.Order.SQL_ORDER_ASC) {
						col.append(" ASC ");
					} else if (o.getOperator() == com.by.base.utils.Order.SQL_ORDER_DESC) {
						col.append(" DESC ");
					}
					if (it.hasNext()) {
						col.append(",");
					}
				}

				hql.append(" ORDER BY " + col);
			}
		}

		log.info(hql);

		Query query = getSession().createQuery(hql.toString());

		if (and.size() > 0) {
			boolAnd = true;
			it = and.iterator();
			int i = 0;
			while (it.hasNext()) {
				Parameter para = (Parameter) it.next();
				Object[] obja = para.getValue();
				for (int j = 0; j < obja.length; j++, i++) {
					query.setParameter(i, obja[j]);
				}
			}
		}
		// 条件OR
		if (or.size() > 0) {
			boolOr = true;
			it = or.iterator();
			int i = 0;
			if (boolAnd) {
				col.append(" OR ");
			}
			while (it.hasNext()) {
				Parameter paro = (Parameter) it.next();
				Object[] obja = paro.getValue();
				for (int j = 0; j < obja.length; j++, i++) {
					query.setParameter(i, obja[j]);
				}
			}
		}

		if (group != null) {
			// 分组查询条件以And做连接（既满足所有条件）
			List groupAnd = group.getParameterAnd();
			// 分组查询条件以Or做连接（既满足所有条件中的任意一个）
			List groupOr = group.getParameterOr();
			// 条件AND
			if (groupAnd.size() > 0) {
				it = groupAnd.iterator();
				int i = 0;
				while (it.hasNext()) {
					Parameter para = (Parameter) it.next();
					Object[] obja = para.getValue();
					for (int j = 0; j < obja.length; j++, i++) {
						query.setParameter(i, obja[j]);
					}
				}
			}
			// 条件OR
			if (groupOr.size() > 0) {
				it = groupOr.iterator();
				int i = 0;
				while (it.hasNext()) {
					Parameter paro = (Parameter) it.next();
					col.append(getCriterionString(paro));
					Object[] obja = paro.getValue();
					for (int j = 0; j < obja.length; j++, i++) {
						query.setParameter(i, obja[j]);
					}
				}
			}
		}

		return query;
	}

	/**
	 * 解析分组条件
	 * 
	 * @param col
	 *            分组条件
	 * @return String
	 */
	private String getGroupColumnString(Column col) {
		String columnName = col.getColumn();
		String alias = col.getAlias();
		int oper = col.getOperator();
		switch (oper) {
		// 分组 avg
		case Group.SQL_GROUP_AVG:
			if (alias != null && !alias.equals("")) {
				return new String("avg(" + columnName + ") AS " + alias);
			} else {
				return new String("avg(" + columnName + ")");
			}
		// 分组 count
		case Group.SQL_GROUP_COUNT:
			if (alias != null && !alias.equals("")) {
				return new String("count(" + columnName + ") AS " + alias);
			} else {
				return new String("count(" + columnName + ")");
			}
		// 分组 count distinct
		case Group.SQL_GROUP_COUNT_DISTINCT:
			if (alias != null && !alias.equals("")) {
				return new String("count(distinct " + columnName + ") AS "
						+ alias);
			} else {
				return new String("count(distinct " + columnName + ")");
			}
		// 分组 max
		case Group.SQL_GROUP_MAX:
			if (alias != null && !alias.equals("")) {
				return new String("max(" + columnName + ") AS " + alias);
			} else {
				return new String("max(" + columnName + ")");
			}
		// 分组 min
		case Group.SQL_GROUP_MIN:
			if (alias != null && !alias.equals("")) {
				return new String("min(" + columnName + ") AS " + alias);
			} else {
				return new String("min(" + columnName + ")");
			}
		// 分组 sum
		case Group.SQL_GROUP_SUM:
			if (alias != null && !alias.equals("")) {
				return new String("sum(" + columnName + ") AS " + alias);
			} else {
				return new String("sum(" + columnName + ")");
			}
		default:
			return "";
		}
	}

	/**
	 * 解析查询条件
	 * 
	 * @param crt
	 *            Criteria
	 * @param par
	 *            条件参数
	 * @return Criteria
	 */
	private String getCriterionString(Parameter par) {
		String column = par.getColumn();
		int oper = par.getOperator();
		Object[] objArray = par.getValue();

		switch (oper) {
		// 等于 =
		case Operator.SQL_EQ:
			if (objArray.length > 1) {
				StringBuffer sql = new StringBuffer(column + " in (");
				int aSize = objArray.length;
				for (int i = 0; i < aSize; i++) {
					sql.append("?");
					if (i + 1 < aSize) {
						sql.append(",");
					}
				}
				sql.append(")");
				return sql.toString();
			} else if (objArray.length == 1) {
				return new String(column + " = ?");
			}
		// 不等于 <>
		case Operator.SQL_NE:
			if (objArray.length > 1) {
				StringBuffer sql = new StringBuffer(column + " not in (");
				int aSize = objArray.length;
				for (int i = 0; i < aSize; i++) {
					sql.append("?");
					if (i + 1 < aSize) {
						sql.append(",");
					}
				}
				sql.append(")");
				return sql.toString();
			} else if (objArray.length == 1) {
				return new String(column + " <> ?");
			}
		// 大于 >
		case Operator.SQL_GT:
			return new String(column + " > ?");
		// 小于 <
		case Operator.SQL_LT:
			return new String(column + " < ?");
		// 大于等于 >=
		case Operator.SQL_GE:
			return new String(column + " >= ?");
		// 小于等于 <=
		case Operator.SQL_LE:
			return new String(column + " <= ?");
		// 区间 between
		case Operator.SQL_BETWEEN:
			return new String(column + " between (? and ?)");
		// 非区间 not between
		case Operator.SQL_NOT_BETWEEN:
			return new String(column + " not between (? and ?)");
		// 模糊查询
		case Operator.SQL_LIKE:
			return new String(column + " like ?");
		// 字段为空 is null
		case Operator.SQL_NULL:
			return new String(column + " is Null ?");
		// 字段不为空 is not null
		case Operator.SQL_NOT_NULL:
			return new String(column + " is not Null ?");
		default:
			return "";
		}
	}

	// ***************************** Criteria *******************************//

	private Criteria parseCriteriaCondition(Condition condition) {
		// 待查询的表对象（对应数据库中的表）
		Class objClass = condition.getObjectClass();
		// 查询条件以And做连接（既满足所有条件）
		List and = condition.getParameterAnd();
		// 查询条件以Or做连接（既满足所有条件中的任意一个）
		List or = condition.getParameterOr();
		// 排序条件
		com.by.base.utils.Order order = condition.getOrder();

		Criteria crt = getSession().createCriteria(objClass);
		// 解析查询条件 And
		if (and != null && and.size() > 0) {
			for (Iterator it = and.iterator(); it.hasNext();) {
				Parameter par = (Parameter) it.next();
				crt.add(getCriterion(crt, par));
			}
		}

		// 解析查询条件 Or
		int orSize = or.size();
		if (or != null && orSize > 0) {
			if (orSize >= 2) {
				crt.add(getCriterionOr(crt, or.iterator(), orSize, 0));
			}
		}

		// 排序参数据的解析
		if (order != null) {
			List column = order.getColumn();
			for (Iterator it = column.iterator(); it.hasNext();) {
				Column o = (Column) it.next();
				if (o.getOperator() == com.by.base.utils.Order.SQL_ORDER_ASC) {
					crt.addOrder(Order.asc(o.getColumn()));
				} else if (o.getOperator() == com.by.base.utils.Order.SQL_ORDER_DESC) {
					crt.addOrder(Order.desc(o.getColumn()));
				}
			}
		}
		return crt;

	}

	/**
	 * 解析排序条件
	 * 
	 * @param crt
	 *            Criteria
	 * @param it
	 *            Iterator
	 * @param orSize
	 *            条件个数
	 * @param i
	 *            当前个数
	 * @return
	 */
	private LogicalExpression getCriterionOr(Criteria crt, Iterator it,
			int orSize, int i) {
		if (i + 2 == orSize) {
			return Expression.or(getCriterion(crt, (Parameter) it.next()),
					getCriterion(crt, (Parameter) it.next()));
		} else {
			i++;
			return Expression.or(getCriterion(crt, (Parameter) it.next()),
					getCriterionOr(crt, it, orSize, i));
		}
	}

	/**
	 * 解析查询条件
	 * 
	 * @param crt
	 *            Criteria
	 * @param par
	 *            条件参数
	 * @return Criteria
	 */
	private Criterion getCriterion(Criteria crt, Parameter par) {
		String column = par.getColumn();
		int oper = par.getOperator();
		Object[] objArray = par.getValue();

		switch (oper) {
		// 等于 =
		case Operator.SQL_EQ:
			if (objArray.length > 1) {
				return Expression.in(column, objArray);
			} else if (objArray.length == 1) {
				return Expression.eq(column, objArray[0]);
			}
		// 不等于 <>
		case Operator.SQL_NE:
			if (objArray.length > 1) {
				return Expression.not(Expression.in(column, objArray));
			} else if (objArray.length == 1) {
				return Expression.ne(column, objArray[0]);
			}
		// 大于 >
		case Operator.SQL_GT:
			return Expression.gt(column, objArray[0]);
		// 小于 <
		case Operator.SQL_LT:
			return Expression.lt(column, objArray[0]);
		// 大于等于 >=
		case Operator.SQL_GE:
			return Expression.ge(column, objArray[0]);
		// 小于等于 <=
		case Operator.SQL_LE:
			return Expression.le(column, objArray[0]);
		// 区间 between
		case Operator.SQL_BETWEEN:
			return Expression.between(column, objArray[0], objArray[1]);
		// 非区间 not between
		case Operator.SQL_NOT_BETWEEN:
			return Expression.not(Expression.between(column, objArray[0],
					objArray[1]));
		// 模糊查询
		case Operator.SQL_LIKE:
			return Expression.like(column, objArray[0]);
		// 字段为空 is null
		case Operator.SQL_NULL:
			return Expression.isNull(column);
		// 字段不为空 is not null
		case Operator.SQL_NOT_NULL:
			return Expression.isNotNull(column);
		default:
			return null;
		}
	}
}
