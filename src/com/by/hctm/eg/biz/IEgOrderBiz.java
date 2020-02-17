package com.by.hctm.eg.biz;

import java.util.List;

import com.by.base.exception.BaseException;
 
public interface IEgOrderBiz   {
	/**
	 * 获得亿格订单表数据集
	 * @author by 2015年3月11日09:27:41
	 * @param rollPage 分页对象
	 * @param user 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public  List getOrdersList()
			throws BaseException;
}
