package com.by.hctm.system.action;

import java.util.Date;
import java.util.List;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.BaseDataInfosUtil;
import com.by.hctm.common.UserRightInfoUtil;
import com.by.hctm.common.utils.DateUtil;
import com.by.hctm.manpower.biz.IUsersBiz;
import com.by.hctm.manpower.entity.Users;
import com.by.hctm.system.biz.IDepartmentsBIZ;
import com.by.hctm.system.biz.ISendReceiversBiz;
import com.by.hctm.system.biz.ISendsBiz;
import com.by.hctm.system.entity.Departments;
import com.by.hctm.system.entity.SendReceivers;
import com.by.hctm.system.entity.Sends;

public class SendsAction extends BaseAction {
	private ISendsBiz sendsBiz  ;
	private Sends sends ;
	private SendReceivers sendReceivers;
	private ISendReceiversBiz sendReceiversBiz;
	private IUsersBiz usersBiz;
	private Users users;
	private IDepartmentsBIZ departmentsBIZ;
	private String tree;
	private Departments departments;
	private List<SendReceivers> listSendReceivers;
	private String mc ="" ;
	private String mn = "" ;
	private String sc ="" ;
	private String sn  = "";
	
	
	/**
	 * 查看发文管理信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewSends() throws BaseException {
		
		try{
				if(sends!=null ){
					sends.setSender(UserRightInfoUtil.getSessionInfo(getRequest()).getUsers().getUserId().toString());
					this.setListValue( this.sendsBiz.getSendsList( this.getRollPage(), sends ) ) ;
				}else{
				Sends sends=new Sends();
				if(UserRightInfoUtil.getSessionInfo(getRequest())!=null){
					String name =UserRightInfoUtil.getSessionInfo(getRequest()).getUsers().getUserId().toString();
					sends.setSender(name);
					this.setListValue( this.sendsBiz.getSendsList( this.getRollPage(), sends ) ) ;
				}else{
					return "login";
				}
				
				
				
				}

			
		} catch (Exception e) {
			log.error("查看发文管理信息列表错误！", e);
			throw new BaseException("查看发文管理信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 保存发文管理信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String saveSendsInit() throws BaseException {
		try{
			
			users=new Users();
			users.setUserName(UserRightInfoUtil.getUserName(getRequest()));
			users=(Users)this.usersBiz.getUsersList(users).get(0);
		} catch (Exception e) {
				
			log("保存发文管理信息初始化错误！", e);
			throw new BaseException("保存发文管理信息初始化错误！", e);
		}
		return ADD_INIT;
		
	}
	
	/**
	 * 保存发文管理信息
	 * @return
	 * @throws BaseException 
	 */
	public String saveSends() throws BaseException {
		
		try{
			if(listSendReceivers.size()>0){
					Date de=new Date();
					sends.setSender(UserRightInfoUtil.getSessionInfo(getRequest()).getUsers().getUserId().toString());
					sends.setSendDate(DateUtil.convertUtilDateToSqlDate(de));
					String str [] =listSendReceivers.get(0).getReceiver().split(",");
					sendReceivers =new SendReceivers();
						for (int j = 0; j < str.length; j++) {
							//users=this.usersBiz.getUsers(new Long(str[j]));
							sendReceivers=new SendReceivers();
							sendReceivers.setReceiver(str[j]);
							sendReceivers.setReceiverType("0");
							sendReceivers.setSends(sends);
							sends.getSendReceivers().add(sendReceivers);
						}
						String std []= listSendReceivers.get(1).getReceiver().split(",");
						for (int i = 0; i < std.length; i++) {
							//users=this.usersBiz.getUsers(new Long(std[i]));
							//System.out.println(users.getUserId());
							sendReceivers=new SendReceivers();
							sendReceivers.setReceiver(std[i]);
							sendReceivers.setReceiverType("1");
							sendReceivers.setSends(sends);
							sends.getSendReceivers().add(sendReceivers);
						}
				}
			this.sendsBiz.saveSends( sends );
		} catch (Exception e) {
			log("保存发文管理信息错误！", e);
			throw new BaseException("保存发文管理信息错误！", e);
		}
		
		return ADD;
		
	}
	
