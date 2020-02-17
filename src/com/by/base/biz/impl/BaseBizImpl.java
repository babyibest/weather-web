package com.by.base.biz.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.by.base.biz.IBaseBiz;
import com.by.base.dao.IBaseDao;
import com.by.base.exception.BaseException;
import com.by.base.utils.Condition;
import com.by.base.utils.RollPage;
import com.by.hctm.manpower.entity.Users;
 

public class BaseBizImpl implements IBaseBiz  {

//	 protected final Log log = LogFactory.getLog(getClass());
	protected final Logger log = Logger.getLogger(this.getClass());
	

	protected IBaseDao baseDao = null;

	// #直连数据库的对象
	protected DataSource dataSource = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (Exception ex) {

		}
		return conn;
	}

	/**
	 * 保存对象
	 * 
	 * @param o
	 *            对象
	 * @throws BaseException
	 */
	public void saveObject(Object o) throws BaseException {
		baseDao.saveObject(o);
	}
	
	/**
	 * 批量保存对象
	 * 
	 * @param list
	 *            对象List
	 * @throws BaseException
	 */
	public void saveBatchObject(List list) throws BaseException {
		baseDao.saveBatchObject(list);
	}
	
	/**
	 * 更新对象
	 * 
	 * @param o
	 *            对象
	 * @throws BaseException
	 */
	public void updateObject(Object o) throws BaseException {
		baseDao.updateObject(o);
	}
	
	/**
	 * 更新对象
	 * 
	 * @param entityName , entity
	 *            对象
	 * @throws BaseException
	 */
	public void updateObject(String entityName,Object entity) throws BaseException {
		baseDao.updateObject(entityName, entity);
	}
	
	/**
	 * 批量更新对象
	 * 
	 * @param list
	 *            对象List
	 * @throws BaseException
	 */
	public void updateBatchObject(List list) throws BaseException {
		baseDao.updateBatchObject(list);
	}
	
	/**
	 * 修改或是更新数据
	 */
	public void saveOrUpdateObject(Object o)throws BaseException {
		baseDao.saveOrUpdateObject(o);
	}
	
	/**
	 * 删除对象
	 */
	public void removeObject( Object o) throws BaseException {
		baseDao.removeObject(o) ;
	}
	
	/**
	 * 删除对象
	 * 
	 * @param clazz
	 *            对象Class
	 * @param id
	 *            对象ID
	 * @throws BaseException
	 */
	public void removeObject(Class clazz, Serializable id) throws BaseException {
		baseDao.removeObject(clazz, id);
	}
	
	/**
	 * 批量删除对象
	 * 
	 * @param list
	 *            对象ID数组
	 * @throws BaseException
	 */
	public void removeBatchObject(Class clazz, Serializable[] id)
			throws BaseException {
		baseDao.removeBatchObject(clazz, id);
	}
	
	/**
	 * 批量删除数据
	 */
	public void removeBatchObject(Class clazz, List list) throws BaseException {
		baseDao.removeBatchObject(clazz, list) ;
	}
	
	/**
	 * 统计数据条数
	 * hql sample: select count(*) from ObjectName where 1=1 
	 * @param hql 查询语句
	 */
	public int countObjects( String hql )throws BaseException {
		return baseDao.count( hql ) ;
	}
	
	/**
	 * 查询单个对象（对象ID）
	 * 
	 * @param clazz
	 *            对象Class
	 * @param id
	 *            对象ID
	 * @return Object 对象
	 * @throws BaseException
	 */
	public Object getObject(Class clazz, Serializable id) throws BaseException {
		return baseDao.getObject(clazz, id);
	}

	/**
	 * 查询所有对象
	 * 
	 * @param clazz
	 *            对象Class
	 * @return List 对象列表
	 * @throws BaseException
	 */
	public List getObjects(Class clazz) throws BaseException {
		return baseDao.getObjects(clazz);
	}

	/**
	 * 数据查询，查询所有数据
	 * 例: test.class, select test.id, test.name from test 
	 * @param clazz 集合中指定对象类型
	 * @param hql 查询语句
	 */
	public List getObjects(Class clazz, String hql )throws BaseException {
		return baseDao.getObjects(clazz, hql) ;
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
		return baseDao.getObjects(rollPage, condition) ;
	}

	/**
	 * 封装HQL查询
	 * @param rollPage 翻页
	 * @param hql 
	 * @return
	 */
	public List getObjects(RollPage rollPage, String hql) throws BaseException {
		return baseDao.getObjects(rollPage, hql ) ;
	}

	/**
	 * 封装HQL查询
	 * @param rollPage 翻页
	 * @param hql 
	 * @param paras  
	 * @return
	 */
	public List getObjects(RollPage rollPage, String hql, Object[] paras) throws BaseException {
		return baseDao.getObjects(rollPage, hql, paras) ;
	}

	/**
	 * HQL查询 
	 * @param hql 
	 * @return
	 */
	public List getObjects(String hql)  throws BaseException {
		return baseDao.getObjects(hql) ;
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
		return baseDao.getObjects(rollPage, sql, column) ;
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
		return baseDao.getObjects(condition) ;
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
		return baseDao.getObjects(sql, column) ;
	}

	/**
	 * 移除Session中的对象
	 * 
	 * @param obj
	 *            对象obj
	 * @throws BaseException
	 */
	public void removeSessionObject(Object obj) throws BaseException {
		baseDao.removeSessionObject(obj) ;
	}

	/**
	 * 取得SEQUENCE的值
	 * @param seqName  SEQUENCE名称 
	 * @throws BaseException 
	 */
	public String getSequenceValue(String seqName ) throws BaseException {
		return baseDao.getSequenceValue( seqName );
	}
	
