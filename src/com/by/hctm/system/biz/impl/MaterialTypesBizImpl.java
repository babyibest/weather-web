package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.biz.IMaterialTypesBIZ;
import com.by.hctm.system.entity.MaterialTypes;
@SuppressWarnings("unchecked")
public class MaterialTypesBizImpl extends BaseBizImpl implements IMaterialTypesBIZ  {
	/**
	 * 根据主键获得物资类别表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public MaterialTypes getMaterialTypes(Long id) throws BaseException {
		return (MaterialTypes)this.getObject(MaterialTypes.class, id);
	}
	
	/**
	 * 添加物资类别表信息
	 * @param MaterialTypes 物资类别表实例
	 * @throws BaseException 
	 */
	public void saveMaterialTypes(MaterialTypes materialTypes) throws BaseException{
		this.saveObject( materialTypes ) ;
	}
	
	/**
	 * 更新物资类别表实例
	 * @param materialTypes 物资类别表实例
	 * @throws BaseException 
	 */
	public void updateMaterialTypes(MaterialTypes materialTypes ) throws BaseException{
		this.updateObject( materialTypes ) ;
	}
	
	/**
	 * 删除物资类别表实例
	 * @param id 主键
	 * @throws BaseException 
	 */
	public void deleteMaterialTypes(Long id) throws BaseException {
		this.removeObject( this.getMaterialTypes( new Long(id) ) ) ;
	}
	
	/**
	 * 删除物资类别表实例
	 * @param materialTypes 物资类别表实例
	 * @throws BaseException 
	 */
	public void deleteMaterialTypes(MaterialTypes materialTypes) throws BaseException {
		this.removeObject( materialTypes ) ;
	}
	
	/**
	 * 删除物资类别表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteDemos(String[] id) throws BaseException {
		this.removeBatchObject(MaterialTypes.class, id) ;
	} 
	
	/**
	 * 获得所有物资类别数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List<MaterialTypes> getMaterialTypesList( RollPage rollPage ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from MaterialTypes ex where 1 = 1 " );
		hql.append(" and isUsable ='0' order by ex.dispNumber ASC");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有物资类别数据集
	 * @param materialTypes 物资类别对象
	 * @return
	 * @throws BaseException 
	 */
	public List<MaterialTypes> getMaterialTypesList( MaterialTypes materialTypes ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from MaterialTypes sub where 1 = 1 " );

		if( materialTypes != null ) {
			
		}
		hql.append(" and isUsable ='0' order by sub.dispNumber ASC");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有物资类别数据集
	 * @param rollPage 分页对象
	 * @param materialTypes 物资类别对象
	 * @return
	 * @throws BaseException 
	 */
	public List<MaterialTypes> getMaterialTypesList( RollPage rollPage, MaterialTypes materialTypes ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from MaterialTypes de where 1 = 1 " );

		if( materialTypes != null ) {
			
		}
		hql.append(" and de.isUsable = '0' order by de.dispNumber asc");
		return this.getObjects(rollPage, hql.toString() );
	}
}
