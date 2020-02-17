package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.system.biz.IConstructionEquipsBiz;
import com.by.hctm.system.entity.ConstructionEquips;

public class ConstructionEquipsBizImpl extends BaseBizImpl implements IConstructionEquipsBiz  {
	
	/**
	 * 根据主键获得监造物资名称表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public ConstructionEquips getConstructionEquips(Long id) throws BaseException {
		return (ConstructionEquips)this.getObject(ConstructionEquips.class, id);
	}
	
	/**
	 * 添加监造物资名称信息
	 * @param ConstructionEquips 监造物资名称表实例
	 * @throws BaseException 
	 */
	public void saveConstructionEquips(ConstructionEquips constructionEquips) throws BaseException{
		this.saveObject( constructionEquips ) ;
	}
	
	/**
	 * 更新监造物资名称表实例
	 * @param ConstructionEquips 监造物资名称表实例
	 * @throws BaseException 
	 */
	public void updateConstructionEquips(ConstructionEquips constructionEquips) throws BaseException{
		this.updateObject( constructionEquips ) ;
	}
	
	/**
	 * 删除监造物资名称表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteConstructionEquips(String id) throws BaseException {
		this.removeObject( this.getConstructionEquips( new Long(id) ) ) ;
	}
	
	/**
	 * 删除监造物资名称表实例
	 * @param ConstructionEquips 监造物资名称表实例
	 * @throws BaseException 
	 */
	public void deleteConstructionEquips(ConstructionEquips constructionEquips) throws BaseException {
		this.removeObject( constructionEquips ) ;
	}
	
	/**
	 * 删除监造物资名称表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteConstructionEquipss(String[] id) throws BaseException {
		this.removeBatchObject(ConstructionEquips.class, id) ;
	}
	
	/**
	 * 获得所有监造物资名称表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List getConstructionEquipsList( RollPage rollPage  ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from ConstructionEquips de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有监造物资名称表数据集
	 * @param ConstructionEquips 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getConstructionEquipsList(  ConstructionEquips constructionEquips ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from ConstructionEquips de where 1 = 1 " );
			
		hql.append(" order by de.id desc ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有监造物资名称表数据集
	 * @param rollPage 分页对象
	 * @param ConstructionEquips 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getConstructionEquipsList( RollPage rollPage, ConstructionEquips constructionEquips ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from ConstructionEquips de where 1 = 1 " );
		if(constructionEquips!=null){
			if( !StringUtil.isBlank(constructionEquips.getCeName())){
				hql.append("and de.ceName like '%").append(constructionEquips.getCeName().trim()+"%'");					
			}
			if(!StringUtil.isBlank(constructionEquips.getStandardName())){
				hql.append(" and de.standardName like '%").append(constructionEquips.getStandardName().trim()).append("%'");
			}
		}
		hql.append(" and de.isUsable = '0' ");
		hql.append(" order by de.publishDate desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	
	public List getConstructionEquipsAllList() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
