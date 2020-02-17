package com.by.hctm.system.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringEscapeUtils;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.BaseDataInfosUtil;
import com.by.hctm.common.DictStatus;
import com.by.hctm.common.utils.GlobalSetting;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.system.biz.IMaterialNamesBiz;
import com.by.hctm.system.biz.IMaterialStagesBiz;
import com.by.hctm.system.biz.IMaterialTypesBIZ;
import com.by.hctm.system.biz.IStagesBiz;
import com.by.hctm.system.biz.ISubjectsBIZ;
import com.by.hctm.system.entity.MaterialNames;
import com.by.hctm.system.entity.MaterialStages;
import com.by.hctm.system.entity.MaterialTypes;
import com.by.hctm.system.entity.Subjects;

public class MaterialNamesAction extends BaseAction {
	private IMaterialStagesBiz iMaterialStagesBiz  ;
	private IMaterialNamesBiz iMaterialNamesBiz  ;
	private IMaterialTypesBIZ iMaterialTypesBIZ;
	private MaterialNames materialNames ;
	private MaterialStages materialStages ;
	private MaterialTypes materialTypes;
	private String tree;
	private Subjects subjects;
	private IStagesBiz iStagesBiz;
	private ISubjectsBIZ iSubjectsBIZ;
	private Map MMap;
	/**
	 * 查看标准信息首页列表
	 * 
	 * @return
	 * @throws BaseException
	 * @Action
	 */
	public String viewMaterialMamesIndex() {

		return INDEX;
	}

	/**
	 * 查看标准信息表初始树列表
	 * 
	 * @return
	 * @throws BaseException
	 * @Action
	 */
	public String viewStandardsInitTree() throws BaseException {

		try {
			String id;
			String name = "";
			int count = 0;
			subjects = new Subjects();
			StringBuffer script = new StringBuffer();
			script.append("var tree = new WebFXTree(\"监理标准树\");\n");

			// 取所有标准
			Set gSet = BaseDataInfosUtil.getDictInfoToMap("1700").keySet();
			Iterator it = gSet.iterator();
			while (it.hasNext()) {
				id = it.next().toString();
				name = StringEscapeUtils.escapeXml(BaseDataInfosUtil.getDictInfoToMap("1700").get(id).toString());
				subjects.setStandardId(new Long(id));
				count =this.iSubjectsBIZ.getSubjectsCount(subjects);
				
				// 判断是否有子节点
				if (count > 0) {
					script.append("tree.add( rti = new WebFXLoadTreeItem(\""
							+ name +"("+count+")"
							+ "\", \"viewSubjectsTree_MaterialNames.action?&subjects.standardId="
							+ id + "\",\"\"));\n");

				} else {
					script.append("tree.add( new WebFXTreeItem(\"" + name
							+ "\",\"\"));\n");
				}
			}

			script.append("document.write(tree);\n");
			script.append("tree.expand();\n");

			tree = script.toString();

		} catch (Exception e) {
			log("查看标准信息表初始树列表错误！", e);
			throw new BaseException("查看标准信息表初始树列表错误！", e);
		}

		return TREE;
	}

