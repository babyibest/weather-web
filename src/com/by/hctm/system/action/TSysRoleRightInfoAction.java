package com.by.hctm.system.action;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.manpower.biz.IUsersBiz;
import com.by.hctm.manpower.entity.Users;
import com.by.hctm.system.biz.IDepartmentsBIZ;
import com.by.hctm.system.biz.ITSysRoleBiz;
import com.by.hctm.system.biz.ITSysRoleRightInfoBiz;
import com.by.hctm.system.biz.ITSysRoleUserInfoBiz;
import com.by.hctm.system.entity.Departments;
import com.by.hctm.system.entity.TSysRole;
import com.by.hctm.system.entity.TSysRoleRightInfo;
import com.by.hctm.system.entity.TSysRoleUserInfo;

public class TSysRoleRightInfoAction extends BaseAction {
	private ITSysRoleRightInfoBiz iSysRoleRightInfoBiz  ;
	private ITSysRoleUserInfoBiz ITSysRoleUserInfoBiz;
	private TSysRoleUserInfo sysRoleUserInfo;
	private TSysRoleRightInfo sysRoleRightInfo ;
	private IDepartmentsBIZ iDepartmentsBIZ;
	private ITSysRoleBiz iTSysRoleBiz;
	private TSysRole sysRole;
	private Departments departments;
	private IUsersBiz iUsersBiz;
	private String tree ;
	private Users users;
	
	
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
					script.append("tree.add( rti = new WebFXLoadTreeItem(\"" + name +"("+count+")"+ "\", \"viewDepartmentsTree_roleRight.action?&departments.parentDeptId=" + id + "\",\"javascript:folderview('" + id + "')\"));\n");
					
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
	public void viewDepartmentsTree() throws BaseException {
		
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
					script.append(" src=\"viewDepartmentsTree_roleRight.action?departments.parentDeptId=").append(id).append("\" ");
				}
				
