package com.by.hctm.system.action;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.system.biz.ITSysModuleInfoBiz;
import com.by.hctm.system.entity.TSysModuleInfo;

public class TSysModuleInfoAction extends BaseAction {
	private ITSysModuleInfoBiz iTSysModuleInfoBiz  ;
	private TSysModuleInfo tSysModuleInfo ;
	
	/**
	 * 查看功能信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewTSysModuleInfo() throws BaseException {
		
		try{
			this.setListValue( this.iTSysModuleInfoBiz.getTSysModuleInfoList( this.getRollPage(), tSysModuleInfo ) ) ;
		} catch (Exception e) {
			log.error("查看功能信息列表错误！", e);
			throw new BaseException("查看功能信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 保存功能信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String saveTSysModuleInfoInit() throws BaseException {
		try{
		} catch (Exception e) {
			log("保存功能信息初始化错误！", e);
			throw new BaseException("保存功能信息初始化错误！", e);
		}
		return ADD_INIT;
		
	}
	
	/**
	 * 保存功能信息
	 * @return
	 * @throws BaseException 
	 */
	public String saveTSysModuleInfo() throws BaseException {
		
		try{
			this.iTSysModuleInfoBiz.saveTSysModuleInfo( tSysModuleInfo );
		} catch (Exception e) {
			log("保存功能信息错误！", e);
			throw new BaseException("保存功能信息错误！", e);
		}
		
		return ADD;
		
	}
	
	/**
	 * 修改功能信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String updateTSysModuleInfoInit() throws BaseException {
		
		try{
			tSysModuleInfo=this.iTSysModuleInfoBiz.getTSysModuleInfo( tSysModuleInfo.getModuleId() );
		} catch (Exception e) {
			log("修改功能信息初始化错误！", e);
			throw new BaseException("修改功能信息初始化错误！", e);
		}
		return MODIFY_INIT;
		
	}
	
	/**
	 * 修改功能信息
	 * @return
	 * @throws BaseException 
	 */
	public String updateTSysModuleInfo() throws BaseException {
		
		try{
			this.iTSysModuleInfoBiz.updateTSysModuleInfo( tSysModuleInfo );
		} catch (Exception e) {
			log("修改功能信息错误！", e);
			throw new BaseException("修改功能信息错误！", e);
		}
		return MODIFY;
		
	}
	
	/**
	 * 删除功能信息
	 * @return
	 * @throws BaseException 
	 */
	public String deleteTSysModuleInfo() throws BaseException {
		try{
			this.iTSysModuleInfoBiz.deleteTSysModuleInfo( tSysModuleInfo  );
		} catch (Exception e) {
			log("删除功能信息错误！", e);
			throw new BaseException("删除功能信息错误！", e);
		}
		return DELETE;
		
	}
	
	/**
	 * 查看功能明细信息
	 * @return
	 * @throws BaseException 
	 */
	public String viewTSysModuleInfoDetail() throws BaseException {
		
		try{
			tSysModuleInfo=this.iTSysModuleInfoBiz.getTSysModuleInfo( tSysModuleInfo.getModuleId() );
		} catch (Exception e) {
			log("查看功能明细信息错误！", e);
			throw new BaseException("查看功能明细信息错误！", e);
		}
		return DETAIL;
		
	}
	
	/**
	 * 提交功能信息
	 * @return
	 * @throws BaseException 
	 */
	public String submitTSysModuleInfo() throws BaseException {
		
		try{
//			this.demoBiz.submitSubjects( subjects  );
		} catch (Exception e) {
			log("提交功能信息错误！", e);
			throw new BaseException("提交功能信息错误！", e);
		}
		return SUBMIT;
		
	}

	public ITSysModuleInfoBiz getTSysModuleInfoBiz() {
		return iTSysModuleInfoBiz;
	}

	public void setTSysModuleInfoBiz(ITSysModuleInfoBiz demoBiz) {
		this.iTSysModuleInfoBiz = demoBiz;
	}

	public TSysModuleInfo getTSysModuleInfo() {
		return tSysModuleInfo;
	}

	public void setTSysModuleInfo(TSysModuleInfo demo) {
		this.tSysModuleInfo = demo;
	}
	
}
