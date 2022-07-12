package com.by.hctm.system.action;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.system.biz.IMessagesBiz;
import com.by.hctm.system.entity.Messages;

public class MessagesAction extends BaseAction {
	// 短信 服务类
	private IMessagesBiz messagesBiz  ;
	// 短信 实例
	private Messages messages ;
	
	/**
	 * 查看短信信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewMessages() throws BaseException {
		
		try{
			// 短信 列表信息
			this.setListValue( this.messagesBiz.getMessagesList( this.getRollPage(), messages ) ) ;
		} catch (Exception e) {
			log.error("查看短信信息列表错误！", e);
			throw new BaseException("查看短信信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 保存短信信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String saveMessagesInit() throws BaseException {
		try{
		} catch (Exception e) {
			log("保存短信信息初始化错误！", e);
			throw new BaseException("保存短信信息初始化错误！", e);
		}
		return ADD_INIT;
		
	}
	
	/**
	 * 保存短信信息
	 * @return
	 * @throws BaseException 
	 */
	public String saveMessages() throws BaseException {
		
		try{
			// 保存短信信息
			this.messagesBiz.saveMessages( messages );
		} catch (Exception e) {
			log("保存短信信息错误！", e);
			throw new BaseException("保存短信信息错误！", e);
		}
		
		return ADD;
		
	}
	
	/**
	 * 修改短信信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String updateMessagesInit() throws BaseException {
		
		try{
			// 取得短信信息
			messages=this.messagesBiz.getMessages( messages.getSmsId() );
		} catch (Exception e) {
			log("修改短信信息初始化错误！", e);
			throw new BaseException("修改短信信息初始化错误！", e);
		}
		return MODIFY_INIT;
		
	}
	
	/**
	 * 修改短信信息
	 * @return
	 * @throws BaseException 
	 */
	public String updateMessages() throws BaseException {
		
		try{
			// 修改短信信息
			this.messagesBiz.updateMessages( messages );
		} catch (Exception e) {
			log("修改短信信息错误！", e);
			throw new BaseException("修改短信信息错误！", e);
		}
		return MODIFY;
		
	}
	
	/**
	 * 删除短信信息
	 * @return
	 * @throws BaseException 
	 */
	public String deleteMessages() throws BaseException {
		try{
			// 删除短信信息
			this.messagesBiz.deleteMessages( messages  );
		} catch (Exception e) {
			log("删除短信信息错误！", e);
			throw new BaseException("删除短信信息错误！", e);
		}
		return DELETE;
		
	}
	
	/**
	 * 查看短信明细信息
	 * @return
	 * @throws BaseException 
	 */
	public String viewMessagesDetail() throws BaseException {
		
		try{
			// 取短信信息
			messages=this.messagesBiz.getMessages( messages.getSmsId() );
		} catch (Exception e) {
			log("查看短信明细信息错误！", e);
			throw new BaseException("查看短信明细信息错误！", e);
		}
		return DETAIL;
		
	}
	
	/**
	 * 提交短信信息
	 * @return
	 * @throws BaseException 
	 */
	public String submitMessages() throws BaseException {
		
		try{
//			this.messagesBiz.submitSubjects( subjects  );
		} catch (Exception e) {
			log("提交短信信息错误！", e);
			throw new BaseException("提交短信信息错误！", e);
		}
		return SUBMIT;
		
	}

	public IMessagesBiz getMessagesBiz() {
		return messagesBiz;
	}

	public void setMessagesBiz(IMessagesBiz messagesBiz) {
		this.messagesBiz = messagesBiz;
	}

	public Messages getMessages() {
		return messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
	}
	
}
