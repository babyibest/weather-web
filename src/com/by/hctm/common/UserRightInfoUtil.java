package com.by.hctm.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.by.hctm.common.entity.SessionInfo;

public class UserRightInfoUtil {
	
	/**
	 * 取用户信息 -> session 
	 * @param request
	 * @return
	 */
	public static SessionInfo getSessionInfo( HttpServletRequest request ) {
		SessionInfo info = null ;
		
		if( request.getSession().getAttribute(TableStatus.LOGIN_INFO_KEY) != null ) {
			info = (SessionInfo) request.getSession().getAttribute(TableStatus.LOGIN_INFO_KEY) ; 
		}
		
		return info ;
	}

	/**
	 * 保存用户信息->session 
	 * @param sessionInfo
	 * @param request
	 */
	public static void setSessionInfo(SessionInfo sessionInfo, HttpServletRequest request ) {

		HttpSession session = request.getSession();
		
		session.setAttribute(TableStatus.LOGIN_INFO_KEY, sessionInfo);
	}
	
	/**
	 * 获取用户名称 -- 登录名( 英文名 )
	 * @param request
	 * @return
	 */
	public static String getUserName(HttpServletRequest request) {
		//登录人的姓名
		return  timeoutUser( request ) ? "" : getSessionInfo(request).getUsers().getUserName() ;
	}
	
	/**
	 * 取得登录用户的中文名称
	 * @param request
	 * @return
	 */
	public static String getChineseName( HttpServletRequest request ){
		return timeoutUser( request ) ? "" : getSessionInfo(request).getUsers().getUserChinesename() ;
	}
	
	/**
	 * 取得上级领导的名称
	 * @param request
	 * @return
	 */
	public static String getLeaderLoginName( HttpServletRequest request ){
		return timeoutUser( request ) ? "" : getSessionInfo(request).getUsers().getUpManager() ;
	}
	
	/**
	 * 获取当前登录用户的部门名称
	 * @param request
	 * @return
	 */
	public static String getUserDeptName( HttpServletRequest request ){
		return timeoutUser( request ) ? "" : getSessionInfo(request).getDept().getDeptName() ;
	}
	
	/**
	 * 获取当前登录用户的部门ID
	 * @param request
	 * @return
	 */
	public static Long getUserDeptId( HttpServletRequest request ){
		return timeoutUser( request ) ? new Long(0) : getSessionInfo(request).getUsers().getDepId() ;
	}
	
	/**
	 * 判断用户一级菜单权限
	 * @param rights 权限代码 
	 * @author ted 2009-12-18 
	 * @return
	 */
	public static boolean ifUserHaveMenuRight(  String  menuCode, HttpServletRequest request ){
		boolean rValue = false ;
		
		SessionInfo info = getSessionInfo(request) ;
		
//		if(  info != null ) {
//			
//			//判断是否是系统管理员
//			if( ifSystemManagerRole( info ) ){
//				rValue 	= true ;
//				
//			}else if( menuCode != null ) { 
//					
//				if( info.getMenuCode().contains( menuCode ) ) {
//					rValue = true ;
//					
//				}
//			}
//		}
		return rValue ;
	}
	
	/**
	 * 判断用户权限
	 * @param rights 权限数组集 
	 * @author ted 2009-12-18 
	 * @return
	 */
	public static boolean ifUserHaveRight(  String [] rights, HttpServletRequest request ){
		boolean rValue = false ;
		SessionInfo info = getSessionInfo(request) ;
		
		if(  info != null ) {
			//判断是否是系统管理员
//			if( ifSystemManagerRole( info ) ){
//				rValue 	= true ;
//				
//			}else if( rights != null ) { 
//				for( int i=0; i<rights.length; i++ ) {
//					
//					if( info.getRightCode().contains( rights[i] ) ) {
//						rValue = true ;
//						
//						break ;
//					}
//				}
//			}
		}
		return rValue ;
	}
	
	/**
	 * 判断用户权限
	 * @param rights 权限代码 
	 * @author ted 2009-12-18 
	 * @return
	 */
	public static boolean ifUserHaveRight(  String  rights, HttpServletRequest request ){
		boolean rValue = false ;
		
		SessionInfo info = getSessionInfo(request) ;
		
		if(  info != null ) {
			
			//判断是否是系统管理员
//			if( ifSystemManagerRole( info ) ){
//				rValue 	= true ;
//				
//			}else if( rights != null ) { 
//					
//				if( info.getRightCode().contains( rights ) ) {
//					rValue = true ;
//					
//				}
//			}
		}
		return rValue ;
	}
	
	/**
	 * 判断是否系统管理员
	 * @param request
	 * @return
	 */
	public static boolean ifSystemManagerRole( HttpServletRequest request ) {
		boolean rValue = false ;
		
		SessionInfo info = getSessionInfo(request) ;
		
//		if( info.getRoleCode().contains( TableStatus.DEFAULT_SYSTEM_ROLE_CODE ) ){
//			rValue 	= true ;
//		}
		
		return rValue ;
	}
	
	/**
	 * 判断是否系统管理员 
	 * @param info 
	 * @return
	 */
	public static boolean ifSystemManagerRole( SessionInfo info ) {
		boolean rValue = false ;
		
//		if( info != null && info.getRoleCode().contains( TableStatus.DEFAULT_SYSTEM_ROLE_CODE ) ){
//			rValue 	= true ;
//		}
		
		return rValue ;
	}
			
	/**
	 * 校验用户SESSION超时
	 * @param request
	 * @return
	 */
	public static boolean timeoutUser( HttpServletRequest request ) {
		boolean rValue = false ;
		
		if( ! ( getSessionInfo( request ) != null ) ) {
			rValue = true ;
		}
		
		return rValue ;
	}
	
	/**
	 * 判断是否存在指定的用户角色代码 
	 * @param request
	 * @param roleCode 角色代码
	 * @return
	 */
	public static boolean ifExitRoleCode( HttpServletRequest request, String roleCode ) {
		boolean rValue = false ;
		
		SessionInfo info = getSessionInfo(request) ;
		
//		if( info.getRoleCode().contains( roleCode ) ){
//			rValue 	= true ;
//		}
		
		return rValue ;
	}
	
}
