package com.by.hctm.system.action;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.BaseDataInfosUtil;
import com.by.hctm.common.TableStatus;
import com.by.hctm.common.utils.MD5;
import com.by.hctm.manpower.biz.IUsersBiz;
import com.by.hctm.manpower.entity.Certificates;
import com.by.hctm.manpower.entity.Users;
import com.by.hctm.system.biz.IDepartmentsBIZ;
import com.by.hctm.system.entity.Departments;

public class UsersAction extends BaseAction {
	private IDepartmentsBIZ iDepartmentsBIZ;
	private IUsersBiz iUsersBiz  ;
	private Departments departments;
	private List<Certificates> certificatesList;
	private Users users ;
	private String tree ;
	
	/**
	 * 查看部门信息首页列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewDepartmentsIndex() {
		
		return INDEX ;
	}
	
	/**
	 * 查看部门信息表初始树列表 getTree
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewDepartmentsInitTree() throws BaseException {
		
		try{
			Long id;
			String name = "";
			
			// 初始父ID为零
			Departments dept = new Departments() ;
			dept.setParentDeptId( new Long(0) ) ;
			List deptList = iDepartmentsBIZ.getDepartmentsList( dept );
			
			StringBuffer script = new StringBuffer();
			script.append("var tree = new WebFXTree(\"机构树\");\n");
			Iterator it=	deptList.iterator();
			
			while (it.hasNext()) {
				Departments	departments=(Departments)it.next();
				id = departments.getDepId();
				name = StringEscapeUtils.escapeXml(departments.getDeptName().trim());
				int count = iUsersBiz.countUsers(null);//用户总数（在职）
				// 判断是否有子节点
				if ("0".equals( departments.getIsHaveChild() )) {
					script.append("tree.add( rti = new WebFXLoadTreeItem(\"" + name +"("+count+")"+ "\", \"viewDepartmentsTree_sysusers.action?&departments.parentDeptId=" + id + "\",\"javascript:folderview('" + id + "')\"));\n");
					
				} else {
					script.append("tree.add( new WebFXTreeItem(\"" + name +"("+count+")"+ "\",\"javascript:folderview('" + id + "')\"));\n");
				}
			}
			
			script.append("document.write(tree);\n");
			script.append("tree.expand();\n"); 

			tree = script.toString() ;
			
		} catch (Exception e) {
			log.error("查看部门信息表初始树列表错误！", e);
			throw new BaseException("查看部门信息表初始树列表错误！", e);
		}
		
		return TREE ;
	}
	
	/**
	 * 查看部门信息表树列表 
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewDepartmentsTree() throws BaseException {
		
		try{
			Long id;
			String name = "";
			
			Departments dept = new Departments() ;
			dept.setParentDeptId( departments.getParentDeptId() ) ;
			
			List deptList = iDepartmentsBIZ.getDepartmentsList( dept );

			StringBuffer script = new StringBuffer();
			script.append("<?xml version=\"1.0\"?>");
			script.append("<tree>");
			Iterator it=deptList.iterator();
			while (it.hasNext()) {
				Departments departments = (Departments) it.next() ;
				id 		= departments.getDepId() ;
				name 	= StringEscapeUtils.escapeXml(departments.getDeptName().trim());
				users = new Users();
				users.setDepId(id);
				int count = iUsersBiz.countUsers(users);
				script.append("<tree text=\"" + name + "(" + count + ")" + "\" id=\"" + id + "\" action=\"javascript:folderview('" + id + "')\" ");
				// 判断是否有子节点
				if ( "0".equals( departments.getIsHaveChild() ) ) {
					script.append(" src=\"viewDepartmentsTree_users.action?departments.parentDeptId=").append(id).append("\" ");
				}
				
				script.append("/>");
				
			}
			
			script.append("</tree>");
			
			getResponse().getWriter().println(script.toString());
			
		} catch (Exception e) {
			log.error("查看部门信息表初始树列表错误！", e);
			throw new BaseException("查看部门信息表初始树列表错误！", e);
		}
		
		return null ;
	}
	
	/**
	 * 查看用户信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewUsers() throws BaseException {
		
		try{
			this.setListValue( this.iUsersBiz.getUsersList( this.getRollPage(), users, departments) ) ;
			departments = iDepartmentsBIZ.getDepartments(departments.getDepId());
		} catch (Exception e) {
			log.error("查看用户信息列表错误！", e);
			throw new BaseException("查看用户信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 修改用户信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String updateUsersInit() throws BaseException {
		
		try{
			users=this.iUsersBiz.getUsers( users.getUserId() );
			departments.setDepId(departments.getDepId());
		} catch (Exception e) {
			log.error("修改用户信息初始化错误！", e);
			throw new BaseException("修改用户信息初始化错误！", e);
		}
		return MODIFY_INIT;
		
	}
	
	/**
	 * 修改用户信息
	 * @return
	 * @throws BaseException 
	 */
	public String updateUsers() throws BaseException {
		
		try{
			Users tuser = this.iUsersBiz.getUsers( users.getUserId() );
			tuser.setUserName(users.getUserName() ) ;
			tuser.setUserPassword( MD5.toMD5String ( users.getUserPassword() ) ) ;
			tuser.setSysStatus( users.getSysStatus() ) ;
			
			this.iUsersBiz.updateUsers( tuser );
			
			BaseDataInfosUtil.initBaseIndexInfos( TableStatus.BASE_DATA_TYPE_01 ) ;
			
			users = null;
		} catch (Exception e) {
			log.error("修改用户信息错误！", e);
			throw new BaseException("修改用户信息错误！", e);
		}
		return viewUsers();
		
	}
	
	/**
	 * 重置用户密码信息
	 * @return
	 * @throws BaseException 
	 */
	public String resetUsers() throws BaseException {
		try{
			users = iUsersBiz.getUsers(users.getUserId());
			users.setUserPassword( MD5.toMD5String ( "666666" ) ) ;
			iUsersBiz.updateUsers(users);
			
			users = null;//清除默认查询信息
			departments.setDepId(departments.getDepId());
			
		} catch (Exception e) {
			log.error("重置用户密码信息错误！", e);
			throw new BaseException("重置用户密码信息错误！", e);
		}
		return viewUsers();
		
	}

	public IDepartmentsBIZ getIDepartmentsBIZ() {
		return iDepartmentsBIZ;
	}

	public void setIDepartmentsBIZ(IDepartmentsBIZ departmentsBIZ) {
		iDepartmentsBIZ = departmentsBIZ;
	}

	public IUsersBiz getIUsersBiz() {
		return iUsersBiz;
	}

	public void setIUsersBiz(IUsersBiz usersBiz) {
		iUsersBiz = usersBiz;
	}

	public Departments getDepartments() {
		return departments;
	}

	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getTree() {
		return tree;
	}

	public void setTree(String tree) {
		this.tree = tree;
	}

	public List<Certificates> getCertificatesList() {
		return certificatesList;
	}

	public void setCertificatesList(List<Certificates> certificatesList) {
		this.certificatesList = certificatesList;
	} 
}
