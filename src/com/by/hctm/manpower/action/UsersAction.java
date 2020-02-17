package com.by.hctm.manpower.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.BaseDataInfosUtil;
import com.by.hctm.common.DictStatus;
import com.by.hctm.common.TableStatus;
import com.by.hctm.common.UserRightInfoUtil;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.manpower.biz.ICertificatesBiz;
import com.by.hctm.manpower.biz.ICertificatesKindBiz;
import com.by.hctm.manpower.biz.IUsersBiz;
import com.by.hctm.manpower.entity.Certificates;
import com.by.hctm.manpower.entity.CertificatesKind;
import com.by.hctm.manpower.entity.Users;
import com.by.hctm.project.util.Common;
import com.by.hctm.system.biz.IDepartmentsBIZ;
import com.by.hctm.system.entity.Departments;

public class UsersAction extends BaseAction {
	
	//部门服务类
	private IDepartmentsBIZ iDepartmentsBIZ;
	//用户服务类
	private IUsersBiz iUsersBiz  ;
	//用户资质服务类
	private ICertificatesBiz iCertificatesBiz;
	//项目部人员服务类
	//private IProjectDepartMembersBiz iProjectDepartMembersBiz;
	//监理项目服务类
	//private IProjectsBiz iProjectsBiz;
	
	//用户实体类
	private Users users ;
	//资质实体类
	private Certificates certificates ;
	//部门实体类
	private Departments departments;
	//资质集合
	private List<Certificates> certificatesList;
	
	//树
	private String tree ;
	//状态集合
	private Map statusMap;
	//人员性质集合
	private Map propertyMap;
	//学历集合
	private Map degreeMap;
	private Map udep;
	//政治面貌集合
	private Map politicalMap;
	//部门集合
	private List<Departments> listDeq;
	//资质专业集合
	private Map certFieldMap;
	//资质中文名
	private String certName;
	//岗位集合
	private Map stationMap;
	//职称集合
	private Map rankMap;
	//人员项目部集合（综合查询）
	//private List<ProjectDepartMembers> pdmList;

    //删除集合
	private String deleteAll;

