package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.system.biz.ISendsBiz;
import com.by.hctm.system.entity.Sends;

public class SendsBizImpl extends BaseBizImpl implements ISendsBiz  {
	
	/**
	 * 根据主键获得发文表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public Sends getSends(Long id) throws BaseException {
		return (Sends)this.getObject(Sends.class, id);
	}
	
	/**
	 * 添加发文信息
	 * @param demo 发文表实例
	 * @throws BaseException 
	 */
	public void saveSends(Sends sends) throws BaseException{
		this.saveObject( sends ) ;
	}
	
	/**
	 * 更新发文表实例
	 * @param sends 发文表实例
	 * @throws BaseException 
	 */
	public void updateSends(Sends sends) throws BaseException{
		this.updateObject( sends ) ;
	}
	
	/**
	 * 删除发文表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteSends(String id) throws BaseException {
		this.removeObject( this.getSends( new Long(id) ) ) ;
	}
	
	/**
	 * 删除发文表实例
	 * @param sends 发文表实例
	 * @throws BaseException 
	 */
	public void deleteSends(Sends sends) throws BaseException {
		this.removeObject( sends ) ;
	}
	
	/**
	 * 删除发文表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteSendss(String[] id) throws BaseException {
		this.removeBatchObject(Sends.class, id) ;
	}
	
	/**
	 * 获得所有发文表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List getSendsList( RollPage rollPage  ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Sends de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有发文表数据集
	 * @param sends 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getSendsList(  Sends sends ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Sends de where 1 = 1 " );
		if(sends!=null){
			if(!StringUtil.isBlank(sends.getSender())){
				hql.append(" and de.sender = '").append(sends.getSender()).append("'");
			}
		}
		hql.append(" order by de.id desc ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有发文表数据集
	 * @param rollPage 分页对象
	 * @param sends 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getSendsList( RollPage rollPage, Sends sends ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Sends de where 1 = 1 " );	
		if(sends!=null){
				if (!StringUtil.isBlank(sends.getSender())) {
					hql.append(" and de.sender = '").append(sends.getSender()).append("'");
				}
				if (!StringUtil.isBlank(sends.getTitle())) {
					hql.append(" and de.title like '%").append(sends.getTitle()).append("%'");
				}
			}
		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
}
