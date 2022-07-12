package com.by.hctm.common.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.TableStatus;
import com.by.hctm.common.biz.ISystemCodeGeneratorBiz;
import com.by.hctm.common.entity.SystemCodeGenerator;
import com.by.hctm.common.utils.DateUtil;
import com.by.hctm.common.utils.StringUtil;

public class SystemCodeGeneratorBizImpl extends BaseBizImpl implements ISystemCodeGeneratorBiz  {
	
	/**
	 * 根据主键获得单据编码表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public SystemCodeGenerator getSystemCodeGenerator(Long id) throws BaseException {
		return (SystemCodeGenerator)this.getObject(SystemCodeGenerator.class, id);
	}
	
	/**
	 * 获得单据编码表实例
	 * @param systemCodeGenerator 单据编码表实例
	 * @return
	 * @throws BaseException 
	 */
	public SystemCodeGenerator getSystemCodeGenerator( SystemCodeGenerator systemCodeGenerator ) throws BaseException {
		return (SystemCodeGenerator)this.getObject(SystemCodeGenerator.class, systemCodeGenerator.getCgId() );
	}
	
	/**
	 * 添加单据编码信息
	 * @param systemCodeGenerator 单据编码表实例
	 * @throws BaseException 
	 */
	public void saveSystemCodeGenerator(SystemCodeGenerator systemCodeGenerator) throws BaseException{
		this.saveObject( systemCodeGenerator ) ;
	}
	
	/**
	 * 更新单据编码表实例
	 * @param systemCodeGenerator 单据编码表实例
	 * @throws BaseException 
	 */
	public void updateSystemCodeGenerator(SystemCodeGenerator systemCodeGenerator) throws BaseException{
		this.updateObject( systemCodeGenerator ) ;
	}
	
	/**
	 * 删除单据编码表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteSystemCodeGenerator(String id) throws BaseException {
		this.removeObject( this.getSystemCodeGenerator( new Long(id) ) ) ;
	}
	
	/**
	 * 删除单据编码表实例
	 * @param systemCodeGenerator 单据编码表实例
	 * @throws BaseException 
	 */
	public void deleteSystemCodeGenerator(SystemCodeGenerator systemCodeGenerator) throws BaseException {
		this.removeObject( systemCodeGenerator ) ;
	}
	
