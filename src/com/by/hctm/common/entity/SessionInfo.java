package com.by.hctm.common.entity;

import java.util.List;

import com.by.hctm.manpower.entity.Users;
import com.by.hctm.system.entity.Departments;

/**
 * @Date 2008-7-3
 * @Author ted
 * @Description：用户登录后的信息
 */
public class SessionInfo {
	/** 登陆用户信息*/
	private Users users;
	
	/** 登陆用户信息*/
	private Departments dept;
	
	/** 角色信息*/
	private List roleList;
	
	/** 用户所拥有的模块URl的list*/
	private List<String> moduleURLList;
	
	/** 所有模块的URL */
	private List<String> allModuleURLList;

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<String> getModuleURLList() {
		return moduleURLList;
	}

	public void setModuleURLList(List<String> moduleURLList) {
		this.moduleURLList = moduleURLList;
	}

	public List getRoleList() {
		return roleList;
	}

	public void setRoleList(List roleList) {
		this.roleList = roleList;
	}

	public List<String> getAllModuleURLList() {
		return allModuleURLList;
	}

	public void setAllModuleURLList(List<String> allModuleURLList) {
		this.allModuleURLList = allModuleURLList;
	}

	public Departments getDept() {
		return dept;
	}

	public void setDept(Departments dept) {
		this.dept = dept;
	}

}
