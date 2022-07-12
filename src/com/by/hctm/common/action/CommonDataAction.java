package com.by.hctm.common.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringEscapeUtils;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.BaseDataInfosUtil;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.manpower.biz.ICertificatesBiz;
import com.by.hctm.manpower.biz.ICertificatesKindBiz;
import com.by.hctm.manpower.biz.IUsersBiz;
import com.by.hctm.manpower.entity.Certificates;
import com.by.hctm.manpower.entity.CertificatesKind;
import com.by.hctm.manpower.entity.Users;
import com.by.hctm.system.biz.IDepartmentsBIZ;
import com.by.hctm.system.biz.ISubjectsBIZ;
import com.by.hctm.system.entity.Departments;
import com.by.hctm.system.entity.Subjects;

public class CommonDataAction extends BaseAction  {
	//专业业务逻辑层
	private ISubjectsBIZ ISubjectsBIZ;
	//专业实体类
	private Subjects subjects;
	//定义树javascript
	private String tree ;
	//部门业务逻辑层
	private IDepartmentsBIZ iDepartmentsBIZ;
	//用户业务逻辑层
	private IUsersBiz iUsersBiz  ;
	//部门实体类
	private Departments departments;
	//用户实体类
	private Users users ;
	//资质业务逻辑层
	private ICertificatesBiz iCertificatesBiz;
	//资质实体类
	private Certificates certificates;
	private ICertificatesKindBiz certificatesKindBiz  ;
	// 人员资质树 实例
	private CertificatesKind certificatesKind ;
	//项目部组建人员表服务类 
	/**
	 * 专业树单选
	 * 查看标准信息表初始树列表
	 * 
	 * @return
	 * @throws BaseException
	 * @Action
	 */
	public String viewStandardsInitTree() throws BaseException {

		try {
			String id;
			String name = "";
			int count = 0;
			subjects = new Subjects();
			StringBuffer script = new StringBuffer();
			script.append("var tree = new WebFXTree(\"机构树\");\n");

			// 取所有标准
			Set gSet = BaseDataInfosUtil.getDictInfoToMap("1700").keySet();
			Iterator it = gSet.iterator();
			while (it.hasNext()) {
				id = it.next().toString();
				name = StringEscapeUtils.escapeXml(BaseDataInfosUtil.getDictInfoToMap("1700").get(id).toString());
				subjects.setStandardId(new Long(id));
				//System.out.println(TableStatusMap.belongStandard.get(id));
				count = this.ISubjectsBIZ.getSubjectsCount(subjects);
				// 判断是否有子节点
				if (count > 0) {
					script.append("tree.add( rti = new WebFXLoadTreeItem(\""
							+ name
							+ "\", \"viewSubTree_commonData.action?&subjects.standardId="
							+ id + "\",\"\"));\n");

				} else {
					script.append("tree.add( new WebFXTreeItem(\"" + name
							+ "\",\"\"));\n");
				}
			}

			script.append("document.write(tree);\n");
			script.append("tree.expand();\n");

			tree = script.toString();

		} catch (Exception e) {
			log("查看标准信息表初始树列表错误！", e);
			throw new BaseException("查看标准信息表初始树列表错误！", e);
		}

		return TREE;
	}

	/**
	 * 查看专业信息表树列表
	 * 
	 * @return
	 * @throws BaseException
	 * @Action
	 */
	public String viewSubTree() throws BaseException {

		try {
			Long id;
			String name = "";
			String str ="";
			List subjectList = this.ISubjectsBIZ.getSubjectsList(subjects);
			StringBuffer script = new StringBuffer();
			script.append("<?xml version=\"1.0\"?>");
			script.append("<tree>");
			Iterator it = subjectList.iterator();
			while (it.hasNext()) {
				Subjects stsList = (Subjects) it.next();
				id = stsList.getSubjId();
				name = StringEscapeUtils.escapeXml(stsList.getSubjName().trim());
				//System.out.println(stsList.getStandardId());
				str = BaseDataInfosUtil.convertSubjectIdToName(stsList.getSubjId())+ "#" 
				+ BaseDataInfosUtil.convertDictCodeToName(stsList.getStandardId().toString(), "1700")+"#"
				+ stsList.getSubjId() + "#";
				
				script.append("<tree text=\"" + name + "\" id=\"" + id	+ "\" action=\"javascript:folderview('" + str + "')\" ");
				// 判断是否有子节点
				// if ( "0".equals( departments.getIsHaveChild() ) ) {
//				script.append(
//						" src=\"viewDepartmentsTree_dept.action?departments.parentDeptId=")
//						.append(id).append("\" ");
				// }

				script.append("/>");

			}

			script.append("</tree>");

			getResponse().getWriter().println(script.toString());

		} catch (Exception e) {
			log("查看部门信息表初始树列表错误！", e);
			throw new BaseException("查看部门信息表初始树列表错误！", e);
		}

		return null;
	}

