package com.by.hctm.common.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.by.base.exception.BaseException;
import com.by.hctm.common.TableStatus;
import com.by.hctm.common.biz.ITSysUserInoutLogBiz;

public class SessionCount implements HttpSessionListener,HttpSessionAttributeListener {

	static int count = 0;//CountSessionFinal.count;     //在线人数
	static int logincount = 0;//CountSessionFinal.logincount;   //登陆人数
	protected static ITSysUserInoutLogBiz userInoutLogBiz ;

	/**
	* 当创建一个session时在线人数加一
	*/
	public void sessionCreated(HttpSessionEvent arg0) {
	   count++;
	}

	/**
	* 当销毁一个session时在线人数减一
	*/
	public void sessionDestroyed(HttpSessionEvent arg0) {
		count--;
		if (arg0 != null){
			try {
//				HttpSession session = arg0.getSession();
//				WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
//				userInoutLogBiz = (ITSysUserInoutLogBiz) context.getBean("userInoutLogBiz");
//				System.out.println(" in destroyed -> " + count ) ;
			   userInoutLogBiz.userLogoutLog(arg0.getSession().getId().toString());
			} catch (BaseException e) {
				e.printStackTrace();
			} //根据session地址删除一登录用户
	   }
	}

	/**
	* 当每生成一个UserBean时在线登陆人数加1
	*/
	public void attributeAdded(HttpSessionBindingEvent arg0) {
	   String name=arg0.getName();
	   if(name.equals( TableStatus.LOGIN_INFO_KEY )){
	    logincount++;
	   }
	}

	/**
	* 当每删除一个UserBean时在线登陆人数减1
	*/
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
	   String name=arg0.getName();
	   if(name.equals( TableStatus.LOGIN_INFO_KEY ) ) {   
		logincount--;
		//根据session地址更新用户在线状态为下线
		try {
//			System.out.println(" in Removed -> " + count ) ;
			userInoutLogBiz.userLogoutLog(arg0.getSession().getId().toString());
		} catch (BaseException e) {
			e.printStackTrace();
		}
	   }
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
	}

	/**
	* 
	* @return    在线登陆人数
	*/
	public static int getLoginCount(){
	   return logincount;
	}

	/**
	* @return    在线人数
	*/
	public static int getCount(){
	   return count;
	}

	public static ITSysUserInoutLogBiz getUserInoutLogBiz() {
		return userInoutLogBiz;
	}

	public static boolean  setUserInoutLogBiz(ITSysUserInoutLogBiz userInoutLogBiz) {
		SessionCount.userInoutLogBiz = userInoutLogBiz;
		return true; 
	}

}