	/**
	 * 修改发文管理信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String updateSendsInit() throws BaseException {
		try{

			sends=this.sendsBiz.getSends( sends.getSendId() );
			for(SendReceivers s:this.sends.getSendReceivers()){
				if(s.getReceiverType().equals("0")){
					mn += BaseDataInfosUtil.convertUserIdToChnName(new Long(s.getReceiver()))+",";
					mc +=s.getReceiver()+",";
				}
				if(s.getReceiverType().equals("1")){
					 sn += BaseDataInfosUtil.convertUserIdToChnName(new Long(s.getReceiver()))+",";
					 sc += s.getReceiver()+",";
				}
			}
			
		
		} catch (Exception e) {
			log("修改发文管理信息初始化错误！", e);
			throw new BaseException("修改发文管理信息初始化错误！", e);
		}
		return MODIFY_INIT;
		
	}
	
	/**
	 * 修改发文管理信息
	 * @return
	 * @throws BaseException 
	 */
	public String updateSends() throws BaseException {
		
		try{
			
			if(listSendReceivers!=null && listSendReceivers.size()>0){
				
				//将表中的数据全删
				SendReceivers sr=new SendReceivers();
				sr.setSendId(sends.getSendId());
				List<SendReceivers> srs=this.sendReceiversBiz.getSendReceiversList(sr);
				for (int i = 0; i < srs.size(); i++) {
					this.sendReceiversBiz.deleteSendReceivers(srs.get(i));
				}
				//开始更新数据
				sends.setSender(UserRightInfoUtil.getSessionInfo(getRequest()).getUsers().getUserId().toString());
				sends.setSendDate( this.getCurrentDateTime() );
				String str [] =listSendReceivers.get(0).getReceiver().split(",");
				if(str.length>0){
				sendReceivers =new SendReceivers();
					for (int j = 0; j < str.length; j++) {
						if (str[j].length()>0) {
							//users=this.usersBiz.getUsers(new Long(str[j]));
							sendReceivers=new SendReceivers();
							sendReceivers.setReceiver(str[j]);
							sendReceivers.setReceiverType("0");
							sendReceivers.setSends(sends);
							sends.getSendReceivers().add(sendReceivers);
						}
						
					}
				}
				String std []= listSendReceivers.get(1).getReceiver().split(",");
				if (std.length>0) {					
					for (int i = 0; i < std.length; i++) {
						if (std[i].length()>0) {
							//users=this.usersBiz.getUsers(new Long(std[i]));
							//System.out.println(users.getUserId());
							sendReceivers=new SendReceivers();
							sendReceivers.setReceiver(std[i]);
							sendReceivers.setReceiverType("1");
							sendReceivers.setSends(sends);
							sends.getSendReceivers().add(sendReceivers);
						}
						
					}
				}
				this.sendsBiz.updateSends( sends );
			}
		} catch (Exception e) {
			log("修改发文管理信息错误！", e);
			throw new BaseException("修改发文管理信息错误！", e);
		}
		return MODIFY;
		
	}
	
	/**
	 * 删除发文管理信息
	 * @return
	 * @throws BaseException 
	 */
	public String deleteSends() throws BaseException {
		try{
			
				String s [] = this.getRequest().getParameter("str").split(",");
				if(!s.equals("")){

					for (int i = 0; i < s.length; i++) {
						System.out.println(s[i]);
						this.sendsBiz.deleteSends( s[i]  );
					}
				}
			
		} catch (Exception e) {
			log("删除发文管理信息错误！", e);
			throw new BaseException("删除发文管理信息错误！", e);
		}
		return DELETE;
		
	}
	
