/**
 * 公用状态定义
 * @author ted
 */
package com.by.hctm.common;

public class TableStatus {
	
	//默认系统管理员角色代码  
	public static final String DEFAULT_SYSTEM_ROLE_CODE = "01" ; 
	
	// 用户session标识
	public static final String LOGIN_INFO_KEY = "LoginInfoKey";
	
	//	--------------------------- 公用状态 ---------------------------
	/** 公用状态 - 是否有效 - 有效 ‘0’ */
	public static final String COMMON_STATUS_VALID = "0" ;
	
	/** 公用状态 - 是否有效 - 有效   */
	public static final String COMMON_STATUS_VALID_TEXT = "有效" ;
	
	/** 公用状态 - 是否有效 - 无效 ‘1’ */
	public static final String COMMON_STATUS_INVALID = "1" ;
	
	/** 公用状态 - 是否有效 - 无效 */
	public static final String COMMON_STATUS_INVALID_TEXT = "无效" ;
	
	//	-------------------------------------- 用户权限  -----------------------------------------
	/** 用户权限 浏览权限 - “0” */
	public final static String User_Right_View = "0";
	
	/** 用户权限 操作权限 - “1” */
	public final static String User_Right_Operat = "1";
	
	/** 用户权限 超级操作权限 - “9” */
	public final static String User_Right_superOperat = "9";
	
//	-------------------------------------- 合同变更单列表  ----------------------------------------
	/** 合同变更单: - 合同编号 ‘01’ */
	public static final String CONTRACT_CHANGE_01 = "01" ;
	
	/** 合同变更单: - 合同编号 */
	public static final String CONTRACT_CHANGE_01_TEXT = "合同编号" ;
	
	/** 合同变更单: - 合同名称 ‘02’ */
	public static final String CONTRACT_CHANGE_02 = "02" ;
	
	/** 合同变更单: - 合同名称 */
	public static final String CONTRACT_CHANGE_02_TEXT = "合同名称" ;
	
	/** 合同变更单: - 项目ID ‘03’ */
	public static final String CONTRACT_CHANGE_03 = "03" ;
	
	/** 合同变更单: - 项目ID */
	public static final String CONTRACT_CHANGE_03_TEXT = "项目ID" ;
	
	/** 合同变更单: - 合同金额 ‘04’ */
	public static final String CONTRACT_CHANGE_04 = "04" ;
	
	/** 合同变更单: - 合同金额 */
	public static final String CONTRACT_CHANGE_04_TEXT = "合同金额" ;
	
	/** 合同变更单: - 结算金额 ‘05’ */
	public static final String CONTRACT_CHANGE_05 = "05" ;
	
	/** 合同变更单: - 结算金额 */
	public static final String CONTRACT_CHANGE_05_TEXT = "结算金额" ;
	
	/** 合同变更单: - 合同签订日期 ‘06’ */
	public static final String CONTRACT_CHANGE_06 = "06" ;
	
	/** 合同变更单: - 合同签订日期 */
	public static final String CONTRACT_CHANGE_06_TEXT = "合同签订日期" ;
	
	/** 合同变更单: - 合同签订人 ‘07’ */
	public static final String CONTRACT_CHANGE_07 = "07" ;
	
	/** 合同变更单: - 合同签订人 */
	public static final String CONTRACT_CHANGE_07_TEXT = "合同签订人" ;
	
	/** 合同变更单: - 合同有效日期起 ‘08’ */
	public static final String CONTRACT_CHANGE_08 = "08" ;
	
	/** 合同变更单: - 合同有效日期起 */
	public static final String CONTRACT_CHANGE_08_TEXT = "合同有效日期起" ;
	
	/** 合同变更单: - 合同有效日期止 ‘09’ */
	public static final String CONTRACT_CHANGE_09 = "09" ;
	
	/** 合同变更单: - 合同有效日期止 */
	public static final String CONTRACT_CHANGE_09_TEXT = "合同有效日期止" ;
	