	/**
	 * 专业树多选
	 * 查看标准信息表初始树列表
	 * 多选跳到subject_index.jsp 的action框架页面
	 * @return
	 * @throws BaseException
	 * @Action
	 * @谢磊
	 */
	public String viewStandardSubjectTree() throws BaseException {
			if(StringUtil.isNotBlank(subjects)&& StringUtil.isNotBlank(subjects.getSubjName())){
				
				//System.out.println(subjects.getSubjName());
				this.getRequest().setAttribute("sub", subjects);
			}
		return "SubjectTreeIndex";
	}
	/**
	 * 多选专业树 subjects_View.jsp方法
	  @return
	 * @throws BaseException
	 * @Action
	 * @谢磊
	 * */
	public String SubjectView() throws BaseException {
		if(StringUtil.isNotBlank(subjects)&&StringUtil.isNotBlank(subjects.getSubjName())){
		
			List<Subjects> list= new ArrayList();
			String sj =subjects.getSubjName();
			String [] id=sj.split(",");
			for (int i = 0; i < id.length; i++) 
			{		
				Subjects sub = new Subjects();
				sub =this.ISubjectsBIZ.getSubjects(new Long(id[i]));
				list.add(sub);
			}
			this.getRequest().setAttribute("sjn", list);
			}
		return "SubjectView";
	}
	
	public String viewStandardSubjectInitTree() throws BaseException {

		try {
			String id;
			String name = "";
			int count = 0;
			subjects = new Subjects();
			StringBuffer script = new StringBuffer();
			script.append("var tree = new WebFXTree(\"机构树\");\n");
			
			// 取所有标准
			Set gSet = BaseDataInfosUtil.getDictInfoToMap("1700").keySet();
			Iterator it = gSet.iterator();
			while (it.hasNext()) {
				id = it.next().toString();
				name = StringEscapeUtils.escapeXml(BaseDataInfosUtil.getDictInfoToMap("1700").get(id).toString());
				subjects.setStandardId(new Long(id));
				//System.out.println(TableStatusMap.belongStandard.get(id));
				count = this.ISubjectsBIZ.getSubjectsCount(subjects);
				// 判断是否有子节点
				if (count > 0) {
					script.append("tree.add( rti = new WebFXLoadTreeItem(\""
							+ name
							+ "\", \"viewSubjectTree_commonData.action?&subjects.standardId="
							+ id + "\",\"\"));\n");

				} else {
					script.append("tree.add( new WebFXTreeItem(\"" + name
							+ "\",\"\"));\n");
				}
			}

			script.append("document.write(tree);\n");
			script.append("tree.expand();\n");

			tree = script.toString();

		} catch (Exception e) {
			log("查看标准信息表初始树列表错误！", e);
			throw new BaseException("查看标准信息表初始树列表错误！", e);
		}

		return "SubjectTree";
	}

