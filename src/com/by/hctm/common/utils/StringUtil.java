package com.by.hctm.common.utils;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.servlet.http.HttpServletRequest;

/*
 * Created on 2005-4-14
 * Author LiuQing
 */
public class StringUtil {
	
	// 数据类型 S 字符串类型 
	public static String DATA_TYPE_STRING 	= "S" ;
	// 数据类型 N 数字类型 
	public static String DATA_TYPE_NUMBER 	= "N" ;
	// 数据类型 D 日期类型
	public static String DATA_TYPE_DATE 	= "D" ;
	
	/**
	 * 判断字符串是否为“”或null
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		if (str == null || str.equals("")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断对象是否为“”或null
	 * @param str
	 * @return
	 */
	public static boolean isBlank(Object str) {
		if (str == null) {
			return true;
		} else {
			if ( ("").equals( str.toString() ) ) {
				return true;
			}
			return false;
		}
	}
	
	/**
	 * 判断字符串是否非“”或null
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		if (str == null || str.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 判断对象是否非“”或null
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(Object str) {
		if (str == null) {
			return false;
		} else {
			if ( ("").equals( str.toString() ) ) {
				return false;
			}
			return true;
		}
	}
	
	/**
	 * 判断对象是否相等,根据toString
	 * @param value1
	 * @param value2
	 * @return
	 */
	public static boolean isEquals(Object value1, Object value2) {
		if( isNotBlank( value1 ) && isNotBlank( value2) ) {
			if ( value1.toString().equals( value2.toString() ) ) {
				return true;
			} else {
				return false;
			}
		}else {
			return false ;
		}
	}
	
	/**
	 * 判断对象是否不相等,根据toString
	 * @param value1
	 * @param value2
	 * @return
	 */
	public static boolean isNotEquals(Object value1, Object value2) {
		if( isNotBlank( value1 ) && isNotBlank( value2) ) {
			if ( value1.toString().equals( value2.toString() ) ) {
				return false;
			} else {
				return true;
			}
		}else {
			return true ;
		}
	}
	
	/**
	 * 将字符串转化成Long型
	 * 
	 * @param var
	 * @return
	 */
	public static Long LongConverter(String var) {
		if (isBlank(var)) {
			return null;
		} else {

			return new Long(var);
		}

	}

	/**
	 * 获取类的名称
	 * 
	 * @param clazz
	 * @return
	 */
	public static String getClassName(Class clazz) {
		String name = clazz.getName();
		int lastDot = name.lastIndexOf(".");
		return name.substring(lastDot + 1);

	}

	/**
	 * 将null转换成“”
	 * 
	 * @param str
	 * @return
	 */
	public static String convertNullToBlank(String str) {
		if (str == null) {
			return "";

		} else {
			return str;

		}

	}

	/**
	 * 将null值转化成&nbsp;
	 * 
	 * @param str
	 * @return
	 */
	public static String convertNullToHtmlBlank(String str) {
		if (str == null) {
			return "&nbsp;";

		} else {
			return str;

		}

	}

	/**
	 * 将null或“”转换成&nbsp;
	 * 
	 * @param str
	 * @return
	 */
	public static String convertBlankToHtmlBlank(String str) {
		if (str == null || str.trim().equals("") || str.trim().equals("null")) {
			return "&nbsp;";

		} else {
			return str;

		}

	}

	public static String convertBlankToHtmlBlank(Object str) {
		if (str != null) {
			return convertBlankToHtmlBlank(str.toString());

		} else {

			return "&nbsp;";
		}

	}

	public static String convertNullToBlank(Object str) {
		if (str != null) {
			return convertNullToBlank(str.toString());

		} else {

			return "";
		}

	}
	/**
	 * 将null转换成“”  格式化日期 yyyy-mm-dd hh:mm:ss
	 * 
	 * @param str
	 * @return
	 */
	public static String convertNullToBlankFormat(Object str) {
		if (str != null) {
			String str1 = convertNullToBlank(str.toString());
			int index = str1.lastIndexOf(".");
			if( index>0 )
				str1 = str1.substring(0,index);
			return str1;
		} else {

			return "";
		}

	}

