/**
 * @author Ted 2010-06-25
 */
package com.by.hctm.common;

public class WorkFlowStatus {
	
	//	--------------------------- 公用流程状态 ---------------------------
	/** 公用状态 - 等待提交 ‘01’ */
	public static String Common_Status_01 = "01" ;
	
	/** 公用状态 - 等待提交 */
	public static String Common_Status_01_Text = "等待提交" ;
	
	/** 公用状态 - 已提交 ‘02’ */
	public static String Common_Status_02 = "02" ;
	
	/** 公用状态 - 已提交 */
	public static String Common_Status_02_Text = "已提交" ;
	
	/** 公用状态 - 已退回 ‘21’ */
	public static String Common_Status_03 = "21" ;
	
	/** 公用状态 - 已退回 */
	public static String Common_Status_03_Text = "已退回" ;
	
	/** 公用状态 - 已撤销 ‘22’ */
	public static String Common_Status_04 = "22" ;
	
	/** 公用状态 - 已撤销 */
	public static String Common_Status_04_Text = "已撤销" ;
	
	/** 公用状态 - 审核通过 ‘23’ */
	public static String Common_Status_05 = "23" ;
	
	/** 公用状态 - 审核通过 */
	public static String Common_Status_05_Text = "审核通过" ;
	
	//----------------------------- 审批状态 ---------------------------------------
	/** 审批状态：不同意  "0" */
	public static String Common_Check_NoPass = "0";
	
	/** 审批状态：不同意的标签 */
	public static String Common_Check_NoPass_Text = "不同意";
	
	/** 审批状态：同意 "1" */
	public static String Common_Check_Pass = "1";
	
	/** 审批状态：同意的标签 */
	public static String Common_Check_Pass_Text = "同意";
	
	//----------------------------- 代办事宜状态 ---------------------------------------
	/** 代办事宜状态:新 "0" */
	public static String Wait_For_Deal_Status_New = "0";
	
	/** 代办事宜状态标签：新 */
	public static String Wait_For_Deal_Status_New_Text = "新";
	
	/** 代办事宜状态:已浏览待处理 "1" */
	public static String Wait_For_Deal_Status_Browse = "1";
	
	/** 代办事宜状态标签：已浏览待处理 */
	public static String Wait_For_Deal_Status_Browse_Text = "已浏览";
	
	/** 代办事宜状态:已处理 "2" */
	public static String Wait_For_Deal_Status_Dealed = "2";
	
	/** 代办事宜状态标签：已处理 */
	public static String Wait_For_Deal_Status_Dealed_Text = "已处理";
	
	//	--------------------------- 流程类型 ---------------------------
	/** 流程编号 - 合同起草 ‘01’ */
	public static final String Work_Flow_Code_01 = "01" ;
	
	/** 流程编号 - 合同变更 ‘02’ */
	public static final String Work_Flow_Code_02 = "02" ;
	
	/** 流程编号 - 监理任务书 ‘03’ */
	public static final String Work_Flow_Code_03 = "03" ;	
	
	/** 流程编号 - 发票申请 ‘04’ */
	public static final String Work_Flow_Code_04 = "04" ;
	
	/** 流程编号 - 档案借阅（内借） ‘05’ */
	public static final String Work_Flow_Code_05 = "05" ;
	
	/** 流程编号 - 档案归还 ‘06’ */
	public static final String Work_Flow_Code_06 = "06" ;
	
	/** 流程编号 - 资料销毁 ‘07’ */
	public static final String Work_Flow_Code_07 = "07" ;
	
	/** 流程编号 - 档案销毁 ‘08’ */
	public static final String Work_Flow_Code_08 = "08" ;
	
	/** 流程编号 - 监造结算申请管理 ‘05’ */
	public static final String Work_Flow_Code_09 = "09" ;
	
	/** 流程编号 - 监造报告管理 ‘06’ */
	public static final String Work_Flow_Code_10 = "10" ;
	
	/** 流程编号 - 监理资料审批 ‘11’ */
	public static final String Work_Flow_Code_11 = "11" ;
	
	/** 流程编号 - 监造合同审批 ‘12’ */
	public static final String Work_Flow_Code_12 = "12" ;
	
	/** 流程编号 - 监理项目部组建审批 ‘13’ */
	public static final String Work_Flow_Code_13 = "13" ;
	
	/** 流程编号 - 安质整改反馈审批 ‘14’ */
	public static final String Work_Flow_Code_14 = "14" ;
	
	/** 流程编号 - 档案借阅（外借） ‘15’ */
	public static final String Work_Flow_Code_15 = "15" ;
	
	/** 流程编号 - 监理资料审批  ‘16’ */
	public static final String Work_Flow_Code_16 = "16" ;
	
	/** 流程编号 - 资料销毁审批  ‘17’ */
	public static final String Work_Flow_Code_17 = "17" ;
	
	/** 流程编号 - 档案销毁审批  ‘18’ */
	public static final String Work_Flow_Code_18 = "18" ;
	
	//	--------------------------- 流程节点状态 ---------------------------
	/** 流程节点状态 - 手动 ‘0’ */
	public static final String Work_Flow_Point_Status_Hand = "0";
	
	/** 流程节点状态 - 手动  */
	public static final String Work_Flow_Point_Status_Hand_Text = "手动";
	
	/** 流程节点状态 - 自动 ‘1’ */
	public static final String Work_Flow_Point_Status_Auto = "1";
	
	/** 流程节点状态 - 自动  */
	public static final String Work_Flow_Point_Status_Auto_Text = "自动";
	
	//	--------------------------- 流程是否结束状态 ---------------------------
	/** 流程是否结束状态 - 是 ‘0’ */
	public static final String Work_Flow_End_STATUS_VALID = "0";
	
	/** 流程是否结束状态 - 是  */
	public static final String Work_Flow_End_STATUS_VALID_TEXT = "是";
	
	/** 流程是否结束状态 - 否 ‘1’ */
	public static final String Work_Flow_End_STATUS_INVALID = "1";
	
	/** 流程是否结束状态 - 否  */
	public static final String Work_Flow_End_STATUS_INVALID_TEXT = "否";
	
}
