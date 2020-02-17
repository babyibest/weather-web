package com.by.base.common;

import java.util.HashMap;
import java.util.Map;

public class BeanValue {
	
	// 放在Session中的数据
	private Map sessionMap = new HashMap();

	// 放在Request中的数据
	private Map requestMap = new HashMap();

	// 错误信息(同样放在Request�?
	private Map errorMap = new HashMap();

	// forward名称
	private String forword;

	public String getForword() {
		return forword;
	}

	public void setForword(String forword) {
		this.forword = forword;
	}

	public Map getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map errorList) {
		this.errorMap = errorList;
	}

	public Map getRequestMap() {
		return requestMap;
	}

	public void setRequestMap(Map requestList) {
		this.requestMap = requestList;
	}

	public Map getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map sessionList) {
		this.sessionMap = sessionList;
	}

	public Object getSessionMap(String key) {
		return sessionMap.get(key);
	}

	public Object getRequestMap(String key) {
		return requestMap.get(key);
	}

	public Object getErrorMap(String key) {
		return errorMap.get(key);
	}

	public void addSessionMap(String key, Object value) {
		sessionMap.put(key, value);
	}

	public void addRequestMap(String key, Object value) {
		requestMap.put(key, value);
	}

	public void addErrorMap(String key, Object value) {
		errorMap.put(key, value);
	}

}
