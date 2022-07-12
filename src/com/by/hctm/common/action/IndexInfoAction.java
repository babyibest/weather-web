package com.by.hctm.common.action;

import java.util.List;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.BaseDataInfosUtil;
import com.by.hctm.system.biz.INoticesBiz;
import com.by.hctm.system.entity.Notices;

public class IndexInfoAction extends BaseAction {
	//待办信息服务类
	private IWaitForDealBiz iWaitForDealBiz  ;
	//已办信息服务类
	private IWaitForDealHistoryBiz iWaitForDealHistoryBiz  ;
	//
	private INoticesBiz noticesBiz  ;
	//
	private Notices notices ;
	//
	private IStandardsBiz iStandardsBiz;
	//
	private Standards standards ;
	//
	private WaitForDeal waitForDeal ;
	//
	private WaitForDealHistory waitForDealHistory ;
	
	private List<WaitForDeal> listWFD;
	
	private List<WaitForDealHistory> listWFDH;
	//通知
	private List<Notices> noticesList;
	//公告
	private List<Notices> announcementList;
	//发文
	private List<Notices> sendList;
	//其他
	private List<Notices> otherList;
	
	private List<Standards> standardsList;
	
	private int wfdNewSum=0;//待办新任务数量
	
	
	/**
	 * 查看首页信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewIndexInfo() throws BaseException {
		
		try{
			int index = 10;
			// 取待办事项信息 前五条
			listWFD=(List<WaitForDeal>)this.iWaitForDealBiz.getWaitForDealList( this.getRollPage() ) ;
			for(WaitForDeal wfd:listWFD){
				if(wfd.getStatus().equals("0"))
					wfdNewSum++;
				wfd.setSenderChina(BaseDataInfosUtil.convertLoginNameToChnName(wfd.getSender()));
			}
			
			// 取已办事项信息 前五条
			listWFDH=this.iWaitForDealHistoryBiz.getWaitForDealHistoryList( this.getRollPage(), waitForDealHistory ) ;
			
			// 取标准信息 前十条
			standardsList=this.iStandardsBiz.getStandardsList(this.getRollPage());
			
			// 取项目进度信息 前五条
			
			// 取发文信息 前五条
			
			// 取通知/公告信息 前十条
			noticesList=this.noticesBiz.getNoticesList( this.getRollPage() ,index,null );
			
		} catch (Exception e) {
			log.error("查看首页信息列表错误！", e);
			throw new BaseException("查看首页信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 查看首页左侧信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewIndexLeftInfo() throws BaseException {
		
		try{
			int index = 5;
			
			// 取发文信息 前五条
			sendList          =this.noticesBiz.getNoticesList( this.getRollPage(),index,"3" );
			// 取通知信息 type = 1 前五条
			noticesList       =this.noticesBiz.getNoticesList( this.getRollPage(),index,"1" );
			// 取公告信息 type = 2 前五条
			announcementList  =this.noticesBiz.getNoticesList( this.getRollPage(),index,"2" );
			
			// 取标准信息 前五条
//			standardsList=this.iStandardsBiz.getStandardsList(this.getRollPage());
			
			// 取已办事项信息 前五条
			listWFDH=this.iWaitForDealHistoryBiz.getWaitForDealHistoryList( this.getRollPage(), waitForDealHistory ) ;
			
			this.setListValue( listWFDH );
			
		} catch (Exception e) {
			log.error("查看首页左侧信息列表错误！", e);
			throw new BaseException("查看首页左侧信息列表错误！", e);
		}
		
		return "view_left" ;
		
	}
	
	/**
	 * 查看首页右侧信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewIndexRightInfo() throws BaseException {
		
		try{
			// 取待办事项信息 前五条
			listWFD=(List<WaitForDeal>)this.iWaitForDealBiz.getWaitForDealList( this.getRollPage() ) ;
			for(WaitForDeal wfd:listWFD){
				if(wfd.getStatus().equals("0"))
					wfdNewSum++;
				wfd.setSenderChina(BaseDataInfosUtil.convertLoginNameToChnName(wfd.getSender()));
			}
			
			// 取项目进度信息 前五条
			
			
			this.setListValue( listWFD );
			
		} catch (Exception e) {
			log.error("查看首页右侧信息列表错误！", e);
			throw new BaseException("查看首页右侧信息列表错误！", e);
		}
		
		return "view_right" ;
		
	}
	
	/**
	 * 查看待办已办信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewWaitForDealInfo() throws BaseException {
		
		try{
			// 取待办事项信息 前五条
			listWFD=(List<WaitForDeal>)this.iWaitForDealBiz.getWaitForDealList( this.getRollPage() ) ;
			for(WaitForDeal wfd:listWFD){
				if(wfd.getStatus().equals("0"))
					wfdNewSum++;
				wfd.setSenderChina(BaseDataInfosUtil.convertLoginNameToChnName(wfd.getSender()));
			}
			
			// 取已办事项信息 前五条
			listWFDH=this.iWaitForDealHistoryBiz.getWaitForDealHistoryList( this.getRollPage(), waitForDealHistory ) ;
			
			this.setListValue( listWFDH );
			
		} catch (Exception e) {
			log.error("查看首页左侧信息列表错误！", e);
			throw new BaseException("查看首页左侧信息列表错误！", e);
		}
		
		return "viewwaitfor" ;
		
	}
	
	
	/**
	 * 查看待办信息列表-分页显示
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewWaitForDeal() throws BaseException {
		
		try{
			
			this.setListValue( this.iWaitForDealBiz.getWaitForDealList( this.getRollPage(), waitForDeal ) ) ;
		} catch (Exception e) {
			log.error("查看待办信息列表-分页显示错误！", e);
			throw new BaseException("查看待办信息列表-分页显示错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 查看已办信息列表-分页显示
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewWaitForDealHistory() throws BaseException {
		
		try{
			
			this.setListValue( this.iWaitForDealHistoryBiz.getWaitForDealHistoryList( this.getRollPage(), waitForDealHistory ) ) ;
		} catch (Exception e) {
			log.error("查看已办信息列表-分页显示错误！", e);
			throw new BaseException("查看已办信息列表-分页显示错误！", e);
		}
		
		return VIEW ;
		
	}

	/**
	 * 查看发文信息列表-分页显示
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewSends() throws BaseException {
		
		try{
			
			this.setListValue( this.iWaitForDealHistoryBiz.getWaitForDealHistoryList( this.getRollPage() ) ) ;
		} catch (Exception e) {
			log.error("查看发文信息列表-分页显示错误！", e);
			throw new BaseException("查看发文信息列表-分页显示错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 查看公告/通知信息列表-分页显示
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewNotices() throws BaseException {
		
		try{
			
			this.setListValue( this.iWaitForDealHistoryBiz.getWaitForDealHistoryList( this.getRollPage() ) ) ;
		} catch (Exception e) {
			log.error("查看公告/通知信息列表-分页显示错误！", e);
			throw new BaseException("查看公告/通知信息列表-分页显示错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 查看标准信息列表-分页显示
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewStandards() throws BaseException {
		
		try{
			
			this.setListValue( this.iWaitForDealHistoryBiz.getWaitForDealHistoryList( this.getRollPage() ) ) ;
		} catch (Exception e) {
			log.error("查看标准信息列表-分页显示错误！", e);
			throw new BaseException("查看标准信息列表-分页显示错误！", e);
		}
		
		return VIEW ;
		
	}
	
	public IWaitForDealBiz getIWaitForDealBiz() {
		return iWaitForDealBiz;
	}

	public void setIWaitForDealBiz(IWaitForDealBiz waitForDealBiz) {
		iWaitForDealBiz = waitForDealBiz;
	}

	public IWaitForDealHistoryBiz getIWaitForDealHistoryBiz() {
		return iWaitForDealHistoryBiz;
	}

	public void setIWaitForDealHistoryBiz(
			IWaitForDealHistoryBiz waitForDealHistoryBiz) {
		iWaitForDealHistoryBiz = waitForDealHistoryBiz;
	}

	public IWaitForDealBiz getiWaitForDealBiz() {
		return iWaitForDealBiz;
	}

	public void setiWaitForDealBiz(IWaitForDealBiz iWaitForDealBiz) {
		this.iWaitForDealBiz = iWaitForDealBiz;
	}

	public IWaitForDealHistoryBiz getiWaitForDealHistoryBiz() {
		return iWaitForDealHistoryBiz;
	}

	public void setiWaitForDealHistoryBiz(
			IWaitForDealHistoryBiz iWaitForDealHistoryBiz) {
		this.iWaitForDealHistoryBiz = iWaitForDealHistoryBiz;
	}

	public WaitForDeal getWaitForDeal() {
		return waitForDeal;
	}

	public void setWaitForDeal(WaitForDeal waitForDeal) {
		this.waitForDeal = waitForDeal;
	}

	public WaitForDealHistory getWaitForDealHistory() {
		return waitForDealHistory;
	}

	public void setWaitForDealHistory(WaitForDealHistory waitForDealHistory) {
		this.waitForDealHistory = waitForDealHistory;
	}

	public List<WaitForDeal> getListWFD() {
		return listWFD;
	}

	public void setListWFD(List<WaitForDeal> listWFD) {
		this.listWFD = listWFD;
	}

	public List<WaitForDealHistory> getListWFDH() {
		return listWFDH;
	}

	public void setListWFDH(List<WaitForDealHistory> listWFDH) {
		this.listWFDH = listWFDH;
	}

	public int getWfdNewSum() {
		return wfdNewSum;
	}

	public void setWfdNewSum(int wfdNewSum) {
		this.wfdNewSum = wfdNewSum;
	}

	public INoticesBiz getNoticesBiz() {
		return noticesBiz;
	}

	public void setNoticesBiz(INoticesBiz noticesBiz) {
		this.noticesBiz = noticesBiz;
	}

	public Notices getNotices() {
		return notices;
	}

	public void setNotices(Notices notices) {
		this.notices = notices;
	}

	public List<Notices> getNoticesList() {
		return noticesList;
	}

	public void setNoticesList(List<Notices> noticesList) {
		this.noticesList = noticesList;
	}

	public IStandardsBiz getiStandardsBiz() {
		return iStandardsBiz;
	}

	public void setiStandardsBiz(IStandardsBiz iStandardsBiz) {
		this.iStandardsBiz = iStandardsBiz;
	}

	public Standards getStandards() {
		return standards;
	}

	public void setStandards(Standards standards) {
		this.standards = standards;
	}

	public List<Standards> getStandardsList() {
		return standardsList;
	}

	public void setStandardsList(List<Standards> standardsList) {
		this.standardsList = standardsList;
	}

	public IStandardsBiz getIStandardsBiz() {
		return iStandardsBiz;
	}

	public void setIStandardsBiz(IStandardsBiz standardsBiz) {
		iStandardsBiz = standardsBiz;
	}

	public List<Notices> getAnnouncementList() {
		return announcementList;
	}

	public void setAnnouncementList(List<Notices> announcementList) {
		this.announcementList = announcementList;
	}

	public List<Notices> getSendList() {
		return sendList;
	}

	public void setSendList(List<Notices> sendList) {
		this.sendList = sendList;
	}

	public List<Notices> getOtherList() {
		return otherList;
	}

	public void setOtherList(List<Notices> otherList) {
		this.otherList = otherList;
	}
	
}
