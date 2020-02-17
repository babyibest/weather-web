package com.by.hctm.system.action;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.system.biz.IConstructionEquipsBiz;
import com.by.hctm.system.biz.IConstructionSubjectsBIZ;
import com.by.hctm.system.entity.ConstructionEquips;
import com.by.hctm.system.entity.ConstructionSubjects;

@SuppressWarnings("serial")
public class ConstructionEquipsAction extends BaseAction {
	//监造大纲bIZ
	private IConstructionEquipsBiz IConstructionEquipsBiz  ;
	//监造专业BIZ
	private IConstructionSubjectsBIZ IConstructionSubjectsBIZ;
	//监造大纲
	private ConstructionEquips constructionEquips ;
	//监造专业
	private ConstructionSubjects constructionSubjects;
	
	/**
	 * 查看监造大纲信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewConstructionEquips() throws BaseException {
		
		try{
			
			this.setListValue( this.IConstructionEquipsBiz.getConstructionEquipsList( this.getRollPage(), constructionEquips ) ) ;
		} catch (Exception e) {
			log.error("查看监造大纲信息列表错误！", e);
			throw new BaseException("查看监造大纲信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * showModalDialog查看监造大纲信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewSelectConstructionEquips() throws BaseException {
		
		try{
			
			this.setListValue( this.IConstructionEquipsBiz.getConstructionEquipsList( this.getRollPage(), constructionEquips ) ) ;
		} catch (Exception e) {
			log.error("查看监造大纲信息列表错误！", e);
			throw new BaseException("查看监造大纲信息列表错误！", e);
		}
		
		return "viewSelectConstructionEquips" ;
		
	}
	
	/**
	 * 保存监造大纲信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String saveConstructionEquipsInit() throws BaseException {
		try{
			this.getRequest().setAttribute("csList", this.IConstructionSubjectsBIZ.getConstructionSubjectsList(constructionSubjects));
		} catch (Exception e) {
			log("保存监造大纲信息初始化错误！", e);
			throw new BaseException("保存监造大纲信息初始化错误！", e);
		}
		return ADD_INIT;
		
	}
	
	/**
	 * 保存监造大纲信息
	 * @return
	 * @throws BaseException 
	 */
	public String saveConstructionEquips() throws BaseException {
		
		try{
			this.IConstructionEquipsBiz.saveConstructionEquips( constructionEquips );
		} catch (Exception e) {
			log("保存监造大纲信息错误！", e);
			throw new BaseException("保存监造大纲信息错误！", e);
		}
		
		return ADD;
		
	}
	
	/**
	 * 修改监造大纲信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String updateConstructionEquipsInit() throws BaseException {
		
		try{
			constructionEquips=this.IConstructionEquipsBiz.getConstructionEquips( constructionEquips.getCeId() );
			this.getRequest().setAttribute("csList", this.IConstructionSubjectsBIZ.getConstructionSubjectsList(constructionSubjects));

		} catch (Exception e) {
			log("修改监造大纲信息初始化错误！", e);
			throw new BaseException("修改监造大纲信息初始化错误！", e);
		}
		return MODIFY_INIT;
		
	}
	
	/**
	 * 修改监造大纲信息
	 * @return
	 * @throws BaseException 
	 */			  
	public String updateConstructionEquips() throws BaseException {
		
		try{
			this.IConstructionEquipsBiz.updateConstructionEquips( constructionEquips );
		} catch (Exception e) {
			log("修改监造大纲信息错误！", e);
			throw new BaseException("修改监造大纲信息错误！", e);
		}
		return MODIFY;
		
	}
	
	/**
	 * 删除监造大纲信息
	 * @return
	 * @throws BaseException 
	 */
	public String deleteConstructionEquips() throws BaseException {
		try{
			//执行未删除！
			constructionEquips =this.IConstructionEquipsBiz.getConstructionEquips(constructionEquips.getCeId());
			constructionEquips.setIsUsable("1");
			//this.IConstructionEquipsBiz.deleteConstructionEquips(constructionEquips.getCeId().toString());
		} catch (Exception e) {
			log("删除监造大纲信息错误！", e);
			throw new BaseException("删除监造大纲信息错误！", e);
		}
		return DELETE;
		
	}
	
	/**
	 * 查看监造大纲明细信息
	 * @return
	 * @throws BaseException 
	 */
	public String viewConstructionEquipsDetail() throws BaseException {
		
		try{
			constructionEquips=this.IConstructionEquipsBiz.getConstructionEquips( constructionEquips.getCeId() );
		} catch (Exception e) {
			log("查看监造大纲明细信息错误！", e);
			throw new BaseException("查看监造大纲明细信息错误！", e);
		}
		return DETAIL;
		
	}
	
	/**
	 *根据监造物资名称信息
	 * @return
	 * @throws BaseException 
	 */
	public String queryConstructionEquips() throws BaseException {
		
		try{
			this.setListValue( this.IConstructionEquipsBiz.getConstructionEquipsList( this.getRollPage(), constructionEquips ) ) ;
		} catch (Exception e) {
			log("提交监造大纲信息错误！", e);
			throw new BaseException("提交监造大纲信息错误！", e);
		}
		return "query";
		
	}

	public IConstructionEquipsBiz getIConstructionEquipsBiz() {
		return IConstructionEquipsBiz;
	}

	public void setIConstructionEquipsBiz(
			IConstructionEquipsBiz iConstructionEquipsBiz) {
		IConstructionEquipsBiz = iConstructionEquipsBiz;
	}

	public ConstructionEquips getConstructionEquips() {
		return constructionEquips;
	}

	public void setConstructionEquips(ConstructionEquips constructionEquips) {
		this.constructionEquips = constructionEquips;
	}

	public IConstructionSubjectsBIZ getIConstructionSubjectsBIZ() {
		return IConstructionSubjectsBIZ;
	}

	public void setIConstructionSubjectsBIZ(
			IConstructionSubjectsBIZ iConstructionSubjectsBIZ) {
		IConstructionSubjectsBIZ = iConstructionSubjectsBIZ;
	}


	public ConstructionSubjects getConstructionSubjects() {
		return constructionSubjects;
	}

	public void setConstructionSubjects(ConstructionSubjects constructionSubjects) {
		this.constructionSubjects = constructionSubjects;
	}
	


	
}
