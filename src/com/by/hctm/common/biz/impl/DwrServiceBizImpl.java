package com.by.hctm.common.biz.impl;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.hctm.common.TableStatus;
import com.by.hctm.common.biz.IDwrServiceBiz;
import com.by.hctm.common.utils.StringUtil;

public class DwrServiceBizImpl extends BaseBizImpl implements IDwrServiceBiz {
	
	private IWfProcessRequestBiz iWfProcessRequestBiz ;
	
	/**
	 * 公用方法-- 校验代码是否存在 
	 * @param tableName 表名(实体) 可为空, 为空则返回大于零的值
	 * @param columnName 列名 可为空
	 * @param columnValue 列值  可为空
	 * @param usableColumnName 是否有效列名 可为空
	 * @param usableColumnValue 是否有效列值 可为空
	 * @author Ted 2010-06-02 
	 * @return 0不存在 其它值存在 
	 */
	public int ifExitCodeInTable(  String tableName , String[] columnNames ,String columnValues[] ) throws BaseException{
		int rValue = 9 ;
		
		String [] str ={"", ""} ;
		
		if( tableName != null && tableName.length()>0 ) {
			StringBuffer sql = new StringBuffer(" select count(*) from " ).append( tableName ).append(" tb where 1=1 ") ;
			
			if( StringUtil.isNotBlank( columnNames) ){
				for( int i=0; i<columnNames.length; i++ ) {
					sql.append( " and tb." ).append( columnNames[i] ).append( " = '" ).append( columnValues[i] ).append( "' ") ;
				}
			}
			
			rValue = this.countObjects( sql.toString() ) ;
		}
		
		return rValue ;
	}
	
	/**
	 * 流程启动校验
	 * @param billId 单据编号(主键)
	 * @param processCode 流程编号
	 * @author Ted 2010-06-02 
	 * @return 状态 error流程已经提交 autoornone不存在或全部为自动执行 
	 * 				0,x流程类型->部门型+排序 1,x流程类型->人员型+排序 
	 * @throws BaseException
	 */
	public String validWorkFlowProcessStart( String billId, String processCode, String deptId ) throws BaseException {
		String rValue = "" ;
//		WfProcessRequestBizImpl iWfProcessRequestBiz = new WfProcessRequestBizImpl() ;
		
		// 取当前流程申请信息
		WfProcessRequest pi = iWfProcessRequestBiz.getWfProcessRequest(billId, processCode, TableStatus.COMMON_STATUS_VALID ) ;
		
		if( pi != null ) { // 流程已经提交
			rValue = "error" ;
			
		}else { // 2判断下一步流程的类型(人员/部门) 3
			
			WfWorkflowPoint wwfp = iWfProcessRequestBiz.getWorkFlowNextPoint(String.valueOf( 1 ), processCode ) ;
			if( wwfp != null ) {
				// 流程类型 0 部门型 1 人员型
				if("0".equals( wwfp.getWfType() )) {
					if( iWfProcessRequestBiz.ifExitApproveUser(new Long(deptId), wwfp, wwfp.getWfType()) ){
						rValue = wwfp.getWfType() + "," + wwfp.getWfOrder() + "," + billId + "," + processCode; 
					}else {
						rValue = "autoornone" ;
					}
					
				}else {
					if( iWfProcessRequestBiz.ifExitApproveUser(null, wwfp, wwfp.getWfType() ) ){
						rValue = wwfp.getWfType() + "," + wwfp.getWfOrder() + "," + billId + "," + processCode; 
					}else{
						rValue = "autoornone" ;
					}
				}
				
			}else { // 不存在或全部为自动执行 
 				rValue = "autoornone" ;
			}
			
		}
		
		return rValue ;
	}
	
	/**
	 * 流程审核校验
	 * @param billId 单据编号(主键)
	 * @param processCode 流程编号
	 * @author Ted 2010-06-02 
	 * @return 状态 error流程申请不存在, 流程错误 finished最后审批 
	 * 				autoornone不存在或全部为自动执行 0,x流程类型->部门型+排序 1,x流程类型->人员型+排序 
	 * @throws BaseException
	 */
	public String validWorkFlowProcessAudit( String billId, String processCode, String deptId ) throws BaseException {
		String rValue = "" ;
		
		// 取当前流程申请信息
		WfProcessRequest pi = iWfProcessRequestBiz.getWfProcessRequest(billId, processCode, TableStatus.COMMON_STATUS_VALID ) ;
		
		if( pi != null ) { 
				
			if( pi.getProLevelCount().intValue() == pi.getProcessLevel().intValue() ) { // 最后审批
				
				rValue = "finished" ;
			}else { // 判断下级的流程类型 
				WfWorkflowPoint wwfp = iWfProcessRequestBiz.getWorkFlowNextPoint( String.valueOf( (pi.getProcessLevel().intValue() + 1 ) ), processCode ) ;
				
				if( wwfp != null ) {
					// 流程类型 0 部门型 1 人员型
					if("0".equals( wwfp.getWfType() )) {
						if( iWfProcessRequestBiz.ifExitApproveUser(new Long(deptId), wwfp, wwfp.getWfType() ) ){
							rValue = wwfp.getWfType() + "," + wwfp.getWfOrder() + "," + billId + "," + processCode; 
						}else {
							rValue = "autoornone" ;
						}
						
					}else {
						if( iWfProcessRequestBiz.ifExitApproveUser(null, wwfp, wwfp.getWfType() ) ){
							rValue = wwfp.getWfType() + "," + wwfp.getWfOrder() + "," + billId + "," + processCode; 
						}else{
							rValue = "autoornone" ;
						}
					}
					
				}else { // 不存在或全部为自动执行 
	 				rValue = "autoornone" ;
				}
			}
			
		}else { // 流程申请不存在, 流程错误!
			
			rValue = "error" ;
		}
		
		return rValue ;
	}

	public IWfProcessRequestBiz getIWfProcessRequestBiz() {
		return iWfProcessRequestBiz;
	}

	public void setIWfProcessRequestBiz(IWfProcessRequestBiz wfProcessRequestBiz) {
		iWfProcessRequestBiz = wfProcessRequestBiz;
	}
	 
}