	/**
	 * 查看专业信息表树列表
	 * 
	 * @return
	 * @throws BaseException
	 * @Action
	 */
	public String viewSubjectsTree() throws BaseException {

		try {
			Long id;
			int count = 0;
			String name = "";
			materialNames = new MaterialNames();
			List subtList = this.iSubjectsBIZ.getSubjectsList(subjects);
			StringBuffer script = new StringBuffer();
			script.append("<?xml version=\"1.0\"?>");
			script.append("<tree>");
			Iterator it = subtList.iterator();
			while (it.hasNext()) {
				Subjects subList = (Subjects) it.next();
				id = subList.getSubjId();
				name = StringEscapeUtils.escapeXml(subList.getSubjName().trim());
				materialNames .setSubjId(new Long(id));
				count = this.iMaterialNamesBiz.getMaterialNamesCount(materialNames);
				script.append("<tree text=\"" + name +"("+count+")"+ "\" id=\"" + id	+ "\" action=\"javascript:folderview('" + id + "')\" ");
				
				// 判断是否有子节点
//				 if ( count>0 ) {
//				script.append(
//						" src=\"viewStagesTree_risks.action?stages.belongSubjid=")
//						.append(id).append("\" ");
//				 }

				script.append("/>");

			}

			script.append("</tree>");

			getResponse().getWriter().println(script.toString());

		} catch (Exception e) {
			log("查看部门信息表初始树列表错误！", e);
			throw new BaseException("查看部门信息表初始树列表错误！", e);
		}

		return null;
	}

	
	/**
	 * 查看资料名称信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewMaterialNames() throws BaseException {
		
		try{	
				initQueryData() ;
				
				this.setListValue( this.iMaterialNamesBiz.getMaterialNamesList( this.getRollPage(), materialNames ) ) ;
				MMap=BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1704);
				List<MaterialTypes> mt =this.iMaterialTypesBIZ.getMaterialTypesList(materialTypes);
				this.getRequest().setAttribute("mt", mt);
				if(materialNames != null){
					subjects=this.iSubjectsBIZ.getSubjects(new Long(materialNames.getSubjId()));		
				}
				
				// 判断是否开发模式
				this.getRequest().setAttribute("debugMode", GlobalSetting.isDebugMode() ) ;
				
		} catch (Exception e) {
			log.error("查看资料名称信息列表错误！", e);
			throw new BaseException("查看监理资料名称信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 保存监理资料名称信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String saveMaterialNamesInit() throws BaseException {
		try{
			subjects=this.iSubjectsBIZ.getSubjects(subjects.getSubjId());
			List<MaterialTypes> mt =this.iMaterialTypesBIZ.getMaterialTypesList(materialTypes);
			this.getRequest().setAttribute("mt", mt);
			MMap=BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1704);
			this.getRequest().setAttribute("input", BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1706));
		} catch (Exception e) {
			
			log("保存监理资料名称信息初始化错误！", e);
			throw new BaseException("保存监理资料名称信息初始化错误！", e);
		}
		return ADD_INIT;
		
	}
	
	/**
	 * 保存监理资料名称信息
	 * @return
	 * @throws BaseException 
	 */
	public String saveMaterialNames() throws BaseException {
		
		try{
			this.iMaterialNamesBiz.saveMaterialNames( materialNames );
		} catch (Exception e) {
			log("保存监理资料名称信息错误！", e);
			throw new BaseException("保存监理资料名称信息错误！", e);
		}
		
		return ADD;
		
	}
	
	/**
	 * 修改监理资料名称信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String updateMaterialNamesInit() throws BaseException {
		
		try{
			MMap=BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1704);
			materialNames=this.iMaterialNamesBiz.getMaterialNames( materialNames.getMnId() );
			List<MaterialTypes> mt =this.iMaterialTypesBIZ.getMaterialTypesList(materialTypes);
			this.getRequest().setAttribute("mt", mt);
			materialNames.setSubName(BaseDataInfosUtil.convertSubjectIdToName(materialNames.getSubjId()));
			this.getRequest().setAttribute("input", BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1706));
		} catch (Exception e) {
			log("修改监理资料名称信息初始化错误！", e);
			throw new BaseException("修改监理资料名称信息初始化错误！", e);
		}
		return MODIFY_INIT;
		
	}
	
	/**
	 * 修改监理资料名称信息
	 * @return
	 * @throws BaseException 
	 */
	public String updateMaterialNames() throws BaseException {
		
		try{
			this.iMaterialNamesBiz.updateMaterialNames( materialNames );
		} catch (Exception e) {
			log("修改监理资料名称信息错误！", e);
			throw new BaseException("修改监理资料名称信息错误！", e);
		}
		return MODIFY;
		
	}
	
	/**
	 * 删除监理资料名称信息
	 * @return
	 * @throws BaseException 
	 */
	public String deleteMaterialNames() throws BaseException {
		try{
			materialNames=this.iMaterialNamesBiz.getMaterialNames(materialNames.getMnId());
			
			materialStages =new MaterialStages();
			materialStages.setMnId(materialNames.getMnId());
			List<MaterialStages> mn=this.iMaterialStagesBiz.getMaterialStagesList(materialStages);
			for(int i=0;i<mn.size();i++){
				if(StringUtil.isNotBlank(mn.get(i).getMnId())){
					this.iMaterialStagesBiz.deleteMaterialStages(mn.get(i).getMsId().toString());
				}
			}
			this.iMaterialNamesBiz.deleteMaterialNames( materialNames  );
		} catch (Exception e) {
			
			log("删除监理资料名称信息错误！", e);
			throw new BaseException("删除监理资料名称信息错误！", e);
		}
		return DELETE;
		
	}
	
