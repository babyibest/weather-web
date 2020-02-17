package com.by.hctm.common.interceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.ognl.OgnlValueStack;

public class ContextInterceptor extends AbstractInterceptor {
	
	private static final long serialVersionUID = -7226650966015164674L;
	protected void after(ActionInvocation dispatcher, String result)
			throws Exception {
	}
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result = null;
		before(invocation);
		result = invocation.invoke();
		after(invocation, result);
		return result;
	}

	protected void before(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String context = request.getContextPath();
		ServletContext servletContext = ServletActionContext
				.getServletContext();
		String realPath = servletContext.getRealPath("/");
		OgnlValueStack stack = (OgnlValueStack) invocation.getStack();
		stack.setValue("context", context);
		stack.setValue("realPath", realPath);
	}
}
