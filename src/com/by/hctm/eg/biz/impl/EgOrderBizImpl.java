package com.by.hctm.eg.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.hctm.eg.biz.IEgOrderBiz;

public class EgOrderBizImpl  extends  BaseBizImpl implements IEgOrderBiz {
	/**
	 * 获得所有亿格订单表数据集
	 * @param rollPage 分页对象
	 * @param user 查询参数对象
	 * @return departments 部门
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public List getOrdersList() throws BaseException {
		StringBuffer hql = new StringBuffer(" from  egorder as u   where 1 = 1 " );
		//hql.append(" and u.isUsable='").append(TableStatus.COMMON_STATUS_VALID).append("' ");
		  //查询
 		//hql.append(" and u.userChinesename like '%").append(user.getUserChinesename()).append("%' ");
		hql.append(" order by u.heth ");
		return this.getObjects (  hql.toString() );
	}

}
