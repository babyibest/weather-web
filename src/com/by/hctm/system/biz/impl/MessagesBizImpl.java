package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.biz.IMessagesBiz;
import com.by.hctm.system.entity.Messages;

public class MessagesBizImpl extends BaseBizImpl implements IMessagesBiz  {
	
	/**
	 * 根据主键获得短信表实例
	 * @param id 主键
	 * @author ted 2012-10-18
	 * @return
	 * @throws BaseException 
	 */
	public Messages getMessages(Long id) throws BaseException {
		return (Messages)this.getObject(Messages.class, id);
	}
	
	/**
	 * 获得短信表实例
	 * @param messages 短信表实例
	 * @author ted 2012-10-18
	 * @return
	 * @throws BaseException 
	 */
	public Messages getMessages( Messages messages ) throws BaseException {
		return (Messages)this.getObject(Messages.class, messages.getSmsId() );
	}
	
	/**
	 * 添加短信信息
	 * @param messages 短信表实例
	 * @author ted 2012-10-18
	 * @throws BaseException 
	 */
	public void saveMessages(Messages messages) throws BaseException{
		this.saveObject( messages ) ;
	}
	
	/**
	 * 更新短信表实例
	 * @param messages 短信表实例
	 * @author ted 2012-10-18
	 * @throws BaseException 
	 */
	public void updateMessages(Messages messages) throws BaseException{
		this.updateObject( messages ) ;
	}
	
	/**
	 * 删除短信表实例
	 * @param id 主键数组
	 * @author ted 2012-10-18
	 * @throws BaseException 
	 */
	public void deleteMessages(String id) throws BaseException {
		this.removeObject( this.getMessages( new Long(id) ) ) ;
	}
	
	/**
	 * 删除短信表实例
	 * @param messages 短信表实例
	 * @author ted 2012-10-18
	 * @throws BaseException 
	 */
	public void deleteMessages(Messages messages) throws BaseException {
		this.removeObject( messages ) ;
	}
	
	/**
	 * 删除短信表实例
	 * @param id 主键数组
	 * @author ted 2012-10-18
	 * @throws BaseException 
	 */
	public void deleteMessagess(String[] id) throws BaseException {
		this.removeBatchObject(Messages.class, id) ;
	}
	
	/**
	 * 获得所有短信表数据集
	 * @param rollPage 分页对象
	 * @author ted 2012-10-18
	 * @return
	 * @throws BaseException 
	 */
	public List getMessagesList( RollPage rollPage  ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Messages de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有短信表数据集
	 * @param messages 查询参数对象
	 * @author ted 2012-10-18
	 * @return
	 * @throws BaseException 
	 */
	public List getMessagesList(  Messages messages ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Messages de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有短信表数据集
	 * @param rollPage 分页对象
	 * @param messages 查询参数对象
	 * @author ted 2012-10-18
	 * @return
	 * @throws BaseException 
	 */
	public List getMessagesList( RollPage rollPage, Messages messages ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Messages de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
}
