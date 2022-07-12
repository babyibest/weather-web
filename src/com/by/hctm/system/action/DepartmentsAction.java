package com.by.hctm.system.action;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.BaseDataInfosUtil;
import com.by.hctm.manpower.biz.IUsersBiz;
import com.by.hctm.system.biz.IDepartmentsBIZ;
import com.by.hctm.system.entity.Departments;
/**
 * @author ted
 * 
 */
public class DepartmentsAction extends BaseAction {
	private IDepartmentsBIZ iDepartmentsBIZ;
	private Departments departments;
	private IUsersBiz iUsersBiz;
	private String tree ;
	private String message ;
	
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
				
				// 判断是否有子节点
				if ("0".equals( departments.getIsHaveChild() )) {
					script.append("tree.add( rti = new WebFXLoadTreeItem(\"" + name + "\", \"viewDepartmentsTree_dept.action?&departments.parentDeptId=" + id + "\",\"javascript:folderview('" + id + "')\"));\n");
					
				} else {
					script.append("tree.add( new WebFXTreeItem(\"" + name + "\",\"javascript:folderview('" + id + "')\"));\n");
				}
			}
			script.append("document.write(tree);\n");
			script.append("tree.expand();\n"); 
			tree = script.toString() ;
		} catch (Exception e) {
			log("查看部门信息表初始树列表错误！", e);
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
			List deptList = iDepartmentsBIZ.getDepartmentsList( departments  );
			StringBuffer script = new StringBuffer();
			script.append("<?xml version=\"1.0\"?>");
			script.append("<tree>");
			Iterator it=deptList.iterator();
			while (it.hasNext()) {
				Departments departments = (Departments) it.next() ;
				id 		= departments.getDepId() ;
				name 	= StringEscapeUtils.escapeXml(departments.getDeptName().trim());
				script.append("<tree text=\"" + name + "\" id=\"" + id + "\" action=\"javascript:folderview('" + id + "')\" ");
				// 判断是否有子节点
				if ( "0".equals( departments.getIsHaveChild() ) ) {
					script.append(" src=\"viewDepartmentsTree_dept.action?departments.parentDeptId=").append(id).append("\" ");
				}
				script.append("/>");
			}
			script.append("</tree>");
			getResponse().getWriter().println(script.toString());
		} catch (Exception e) {
			log("查看部门信息表初始树列表错误！", e);
			throw new BaseException("查看部门信息表初始树列表错误！", e);
		}
	}
	
	/**
	 * 修改部门信息初始化
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String updateDepartmentsInit() throws BaseException {
		
		try{
			departments= iDepartmentsBIZ.getDepartments( departments.getDepId() ) ;
			if(departments.getCompLeaderEn() !=null && departments.getDepLeaderEn() != null){
				departments.setDepLeaderCn(BaseDataInfosUtil.convertUserIdToChnName(new Long(departments.getDepLeaderEn())));
				departments.setCompLeaderCn(BaseDataInfosUtil.convertUserIdToChnName(new Long(departments.getCompLeaderEn())));
			}
		} catch (Exception e) {
			log("修改部门信息初始化错误！", e);
			throw new BaseException("修改部门信息初始化错误！", e);
		}
		
		return MODIFY_INIT ;
	}
	
	/**
	 * 修改部门信息信息
	 * @return
	 * @throws BaseException 
	 */
	public String updateDepartments() throws BaseException {
		try{
			//Users depLeader =this.iUsersBiz.getUsers(new Long(departments.getDepLeaderEn()));
			//Users compLeader =this.iUsersBiz.getUsers(new Long(departments.getCompLeaderEn()));
			System.out.println(departments.getCompLeaderEn());
			System.out.println(departments.getDepLeaderEn());
			iDepartmentsBIZ.updateDepartments( departments ) ;
			departments.setOperType("update") ;
			message = " 修改成功! " ;
		} catch (Exception e) {
			log("修改部门信息信息错误！", e);
			throw new BaseException("修改部门信息信息错误！", e);
		}
		return MODIFY;
	}
	
	/**
	 * 保存部门信息信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String saveDepartmentsInit() throws BaseException {
		try{
			departments = iDepartmentsBIZ.getDepartments( departments.getDepId() ) ;
		} catch (Exception e) {
			log("保存部门信息信息初始化错误！", e);
			throw new BaseException("保存部门信息信息初始化错误！", e);
		}
		return ADD_INIT;
	}
	
	/**
	 * 保存部门信息信息
	 * @return
	 * @throws BaseException 
	 */
	public String saveDepartments() throws BaseException {
		try{
			
			// 更新父节点中是否有子节点为存在  Ted 2009-12-03 
			Departments parentdt= iDepartmentsBIZ.getDepartments( departments.getParentDeptId() ) ;
			parentdt.setIsHaveChild("0");
			
			iDepartmentsBIZ.updateDepartments( parentdt ) ;
			
			departments.setSelflevName( parentdt.getSelflevName() + "," + departments.getDeptName().toString() ) ;
			
			departments.setDeptLevel( parentdt.getDeptLevel() + 1 ) ;
			
			departments.setCreateTime(new Date() ) ;
			departments.setCreateMan( "admin" ) ;
			
			// 保存部门表
			iDepartmentsBIZ.saveDepartments( departments ) ;
			
			departments.setSelflevCode( parentdt.getSelflevCode() + "," + departments.getDepId().toString() ) ;
			
			// 更新级联码
			iDepartmentsBIZ.updateDepartments( departments ) ;
			
			departments.setOperType("add") ;
			message = " 新增成功! " ;
			
		} catch (Exception e) {
			log("保存部门信息信息错误！", e);
			throw new BaseException("保存部门信息信息错误！", e);
		}
		
		return ADD;
		
	}
   
	/**
	 * 生成树-修改操作后定位
	 * @return
	 * @throws BaseException
	 */
	public String getRelocationTree() throws BaseException {
		
		StringBuffer script = new StringBuffer();
		script.append(" var tree = new WebFXTree(\"组织机构\"); \n");
		
		script.append( getTreeListByCode( departments.getSelflevCode() ) ) ;
		
		script.append("document.write(tree);\n");
		script.append("tree.expandChildren();\n"); 
		
		tree = script.toString() ;
		return TREE ;
	}
	
	/**
	 * 根据级联码生成静态+动态树
	 * @param selfevCode 级联码
	 * @return
	 * @author 
	 * @throws BaseException 
	 */
	private String getTreeListByCode( String selfevCode ) throws BaseException {
		StringBuffer sb = new StringBuffer("") ;
		
		List<Departments> deptListTemp = new ArrayList<Departments>();
		
		Long id;
		String name = "";
		String isHaveChild = "" ;
		Long parentId	= new Long(0) ;
		String action = "" ;
		String jscript = "" ;
		
		Departments deptst = null ;
		Departments deptst2 = new Departments()  ;
		
		if( selfevCode !=null && selfevCode.length()>0 ) {
			
			String [] scodearr = selfevCode.split(",") ;
			
			for( int i=0; i<scodearr.length-1; i++ ) {
				deptst2.setParentDeptId( new Long( scodearr[i] ) ) ;
				deptListTemp = iDepartmentsBIZ.getDepartmentsList( deptst2 ) ;
				
				for( int j=0; j<deptListTemp.size(); j++ ) {
					deptst 		=  deptListTemp.get( j ) ;
					id 			= deptst.getDepId() ;
					name 		= StringEscapeUtils.escapeXml(deptst.getDeptName().trim());
					isHaveChild = deptst.getIsHaveChild() ;
					parentId	= deptst.getParentDeptId() ;
					action 		= "\"viewDepartmentsTree_dept.action?departments.parentDeptId=" + id + "\"" ;
					jscript		= "\"javascript:folderview('" + id + "')\"" ;
					
					if( i==0 ) {
						if ("0".equals( isHaveChild )) {
							if( id.toString().equals( scodearr[i+1] ) ) {
								sb.append(" var folder").append(id).append(" = new WebFXTreeItem( \"" ).append( name ).append( "\" , " ).append( jscript ).append( " ) ; \n " ) ;
								sb.append(" tree.add( folder").append(id).append("); ");
								
							}else{
								sb.append(" tree.add( new WebFXLoadTreeItem( \"" ).append( name).append( "\" , ").append( action ).append( " , " ).append( jscript ).append( " ) ) ; \n " ) ;
							}
							
						}else {
							sb.append(" tree.add(new WebFXTreeItem( \"" ).append( name ).append( "\" , " ).append( jscript ).append( " ) ) ; \n " ) ;
						}
						
					}else {
						
						if ("0".equals( isHaveChild )) {
							if( id.toString().equals( scodearr[i+1] ) ) {
								sb.append(" var folder").append(id).append(" = new WebFXTreeItem( \"" ).append( name ).append( "\" , " ).append( jscript ).append( " ) ; \n " ) ;
								sb.append(" folder").append( parentId ).append(".add(folder").append(id).append("); ");
								
							}else{
								sb.append(" folder").append( parentId ).append(".add( new WebFXLoadTreeItem( \"" ).append( name).append( "\" , ").append( action ).append( " , " ).append( jscript ).append( " ) ) ; \n " ) ;
							}
							
						}else {
							sb.append(" folder").append( parentId ).append(".add( new WebFXTreeItem( \"" ).append( name ).append( "\" , " ).append( jscript ).append( " ) ) ; \n " ) ;
						}
					}
				}
			}
			
		}
		
		return sb.toString() ;
	}
	
	/**
	 * 删除部门信息信息
	 * @return
	 * @throws BaseException 
	 */
	public String delDepartments() throws BaseException {
		try{
			
			departments = iDepartmentsBIZ.getDepartments(  departments.getDepId() ) ;
			
			// 更新部门表-本级和它所有子节点为不可用
			iDepartmentsBIZ.updateDepartmentsBySelflevCode( departments ) ;
			
			Departments dept = new Departments() ;
			dept.setParentDeptId( departments.getParentDeptId() ) ;
			//  判断父节点下面是否存在子节点
			int dpCount = iDepartmentsBIZ.getDepartmentsCount( dept ) ;
			if( dpCount == 0 ) {
				Departments  parentDept= iDepartmentsBIZ.getDepartments(  departments.getParentDeptId() );
				parentDept.setIsHaveChild("1");
				iDepartmentsBIZ.updateDepartments( parentDept );
			}
			
			departments.setOperType("delete") ;
			message = " 删除成功! " ;
			
		} catch (Exception e) {
			log("删除部门信息信息错误！", e);
			throw new BaseException("删除部门信息信息错误！", e);
		}
		
		return DELETE;
		//793
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
