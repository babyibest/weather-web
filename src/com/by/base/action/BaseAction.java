package com.by.base.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.by.base.common.BeanValue;
import com.by.base.entity.BaseAttachment;
import com.by.base.entity.BaseObject;
import com.by.base.utils.RollPage;
import com.by.base.utils.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport {
//	implements ServletResponseAware, ServletRequestAware, SessionAware
	   
	private static final long serialVersionUID = 3525445612504421307L;

	protected transient final Logger log = Logger.getLogger(this.getClass());

	protected static final String CONTENT_TYPE = "text/html; charset=utf-8";

	protected static final String SUCCESS		= "success";
	protected static final String INDEX			= "index";
	protected static final String VIEW 			= "view";
	protected static final String ADD_INIT		= "addInit";
	protected static final String ADD 			= "add";
	protected static final String MODIFY_INIT 	= "modifyInit";
	protected static final String MODIFY 		= "modify";
	protected static final String DELETE 		= "delete";
	protected static final String DETAIL 		= "detail";
	protected static final String SUBMIT 		= "submit";
	protected static final String TREE			= "tree";
	protected static final String BLANK			= "blank";
	protected static final String FORWARD		= "forward";
	protected static final String RETURN		= "return";
	
	private List listValue ;
	
	private RollPage rollPage  ;
	
	private String page = "0";
	
	// 查询标识 
	private String qflag = "" ;
	
	protected BaseAttachment setUploadFile( BaseObject bo, Long billId, String attachmentCode, String writer ) {
		BaseAttachment att = new BaseAttachment() ;
		att.setUploadFiles( bo.getUploadFiles() ) ;
		att.setUploadFilesFileName( bo.getUploadFilesFileName() ) ;
		att.setUploadFilesContentType( bo.getUploadFilesContentType() ) ;
		att.setAttachmentType( StringUtil.getClassName( bo.getClass() ) ) ;
		att.setAttachmentTypeId( billId )  ;
		att.setAttachmentField( attachmentCode ) ;
		att.setWriter(writer) ;
		att.setWriteDate( new Date() ) ;
		
		return att ;
	}
	
	protected void disposeRequest( BeanValue value) {
		// 放在请求中的信息
		Map rMap = value.getRequestMap();
		// 放在Session中的信息
		Map sMap = value.getSessionMap();
		// 放在请求中的错误信息
		Map eMap = value.getErrorMap();

		// 将信息放入请求中
		Iterator it = rMap.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			getRequest().setAttribute(key, rMap.get(key));
		}
		// 将SESSION信息放入SESSION�?
		it = sMap.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			getSession().setAttribute(key, sMap.get(key));
		}
		// 将错误信息放入请求中
		it = eMap.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			getRequest().setAttribute(key, eMap.get(key));
		}
	}
	
	protected void saveMessage(String msg) {
		List messages = (List) getRequest().getSession().getAttribute(
				"messages");
		if (messages == null)
		{
			messages = new ArrayList();
		}
		messages.add(msg);
		getRequest().getSession().setAttribute("messages", messages);
	}

	protected ServletContext getServletContext() {
		return ServletActionContext.getServletContext() ;
	}
	
	/**
	 * Convenience method to get the request
	 * 
	 * @return current request
	 */
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * Convenience method to get the response
	 * 
	 * @return current response
	 */
	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * Convenience method to get the session
	 */
	protected HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * 获取当前日期
	 * 
	 * @return
	 */
	protected java.sql.Date getCurrentDate() {
		java.sql.Date current = new java.sql.Date(System.currentTimeMillis());
		return current;
	}
	
	/**
	 * 获取当前时间
	 * @return
	 */
	protected java.util.Date getCurrentDateTime() {
		java.util.Date current = new java.util.Date(System.currentTimeMillis());
		return current;
	}
	
	/**
	 * 获取当前时间
	 * @return
	 */
	protected Timestamp getCurrentTimestamp() {
		return new Timestamp(getCurrentDateTime().getTime()); 
	}
	
	/**
	 * print log message
	 * 
	 * @param e
	 */
	public void log(String message, Exception e) {
		log.error(message, e);
		e.printStackTrace() ;
	}

	public void setListValue(List listValue) {
		this.listValue = listValue;
	}

	public List getListValue() {
		return listValue;
	}

	public RollPage getRollPage() {
		if( rollPage == null ) {
			rollPage = new RollPage("0") ; 
		}
		
		if( page != null && page.length()>0 ) {
			rollPage.setPageCur( Integer.parseInt(page) ) ;
		}else {
			rollPage.setPageCur( 0 ) ;
		}
		
		return  rollPage ;
	}

	public void setRollPage(RollPage rollPage) {
		this.rollPage = rollPage;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getPage() {
		return page;
	}

	public String getQflag() {
		return qflag;
	}

	public void setQflag(String qflag) {
		this.qflag = qflag;
	}

	/**
	 * 初始化查询条�?如存在初始化标识则跳转到首页
	 */
	public void initQueryData() {
		if("0".equals( qflag ) ) {
			this.setPage("0") ;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork.ModelDriven#getModel()
	 */
//	public abstract Object getModel();

	/**
	 * @Desc ADD THIS METHOD FOR UNITTEST
	 */
//	public abstract void setModel(Object o);
	
}