	/**
	 * 查看专业信息表树列表
	 * 
	 * @return
	 * @throws BaseException
	 * @Action
	 */
	public String viewSubjectTree() throws BaseException {

		try {
			Long id;
			String name = "";
			String str ="";
			List subjectList = this.ISubjectsBIZ.getSubjectsList(subjects);
			StringBuffer script = new StringBuffer();
			script.append("<?xml version=\"1.0\"?>");
			script.append("<tree>");
			Iterator it = subjectList.iterator();
			while (it.hasNext()) {
				Subjects stsList = (Subjects) it.next();
				id = stsList.getSubjId();
				name = StringEscapeUtils.escapeXml(stsList.getSubjName().trim());
				//System.out.println(stsList.getStandardId());
				str = BaseDataInfosUtil.convertSubjectIdToName(stsList.getSubjId())+ "#" 
				+ BaseDataInfosUtil.convertDictCodeToName(stsList.getStandardId().toString(), "1700")+"#"
				+ stsList.getSubjId() + "#";
				
				script.append("<tree text=\"" + name + "\" id=\"" + id	+ "\" action=\"javascript:folderview('" + str + "')\" ");
				// 判断是否有子节点
				// if ( "0".equals( departments.getIsHaveChild() ) ) {
//				script.append(
//						" src=\"viewDepartmentsTree_dept.action?departments.parentDeptId=")
//						.append(id).append("\" ");
				// }

				script.append("/>");

			}

			script.append("</tree>");

			getResponse().getWriter().println(script.toString());

		} catch (Exception e) {
			log("查看部门信息表初始树列表错误！", e);
			throw new BaseException("查看部门信息表初始树列表错误！", e);
		}

		return null;
	}

   /*人员树*/
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
					script.append("tree.add( rti = new WebFXLoadTreeItem(\"" + name +"("+count+")"+ "\", \"viewDepartmentsTree_commonData.action?&departments.parentDeptId=" + id + "\"));\n");
					
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
		
