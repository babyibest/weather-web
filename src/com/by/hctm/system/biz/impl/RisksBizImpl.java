package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.system.biz.IRisksBIZ;
import com.by.hctm.system.entity.Risks;
import com.by.hctm.system.entity.Stages;

public class RisksBizImpl extends BaseBizImpl implements IRisksBIZ {

	/**
	 * 根据主键获得风险点表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public Risks getRisks(Long id) throws BaseException {
		return (Risks)this.getObject(Risks.class, id);
	}
	
	/**
	 * 添加风险点表信息
	 * @param risks 风险点表实例
	 * @throws BaseException 
	 */
	public void saveRisks(Risks risks) throws BaseException{
		this.saveObject( risks ) ;
	}
	
	/**
	 * 更新风险点表实例
	 * @param risks 风险点表实例
	 * @throws BaseException 
	 */
	public void updateRisks(Risks risks ) throws BaseException{
		this.updateObject( risks ) ;
	}
	
	/**
	 * 删除风险点表实例
	 * @param id 主键
	 * @throws BaseException 
	 */
	public void deleteRisks(String id) throws BaseException {
		this.removeObject( this.getRisks( new Long(id) ) ) ;
	}
	
	/**
	 * 删除风险点表实例
	 * @param risks 风险点表实例
	 * @throws BaseException 
	 */
	public void deleteRisks(Risks risks) throws BaseException {
		this.removeObject( risks ) ;
	}
	
	/**
	 * 删除风险点表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteDemos(String[] id) throws BaseException {
		this.removeBatchObject(Risks.class, id) ;
	} 
	
	/**
	 * 获得所有风险点数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List<Risks> getRisksList( RollPage rollPage ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Risks ex where 1 = 1 " );
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有风险点数据集
	 * @param risks 风险点对象
	 * @return
	 * @throws BaseException 
	 */
	public List<Risks> getRisksList( Risks risks ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Risks sub where 1 = 1 " );

		if( risks != null ) {
		}
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有风险点数据集
	 * @param rollPage 分页对象
	 * @param risks 风险点对象
	 * @return
	 * @throws BaseException 
	 */
	public List<Risks> getRisksList( RollPage rollPage, Risks risks ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Risks de where 1 = 1 " );
		if( StringUtil.isNotBlank(risks)&&!StringUtil.isBlank(risks.getStageId()) ) {
			hql.append("and de.stageId=").append(risks.getStageId());
		}
		hql.append(" and de.isUsable = '0' order by de.id asc");
        return this.getObjects(rollPage, hql.toString());
	}
	
	/**
	 * 获得所有专业数据集
	 * @return
	 * @throws BaseException 
	 */
	public List getSubjectsList(int id) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Subjects de where 1 = 1 and de.standardId= "+id );
		hql.append(" order by de.id desc ");
		return this.getObjects(hql.toString() );
	}
	/**
	 * 获得所有工序数据集
	
	 * @return
	 * @throws BaseException 
	 */
	
	public List<Stages> getStagesList( ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Stages sub where 1 = 1 " );
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有专业数据集
	 * @return
	 * @throws BaseException 
	 */
	public Stages getStagesList(Risks risks) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Stages de where 1 = 1 and de.stageCode= "+risks.getStageId() );
		hql.append(" order by de.id desc ");
		Stages stages=null;
		List<Stages> sts=this.getObjects(hql.toString() );
		for(int i=0;i<sts.size();i++){
			stages= new Stages();
			stages.setBelongStandard(sts.get(i).getBelongStandard());
			stages.setBelongSubjid(sts.get(i).getBelongSubjid());
			stages.setDispNumber(sts.get(i).getDispNumber());
			stages.setRemark(sts.get(i).getRemark());
			stages.setStageCode(sts.get(i).getStageCode());
			stages.setStageId(sts.get(i).getStageId());
			stages.setStageName(sts.get(i).getStageName());
		}
		
		return stages;
	}
	/**
	 * 获得根据工序有无子节点
	 * @param
	 * @param Subjects 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public int  getRisksCount(Risks risks ) throws BaseException {
		StringBuffer hql = new StringBuffer("select count(*)  from Risks de where 1 = 1 ");
		if(risks != null){
			if(!StringUtil.isBlank(risks.getStageId())){
				hql.append(" and de.stageId = ").append(risks.getStageId());
			}
		}
		hql.append(" and isUsable = '0' order by de.id desc ");
		return  this.countObjects(hql.toString());
	}
		
	
}