	/**
	 * 将null转换成“”
	 * 
	 * @param str
	 * @return
	 */
	public static String convertNullToBlankAndTrim(String str) {
		if (str == null) {
			return "";

		} else {
			return str.trim();

		}

	}
	
	/**
	 * <b>保留字符串</b>
	 * 
	 * @param number
	 * @param digit
	 * @return
	 */
	public static String getDecimal(String number, int digit) {
		String decimal = "";
		if (number.indexOf('.') != -1) {
			if (number.indexOf('.') + (digit + 1) > number.length())
				decimal = number.substring(0, number.length());
			else
				decimal = number
						.substring(0, number.indexOf('.') + (digit + 1));
		} else {
			decimal = number;
		}

		return decimal;
	}

	/**
	 * <b>得到两个字符串相加后的值</b>
	 * 
	 * @param money1
	 * @param money2
	 * @return
	 */
	public static String getStringValue(String money1, String money2) {

		String money = "0.00";

		if (money1 == null)
			money1 = "0.00";

		if (money2 == null)
			money2 = "0.00";

		money = StringUtil.doubleToStringForUpdate(new Double(""
				+ (Double.parseDouble(money1) + Double.parseDouble(money2))));

		return money;
	}

	/**
	 * 保留小数 liuqing2005-09-28
	 * 
	 * @param number
	 * @param step保留几位小数
	 * @return
	 */
	public static String formateNumber(double number) {
		if (number == 0) {
			return "-";

		}
		// 保留小数
		String format = "###.00";
		
		DecimalFormat df = new DecimalFormat(format);
		return df.format(number);

	}
	
	/**
	 * 保留小数 
	 * 
	 * @param number
	 * @param boolean judgeZero
	 * @param step保留几位小数
	 * @return String
	 * @author tzc 2006-11-24
	 */
	public static String formateNumber(double number,boolean judgeZero ) {
		if( judgeZero ){
			if (number == 0) {
				return "-";	
			}
		}
		// 保留小数
		String format = "###.00";
		
		DecimalFormat df = new DecimalFormat(format);
		return df.format(number);

	}

	public static String parseDecimalFormat(double number, int step) {
		if (number == 0) {
			return "-";

		}
		// 保留小数
		String format = "###,###.";
		for (int i = 0; i < step; i++) {
			format += "0";

		}
		DecimalFormat df = new DecimalFormat(format);
		String decimal = df.format(number);
		return decimal;
		// 格式化金额
		// NumberFormat usFormat = NumberFormat.getNumberInstance(Locale.US);
		// return usFormat.format(Double.parseDouble(decimal));

	}
	/**
	 * 将字符串根据“，”分解
	 * @param numStr
	 * @return
	 */
    public static String splitStringDecimal(String numStr ){
    	String str = "";
    	if(numStr.equals("")||numStr.equals("-")||numStr.equals("&nbsp")||numStr.equals("null")||numStr.equals(" ")){
    		str = "0.00";
    		return str;
    	}else{
	    	String[] numStrArray = numStr.split(",");
	    	for(int i = 0;i<numStrArray.length;i++){
	    		str +=numStrArray[i];
	    	}
	    	return str;
    	}
    }
	/**
	 * 转换数字显示格式
	 * 
	 * @param number
	 *            //需要转换的数字
	 * @param step
	 *            //需要保留的小数位数
	 * @param zerodispay
	 *            //数字为零时的显示形式
	 * @param isthousand
	 *            //是否需要千分号显示
	 * @return String //返回转换后的格式
	 */
	public static String parseDecimalFormat(double number, int step,
			String zerodispay, boolean isthousand) {
		if (number == 0) {
			return zerodispay;
		}
		// 保留小数
		String format = null;

		// 千分号显示
		if (isthousand) {
			format = "000,000.";
		} else {
			format = "0.";
		}

		for (int i = 0; i < step; i++) {
			format += "0";
		}
		DecimalFormat df = new DecimalFormat(format);
		String decimal = df.format(number);
		return decimal;
		// // 格式化金额
		// NumberFormat usFormat = NumberFormat.getNumberInstance(Locale.US);
		// return usFormat.format(Double.parseDouble(decimal));

	}

