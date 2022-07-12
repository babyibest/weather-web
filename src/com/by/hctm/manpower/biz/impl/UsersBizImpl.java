package com.by.hctm.manpower.biz.impl;

import java.sql.Timestamp;
import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.TableStatus;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.manpower.biz.IUsersBiz;
import com.by.hctm.manpower.entity.Certificates;
import com.by.hctm.manpower.entity.Users;
import com.by.hctm.system.entity.Departments;

public class UsersBizImpl extends BaseBizImpl implements IUsersBiz  {
	
	/**
	 * 根据主键获得用户表实例
	 * @param id 主键
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public Users getUsers(Long id) throws BaseException {
		return (Users)this.getObject(Users.class, id);
	}
	
	/**
	 * 添加用户信息
	 * @author zwp 2012-10-19
	 * @param user 用户表实例
	 * @throws BaseException 
	 */
	public void saveUsers(Users user) throws BaseException{
		this.saveObject( user ) ;
	}
	
	/**
	 * 更新用户表实例
	 * @author zwp 2012-10-19
	 * @param user 用户表实例
	 * @throws BaseException 
	 */
	public void updateUsers(Users user) throws BaseException{
		this.updateObject( user ) ;
	}
	
	/**
	 * 删除用户表实例
	 * @author zwp 2012-10-19
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteUsers(String id) throws BaseException {
		this.removeObject( this.getUsers( new Long(id) ) ) ;
	}
	
	/**
	 * 删除用户表实例
	 * @author zwp 2012-10-19
	 * @param user 用户表实例
	 * @throws BaseException 
	 */
	public void deleteUsers(Users user) throws BaseException {
		this.removeObject( user ) ;
	}
	
	/**
	 * 删除用户表实例
	 * @author zwp 2012-10-19
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteUserss(String[] id) throws BaseException {
		this.removeBatchObject(Users.class, id) ;
	}
	
	/**
	 * 删除用户表实例
	 * @author zwp 2012-10-19
	 * @param list 对象数组
	 * @throws BaseException 
	 */
	public void deleteUserss(List list) throws BaseException {
		if(list!=null && list.size()!=0){
			for(int i=0;i<list.size();i++){
			deleteUsers((Users)list.get(i));
			}
		}
	}
	
