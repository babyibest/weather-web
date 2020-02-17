package com.by.hctm.common.action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.TableStatus;
import com.by.hctm.common.UserRightInfoUtil;
import com.by.hctm.common.biz.ITSysUserInoutLogBiz;
import com.by.hctm.common.entity.SessionInfo;
import com.by.hctm.common.utils.MD5;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.manpower.biz.IUsersBiz;
import com.by.hctm.manpower.entity.Users;
import com.by.hctm.system.biz.IDepartmentsBIZ;
import com.by.hctm.system.entity.TSysUserInoutLog;

public class ValidateUserAction extends BaseAction {
	/**
	 * 变量的说明： 
	 * 变量名称：serialVersionUID
	 * 变量类型：long
	 */
	
	private static final long serialVersionUID = 1L;
	private IUsersBiz iUsersBiz  ;
	private IDepartmentsBIZ iDepartmentsBIZ;
	private ITSysUserInoutLogBiz userInoutLogBiz ;
	
	private Users ur ;
	private String ifRem ; //是否记住账号
	private String ifPwd ; //是否记住密码
 	private String errorMsg ;
	
	/**
	 * 用户登陆校验
	 * @return
	 * @throws ServletException
	 */
	public String verifyLogin( ) throws BaseException {
		String rUrlPage 		= "invalidlogin" ;
		
		try {
			if( ! UserRightInfoUtil.timeoutUser( this.getRequest() ) ) {
				rUrlPage = INDEX ; 
				
			}else {
				if( ur != null ) {
					ur.setUserName( ur.getJ_username() ) ;
					ur.setUserPassword( MD5.toMD5String( ur.getJ_password().trim() ) ) ;
					List<?> userList 			= iUsersBiz.getUsersList( ur ) ;
					
					
					if( userList != null && userList.size()>0 ) { // 通过用户校验, 保存用户信息到session并返回主页面
						Users user = (Users) userList.get( 0 ) ;
						
						if( TableStatus.COMMON_STATUS_VALID.equals( user.getIsUsable() ) ){//判断用户是否有效	
							SessionInfo info = new SessionInfo() ;
							
							info.setUsers( user );
							
							info.setDept( iDepartmentsBIZ.getDepartments( user.getDepId() ) ) ;
							
	//						//添加用户角色编号
	//						info.setRoleCode(rolemananger.getEmpRoleInfo(user.getId()));
	//						
	//						//添加用户权限编号
	//						info.setRightCode(rolemananger.getEmpRigetInfos(user.getId()));
	//						
	//						// 取得当前用户所拥有的一级菜单权限code
	//						//添加用户权限组
	//						info.setMenuCode(rolemananger.getEmpRigetGroup(user.getId()));
	//						
	//						// 添加用户仓库信息 Ted 2012-06-07
	//						info.setWhCode( rolemananger.getEmployeeWarehouse( user.getId() ) ) ;
							
							UserRightInfoUtil.setSessionInfo(info, this.getRequest() ) ;
							//原来的首页
//							rUrlPage = INDEX ;
							//替换后的首页
							rUrlPage = "main";
							
							// 设置用户COOKIE信息
							this.setUserCookieInfo( ) ;
							
							// 保存登录日志信息
							userInoutLogBiz.saveTSysUserInoutLog( new TSysUserInoutLog( info.getUsers().getUserName(), info.getUsers().getUserChinesename(),
									this.getRequest().getRemoteAddr(), new Date(), this.getSession().getId().toString(), TableStatus.COMMON_STATUS_VALID ) );
							
						}else {
							rUrlPage = "invalidlogin" ;
						}	
					}else{ // 校验失败, 返回登陆页面, 提示错误信息
						errorMsg = "incorrectPassword"; // 姓名或密码输入错误！
						rUrlPage = "errorlogin" ;
					}
				}
			}
			
		} catch (Exception e) {
			log.error("用户登陆校验错误！", e);
			throw new BaseException("用户登陆校验错误！", e);
		}
		return rUrlPage  ;
	}
	
