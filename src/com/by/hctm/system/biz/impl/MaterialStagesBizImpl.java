package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.system.biz.IMaterialStagesBiz;
import com.by.hctm.system.entity.MaterialNames;
import com.by.hctm.system.entity.MaterialStages;

public class MaterialStagesBizImpl extends BaseBizImpl implements IMaterialStagesBiz  {
	
	/**
	 * 根据主键获得监理资料工序对应表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public MaterialStages getMaterialStages(Long id) throws BaseException {
		return (MaterialStages)this.getObject(MaterialStages.class, id);
	}
	
	/**
	 * 添加监理资料工序对应信息
	 * @param MaterialStages 监理资料工序对应表实例
	 * @throws BaseException 
	 */
	public void saveMaterialStages(MaterialStages materialStages) throws BaseException{
		this.saveObject( materialStages ) ;
	}
	
	/**
	 * 更新监理资料工序对应表实例
	 * @param MaterialStages 监理资料工序对应表实例
	 * @throws BaseException 
	 */
	public void updateMaterialStages(MaterialStages materialStages) throws BaseException{
		this.updateObject( materialStages ) ;
	}
	
	/**
	 * 删除监理资料工序对应表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteMaterialStages(String id) throws BaseException {
		this.removeObject( this.getMaterialStages( new Long(id) ) ) ;
	}
	
	/**
	 * 删除监理资料工序对应表实例
	 * @param MaterialStages 监理资料工序对应表实例
	 * @throws BaseException 
	 */
	public void deleteMaterialStages(MaterialStages materialStages) throws BaseException {
		this.removeObject( materialStages ) ;
	}
	
	/**
	 * 删除监理资料工序对应表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteMaterialStagess(String[] id) throws BaseException {
		this.removeBatchObject(MaterialStages.class, id) ;
	}
	
	/**
	 * 获得所有监理资料工序对应表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List getMaterialStagesList( RollPage rollPage  ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from MaterialStages de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有监理资料工序对应表数据集
	 * @param MaterialStages 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getMaterialStagesList(  MaterialStages materialStages ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from MaterialStages de where 1 = 1 " );
			if(materialStages!=null){
				if(StringUtil.isNotBlank(materialStages.getMnId())){
					hql.append(" and de.mnId = '").append(materialStages.getMnId()).append("'");
				}
			}
		hql.append(" order by de.id desc ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有监理资料工序对应表数据集
	 * @param rollPage 分页对象
	 * @param MaterialStages 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getMaterialStagesList( RollPage rollPage, MaterialStages materialStages ) throws BaseException {
		StringBuffer hql = new StringBuffer(" select m.mnId, m.mnCode,m.mnName,m.mnDetail,m.ifApprove" +
				",m.ifReply,m.ifInput,m.inputName,m.amounts,m.ifArchive," +
				"s.msId from MaterialNames m ,MaterialStages s where m.mnId = s.mnId " );
		if(materialStages!=null){
			if(!StringUtil.isBlank(materialStages.getStageId())){
				
				hql.append("and s.stageId=").append(materialStages.getStageId());
			}
		}
		hql.append(" order by s.msId desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有监理资料工序对应表数据集
	 * @param MaterialStages 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public int getMaterialStagesCount(  MaterialStages materialStages ) throws BaseException {
		StringBuffer hql = new StringBuffer("select count(*) from MaterialStages de where 1 = 1 " );
		if(materialStages!=null){
			if (!StringUtil.isBlank(materialStages.getStageId())) {
				hql.append(" and de.stageId = ").append(materialStages.getStageId());
			}			
		}
		hql.append(" order by de.mnId desc ");
		return this.countObjects(hql.toString());
	}
	
	
	/**
	 * 获得所有监理资料工序对应表数据集
	 * @param MaterialStages 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public int getMaterialStagesNmae(  MaterialStages materialStages ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from MaterialStages de where 1 = 1 " );
		if(materialStages!=null){
			if (!StringUtil.isBlank(materialStages.getStageId())) {
				hql.append(" and de.stageId = ").append(materialStages.getStageId());
			}			
		}
		hql.append(" order by de.id desc ");
		return this.countObjects(hql.toString());
	}
	
	/**
	 * 获得所有名称表数据集
	 * @param rollPage 分页对象
	 * @param MaterialNames 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List gMaterialStagesList( RollPage rollPage, MaterialStages materialStages , MaterialNames materialNames) throws BaseException {
		StringBuffer hql = new StringBuffer("select m.mnId, m.mnCode,m.mnName,m.comeFrom,m.mtId,m.mnDetail from MaterialNames m ,MaterialStages s where m.mnId = s.mnId " );
			if(materialStages!=null){
				if(StringUtil.isNotBlank(materialStages.getStageId())){
					hql.append("and s.stageId = ").append(materialStages.getStageId());
				}
			}
			if(materialNames!=null){
				if(StringUtil.isNotBlank(materialNames.getMnName())){
					hql.append(" and m.mnName like '%" ).append(materialNames.getMnName()).append("%'");
				}
				if(StringUtil.isNotBlank(materialNames.getMnCode())){
					hql.append(" and m.mnCode like '%" ).append(materialNames.getMnCode().toUpperCase()).append("%'");	
				}
			}
			
		hql.append(" order by s.mnId desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
}
