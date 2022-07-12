package com.by.hctm.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListUtil {

	/**
	 * List 追加
	 * @param src	//源List
	 * @param dest	//目的List
	 * @author ted 2005-12-14
	 */
	public static void listappend( List src,List dest ){
		if( src != null && src.size() > 0 ){
			if( dest == null ){
				dest = new ArrayList();
			}
			
			for( int i = 0; i < src.size(); i ++ ){
				if( src.get(i) != null ){
					dest.add( src.get(i) );
				}
			}
		}
		
	}
	
	/**
	 * 实现List的随机排序
	 * @param src	//原List
	 * @return dest //返回排序后的List
	 * @author ted 2006-07-03
	 */
	public static List randomsort( List src ){
		List dest = null;
		List temp = new ArrayList( src );
		
		if( temp != null && temp.size() >= 0 ){
			dest = new ArrayList();
			Random generator = new Random();
			
			int iSelNum = 0;
			while( temp.size() > 0 ){
				iSelNum = generator.nextInt( temp.size() );
		  		
				dest.add( temp.get( iSelNum ) );
				temp.remove( iSelNum );
	  		}
		} 
		
		return dest;
	}
	public static void main(String[] args) {
//		List la = new ArrayList();
//		la.add( "a" );
//		la.add( "b" );
//		la.add( "c" );
//		
//		List lb = new ArrayList();
//		lb.add( "d" );
//		lb.add( "e" );
//		lb.add( "f" );
//		
//		ListUtil.listappend( lb,la );
//		System.out.println( " aaaaaaaaaaaaa" + la );
//		System.out.println( " bbbbbbbbbbbbb" +lb );
		
//		List vl = new ArrayList();
//  		vl.add( new Integer( 0 ));
//  		vl.add( new Integer( 1 ));
//  		vl.add( new Integer( 2 ));
//  		vl.add( new Integer( 3 ));
//  		vl.add( new Integer( 4 ));
//  		vl.add( new Integer( 5 ));
//  		vl.add( new Integer( 6 ));
//  		vl.add( new Integer( 7 ));
//  		vl.add( new Integer( 8 ));
//  		vl.add( new Integer( 9 ));
//  		
//  		vl = ListUtil.randomsort( vl );
//  		
//  		for( int i = 0; i < vl.size() ; i ++ ){
//  			System.out.println( " -- " + i + " == " + vl.get(i)  )	;
//    	}
	}
}