	/**
	 * 转换数字显示格式
	 * 
	 * @param number
	 *            //需要转换的数字
	 * @param step
	 *            //需要保留的小数位数
	 * @param zerodispay
	 *            //数字为零时的显示形式
	 * @param isthousand
	 *            //是否需要千分号显示
	 * @return String //返回转换后的格式
	 */
	public static String parseDecimalFormat(Double number, int step,
			String zerodispay, boolean isthousand) {
		double doubleNumber = 0;
		if (number != null)
			doubleNumber = number.doubleValue();
		return parseDecimalFormat(doubleNumber, step, zerodispay, isthousand);
	}

	/**
	 * 缺省的显示格式
	 * 
	 * @param number
	 *            //需要转换的数字
	 * @return String //返回转换后的格式 ( 保留两位小数位 )
	 */
	public static String default_parseDecimalFormat(double number) {
		return parseDecimalFormat(number, 2, "0.00", false);
	}

	/**
	 * 缺省的显示格式
	 * 
	 * @param number
	 *            //需要转换的数字
	 * @return String //返回转换后的格式 ( 保留两位小数位 )
	 */
	public static String default_parseDecimalFormat(Double number) {
		return parseDecimalFormat(number, 2, "0.00", false);
	}

	public static String parseDecimalFormat(double number) {
		return parseDecimalFormat(number, 2);

	}

	public static String parseDecimalFormat(Double number) {
		return parseDecimalFormat(number, 2);

	}

	public static String parseDecimalFormat(Object number) {
		if (number == null) {
			return "-";
		}
		return parseDecimalFormat(new Double(number.toString()), 2);

	}

	public static Double convertObject(Object obj) {
		if (obj == null || obj.toString().length() == 0)
			return new Double(0);
		else {
			return new Double(obj.toString());
		}
	}

	/**
	 * 
	 * @param number
	 * @param step
	 * @return
	 */
	public static String parseDecimalFormat(Double number, int step) {
		double doubleNumber = 0;
		if (number != null)
			doubleNumber = number.doubleValue();
		return parseDecimalFormat(doubleNumber, step);
	}

	/**
	 * <b>判断对象是否是null值</b>
	 * 
	 * @param object
	 * @return
	 */
	public static boolean estimateObject_Null(Object object) {
		boolean estimate = false;
		if (object != null && !object.toString().trim().equals("")
				&& !object.toString().equals("")
				&& !object.toString().equals("&nbsp;")
				&& !object.toString().equals("-")
				&& !object.toString().equals("null"))
			estimate = true;

		return estimate;
	}

	/**
	 * <b>字符串转换</b>
	 * 
	 * @param anumber
	 * @return
	 */
	public static String doubleToString(Object object) {

		Double number = null;
		/* 使用本地的locale来初始NumberFormat */
		DecimalFormat decimalFormat = new DecimalFormat("###,##0.00");

		/* 判断所传值 */
		if (object != null && !object.toString().equals("")
				&& !object.toString().equals("-")) {

			try {

				if (object instanceof Double)
					number = (Double) object;
				else if (object instanceof String)
					number = new Double(object.toString());
				else
					number = new Double(0);

				return decimalFormat.format(number);

			} catch (NumberFormatException e) {

				throw new NumberFormatException("在方法 doubleToString() 数值类型错误 "
						+ object.toString());

			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException(
						"在方法 doubleToString() format 数值类型错误");

			}

		} else {
			return "-";
		}
	}

	/**
	 * <b>字符串转换</b>
	 * 
	 * @param anumber
	 * @return
	 */
	public static String doubleToStringForUpdate(Object object) {
		if (object == null || object.toString().equals(""))
			object = "0.00";

		/* 使用本地的locale来初始NumberFormat */
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);

