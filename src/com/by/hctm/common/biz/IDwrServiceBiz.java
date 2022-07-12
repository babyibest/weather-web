package com.by.hctm.common.biz;

import com.by.base.exception.BaseException;

public interface IDwrServiceBiz {

	/**
	 * 公用方法-- 校验代码是否存在 
	 * @param tableName 表名(实体) 可为空, 为空则返回大于零的值
	 * @param columnNames 列名 可为空
	 * @param columnValues 列值  可为空
	 * @return 0不存在 其它值存在 
	 */
	public int ifExitCodeInTable(  String tableName , String[] columnNames ,String columnValues[] ) 
		throws BaseException ;

	/**
	 * 流程启动校验
	 * @param billId 单据编号(主键)
	 * @param processCode 流程编号
	 * @author Ted 2010-06-02 
	 * @return 状态 error流程已经提交 autoornone不存在或全部为自动执行 
	 * 				0,x流程类型->部门型+排序 1,x流程类型->人员型+排序 
	 * @throws BaseException
	 */
	abstract String validWorkFlowProcessStart(String billId,
			String processCode, String deptId) throws BaseException;

	/**
	 * 流程审核校验
	 * @param billId 单据编号(主键)
	 * @param processCode 流程编号
	 * @author Ted 2010-06-02 
	 * @return 状态 error流程申请不存在, 流程错误 finished最后审批 
	 * 				autoornone不存在或全部为自动执行 0,x流程类型->部门型+排序 1,x流程类型->人员型+排序 
	 * @throws BaseException
	 */
	abstract String validWorkFlowProcessAudit(String billId,
			String processCode, String deptId) throws BaseException;

}