	/** 合同变更单: - 合同所属部门 ‘10’ */
	public static final String CONTRACT_CHANGE_10 = "10" ;
	
	/** 合同变更单: - 合同所属部门 */
	public static final String CONTRACT_CHANGE_10_TEXT = "合同所属部门" ;
	
	/** 合同变更单: - 甲方名称 ‘11’ */
	public static final String CONTRACT_CHANGE_11 = "11" ;
	
	/** 合同变更单: - 甲方名称 */
	public static final String CONTRACT_CHANGE_11_TEXT = "甲方名称" ;
	
	/** 合同变更单: - 甲方联系人名 ‘12’ */
	public static final String CONTRACT_CHANGE_12 = "12" ;
	
	/** 合同变更单: - 甲方联系人名 */
	public static final String CONTRACT_CHANGE_12_TEXT = "甲方联系人名" ;
	
	/** 合同变更单: - 甲方联系人电话 ‘13’ */
	public static final String CONTRACT_CHANGE_13 = "13" ;
	
	/** 合同变更单: - 甲方联系人电话 */
	public static final String CONTRACT_CHANGE_13_TEXT = "甲方联系人电话" ;
	
	/** 合同变更单: - 乙方名称 ‘14’ */
	public static final String CONTRACT_CHANGE_14 = "14" ;
	
	/** 合同变更单: - 乙方名称 */
	public static final String CONTRACT_CHANGE_14_TEXT = "乙方名称" ;
	
	/** 合同变更单: - 乙方联系人名 ‘15’ */
	public static final String CONTRACT_CHANGE_15 = "15" ;
	
	/** 合同变更单: - 乙方联系人名 */
	public static final String CONTRACT_CHANGE_15_TEXT = "乙方联系人名" ;
	
	/** 合同变更单: - 乙方联系人电话 ‘16’ */
	public static final String CONTRACT_CHANGE_16 = "16" ;
	
	/** 合同变更单: - 乙方联系人电话 */
	public static final String CONTRACT_CHANGE_16_TEXT = "乙方联系人电话" ;
	
	/** 合同变更单: - 建委备案人 ‘17’ */
	public static final String CONTRACT_CHANGE_17 = "17" ;
	
	/** 合同变更单: - 建委备案人 */
	public static final String CONTRACT_CHANGE_17_TEXT = "建委备案人" ;

	/** 合同变更单: - 建委备案日期 ‘18’ */
	public static final String CONTRACT_CHANGE_18 = "18" ;
	
	/** 合同变更单: - 建委备案日期 */
	public static final String CONTRACT_CHANGE_18_TEXT = "建委备案日期" ;
	
	/** 合同变更单: - 财务部备案人 ‘19’ */
	public static final String CONTRACT_CHANGE_19 = "19" ;
	
	/** 合同变更单: - 国财务部备案人 */
	public static final String CONTRACT_CHANGE_19_TEXT = "财务部备案人" ;
	
	/** 合同变更单: - 财务部备案日期 ‘20’ */
	public static final String CONTRACT_CHANGE_20 = "20" ;
	
	/** 合同变更单: - 财务部备案日期 */
	public static final String CONTRACT_CHANGE_20_TEXT = "财务部备案日期" ;
	
	/** 合同变更单: - 履约保函金额 ‘21’ */
	public static final String CONTRACT_CHANGE_21 = "21" ;
	
	/** 合同变更单: - 履约保函金额 */
	public static final String CONTRACT_CHANGE_21_TEXT = "履约保函金额" ;
	
	/** 合同变更单: - 履约保函日期起 ‘22’ */
	public static final String CONTRACT_CHANGE_22 = "22" ;
	
	/** 合同变更单: - 履约保函日期起 */
	public static final String CONTRACT_CHANGE_22_TEXT = "履约保函日期起" ;
	
