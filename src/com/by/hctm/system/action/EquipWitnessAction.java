package com.by.hctm.system.action;

import java.util.List;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.BaseDataInfosUtil;
import com.by.hctm.common.DictStatus;
import com.by.hctm.system.biz.IEquipWitnessBiz;
import com.by.hctm.system.entity.EquipWitness;

@SuppressWarnings("serial")
public class EquipWitnessAction extends BaseAction {
	private IEquipWitnessBiz IEquipWitnessBiz;
	private EquipWitness equipWitness;
	private List<EquipWitness>  equipWitnessList;
	private String str;
	
	/**
	 * 查看监造物资见证信息信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewEquipWitness() throws BaseException {
		
		try{
			if(equipWitness==null){
				equipWitness=new EquipWitness();
				equipWitness.setCeId(equipWitness.getCeId());
			}
			this.setListValue( this.IEquipWitnessBiz.getEquipWitnessList( this.getRollPage(), equipWitness ) ) ;
			this.getRequest().setAttribute("ew", BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1701));
		} catch (Exception e) {
			log.error("查看监造物资见证信息信息列表错误！", e);
			throw new BaseException("查看监造物资见证信息信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	/**
	 * showModalDialog查看监造物资见证信息信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewShowModalDialogEquipWitness() throws BaseException {
		
		try{
			if(equipWitness==null){
				//equipWitness=new EquipWitness();
				equipWitness.setCeId(equipWitness.getCeId());
			}
		
			this.setListValue( this.IEquipWitnessBiz.getEquipWitnessList( this.getRollPage(), equipWitness ) ) ;
		} catch (Exception e) {
			log.error("查看监造物资见证信息信息列表错误！", e);
			throw new BaseException("查看监造物资见证信息信息列表错误！", e);
		}
		
		return "viewShowModalDialogEquipWitness" ;
		
	}
	
	/**
	 * 保存监造物资见证信息信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String saveEquipWitnessInit() throws BaseException {
		try{
		} catch (Exception e) {
			log("保存监造物资见证信息信息初始化错误！", e);
			throw new BaseException("保存监造物资见证信息信息初始化错误！", e);
		}
		return ADD_INIT;
		
	}
	
	/**
	 * 保存监造物资见证信息信息
	 * @return
	 * @throws BaseException 
	 */
	public String saveEquipWitness() throws BaseException {
		
		try{
			if(equipWitnessList!=null &&equipWitnessList.size()>0){
				for (int i = 0; i < equipWitnessList.size(); i++) {
					if (equipWitnessList.get(i)!=null) {
						if (equipWitnessList.get(i).getEwId()!=null) {
							this.IEquipWitnessBiz.updateEquipWitness(equipWitnessList.get(i));
						}else{
							this.IEquipWitnessBiz.saveEquipWitness( equipWitnessList.get(i) );
						}
						if(equipWitnessList.get(i)!=null){
							equipWitness=new EquipWitness();
							equipWitness.setCeId(equipWitnessList.get(i).getCeId());
						}
						
					}
				}
				
			}
		} catch (Exception e) {
			log("保存监造物资见证信息信息错误！", e);
			throw new BaseException("保存监造物资见证信息信息错误！", e);
		}
		return ADD;
		
	}
	
	/**
	 * 修改监造物资见证信息信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String updateEquipWitnessInit() throws BaseException {
		try{
			equipWitness=this.IEquipWitnessBiz.getEquipWitness( equipWitness.getEwId() );
		} catch (Exception e) {
			log("修改监造物资见证信息信息初始化错误！", e);
			throw new BaseException("修改监造物资见证信息信息初始化错误！", e);
		}
		return MODIFY_INIT;
	}
	
	/**
	 * 修改监造物资见证信息信息
	 * @return
	 * @throws BaseException 
	 */
	public String updateEquipWitness() throws BaseException {
		
		try{
			this.IEquipWitnessBiz.updateEquipWitness( equipWitness );
		} catch (Exception e) {
			log("修改监造物资见证信息信息错误！", e);
			throw new BaseException("修改监造物资见证信息信息错误！", e);
		}
		return MODIFY;
	}
	
	/**
	 * 删除监造物资见证信息信息
	 * @return
	 * @throws BaseException 
	 */
	public String deleteEquipWitness() throws BaseException {
		try{
		        String a[] = str.split(",");   
		       for (int i = 0; i < a.length; i++) {
		    	   equipWitness=this.IEquipWitnessBiz.getEquipWitness(new Long (a[i]));  
		    	   this.IEquipWitnessBiz.deleteEquipWitness( equipWitness  );
		    	   if( Integer.valueOf(a[i])==0){
						equipWitness=this.IEquipWitnessBiz.getEquipWitness(new Long (a[0]));
				}
		    	   
			}
		} catch (Exception e) {
			log("删除监造物资见证信息信息错误！", e);
			throw new BaseException("删除监造物资见证信息信息错误！", e);
		}
		return DELETE;
		
	}
	
	/**
	 * 查看监造物资见证信息明细信息
	 * @return
	 * @throws BaseException 
	 */
	public String viewEquipWitnessDetail() throws BaseException {
		try{
			equipWitness=this.IEquipWitnessBiz.getEquipWitness( equipWitness.getEwId() );
		} catch (Exception e) {
			log("查看监造物资见证信息明细信息错误！", e);
			throw new BaseException("查看监造物资见证信息明细信息错误！", e);
		}
		return DETAIL;
	}
	
	/**
	 * 提交监造物资见证信息信息
	 * @return
	 * @throws BaseException 
	 */
	public String submitEquipWitness() throws BaseException {
		
		try{
//			this.EquipWitnessBiz.submitSubjects( subjects  );
		} catch (Exception e) {
			log("提交监造物资见证信息信息错误！", e);
			throw new BaseException("提交监造物资见证信息信息错误！", e);
		}
		return SUBMIT;
	}
	

	public IEquipWitnessBiz getIEquipWitnessBiz() {
		return IEquipWitnessBiz;
	}
	public void setIEquipWitnessBiz(IEquipWitnessBiz iEquipWitnessBiz) {
		IEquipWitnessBiz = iEquipWitnessBiz;
	}
	public EquipWitness getEquipWitness() {
		return equipWitness;
	}
	public void setEquipWitness(EquipWitness equipWitness) {
		this.equipWitness = equipWitness;
	}
	public List<EquipWitness> getEquipWitnessList() {
		return equipWitnessList;
	}
	public void setEquipWitnessList(List<EquipWitness> equipWitnessList) {
		this.equipWitnessList = equipWitnessList;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
}
