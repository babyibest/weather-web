package com.by.hctm.common;

import com.by.base.exception.BaseException;
import com.by.hctm.common.biz.ISystemCodeGeneratorBiz;
import com.by.hctm.common.entity.SystemCodeGenerator;
import com.by.hctm.common.utils.StringUtil;

public class CodeGeneratorUtil {

	/**
	 * 编号生成器, 按年重置(年度（四位）+月份（二位）+流水号（4位，从0001开始）)
	 * @param codeType 单据编码标识 
	 * @return
	 * @throws BaseException
	 */
	public static String geGeneratCommonCode(  String codeType  ) throws BaseException {
		String rValue = "" ;
		if( StringUtil.isNotBlank( codeType ) ){
			rValue = iSystemCodeGeneratorBiz.geGeneratCommonCode( new SystemCodeGenerator(codeType ) ) ;
		}
		
		return rValue ;
	}
	
	/**
	 * 编号生成器, 按年重置(监理项目编号、监造项目编码、监理合同编号)
	 * @param codeType 单据编码标识 
	 * @param deptCode 部门编码(下发部门编码/合同签订部门编码) 
	 * @return
	 * @throws BaseException
	 */
	public static String geGeneratCommonCode(  String codeType, String deptCode ) throws BaseException {
		String rValue = "" ;
		if( StringUtil.isNotBlank( codeType ) && StringUtil.isNotBlank( deptCode ) ){
			rValue = iSystemCodeGeneratorBiz.geGeneratCommonCode( new SystemCodeGenerator(codeType, deptCode ) ) ;
		}
		
		return rValue ;
	}
	
	/**
	 * 编号生成器, 按年重置(监理任务书编号)
	 * @param codeType 单据编码标识 
	 * @param deptCode 下发部门编码 
	 * @param dept2Code 接收部门编码 
	 * @return
	 * @throws BaseException
	 */
	public static String geGeneratCommonCode(  String codeType, String deptCode, String dept2Code ) throws BaseException {
		String rValue = "" ;
		if( StringUtil.isNotBlank( codeType ) && StringUtil.isNotBlank( deptCode ) && StringUtil.isNotBlank( dept2Code )){
			rValue = iSystemCodeGeneratorBiz.geGeneratCommonCode( new SystemCodeGenerator(codeType, deptCode, dept2Code ) ) ;
		}
		
		return rValue ;
	}
	
	private static ISystemCodeGeneratorBiz iSystemCodeGeneratorBiz ;
	
	public static ISystemCodeGeneratorBiz getISystemCodeGeneratorBiz() {
		return iSystemCodeGeneratorBiz;
	}

	public static boolean setISystemCodeGeneratorBiz(
			ISystemCodeGeneratorBiz systemCodeGeneratorBiz) {
		iSystemCodeGeneratorBiz = systemCodeGeneratorBiz;
		return true; 
	}
   
}
