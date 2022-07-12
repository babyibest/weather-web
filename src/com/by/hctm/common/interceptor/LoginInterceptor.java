package com.by.hctm.common.interceptor;

import org.apache.log4j.Logger;

import com.by.hctm.common.TableStatus;
import com.by.hctm.common.entity.SessionInfo;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
/**
 *  登录拦截器，判断用户是否登录
 * @author ted
 *
 */
public class LoginInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger
			.getLogger(LoginInterceptor.class);

	public void init() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			logger.debug("login Interceptor");
			SessionInfo loginInfo = (SessionInfo) invocation.getInvocationContext()
					.getSession().get( TableStatus.LOGIN_INFO_KEY );
			if (loginInfo == null) {
				return "timeout";
			}  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return invocation.invoke();
	}

	public void destroy() {

	}
}