	// 人员资质树 服务类
	private ICertificatesKindBiz certificatesKindBiz  ;
	// 人员资质树 实例
	private CertificatesKind certificatesKind ;

	
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
					script.append("tree.add( rti = new WebFXLoadTreeItem(\"" + name +"("+count+")"+ "\", \"viewDepartmentsTree_users.action?&departments.parentDeptId=" + id + "\",\"javascript:folderview('" + id + "')\"));\n");
					
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
				int count = iUsersBiz.countDeptUsers(users);
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
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 * @Action
	 */
	public String viewUsers() throws BaseException {
		
		try{
				this.setListValue( this.iUsersBiz.getUsersList( this.getRollPage(), users, departments) ) ;
				departments = iDepartmentsBIZ.getDepartments(departments.getDepId());
			if(this.getListValue()!=null && this.getListValue().size()>0){
				for(int i=0;i<this.getListValue().size();i++){
					Users u = (Users)this.getListValue().get(i);
					//转换成中文
					if(StringUtil.isNotBlank(u.getStatus())){
						u.setStatusCn(BaseDataInfosUtil.convertDictCodeToName(u.getStatus(), DictStatus.COMMON_DICT_TYPE_1802));
					}
				}
			}
		} catch (Exception e) {
			log.error("查看用户信息列表错误！", e);
			throw new BaseException("查看用户信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 查看用户明细表
	 * @return
	 * @author zwp 2012-11-10
	 * @throws BaseException 
	 * @Action
	 */
	public String conditionViewUsersDetail() throws BaseException {
		
		try{
			users = iUsersBiz.getUsers(users.getUserId());
			//转换成中文
			users.setWriterCn(BaseDataInfosUtil.convertLoginNameToChnName(users.getWriter()));
			users.setStatusCn(BaseDataInfosUtil.convertDictCodeToName(users.getSysStatus(), DictStatus.COMMON_DICT_TYPE_1802));
			users.setPropertyCn(BaseDataInfosUtil.convertDictCodeToName(users.getProperty(), DictStatus.COMMON_DICT_TYPE_1801));
			users.setDegreeCn(BaseDataInfosUtil.convertDictCodeToName(users.getDegree(), DictStatus.COMMON_DICT_TYPE_1800));
			users.setDepName(BaseDataInfosUtil.convertDeptIdToName(users.getDepId()));
			users.setPoliticalCn(BaseDataInfosUtil.convertDictCodeToName(users.getPolitical(), DictStatus.COMMON_DICT_TYPE_1803));
			if(StringUtil.isNotBlank(users.getUpManager())){
				users.setUpManagerName(BaseDataInfosUtil.convertUserIdToChnName(new Long(users.getUpManager().trim())));
			}
			this.setListValue(iCertificatesBiz.getCertificatesListById(users.getUserId()));
			if(this.getListValue()!=null && this.getListValue().size()>0){
				for(int i=0;i<this.getListValue().size();i++){
					Certificates cert = (Certificates)this.getListValue().get(i);
					cert.setCertFieldCn(BaseDataInfosUtil.convertDictCodeToName(cert.getCertField(), DictStatus.COMMON_DICT_TYPE_1804));
					cert.setCertNameCn(certificatesKindBiz.getCertificatesKind(new Long(cert.getCertName())).getCertKindName());
				}
			}
//			pdmList = iProjectDepartMembersBiz.getProDepMemListByUserName(users.getUserId().toString());
//			if(pdmList!=null && pdmList.size()>0){
//				for(int i=0;i<pdmList.size();i++){
//					ProjectDepartMembers pdm = pdmList.get(i);
//					if(pdm.getProjectId()!=null){
//						pdm.setProjectName(iProjectsBiz.getProject(pdm.getProjectId()).getProjectName());
//					}
//				}
//			}
			
		} catch (Exception e) {
			log.error("查看用户信息列表错误！", e);
			throw new BaseException("查看用户信息列表错误！", e);
		}
		
		return "conditionDetail" ;
		
	}
	
	/**
	 * 查看用户明细表
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 * @Action
	 */
	public String viewUsersDetail() throws BaseException {
		
		try{
			users = iUsersBiz.getUsers(users.getUserId());
			//转换成中文
			users.setWriterCn(BaseDataInfosUtil.convertLoginNameToChnName(users.getWriter()));
			users.setStatusCn(BaseDataInfosUtil.convertDictCodeToName(users.getSysStatus(), DictStatus.COMMON_DICT_TYPE_1802));
			users.setPropertyCn(BaseDataInfosUtil.convertDictCodeToName(users.getProperty(), DictStatus.COMMON_DICT_TYPE_1801));
			users.setDegreeCn(BaseDataInfosUtil.convertDictCodeToName(users.getDegree(), DictStatus.COMMON_DICT_TYPE_1800));
			users.setDepName(BaseDataInfosUtil.convertDeptIdToName(users.getDepId()));
			users.setPoliticalCn(BaseDataInfosUtil.convertDictCodeToName(users.getPolitical(), DictStatus.COMMON_DICT_TYPE_1803));
			if(StringUtil.isNotBlank(users.getUpManager())){
				users.setUpManagerName(BaseDataInfosUtil.convertUserIdToChnName(new Long(users.getUpManager().trim())));
			}
			this.setListValue(iCertificatesBiz.getCertificatesListById(users.getUserId()));
			if(this.getListValue()!=null && this.getListValue().size()>0){
				for(int i=0;i<this.getListValue().size();i++){
					Certificates cert = (Certificates)this.getListValue().get(i);
					cert.setCertFieldCn(BaseDataInfosUtil.convertDictCodeToName(cert.getCertField(), DictStatus.COMMON_DICT_TYPE_1804));
					cert.setCertNameCn(certificatesKindBiz.getCertificatesKind(new Long(cert.getCertName())).getCertKindName());
				}
			}
		} catch (Exception e) {
			log.error("查看用户信息列表错误！", e);
			throw new BaseException("查看用户信息列表错误！", e);
		}
		
		return DETAIL ;
		
	}
	
	/**
	 * 保存用户信息初始化
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public String saveUsersInit() throws BaseException {
		try{
			degreeMap = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1800);
			statusMap = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1802);
			politicalMap = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1803);
			propertyMap = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1801);
			stationMap = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1805);//岗位
			rankMap = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1806);//职称
			
			departments.setDepId(departments.getDepId());
		} catch (Exception e) {
			log.error("保存用户信息初始化错误！", e);
			throw new BaseException("保存用户信息初始化错误！", e);
		}
		return ADD_INIT;
		
	}
	
	/**
	 * 保存用户信息
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public String saveUsers() throws BaseException {
		
		try{
			
			//保存人员信息
			String str = Common.getStringFromDate(new Date());
			Timestamp writeDate = Common.getTimestampFromString(str);
			users.setWriteDate(writeDate);
			users.setWriter(UserRightInfoUtil.getUserName(this.getRequest()));
			users.setIsUsable(TableStatus.COMMON_STATUS_VALID);
			users.setDepId(departments.getDepId());
			users.setSelflevCode(iDepartmentsBIZ.getDepartments(departments.getDepId()).getSelflevCode());
			
			// 用户帐号状态 默认为有效'0'
			users.setSysStatus( TableStatus.COMMON_STATUS_VALID ) ;
			
			this.iUsersBiz.saveUsers( users );
			
			//保存资质
			if(certificatesList!=null){  //判断是否有资质
				for(int i=0;i<certificatesList.size();i++){
					if(certificatesList.get(i)!=null){//判断是否为空(删除时会把序列打乱,使有的对象为空)
						List<Users> userlist = new ArrayList<Users>();
						userlist = iUsersBiz.getContractsList(writeDate);
						certificates = certificatesList.get(i);
						certificates.setUser(userlist.get(0));
						certificates.setIsUsable(TableStatus.COMMON_STATUS_VALID);
						this.iCertificatesBiz.saveCertificates(certificates);
					}
				}
			}
			users = null;//清除默认查询信息
			departments.setDepId(departments.getDepId());
			BaseDataInfosUtil.initBaseIndexInfos( TableStatus.BASE_DATA_TYPE_01 ) ;
		} catch (Exception e) {
			log.error("保存用户信息错误！", e);
			throw new BaseException("保存用户信息错误！", e);
		}
		
		return viewUsers();
		
	}
	
	/**
	 * 修改用户信息初始化
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public String updateUsersInit() throws BaseException {
		
		try{
		
			degreeMap = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1800);
			statusMap = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1802);
			propertyMap = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1801);
			politicalMap = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1803);
			certFieldMap = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1804);
			stationMap = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1805);//岗位
			rankMap = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1806);//职称
			users=this.iUsersBiz.getUsers( users.getUserId() );
			if(StringUtil.isNotBlank(users.getUpManager())){
				users.setUpManagerName(BaseDataInfosUtil.convertUserIdToChnName(new Long(users.getUpManager().trim())));
			}
			departments.setDepId(departments.getDepId());
			this.setListValue(iCertificatesBiz.getCertificatesListById(users.getUserId()));
			if(this.getListValue()!=null && this.getListValue().size()>0){
				for(int i=0;i<this.getListValue().size();i++){
					Certificates cert = (Certificates)this.getListValue().get(i);
					cert.setCertNameCn(certificatesKindBiz.getCertificatesKind(new Long(cert.getCertName())).getCertKindName());
				}
			}
		} catch (Exception e) {
			log.error("修改用户信息初始化错误！", e);
			throw new BaseException("修改用户信息初始化错误！", e);
		}
		return MODIFY_INIT;
		
	}
	
	/**
	 * 修改用户信息
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public String updateUsers() throws BaseException {
		
		try{
			users.setDepId(departments.getDepId());
			this.iUsersBiz.updateUsers(users);
			if(certificatesList!=null){
				for(int i=0;i<certificatesList.size();i++){
					if(certificatesList.get(i)!=null && certificatesList.get(i).getCertName()!=null){ 
						certificates = certificatesList.get(i);
						certificates.setUser(users);
						if(certificatesList.get(i).getCertId()!=null){//对已存在的资质进行修改
							iCertificatesBiz.updateCertificates(certificates);
						}else{//对不存在的资质进行保存
							certificates.setIsUsable(TableStatus.COMMON_STATUS_VALID);
							iCertificatesBiz.saveCertificates(certificates);
						}
					}
				}
			}
			//删除资质
			if(!"".equals(deleteAll)){
				String[] delCert = deleteAll.split(",");
				if(delCert!=null && delCert.length>0){
					for(int i=0;i<delCert.length;i++){
						iCertificatesBiz.deleteCertificates(delCert[i]);
					}
				}
			}
			users = null;
			BaseDataInfosUtil.initBaseIndexInfos( TableStatus.BASE_DATA_TYPE_01 ) ;
		} catch (Exception e) {
			log.error("修改用户信息错误！", e);
			throw new BaseException("修改用户信息错误！", e);
		}
		return viewUsers();
		
	}
	
	/**
	 * 删除用户信息
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public String deleteUsers() throws BaseException {
		try{
			this.iUsersBiz.deleteUsers( users  );
		} catch (Exception e) {
			log.error("删除用户信息错误！", e);
			throw new BaseException("删除用户信息错误！", e);
		}
		return DELETE;
		
	}
	
	/**
	 * 删除用户信息
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public String deleteUserById() throws BaseException {
		try{
			Long userId = users.getUserId();
			this.iUsersBiz.deleteUsers(userId.toString()); 
			List<Certificates> list = iCertificatesBiz.getCertificatesListById(userId);
			this.iCertificatesBiz.deleteCertificates(list);
			users = null;//清除默认查询信息
			departments.setDepId(departments.getDepId());
		} catch (Exception e) {
			log.error("删除用户信息错误！", e);
			throw new BaseException("删除用户信息错误！", e);
		}
		return viewUsers();
		
	}
	
	/**
	 * 伪删除用户信息
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public String delUser() throws BaseException {
		try{
			//更改用户状态为1 ：无效
			users = iUsersBiz.getUsers(users.getUserId());
			users.setIsUsable(TableStatus.COMMON_STATUS_INVALID);
			Iterator<Certificates> c = users.getCertificates().iterator();
			while(c.hasNext()){
				Certificates cf = c.next();
				cf.setIsUsable(TableStatus.COMMON_STATUS_INVALID );
			}
			iUsersBiz.updateUsers(users);
			users = null;//清除默认查询信息
			departments.setDepId(departments.getDepId());
			
				BaseDataInfosUtil.initBaseIndexInfos( TableStatus.BASE_DATA_TYPE_01 ) ;
		} catch (Exception e) {
			log.error("删除用户信息错误！", e);
			throw new BaseException("删除用户信息错误！", e);
		}
		return viewUsers();
		
	}

	/**
	 * 提交用户信息
	 * @return
	 * @throws BaseException 
	 */
	public String submitUsers() throws BaseException {
		
		try{
//			this.iUsersBiz.submitSubjects( subjects  );
		} catch (Exception e) {
			log.error("提交用户信息错误！", e);
			throw new BaseException("提交用户信息错误！", e);
		}
		return SUBMIT;
		
	}
	
	/**
	 * 删除伪用户资质信息
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException
	 */
	public String delCertificates() throws BaseException {
		try {
			certificates = iCertificatesBiz.getCertificates(certificates.getCertId());
			certificates.setIsUsable(TableStatus.COMMON_STATUS_INVALID);
			iCertificatesBiz.updateCertificates(certificates);
			departments.setDepId(departments.getDepId());
		} catch (Exception e) {
			log.error("删除用户资质信息错误",e);
			throw new BaseException("删除用户资质信息错误",e);
		}
		return updateUsersInit();
	}
	/**
	 * 删除用户资质信息
	 * @return
	 * @throws BaseException
	 */
	public String deleteCertificates() throws BaseException {
		try {
			iCertificatesBiz.deleteCertificates(certificates.getCertId().toString());
		} catch (Exception e) {
			log.error("删除用户资质信息错误",e);
			throw new BaseException("删除用户资质信息错误",e);
		}
		return updateUsersInit();
	}
	
	/**
	 * 综合查询用户
	 * @return
	 * @throws BaseException
	 */
	public String queryViewUsers() throws BaseException{
		try{
			listDeq = iDepartmentsBIZ.getDepartmentsList(departments);
			this.setListValue(iUsersBiz.getUsersList(this.getRollPage()));
			degreeMap = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1800);
			politicalMap = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1803);
			certFieldMap = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1804);
		}catch(Exception e){
			log.error("查看用户信息错误",e);
			throw new BaseException("查看用户信息错误",e);
		}
		return "queryView";
	}
	
