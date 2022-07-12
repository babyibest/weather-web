package com.by.hctm.system.action;
import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.BaseDataInfosUtil;
import com.by.hctm.common.DictStatus;
import com.by.hctm.system.biz.IRightsBIZ;
import com.by.hctm.system.entity.Rights;
@SuppressWarnings("unchecked")
public class RightsAction extends BaseAction {
	private IRightsBIZ IRightsBIZ;
	private Rights rights;
	
	
	/**
	 * 查看权限信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewRights() throws BaseException {
		
		try{
			this.setListValue( this.IRightsBIZ.getRightsList( this.getRollPage(),rights ) ) ;
			this.getRequest().setAttribute("map", BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1705));
		} catch (Exception e) {
			log.error("查看权限信息列表错误！", e);
			throw new BaseException("查看权限信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 保存权限信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String saveRightsInit() throws BaseException {
		try{
			this.getRequest().setAttribute("map", BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1705));
			
		} catch (Exception e) {
			log("保存权限信息初始化错误！", e);
			throw new BaseException("保存权限信息初始化错误！", e);
		}
		return ADD_INIT;
		
	}
	
	/**
	 * 保存权限信息
	 * @return
	 * @throws BaseException 
	 */
	public String saveRights() throws BaseException {
		
		try{
			this.IRightsBIZ.saveRights(rights);
		} catch (Exception e) {
			log("保存权限信息错误！", e);
			throw new BaseException("保存权限信息错误！", e);
		}
		
		return ADD;
		
	}
	
	/**
	 * 修改权限信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String updateRightsInit() throws BaseException {
		
		try{
			this.getRequest().setAttribute("map", BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1705));
			rights=this.IRightsBIZ.getRights( rights.getRightId() );
		} catch (Exception e) {
			log("修改权限信息初始化错误！", e);
			throw new BaseException("修改权限信息初始化错误！", e);
		}
		return MODIFY_INIT;
		
	}
	
	/**
	 * 修改权限信息
	 * @return
	 * @throws BaseException 
	 */
	public String updateRights() throws BaseException {
		
		try{
			this.IRightsBIZ.updateRights(rights);
		} catch (Exception e) {
			log("修改权限信息错误！", e);
			throw new BaseException("修改权限信息错误！", e);
		}
		return MODIFY;
		
	}
	
	/**
	 * 删除权限信息
	 * @return
	 * @throws BaseException 
	 */
	public String deleteRights() throws BaseException {
		try{
			rights = IRightsBIZ.getRights(rights.getRightId());
			rights.setIsUsable("1");
			//this.IRightsBIZ.deleteRights(rights.getRightId());
		} catch (Exception e) {
			log("删除权限信息错误！", e);
			throw new BaseException("删除权限信息错误！", e);
		}
		return DELETE;
		
	}
	
	/**
	 * 查看权限明细信息
	 * @return
	 * @throws BaseException 
	 */
	public String viewRightsDetail() throws BaseException {
		
		try{
			rights=this.IRightsBIZ.getRights(rights.getRightId() );
		} catch (Exception e) {
			log("查看权限明细信息错误！", e);
			throw new BaseException("查看权限明细信息错误！", e);
		}
		return DETAIL;
		
	}
	
	/**
	 * 提交权限信息
	 * @return
	 * @throws BaseException 
	 */
	public String submitRights() throws BaseException {
		
		try{
//			this.RightsBiz.submitSubjects( subjects  );
		} catch (Exception e) {
			log("提交权限信息错误！", e);
			throw new BaseException("提交权限信息错误！", e);
		}
		return SUBMIT;
		
	}

	
	public IRightsBIZ getIRightsBIZ() {
		return IRightsBIZ;
	}
	public void setIRightsBIZ(IRightsBIZ rightsBIZ) {
		IRightsBIZ = rightsBIZ;
	}
	public Rights getRights() {
		return rights;
	}
	public void setRights(Rights rights) {
		this.rights = rights;
	}
	

	
	
}
