package com.by.hctm.common.utils;

import java.util.Date;

import javax.servlet.ServletContext;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.web.context.ServletContextAware;

public class QuartzJob implements ServletContextAware{
	
//	private QuartzManager quartzManager;
//	
//	public void setQuartzManager(QuartzManager quartzManager) {
//		this.quartzManager = quartzManager;
//	}
	
	private String localPath; 
	public void setServletContext(ServletContext servletContext) {
		// 得到系统路径
		localPath = servletContext.getRealPath("\\").replaceAll("\\\\", "/");
	}

	/**
	 * @date Jul 10, 2008
	 * @author yb
	 * @方法描述: 定时验证开标,截标
	 * @参数描述: 
	 */
	public void workOpenBid() {
//		quartzManager.setActuallyStartTime();
//		List endOmbList=quartzManager.setActuallyEndTime();
//		quartzManager.doEndLogic(endOmbList);
		System.out.println( " in job !" + new Date() ) ;
	}
	
	public void hello(){  
		System.out.println("hello!!!");  
	} 
	
	public static void main(String[] args) {

        String userName = "1' or '1'='1";

        String password = "123456";

        userName = StringEscapeUtils.escapeSql(userName);

        password = StringEscapeUtils.escapeSql(password);

        String sql = "SELECT COUNT(userId) FROM t_user WHERE userName='"

            + userName + "' AND password ='" + password + "'";

        System.out.println(sql);

    }

}
