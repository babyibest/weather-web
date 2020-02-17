/**
 * 
 */
package com.by.hctm.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ted 2010-06-25 
 *
 */
public class WorkFlowStatusMap {

	// 物资需求计划审批流程定义
	private static Map<String, String> workflowStatusMap1	=	new HashMap<String, String>();
 
	// 物资需求计划汇总审批流程定义
	private static Map<String, String> workflowStatusMap2	=	new HashMap<String, String>();

	// 合同付款审批流程定义
	private static Map<String, String> workflowStatusMap3	=	new HashMap<String, String>();
	
	// 合同签订审批流程定义
	private static Map<String, String> workflowStatusMap4	=	new HashMap<String, String>();
	
	// 物资领料单审批流程定义
	private static Map<String, String> workflowStatusMap5	=	new HashMap<String, String>();
	
	// 物资退料单审批流程定义
	private static Map<String, String> workflowStatusMap6	=	new HashMap<String, String>();
	
	// 特需物资领料单审批流程定义
	private static Map<String, String> workflowStatusMap7	=	new HashMap<String, String>();
	
	
	public static Map<String, String> getWorkflowStatusMap1() {
		return workflowStatusMap1;
	}

	public static Map<String, String> getWorkflowStatusMap2() {
		return workflowStatusMap2;
	}

	public static Map<String, String> getWorkflowStatusMap3() {
		return workflowStatusMap3;
	}

	public static Map<String, String> getWorkflowStatusMap4() {
		return workflowStatusMap4;
	}

	public static Map<String, String> getWorkflowStatusMap5() {
		return workflowStatusMap5;
	}

	public static Map<String, String> getWorkflowStatusMap6() {
		return workflowStatusMap6;
	}

	public static Map<String, String> getWorkflowStatusMap7() {
		return workflowStatusMap7;
	}

}