	/**
	 * 获得所有用户表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public List getUsersList( RollPage rollPage  ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Users de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有用户表数据集
	 * @param user 查询参数对象
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public List getUsersList(  Users user ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Users usr where 1 = 1 " );
		if(StringUtil.isNotBlank(user) ){
			if(StringUtil.isNotBlank(user.getDepId())){
				hql.append(" and usr.depId ='").append( user.getDepId() ).append("'");
			}
			if( ! StringUtil.isBlank( user.getUserName() )  ){
				hql.append(" and usr.userName ='").append( user.getUserName() ).append("'");
			}
			
			if( ! StringUtil.isBlank( user.getUserPassword() )  ){
				hql.append(" and usr.userPassword ='").append( user.getUserPassword() ).append("'");
			}
			if( ! StringUtil.isBlank( user.getUserChinesename() )  ){
				hql.append(" and usr.userChinesename ='").append( user.getUserChinesename() ).append("'");
			}
		}
		
		hql.append(" and isUsable = '0' order by usr.userId desc ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有用户表数据集
	 * @param rollPage 分页对象
	 * @param user 查询参数对象
	 * @return
	 * @author
	 * @throws BaseException 
	 */
	public List getUsersList( RollPage rollPage, Users user ) throws BaseException {
		StringBuffer hql = new StringBuffer("select de.userName ,de.userSex ,de.userName , de.depId , de.station," +
				" de.rank ,de.status from Users de , Certificates ce where ce.user.userId = de.userId" );
			if(user != null){
				if(!StringUtil.isBlank(user.getDepId())){
					hql.append(" and de.depId = ").append(user.getDepId());
				}
				if(!StringUtil.isBlank(user.getUserChinesename())){
					hql.append(" and de.userChinesename like '%").append(user.getUserChinesename().trim()).append("%'");
				}
				if(!StringUtil.isBlank(user.getRank())){
					hql.append(" and de.rank like '%").append(user.getRank()).append("%'");
				}
				if(!StringUtil.isBlank(user.getStation())){
					hql.append(" and de.station like '%").append(user.getStation()).append("%'");
				}
				if(!StringUtil.isBlank(user.getPolitical())){
					hql.append(" and de.political = '").append(user.getPolitical()).append("'");
				}
				if(!StringUtil.isBlank(user.getDegree())){
					hql.append(" and de.degree = '").append(user.getDegree()).append("'");
				}
				
				
			}
			
		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	
	
	/**
	 * 获得所有用户表数据集
	 * @param rollPage 分页对象
	 * @param user 查询参数对象
	 * @return
	 * @author 谢磊
	 * @throws BaseException 
	 */
	public List getUsersListRight( RollPage rollPage, Users user ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Users de  where 1=1 " );
			if(StringUtil.isNotBlank(user)){
				if(!StringUtil.isBlank(user.getDepId())){
					hql.append(" and de.depId = ").append(user.getDepId());
				}
				if(StringUtil.isNotBlank(user.getUserName())){
					if(user.getUserName().equals("0")){
						hql.append( "and de.userName is not null or de.userName != '' ");
					}else{
						
						hql.append(" and de.userName = ' ").append(user.getUserName()).append("'");
					}
				}
				if(!StringUtil.isBlank(user.getUserChinesename())){
					hql.append(" and de.userChinesename like '%").append(user.getUserChinesename().trim()).append("%'");
				}
				if(!StringUtil.isBlank(user.getRank())){
					hql.append(" and de.rank like '%").append(user.getRank()).append("%'");
				}
				if(!StringUtil.isBlank(user.getStation())){
					hql.append(" and de.station like '%").append(user.getStation()).append("%'");
				}
				if(!StringUtil.isBlank(user.getPolitical())){
					hql.append(" and de.political = '").append(user.getPolitical()).append("'");
				}
				if(!StringUtil.isBlank(user.getDegree())){
					hql.append(" and de.degree = '").append(user.getDegree()).append("'");
				}
				
				
			}
			
		hql.append(" and de.isUsable ='0' order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有用户表数据集
	 * @param rollPage 分页对象
	 * @param user 查询参数对象
	 * @return departments 部门
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public List getUsersList(RollPage rollPage, Users user, Departments departments) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Users as u where 1 = 1 " );
		hql.append(" and u.isUsable='").append(TableStatus.COMMON_STATUS_VALID).append("' ");
		  //查询
		if(user!=null){
			if(user.getUserChinesename()!=null && user.getUserChinesename()!="" && user.getUserChinesename().length()!=0){
				hql.append(" and u.userChinesename like '%").append(user.getUserChinesename()).append("%' ");
				user.setUserChinesename(user.getUserChinesename());
			}
		}
		  if(departments!=null){
			  if(departments.getDepId()!=null){
				  hql.append(" and u.depId=").append(departments.getDepId()).append(" ");
			  }
		  }
		hql.append(" order by u.id ");
		return this.getObjects(rollPage, hql.toString() );
	}
	

	/**
	 * 获得所有用户表数据集
	 * @param ts 查询参数
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public List getContractsList(Timestamp ts) throws BaseException {
		StringBuffer hql = new StringBuffer("from Users as u where 1=1");
		hql.append(" and u.writeDate = to_date('").append(ts.toString().substring(0,19)).append("','yyyy-mm-dd hh24:mi:ss') ");
		hql.append(" order by u.writeDate desc");
		return this.getObjects(hql.toString());
	}
	

	
	/**
	 * 集合数量用户表实例
	 * @author zwp 2012-10-19
	 * @param users 用户
	 * @throws BaseException
	 */
	public int countUsers(Users users) throws BaseException{
		StringBuffer hql = new StringBuffer(" select count(*) from Users as u where 1=1");
		if(users!=null){
			if(users.getDepId()!=null){
			hql.append(" or u.selflevCode like '%,").append(users.getDepId()).append(",%') ");
			}
		}
		hql.append(" and u.isUsable='").append(TableStatus.COMMON_STATUS_VALID).append("' ");
		hql.append(" order by u.depId desc");
		System.out.println(hql);
		return this.baseDao.count(hql.toString());
	    
	}
	
	/**
	 * 集合数量用户表实例
	 * @author 谢磊 2012-11-9
	 * @param users 用户
	 * @throws BaseException
	 */
	public int countDeptUsers(Users users) throws BaseException{
		StringBuffer hql = new StringBuffer(" select count(*) from Users u  where 1=1 ");
		if(StringUtil.isNotBlank(users)){
			if(users.getDepId()!=null){
		    hql.append("  and u.depId = '").append(users.getDepId()).append("'");		
			}
			if(StringUtil.isNotBlank(users.getUserName())){
				if(users.getUserName().equals("0")){
					hql.append( "and u.userName is not null or u.userName != '' ");
				}else{
					
					hql.append(" and u.userName = ' ").append(users.getUserName()).append("'");
				}
			}
			
		}
		
		hql.append(" and u.isUsable = 0");
		System.out.println(hql);
		return this.countObjects(hql.toString());
	    
	}
	
	/**
	 * 获得所有用户表数据
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public List getUsersList() throws BaseException {
		StringBuffer hql = new StringBuffer(" from Users de where 1 = 1 and de.isUsable = '0' " );

		hql.append(" order by de.id desc ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得对象所有用户表数据
	 * @return参数  cert.getCertField
	 * @author 谢磊  2012-11-08
	 * @throws BaseException 
	 */
	public List getUsersCertList( Certificates cert) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Users u , Certificates c where c.user.userId = u.userId and c.isUsable='0' and u.isUsable = 0 " );
		if(StringUtil.isNotBlank(cert) && StringUtil.isNotBlank(cert.getCertName())){
			hql.append("  and c.certName = '").append(cert.getCertName()).append("'");
		}
		hql.append(" order by c.certId desc ");
		return this.getObjects( hql.toString() );
	}
	/**
	 * 获得所有用户表数据集
	 * @author zwp 2012-10-19
	 * @param rollPage 分页对象
	 * @param user 查询参数对象
	 * @param cert 资质实体类
	 * @return
	 * @throws BaseException 
	 */
	public List getUsersList(RollPage rollPage, Users user, Certificates cert)
			throws BaseException{
		StringBuffer hql = new StringBuffer("select u from Users u , Certificates c where c.user.userId = u.userId and c.isUsable='0' ");
		//模糊查询
		if(user!=null){
			if(StringUtil.isNotBlank(user.getUserChinesename())){
				hql.append(" and u.userChinesename like '%").append(user.getUserChinesename()).append("%' ");
			}
		}
		//筛选专业
		if(cert!=null){
			if(StringUtil.isNotBlank(cert.getCertField())){
				hql.append(" and c.certName='").append(cert.getCertField()).append("' ");
			}
		}
		//剔除无效用户
		hql.append(" and u.isUsable='").append(TableStatus.COMMON_STATUS_VALID).append("' ");
		hql.append(" order by u.writeDate desc ");
		System.out.println(hql);
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 相同资质用户数量
	 * @author zwp 2012-10-19
	 * @param cert 资质实体类
	 * @throws BaseException
	 */
	public int countCertField(Certificates cert) throws BaseException{
		StringBuffer hql = new StringBuffer(" select count(*) from Users as u where 1=1");
		hql.append(" and exists(select 1 from Certificates c where c.user.userId = u.userId and c.isUsable='0' ");
		if(cert!=null){
			if(cert.getCertField()!=null){
				hql.append(" and c.certField='").append(cert.getCertField()).append("' ");
			}
		}
		hql.append(") ");
		hql.append(" and u.isUsable='").append(TableStatus.COMMON_STATUS_VALID).append("' ");
		hql.append(" order by u.writeDate desc");
		System.out.println(hql);
		return this.baseDao.count(hql.toString());
	    
	}
  
	public List getCertUsersList(RollPage rollPage, Users user,
			Certificates cert) throws BaseException {
		StringBuffer hql = new StringBuffer("from Users de where 1 = 1" );
	if(user != null){
		if(cert!=null){
			if(!StringUtil.isBlank(cert.getCertField())){
				hql.append(" and EXISTS(select 1 from Certificates c where c.isUsable='0' and c.user.userId = de.userId and c.certField = '").append(cert.getCertField()).append("') ");
			}
		}
		if(!StringUtil.isBlank(user.getDepId())){
			hql.append(" and de.depId = ").append(user.getDepId());
		}
		if(!StringUtil.isBlank(user.getUserChinesename())){
			hql.append(" and de.userChinesename like '%").append(user.getUserChinesename().trim()).append("%'");
		}
		if(!StringUtil.isBlank(user.getRank())){
			hql.append(" and de.rank like '%").append(user.getRank()).append("%'");
		}
		if(!StringUtil.isBlank(user.getStation())){
			hql.append(" and de.station like '%").append(user.getStation()).append("%'");
		}
		if(!StringUtil.isBlank(user.getPolitical())){
			hql.append(" and de.political = '").append(user.getPolitical()).append("'");
		}
		if(!StringUtil.isBlank(user.getDegree())){
			hql.append(" and de.degree = '").append(user.getDegree()).append("'");
		}
		
		
	}
	    
	    hql.append(" and de.isUsable='0'");
	    System.out.println(hql);
		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
				
	}
}
