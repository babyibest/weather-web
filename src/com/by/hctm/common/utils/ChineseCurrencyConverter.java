package com.by.hctm.common.utils;

public class ChineseCurrencyConverter {
	    /**
	    * 将数字（ Double ）金额转换为中文金额
	    * @param  vdMoney //转换前的数字金额
	    * @return String  //返回转换后的中文金额
	    */
	    public static String convertChineseCurrency( Double vdMoney ) {
	    	return convertChineseCurrency( vdMoney.doubleValue() );
	    }
	    
	    /**
	     * 将数字（ double ）金额转换为中文金额
	     * @param vdMoney //转换前的数字金额
	     * @return String //返回转换后的中文金额
	     */
	    public static String convertChineseCurrency( double vdMoney ) {
	    	
	    	//中文金额单位数组
	    	String[] straChineseUnit = new String[] {"分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟","万"};
	    	//中文数字字符数组
	    	String[] straChineseNumber = new String[] {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
	    	
	    	
	        String strChineseCurrency = "";
	        //零数位标记
	        boolean bZero = true;
	        //中文金额单位下标
	        int ChineseUnitIndex = 0;

	        try {
	            if ( vdMoney == 0 )
	                return "零圆整";

	            //处理小数部分，四舍五入
	            double doubMoneyNumber = Math.round( vdMoney * 100);

	            //是否负数
	            boolean bNegative = doubMoneyNumber < 0;

	            //取绝对值
	            doubMoneyNumber = Math.abs(doubMoneyNumber);

	            //循环处理转换操作
	            while (doubMoneyNumber > 0) {
	            	
	                //整的处理(无小数位)
	                if (ChineseUnitIndex == 2 && strChineseCurrency.length() == 0)
	                    strChineseCurrency = strChineseCurrency + "整";

	                //非零数位的处理
	                if (doubMoneyNumber % 10 > 0) {
	                    strChineseCurrency = straChineseNumber[(int)( (long)doubMoneyNumber % 10 )] + straChineseUnit[ChineseUnitIndex] + strChineseCurrency;
	                    bZero = false;
	                } else { //零数位的处理
	                    //元的处理(个位)
	                    if (ChineseUnitIndex == 2 ) {
	                        //段中有数字
	                        if (doubMoneyNumber > 0) {
	                            strChineseCurrency = straChineseUnit[ChineseUnitIndex] + strChineseCurrency;
	                            bZero = true;
	                        }
	                    }
	                    
	                    //前一数位非零的处理
	                    if (!bZero)
	                        strChineseCurrency = straChineseNumber[0] + strChineseCurrency;

	                    if (ChineseUnitIndex == 6 || ChineseUnitIndex == 10) {  //万、亿数位的处理
	                        //段中有数字
	                        if (doubMoneyNumber % 1000 > 0)
	                            strChineseCurrency = straChineseUnit[ChineseUnitIndex] + strChineseCurrency;
	                    }
	                    
	                    bZero = true;
	                }

	                doubMoneyNumber = Math.floor(doubMoneyNumber / 10);
	                ChineseUnitIndex ++;
	            }

	            //负数的处理
	            if (bNegative)
	                strChineseCurrency = "负" + strChineseCurrency;
	        }
	        catch (Exception e) {
	           
	            e.printStackTrace();

	            return "";
	        }

	        return strChineseCurrency;
	    }

	    /**
	     * 将数字（ double ）转换为中文
	     * @param vdMoney //转换前的数字
	     * @return String //返回转换后的中文
	     */
	    public static String convertChineseNumber( Long vdMoney ) {
	    	
	    	//中文数字字符数组
	    	String[] straChineseNumber = new String[] {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
	    	
	        String strChineseCurrency = "";
	        //零数位标记
	        boolean bZero = true;
	        //中文金额单位下标
	        int ChineseUnitIndex = 0;

	        try {
	            if ( vdMoney == 0 )
	                return "零";

	            //处理小数部分，四舍五入
	            double doubMoneyNumber = Math.round( vdMoney * 100);
//	            long doubMoneyNumber = vdMoney ;
	            
	            //是否负数
	            boolean bNegative = doubMoneyNumber < 0;

	            //取绝对值
	            doubMoneyNumber = Math.abs(doubMoneyNumber);

	            //循环处理转换操作
	            while (doubMoneyNumber > 0) {
	            	
	                //整的处理(无小数位)
	                if (ChineseUnitIndex == 2 && strChineseCurrency.length() == 0)
	                    strChineseCurrency = strChineseCurrency  ;

	                //非零数位的处理
	                if (doubMoneyNumber % 10 > 0) {
	                    strChineseCurrency = straChineseNumber[(int)( (long)doubMoneyNumber % 10 )] + strChineseCurrency;
	                    bZero = false;
	                } else { //零数位的处理
	                    //元的处理(个位)
	                    if (ChineseUnitIndex == 2 ) {
	                        //段中有数字
	                        if (doubMoneyNumber > 0) {
	                            strChineseCurrency =  strChineseCurrency;
	                            bZero = true;
	                        }
	                    }
	                    
	                    //前一数位非零的处理
	                    if (!bZero)
	                        strChineseCurrency = straChineseNumber[0] + strChineseCurrency;

	                    if (ChineseUnitIndex == 6 || ChineseUnitIndex == 10) {  //万、亿数位的处理
	                        //段中有数字
	                        if (doubMoneyNumber % 1000 > 0)
	                            strChineseCurrency =  strChineseCurrency;
	                    }
	                    
	                    bZero = true;
	                }

	                doubMoneyNumber = Math.floor(doubMoneyNumber / 10);
	                ChineseUnitIndex ++;
	            }

	            //负数的处理
	            if (bNegative)
	                strChineseCurrency = "负" + strChineseCurrency;
	        }
	        catch (Exception e) {
	           
	            e.printStackTrace();

	            return "";
	        }

	        return strChineseCurrency;
	    }
	    
	    public static void main(String[] args) {
//	    	ChineseCurrencyConverter cc = new ChineseCurrencyConverter();
//	    	System.out.println( "5435436078333.69" + cc.convertChineseCurrency( 5435436078333.69 ) );
//	    	System.out.println( "6078333.69" + cc.convertChineseCurrency( 6078333.69 ) );
	    	//System.out.println( "58561930.36" + cc.convertChineseCurrency( 58561930.36 ) );
	    	//System.out.println( "906080" + cc.convertChineseCurrency( 906080 ) );
	    	//System.out.println( "32906580" + cc.convertChineseCurrency( 32906580 ) );
	    	//System.out.println( "32906581" + cc.convertChineseCurrency(32906581 ) );
//	    	System.out.println( "32906081.79" + ChineseCurrencyConverter.convertChineseCurrency(32906081.79 ) );
	    	System.out.println( " 1 = " + ChineseCurrencyConverter.convertChineseNumber( new Long(5954332) ) );
		}
}
