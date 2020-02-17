package com.by.hctm.system.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.system.biz.IUserRightsBIZ;
import com.by.hctm.system.entity.UserRights;

public class UserRightsAction extends BaseAction {
	private IUserRightsBIZ  iUserRightsBIZ;
	private UserRights userRights;
	
	public String  findUserRights () throws BaseException{
		HttpServletRequest request =ServletActionContext.getRequest();
		List<UserRights> ur= this.iUserRightsBIZ.getUserRightsList( this.getRollPage(), userRights);
		System.out.println(ur.size());
		request.setAttribute("UserRights", ur);
		return SUCCESS;
	}
	
	public UserRights getUserRights() {
		return userRights;
	}
	public void setUserRights(UserRights userRights) {
		this.userRights = userRights;
	}
	public IUserRightsBIZ getIUserRightsBIZ() {
		return iUserRightsBIZ;
	}
	public void setIUserRightsBIZ(IUserRightsBIZ userRightsBIZ) {
		iUserRightsBIZ = userRightsBIZ;
	}
	
}
