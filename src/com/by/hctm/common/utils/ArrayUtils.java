package com.by.hctm.common.utils;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ArrayUtils extends org.apache.commons.lang.ArrayUtils {
	/**
	 * String数组转换成字符串
	 * 
	 * @param array
	 * @return
	 */
	public static String toString(String[] array) {

//		String returnStr = "";
		StringBuffer returnStr = new StringBuffer( "" ) ;
		for (int i = 0; i < array.length; i++) {

			if (i == 0) {
				returnStr.append( array[i] ) ;

			} else {

				returnStr.append( "," ) ;
				returnStr.append( array[i] ) ;
			}

		}
		return returnStr.toString() ;

	}
	
	/**
	 * String数组转换成Set集合
	 * @param array 
	 * @return Set集合
	 * @author Ted 2006-12-04
	 */
	public static Set arryToSet(String[] array){
		Set rSet = new TreeSet();
		for (int i = 0; i < array.length; i++) {
			rSet.add(array[i]);
		}
		
		return rSet ;
	}
	
	/**
	 * 根据分割符类型把Ser集合转化为字符串
	 * @param tSet Ser集合
	 * @param spType 分割符类型
	 * @return 字符串
	 * @author Ted 2006-12-04
	 */
	public static String setToStringBySplit(Set tSet, String spType){
		StringBuffer rValue = new StringBuffer("") ; 
		String defaultType 	= "," ;
		
		if( spType!=null && spType.length()>0 )
			defaultType 	= spType ;
			
		if(tSet != null ){
			int i=0;
			for(Iterator iter = tSet.iterator(); iter.hasNext(); ){
				if(i == tSet.size()-1)
					rValue.append( iter.next().toString() + "");
				else
					rValue.append( iter.next().toString() + defaultType);
				
				i++ ;
			}
		}
		
		return rValue.toString() ;
	}
	
	/**
	 * 将数组进行非空检验
	 * @param obj
	 */
	public static void arrayBlankUtil(Object[] obj){
		if (obj == null) return;
		for(int i= 0;i< obj.length;i++){
			if(obj[i] == null){
				obj[i] = "";
			}
		}
		
	}
	
	public static void main(String[] args){
		String[] aa = {"11",null,"33",};
		arrayBlankUtil(aa);
		System.out.println(aa.length);
		for(int i=0;i<aa.length;i++){
			System.out.print(aa[i]);
		}
		System.out.println("dfffff");
		System.out.println(aa[1]);
	}
	
	/**
	 * String数组转换成字符串
	 * 
	 * @param array
	 * spType 
	 * @return
	 */
	public static String toString(String[] array, String spType ) {

//		String returnStr = "";
		StringBuffer returnStr = new StringBuffer( "" ) ;
		for (int i = 0; i < array.length; i++) {

			if (i == 0) {
				returnStr.append( array[i] ) ;

			} else {

				returnStr.append( spType ) ;
				returnStr.append( array[i] ) ;
			}

		}
		return returnStr.toString() ;

	}
	
}
