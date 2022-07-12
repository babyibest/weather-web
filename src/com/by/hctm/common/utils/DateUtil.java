package com.by.hctm.common.utils;

import java.text.ParseException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtil {
	// ~ Static fields/initializers
	// =============================================

	private static Log log = LogFactory.getLog(DateUtil.class);

	private static String defaultDatePattern = "yyyy-MM-dd";

	private static String timePattern = "HH:mm";

	// ~ Methods
	// ================================================================

	/**
	 * Return default datePattern (MM/dd/yyyy)
	 * 
	 * @return a string representing the date pattern on the UI
	 */
	public static String getDatePattern() {

		return defaultDatePattern;
	}

	/**
	 * This method attempts to convert an Oracle-formatted date in the form
	 * dd-MMM-yyyy to mm/dd/yyyy.
	 * 
	 * @param aDate
	 *            date from database as a string
	 * @return formatted string for the ui
	 */
	public static final String getDate(Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(getDatePattern());
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * This method generates a string representation of a date/time in the
	 * format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param strDate
	 *            a string representation of a date
	 * @return a converted Date object
	 * @see java.text.SimpleDateFormat
	 * @throws ParseException
	 */
	public static final Date convertStringToDate(String aMask, String strDate)
			throws ParseException {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(aMask);

		if (log.isDebugEnabled()) {
			log.debug("converting '" + strDate + "' to date with mask '"
					+ aMask + "'");
		}

		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			// log.error("ParseException: " + pe);
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return (date);
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static final java.sql.Date convertUtilDateToSqlDate(
			java.util.Date date) {
		java.sql.Date current = new java.sql.Date(date.getTime());
		return current;

	}

	/**
	 * This method returns the current date time in the format: MM/dd/yyyy HH:MM
	 * a
	 * 
	 * @param theTime
	 *            the current time
	 * @return the current date/time
	 */
	public static String getTimeNow(Date theTime) {
		return getDateTime(timePattern, theTime);
	}

	/**
	 * This method returns the current date in the format: MM/dd/yyyy
	 * 
	 * @return the current date
	 * @throws ParseException
	 */
	public static Calendar getToday() throws ParseException {
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat(getDatePattern());

		// This seems like quite a hack (date -> string -> date),
		// but it works ;-)
		String todayAsString = df.format(today);
		Calendar cal = new GregorianCalendar();
		cal.setTime(convertStringToDate(todayAsString));

		return cal;
	}

	/**
	 * This method generates a string representation of a date's date/time in
	 * the format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param aDate
	 *            a date object
	 * @return a formatted string representation of the date
	 * 
	 * @see java.text.SimpleDateFormat
	 */
	public static final String getDateTime(String aMask, Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null) {
			log.error("aDate is null!");
		} else {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * This method generates a string representation of a date based on the
	 * System Property 'dateFormat' in the format you specify on input
	 * 
	 * @param aDate
	 *            A date to convert
	 * @return a string representation of the date
	 */
	public static final String convertDateToString(Date aDate) {
		return getDateTime(getDatePattern(), aDate);
	}

	/**
	 * This method converts a String to a date using the datePattern
	 * 
	 * @param strDate
	 *            the date to convert (in format yyyy-mm-dd)
	 * @return a date object
	 * 
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String strDate)
			throws ParseException {
		Date aDate = null;

		try {
			if (log.isDebugEnabled()) {
				log.debug("converting date with pattern: " + getDatePattern());
			}

			aDate = convertStringToDate(getDatePattern(), strDate);
		} catch (ParseException pe) {
			log.error("Could not convert '" + strDate
					+ "' to a date, throwing exception");
			pe.printStackTrace();
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());

		}

		return aDate;
	}

//	private static final SimpleDateFormat mFormat8chars = new SimpleDateFormat(
//			"yyyyMMdd");

	private static final SimpleDateFormat mFormatIso8601Day = new SimpleDateFormat(
			"yyyy-MM-dd");

	private static final SimpleDateFormat mFormatZh = new SimpleDateFormat(
			"yyyy年MM月dd日");

	private static final SimpleDateFormat mFormatIso8601 = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssZ");

//	private static final SimpleDateFormat mFormatRfc822 = new SimpleDateFormat(
//			"EEE, d MMM yyyy HH:mm:ss z");

	/**
	 * Returns a string the represents the passed-in date parsed according to
	 * the passed-in format. Returns an empty string if the date or the format
	 * is null.
	 */
	public static String format(Date aDate, SimpleDateFormat aFormat) {
		if (aDate == null || aFormat == null) {
			return "";
		}
		return aFormat.format(aDate);
	}
	/**字符串日期转字符串日期格式格式
	 * lh
	 * @return
	 */
	public static String formatDate(String ss ,String c){
		String s1= null;
		if(ss.indexOf(c)!=0 && ss!=null && ss!=""){
			String s [] =ss.split(c);
			 s1 = s[0]+"年"+s[1]+"月"+s[2]+"日";
		}
		return s1;
	}
	
	public static String format(Date aDate, String aFormat) {
		if (aDate == null || aFormat == null) {
			return "";
		}
		return  new SimpleDateFormat(aFormat).format(aDate);
	}

	public static String getDefaultDateFormat(Date aDate) {

		return DateUtil.format(aDate, mFormatIso8601Day);
	}

	public static String getTimeFormat(Date aDate) {

		return DateUtil.format(aDate, mFormatIso8601);
	}
	
	
	
	

	/**
	 * 获取中文格式的日期格式2005年09月03日
	 * 
	 * @param data
	 * @return
	 */
	public static String getZhTimeFormat(Date data) {

		return DateUtil.format(data, mFormatZh);

	}

	public static String getDefaultDateFormat(long aDate) {
		Date date = new Date();
		date.setTime(aDate);

		return DateUtil.format(date, mFormatIso8601Day);
	}

	/**
	 * ouyangli 2005-09-07 按照需要获得符合"number值"日后的日期
	 * 
	 * @param number
	 * @return
	 */
	public static String getDateofneed(int number) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date myDate = new java.util.Date();
		long myTime = (myDate.getTime() / 1000) + 60 * 60 * 24 * number;
		myDate.setTime(myTime * 1000);
		String needDate = formatter.format(myDate);
		return needDate;
	}

	public static String getYear(Date date) {
		String currentTime = DateUtil.getDefaultDateFormat(date.getTime());
		String year = currentTime.substring(0, 4);
		// String month = currentTime.substring(5, 7);
		return year;

	}

	public static String getMonth(Date date) {
		String currentTime = DateUtil.getDefaultDateFormat(date.getTime());
		// String year = currentTime.substring(0, 4);
		String month = currentTime.substring(5, 7);
		return month;

	}

	public static String getDay(Date date) {
		String currentTime = DateUtil.getDefaultDateFormat(date.getTime());
		// String year = currentTime.substring(0, 4);
		// String month = currentTime.substring(5, 7);

		String day = currentTime.substring(8, 10);
		return day;

	}
	
	/**
	 * 根据日期生成附件上传目录结构
	 * \\2004\\09
	 * @param date
	 * @return
	 */
	public static String getDirectoryByDate(Date date){
		return getYear(date)+File.separator+getMonth(date)+File.separator;
		
		
	}
	/**
	 * 根据日期获取访问url（相对于路径）
	 * @param date
	 * @return
	 */
	public static String getUrlByDate(Date date){
		return getYear(date)+"/"+getMonth(date)+"/";
		
		
	}

	
	/**
	   * 给date添加(days,hours,minutes , seconds)时间偏移
	   * @param date		//时间基准
	   * @param days		//偏移的天数
	   * @param hours		//偏移的小时
	   * @param minutes		//偏移的分钟
	   * @param seconds		//偏移的秒数
	   * @return Date		//返回偏移后的日期
	   * @author tzc 2005-09-21 )
	   */
	  public static synchronized Date Add(Date date , int days , int hours , int minutes , int seconds) {

	      Date dt = date;
	      if(dt != null)
	      {
	      	Calendar calendar = Calendar.getInstance(); 
	      	calendar.setTime(dt); 
	    
			if(days != 0)
			{
			    calendar.add(Calendar.DATE,days);	
			}
			if(hours != 0)
			{
			    calendar.add(Calendar.HOUR ,hours);	
			}
			if(minutes != 0)
			{
			    calendar.add(Calendar.MINUTE ,minutes);	
			}
			if(seconds != 0)
			{
			    calendar.add(Calendar.SECOND ,seconds);	
			}
			dt = calendar.getTime() ;
	      }
	      return dt;
	  }
	  
	  
	  /**
	   * 获取当前年
	   * @return
	   */
	  public static int getCurrentYear(){
		  Calendar calendar = Calendar.getInstance(); 
		  return calendar.get(Calendar.YEAR);
		  
	  }
	  
	  /**
	   * 获取当前月
	   * @return
	   */
	  public static int getCurrentMonth(){
		  Calendar calendar = Calendar.getInstance(); 
		  return calendar.get(Calendar.MONTH)+1;
		  
	  }
	  
	  /**
	   * 获取当前天
	   * @return
	   */
	  public static int getCurrentDay(){
		  Calendar calendar = Calendar.getInstance(); 
		  return calendar.get(Calendar.DAY_OF_MONTH);
		  
	  }
	  /**
	   * 获取当前中文格式的日期格式2005年09月03日
	   * 
	   * @param data
	   * @return
	   */
	   public static String getCurrentZhTimeFormat() {
		  return DateUtil.format(new Date(), mFormatZh);
	   }
	  /**
	   * 获取当前天星期
	   * @return
	   */
	  public static String getCurrentWeekDay(){
		  Calendar calendar = Calendar.getInstance(); 
		  int weekInteger=calendar.get(Calendar.DAY_OF_WEEK);
		  String week="";
			switch(weekInteger){
				case 1:week="日";break;
				case 2:week="一";break;
				case 3:week="二";break;
				case 4:week="三";break;
				case 5:week="四";break;
				case 6:week="五";break;
				case 7:week="六";break;
			}
		  return week;
		  
	  }
	  /**
	   * 获取星期
	   * @return
	   */
	  public static String getCurrentWeekDay(Date date){
		  Calendar calendar = new GregorianCalendar(); 
		  calendar.setTime(date); 
		  int weekInteger=calendar.get(Calendar.DAY_OF_WEEK);
		  String week="";
			switch(weekInteger){
				case 1:week="日";break;
				case 2:week="一";break;
				case 3:week="二";break;
				case 4:week="三";break;
				case 5:week="四";break;
				case 6:week="五";break;
				case 7:week="六";break;
			}
		  return week;
		  
	  }
	  public static void main(String[] args) {
		  System.out.println( DateUtil.getDateTime( "yyyy-MM-dd hh:mm:ss ", new Date() )) ;
	  }
}
