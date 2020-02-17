package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.system.biz.ISubjectsBIZ;
import com.by.hctm.system.entity.Subjects;

public class SubjectsBizImpl extends BaseBizImpl implements ISubjectsBIZ {
	
	/**
	 * 根据主键获得项目专业表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public Subjects getSubjects(Long id) throws BaseException {
		System.out.println(id);
		return (Subjects)this.getObject(Subjects.class, id);
	}
	/**
	 * 根据主键获得项目专业表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public Subjects getSubjectsb(Subjects subjects) throws BaseException {
		return (Subjects)this.getObject(Subjects.class, subjects.getBelongStandard());
	}
	
	/**
	 * 添加项目专业表信息
	 * @param subjects 项目专业表实例
	 * @throws BaseException 
	 */
	public void saveSubjects(Subjects subjects) throws BaseException{
		this.saveObject( subjects ) ;
	}
	
	/**
	 * 更新项目专业表实例
	 * @param subjects 项目专业表实例
	 * @throws BaseException 
	 */
	public void updateSubjects(Subjects subjects ) throws BaseException{
		this.updateObject( subjects ) ;
	}
	
	/**
	 * 删除项目专业表实例
	 * @param id 主键
	 * @throws BaseException 
	 */
	public void deleteSubjects(String id) throws BaseException {
		this.removeObject( this.getSubjects( new Long(id) ) ) ;
	}
	
	/**
	 * 删除项目专业表实例
	 * @param subjects 项目专业表实例
	 * @throws BaseException 
	 */
	public void deleteSubjects(Subjects subjects) throws BaseException {
		this.removeObject( subjects ) ;
	}
	
	/**
	 * 删除项目专业表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteSubjects(String[] id) throws BaseException {
		this.removeBatchObject(Subjects.class, id) ;
	} 
	
	/**
	 * 获得所有项目专业数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List<Subjects> getSubjectsList( RollPage rollPage ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Subjects ex where 1 = 1 " );

		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有项目专业数据集
	 * @param subjects 项目专业对象
	 * @return
	 * @throws BaseException 
	 */
	public List<Subjects> getSubjectsList( Subjects subjects ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Subjects sub where 1 = 1 " );

		if( subjects != null ) {
			if( !StringUtil.isBlank(subjects.getStandardId() ) ) {
				hql.append(" and sub.standardId ='" ).append(subjects.getStandardId() ).append("' ") ;
			}
		}
		hql.append(" and isUsable='0' order by sub.dispNumber,sub.subjCode ASC");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有项目专业数据集
	 * @param rollPage 分页对象
	 * @param subjects 项目专业对象
	 * @return
	 * @throws BaseException 
	 */
	public List<Subjects> getSubjectsList( RollPage rollPage, Subjects subjects ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Subjects sub where 1 = 1 " );

		if( subjects != null ) {
			// 所属标准非空且不等于0
			if( !StringUtil.isBlank( subjects.getStandardId() ) && subjects.getStandardId().longValue()>0  ) {
				hql.append(" and sub.standardId = " ).append( subjects.getStandardId() ) ;
			}
		}
		hql.append("  order by sub.dispNumber,sub.subjCode ASC");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	
	/**
	 * 获得根据专业编码数据集
	 * @param subjects 项目专业对象
	 * @return
	 * @throws BaseException 
	 */
	public List<Subjects> getSubjectsCodeList( Subjects subjects ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Subjects s where" );

		if( subjects != null ) {
			if( !StringUtil.isBlank(subjects.getSubjCode() ) ) {
				hql.append(" s.subjCode ='" ).append(subjects.getSubjCode() ).append("' ") ;
			}
		}
		hql.append( " and isUsable = '0' order by s.dispNumber ASC" );
		return this.getObjects( hql.toString() );
	}
	/**
	 * 获得根据标准查询专业数据集
	 * @param subjects 项目专业对象
	 * @return
	 * @throws BaseException 
	 */
	public int getSubjectsCount( Subjects subjects ) throws BaseException {
		StringBuffer hql = new StringBuffer(" select count(*) from Subjects de where 1=1" );
		if( subjects != null ) {
			if( !StringUtil.isBlank(subjects.getStandardId())) {
				hql.append(" and  de.standardId ='" ).append(subjects.getStandardId() ).append("' ") ;
			}
		}
		hql.append(" and isUsable='0'  ");
		return this.countObjects(hql.toString());
	}
	
}
