package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.system.biz.ISendReceiversBiz;
import com.by.hctm.system.entity.SendReceivers;

public class SendReceiversBizImpl extends BaseBizImpl implements
		ISendReceiversBiz {

	/**
	 * 根据主键获得发文信息接收表实例
	 * 
	 * @param id
	 *            主键
	 * @return
	 * @throws BaseException
	 */
	public SendReceivers getSendReceivers(Long id) throws BaseException {
		return (SendReceivers) this.getObject(SendReceivers.class, id);
	}

	/**
	 * 获得发文信息接收表实例
	 * 
	 * @param sendReceivers
	 *            发文信息接收表实例
	 * @return
	 * @throws BaseException
	 */
	public SendReceivers getSendReceivers(SendReceivers sendReceivers)
			throws BaseException {
		return (SendReceivers) this.getObject(SendReceivers.class,
				sendReceivers.getSrId());
	}

	/**
	 * 添加发文信息接收信息
	 * 
	 * @param sendReceivers
	 *            发文信息接收表实例
	 * @throws BaseException
	 */
	public void saveSendReceivers(SendReceivers sendReceivers)
			throws BaseException {
		this.saveObject(sendReceivers);
	}

	/**
	 * 更新发文信息接收表实例
	 * 
	 * @param sendReceivers
	 *            发文信息接收表实例
	 * @throws BaseException
	 */
	public void updateSendReceivers(SendReceivers sendReceivers)
			throws BaseException {
		this.updateObject(sendReceivers);
	}

	/**
	 * 删除发文信息接收表实例
	 * 
	 * @param id
	 *            主键数组
	 * @throws BaseException
	 */
	public void deleteSendReceivers(String id) throws BaseException {
		this.removeObject(this.getSendReceivers(new Long(id)));
	}

	/**
	 * 删除发文信息接收表实例
	 * 
	 * @param sendReceivers
	 *            发文信息接收表实例
	 * @throws BaseException
	 */
	public void deleteSendReceivers(SendReceivers sendReceivers)
			throws BaseException {
		this.removeObject(sendReceivers);
	}

	/**
	 * 删除发文信息接收表实例
	 * 
	 * @param id
	 *            主键数组
	 * @throws BaseException
	 */
	public void deleteSendReceiverss(String[] id) throws BaseException {
		this.removeBatchObject(SendReceivers.class, id);
	}

	/**
	 * 获得所有发文信息接收表数据集
	 * 
	 * @param rollPage
	 *            分页对象
	 * @return
	 * @throws BaseException
	 */
	public List getSendReceiversList(RollPage rollPage) throws BaseException {
		StringBuffer hql = new StringBuffer(
				" from SendReceivers de where 1 = 1 ");

		hql.append(" order by de.srId desc ");
		return this.getObjects(rollPage, hql.toString());
	}

	/**
	 * 获得所有发文信息接收表数据集
	 * 
	 * @param sendReceivers
	 *            查询参数对象
	 * @return
	 * @throws BaseException
	 */
	public List getSendReceiversList(SendReceivers sendReceivers)
			throws BaseException {
		StringBuffer hql = new StringBuffer(
				" from SendReceivers de where 1 = 1 ");
		if (sendReceivers != null) {
			if (!StringUtil.isBlank(sendReceivers.getReceiver())) {

				hql.append(" and de.receiver = '")
						.append(sendReceivers.getReceiver()).append("'");
			}
			if (!StringUtil.isBlank(sendReceivers.getReceiverType())) {

				hql.append(" and de.receiverType = ").append(
						sendReceivers.getReceiverType());
			}
			if (!StringUtil.isBlank(sendReceivers.getSendId())) {

				hql.append(" and de.sends.sendId = ").append(
						sendReceivers.getSendId());
			}

		}
		hql.append(" order by de.srId desc ");
		return this.getObjects(hql.toString());
	}

	/**
	 * 获得所有发文信息接收表数据集
	 * 
	 * @param rollPage
	 *            分页对象
	 * @param sendReceivers
	 *            查询参数对象
	 * @return
	 * @throws BaseException
	 */
	public List getSendReceiversList(RollPage rollPage,
			SendReceivers sendReceivers) throws BaseException {
		StringBuffer hql = new StringBuffer(
				" from SendReceivers de where 1 = 1 ");
		if (sendReceivers != null) {
			if (StringUtil.isBlank(sendReceivers.getSendId())) {
				hql.append(" and de.sendId").append(sendReceivers.getSendId());
			}
		}
		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString());
	}

}
