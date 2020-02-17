package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.system.biz.IStagesBiz;
import com.by.hctm.system.entity.Stages;
import com.by.hctm.system.entity.Subjects;
@SuppressWarnings("unchecked")
public class StagesBizImpl extends BaseBizImpl implements IStagesBiz  {
	
	/**
	 * 根据主键获得工序表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public Stages getStages(Long id) throws BaseException {
		return (Stages)this.getObject(Stages.class, id);
	}
	
	/**
	 * 添加工序信息
	 * @param Stages 工序表实例
	 * @throws BaseException 
	 */
	public void saveStages(Stages stages) throws BaseException{
		this.saveObject( stages ) ;
	}
	
	/**
	 * 更新工序表实例
	 * @param Stages 工序表实例
	 * @throws BaseException 
	 */
	public void updateStages(Stages stages) throws BaseException{
		this.updateObject( stages ) ;
	}
	
	/**
	 * 删除工序表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteStages(Long id) throws BaseException {
		this.removeObject( this.getStages( new Long(id) ) ) ;
	}
	
	/**
	 * 删除工序表实例
	 * @param Stages 工序表实例
	 * @throws BaseException 
	 */
	public void deleteStages(Stages stages) throws BaseException {
		this.removeObject( stages ) ;
	}
	
	/**
	 * 删除工序表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteStagess(String[] id) throws BaseException {
		this.removeBatchObject(Stages.class, id) ;
	}
	
	/**
	 * 获得所有工序表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	
	public List getStagesList( RollPage rollPage  ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Stages de where 1 = 1 " );
			
		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有工序表数据集
	 * @param Stages 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getStagesList(  Stages stages ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Stages de where 1 = 1 " );
			if (stages != null) {
				if (!StringUtil.isBlank(stages.getBelongSubjid())) {
					hql.append(" and de.belongSubjid = ").append(stages.getBelongSubjid());
				}
			}
		hql.append(" and de.isUsable = '0' order by de.dispNumber,de.stageCode desc ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有工序表数据集
	 * @param rollPage 分页对象
	 * @param Stages 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getStagesList( RollPage rollPage, Stages stages ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Stages de where 1 = 1 " );
		if(stages!=null){
			if(stages.getBelongSubjid()!=null){
				hql.append("and de.belongSubjid=").append(stages.getBelongSubjid());
			}
		}
		hql.append(" and de.isUsable ='0' order by de.dispNumber asc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	/**
	 * 获得所有专业表数据集
	 * @param rollPage 分页对象
	 * @param Stages 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getSubjectsList(int id) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Subjects de where 1 = 1 and de.standardId= "+id );
		hql.append(" order by de.id desc ");
		return this.getObjects(hql.toString() );
	}
	/**
	 * 获得所有工序表数据集
	 * @param rollPage 分页对象
	 * @param Stages 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getSubStagesList( RollPage rollPage, Stages stages ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Stages de where 1 = 1 and de.belongSubjid="+stages.getBelongSubjid() );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	/**
	 * 获得根据专业编码获专业数据集
	 * @param
	 * @param Subjects 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public Subjects getSubjects(Stages stages ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Subjects de where 1 = 1 and de.subjCode="+stages.getBelongSubjid() );
		
		hql.append(" order by de.id desc ");
		List<Subjects> list=this.getObjects(hql.toString() );
		Subjects subjects = new Subjects();
		System.out.println(list.size());
		if(list!=null){
		for(int i=0;i<list.size();i++){
			subjects.setBelongStandard(list.get(i).getBelongStandard());
			subjects.setRemark(list.get(i).getRemark());
			subjects.setStandardId(list.get(i).getStandardId());
			subjects.setSubjCode(list.get(i).getSubjCode());
			subjects.setSubjId(list.get(i).getSubjId());
			subjects.setSubjName(list.get(i).getSubjName());
		}
		}
		return subjects;
	}

	/**
	 * 获得根据专业有无子节点
	 * @param
	 * @param Subjects 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public int  getIsHaveChild(Subjects subjects ) throws BaseException {
		StringBuffer hql = new StringBuffer("select count(*)  from Subjects de where 1 = 1 and de.standardId="+subjects.getStandardId());
		hql.append(" order by de.id desc ");
		return  this.countObjects(hql.toString());
	}
	
	/**
	 * 获得根据标准获取专业
	 * @param
	 * @param Subjects 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List<Subjects>  getSubjects(Subjects subjects ) throws BaseException {
		StringBuffer hql = new StringBuffer("from Subjects de where 1 = 1 and de.standardId="+subjects.getStandardId());
		hql.append(" order by de.id desc ");
		return  this.getObjects(hql.toString());
	}
	/**
	 * 根据主键获得项目专业表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public Subjects getSubjectsId(Long id) throws BaseException {
		return (Subjects)this.getObject(Subjects.class, id);
	}
	
	/**
	 * 根据主键获得项目工序表数量
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public int getStagesCount(Stages stages) throws BaseException {
		StringBuffer hql = new StringBuffer("select count(*) from Stages de where 1 = 1");
			if(stages!=null){
				if (!StringUtil.isBlank(stages.getBelongSubjid())) {
					hql.append(" and de.belongSubjid = ").append(stages.getBelongSubjid());
					
				}
			}
			hql.append(" and de.isUsable = '0'");
		return this.baseDao.count(hql.toString());
	}

	public int getStagesCount(Subjects subjects) throws BaseException {
		// TODO Auto-generated method stub
		return 0;
	}
}
