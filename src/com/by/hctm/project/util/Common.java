package com.by.hctm.project.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {

	/**
	 * //将date型转换成yyyy-MM-dd HH:mm:ss的String
	 * @param date 日期
	 * @return
	 */
	public static String getStringFromDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * 将String日期转换成Timestamp
	 * @param str
	 * @return
	 */
	public static Timestamp getTimestampFromString(String str){
		return Timestamp.valueOf(str);
	}
}
