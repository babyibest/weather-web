package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.biz.IConstructionSubjectsBIZ;
import com.by.hctm.system.entity.ConstructionSubjects;

public class ConstructionSubjectsBizImpl extends BaseBizImpl implements IConstructionSubjectsBIZ  {
	
	/**
	 * 根据主键获得监造专业表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public ConstructionSubjects getConstructionSubjects(Long id) throws BaseException {
		return (ConstructionSubjects)this.getObject(ConstructionSubjects.class, id);
	}
	
	/**
	 * 添加监造专业信息
	 * @param constructionSubjects 监造专业表实例
	 * @throws BaseException 
	 */
	public void saveConstructionSubjects(ConstructionSubjects constructionSubjects) throws BaseException{
		this.saveObject(constructionSubjects) ;
	}
	
	/**
	 * 更新监造专业表实例
	 * @param ConstructionSubjects 监造专业表实例
	 * @throws BaseException 
	 */
	public void updateConstructionSubjects(ConstructionSubjects constructionSubjects) throws BaseException{
		this.updateObject( constructionSubjects) ;
	}
	
	/**
	 * 删除监造专业表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteConstructionSubjects(String id) throws BaseException {
		this.removeObject( this.getConstructionSubjects( new Long(id) ) ) ;
	}
	
	/**
	 * 删除监造专业表实例
	 * @param ConstructionSubjects 监造专业表实例
	 * @throws BaseException 
	 */
	public void deleteConstructionSubjects(ConstructionSubjects ConstructionSubjects) throws BaseException {
		this.removeObject( ConstructionSubjects ) ;
	}
	
	/**
	 * 删除监造专业表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteConstructionSubjectss(String[] id) throws BaseException {
		this.removeBatchObject(ConstructionSubjects.class, id) ;
	}
	
	/**
	 * 获得所有监造专业表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List getConstructionSubjectsList( RollPage rollPage  ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from ConstructionSubjects de where 1 = 1 " );

		hql.append(" and de.isUsable = '0'  order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有监造专业表数据集
	 * @param ConstructionSubjects 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getConstructionSubjectsList(  ConstructionSubjects constructionSubjects ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from ConstructionSubjects de where 1 = 1 " );

		hql.append(" and de.isUsable = '0'  order by de.id desc ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有监造专业表数据集
	 * @param rollPage 分页对象
	 * @param ConstructionSubjects 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getConstructionSubjectsList( RollPage rollPage, ConstructionSubjects constructionSubjects ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from ConstructionSubjects de where 1 = 1 " );

		hql.append(" and isUsable ='0' order by de.csubjCode desc ");
		return this.getObjects(rollPage, hql.toString() );
	}

	public List getConstructionSubjectsAllList() throws BaseException {
		// TODO Auto-generated method stub
		return this.getObjects(ConstructionSubjects.class);
	}
	
}
