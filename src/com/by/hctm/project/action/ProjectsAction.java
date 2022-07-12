package com.by.hctm.project.action;

import javax.ws.rs.core.Request;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.project.biz.IProjectsBiz;
import com.by.hctm.project.entity.Egorder;
import com.by.hctm.project.entity.EgorderDetail;

public class ProjectsAction extends BaseAction {

	//项目服务类
	private IProjectsBiz iProjectsBiz =null ;
	 
	
	
	//订单实体类 from  xhcerp   
	private   Egorder   egorder;
	//订单详情类
	private   EgorderDetail   egorderDetail;

	
	
	/**
	 * 查看亿格订单信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewOrders() throws BaseException {
		
		try{
			this.setListValue(iProjectsBiz.getOrdersList());  //获取所有的订单信息
		} catch (Exception e) {
			log.error("查看亿格订单信息列表错误！", e);
			throw new BaseException("查看亿格订单信息列表错误！", e);
		}
		
		return "selectOrderIndex" ;
		
	}
	
	/**
	 * 查看亿格订单信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String selectViewOrders() throws BaseException {
		
		try{
			
			this.setListValue(iProjectsBiz.getOrdersList(egorder));  //获取所有的订单信息
		} catch (Exception e) {
			log.error("查看亿格订单信息列表错误！", e);
			throw new BaseException("查看亿格订单信息列表错误！", e);
		}
		
		return "selectOrderIndexView";
		
	}


	
	/**
	 * 查看亿格订单明细信息
	 * @author by  2015年3月12日09:06:43
	 * @return
	 * @throws BaseException 
	 */
	public String viewProjectsDetail() throws BaseException {
		//	egorder=this.iProjectsBiz.getEgorder(ddd );
			//System.out.println("订单号="+ddd);
			try{  
			egorderDetail = this.iProjectsBiz.getEgorderDetail(egorder) ;    
		} catch (Exception e) {
			System.out.println("订单号="+egorder.getHeth());
			log("查看亿格订单明细信息错误！", e);
			throw new BaseException("查看亿格订单明细信息错误！", e);
		} 
		return DETAIL;
		
	}
	
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	 
	
	
	public IProjectsBiz getIProjectsBiz() {
		return iProjectsBiz;
	}


	public void setIProjectsBiz(IProjectsBiz projectsBiz) {
		iProjectsBiz = projectsBiz;
	}

	public Egorder getEgorder() {
		return egorder;
	}

	public void setEgorder(Egorder egorder) {
		this.egorder = egorder;
	}

	
	 

	 

}