	/** 合同变更单: - 履约保函日期止 ‘23’ */
	public static final String CONTRACT_CHANGE_23 = "23" ;
	
	/** 合同变更单: - 履约保函日期止 */
	public static final String CONTRACT_CHANGE_23_TEXT = "履约保函日期止" ;
	
	/** 合同变更单: - 履约保函开具日期 ‘24’ */
	public static final String CONTRACT_CHANGE_24 = "24" ;
	
	/** 合同变更单: - 履约保函开具日期 */
	public static final String CONTRACT_CHANGE_24_TEXT = "履约保函开具日期" ;
	
	/** 合同变更单: - 合同类别 ‘25’ */
	public static final String CONTRACT_CHANGE_25 = "25" ;
	
	/** 合同变更单: - 合同类别 */
	public static final String CONTRACT_CHANGE_25_TEXT = "合同类别" ;
	
	/** 合同变更单: - 协议关联的合同编号 ‘26’ */
	public static final String CONTRACT_CHANGE_26 = "26" ;
	
	/** 合同变更单: - 协议关联的合同编号 */
	public static final String CONTRACT_CHANGE_26_TEXT = "协议关联的合同编号" ;
	
	/** 合同变更单: - 合同当前状态 ‘27’ */
	public static final String CONTRACT_CHANGE_27 = "27" ;
	
	/** 合同变更单: - 合同当前状态 */
	public static final String CONTRACT_CHANGE_27_TEXT = "合同当前状态" ;
	
	/** 合同变更单: - 备注 ‘28’ */
	public static final String CONTRACT_CHANGE_28 = "28" ;
	
	/** 合同变更单: - 备注 */
	public static final String CONTRACT_CHANGE_28_TEXT = "备注" ;
	
	/** 合同变更单: - 编制人 ‘29’ */
	public static final String CONTRACT_CHANGE_29 = "29" ;
	
	/** 合同变更单: - 编制人 */
	public static final String CONTRACT_CHANGE_29_TEXT = "编制人" ;
	
	/** 合同变更单: - 编制人中文 ‘30’ */
	public static final String CONTRACT_CHANGE_30 = "30" ;
	
	/** 合同变更单: - 编制人中文 */
	public static final String CONTRACT_CHANGE_30_TEXT = "编制人中文" ;
	
	/** 合同变更单: - 编制日期 ‘31’ */
	public static final String CONTRACT_CHANGE_31 = "31" ;
	
	/** 合同变更单: - 编制日期 */
	public static final String CONTRACT_CHANGE_31_TEXT = "编制日期" ;
	
	/** 合同变更单: - 修改人 ‘32’ */
	public static final String CONTRACT_CHANGE_32 = "32" ;
	
	/** 合同变更单: - 修改人 */
	public static final String CONTRACT_CHANGE_32_TEXT = "修改人" ;
	
	/** 合同变更单: - 修改日期 ‘33’ */
	public static final String CONTRACT_CHANGE_33 = "33" ;
	
	/** 合同变更单: - 修改日期 */
	public static final String CONTRACT_CHANGE_33_TEXT = "修改日期" ;
	
	
	//	-------------------------------------- 单据类型列表  -----------------------------------------
	/** 单据编号 - 监理项目编号 ‘01’ */
	public static final String BILL_CODE_GENERATOR_01 = "01" ;
	
	/** 单据编号 - 监理合同编号 ‘02’ */
	public static final String BILL_CODE_GENERATOR_02 = "02" ;
	
	/** 单据编号 - 监理任务书编号 ‘03’ */
	public static final String BILL_CODE_GENERATOR_03 = "03" ;
 
	/** 编号 	- 监造项目编码 ‘04’ */
	public static final String BILL_CODE_GENERATOR_04 = "04" ;
	
	/** 编号 	- 见证单编号 ‘05’ */
	public static final String BILL_CODE_GENERATOR_05 = "05" ;
	
