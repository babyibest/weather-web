package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.manpower.entity.Users;
import com.by.hctm.system.biz.IDepartmentsBIZ;
import com.by.hctm.system.entity.Departments;

public class DepartmentsBizImpl extends BaseBizImpl implements IDepartmentsBIZ   {

	/**
	 * 根据主键获得部门表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public Departments getDepartments(Long id) throws BaseException {
		return (Departments)this.getObject(Departments.class, id);
	}
	
	/**
	 * 添加部门表信息
	 * @param Departments 部门表实例
	 * @throws BaseException 
	 */
	public void saveDepartments(Departments departments) throws BaseException{
		this.saveObject( departments ) ;
	}
	
	/**
	 * 更新部门表实例
	 * @param departments 部门表实例
	 * @throws BaseException 
	 */
	public void updateDepartments(Departments departments ) throws BaseException{
		this.updateObject( departments ) ;
	}
	
	/**
	 * 更新部门表实例-修改本级和本级所有子节点为不可用
	 * @param departments 部门表实例
	 * @throws BaseException 
	 */
	public void updateDepartmentsBySelflevCode(  Departments departments  )throws BaseException{
		StringBuffer sbHql = new StringBuffer( " from  Departments dept where  1=1 " );
		
		if( departments != null && departments.getDepId() != null ) {
			sbHql.append( " and dept.selflevCode like '%," ).append( departments.getDepId() ).append(",%'") ;
			sbHql.append( " or dept.depId = " ).append( departments.getDepId() );
			
			List deptList= getObjects( sbHql.toString() );
			
			if(deptList!=null){
				for(int i=0;i<deptList.size();i++){
					Departments  dept = (Departments) deptList.get(i);
					dept.setIsUsable("1");
					
					this.updateDepartments( dept ) ;
				}
			}
		}
	}
	
	/**
	 * 删除部门表实例
	 * @param id 主键
	 * @throws BaseException 
	 */
	public void deleteDepartments(Long id) throws BaseException {
		this.removeObject( this.getDepartments( new Long(id) ) ) ;
	}
	
	/**
	 * 删除部门表实例
	 * @param departments 部门表实例
	 * @throws BaseException 
	 */
	public void deleteDepartments(Departments departments) throws BaseException {
		this.removeObject( departments ) ;
	}
	
	/**
	 * 删除部门表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteDemos(String[] id) throws BaseException {
		this.removeBatchObject(Departments.class, id) ;
	} 
	
	/**
	 * 获得所有部门数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List<Departments> getDepartmentsList( RollPage rollPage ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Departments dept where 1 = 1 " );

		hql.append(" and dept.isUsable = '0' ") ;
		hql.append(" order by dept.deptOrder asc ") ;
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有部门数据集
	 * @Cacheable(cacheName="departCache") 
	 * @param departments 部门对象
	 * @return
	 * @throws BaseException 
	 */
	
	public List<Departments> getDepartmentsList( Departments departments ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Departments dept where 1 = 1 " );

		if( departments != null ) {
			// 父类ID
			if( departments.getParentDeptId() != null ) {
				hql.append(" and dept.parentDeptId = " ).append( departments.getParentDeptId() ) ;
			}
			// 部门编码
			if( departments.getDeptCode() != null && departments.getDeptCode().length()>0 ) {
				hql.append(" and dept.deptCode = '" ).append( departments.getDeptCode() ).append("' ") ;
			}
			if( departments.getDeptName() != null && departments.getDeptName().length()>0 ) {
				hql.append(" and dept.deptName = '" ).append( departments.getDeptName() ).append("' ") ;
			}
		}
		
		hql.append(" and dept.isUsable = '0' ") ;
		hql.append(" order by dept.deptOrder asc ") ;
		
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有部门数据集
	 * @param rollPage 分页对象
	 * @param departments 部门对象
	 * @return
	 * @throws BaseException 
	 */
	public List<Departments> getDepartmentsList( RollPage rollPage, Departments departments ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Departments sub where 1 = 1 " );

		if( departments != null ) {
			// 父类ID
			if( departments.getParentDeptId() != null ) {
				hql.append(" and dept.parentDeptId = " ).append( departments.getParentDeptId() ) ;
			}
			// 部门编码
			if( departments.getDeptCode() != null && departments.getDeptCode().length()>0 ) {
				hql.append(" and dept.depCode = '" ).append( departments.getDeptCode() ).append("' ") ;
			}
		}
		
		hql.append(" and dept.isUsable = '0' ") ;
		
		hql.append(" order by dept.deptOrder asc ") ;
		
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有部门数量
	 * @param departments 部门对象
	 * @return
	 * @throws BaseException 
	 */
	public int getDepartmentsCount( Departments departments ) throws BaseException {
		
		int gValue = 0 ;
		StringBuffer hql = new StringBuffer(" select count(*) from Departments dept where 1 = 1 " );

		if( departments != null ) {
			// 父类ID
			if( departments.getParentDeptId() != null ) {
				hql.append(" and dept.parentDeptId = " ).append( departments.getParentDeptId() ) ;
			}
			// 部门编码
			if( departments.getDeptCode() != null && departments.getDeptCode().length()>0 ) {
				hql.append(" and dept.deptCode = '" ).append( departments.getDeptCode() ).append("' ") ;
			}
		}
		
		hql.append(" and dept.isUsable = '0' ") ;
		
		return this.countObjects( hql.toString() ) ;
	}
	
	/**
	 * 获得所有部门数据集
	 * @return
	 * @throws BaseException 
	 */
	public List<Departments> getTreeDepartmentsList() throws BaseException {
		List<Departments> list=	this.getObjects(Departments.class);
		
		return list;
	}
	
	/**
	 * 获得所有部门数据集
	 * @param rollPage 分页对象
	 * @param Departments 部门对象
	 * @return
	 * @throws BaseException 
	 */
	public List<Users> getUsersList( RollPage rollPage) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Users  where 1 = 1 " );
			return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得根据部门编号数据集
	 * @return
	 * @throws BaseException 
	 */
	public List<Departments> getDepartmentsCodeList(Departments departments ) throws BaseException {
		StringBuffer hql = new StringBuffer("from Departments where depCode='"+departments.getDeptCode().trim()+"'");
		List<Departments> list=	this.getObjects(hql.toString());
		
		return list;
	}
	
	/**
	 * 获得上级部门编号数据集，如果有下级部门，上级部门不允许删除
	 * @return
	 * @throws BaseException 
	 */
	public List<Departments> getDepartmentsupDepIdList(Departments departments ) throws BaseException {
		StringBuffer hql = new StringBuffer("from Departments where updepId='"+departments.getDeptCode()+"'");
		List<Departments> list=	this.getObjects(hql.toString());
		
		return list;
	}
	/**
	 * 获得所有部门人员视图
	 * @return
	 * @throws BaseException 
	 */
	public List getAllDeptRoot() throws BaseException {
		StringBuffer hql=new StringBuffer(" from Departments d where d.deptLevel = 1 ");
		return this.getObjects(hql.toString());
	}
}
