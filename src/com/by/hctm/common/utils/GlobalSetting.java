package com.by.hctm.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.by.base.utils.GlobalSettingBase;

/**
 * @author 代长伟
 */
public class GlobalSetting extends GlobalSettingBase {

	/**
	 * Logger for this class
	 */
	private static final Log log = LogFactory.getLog(GlobalSetting.class);
	
	/**
	 * 获取Http路径
	 * @return
	 */
	public static String getHttp() {
		return getGlobalSetting().getProperty("template_http_address");
	}
	
	/**
	 * 获取合同上传相对路径
	 * @return
	 */
	public static String getContractUploadLoaction() {
		return getGlobalSetting().getProperty("contract_upload_location");
	}

	/**
	 * 获取合同模板相对路径
	 * @return
	 */
	public static String getContractTempletLoaction() {
		return getGlobalSetting().getProperty("contract_templet_location");
	}
	
	/**
	 * 获取结算申请书模板相对路径
	 * @return
	 */
	public static String getCashupTempletLoaction() {
		return getGlobalSetting().getProperty("cashup_templet_location");
	}
	/**
	 * 获取监理资料模板相对路径
	 * @return
	 */
	public static String getMaterialTempletLoaction() {
		return getGlobalSetting().getProperty("material_templet_location");
	} 
	/**
	 * 获取监造报告模板相对路径
	 * @return
	 */
	public static String getConstructReportTempletLoaction() {
		return getGlobalSetting().getProperty("constructReport_templet_location");
	} 
	/**
	 * 获取招标文件模板相对路径
	 * @return
	 */
	public static String getBidFileTempletLoaction() {
		return getGlobalSetting().getProperty("bidfile_templet_location");
	}
  

	/**
	 * 获取当前系统使用用户
	 * @return
	 */
	public static String getSystemCurrentUsename() {
		return getGlobalSetting().getProperty("system_current_usename");
	}
	
	/**
	 * 判断当前系统是否是开发模式
	 * @return
	 */
	public static boolean isDebugMode() {
		return "true".equals( getGlobalSetting().getProperty("debug_mode") ) ? true : false ;
	}
	
	/** 发送邮件信息 begin */
	public static boolean getMailMode(){
		return "true".equals( getGlobalSettingProperty("mail_mode") ) ? true : false ;
	}
	
	public static String getMailUser(){
		return getGlobalSettingProperty("mail_user");
	}
	
	public static String getMailPwd(){
		return getGlobalSettingProperty("mail_pwd");
	}
	
	public static String getMailAddress(){
		return getGlobalSettingProperty("mail_address");
	}
	
	public static String getMailPop3Address(){
		return getGlobalSettingProperty("mail_pop3_address");
	}
	
	public static String getMailSmtpAddress(){
		return getGlobalSettingProperty("mail_smtp_address");
	}
	
	public static String getMailImapAddress(){
		return getGlobalSettingProperty("mail_imap_address");
	}
	
	/** 发送邮件信息 end */
	
	/** 发送短信信息 begin */
	
	public static boolean getSmsMode(){
		return "true".equals( getGlobalSettingProperty("sms_mode") ) ? true : false ;
	}
	
	public static String getSmsUsername(){
		return getGlobalSettingProperty("sms_username");
	}
	
	public static String getSmsUserpwd(){
		return getGlobalSettingProperty("sms_userpwd");
	}
	
	public static String getSmsSendUrl(){
		return getGlobalSettingProperty("sms_send_url");
	}
	
	public static String getSmsReceiveUrl(){
		return getGlobalSettingProperty("sms_receive_url");
	}
	
	public static String getSmsSendReportUrl(){
		return getGlobalSettingProperty("sms_send_report_url");
	}
	
	/** 发送短信信息 end */
	
}