	/** 编号 	- 巡检记录表编号 ‘06’ */
	public static final String BILL_CODE_GENERATOR_06 = "06" ;
	
	/** 编号 	- 整改单编号 ‘07’ */
	public static final String BILL_CODE_GENERATOR_07 = "07" ;
	
	/** 编号 	- 资料编号 ‘08’ */
	public static final String BILL_CODE_GENERATOR_08 = "08" ;
	
	/** 编号 	- 档案编号 ‘09’ */
	public static final String BILL_CODE_GENERATOR_09 = "09" ;
	
	/** 编号 	- 档案借阅申请单号 ‘10’ */
	public static final String BILL_CODE_GENERATOR_10 = "10" ;
	
	/** 编号 	- 资料销毁申请单号 ‘11’ */
	public static final String BILL_CODE_GENERATOR_11 = "11" ;
	
	/** 编号 	- 档案销毁申请单号 ‘12’ */
	public static final String BILL_CODE_GENERATOR_12 = "12" ;
	
	/** 编号 	- 文件编号单号 ‘13’ */
	public static final String BILL_CODE_GENERATOR_13 = "13" ;
	
	//	-------------------------------------- 附件类型列表  -----------------------------------------
	/** 附件类型 - 供方资料附件 '01' */
	public static final String ATTACHMENT_CODE_01 = "01" ;
	
	/** 附件类型 - 招标计划导入附件 '02' */
	public static final String ATTACHMENT_CODE_02 = "02" ;
	
	/** 附件类型 - 招标计划-流程审批附件 '03' */
	public static final String ATTACHMENT_CODE_03 = "03" ;
	
	/** 附件类型 - 招标采购清单 '04' */
	public static final String ATTACHMENT_CODE_04 = "04" ;
	
	/** 附件类型 - 招标邀请-流程审批附件 '05' */
	public static final String ATTACHMENT_CODE_05 = "05" ;
	
	/** 附件类型 - 招标标书/询价函 '06' */
	public static final String ATTACHMENT_CODE_06 = "06" ;
	
	/** 附件类型 - 准备招标文件/准备询价函-流程审批附件 '07' */
	public static final String ATTACHMENT_CODE_07 = "07" ;
	
	/** 附件类型 - 招标/直接委托-发标-公告附件 '08' */
	public static final String ATTACHMENT_CODE_08 = "08" ;
	
	/** 附件类型 - 招标/直接委托-发澄清函-澄清函附件 '09' */
	public static final String ATTACHMENT_CODE_09 = "09" ;
	
	/** 附件类型 - 招标/直接委托-报价单模板 '10' */
	public static final String ATTACHMENT_CODE_10 = "10" ;
	
	//	-------------------------------------- 提醒类型列表  -----------------------------------------
	/** 提醒类型 - ‘01’ */
	public static final String MESSAGE_INFO_CODE_01 = "01" ;
	
	/** 提醒类型 - 承包合同提醒 ‘01’ */
	public static final String MESSAGE_INFO_CODE_TEXT_01 = "承包合同提醒" ;
	  

	// 操作类型: 新增 
	public static final String USER_OPER_TYPE_ADD 			= "新增" ;
	
	// 操作类型: 修改 
	public static final String USER_OPER_TYPE_MODI 			= "修改" ;
	
	// 操作类型: 删除 
	public static final String USER_OPER_TYPE_DEL 			= "删除" ;
	
	// 操作类型: 导入 
	public static final String USER_OPER_TYPE_IMP 			= "导入" ;
	
	// 操作类型: 导入 
	public static final String USER_OPER_TYPE_RESTORE		= "恢复" ;
	
	// 操作类型: 导入 
	public static final String USER_OPER_TYPE_SUBMIT		= "提交" ;
	
	// 操作类型: 导入 dq 2010-10-29
	public static final String OUT_PUT_PRINT      			= "导出" ;
	
