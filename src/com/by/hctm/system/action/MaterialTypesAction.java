package com.by.hctm.system.action;

import java.util.List;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.system.biz.IMaterialTypesBIZ;
import com.by.hctm.system.entity.MaterialTypes;
@SuppressWarnings("unchecked")
public class MaterialTypesAction extends BaseAction {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private IMaterialTypesBIZ iMaterialTypesBIZ;
		private MaterialTypes materialTypes;
		private List<MaterialTypes> mterialTypesList;
		 
		public IMaterialTypesBIZ getIMaterialTypesBIZ() {
			return iMaterialTypesBIZ;
		}

		public void setIMaterialTypesBIZ(IMaterialTypesBIZ materialTypesBIZ) {
			iMaterialTypesBIZ = materialTypesBIZ;
		}

		public MaterialTypes getMaterialTypes() {
			return materialTypes;
		}

		public void setMaterialTypes(MaterialTypes materialTypes) {
			this.materialTypes = materialTypes;
		}

		public List<MaterialTypes> getMterialTypesList() {
			return mterialTypesList;
		}

		public void setMterialTypesList(List<MaterialTypes> mterialTypesList) {
			this.mterialTypesList = mterialTypesList;
		}
		
		
		/**
		 * 查看物资类别信息列表
		 * @return
		 * @throws BaseException 
		 * @Action
		 */
		public String viewMaterialTypes() throws BaseException {
			
			try{
				this.setListValue( this.iMaterialTypesBIZ.getMaterialTypesList( this.getRollPage(), materialTypes ) ) ;
				 //BaseDataInfosUtil.initBaseIndexInfos( TableStatus.BASE_DATA_TYPE_07 ) ;
			} catch (Exception e) {
				log("查看物资类别信息列表错误！", e);
				throw new BaseException("查看物资类别信息列表错误！", e);
			}
			
			return VIEW ;
		}
		

		/**
		 * 保存物资类别信息初始化
		 * @return
		 * @throws BaseException 
		 */
		public String saveMaterialTypesInit() throws BaseException {
			try{
			} catch (Exception e) {
				log("保存物资类别信息初始化错误！", e);
				throw new BaseException("保存物资类别信息初始化错误！", e);
			}
			return ADD_INIT;
			
		}
		
		/**
		 * 保存物资类别信息
		 * @return
		 * @throws BaseException 
		 */
		public String saveMaterialTypes() throws BaseException {
			try{
				this.iMaterialTypesBIZ.saveMaterialTypes( materialTypes );
			} catch (Exception e) {
				log("保存物资类别信息错误！", e);
				throw new BaseException("保存物资类别信息错误！", e);
			}
			
			return ADD;
			
		}
		
		/**
		 * 修改物资类别信息初始化
		 * @return
		 * @throws BaseException 
		 */
		public String updateMaterialTypesInit() throws BaseException {
			try{
				materialTypes=this.iMaterialTypesBIZ.getMaterialTypes( materialTypes.getMtId() );
			} catch (Exception e) {
				log("修改物资类别信息初始化错误！", e);
				throw new BaseException("修改物资类别信息初始化错误！", e);
			}
			return MODIFY_INIT;
			
		}
		
		/**
		 * 修改物资类别信息
		 * @return
		 * @throws BaseException 
		 */
		public String updateMaterialTypes() throws BaseException {
			try{
				this.iMaterialTypesBIZ.updateMaterialTypes( materialTypes );
			} catch (Exception e) {
				log("修改物资类别信息错误！", e);
				throw new BaseException("修改物资类别信息错误！", e);
			}
			return MODIFY;
			
		}
		
		/**
		 * 删除物资类别信息
		 * @return
		 * @throws BaseException 
		 */
		public String delMaterialTypes() throws BaseException {
			try{
				//伪删除
				materialTypes = iMaterialTypesBIZ.getMaterialTypes(materialTypes.getMtId());
				materialTypes.setIsUsable("1");
				//this.iMaterialTypesBIZ.deleteMaterialTypes( materialTypes.getMtId());
			} catch (Exception e) {
				log("删除物资类别信息错误！", e);
				throw new BaseException("删除物资类别信息错误！", e);
			}
			return DELETE;
			
		}
	
}