	/**
	 * 跳转到修改用户密码页面
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	public String updatePwdInit( ) throws BaseException {
		if( UserRightInfoUtil.timeoutUser( this.getRequest() ) ) {
			return "timout" ; 
		}
		
		try {
			ur = ( (SessionInfo)this.getSession().getAttribute( TableStatus.LOGIN_INFO_KEY )).getUsers();
		} catch (Exception e) {
			log.error("修改用户密码错误！", e);
			throw new BaseException("修改用户密码错误！", e);
		}
		
		return  MODIFY_INIT   ;
	}
	
	/**
	 * 修改用户密码
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	public String updatePwd( ) throws BaseException {
		
		if( UserRightInfoUtil.timeoutUser( this.getRequest() ) ) {
			return "timout" ; 
		}
		
		String rUrlPage = "/index.jsp" ; 
		try {
			Users users = iUsersBiz.getUsers( ur.getUserId() );
			users.setUserPassword( MD5.toMD5String( ur.getUserPassword() ) );
			iUsersBiz.updateUsers( users ) ;
			 
			this.getResponse().setContentType(CONTENT_TYPE);
			PrintWriter out = this.getResponse().getWriter();
			out.print("<script language=\"javaScript\">");
			out.print("alert(\"修改成功\");");
			out.print("parent.close();");
			out.print("</script>");
			out.flush();
			out.close();
		} catch (Exception e) {
			log.error("修改用户密码错误！", e);
			throw new BaseException("修改用户密码错误！", e);

		}
		
		return rUrlPage  ;
	}
	
	/**
	 * 用户退出
	 * @return
	 * @throws ServletException
	 */
	public String exit( ) throws BaseException {
		try {
			HttpSession session = this.getSession() ;
			
//			userInoutLogBiz.userLogoutLog(session.getId().toString());
			
			for (Enumeration<String> e = session.getAttributeNames() ; e.hasMoreElements() ;) {
				session.removeAttribute((String)e.nextElement());
		    }
			
		} catch (Exception e) {
			log.error("用户退出错误！", e);
			throw new BaseException("用户退出错误！", e);

		}
		return "exit"  ;
	}
	
	public String timeout(){
		return "timeout" ;
	}
	
	/**
	 * 保存用户COOKIE信息 
	 */
	private void setUserCookieInfo ( ) {
		
		if( ! StringUtil.isBlank( ifRem ) ) {
			Cookie ckrem 	= new Cookie("jsrem", ifRem ) ;
			ckrem.setMaxAge(604800) ;
			
			this.getResponse().addCookie( ckrem ) ;
		}
		if( ! StringUtil.isBlank( ifPwd ) ) {
			Cookie pwd 	= new Cookie("pwd", ifPwd ) ;
			pwd.setMaxAge(604800) ;
			
			this.getResponse().addCookie( pwd ) ;
		}
		if( ! StringUtil.isBlank( ur.getJ_username() ) ) {
			Cookie ckuser 	= new Cookie("jsuser", ur.getJ_username() ) ;		
			if("0".equals( ifRem ) ) {
				ckuser.setMaxAge(604800) ;
			}else{
				ckuser 		= new Cookie("jsuser", "" ) ;
				ckuser.setMaxAge(1) ;
			}
			this.getResponse().addCookie( ckuser ) ;
		}

		if( ! StringUtil.isBlank( ur.getJ_password() ) ) {
			Cookie ckpwd 	= new Cookie("jspwd", ur.getJ_password() ) ;
			
			if("0".equals( ifPwd ) ) {
				ckpwd.setMaxAge(604800) ;
			}else{
				ckpwd 		= new Cookie("jspwd", "" ) ;
				ckpwd.setMaxAge(1) ;
			}
			
			this.getResponse().addCookie( ckpwd ) ;
		}
	}

	public IUsersBiz getIUsersBiz() {
		return iUsersBiz;
	}

	public void setIUsersBiz(IUsersBiz usersBiz) {
		iUsersBiz = usersBiz;
	}

	public IDepartmentsBIZ getIDepartmentsBIZ() {
		return iDepartmentsBIZ;
	}

	public void setIDepartmentsBIZ(IDepartmentsBIZ departmentsBIZ) {
		iDepartmentsBIZ = departmentsBIZ;
	}

	public ITSysUserInoutLogBiz getUserInoutLogBiz() {
		return userInoutLogBiz;
	}

	public void setUserInoutLogBiz(ITSysUserInoutLogBiz userInoutLogBiz) {
		this.userInoutLogBiz = userInoutLogBiz;
	}

	public Users getUr() {
		return ur;
	}
	
	public void setUr(Users ur) {
		this.ur = ur;
	}

	public String getIfRem() {
		return ifRem;
	}

	public void setIfRem(String ifRem) {
		this.ifRem = ifRem;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getIfPwd() {
		return ifPwd;
	}

	public void setIfPwd(String ifPwd) {
		this.ifPwd = ifPwd;
	}
	
}
