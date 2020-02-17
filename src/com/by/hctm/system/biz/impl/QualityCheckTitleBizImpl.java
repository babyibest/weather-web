package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.system.biz.IQualityCheckTitleBIZ;
import com.by.hctm.system.entity.QualityCheckKind;
import com.by.hctm.system.entity.QualityCheckTitle;
public class QualityCheckTitleBizImpl extends BaseBizImpl implements IQualityCheckTitleBIZ   {

	/**
	 * 根据主键获得巡检记录标题项表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public QualityCheckTitle getQualityCheckTitle(Long id) throws BaseException {
		return (QualityCheckTitle)this.getObject(QualityCheckTitle.class, id);
	}
	
	/**
	 * 根据主键获得巡检记录标题项表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public QualityCheckKind getQualityCheckKind(Long id) throws BaseException {
		return (QualityCheckKind)this.getObject(QualityCheckKind.class, id);
	}
	
	/**
	 * 添加巡检记录标题项表信息
	 * @param qualityCheckTitle 巡检记录标题项表实例
	 * @throws BaseException 
	 */
	public void saveQualityCheckTitle(QualityCheckTitle qualityCheckTitle) throws BaseException{
		this.saveObject( qualityCheckTitle ) ;
	}
	
	/**
	 * 更新巡检记录标题项表实例
	 * @param qualityCheckTitle 巡检记录标题项表实例
	 * @throws BaseException 
	 */
	public void updateQualityCheckTitle(QualityCheckTitle qualityCheckTitle ) throws BaseException{
		this.updateObject( qualityCheckTitle ) ;
	}
	
	/**
	 * 删除巡检记录标题项表实例
	 * @param id 主键
	 * @throws BaseException 
	 */
	public void deleteQualityCheckTitle(Long id) throws BaseException {
		this.removeObject( this.getQualityCheckTitle( new Long(id) ) ) ;
	}
	
	/**
	 * 删除巡检记录标题项表实例
	 * @param qualityCheckTitle 巡检记录标题项表实例
	 * @throws BaseException 
	 */
	public void deleteQualityCheckTitle(QualityCheckTitle qualityCheckTitle) throws BaseException {
		this.removeObject( qualityCheckTitle ) ;
	}
	
	/**
	 * 删除巡检记录标题项表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteQualityCheckTitles(String[] id) throws BaseException {
		this.removeBatchObject(QualityCheckTitle.class, id) ;
	} 
	
	/**
	 * 获得所有巡检记录类别项数据集
	 * @param QualityCheckCheck 巡检记录类别项对象
	 * @return
	 * @throws BaseException 
	 */
	public List<QualityCheckKind> getQualityCheckKindList( QualityCheckKind qualityCheckKind ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from QualityCheckKind qck where 1 = 1 " );

		if( qualityCheckKind != null ) {
			// 父类ID
			if( qualityCheckKind.getParentQckId() != null ) {
				hql.append(" and qck.parentQckId = " ).append( qualityCheckKind.getParentQckId() ) ;
			}
		}
		
		hql.append(" and qck.isUsable = '0' ") ;
		hql.append(" order by qck.qckOrder asc ") ;
		
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有巡检记录标题项数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List<QualityCheckTitle> getQualityCheckTitleList( RollPage rollPage ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from QualityCheckTitle qct where 1 = 1 " );

		hql.append(" and qct.isUsable = '0' ") ;
		
		hql.append(" order by qct.qctOrder asc ") ;
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有巡检记录标题项数据集
	 * @param qualityCheckTitle 巡检记录标题项对象
	 * @return
	 * @throws BaseException 
	 */
	public List<QualityCheckTitle> getQualityCheckTitleList( QualityCheckTitle qualityCheckTitle ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from QualityCheckTitle qct where 1 = 1 " );

		if( qualityCheckTitle != null ) {
			 if( !StringUtil.isBlank( qualityCheckTitle.getQckId() ) ) {
				hql.append(" and qct.qckId = ").append( qualityCheckTitle.getQckId() );
			 }
			 
			 if( !StringUtil.isBlank( qualityCheckTitle.getTitleFlag() ) ) {
				hql.append(" and qct.titleFlag = '").append( qualityCheckTitle.getTitleFlag() ).append("' ") ; 
			 }
		}
		
		hql.append(" and qct.isUsable = '0' ") ;
		
		hql.append(" order by qct.titleFlag ,qct.qctOrder asc ") ;
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有巡检记录标题项数据集
	 * @param rollPage 分页对象
	 * @param qualityCheckTitle 巡检记录标题项对象
	 * @return
	 * @throws BaseException 
	 */
	public List<QualityCheckTitle> getQualityCheckTitleList( RollPage rollPage, QualityCheckTitle qualityCheckTitle ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from QualityCheckTitle qct where 1 = 1 " );

		if( qualityCheckTitle != null ) {
			 hql.append("and qct.qckId=").append(qualityCheckTitle.getQckId());
		}
		hql.append(" and qct.isUsable = '0' ") ;
		hql.append(" order by qct.titleFlag ,qct.qctOrder asc ") ;
		//hql.append("group by qct.qctOrder  asc");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有巡检记录标题项数据集
	 * @return
	 * @throws BaseException 
	 */
	public List<QualityCheckTitle> getQualityCheckTitleList() throws BaseException {
		List<QualityCheckTitle> list=	this.getObjects(QualityCheckTitle.class);
		
		return list;
	}
	
	/**
	 * 获得非一级父节点的巡检记录类别项数据集
	 * @param QualityCheckCheck 巡检记录类别项对象
	 * @return
	 * @throws BaseException 
	 */
	public List<QualityCheckKind> getqckList( QualityCheckKind qualityCheckKind ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from QualityCheckKind qck where qck.parentQckId != 0 " );

		if( qualityCheckKind != null ) {
			// 父类ID
			if( qualityCheckKind.getParentQckId() != null ) {
				hql.append(" and qck.parentQckId = " ).append( qualityCheckKind.getParentQckId() ) ;
			}
		}
		
		hql.append(" and qck.isUsable = '0' ") ;
		hql.append(" order by qck.qckOrder asc ") ;
		
		return this.getObjects( hql.toString() );
	}
	
}