				script.append("/>");
				
			}
			
			script.append("</tree>");
			
			getResponse().getWriter().println(script.toString());
			
		} catch (Exception e) {
			log.error("查看部门信息表初始树列表错误！", e);
			throw new BaseException("查看部门信息表初始树列表错误！", e);
		}
		
		
	}
	/**
	 * 查看角色权限信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewTSysRoleRightInfo() throws BaseException {
		
		try{
			
			this.setListValue( this.iUsersBiz.getUsersListRight(this.getRollPage(), users)) ;
		} catch (Exception e) {
			log.error("查看角色权限信息列表错误！", e);
			throw new BaseException("查看角色权限信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 保存角色权限信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String saveTSysRoleRightInfoInit() throws BaseException {
		try{
			users = this.iUsersBiz.getUsers(users.getUserId());
			departments = this.iDepartmentsBIZ.getDepartments(users.getDepId());
			sysRole = new TSysRole();
			sysRole.setRoleId(new Long(users.getUserId()));
			this.setListValue(this.iTSysRoleBiz.getSysRoleList(this.getRollPage(), sysRole));
		} catch (Exception e) {
			log("保存角色权限信息初始化错误！", e);
			throw new BaseException("保存角色权限信息初始化错误！", e);
		}
		return ADD_INIT;
		
	}
	
	/**
	 * 保存角色权限信息
	 * @return
	 * @throws BaseException 
	 */
	public String saveTSysRoleRightInfo() throws BaseException {
		
		try{
			this.iSysRoleRightInfoBiz.saveTSysRoleRightInfo( sysRoleRightInfo );
			
		} catch (Exception e) {
			log("保存角色权限信息错误！", e);
			throw new BaseException("保存角色权限信息错误！", e);
		}
		
		return ADD;
		
	}
	
	/**
	 * 角色信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String SysRoleRightInit() throws BaseException {
		
		try{
			this.getRequest().setAttribute("userId", this.getRequest().getParameter("id"));
			this.setListValue(this.iTSysRoleBiz.getTSysRoleList(this.getRollPage(),this.getRequest().getParameter("id")));
		} catch (Exception e) {
			log("修改角色权限信息初始化错误！", e);
			throw new BaseException("修改角色权限信息初始化错误！", e);
		}
		return "role";
		
	}
	
	/**
	 * dwr
	 * 修改用户角色信息
	 * @return
	 * @throws BaseException 
	 */
	public String updateTSysRoleRightInfo(String id,String userId) throws BaseException {
		
		try{
			String rd [] = id.split(",");
			for (int i = 0; i < rd.length; i++) {
				sysRoleUserInfo = new TSysRoleUserInfo();
				sysRoleUserInfo.setUserId(new Long(userId));
				sysRoleUserInfo.setRoleId(new Long(rd[i]));
				this.ITSysRoleUserInfoBiz.saveTSysRoleUserInfo(sysRoleUserInfo);
			}
			
		} catch (Exception e) {
			log("修改角色权限信息错误！", e);
			throw new BaseException("修改角色权限信息错误！", e);
		}
		return MODIFY;
		
	}
	
	/**
	 * 查看用户角色信息
	 * @return 
	 * @return
	 * @throws BaseException 
	 */
	public  List<TSysRole> saveUserRoleInfo(String id) throws BaseException {
		List<TSysRole> list ;
		try{
			sysRole = new TSysRole();
			sysRole.setRoleId(new Long(id));
			list=this.iTSysRoleBiz.getSysRoleList(this.getRollPage(), sysRole);
		
			System.out.println(list.size());
		} catch (Exception e) {
			log("修改角色权限信息错误！", e);
			throw new BaseException("修改角色权限信息错误！", e);
		}
		return list ;
	}
	/**
	 * 删除角色权限信息
	 * @return
	 * @throws BaseException 
	 */
	public String deleteTSysRoleRightInfo(String id) throws BaseException {
		try{
		
			String roleId=	this.getRequest().getParameter("roleId");	
			this.ITSysRoleUserInfoBiz.deleteTSysRoleUserInfo(id);
		} catch (Exception e) {
			log("删除角色权限信息错误！", e);
			throw new BaseException("删除角色权限信息错误！", e);
		}
		return DELETE;
		
	}
	
	/**
	 * 查看角色权限明细信息
	 * @return
	 * @throws BaseException 
	 */
	public String viewTSysRoleRightInfoDetail() throws BaseException {
		
		try{
			sysRoleRightInfo=this.iSysRoleRightInfoBiz.getTSysRoleRightInfo( sysRoleRightInfo.getRrId() );
		} catch (Exception e) {
			log("查看角色权限明细信息错误！", e);
			throw new BaseException("查看角色权限明细信息错误！", e);
		}
		return DETAIL;
		
	}
	
	/**
	 * 提交角色权限信息
	 * @return
	 * @throws BaseException 
	 */
	public String submitTSysRoleRightInfo() throws BaseException {
		
		try{
//			this.iSysRoleRightInfoBiz.submitSubjects( subjects  );
		} catch (Exception e) {
			log("提交角色权限信息错误！", e);
			throw new BaseException("提交角色权限信息错误！", e);
		}
		return SUBMIT;
		
	}

	public ITSysRoleRightInfoBiz getISysRoleRightInfoBiz() {
		return iSysRoleRightInfoBiz;
	}

	public void setISysRoleRightInfoBiz(ITSysRoleRightInfoBiz sysRoleRightInfoBiz) {
		iSysRoleRightInfoBiz = sysRoleRightInfoBiz;
	}

	public TSysRoleRightInfo getSysRoleRightInfo() {
		return sysRoleRightInfo;
	}

	public void setSysRoleRightInfo(TSysRoleRightInfo sysRoleRightInfo) {
		this.sysRoleRightInfo = sysRoleRightInfo;
	}

	public IDepartmentsBIZ getIDepartmentsBIZ() {
		return iDepartmentsBIZ;
	}

	public void setIDepartmentsBIZ(IDepartmentsBIZ departmentsBIZ) {
		iDepartmentsBIZ = departmentsBIZ;
	}

	public Departments getDepartments() {
		return departments;
	}

	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

	public IUsersBiz getIUsersBiz() {
		return iUsersBiz;
	}

	public void setIUsersBiz(IUsersBiz usersBiz) {
		iUsersBiz = usersBiz;
	}

	public String getTree() {
		return tree;
	}

	public void setTree(String tree) {
		this.tree = tree;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public ITSysRoleBiz getITSysRoleBiz() {
		return iTSysRoleBiz;
	}

	public void setITSysRoleBiz(ITSysRoleBiz sysRoleBiz) {
		iTSysRoleBiz = sysRoleBiz;
	}

	public TSysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(TSysRole sysRole) {
		this.sysRole = sysRole;
	}

	public ITSysRoleUserInfoBiz getITSysRoleUserInfoBiz() {
		return ITSysRoleUserInfoBiz;
	}

	public void setITSysRoleUserInfoBiz(ITSysRoleUserInfoBiz sysRoleUserInfoBiz) {
		ITSysRoleUserInfoBiz = sysRoleUserInfoBiz;
	}

	public TSysRoleUserInfo getSysRoleUserInfo() {
		return sysRoleUserInfo;
	}

	public void setSysRoleUserInfo(TSysRoleUserInfo sysRoleUserInfo) {
		this.sysRoleUserInfo = sysRoleUserInfo;
	}
	
	
	
}
