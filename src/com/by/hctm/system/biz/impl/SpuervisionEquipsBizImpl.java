package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.system.biz.ISpuervisionEquipsBiz;
import com.by.hctm.system.entity.SpuervisionEquips;

public class SpuervisionEquipsBizImpl extends BaseBizImpl implements ISpuervisionEquipsBiz  {
	
	/**
	 * 根据主键获得监理装备表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public SpuervisionEquips getSpuervisionEquips(Long id) throws BaseException {
		return (SpuervisionEquips)this.getObject(SpuervisionEquips.class, id);
	}
	
	/**
	 * 添加监理装备信息
	 * @param SpuervisionEquips 监理装备表实例
	 * @throws BaseException 
	 */
	public void saveSpuervisionEquips(SpuervisionEquips spuervisionEquips) throws BaseException{
		this.saveObject( spuervisionEquips ) ;
	}
	
	/**
	 * 更新监理装备表实例
	 * @param SpuervisionEquips 监理装备表实例
	 * @throws BaseException 
	 */
	public void updateSpuervisionEquips(SpuervisionEquips spuervisionEquips) throws BaseException{
		this.updateObject( spuervisionEquips ) ;
	}
	
	/**
	 * 删除监理装备表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteSpuervisionEquips(String id) throws BaseException {
		this.removeObject( this.getSpuervisionEquips( new Long(id) ) ) ;
	}
	
	/**
	 * 删除监理装备表实例
	 * @param SpuervisionEquips 监理装备表实例
	 * @throws BaseException 
	 */
	public void deleteSpuervisionEquips(SpuervisionEquips spuervisionEquips) throws BaseException {
		this.removeObject( spuervisionEquips ) ;
	}
	
	/**
	 * 删除监理装备表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteSpuervisionEquipss(String[] id) throws BaseException {
		this.removeBatchObject(SpuervisionEquips.class, id) ;
	}
	
	/**
	 * 获得所有监理装备表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List getSpuervisionEquipsList( RollPage rollPage  ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from SpuervisionEquips de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有监理装备表数据集
	 * @param SpuervisionEquips 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getSpuervisionEquipsList(  SpuervisionEquips spuervisionEquips ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from SpuervisionEquips de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有监理装备表数据集
	 * @param rollPage 分页对象
	 * @param SpuervisionEquips 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getSpuervisionEquipsList( RollPage rollPage, SpuervisionEquips spuervisionEquips ,String s ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from SpuervisionEquips de where 1 = 1 ");
		if(!StringUtil.isBlank(s)){
			s=s.substring(0, s.lastIndexOf(","));
			hql.append(" and de.seId not in (" +s+")");
		}
		hql.append(" order by de.seId desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
}