	/**
	 * 查看监理资料名称明细信息
	 * @return
	 * @throws BaseException 
	 */
	public String viewMaterialNamesDetail() throws BaseException {
		
		try{
			materialNames =this.iMaterialNamesBiz.getMaterialNames( materialNames.getMnId());
			if(materialNames!=null){
				
				/*所属专业*/
				if(materialNames.getSubjId() != null){
					materialNames.setSubName(BaseDataInfosUtil.convertSubjectIdToName(materialNames.getSubjId()));
				}
				/*资料类别*/
				if(materialNames.getMtId() != null){
					materialNames.setMtIdName(this.iMaterialTypesBIZ.getMaterialTypes(materialNames.getMtId()).getMtName());
				}
				/*输入模块名称*/
				if(materialNames.getInputName()!=null){
					materialNames.setInputNameCn(BaseDataInfosUtil.convertDictCodeToName(materialNames.getInputName().toString(), DictStatus.COMMON_DICT_TYPE_1706));
				}
				/*资料来源*/
				if(materialNames.getComeFrom() != null){
					materialNames.setComeFromCn(BaseDataInfosUtil.convertDictCodeToName(materialNames.getComeFrom().toString(), DictStatus.COMMON_DICT_TYPE_1704));
				}
			}
		} catch (Exception e) {
			log("查看资料名称明细信息错误！", e);
			throw new BaseException("查看资料名称明细信息错误！", e);
		}
		return DETAIL;
		
	}
	
	/**
	 * 提交资料名称信息
	 * @return
	 * @throws BaseException 
	 */
	public String submitMaterialNames() throws BaseException {
		
		try{
//			this.MaterialNamesBiz.submitSubjects( subjects  );
		} catch (Exception e) {
			log("提交资料名称信息错误！", e);
			throw new BaseException("提交资料名称信息错误！", e);
		}
		return SUBMIT;
		
	}

	public IMaterialNamesBiz getIMaterialNamesBiz() {
		return iMaterialNamesBiz;
	}

	public void setIMaterialNamesBiz(IMaterialNamesBiz materialNamesBiz) {
		iMaterialNamesBiz = materialNamesBiz;
	}

	public MaterialNames getMaterialNames() {
		return materialNames;
	}

	public void setMaterialNames(MaterialNames materialNames) {
		this.materialNames = materialNames;
	}

	public String getTree() {
		return tree;
	}

	public void setTree(String tree) {
		this.tree = tree;
	}

	public Subjects getSubjects() {
		return subjects;
	}

	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}

	public IStagesBiz getIStagesBiz() {
		return iStagesBiz;
	}

	public void setIStagesBiz(IStagesBiz stagesBiz) {
		iStagesBiz = stagesBiz;
	}

	public ISubjectsBIZ getISubjectsBIZ() {
		return iSubjectsBIZ;
	}

	public void setISubjectsBIZ(ISubjectsBIZ subjectsBIZ) {
		iSubjectsBIZ = subjectsBIZ;
	}

	public Map getMMap() {
		return MMap;
	}

	public void setMMap(Map map) {
		MMap = map;
	}

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

	public IMaterialStagesBiz getiMaterialStagesBiz() {
		return iMaterialStagesBiz;
	}

	public void setiMaterialStagesBiz(IMaterialStagesBiz iMaterialStagesBiz) {
		this.iMaterialStagesBiz = iMaterialStagesBiz;
	}

	public IMaterialNamesBiz getiMaterialNamesBiz() {
		return iMaterialNamesBiz;
	}

	public void setiMaterialNamesBiz(IMaterialNamesBiz iMaterialNamesBiz) {
		this.iMaterialNamesBiz = iMaterialNamesBiz;
	}

	public IMaterialTypesBIZ getiMaterialTypesBIZ() {
		return iMaterialTypesBIZ;
	}

	public void setiMaterialTypesBIZ(IMaterialTypesBIZ iMaterialTypesBIZ) {
		this.iMaterialTypesBIZ = iMaterialTypesBIZ;
	}

	public MaterialStages getMaterialStages() {
		return materialStages;
	}

	public void setMaterialStages(MaterialStages materialStages) {
		this.materialStages = materialStages;
	}

	public IStagesBiz getiStagesBiz() {
		return iStagesBiz;
	}

	public void setiStagesBiz(IStagesBiz iStagesBiz) {
		this.iStagesBiz = iStagesBiz;
	}

	public ISubjectsBIZ getiSubjectsBIZ() {
		return iSubjectsBIZ;
	}

	public void setiSubjectsBIZ(ISubjectsBIZ iSubjectsBIZ) {
		this.iSubjectsBIZ = iSubjectsBIZ;
	}


	

}