	// 操作完成提示信息: 新增成功 
	public static final String RESULT_MESSAGE_ADD_SUCCESS 	= "新增成功" ;
	
	// 操作完成提示信息: 新增失败  
	public static final String RESULT_MESSAGE_ADD_FAILTURE 	= "新增失败" ;
	
	// 操作完成提示信息: 修改成功 
	public static final String RESULT_MESSAGE_MODI_SUCCESS 	= "修改成功" ;
	
	// 操作完成提示信息: 修改失败 
	public static final String RESULT_MESSAGE_MODI_FAILTURE = "修改失败" ;
	
	// 操作完成提示信息: 删除成功 
	public static final String RESULT_MESSAGE_DEL_SUCCESS 	= "删除成功" ;
	
	// 操作完成提示信息: 删除失败 
	public static final String RESULT_MESSAGE_DEL_FAILTURE 	= "删除失败" ;
	
	// 操作完成提示信息: 导入成功 
	public static final String RESULT_MESSAGE_IMP_SUCCESS 	= "导入成功" ;
	
	// 操作完成提示信息: 导入失败 
	public static final String RESULT_MESSAGE_IMP_FAILTURE 	= "导入失败" ;
	
	// 操作完成提示信息: 恢复成功 
	public static final String RESULT_MESSAGE_RESTORE_SUCCESS	= "恢复成功" ;
	
	// 操作完成提示信息: 恢复失败 
	public static final String RESULT_MESSAGE_RESTORE_FAILTURE	= "恢复失败" ;
	
	// 操作完成提示信息: 恢复成功 
	public static final String RESULT_MESSAGE_SUBMIT_SUCCESS	= "提交成功" ;
	
	// 操作完成提示信息: 恢复失败 
	public static final String RESULT_MESSAGE_SUBMIT_FAILTURE 	= "提交失败" ;
	
	// 操作完成提示信息: 没有数据  
	public static final String RESULT_MESSAGE_NULL 				= "没有数据" ;
	
	// 操作完成提示信息: 撤销成功  
	public static final String RESULT_MESSAGE_SUCCESS			= "撤回成功" ;
	
	// 操作完成提示信息: 撤销成功  
	public static final String RESULT_MESSAGE_FAILTURE			= "撤回失败" ;
	
//	-------------------------------------- 合同运行状态  -----------------------------------------
	/** 合同运行状态:已起草 "00" */
	public static final String CONTRACT_RUN_STATUS_00="0";
	
	/** 合同运行状态:已起草*/
	public static final String CONTRACT_RUN_STATUS_00_Text = "已起草";
	
	/** 合同运行状态:已签订 "01" */
	public static final String CONTRACT_RUN_STATUS_01="1";
	
	/** 合同运行状态:已签订*/
	public static final String CONTRACT_RUN_STATUS_01_Text = "已签订";
	
	/** 合同运行状态:已中止 "02" */
	public static final String CONTRACT_RUN_STATUS_02="2";
	
	/** 合同运行状态:已中止*/
	public static final String CONTRACT_RUN_STATUS_02_Text = "已中止";
	
	/** 合同运行状态:收货完成 "03" */
	public static final String CONTRACT_RUN_STATUS_03="3";
	
	/** 合同运行状态:收货完成*/
	public static final String CONTRACT_RUN_STATUS_03_Text = "收货完成";

//	----------------------------------------合同变更项列表 --------------------------------------------------------------
	
	/** 变更项类型 - 质保开始日期 ‘01’ */
	public static final String CONTRACT_CHANGE_TYPE_01 = "01" ;
	
	/** 变更项类型 - 质保开始日期 ‘01’ */
	public static final String CONTRACT_CHANGE_TYPE_Text_01 = "质保开始日期" ;
	
	/** 变更项类型 - 质保结束日期 ‘02’ */
	public static final String CONTRACT_CHANGE_TYPE_02 = "02" ;
	