	/**
	 * 综合中的模糊查询
	 * @return
	 * @throws BaseException
	 */
	public String conditionViewUsers() throws BaseException{
		try{
			listDeq = iDepartmentsBIZ.getDepartmentsList(this.getRollPage());
			degreeMap = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1800);
			politicalMap = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1803);
			certFieldMap = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1804);
			this.setListValue(iUsersBiz.getCertUsersList(this.getRollPage(), users ,certificates));	
		}catch(Exception e){
			log.error("条件查看用户信息错误",e);
			throw new BaseException("条件查看用户信息错误",e);
		}
		return "condition";
	}
	
	/**
	 * 查看资质类别信息首页列表
	 * @return
	 * @author ted 2012-10-22
	 * @throws BaseException 
	 * @Action
	 */
	public String viewCertificatesIndex() {
		
		return "index2" ;
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
				Certificates cs = new Certificates();
				cs.setCertName(id.toString());
				int count = this.iUsersBiz.getUsersCertList(cs).size();
				
				// 判断是否有子节点
				if ("0".equals( certKind.getIsHaveChild() )) {
					script.append("tree.add( rti = new WebFXLoadTreeItem(\"" + name + "\", \"viewCertificatesTree_users.action?certificatesKind.certKindParentId=" + id + "\",\"\"));\n");
				} else {
					script.append("tree.add( new WebFXTreeItem(\"" + name + "("+count+")"+"\",\"javascript:folderview('" + id + "')\"));\n");
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
		
		return "tree2" ;
	}
	
	/**
	 * 查看资质类别信息表树列表 
	 * @return
	 * @author ted 2012-10-22
	 * @throws BaseException 
	 * @Action
	 */
	public void viewCertificatesTree() throws BaseException {
		
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
				int count = this.iUsersBiz.getUsersCertList(cs).size();
				
//				 判断是否有子节点
				if ( "0".equals( certificatesKind.getIsHaveChild() ) ) {
					script.append("<tree text=\"" + name + "\" id=\"" + id + "\" action=\"\" ");
					script.append(" src=\"viewCertificatesTree_users.action?certificatesKind.certKindParentId=").append(id).append("\" ");
				}else{
					
					script.append("<tree text=\"" + name +"("+count+")"+ "\" id=\"" + id + "\" action=\"javascript:folderview('" + id + "')\" ");
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
	 * 查看资质类别用户信息列表
	 * @return
	 * @author ted 2012-10-22
	 * @throws BaseException 
	 * @Action
	 */
	public String viewCertificatesUsers() throws BaseException {
		
		try{
			certName = certificatesKindBiz.getCertificatesKind(new Long(certificates.getCertField())).getCertKindName();
			this.setListValue( this.iUsersBiz.getUsersList(this.getRollPage(), users, certificates) ) ;
			if(this.getListValue()!=null && this.getListValue().size()>0){
				for(int i=0;i<this.getListValue().size();i++){
					Users u = (Users)this.getListValue().get(i);
					//转换成中文
					if(StringUtil.isNotBlank(u.getStatus())){
						u.setStatusCn(BaseDataInfosUtil.convertDictCodeToName(u.getStatus(), DictStatus.COMMON_DICT_TYPE_1802));
					}
					 u.setDepName(BaseDataInfosUtil.convertDeptIdToName(u.getDepId()));
				}
			}
		} catch (Exception e) {
			log.error("查看资质类别用户信息列表错误！", e);
			throw new BaseException("查看资质类别用户信息列表错误！", e);
		}
		
		return "view2" ;
	}
	
	/**
	 * 传递资质集合
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 * @Action
	 */
	public String validateCer() throws BaseException {
		
		try{
			certFieldMap = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1804);
			Iterator cf = certFieldMap.entrySet().iterator();
			String certjson = "";
			//遍历资质的key和value
			while(cf.hasNext()){
				Map.Entry me = (Map.Entry)cf.next();
				certjson+=me.getKey()+":"+me.getValue()+",";
			}
			//ajax传递
			this.getResponse().getWriter().write(certjson.substring(0, certjson.length()-1));
		} catch (Exception e) {
			log.error("传递资质集合错误！", e);
			throw new BaseException("传递资质集合错误！", e);
		}
		
		return null ;
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

	public ICertificatesBiz getICertificatesBiz() {
		return iCertificatesBiz;
	}

	public void setICertificatesBiz(ICertificatesBiz certificatesBiz) {
		iCertificatesBiz = certificatesBiz;
	}

	public List<Certificates> getCertificatesList() {
		return certificatesList;
	}

	public void setCertificatesList(List<Certificates> certificatesList) {
		this.certificatesList = certificatesList;
	}

	public Certificates getCertificates() {
		return certificates;
	}

	public void setCertificates(Certificates certificates) {
		this.certificates = certificates;
	}

	public Map getStatusMap() {
		return statusMap;
	}

	public void setStatusMap(Map statusMap) {
		this.statusMap = statusMap;
	}

	public Map getPropertyMap() {
		return propertyMap;
	}

	public void setPropertyMap(Map propertyMap) {
		this.propertyMap = propertyMap;
	}

	public Map getDegreeMap() {
		return degreeMap;
	}

	public void setDegreeMap(Map degreeMap) {
		this.degreeMap = degreeMap;
	}

	public Map getUdep() {
		return udep;
	}

	public void setUdep(Map udep) {
		this.udep = udep;
	}

	public List<Departments> getListDeq() {
		return listDeq;
	}

	public void setListDeq(List<Departments> listDeq) {
		this.listDeq = listDeq;
	}

	public Map getPoliticalMap() {
		return politicalMap;
	}

	public void setPoliticalMap(Map politicalMap) {
		this.politicalMap = politicalMap;
	}

	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}

	public Map getCertFieldMap() {
		return certFieldMap;
	}

	public void setCertFieldMap(Map certFieldMap) {
		this.certFieldMap = certFieldMap;
	}


	public String getDeleteAll() {
		return deleteAll;
	}

	public void setDeleteAll(String deleteAll) {
		this.deleteAll = deleteAll;
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

	public ICertificatesBiz getiCertificatesBiz() {
		return iCertificatesBiz;
	}

	public void setiCertificatesBiz(ICertificatesBiz iCertificatesBiz) {
		this.iCertificatesBiz = iCertificatesBiz;
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

	public Map getStationMap() {
		return stationMap;
	}

	public void setStationMap(Map stationMap) {
		this.stationMap = stationMap;
	}

	public Map getRankMap() {
		return rankMap;
	}

	public void setRankMap(Map rankMap) {
		this.rankMap = rankMap;
	}

	 
	


	
	
	
}
