package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.system.biz.IMaterialNamesBiz;
import com.by.hctm.system.entity.MaterialNames;
import com.by.hctm.system.entity.MaterialStages;

public class MaterialNamesBizImpl extends BaseBizImpl implements IMaterialNamesBiz  {
	
	/**
	 * 根据主键获得资料名称表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public MaterialNames getMaterialNames(Long id) throws BaseException {
		return (MaterialNames)this.getObject(MaterialNames.class, id);
	}
	
	/**
	 * 添加资料名称信息
	 * @param MaterialNames 资料名称表实例
	 * @throws BaseException 
	 */
	public void saveMaterialNames(MaterialNames MaterialNames) throws BaseException{
		this.saveObject( MaterialNames ) ;
	}
	
	/**
	 * 更新资料名称表实例
	 * @param MaterialNames 资料名称表实例
	 * @throws BaseException 
	 */
	public void updateMaterialNames(MaterialNames MaterialNames) throws BaseException{
		this.updateObject( MaterialNames ) ;
	}
	
	/**
	 * 删除资料名称表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteMaterialNames(String id) throws BaseException {
		this.removeObject( this.getMaterialNames( new Long(id) ) ) ;
	}
	
	/**
	 * 删除资料名称表实例
	 * @param MaterialNames 资料名称表实例
	 * @throws BaseException 
	 */
	public void deleteMaterialNames(MaterialNames MaterialNames) throws BaseException {
		this.removeObject( MaterialNames ) ;
	}
	
	/**
	 * 删除资料名称表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteMaterialNamess(String[] id) throws BaseException {
		this.removeBatchObject(MaterialNames.class, id) ;
	}
	
	/**
	 * 获得所有资料名称表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List getMaterialNamesList( RollPage rollPage  ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from MaterialNames de where 1 = 1 " );

		hql.append(" order by de.dispNumber ASC ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有资料名称表数据集
	 * @param MaterialNames 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getMaterialNamesList(  MaterialNames MaterialNames ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from MaterialNames de where 1 = 1 " );

		hql.append(" order by de.dispNumber ASC ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有资料名称表数据集
	 * @param rollPage 分页对象
	 * @param MaterialNames 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getMaterialNamesList( RollPage rollPage, MaterialNames materialNames ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from MaterialNames de where 1 = 1 " );
			if(materialNames!=null){
				if(!StringUtil.isBlank(materialNames.getSubjId())){
				hql.append(" and de.subjId = '").append(materialNames.getSubjId()).append("'");
				}
				if(!StringUtil.isBlank(materialNames.getMtId())){
					hql.append(" and de.mtId = '").append(materialNames.getMtId()).append("'");
				}
				if(!StringUtil.isBlank(materialNames.getMnName())){
					hql.append(" and de.mnName like '%").append(materialNames.getMnName()).append("%'");
				}
				if(!StringUtil.isBlank(materialNames.getComeFrom())){
					hql.append(" and de.comeFrom = '").append(materialNames.getComeFrom()).append("'");
				}
			}
		hql.append(" order by de.mtId,de.comeFrom,de.dispNumber ASC ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	 
	
	/**
	 * 获得所有资料名称表数据集
	 * @param rollPage 分页对象
	 * @param MaterialNames 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List MaterialNameList( RollPage rollPage, MaterialNames materialNames,MaterialStages materialStages ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from MaterialNames m where m.mnId not in (select t.mnId from MaterialStages t where  " );
			
		if(materialStages != null){
			if(!StringUtil.isBlank(materialStages.getStageId())){
				hql.append(" t.stageId = ").append(materialStages.getStageId()).append(" )");				
			}
		}
			if(materialNames!=null){
				
				if(!StringUtil.isBlank(materialNames.getSubjId())){
					hql.append(" and m.subjId=").append(materialNames.getSubjId());
				}
				if(!StringUtil.isBlank(materialNames.getSubjId())){
					hql.append(" and m.subjId = '").append(materialNames.getSubjId()).append("'");
				}
				if(!StringUtil.isBlank(materialNames.getMtId())){
					hql.append(" and m.mtId = '").append(materialNames.getMtId()).append("'");
				}
				if(!StringUtil.isBlank(materialNames.getMnName())){
					hql.append(" and m.mnName like '%").append(materialNames.getMnName()).append("%'");
				}
				if(!StringUtil.isBlank(materialNames.getComeFrom())){
					hql.append(" and m.comeFrom = '").append(materialNames.getComeFrom()).append("'");
				}
			}
			hql.append(" order by m.dispNumber ASC ");
		return this.getObjects(rollPage, hql.toString() );
	}

	/**
	 * 获得所有资料类别数据集
	 * @return
	 * @throws BaseException 
	 */
	public List getMaterialTypesList() throws BaseException {
		StringBuffer hql = new StringBuffer(" from MaterialTypes de where 1 = 1  " );
		hql.append(" order by de.dispNumber ASC ");
		return this.getObjects(hql.toString() );
	}
	/**
	 * 获得所有资料类别数据count
	 * @return
	 * @throws BaseException 
	 */
	public int getMaterialNamesCount(MaterialNames materialNames) throws BaseException {
		StringBuffer hql = new StringBuffer(" select count(*) from MaterialNames de where 1 = 1  " );
			if (materialNames != null) {
				if (!StringUtil.isBlank(materialNames.getSubjId())) {
					hql.append(" and de.subjId =").append(materialNames.getSubjId());
				}
			}
		hql.append(" order by de.dispNumber ASC ");
		return this.countObjects(hql.toString());
		}


}
