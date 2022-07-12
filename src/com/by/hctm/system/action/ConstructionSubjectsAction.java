package com.by.hctm.system.action;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.system.biz.IConstructionSubjectsBIZ;
import com.by.hctm.system.entity.ConstructionSubjects;

public class ConstructionSubjectsAction extends BaseAction {
	//监造专业
	private ConstructionSubjects constructionSubjects ;
	//监造专业BIZ
	private IConstructionSubjectsBIZ IConstructionSubjectsBIZ  ;

	/**
	 * 查看监造专业管理信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewConstructionSubjects() throws BaseException {
		
		try{
			this.setListValue( this.IConstructionSubjectsBIZ.getConstructionSubjectsList( this.getRollPage(), constructionSubjects ) ) ;
		} catch (Exception e) {
			log.error("查看监造专业管理信息列表错误！", e);
			throw new BaseException("查看监造专业管理信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 保存监造专业管理信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String saveConstructionSubjectsInit() throws BaseException {
		try{
			
		} catch (Exception e) {
		
			log("保存监造专业管理信息初始化错误！", e);
			throw new BaseException("保存监造专业管理信息初始化错误！", e);
		}
		return ADD_INIT;
		
	}
	
	/**
	 * 保存监造专业管理信息
	 * @return
	 * @throws BaseException 
	 */
	public String saveConstructionSubjects() throws BaseException {
		
		try{
			this.IConstructionSubjectsBIZ.saveConstructionSubjects( constructionSubjects );
		} catch (Exception e) {
			log("保存监造专业管理信息错误！", e);
			throw new BaseException("保存监造专业管理信息错误！", e);
		}
		
		return ADD;
		
	}
	
	/**
	 * 修改监造专业管理信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String updateConstructionSubjectsInit() throws BaseException {
		
		try{
			constructionSubjects=this.IConstructionSubjectsBIZ.getConstructionSubjects( constructionSubjects.getCsubjId());
		} catch (Exception e) {
			log("修改监造专业管理信息初始化错误！", e);
			throw new BaseException("修改监造专业管理信息初始化错误！", e);
		}
		return MODIFY_INIT;
		
	}
	
	/**
	 * 修改监造专业管理信息
	 * @return
	 * @throws BaseException 
	 */
	public String updateConstructionSubjects() throws BaseException {
		
		try{
			this.IConstructionSubjectsBIZ.updateConstructionSubjects( constructionSubjects );
		} catch (Exception e) {
			log("修改监造专业管理信息错误！", e);
			throw new BaseException("修改监造专业管理信息错误！", e);
		}
		return MODIFY;
		
	}
	
	/**
	 * 删除监造专业管理信息
	 * @return
	 * @throws BaseException 
	 */
	public String deleteConstructionSubjects() throws BaseException {
		
		try{
			constructionSubjects=this.IConstructionSubjectsBIZ.getConstructionSubjects(constructionSubjects.getCsubjId());
			constructionSubjects.setIsUsable("1");
			//this.IConstructionSubjectsBIZ.deleteConstructionSubjects( constructionSubjects  );
		} catch (Exception e) {
			log("删除监造专业管理信息错误！", e);
			throw new BaseException("删除监造专业管理信息错误！", e);
		}
		return DELETE;
		
	}
	
	/**
	 * 查看监造专业管理明细信息
	 * @return
	 * @throws BaseException 
	 */
	public String viewConstructionSubjectsDetail() throws BaseException {
		
		try{
			constructionSubjects=this.IConstructionSubjectsBIZ.getConstructionSubjects( constructionSubjects.getCsubjId());
		} catch (Exception e) {
			log("查看监造专业管理明细信息错误！", e);
			throw new BaseException("查看监造专业管理明细信息错误！", e);
		}
		return DETAIL;
		
	}
	
	
	public IConstructionSubjectsBIZ getIConstructionSubjectsBIZ() {
		return IConstructionSubjectsBIZ;
	}

	public void setIConstructionSubjectsBIZ(
			IConstructionSubjectsBIZ constructionSubjectsBIZ) {
		IConstructionSubjectsBIZ = constructionSubjectsBIZ;
	}

	public ConstructionSubjects getConstructionSubjects() {
		return constructionSubjects;
	}

	public void setConstructionSubjects(ConstructionSubjects constructionSubjects) {
		this.constructionSubjects = constructionSubjects;
	}
	
}