//	protected List getMenusChildren(Long id) throws BaseException {
//		Condition con = new Condition(MSysTMenus.class);
//		//条件：Pid = id 可用 显示
//		con.addParameterAnd(new Parameter("PId", Operator.SQL_EQ,
//				new Long[] { id }));
//		con.addParameterAnd(new Parameter("menuMark", Operator.SQL_EQ,
//				new String[] { ConstantsService.MENU_MARK }));
//		con.addParameterAnd(new Parameter("menuDisplay", Operator.SQL_EQ,
//				new String[] { ConstantsService.MENU_DISPLAY }));
//		
//		List children = dao.getObjects(con);
//
//		LinkedList linklist = new LinkedList();
//
//		if (children != null) {
//
//			// 递归下一级栏目
//			linklist.addAll(children);
//
//			for (Iterator iterator = children.iterator(); iterator.hasNext();) {
//				MSysTMenus utMenus = (MSysTMenus) iterator.next();
//				linklist.addAll(getMenusChildren(utMenus.getId()));
//			}
//		}
//		return linklist;
//	}

	/**
	 * 保存管理员日志
	 * noteAdminLog(request：请求，operModule：模块信息，operBrief：操作简介，operInfo：操作详细信息)
	 */
	protected void disposeOperationLog(Users admin, Long operModule,
			String operBrief, String operInfo) throws BaseException {
		// 管理员不能为空
		if (admin != null) {
//			// 管理员日志对象
//			MSysTUserLog log = new MSysTUserLog();
//			// 记录管理员ID
//			log.setUserId(admin.getId().toString());
//			// 记录管理员登录名
//			log.setLoginName(admin.getLoginName());
//			// 操作时间
//			log.setOperTime(ConvertLang
//					.convertDateTimeYMDHMS(new Date()));
//			// 操作模块
//			log.setOperModule(operModule);
//			// 操作备注
//			log.setOperBrief(operBrief);
//			// 操作详细信息
//			log.setOperInfo(operInfo);
//			// 部门信息
//			log.setDeptId(admin.getDeptId());
//			// 保存日志
//			dao.saveObject(log);
		}
	}

	/**
	 * 查询菜单是示否有访问权限
	 */
//	public BeanValue validateTreePermission(Users admin, List menu,
//			BeanValue value) throws BaseException {
//		String adminId = String.valueOf(admin.getId());
//
//		int size = menu.size();
//
//		String[] id = new String[size];
//
//		for (int i = 0; i < size; i++) {
//			id[i] = String.valueOf(((MSysTMenus) menu.get(i)).getId());
//		}
//
//		// ****************操作员权限
//		Condition conu = new Condition(MSysTUserPermissions.class);
//		// 操作员ID
//		conu.addParameterAnd(new Parameter("adminId", Operator.SQL_EQ,
//				new String[] { adminId }));
//		// 权限ID
//		conu
//				.addParameterAnd(new Parameter("permissionId", Operator.SQL_EQ,
//						id));
//		// 获得对应关系
//		List list = dao.getObjects(conu);
//
//		if (list != null) {
//			Iterator it = list.iterator();
//			while (it.hasNext()) {
//				MSysTUserPermissions ut = (MSysTUserPermissions) it.next();
//				value.addRequestMap("menu" + ut.getId(), ut.getId());
//			}
//		}
//
//		// **************查询出操作员继承下来的权限(操作组)
//
//		// 操作员继承的权限组
//		List uvTPList = null;
//
//		Condition conTeamPer = new Condition(MSysTUserPermissions.class);
//		conTeamPer.addParameterAnd(new Parameter("id.adminId", Operator.SQL_EQ,
//				new String[] { adminId }));
//		conTeamPer.addParameterAnd(new Parameter("id.permissionId",
//				Operator.SQL_EQ, id));
//
//		uvTPList = dao.getObjects(conTeamPer);
//
//		if (uvTPList != null) {
//			Iterator it = uvTPList.iterator();
//			while (it.hasNext()) {
//			//	MSTDeptPermissions ut = (MSTDeptPermissions) it.next();
//			//	value.addRequestMap("menu" + ut.getId(), new Long(ut
//			//			.getId()));
//			}
//		}
//
//		// **************查询操作员继承权限完成(操作组)
//
//		// **************查询出操作员继承下来的权限(角色)
//
//
//		// **************查询操作员继承权限完成(角色)
//		return value;
//	}

}
