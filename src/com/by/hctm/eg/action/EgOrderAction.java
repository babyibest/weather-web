package com.by.hctm.eg.action;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.eg.biz.IEgOrderBiz;

public class EgOrderAction extends BaseAction {	
	//亿格订单biz
	private  IEgOrderBiz  iEgOrderbiz =null ;
	/**
	 * 查看亿格订单信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewOrders() throws BaseException {
		
		try{
			this.setListValue(iEgOrderbiz.getOrdersList());  //获取所有的订单信息
		} catch (Exception e) {
			log.error("查看亿格订单信息列表错误！", e);
			throw new BaseException("查看亿格订单信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	public IEgOrderBiz getiEgOrderbiz() {
		return iEgOrderbiz;
	}
	public void setiEgOrderbiz(IEgOrderBiz iEgOrderbiz) {
		this.iEgOrderbiz = iEgOrderbiz;
	}
	 
	
}
