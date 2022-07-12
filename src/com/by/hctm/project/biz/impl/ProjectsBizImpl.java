package com.by.hctm.project.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.project.biz.IProjectsBiz;
import com.by.hctm.project.entity.Egorder;
import com.by.hctm.project.entity.EgorderDetail;
import com.by.hctm.project.entity.Projects;
import com.by.hctm.project.entity.Tyxs212Id;



public class ProjectsBizImpl extends BaseBizImpl implements IProjectsBiz {
	/**
	 * 获得所有亿格订单表数据集 
	 * @return 订单集合
	 * @author by 2015年3月11日20:21:22
	 * @throws BaseException 
	 */
	public List getOrdersList() throws BaseException {
		
	 
		StringBuffer hql = new StringBuffer(" from  Egorder   u  where 1=1   " );
		//hql.append(" and u.isUsable='").append(TableStatus.COMMON_STATUS_VALID).append("' ");
		  //查询
 		//hql.append(" and u.userChinesename like '%").append(user.getUserChinesename()).append("%' ");
		hql.append(" order by u.heth ");
		return this.getObjects (  hql.toString() );
	}

	/**
	 * 获得所有亿格订单表数据集 
	 * @param Egorder 查询参数对象
	 * @return
	 * @author by 2015年3月11日20:20:58
	 * @throws BaseException 
	 */
	public List getOrdersList(   Egorder egorder ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from  Egorder   u  where 1=1  " );
        if(egorder!=null){
        	//如果亿格订单号不为空  添加查询条件
        	if( !"".equals(egorder.getHeth())&&egorder.getHeth().length()!=0 ){
        		 hql.append(" and u.heth like '%").append(egorder.getHeth()).append("%' ");
				
			}
        }
        hql.append(" order by u.heth ");
		return this.getObjects (  hql.toString() );
	 
	}
  
	/**
	 * 根据主键获得项目台账表实例
	 * @param id 主键
	 * @return
	 * @author by 2015年3月12日10:50:35
	 * @throws BaseException 
	 */
	public EgorderDetail getEgorderDetail(Egorder egorder) throws BaseException {
		StringBuffer hql = new StringBuffer(" from  EgorderDetail   u  , Egorder s where 1=1   u.heth=s.heth" );
		if(egorder.getHeth()!=null){
			//如果亿格订单号不为空  添加查询条件
        		 hql.append(" and u.heth like '%").append(egorder.getHeth()).append("%' ");
		}
		return (EgorderDetail)this.getObjects (  hql.toString() );
	}
	/**
	 * 根据主键获得项目台账表实例
	 * @param id 主键
	 * @return
	 * @author by 2015年3月12日10:50:35
	 * @throws BaseException 
	 */
	public Egorder  getEgorder(String id) throws BaseException {
		return (Egorder)this.getObject(Egorder.class, id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 根据主键获得项目台账表实例
	 * @param id 主键
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public Projects getProjects(Long id) throws BaseException {
		return (Projects)this.getObject(Projects.class, id);
	}
	/**
	 * 根据主键获得项目台账表实例
	 * @param id 主键
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public Projects getProject(Long id) throws BaseException {
		return (Projects)this.getObject(Projects.class, id);
	}

	/**
	 * 添加项目台账信息
	 * @author zwp 2012-10-19
	 * @param Projects 项目台账表实例
	 * @throws BaseException 
	 */
	public void saveProjects(Projects projects) throws BaseException{
		this.saveObject( projects ) ;
	}
	
	/**
	 * 更新项目台账表实例
	 * @author zwp 2012-10-19
	 * @param Projects 项目台账表实例
	 * @throws BaseException 
	 */
	public void updateProjects(Projects projects) throws BaseException{
		this.updateObject( projects ) ;
	}
	
	/**
	 * 删除项目台账表实例
	 * @author zwp 2012-10-19
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteProjects(String id) throws BaseException {
		this.removeObject( this.getProjects( new Long(id) ) ) ;
	}
	
	/**
	 * 删除项目台账表实例
	 * @author zwp 2012-10-19
	 * @param Projects 项目台账表实例
	 * @throws BaseException 
	 */
	public void deleteProjects(Projects projects) throws BaseException {
		this.removeObject( projects ) ;
	}
	
	/**
	 * 删除项目台账表实例
	 * @author zwp 2012-10-19
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteProjectss(String[] id) throws BaseException {
		for(int i=0;i<id.length;i++){
			this.removeObject(Projects.class,new Long(id[i])) ;
		}
	}
	
	/**
	 * 关闭项目台账表实例
	 * @author zwp 2012-10-19
	 * @param projectId
	 * @throws BaseException
	 */
	public void updateByHql(Long projectId) throws BaseException{
		String hql = "update Projects as p set p.status='06' where p.projectId = '"+projectId+"'";
	    this.baseDao.updateObjectByHql(hql);
	}
	/**
	 * 获得所有项目台账表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public List getProjectsList( RollPage rollPage  ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Projects de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有项目台账表数据集
	 * @param Projects 查询参数对象
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public List getProjectsList(  Projects projects ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Projects de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有项目台账表数据集
	 * @param rollPage 分页对象
	 * @param Projects 查询参数对象
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public List getProjectsList( RollPage rollPage, Projects project ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Projects as p where 1 = 1 " );
        if(project!=null){
        	
        	if(project.getProjectName()!=null && project.getProjectName().length()!=0 && project.getProjectName()!=""){
				project.setProjectName(project.getProjectName());
				hql.append(" and p.projectName like '%").append(project.getProjectName()).append("%' ");
				
			}
			if(project.getOwnerName()!=null && project.getOwnerName().length()!=0 && project.getOwnerName()!=""){
				project.setOwnerName(project.getOwnerName());
				hql.append(" and p.ownerName like '%").append(project.getOwnerName()).append("%' ");
				
			}
//			if(project.getDepId()!=null && project.getDepId()!=0 ){
//				project.setDepId(project.getDepId());
//				hql.append(" and p.depId=").append(project.getDepId()).append(" ");
//				
//			}
			if(project.getDepName()!=null && project.getDepName()!="" && project.getDepName().length()>0){
				project.setDepName(project.getDepName());
				hql.append(" and p.depId=").append(project.getDepName()).append(" ");
				
			}
			if(project.getSubjId()!=null && project.getSubjId()!=0 ){
				project.setSubjId(project.getSubjId());
				hql.append(" and p.subjId=").append(project.getSubjId()).append(" ");
				
			}
			if(project.getProjectCode()!=null && project.getProjectCode().length()!=0 && project.getProjectCode()!=""){
				project.setProjectCode(project.getProjectCode());
				hql.append(" and p.projectCode like '%").append(project.getProjectCode()).append("%' ");
				
			}
			if(StringUtil.isNotBlank(project.getStatus())){
				hql.append(" and p.status='").append(project.getStatus()).append("' ");
			}
        }
        hql.append(" and p.isUsable='0'");
		hql.append(" order by p.writeDate desc ");
		System.out.println(hql);
		return this.getObjects(rollPage, hql.toString() );
	}
  

	
	
}