	/**
	 * 删除单据编码表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteSystemCodeGenerators(String[] id) throws BaseException {
		this.removeBatchObject(SystemCodeGenerator.class, id) ;
	}
	
	/**
	 * 获得所有单据编码表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List getSystemCodeGeneratorList( RollPage rollPage  ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from SystemCodeGenerator de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有单据编码表数据集
	 * @param systemCodeGenerator 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getSystemCodeGeneratorList(  SystemCodeGenerator systemCodeGenerator ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from SystemCodeGenerator scg where 1 = 1 " );

		if ( !StringUtil.isBlank( systemCodeGenerator.getCgCode() )) {
			hql.append( " and scg.cgCode = '" ).append( systemCodeGenerator.getCgCode() ).append( "'" ) ;
		}
		
		if ( !StringUtil.isBlank( systemCodeGenerator.getCgName() )) {
			hql.append( " and scg.cgName = '" ).append( systemCodeGenerator.getCgName() ).append( "'" ) ;
		}
		
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有单据编码表数据集
	 * @param rollPage 分页对象
	 * @param systemCodeGenerator 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getSystemCodeGeneratorList( RollPage rollPage, SystemCodeGenerator systemCodeGenerator ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from SystemCodeGenerator de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 编号生成器, 按年重置(监理项目编号、监造项目编码、监理合同编号、监理任务书编号)
	 * @param scgener  
	 * @return
	 * @throws BaseException
	 */
	public synchronized String geGeneratCommonCode(  SystemCodeGenerator scgener  ) throws BaseException {
		StringBuffer rCode = new StringBuffer( "" );
		
//		String sql = " from SystemCodeGenerator scg where scg.cgCode = '" + tableCode + "' ";
//		List gList = this.getObjects( sql ) ;
		
		List gList = this.getSystemCodeGeneratorList( scgener ) ;
		
		SystemCodeGenerator scg = null  ;
		
		if( gList != null && gList.size()>0 ) {
			scg = (SystemCodeGenerator) gList.get( 0 )  ;
			
			String currentYear = String.valueOf( DateUtil.getCurrentYear() ) ;
			String currentMonth = String.valueOf( DateUtil.getCurrentMonth() ) ;
			String recordYear = scg.getCurrentMaxId().toString().substring(0, 4) ;
			
			if( recordYear != null && currentYear.equals( recordYear ) ) { // 同年
				String temp = scg.getCurrentMaxId().toString().substring( 4 ) ;
				int temp2 = Integer.parseInt( temp ) + 1 ;
				String maxId = recordYear + temp2 ;
				scg.setCurrentMaxId(  new Long( maxId ) ) ;
				
//				rCode.append( scg.getCgName() ).append("_").append(recordYear).append("_").append( getSystemSetNumber(scg.getCurrentMaxId().toString().substring(4), 4 ) ) ;
				if( TableStatus.BILL_CODE_GENERATOR_02.equals( scgener.getCgCode() ) ) {
					// 监理合同编号
					rCode.append( "JB" ).append(recordYear).append( getSystemSetNumber(scg.getCurrentMaxId().toString().substring(4), 4 ) )
						.append("-").append( scgener.getDeptCode01() ) ;
					
				}else if( TableStatus.BILL_CODE_GENERATOR_03.equals( scgener.getCgCode() ) ) {
					// 监理任务书编号
					rCode.append( scgener.getDeptCode01() ).append(recordYear).append( getSystemSetNumber(scg.getCurrentMaxId().toString().substring(4), 4 ) )
						.append("-").append( scgener.getDeptCode02() ) ;
					
				}else if( TableStatus.BILL_CODE_GENERATOR_01.equals( scgener.getCgCode() ) || TableStatus.BILL_CODE_GENERATOR_04.equals( scgener.getCgCode() ) ) {
					// 监理项目编号、监造项目编码
					rCode.append( scgener.getDeptCode01() ).append(recordYear).append( getSystemSetNumber(scg.getCurrentMaxId().toString().substring(4), 4 ) ) ;
					
				}else {
					// 其它编码
					rCode.append(recordYear).append( getSystemSetNumber(currentMonth, 2) ).append( getSystemSetNumber(scg.getCurrentMaxId().toString().substring(4), 4 ) ) ;
				}
			}else { // 跨年序号重置
				String cmi = currentYear + "1" ;
				scg.setCurrentMaxId( new Long( cmi ) ) ;
				
				if( TableStatus.BILL_CODE_GENERATOR_02.equals( scgener.getCgCode() ) ) {
					// 监理合同编号
					rCode.append( "JB" ).append(recordYear).append( getSystemSetNumber(scg.getCurrentMaxId().toString().substring(4), 4 ) )
						.append("-").append( scgener.getDeptCode01() ) ;
					
				}else if( TableStatus.BILL_CODE_GENERATOR_03.equals( scgener.getCgCode() ) ) {
					// 监理任务书编号
					rCode.append( scgener.getDeptCode01() ).append(recordYear).append( getSystemSetNumber(scg.getCurrentMaxId().toString().substring(4), 4 ) )
						.append("-").append( scgener.getDeptCode02() ) ;
					
				}else if( TableStatus.BILL_CODE_GENERATOR_01.equals( scgener.getCgCode() ) || TableStatus.BILL_CODE_GENERATOR_04.equals( scgener.getCgCode() ) ) {
					// 监理项目编号、监造项目编码
					rCode.append( scgener.getDeptCode01() ).append(recordYear).append( getSystemSetNumber(scg.getCurrentMaxId().toString().substring(4), 4 ) ) ;
					
				}else {
					// 其它编码
					rCode.append(recordYear).append( getSystemSetNumber(currentMonth, 2) ).append( getSystemSetNumber(scg.getCurrentMaxId().toString().substring(4), 4 ) ) ;
				}
				
			}
			
			scg.setMaxId( scg.getMaxId() + 1 ) ;
			
			// 更新编号表
			this.updateSystemCodeGenerator( scg ) ; 
		}
		
		return rCode.toString()  ;
	}
	
	/**
	 * 编号生成器4, 按顺序号生成编码, 每次执行产生一个新编码, 不按年重置
	 * @param tableCode 单据标识 
	 * @param codeLength 单据编码长度 01 001 0001
	 * @author ted 2011-07-07 
	 * @return
	 * @throws BaseException
	 */
	public synchronized String geGeneratCommonCode(  String tableCode, int codeLength   ) throws BaseException {
		StringBuffer rCode = new StringBuffer( "" );
		
		String sql = " from SystemCodeGenerator scg where scg.cgCode = '" + tableCode + "' ";
		
		List gList = this.getObjects( sql ) ;
		
		SystemCodeGenerator scg = null  ;
		
		if( gList != null && gList.size()>0 ) {
			scg = (SystemCodeGenerator) gList.get( 0 )  ;
			
			String currentMaxId = scg.getCurrentMaxId().toString()  ;
			
			int nextMaxId = Integer.parseInt( currentMaxId ) + 1 ;
			
			scg.setCurrentMaxId(  new Long( nextMaxId ) ) ;
			
			scg.setMaxId( scg.getCurrentMaxId() ) ;
			
			rCode.append( getSystemSetNumber(scg.getCurrentMaxId().toString(), codeLength ) ) ;
			
			// 更新编号表
			this.updateSystemCodeGenerator( scg ) ; 
		}
		
		return rCode.toString()  ;
	}
	
	/**
	 * 取序号,位数不够补零
	 * @param number 序号
	 * @param length 位数
	 * @author ted 2010-12-20 
	 * @return
	 */
	private String getSystemSetNumber( String number, int length ) {
		
		String rValue = "" ;
		
		if( length <= number.length()  ) {
			rValue = number ;
			
		}else if( length > number.length() ) {
			StringBuffer sb = new StringBuffer(  ) ;
			
			for( int i=0; i< ( length-number.length() ); i++ ){
				sb.append("0") ;
			}
			
			sb.append( number ) ;
			
			rValue = sb.toString() ;
		}
			
		return rValue ;
	}
	
}