		return "userTree" ;
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
				script.append("<tree text=\"" + name + "(" + count + ")" + "\" id=\"" + id + "\" action=\"\" ");
				// 判断是否有子节点
				if ( !"0".equals( departments.getIsHaveChild() ) ) {
					script.append(" src=\"viewUsersTree_commonData.action?users.depId=").append(id).append("\" ");
				}
				else {
					script.append("tree.add( new WebFXTreeItem(\"" + name +"("+count+")"+ "\",\"javascript:folderview('" + id + "')\"));\n");
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
	 * 查看专业信息表树列表
	 * 
	 * @return
	 * @throws BaseException
	 * @Action
	 */
	public void viewUsersTree() throws BaseException {

		try {
			Long id;
			String name = "";
			int count=0;

			List<Users> user = (List<Users>)this.iUsersBiz.getUsersList(users);
			StringBuffer script = new StringBuffer();
			script.append("<?xml version=\"1.0\"?>");
			script.append("<tree>");
			Iterator it = user.iterator();
			while (it.hasNext()) {
				Users ur = (Users) it.next();
				id = ur.getUserId();
				name = StringEscapeUtils
						.escapeXml(ur.getUserChinesename().toString().trim());				
				script.append("<tree text=\"" + name + "\" id=\"" + id	+ "\" action=\"javascript:folderview('" + id +":"+name+"')\" ");
				
				//System.out.println(count);
				// 判断是否有子节点
//				 if ( count>0 ) {
//				script.append(
//						" src=\"viewStagesTree_risks.action?stages.belongSubjid=")
//						.append(id).append("\" ");
//				 }

				script.append("/>");

			}

			script.append("</tree>");

			getResponse().getWriter().println(script.toString());

		} catch (Exception e) {
			log("查看部门信息表初始树列表错误！", e);
			throw new BaseException("查看部门信息表初始树列表错误！", e);
		}

		
	}

	
	 /*人员单个树*/
	/**
	 * 查看部门信息首页列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */

	/**
	 * 查看部门信息表初始树列表 getTree
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewDepartmentsInitTrees() throws BaseException {
		
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
					script.append("tree.add( rti = new WebFXLoadTreeItem(\"" + name +"("+count+")"+ "\", \"viewDepartmentsTrees_commonData.action?&departments.parentDeptId=" + id + "\"));\n");
					
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
		
		return "usersTree" ;
	}
	
	/**
	 * 查看部门信息表树列表 
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public void viewDepartmentsTrees() throws BaseException {
		
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
				script.append("<tree text=\"" + name + "(" + count + ")" + "\" id=\"" + id + "\" action=\"\" ");
				// 判断是否有子节点
				if ( !"0".equals( departments.getIsHaveChild() ) ) {
					script.append(" src=\"viewUsersTrees_commonData.action?users.depId=").append(id).append("\" ");
				}
				else {
					script.append("tree.add( new WebFXTreeItem(\"" + name +"("+count+")"+ "\",\"javascript:folderview('" + id + "')\"));\n");
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
	 * 查看人员信息表树列表
	 * 
	 * @return
	 * @throws BaseException
	 * @Action
	 */
	public void viewUsersTrees() throws BaseException {

		try {
			Long id;
			String name = "";
			int count=0;

			List<Users> user = (List<Users>)this.iUsersBiz.getUsersList(users);
			StringBuffer script = new StringBuffer();
			script.append("<?xml version=\"1.0\"?>");
			script.append("<tree>");
			Iterator it = user.iterator();
			while (it.hasNext()) {
				Users ur = (Users) it.next();
				id = ur.getUserId();
				name = StringEscapeUtils.escapeXml(ur.getUserChinesename().trim());	
				//System.out.println(name);
				script.append("<tree text=\"" + name + "\" id=\"" + id	+ "\" action=\"javascript:folderview('" + id +":"+name+"')\" ");
				
				//System.out.println(count);
				// 判断是否有子节点
//				 if ( count>0 ) {
//				script.append(
//						" src=\"viewStagesTree_risks.action?stages.belongSubjid=")
//						.append(id).append("\" ");
//				 }

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
	 * 资质信息人员树
	 * 查看资质信息表初始树列表 
	 * 谢磊修改
	 * @return
	 * @throws BaseException
	 * @Action
	 */
	public String viewCertificatesTree() throws BaseException {

		try {
			Long id;
			List certList = new ArrayList() ;
			String name = "";
			
			// 初始父ID为零
			if(StringUtil.isNotBlank(certificatesKind) && StringUtil.isNotBlank(certificatesKind.getCertKindParentId())){
				certList = this.certificatesKindBiz.getCertificatesKindList(certificatesKind);
				System.out.println(certList.size());
			}else{
				CertificatesKind certKind = new CertificatesKind();
				certKind.setCertKindParentId(new Long(0));
				certList = this.certificatesKindBiz.getCertificatesKindList(certKind);
				System.out.println(certList.size());
			
			}
				if(StringUtil.isNotBlank(certList)){
				
			
			
			StringBuffer script = new StringBuffer();
			script.append("var tree = new WebFXTree(\"人员资质类别树\");\n");
			Iterator it=	certList.iterator();
			
			while (it.hasNext()) {
				CertificatesKind	certKind=(CertificatesKind)it.next();
				id = certKind.getCertKindId();
				name = StringEscapeUtils.escapeXml(certKind.getCertKindName().trim());
				int count=this.iCertificatesBiz.getCertificatesCount(certificates);
				
				// 判断是否有子节点
				if ("0".equals( certKind.getIsHaveChild() )) {
					script.append("tree.add( rti = new WebFXLoadTreeItem(\"" + name + "\", \"viewCertificates_u_Tree_certificates.action?certificatesKind.certKindParentId=" + id + "\",\"\"));\n");
				} else {
					script.append("tree.add( new WebFXTreeItem(\"" + name +"("+count+")"+ "\",\"javascript:folderview('" + id +"')\"));\n");
				}
			}
			
			script.append("document.write(tree);\n");
			script.append("tree.expand();\n"); 

			tree = script.toString() ;
				}


		} catch (Exception e) {
			log("查看标准信息表初始树列表错误！", e);
			throw new BaseException("查看标准信息表初始树列表错误！", e);
		}

		return TREE;
	}
	
	/**
	 * 查看资质类别信息表树列表 
	 * @return
	 * @author ted 2012-10-22
	 * @throws BaseException 
	 * @Action
	 */
	public void viewCertificates_u_Tree() throws BaseException {
		
		try{
			Long id;
			String name = "";
			
			List certList = this.certificatesKindBiz.getCertificatesKindList(certificatesKind);

			StringBuffer script = new StringBuffer();
			script.append("<?xml version=\"1.0\"?>");
			script.append("<tree>");
			Iterator it=certList.iterator();
			while (it.hasNext()) {
				CertificatesKind certificatesKind = (CertificatesKind) it.next() ;
				id 		= certificatesKind.getCertKindId() ;
				name 	= StringEscapeUtils.escapeXml(certificatesKind.getCertKindName().trim());
				Certificates cs = new Certificates();
				cs.setCertName(id.toString());
				int count=this.iCertificatesBiz.getCertificatesCount(cs);
				
//				 判断是否有子节点
				if ( "0".equals( certificatesKind.getIsHaveChild() ) ) {
					script.append("<tree text=\"" + name + "\" id=\"" + id + "\" action=\"\" ");
					script.append(" src=\"viewCertificates_u_Tree_certificates.action?certificatesKind.certKindParentId=").append(id).append("\" ");
				}else{
					
					script.append("<tree text=\"" + name +"("+count+")"+ "\" id=\"" + id + "\" action=\"javascript:folderview('" + id+ "')\" ");
				}
				
				script.append("/>");
				
			}
			
			script.append("</tree>");
			
			getResponse().getWriter().println(script.toString());
			
		} catch (Exception e) {
			log("查看标准类别信息表初始树列表错误！", e);
			throw new BaseException("查看标准类别信息表初始树列表错误！", e);
		}
		
	}
	
	/**
	 * 资质信息显示内容
	 * 查看资质显示信息表初始树列表 
	 * 谢磊修改
	 * @return
	 * @throws BaseException
	 * @Action
	 */
	public String viewCertificatesIndex() {
		
		this.getRequest().setAttribute("ul", certificates.getDepName());
		return INDEX ;
	}
	
	 
	
	/**
	 * 资质信息显示内容
	 * 查看资质显示下面信息表初始树列表 
	 * 谢磊修改
	 * @return
	 * @throws Exception 
	 * @throws BaseException
	 * @Action
	 */
	public String viewCertificatesbutton() throws Exception, BaseException {
		
		if( certificates.getDepName()!=null &&!(certificates.getDepName().equals("-1"))){
			
			String [] mn = certificates.getDepName().split(",");
			String mc ="";
			for(int i=0;i<mn.length;i++){
				String m=BaseDataInfosUtil.convertUserIdToChnName(new Long(mn[i])).toString();
				mc+=mn[i]+":"+m+",";
			}
			this.getRequest().setAttribute("ul", mc.substring(0, mc.lastIndexOf(",")));
		}else{
		this.getRequest().setAttribute("ul", "-1");
		}
		return "certificatesButton" ;
	}
	
	//开始 start
	/**
	 * NEW TREE 专业树多选
	 * */
	   /*人员树*/
		/**
		 * 查看部门信息首页列表
		 * @return
		 * @throws BaseException 
		 * @Action
		 */
		public String viewDeptIndex() {
			
			this.getRequest().setAttribute("ul", users.getSelflevCode());
			this.getRequest().setAttribute("usersName", users.getUserName());
			return INDEX ;
		}
		/*
		 * top_frameset
		 * 框架上部
		 * 谢磊
		 * */
		public String viewTopIndex() throws Exception {
			if(StringUtil.isNotBlank(users)){
				
				this.setListValue(this.iUsersBiz.getUsersListRight(getRollPage(), users));
				
			}
			return "top" ;
		}
		/*
		 * button_frameset
		 * 框架下部
		 * 谢磊
		 * */
		
		public String viewButtonIndex() throws Exception {
			
			if( StringUtil.isNotBlank(users) &&!(users.getSelflevCode().equals("-1"))){
				
				String [] mn = users.getSelflevCode().split(",");
				String mc ="";
				for(int i=0;i<mn.length;i++){
					String m=BaseDataInfosUtil.convertUserIdToChnName(new Long(mn[i])).toString();
					mc+=mn[i]+":"+m+",";
				}
				this.getRequest().setAttribute("ul", mc.substring(0, mc.lastIndexOf(",")));
			}else{
			this.getRequest().setAttribute("ul", "-1");
			}
			System.out.println(users.getSelflevCode());
			return "button" ;
		}
		/**
		 * 查看部门信息表初始树列表 getTree
		 * @return
		 * @throws BaseException 
		 * @Action
		 */
		public String viewDeptInitTree() throws BaseException {
			
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
					int count = iUsersBiz.countDeptUsers(users);//用户总数（在职）
					// 判断是否有子节点
					if ("0".equals( departments.getIsHaveChild() )) {
						script.append("tree.add( rti = new WebFXLoadTreeItem(\"" + name +"("+count+")"+ "\", \"viewDeptTree_userTree.action?users.userName="+users.getUserName()+"&departments.parentDeptId=" + id + "\"));\n");
						
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
			
			return "tree" ;
		}
		
		/**
		 * 查看部门信息表树列表 
		 * @return
		 * @throws BaseException 
		 * @Action
		 */
		public String viewDeptTree() throws BaseException {
			
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
					Users ur = new  Users();
					ur.setDepId(id);
					ur.setUserName(users.getUserName());
					int count = iUsersBiz.countDeptUsers(ur);
					String s = id+","+users.getUserName();
					System.out.println(s);
					script.append("<tree text=\"" + name + "(" + count + ")" + "\" id=\"" + id + "\" action=\"javascript:folderview('" +s+ "')\" ");
					// 判断是否有子节点
//					if ( !"0".equals( departments.getIsHaveChild() ) ) {
//						script.append(" src=\"viewUsersTree_commonData.action?users.depId=").append(id).append("\" ");
//					}
//					else {
//						script.append("tree.add( new WebFXTreeItem(\"" + name +"("+count+")"+ "\",\"javascript:folderview('" + id + "')\"));\n");
//					}
					
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
		
	
//NEW TREE结束
/**
 * 资质树按人资要求NEW
 * */
		/**
		 * 查看资质类别信息首页列表
		 * @return
		 * @author ted 2012-10-22
		 * @throws BaseException 
		 * @Action
		 */
		public String viewCertificates_Index() {
			
			return "index" ;
		}
		
		/**
		 * 查看资质类别信息表初始树列表 getTree
		 * @return
		 * @author ted 2012-10-22
		 * @throws BaseException 
		 * @Action
		 */
		public String viewCertificatesInitTree() throws BaseException {
			
			try{
				Long id;
				List certList = new ArrayList() ;
				String name = "";
				
				// 初始父ID为零
				if(StringUtil.isNotBlank(certificatesKind) && StringUtil.isNotBlank(certificatesKind.getCertKindParentId())){
					certList = this.certificatesKindBiz.getCertificatesKindList(certificatesKind);
					System.out.println(certList.size());
				}else{
					CertificatesKind certKind = new CertificatesKind();
					certKind.setCertKindParentId(new Long(0));
					certList = this.certificatesKindBiz.getCertificatesKindList(certKind);
				
				}
					if(StringUtil.isNotBlank(certList)){
					
				
				
				StringBuffer script = new StringBuffer();
				script.append("var tree = new WebFXTree(\"人员资质类别树\");\n");
				Iterator it=	certList.iterator();
				
				while (it.hasNext()) {
					CertificatesKind	certKind=(CertificatesKind)it.next();
					id = certKind.getCertKindId();
					name = StringEscapeUtils.escapeXml(certKind.getCertKindName().trim());
					
					
					// 判断是否有子节点
					if ("0".equals( certKind.getIsHaveChild() )) {
						script.append("tree.add( rti = new WebFXLoadTreeItem(\"" + name + "\", \"viewCertificates_Tree_certificatesTree.action?certificatesKind.certKindParentId=" + id + "\",\"\"));\n");
					} else {
						script.append("tree.add( new WebFXTreeItem(\"" + name + "\",\"javascript:folderview('" + id +":"+name+ "')\"));\n");
					}
				}
				
				script.append("document.write(tree);\n");
				script.append("tree.expand();\n"); 

				tree = script.toString() ;
					}

			} catch (Exception e) {
				log("查看标准类别信息表初始树列表错误！", e);
				throw new BaseException("查看标准类别信息表初始树列表错误！", e);
			}
			
			return "tree" ;
		}
		
		/**
		 * 查看资质类别信息表树列表 
		 * @return
		 * @author ted 2012-10-22
		 * @throws BaseException 
		 * @Action
		 */
		public void viewCertificates_Tree() throws BaseException {
			
			try{
				Long id;
				String name = "";
				
				List certList = this.certificatesKindBiz.getCertificatesKindList(certificatesKind);

				StringBuffer script = new StringBuffer();
				script.append("<?xml version=\"1.0\"?>");
				script.append("<tree>");
				Iterator it=certList.iterator();
				while (it.hasNext()) {
					CertificatesKind certificatesKind = (CertificatesKind) it.next() ;
					id 		= certificatesKind.getCertKindId() ;
					name 	= StringEscapeUtils.escapeXml(certificatesKind.getCertKindName().trim());
					
					
//					 判断是否有子节点
					if ( "0".equals( certificatesKind.getIsHaveChild() ) ) {
						script.append("<tree text=\"" + name + "\" id=\"" + id + "\" action=\"\" ");
						script.append(" src=\"viewCertificates_Tree_certificatesTree.action?certificatesKind.certKindParentId=").append(id).append("\" ");
					}else{
						
						script.append("<tree text=\"" + name + "\" id=\"" + id + "\" action=\"javascript:folderview('" + id+":"+name + "')\" ");
					}
					
					script.append("/>");
					
				}
				
				script.append("</tree>");
				
				getResponse().getWriter().println(script.toString());
				
			} catch (Exception e) {
				log("查看标准类别信息表初始树列表错误！", e);
				throw new BaseException("查看标准类别信息表初始树列表错误！", e);
			}
			
		}

		public void message(String str) throws IOException{
			this.getResponse().setContentType("text/html; charset=UTF-8"); //转码
		    PrintWriter out = this.getResponse().getWriter();
		    out.flush();
		    out.println("<script>");
		    out.println("alert('"+str+"!');");
		    out.println("parent.location.reload();");
		    out.println("</script>");
		}


	public ISubjectsBIZ getISubjectsBIZ() {
		return ISubjectsBIZ;
	}

	public void setISubjectsBIZ(ISubjectsBIZ iSubjectsBIZ) {
		ISubjectsBIZ = iSubjectsBIZ;
	}

	public Subjects getSubjects() {
		return subjects;
	}

	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}

	public String getTree() {
		return tree;
	}

	public void setTree(String tree) {
		this.tree = tree;
	}

	public IDepartmentsBIZ getiDepartmentsBIZ() {
		return iDepartmentsBIZ;
	}

	public void setiDepartmentsBIZ(IDepartmentsBIZ iDepartmentsBIZ) {
		this.iDepartmentsBIZ = iDepartmentsBIZ;
	}

	public IUsersBiz getiUsersBiz() {
		return iUsersBiz;
	}

	public void setiUsersBiz(IUsersBiz iUsersBiz) {
		this.iUsersBiz = iUsersBiz;
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

	public ICertificatesBiz getiCertificatesBiz() {
		return iCertificatesBiz;
	}

	public void setiCertificatesBiz(ICertificatesBiz iCertificatesBiz) {
		this.iCertificatesBiz = iCertificatesBiz;
	}

	public Certificates getCertificates() {
		return certificates;
	}

	public void setCertificates(Certificates certificates) {
		this.certificates = certificates;
	}

	public ICertificatesKindBiz getCertificatesKindBiz() {
		return certificatesKindBiz;
	}

	public void setCertificatesKindBiz(ICertificatesKindBiz certificatesKindBiz) {
		this.certificatesKindBiz = certificatesKindBiz;
	}

	public CertificatesKind getCertificatesKind() {
		return certificatesKind;
	}

	public void setCertificatesKind(CertificatesKind certificatesKind) {
		this.certificatesKind = certificatesKind;
	}

	 

	
	
}
