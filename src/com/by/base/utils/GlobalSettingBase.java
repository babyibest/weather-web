package com.by.base.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author 代长�?
 */
public class GlobalSettingBase {

	/**
	 * Logger for this class
	 */
	private static final Log log = LogFactory.getLog(GlobalSettingBase.class);

	private static Properties globalSetting = null;

	// 附件默认上传目录
	private static String default_attachment_upload_location = "/TEMP-GENERATOR/ATTACHMENT/";

	static {
		InputStream is = GlobalSettingBase.class.getClassLoader()
				.getResourceAsStream("globalSetting.properties");
		Properties pro = new Properties();

		try {
			pro.load(is);
		} catch (IOException e) {
			log.error("load file globalSetting.properties error", e);
		}
		
		globalSetting = pro;
	}

	/**
	 * 获取附件上传相对路径
	 * @return
	 */
	public static String getAttachmentUploadLoaction() {
		String location = globalSetting
				.getProperty("attachment_upload_location");
		if (StringUtil.isBlank(location)) {
			location = default_attachment_upload_location;
		}
		return location;
	}

	/**
	 * 获取每页显示记录�?
	 * 
	 * @return
	 * @throws IOException
	 */
	public static int getMaxPageSize() {

		String maxResultInPage = globalSetting.getProperty("maxPageSize");
		return Integer.parseInt(maxResultInPage);
	}
	
	/**
	 * 获取每页显示记录�?
	 * @return
	 * @throws IOException
	 */
	public static int getMaxQueryPageSize() {
		String maxResultInPage = globalSetting.getProperty("maxQueryPageSize");
		return Integer.parseInt(maxResultInPage);
	}
	
	/**
	 * 获取每页显示记录�?
	 * @return
	 * @throws IOException
	 */
	public static int getMaxPageSize(int increasedR)  {
		String maxResultInPage = globalSetting.getProperty("maxPageSize");
		return Integer.parseInt(maxResultInPage)+increasedR;
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public static int getMaxIndexPages() {
		String maxResultInPage = globalSetting.getProperty("maxIndexPages");
		return Integer.parseInt(maxResultInPage);
	}

	/**
	 * get globalSetting.properties
	 * @param key
	 * @return
	 */
	public static String getGlobalSettingProperty(String key) {
		log.debug("Fetching property [" + key + "="
				+ globalSetting.getProperty(key) + "]");
		return globalSetting.getProperty(key);
	}

	/**
	 * 接受word文件上传的servlet部署的请求地�?
	 * @param type 类型定义，区别接受的是那种服务，类型定义看当前类中下面的定义
	 * @return
	 */
	public static String getWebTraceServerDeployAddress(String type){
		return getGlobalSettingProperty("wordfile_webTraceServlet_deployAddress")+"/WebTraceServlet?type="+type;
	}
	
	/**
	 * 接受word文件上传的servlet部署的服务器地址
	 * @return
	 */
	public static String getWebTraceServerDeployAddress(){
		return getGlobalSettingProperty("wordfile_webTraceServlet_deployAddress");
	}
	
	/**
	 * nas 服务器地�?��用于存放附件
	 * <p>采用HTTP协议</p>
	 * @return
	 */
	public static String getAttachdmentPlacedHttpAddress(){
		return getGlobalSettingProperty("attachment_placed_http_address");
	}

	/**
	 * nas 服务器地�?��用于存放附件
	 * <p>采用FTP协议</p>
	 * @return
	 */
	public static String getAttachdmentPlacedFtpAddress(){
		return getGlobalSettingProperty("attachment_placed_ftp_address");
	}

	/**
	 * nas 服务器地�?��口，用于存放附件
	 * <p>采用FTP协议</p>
	 * @author Ted 2010-05-27 
	 * @return
	 */
	public static String getAttachdmentPlacedFtpAddressPort(){
		return getGlobalSettingProperty("attachment_placed_ftp_address_port") ;
	}
	
	/**
	 * 文件服务器的访问用户�? FTP )
	 * <p>采用FTP协议</p>
	 * @return
	 */
	public static String getFileServerFtpUser(){
		return getGlobalSettingProperty("fileserver_ftp_user");
	}
	
	/**
	 * 文件服务器的访问用户名的密码( FTP )
	 * <p>采用FTP协议</p>
	 * @return
	 */
	public static String getFileServerFtpPassword(){
		return getGlobalSettingProperty("fileserver_ftp_password");
	}
	 
	/**
	 * 取得用javascript将Html中的表单数据导入到Excel中的错误提示信息
	 * 
	 * @author tzc 2006-06-01
	 */
	public static String getJavascript_create_excel_cueinfo() {
		String sTemp = getGlobalSettingProperty("javascript_create_excel_cueinfo");
		
		return sTemp;
	}
  
	/**
	 * 当前的使用应用名�?
	 * @return
	 */
	public static String getCurrentAppName(){
		return getGlobalSettingProperty("system_current_appname");
	}
	
	/**
	 * 当前的使用单位名�?
	 * @return
	 */
	public static String getCurrentUseName(){
		return getGlobalSettingProperty("system_current_usename");
	}
	
	public static String getProjectMode(){
		return getGlobalSettingProperty("project_mode");
	}
	
	public static boolean ifDebugMode(){
		boolean rValue = false ;
		
		if("true".equals( getGlobalSettingProperty("debug_mode") ) ) {
			rValue = true ;
		}
		
		return  rValue ;
	}

	public static Properties getGlobalSetting() {
		return globalSetting;
	}
	 
}
