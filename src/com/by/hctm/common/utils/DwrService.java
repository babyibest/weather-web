package com.by.hctm.common.utils;

import com.by.base.exception.BaseException;
import com.by.hctm.common.biz.IDwrServiceBiz;
 
public class DwrService {

	/**
	 * 公用方法-- 校验代码是否存在 
	 * @param tableName 表名(实体) 可为空, 为空则返回大于零的值
	 * @param columnName 列名,多列以逗号分割,如deptCode,isUsable
	 * @param columnValue 列值,多以逗号分割,如05,0
	 * @return 0不存在 其它值存在 
	 */
	public static int ifExitCodeInTable(  String tableName , String columnName ,String columnValue ) 
		throws BaseException{
		int rValue = -1 ;
		if( StringUtil.isNotBlank( columnName ) || StringUtil.isNotBlank( columnValue ) ) {
			String [] columnNames  = columnName.split(",") ;
			String [] columnValues = columnValue.split(",") ;
			rValue = iDwrServiceBiz.ifExitCodeInTable(tableName, columnNames, columnValues ) ;
		}
		
		return rValue  ;
		
	}
	
	/**
	 * 流程启动校验
	 * @param billId 单据编号(主键)
	 * @param processCode 流程编号
	 * @author Ted 2010-06-02 
	 * @return 状态 error流程已经提交 autoornone不存在或全部为自动执行 0,x流程类型->部门型+排序 1,x流程类型->人员型+排序 
	 * @throws BaseException
	 */
	public static String validWorkFlowProcessStart( String billId, String processCode, String deptId ) throws BaseException {
		return iDwrServiceBiz.validWorkFlowProcessStart(billId, processCode, deptId) ;
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
	public static String validWorkFlowProcessAudit( String billId, String processCode, String deptId ) throws BaseException {
		return iDwrServiceBiz.validWorkFlowProcessAudit(billId, processCode, deptId) ;
	}

	private static IDwrServiceBiz iDwrServiceBiz = null ;
	
	public static IDwrServiceBiz getIDwrServiceBiz() {
		return iDwrServiceBiz;
	}

	public static boolean setIDwrServiceBiz(IDwrServiceBiz dwrServiceBiz) {
		iDwrServiceBiz = dwrServiceBiz;
		return true; 
	}
	
}
