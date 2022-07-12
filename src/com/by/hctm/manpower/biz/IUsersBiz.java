package com.by.hctm.manpower.biz;

import java.sql.Timestamp;
import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.manpower.entity.Certificates;
import com.by.hctm.manpower.entity.Users;
import com.by.hctm.system.entity.Departments;

public interface IUsersBiz {

	/**
	 * 根据主键获得用户表实例
	 * @author zwp 2012-10-19
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract Users getUsers(Long id) throws BaseException;

	/**
	 * 添加用户信息
	 * @author zwp 2012-10-19
	 * @param user 用户表实例
	 * @throws BaseException 
	 */
	abstract void saveUsers(Users user) throws BaseException;

	/**
	 * 更新用户表实例
	 * @author zwp 2012-10-19
	 * @param user 用户表实例
	 * @throws BaseException 
	 */
	abstract void updateUsers(Users user) throws BaseException;

	/**
	 * 删除用户表实例
	 * @author zwp 2012-10-19
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteUsers(String id) throws BaseException;

	/**
	 * 删除用户表实例
	 * @author zwp 2012-10-19
	 * @param user 用户表实例
	 * @throws BaseException 
	 */
	abstract void deleteUsers(Users user) throws BaseException;

	/**
	 * 删除用户表实例
	 * @author zwp 2012-10-19
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteUserss(String[] id) throws BaseException;
	
	/**
	 * 删除用户表实例
	 * @author zwp 2012-10-19
	 * @param list 对象数组
	 * @throws BaseException 
	 */
	abstract void deleteUserss(List list) throws BaseException;

	/**
	 * 获得所有用户表数据集
	 * @author zwp 2012-10-19
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getUsersList(RollPage rollPage) throws BaseException;

	/**
	 * 获得所有用户表数据集
	 * @author zwp 2012-10-19
	 * @param user 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getUsersList(Users user) throws BaseException;

	/**
	 * 获得所有用户表数据集
	 * @author zwp 2012-10-19
	 * @param rollPage 分页对象
	 * @param user 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getUsersList(RollPage rollPage, Users user)
			throws BaseException;

	/**
	 * 获得所有用户表数据集
	 * @author zwp 2012-10-19
	 * @param rollPage 分页对象
	 * @param user 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getUsersList(RollPage rollPage, Users user, Departments departments)
			throws BaseException;
	
	/**
	 * 获得所有用户表数据集
	 * @author zwp 2012-10-19
	 * @param rollPage 分页对象
	 * @param Contracts 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getContractsList(Timestamp ts)
			throws BaseException;
	
	/**
	 * 集合数量用户表实例
	 * @author zwp 2012-10-19
	 * @param projectId
	 * @throws BaseException
	 */
	public int countUsers(Users users) throws BaseException;
	
	/**
	 * 获得所有用户表数据
	 * @author zwp 2012-10-19
	 * @return
	 * @throws BaseException 
	 */
	abstract List getUsersList() throws BaseException;
	
	/**
	 * 获得所有用户表数据集
	 * @author zwp 2012-10-19
	 * @param rollPage 分页对象
	 * @param user 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getUsersList(RollPage rollPage, Users user, Certificates cert)
			throws BaseException;
	/**
	 * 相同资质用户数量
	 * @author zwp 2012-10-19
	 * @param cert 资质实体类
	 * @throws BaseException
	 */
	abstract int countCertField(Certificates cert) throws BaseException;
	
	/**
	 * 获得所有用户表数据集
	 * @author lh 2012-10-19
	 * @param rollPage 分页对象
	 * @param user 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getCertUsersList(RollPage rollPage, Users user, Certificates cert)
	throws BaseException;
	/**
	 * 获得所有用户表数据集
	 * @param rollPage 分页对象
	 * @param user 查询参数对象
	 * @return
	 * @author 谢磊
	 * @throws BaseException 
	 */
	public List getUsersListRight( RollPage rollPage, Users user ) throws BaseException;
	
	/**
	 * 获得对象所有用户表数据
	 * @return参数  cert.getCertField
	 * @author 谢磊  2012-11-08
	 * @throws BaseException 
	 */
	public List getUsersCertList( Certificates cert) throws BaseException;
	/**
	 * 集合数量用户表实例
	 * @author 谢磊 2012-11-9
	 * @param users 用户
	 * @throws BaseException
	 */
	public int countDeptUsers(Users users) throws BaseException;
}