	/**
	 * 查看发文管理明细信息
	 * @return
	 * @throws BaseException 
	 */
	public String viewSendsDetail() throws BaseException {
		
		try{
			sends=this.sendsBiz.getSends( sends.getSendId() );
			SendReceivers srs = new SendReceivers();
			srs.setSendId(sends.getSendId());
			srs.setReceiverType("0");
			this.sendReceiversBiz.getSendReceiversList(srs);
		} catch (Exception e) {
			log("查看发文管理明细信息错误！", e);
			throw new BaseException("查看发文管理明细信息错误！", e);
		}
		return DETAIL;
		
	}
	
	/**
	 * 提交发文管理信息
	 * @return
	 * @throws BaseException 
	 */
	public String submitSends() throws BaseException {
		
		try{
//			this.sendsBiz.submitSubjects( subjects  );
		} catch (Exception e) {
			log("提交发文管理信息错误！", e);
			throw new BaseException("提交发文管理信息错误！", e);
		}
		return SUBMIT;
		
	}
	
	/**
	 * 提交发文管理信息
	 * @return
	 * @throws BaseException 
	 */
	public String querySends() throws BaseException {
		
		try{	
				String userId   = this.getRequest().getParameter("userId");
				String userName = this.getRequest().getParameter("userName");
				//String str=new String(userName.getBytes("UTF-8"),"ISO8859-1");

				this.getRequest().setAttribute("userId",userId);
				this.getRequest().setAttribute("userName",userName);
		} catch (Exception e) {
			log("提交发文管理信息错误！", e);
			throw new BaseException("提交发文管理信息错误！", e);
		}
		return "query";
		
	}
	
	/**
	 * 修改发文信息状态
	 * @return
	 * @throws BaseException 
	 */
	public String updateStatusSends() throws BaseException {
		
		try{	
			String s [] = this.getRequest().getParameter("sid").split(",");
				
				if(!s.equals("")){

					for (int i = 0; i < s.length; i++) {
						System.out.println(s[i]);
						sends =new Sends();
						sends=this.sendsBiz.getSends(new Long(s[i]));
						sends.setStatus("已发送");
						this.sendsBiz.updateSends(sends);
					}
				}
			
		} catch (Exception e) {
			log("提交发文管理信息错误！", e);
			throw new BaseException("提交发文管理信息错误！", e);
		}
		return "status";
		
	}

	public ISendsBiz getSendsBiz() {
		return sendsBiz;
	}

	public void setSendsBiz(ISendsBiz sendsBiz) {
		this.sendsBiz = sendsBiz;
	}

	public Sends getSends() {
		return sends;
	}

	public void setSends(Sends sends) {
		this.sends = sends;
	}

	public IUsersBiz getUsersBiz() {
		return usersBiz;
	}

	public void setUsersBiz(IUsersBiz usersBiz) {
		this.usersBiz = usersBiz;
	}

	public IDepartmentsBIZ getDepartmentsBIZ() {
		return departmentsBIZ;
	}

	public void setDepartmentsBIZ(IDepartmentsBIZ departmentsBIZ) {
		this.departmentsBIZ = departmentsBIZ;
	}

	public String getTree() {
		return tree;
	}

	public void setTree(String tree) {
		this.tree = tree;
	}

	public Departments getDepartments() {
		return departments;
	}

	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public SendReceivers getSendReceivers() {
		return sendReceivers;
	}

	public void setSendReceivers(SendReceivers sendReceivers) {
		this.sendReceivers = sendReceivers;
	}

	public List<SendReceivers> getListSendReceivers() {
		return listSendReceivers;
	}

	public void setListSendReceivers(List<SendReceivers> listSendReceivers) {
		this.listSendReceivers = listSendReceivers;
	}

	public ISendReceiversBiz getSendReceiversBiz() {
		return sendReceiversBiz;
	}

	public void setSendReceiversBiz(ISendReceiversBiz sendReceiversBiz) {
		this.sendReceiversBiz = sendReceiversBiz;
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getMn() {
		return mn;
	}

	public void setMn(String mn) {
		this.mn = mn;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	
	
}
