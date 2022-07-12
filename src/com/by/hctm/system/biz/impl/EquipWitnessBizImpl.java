package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.biz.IEquipWitnessBiz;
import com.by.hctm.system.entity.EquipWitness;


public class EquipWitnessBizImpl extends BaseBizImpl implements IEquipWitnessBiz  {
	
	/**
	 * 根据主键获得见证单表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public EquipWitness getEquipWitness(Long id) throws BaseException {
		return (EquipWitness)this.getObject(EquipWitness.class, id);
	}
	
	/**
	 * 添加见证单信息
	 * @param EquipWitness 见证单表实例
	 * @throws BaseException 
	 */
	public void saveEquipWitness(EquipWitness equipWitness) throws BaseException{
		this.saveObject( equipWitness ) ;
	}
	
	/**
	 * 更新见证单表实例
	 * @param EquipWitness 见证单表实例
	 * @throws BaseException 
	 */
	public void updateEquipWitness(EquipWitness equipWitness) throws BaseException{
		this.updateObject( equipWitness ) ;
	}
	
	/**
	 * 删除见证单表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteEquipWitness(String id) throws BaseException {
		this.removeObject( this.getEquipWitness( new Long(id) ) ) ;
	}
	
	/**
	 * 删除见证单表实例
	 * @param EquipWitness 见证单表实例
	 * @throws BaseException 
	 */
	public void deleteEquipWitness(EquipWitness equipWitness) throws BaseException {
		this.removeObject( equipWitness ) ;
	}
	
	/**
	 * 删除见证单表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteEquipWitnesss(String[] id) throws BaseException {
		this.removeBatchObject(EquipWitness.class, id) ;
	}
	
	/**
	 * 获得所有见证单表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List getEquipWitnessList( RollPage rollPage  ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from EquipWitness de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有见证单表数据集
	 * @param EquipWitness 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getEquipWitnessList(  EquipWitness equipWitness ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from EquipWitness de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有见证单表数据集
	 * @param rollPage 分页对象
	 * @param EquipWitness 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getEquipWitnessList( RollPage rollPage, EquipWitness equipWitness ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from EquipWitness de where 1 = 1 " );
		if(equipWitness!=null){
			if(equipWitness.getCeId()!=null){
				
				hql.append("and de.ceId=").append(equipWitness.getCeId());
			}
		}
		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
}