	/** 变更项类型 - 质保结束日期 ‘02’ */
	public static final String CONTRACT_CHANGE_TYPE_Text_02 = "质保结束日期" ;
	
	/** 变更项类型 - 到货日期 ‘03’ */
	public static final String CONTRACT_CHANGE_TYPE_03 = "03" ;
	
	/** 变更项类型 - 到货日期 ‘03’ */
	public static final String CONTRACT_CHANGE_TYPE_Text_03 = "到货日期" ;
	
	/** 变更项类型 - 付款方式 ‘04’ */
	public static final String CONTRACT_CHANGE_TYPE_04 = "04" ;
	
	/** 变更项类型 - 付款方式 ‘04’ */
	public static final String CONTRACT_CHANGE_TYPE_Text_04 = "付款方式" ;	
	
	/** 变更项类型 - 物资数量 ‘05’ */
	public static final String CONTRACT_CHANGE_TYPE_05 = "05" ;
	
	/** 变更项类型 - 物资数量 ‘05’ */
	public static final String CONTRACT_CHANGE_TYPE_Text_05 = "物资数量" ;	
	
	/** 变更项类型 - 物资单价 ‘06’ */
	public static final String CONTRACT_CHANGE_TYPE_06 = "06" ;
	
	/** 变更项类型 - 物资单价 ‘06’ */
	public static final String CONTRACT_CHANGE_TYPE_Text_06 = "物资单价" ;	
	
	/** 变更项类型 - 物资备注 ‘07’ */
	public static final String CONTRACT_CHANGE_TYPE_07 = "07" ;
	
	/** 变更项类型 - 物资备注 ‘07’ */
	public static final String CONTRACT_CHANGE_TYPE_Text_07 = "物资备注" ;
	
	/** 变更项类型 - 首付款 ‘08’ */
	public static final String CONTRACT_CHANGE_TYPE_08 = "08" ;
	
	/** 变更项类型 - 首付款 ‘08’ */
	public static final String CONTRACT_CHANGE_TYPE_Text_08 = "首付款" ;
	
	/** 变更项类型 - 货到付款 ‘09’ */
	public static final String CONTRACT_CHANGE_TYPE_09 = "09" ;
	
	/** 变更项类型 - 货到付款 ‘09’ */
	public static final String CONTRACT_CHANGE_TYPE_Text_09 = "货到付款" ;
	
	/** 变更项类型 - 质保金 ‘10’ */
	public static final String CONTRACT_CHANGE_TYPE_10 = "10" ;
	
	/** 变更项类型 - 质保金 ‘10’ */
	public static final String CONTRACT_CHANGE_TYPE_Text_10 = "质保金" ;
 
//	----------------------------------------基础数据类型 --------------------------------------------------------------
	/** 基础数据类型 - 用户信息 ‘usersCache’ */
	public static final String BASE_DATA_TYPE_01 = "usersCache" ;
	
	/** 基础数据类型 - 部门信息 ‘departsCache’ */
	public static final String BASE_DATA_TYPE_02 = "departsCache" ;
	
	/** 基础数据类型 - 字典表信息 ‘dictsCache’ */
	public static final String BASE_DATA_TYPE_03 = "dictsCache" ;
	
	/** 基础数据类型 - 监理专业信息 ‘subjectsCache’ */
	public static final String BASE_DATA_TYPE_04 = "subjectsCache" ;
	
	/** 基础数据类型 - 监造专业信息 ‘conSubjectsCache’ */
	public static final String BASE_DATA_TYPE_05 = "conSubjectsCache" ;
	
	/** 基础数据类型 - 角色信息 ‘rolesCache’ */
	public static final String BASE_DATA_TYPE_06 = "rolesCache" ;
	
	/** 基础数据类型 - 监理资料类别 ‘mKindCache’ */
	public static final String BASE_DATA_TYPE_07 = "mKindCache" ;
	
}
