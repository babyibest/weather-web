package com.by.hctm.system.action;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.system.biz.ISpuervisionEquipsBiz;
import com.by.hctm.system.entity.SpuervisionEquips;

public class SpuervisionEquipsAction extends BaseAction {
	private ISpuervisionEquipsBiz iSpuervisionEquipsBiz  ;
	private SpuervisionEquips spuervisionEquips ;
	
	

	/**
	 * 查看监理装备信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewSpuervisionEquips() throws BaseException {
		
		try{
			this.setListValue( this.iSpuervisionEquipsBiz.getSpuervisionEquipsList( this.getRollPage(), spuervisionEquips ,null) ) ;
		} catch (Exception e) {
			log.error("查看监理装备信息列表错误！", e);
			throw new BaseException("查看监理装备信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 保存监理装备信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String saveSpuervisionEquipsInit() throws BaseException {
		try{
		} catch (Exception e) {
			log("保存监理装备信息初始化错误！", e);
			throw new BaseException("保存监理装备信息初始化错误！", e);
		}
		return ADD_INIT;
		
	}
	
	/**
	 * 保存监理装备信息
	 * @return
	 * @throws BaseException 
	 */
	public String saveSpuervisionEquips() throws BaseException {
		
		try{
			this.iSpuervisionEquipsBiz.saveSpuervisionEquips( spuervisionEquips );
		} catch (Exception e) {
			log("保存监理装备信息错误！", e);
			throw new BaseException("保存监理装备信息错误！", e);
		}
		
		return ADD;
		
	}
	
	/**
	 * 修改监理装备信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String updateSpuervisionEquipsInit() throws BaseException {
		
		try{
			spuervisionEquips=this.iSpuervisionEquipsBiz.getSpuervisionEquips( spuervisionEquips.getSeId() );
		} catch (Exception e) {
			log("修改监理装备信息初始化错误！", e);
			throw new BaseException("修改监理装备信息初始化错误！", e);
		}
		return MODIFY_INIT;
		
	}
	
	/**
	 * 修改监理装备信息
	 * @return
	 * @throws BaseException 
	 */
	public String updateSpuervisionEquips() throws BaseException {
		
		try{
			this.iSpuervisionEquipsBiz.updateSpuervisionEquips( spuervisionEquips );
		} catch (Exception e) {
			log("修改监理装备信息错误！", e);
			throw new BaseException("修改监理装备信息错误！", e);
		}
		return MODIFY;
		
	}
	
	/**
	 * 删除监理装备信息
	 * @return
	 * @throws BaseException 
	 */
	public String deleteSpuervisionEquips() throws BaseException {
		try{
			this.iSpuervisionEquipsBiz.deleteSpuervisionEquips(spuervisionEquips.getSeId().toString() );
		} catch (Exception e) {
			log("删除监理装备信息错误！", e);
			throw new BaseException("删除监理装备信息错误！", e);
		}
		return DELETE;
		
	}
	
	/**
	 * 查看监理装备明细信息
	 * @return
	 * @throws BaseException 
	 */
	public String viewSpuervisionEquipsDetail() throws BaseException {
		
		try{
			spuervisionEquips=this.iSpuervisionEquipsBiz.getSpuervisionEquips( spuervisionEquips.getSeId());
		} catch (Exception e) {
			log("查看监理装备明细信息错误！", e);
			throw new BaseException("查看监理装备明细信息错误！", e);
		}
		return DETAIL;
		
	}
	
	/**
	 * 提交监理装备信息
	 * @return
	 * @throws BaseException 
	 */
	public String submitSpuervisionEquips() throws BaseException {
		
		try{
//			this.SpuervisionEquipsBiz.submitSubjects( subjects  );
		} catch (Exception e) {
			log("提交监理装备信息错误！", e);
			throw new BaseException("提交监理装备信息错误！", e);
		}
		return SUBMIT;
		
	}

	public ISpuervisionEquipsBiz getISpuervisionEquipsBiz() {
		return iSpuervisionEquipsBiz;
	}

	public void setISpuervisionEquipsBiz(ISpuervisionEquipsBiz spuervisionEquipsBiz) {
		iSpuervisionEquipsBiz = spuervisionEquipsBiz;
	}

	public SpuervisionEquips getSpuervisionEquips() {
		return spuervisionEquips;
	}

	public void setSpuervisionEquips(SpuervisionEquips spuervisionEquips) {
		this.spuervisionEquips = spuervisionEquips;
	}
	

}
