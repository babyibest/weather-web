package com.by.hctm.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jxls.XLSTransformer;

/**
 * 
 * @author Ted
 * 
 */
public class ExcelUtil extends XLSTransformer {
	//需求计划模版
	public String REQUIRED_PLAN_TEMPLET_NAME = "/com/wellsoon/mms/templet/requiredplan.xls";
	//推荐厂家模版
	public String RECOMMAND_COMPANY_TEMPLET_NAME = "/com/wellsoon/mms/templet/companyrecommend.xls";

	/**
	 * 
	 * @param templetName
	 * @return
	 */
	private InputStream getTempletInputStream(String templetName) {

		InputStream io = ExcelUtil.class.getResourceAsStream(templetName);
		return io;
	}

	/**
	 * 导出excel
	 * 
	 * @param beanParams
	 *            数据源
	 * @param templetName
	 *            模版名称
	 * @param response
	 * @param writeFilName
	 *            写入文件明
	 */
	public void expExcel(Map beanParams, String templetName, HttpServletResponse response,
			String writeFilName) {

		try {
			InputStream is = getTempletInputStream(templetName);
			
			HSSFWorkbook workBook = transformXLS(is, beanParams);
			response.setContentType("application/octet-stream");
			writeFilName = new String(writeFilName.getBytes("GBK"), "ISO-8859-1");

			if (!writeFilName.endsWith(".xls")) {
				writeFilName += ".xls";
			}

			response.addHeader("Content-Disposition", "attachment; filename=\"" + writeFilName
					+ "\"");

			response.setHeader("Accept-ranges", "bytes");

			OutputStream outp = response.getOutputStream();
			workBook.write(outp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 读取excel中所有信息
	 * @param filePath 文件路径
	 * @author ted 2007-06-08
	 * @return 二维数组集
	 * @throws FileNotFoundException 
	 */
	public String[][] readExcel(String filePath)  {
		InputStream is = null ;
		try{
			is = new FileInputStream(filePath);
		}catch( FileNotFoundException fnfe ){
			System.out.print(" 文件未找到！") ;
			fnfe.printStackTrace() ;
		}
		return readExcel( is ) ;
	}
	
	/**
	 * 读取excel中所有信息
	 * @param is 文件输入流
	 * @author ted 2007-06-08
	 * @return 所的信息以二维数组集返回
	 */
	public String[][] readExcel(InputStream is) {
		String[][] strTemp = null;
		try {
			Workbook wb = Workbook.getWorkbook(is);
			Sheet rs = wb.getSheet(0);
			int rows = rs.getRows();
			int cols = rs.getColumns();

			strTemp = new String[rows][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					Cell c = rs.getCell(j, i);
					strTemp[i][j] = c.getContents().trim();
				}
			}
			wb.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return strTemp;
	}
	
	/**
	 * 读取供应商批量修改
	 * @param is 文件输入流
	 * @return
	 * 2010-03-22  gw add 
	 */
	public String[][] readExcelSupplierInfo( InputStream is ){
		String[][] strTemp = null;
		try {
			Workbook wb = Workbook.getWorkbook(is);
			Sheet rs = wb.getSheet(0);
			int rows = rs.getRows();
			int cols = 	27;			// rs.getColumns();
			
			strTemp = new String[rows][cols];
			for (int i = 1; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					Cell c = rs.getCell(j, i);
					strTemp[i][j] = c.getContents() == null ? "" : c.getContents().trim();
					if( j == 0 && strTemp[i][j].equals( "" ) ){
						strTemp[i][j] = strTemp[i - 1 ][j];
					}
					//System.out.print( "&&&" + strTemp[i][j].length() + "&&&");
				}//for
				//System.out.println("-------------------------------------------------------------------");
			}
			wb.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return strTemp;
	}

	/**
	 * 读取供应商批量修改
	 * @param is 文件输入流
	 * @return
	 * 2010-03-22  gw add 
	 */
	public String[][] readMaterialStorageExcel( InputStream is ){
		String[][] strTemp = null;
		try {
			Workbook wb = Workbook.getWorkbook(is);
			Sheet rs = wb.getSheet(0);
			int rows = rs.getRows();
			int cols = 6; 
			
			strTemp = new String[rows][cols];
			for (int i = 1; i < rows; i++) {
				for( int j = 0 ; j < cols ; j ++ ){
					Cell c  = rs.getCell( j , i );
					strTemp[ i-1 ][ j ] = c.getContents() == null ? "" : c.getContents().trim();
					strTemp[ i-1 ][ j ] = strTemp[ i-1 ][ j ].replaceAll( "??" , "" );
				}
			}
			wb.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return strTemp;
	}
	
	/**
	 * 读取物资需求计划批量修改
	 * @param is 文件输入流
	 * @return
	 * 2010-05-17  jinxin
	 */
	public String[][] readExcelReqMaterialInfo( InputStream is ){
		String[][] strTemp = null;
		try {
			Workbook wb = Workbook.getWorkbook(is);
			Sheet rs = wb.getSheet(0);
			int rows = rs.getRows();
			int cols = 9; //rs.getColumns();
			
			strTemp = new String[rows][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					Cell c = rs.getCell(j, i);
					strTemp[i][j] = c.getContents() == null ? "" : c.getContents().trim();
					if( j == 0 && strTemp[i][j].equals( "" ) ){
						strTemp[i][j] = strTemp[i - 1 ][j];
					}
				}//for
			}
			wb.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return strTemp;
	}
	
	/**
	 * 读取报价汇总批量修改
	 * @param is 文件输入流
	 * @return
	 * 2010-05-17  jinxin
	 */
	public String[][] readExcelBidPriceAa( InputStream is ){
		String[][] strTemp = null;
		try {
			Workbook wb = Workbook.getWorkbook(is);
			Sheet rs = wb.getSheet(0);
			int rows = rs.getRows();
			int cols = 15; //rs.getColumns();
			
			strTemp = new String[rows][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					Cell c = rs.getCell(j, i);
					strTemp[i][j] = c.getContents() == null ? "" : c.getContents().trim();
					if( j == 0 && strTemp[i][j].equals( "" ) ){
						strTemp[i][j] = strTemp[i - 1 ][j];
					}
				}//for
			}
			wb.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return strTemp;
	}
	
	/**
	 * 读取EXCEL内容
	 * @param is 文件输入流
	 * @param columnCount 指定EXCEL列的数量
	 * @param allColumn	  是否动态取所有列
	 * @author ted 2010-08-04
	 * @return EXCEL内容
	 */
	public String[][] readExcel( InputStream is, int columnCount, boolean allColumn ){
		String[][] strTemp = null;
		try {
			Workbook wb = Workbook.getWorkbook(is);
			Sheet rs = wb.getSheet(0);
			int rows = rs.getRows();
			int cols = columnCount; //rs.getColumns();
			
			if( allColumn )
				cols = rs.getColumns() ;
			
			strTemp = new String[rows][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					Cell c = rs.getCell(j, i);
					strTemp[i][j] = c.getContents() == null ? "" : c.getContents().trim();
					if( j == 0 && strTemp[i][j].equals( "" ) ){
						strTemp[i][j] = strTemp[i - 1 ][j];
					}
					
					// 如果总价未填写, 直接读取公式则赋值为空 Ted 2012-02-21 
					if( "sump".equals( strTemp[i][j] ) ) {
						if("4".equals( strTemp[i][j-2] ) ) {
							strTemp[i][j-2] = "" ;
						}
					}
				}//for
			}
			
			wb.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return strTemp;
	}
	
	/**
	 * 读取excel表 批量导入招标计划信息 
	 * @param is 文件输入流
	 * @return
	 * 2011-05-11  RenLiChao add
	 */
	public String[][] readExcelProjectPlanInfo( InputStream is ){
		String[][] strTemp = null;
		try {
			Workbook wb = Workbook.getWorkbook(is);
			Sheet rs = wb.getSheet(0);
			int rows = rs.getRows();
			int cols = 13; //rs.getColumns();
			
			strTemp = new String[rows][cols];
			for (int i = 1; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					Cell c = rs.getCell(j, i);
					strTemp[i][j] = c.getContents() == null ? "" : c.getContents().trim();
					if( j == 0 && strTemp[i][j].equals( "" ) ){
						strTemp[i][j] = strTemp[i - 1 ][j];
					}
				}
			}
			wb.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return strTemp;
	}
	
	/**
	 * 读取excel表 批量导入一类招标计划信息 
	 * @param is 文件输入流
	 * @return
	 * 2011-05-11  ted add
	 */
	public String[][] readExcelProjectPlanFristInfo( InputStream is ){
		String[][] strTemp = null;
		try {
			Workbook wb = Workbook.getWorkbook(is);
			Sheet rs = wb.getSheet(0);
			int rows = rs.getRows();
			int cols = 12; //rs.getColumns();
			
			strTemp = new String[rows][cols];
			for (int i = 1; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					Cell c = rs.getCell(j, i);
					strTemp[i][j] = c.getContents() == null ? "" : c.getContents().trim();
					if( j == 0 && strTemp[i][j].equals( "" ) ){
						strTemp[i][j] = strTemp[i - 1 ][j];
					}
				}
			}
			wb.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return strTemp;
	}
	
	public String[][] readBidPurchaseDetail( InputStream is ){
		String[][] strTemp = null;
		try {
			Workbook wb = Workbook.getWorkbook(is);
			//Object obj = wb.getSheet(0);
			Sheet [] tt = wb.getSheets() ;
//			Sheet rs = (Sheet)wb.getSheet(0);
			Sheet rs = tt[0];
			int rows = 500;//rs.getRows();
			int cols = 9;//rs.getColumns();
			
			strTemp = new String[rows][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					
					// Ted 
					if( j == 6 || j == 7 )
						continue ;
					
					Cell c = rs.getCell(j, i);
					strTemp[i][j] = c.getContents() == null ? "" : c.getContents().trim();
					if( j == 0 && strTemp[i][j].equals( "" ) ){
						//strTemp[i][j] = strTemp[i - 1 ][j];
					}
				}
			}
			wb.close();
		} catch (Exception ex) {
			strTemp = null ;
			try {
				is.close() ;
			} catch (IOException e) {
				e.printStackTrace();
			}
			ex.printStackTrace();
		}
		return strTemp;
	}
	
	/**
	 * 生成加密后文件
	 * @param filepath 
	 * @param pis
	 * @author ted 2011-06-01 
	 * @return
	 */
	public static File createEncryTempFile(String filepath  ){
		try{
		  String fileName = "加密后文件.xls";
	      Random random = new Random();
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

	      fileName = sdf.format(new Date()) + "_" + String.valueOf(random.nextInt(900) + 100) + ".xls";

	      File filefolt = new File(filepath);
	      if (!(filefolt.exists()))
	        filefolt.mkdirs();

	      File file = new File(filepath + fileName);
	      WritableWorkbook workbook = Workbook.createWorkbook(file);

	      WritableSheet sheet = workbook.createSheet("加密后文件", 0);

	      
	      workbook.write();
	      workbook.close();
	      return file;
	      
		}catch(Exception e){
		  System.out.println(e);
		  return null;
		}
	}
	
	/**
	 * 读取EXCEL内容
	 * @param is 文件输入流
	 * @param columnCount 指定EXCEL列的数量
	 * @param allColumn	  是否动态取所有列
	 * @author ted 2010-08-04
	 * @return EXCEL内容
	 */
	public String[][] readExcelByPOI( InputStream is, int columnCount, boolean allColumn ){
		
		// 
		String[][] strTemp = null;
		
		try {
			HSSFWorkbook wb = new HSSFWorkbook( is );
			
			// 取第一个工作表
			HSSFSheet sheet = wb.getSheetAt(0); 
			
			int allrows 	= sheet.getLastRowNum()+1;
			int cols 		= columnCount; //rs.getColumns();
			
			if( allColumn )
				cols 		= 10 ;
			
			strTemp 		= new String[allrows][cols];
			
			HSSFRow row 	= null ;
			HSSFCell cell 	= null ;
			String cValue1 	= "" ;
			
			for (int i = 0; i < allrows ; i++) {
				// 循环得到行
	            row 		= sheet.getRow(i); 
	            for (int j = 0; j < cols; j++) {
	            	
	            	
	            	// 循环得到单元格
	                cell 	= row.getCell( (short) j ) ; 
	                
	                if (cell != null) { //如果是空值则会抛出异常，所以要判断
	                	
	                    //数据类型一定要匹配才可以读取值，要不然也会抛出异常
	                    if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
	                        cValue1 	= cell.getStringCellValue() ;
	                        if( cValue1 != null && cValue1.length()>0 )
	                        	strTemp[i][j] 	= cValue1 ;
	                    } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
	                        cValue1 	= String.valueOf( cell.getNumericCellValue() ) ;
	                        if( cValue1 != null && cValue1.length()>0 )
	                        	strTemp[i][j] 	= cValue1 ;
	                    }
	                }
	            }
	        }
			
		} catch (Exception ex) {
			strTemp = null ;
			ex.printStackTrace();
		}
		
		return strTemp;
	}
	
	/**
	 * 读取excel中所有信息
	 * @param filePath 文件路径
	 * @param columnCount 指定EXCEL列的数量
	 * @param allColumn	  是否动态取所有列
	 * @author ted 2007-06-08
	 * @return 二维数组集
	 * @throws FileNotFoundException 
	 */
	public String[][] readExcel(String filePath, int columnCount, boolean allColumn )  {
		InputStream is = null ;
		try{
			is = new FileInputStream(filePath);
		}catch( FileNotFoundException fnfe ){
			System.out.print(" 文件未找到！") ;
			fnfe.printStackTrace() ;
		}
		return readExcel( is, columnCount, allColumn ) ;
	}
	
}