		try {

			String number = doubleToString(object);
			if (number.equals("-"))
				return "0.00";
			else
				return numberFormat.parse(number).toString();
		} catch (ParseException e) {

			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @return
	 */
	public static String getHtmlValue() {
		return "&nbsp;";
	}

	/**
	 * 
	 * @param line
	 * @param oldString
	 * @param newString
	 * @return
	 */
	public static final String replace(String line, String oldString,
			String newString) {
		if (line == null) {
			return null;
		}
		int i = 0;
		if ((i = line.indexOf(oldString, i)) >= 0) {
			char[] line2 = line.toCharArray();
			char[] newString2 = newString.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = line.indexOf(oldString, i)) > 0) {
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			return buf.toString();
		}
		return line;
	}

	/**
	 * 
	 * @param line
	 * @param oldString
	 * @param newString
	 * @return
	 */
	public static final String replaceIgnoreCase(String line, String oldString,
			String newString) {
		if (line == null) {
			return null;
		}
		String lcLine = line.toLowerCase();
		String lcOldString = oldString.toLowerCase();
		int i = 0;
		if ((i = lcLine.indexOf(lcOldString, i)) >= 0) {
			char[] line2 = line.toCharArray();
			char[] newString2 = newString.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = lcLine.indexOf(lcOldString, i)) > 0) {
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			return buf.toString();
		}
		return line;
	}

	/**
	 * 将gbk字符转成ISO各式
	 * 
	 * @param gbkStr
	 * @return
	 */

	public static String getISO(String gbkStr) {
		try {
			return new String(gbkStr.getBytes("GBK"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			return gbkStr;
		}

	}

	public static String getGBK(String gbkStr) {
		try {
			return new String(gbkStr.getBytes("ISO-8859-1"), "GBK");
		} catch (UnsupportedEncodingException e) {
			return gbkStr;
		}

	}

	/**
	 * ted
	 * 
	 * @param request
	 * @param name
	 * @return
	 */
	public static String getAttribute(HttpServletRequest request, String name) {

		String rName = "";
		Object nameObj = request.getAttribute(name);
		if (nameObj != null) {
			rName = nameObj.toString();

		}
		return rName;

	}

	/**
	 * 取数字的中文
	 * 
	 * @param viNumber
	 *            //数字
	 * @return String //返回数字的中文
	 * @author tzc 2006-02-26
	 */
	public static String getChineseNumber(int viNumber) {
		String sChineseNumber = "";

		// 中文数字单位数组
		String[] straChineseUnit = new String[] { "", "十", "百", "千", "万", "十",
				"百", "千", "亿", "十", "百", "千" };

		// 中文数字字符数组
		String[] straChineseNumber = new String[] { "零", "一", "二", "三", "四",
				"五", "六", "七", "八", "九" };

		double iDeal = Math.abs(viNumber);

		// 中文单位下标
		int ChineseUnitIndex = 0;

		// 零数位标记
		boolean bZero = true;

		// 循环处理转换操作
		while (iDeal > 0) {

			// 非零数位的处理
			if (iDeal % 10 > 0) {
				sChineseNumber = straChineseNumber[(int) iDeal % 10]
						+ straChineseUnit[ChineseUnitIndex] + sChineseNumber;
				bZero = false;
			}
			// 零数位的处理
			else {
				// 元的处理(个位)
				if (ChineseUnitIndex == 2) {
					// 段中有数字
					if (iDeal > 0) {
						sChineseNumber = straChineseUnit[ChineseUnitIndex]
								+ sChineseNumber;
						bZero = true;
					}
				}
				// 万、亿数位的处理
				else if (ChineseUnitIndex == 6 || ChineseUnitIndex == 10) {
					// 段中有数字
					if (iDeal % 1000 > 0)
						sChineseNumber = straChineseUnit[ChineseUnitIndex]
								+ sChineseNumber;
				}

				// 前一数位非零的处理
				if (!bZero)
					sChineseNumber = straChineseNumber[0] + sChineseNumber;

				bZero = true;
			}

			iDeal = Math.floor(iDeal / 10);
			ChineseUnitIndex++;
		}

		return sChineseNumber;
	}
	
	public static void main(String[] args) {
		// System.out.println( " 1: " + StringUtil.getChineseNumber( 1 ) );
		// System.out.println( " 2: " + StringUtil.getChineseNumber( 2 ) );
		// System.out.println( " 3: " + StringUtil.getChineseNumber( 3 ) );
		// System.out.println( " 4: " + StringUtil.getChineseNumber( 4 ) );
		// System.out.println( " 5: " + StringUtil.getChineseNumber( 5 ) );
		// System.out.println( " 10: " + StringUtil.getChineseNumber( 10 ) );
		// System.out.println( " 12: " + StringUtil.getChineseNumber( 12 ) );
		// System.out.println( " 1597545165: " + StringUtil.getChineseNumber(
		// 1597545165 ) );
		// String totalPrice = "689200.2";
		// Double totalPriceFormat = Double.valueOf(totalPrice);
		StringUtil ss = new StringUtil();
		String sss = ss.splitStringDecimal("22222,000.00");
		
		System.out.println(" " + sss);
	
	
		 System.out.println( StringUtil.formateNumber(4.0) );
		 
		 String val = ss.parseDecimalFormat( 0.186 );
		 int ind = val.indexOf(".");
		 System.out.println( ind );
		 if( ind == 0 ){
			 val = "0" + val;
		 }
		 System.out.println( "val=" + val);
		 
		 
		 System.out.println(  "-----------" + ss.formateNumber( 0 , false ) ) ;
		 
		 //------------------------------------------------------------------------
		 DecimalFormat df = new DecimalFormat( ".##");
		 double va = 1870.245  + 0.001 ;
		 double va2 = 58800.104999999996 ;
		 System.out.println( "------------------------------------" + ss.round( va2 ) );
	     String decimal = df.format( va );
	     String decimal2 = df.format( va2 );
	     System.out.println(decimal);
	     System.out.println(decimal2);
		 System.out.println( "===========================" + ss.default_parseDecimalFormat( new Double(1870.245) ) );
		 
		 double ja = Math.round( 1870.245 * 100.0 ) / 100;
		 System.out.println( "----------" + ja );
		 
		 String index = va2+"";
		 int ind_1 = index.indexOf( "." );
		 System.out.println( "---------" + index.substring( ind_1 +3 , ind_1+4 ) );
		 if( index.substring( ind_1 + 3 , ind_1+4 ).equals("5") ){
			 System.out.println("==================OKOKOKOKOOOKOKOKKKKKKKKKKKKKO");
		 }
		 
		 //////////////////////////////////////////////////////////////////////////
		 int ind_2 = index.indexOf( "-" );
		 System.out.println( " ========= " + ind_2);
		
		 
		 String va3 = va2 + "";
		 if( va3.equals( "1870.245" )){
			 System.out.println( "oooooooooooooooooooooookkkkkkkkkkkkkkkkkkkkkk" );
		 }
		 
//		 System.out.println(  StringUtil.getChineseNumber( 123321.55 ) ) ;
		 
		 System.out.println( StringUtil.formateNumber(0.00, false) )  ;
		 System.out.println( StringUtil.formateNumber(0, false ) )  ;
	}
	
	/**
	 * 
	 * @param priceRate
	 * @return
	 */
	public static String parseDecimalFormatByRate(double priceRate){
		String price = parseDecimalFormat(priceRate, 2, "-", false);
		System.out.println(price);
		String returnPrice = "";
		if(price.indexOf("-") > -1){
			
			if(price.equals("-")){
				
				returnPrice = price;
			}else{
				returnPrice = "-" + Float.parseFloat(price.substring(1))*1 ;
			}
		}else{
			returnPrice = "" + Float.parseFloat(price)*1 ;
		}
		
		return returnPrice;
	}
	/**
	 * 对于页面处理需要的URL的处理
	 * @param vsURL	//原连接
	 * @return String //转换后的URL
	 * @author tzc 2006-07-21
	 */
	public static String replaceURL( String vsURL ){
		String stemp = vsURL;
		
		if( stemp != null ){
			int ipoint = stemp.indexOf( "?" );
			stemp = stemp.substring(0,ipoint ) + "88-88" + stemp.substring( ipoint + 1 );
			
			ipoint = stemp.indexOf( "." );
			stemp = stemp.substring(0,ipoint ) + "88--88" + stemp.substring( ipoint + 1 );
			
			stemp = stemp.replaceAll( "/","88---88");
			
			stemp = stemp.replaceAll( "&","88----88");
			
			stemp = stemp.replaceAll( "=","88-----88");
		}
		
		return stemp;
	}
	
	/**
	 * 对于页面处理需要的URL处理后的复原
	 * @param vsReURL	//原连接
	 * @return String //转换后的URL
	 * @author tzc 2006-07-21
	 */
	public static String replaceReturnURL( String vsReURL ){
		String stemp = vsReURL;
		
		if( stemp != null ){
			stemp = stemp.replaceAll( "88-----88","=");
			stemp = stemp.replaceAll( "88----88","&" );
			stemp = stemp.replaceAll( "88---88","/" );
			stemp = stemp.replaceAll( "88--88","." );
			stemp = stemp.replaceAll( "88-88","?" );
		}
		
		return stemp;
	}
	
	/**
	 * 去掉字符串中 -- &nbsp;
	 * @param vsStr //待处理字符串
	 * @return String //处理后字符串
	 * @author tzc 2007-06-26
	 */
	public static String replacedStrnbsp( String vsStr ){
		String sTemp = vsStr;
		
		if( sTemp != null ){
			sTemp.replaceAll( "&nbsp;","" );
		}
		
		return sTemp;
	}
	
	
	////////////////////////////////////////////////////////
	 //对一个浮点数字保留两位。
	public static double round(double v){
	        BigDecimal b = new BigDecimal(Double.toString(v));
	        BigDecimal one = new BigDecimal("1");
	        return b.divide(one,2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	//对一个浮点数字保留位。
	public static double round(double v,int w){
	        BigDecimal b = new BigDecimal(Double.toString(v));
	        BigDecimal one = new BigDecimal("1");
	        return b.divide(one,w,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static boolean isInteger(String str){
		  if(str==null )
		   return false;
		  Pattern pattern = Pattern.compile("[0-9]+");
		  return pattern.matcher(str).matches();
		 }

	public static boolean isDecimal(String str) {
		  if(str==null || "".equals(str))
		   return false;  
		  Pattern pattern = Pattern.compile("[0-9]*(\\.?)[0-9]*");
		  return pattern.matcher(str).matches();
		 }

	public   static    String StringFilter(String str )   throws    PatternSyntaxException    {      
        // 只允许字母和数字        
        // String    regEx   =   "[^a-zA-Z0-9]";                      
           // 清除掉所有特殊字符   
	   String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\][^0-9.]\"<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";   
	   Pattern    p    =    Pattern.compile(regEx);      
	   Matcher    m    =    p.matcher(str);      
	  return    m.replaceAll("").trim();      
	} 
	
	/**
	 * 判断字符串是否为NULL、空、""、&nbsp; 并赋初值
	 * 
	 * @param str
	 *            字符串
	 * @param type
	 *            S 字符串类型 N 数字类型 D 日期类型
	 * 
	 * @return
	 */
	public static String convertStringFormat(String str, String type) {
		if (str == null || str.equals("null") || str.equals("")
				|| str.equals("&nbsp;")) {
			if ( type.equals( StringUtil.DATA_TYPE_STRING ) ) {
				str = ""; // 字符串类型
			
			}else if (type.equals( StringUtil.DATA_TYPE_NUMBER )) {
				str = "0"; // 数字类型
			
			}else if (type.equals( StringUtil.DATA_TYPE_DATE )) {
				str = DateUtil.getDateTime("yyyy-MM-dd", new Date()); // 日期类型
			}
		}
		return str.trim();
	}
	
	/**
	 * 将"null"转换成"";
	 * 
	 * @param str
	 * @return
	 */
	public static String convertBlankToEmptryBlank(String emptry) {
		if (emptry == null || emptry.trim().equals("") || emptry.trim().equals("null")) {
			return "";

		} else {
			return emptry;

		}

	}
}
