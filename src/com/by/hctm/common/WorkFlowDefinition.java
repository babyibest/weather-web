/**
 * 
 */
package com.by.hctm.common;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;

import com.by.hctm.common.utils.XmlUtil;

/**
 * @author Ted 工作流定义
 * 
 */
public class WorkFlowDefinition {
	/**
	 * Logger for this class
	 */
	private static final Log logger = LogFactory
			.getLog(WorkFlowDefinition.class);

	private static Document document = null;

	static {
		initWorkFlowStatus() ;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Document getDefinitionDocument() {
		if (document == null) {
			try {
				document = XmlUtil.parse(WorkFlowDefinition.class.
						getClassLoader().getResourceAsStream("workflow-definition.xml"));
			} catch (DocumentException e) {
				logger.error("读取workflow-definition.xml文件出错！"+e);
			}

		}
		return document;
	}

	/**
	 *根据类型查找当前的流程 
	 * @param usage
	 * @return
	 */
	public static String getTemplateName(String usage) {
		String name = "" ;
		
		Node node = getDefinitionDocument().selectSingleNode("//workflow/template[@usage='"
				+ usage + "']");
		
		if( node != null )
			name = node.valueOf("@name");
		
		return name;

	}
	
	/**
	 * 根据流程类型取当前状态值
	 * @param usage 流程类型
	 * @param position 第几个状态值 
	 * @author Ted 2010-05-31 
	 * @return
	 */
	public static String getWorkFlowTemplateStatus(String usage, int position ) {
		String rValue = "000" ;
		
		String name = getTemplateName( usage ) ;
		
		if(  name != null && position >0 ) {
			String [] strarr = name.split(",") ;
			
			if( strarr != null && strarr.length>=position ) {
				rValue = strarr[position-1] ;
			}
		}
		
		return rValue;
	}

	/**
	 * 初始化流程状态信息
	 * @author Ted 2010-05-31 
	 */
	private static void initWorkFlowStatus( ) {
		
		// 取得流程数量
		int wfcount = Integer.parseInt( getTemplateName( "workflowcount" ) ) ;
		
		String [] statusArr = null ;
		String [] textArr = null ;
		
		for( int i=1; i<=wfcount; i++ ) {
			
			//
			statusArr = getTemplateName( "workflowStatus" + i ).split( "," ) ;
			textArr   = getTemplateName( "workflowStatusText" + i ).split( "," ) ;
			
			initStatusSwitch(statusArr, textArr, i ) ;
		}
		
 	}
	
	/**
	 * 设置流程状态
	 * @param statusArr
	 * @param textArr
	 * @param i
	 */
	private static void initStatusSwitch(String [] statusArr, String [] textArr, int i ) {
		switch( i ){
			case 1: {  
				// 物资需求计划审批流程定义
				initStatusMap(statusArr, textArr, WorkFlowStatusMap.getWorkflowStatusMap1() ); break;
			} 
			case 2 :{
				// 物资需求计划汇总审批流程定义
				initStatusMap(statusArr, textArr, WorkFlowStatusMap.getWorkflowStatusMap2() ); break;
			}
			case 3: {  
				// 合同付款审批流程定义
				initStatusMap(statusArr, textArr, WorkFlowStatusMap.getWorkflowStatusMap3() ); break;
			} 
			case 4 :{
				// 合同签订审批流程定义
				initStatusMap(statusArr, textArr, WorkFlowStatusMap.getWorkflowStatusMap4() ); break;
			}
			case 5: {  
				// 物资领料单审批流程定义
				initStatusMap(statusArr, textArr, WorkFlowStatusMap.getWorkflowStatusMap5() ); break;
			} 
			case 6 :{
				// 物资退料单审批流程定义
				initStatusMap(statusArr, textArr, WorkFlowStatusMap.getWorkflowStatusMap6() ); break;
			}
			case 7: { 
				// 特需物资领料单审批流程定义
				initStatusMap(statusArr, textArr, WorkFlowStatusMap.getWorkflowStatusMap7() ); break;
			}
		}
	}
	
	/**
	 * 流程状态赋值 
	 * @param statusArr
	 * @param textArr
	 * @param wfStatus
	 */
	private static void  initStatusMap( String [] statusArr, String [] textArr, Map<String, String> wfStatus ) {
		
		if( statusArr != null && textArr != null ) {
			
			for(int i=0; i<statusArr.length; i++ ) {
				wfStatus.put(statusArr[i], textArr[i]) ;
			}
		}
	}
	
	/**
	 * 取第一个节点状态值
	 * @param workflowType 流程类型 
	 * @return
	 */
	public static String getFirstNodeWorkFlowStatus( String workflowType ) {
		String rValue = "000" ;
		
		String name = getTemplateName( workflowType ) ;
		
		if(  name != null && name.length() >0 ) {
			String [] strarr = name.split(",") ;
			
			if( strarr != null && strarr.length>0 ) {
				rValue = strarr[0] ;
			}
		}
		
		return rValue;
	}
	
	/**
	 * 取最后节点状态值
	 * @param workflowType 流程类型 
	 * @return
	 */
	public static String getEndNodeWorkFlowStatus( String workflowType ) {
		String rValue = "000" ;
		
		String name = getTemplateName( workflowType ) ;
		
		if(  name != null && name.length() >0 ) {
			String [] strarr = name.split(",") ;
			
			if( strarr != null && strarr.length>0 ) {
				rValue = strarr[strarr.length-1] ;
			}
		}
		
		return rValue;
	}
	
	public static void main(String[] args) {
		System.out.println( WorkFlowDefinition.getEndNodeWorkFlowStatus("workflowStatusText5") ) ;
		
		WorkFlowDefinition.initWorkFlowStatus() ;
	}
}
