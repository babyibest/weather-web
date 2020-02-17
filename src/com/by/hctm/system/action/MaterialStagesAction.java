package com.by.hctm.system.action;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringEscapeUtils;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.BaseDataInfosUtil;
import com.by.hctm.common.DictStatus;
import com.by.hctm.system.biz.IMaterialNamesBiz;
import com.by.hctm.system.biz.IMaterialStagesBiz;
import com.by.hctm.system.biz.IMaterialTypesBIZ;
import com.by.hctm.system.biz.IStagesBiz;
import com.by.hctm.system.biz.ISubjectsBIZ;
import com.by.hctm.system.entity.MaterialNames;
import com.by.hctm.system.entity.MaterialStages;
import com.by.hctm.system.entity.MaterialTypes;
import com.by.hctm.system.entity.Stages;
import com.by.hctm.system.entity.Subjects;

public class MaterialStagesAction extends BaseAction {
	private IMaterialNamesBiz iMaterialNamesBiz  ;
	private MaterialNames materialNames ;
	private MaterialTypes materialTypes;
	private IMaterialTypesBIZ iMaterialTypesBIZ;
	private IMaterialStagesBiz iMaterialStagesBiz  ;
	private MaterialStages materialStages ;
	private IStagesBiz iStagesBiz;
	private ISubjectsBIZ iSubjectsBIZ;
	private Stages stages;
	private Subjects subjects;
	private String tree;

	
	/**
	 * 查看标准信息首页列表
	 * 
	 * @return
	 * @throws BaseException
	 * @Action
	 */
	public String viewMaterialStagesIndex() {

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
			script.append("var tree = new WebFXTree(\"机构树\");\n");

			// 取所有标准
			Set gSet =BaseDataInfosUtil.getDictInfoToMap("1700").keySet();
			Iterator it = gSet.iterator();
			while (it.hasNext()) {
				id = it.next().toString();
				name = StringEscapeUtils.escapeXml(BaseDataInfosUtil.getDictInfoToMap("1700").get(id).toString());
				subjects.setStandardId(new Long(id));

				count = this.iSubjectsBIZ.getSubjectsCount(subjects);
				// 判断是否有子节点
				if (count > 0) {
					script.append("tree.add( rti = new WebFXLoadTreeItem(\""
							+ name + "("+count+ ")"+ "\", \"viewSubjectsTree_MaterialStages.action?&subjects.standardId="+ id + "\",\"\"));\n");

				} 
				else {
					script.append("tree.add( new WebFXTreeItem(\"" + name+ "\",\"\"));\n");
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
			String name = "";
			int count=0;
			List subtList = this.iSubjectsBIZ.getSubjectsList(subjects);
			stages=new Stages();
			StringBuffer script = new StringBuffer();
			script.append("<?xml version=\"1.0\"?>");
			script.append("<tree>");
			Iterator it = subtList.iterator();
			while (it.hasNext()) {
				Subjects subList = (Subjects) it.next();
				id = subList.getSubjId();
				name = StringEscapeUtils.escapeXml(subList.getSubjName().trim());
				stages.setBelongSubjid(new Long(id));
				count = this.iStagesBiz.getStagesCount(stages);
				script.append("<tree text=\"" + name +"("+count+")"+ "\" id=\"" + id	+ "\" action=\"javascript:\" ");
				// 判断是否有子节点
				 if ( count>0 ) {
				script.append(
						" src=\"viewStagesTree_MaterialStages.action?stages.belongSubjid=")
						.append(id).append("\" ");
				 }

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
	 * 查看专业信息表树列表
	 * 
	 * @return
	 * @throws BaseException
	 * @Action
	 */
	public String viewStagesTree() throws BaseException {

		try {
			Long id;
			String name = "";
			int count = 0;
			materialStages = new MaterialStages();
			List stagestList = this.iStagesBiz.getStagesList(stages);
			StringBuffer script = new StringBuffer();
			script.append("<?xml version=\"1.0\"?>");
			script.append("<tree>");
			Iterator it = stagestList.iterator();
			while (it.hasNext()) {
				Stages stsList = (Stages) it.next();
				id = stsList.getStageId();
				name = StringEscapeUtils.escapeXml(stsList.getStageName().trim());
				materialStages.setStageId(new Long(id));
				count = this.iMaterialStagesBiz.getMaterialStagesCount(materialStages);
				script.append("<tree text=\"" + name +"("+count+")"+ "\" id=\"" + id	+ "\" action=\"javascript:folderview('" + id + "')\" ");
				// 判断是否有子节点
				// if ( "0".equals( departments.getIsHaveChild() ) ) {
//				script.append(
//						" src=\"viewDepartmentsTree_dept.action?departments.parentDeptId=")
//						.append(id).append("\" ");
				// }

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
	 * 查看监理资料工序对应信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewMaterialStages() throws BaseException {
		
		try{
		
			if(materialStages!=null&&materialStages.getStageId()!=null){
				stages=this.iStagesBiz.getStages(materialStages.getStageId());
			}
			this.getRequest().setAttribute("nComeFrom", BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1704));
			this.getRequest().setAttribute("nType", (List<MaterialTypes>)this.iMaterialTypesBIZ.getMaterialTypesList(materialTypes));
			this.setListValue(this.iMaterialStagesBiz.gMaterialStagesList(this.getRollPage(), materialStages ,materialNames ));
		} catch (Exception e) {
			log.error("查看监理资料工序对应信息列表错误！", e);
			throw new BaseException("查看监理资料工序对应信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 查看监理资料工序对应信息列表a
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewQueryMaterialStages() throws BaseException {
		
		try{
			List list=this.iMaterialStagesBiz.gMaterialStagesList(this.getRollPage(), materialStages,materialNames );
			stages=this.iStagesBiz.getStages(stages.getStageId());
			this.setListValue(list);
//			System.out.println(stages.getBelongSubjid());
			
		} catch (Exception e) {
			log.error("查看监理资料工序对应信息列表错误！", e);
			throw new BaseException("查看监理资料工序对应信息列表错误！", e);
		}
		
		return "viewquery" ;
		
	}
	
	
	
	
	/**
	 * 保存监理资料工序对应信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String saveMaterialStagesInit() throws BaseException {
		try{
		} catch (Exception e) {
			log("保存监理资料工序对应信息初始化错误！", e);
			throw new BaseException("保存监理资料工序对应信息初始化错误！", e);
		}
		return ADD_INIT;
		
	}
	
	/**
	 * 增加资料初始化信息
	 * @return
	 * @throws BaseException 
	 */
	public String subMaterialInitStages() throws BaseException {
		
		try{
			this.setListValue( this.iMaterialNamesBiz.MaterialNameList(this.getRollPage(), materialNames,materialStages));
			this.getRequest().setAttribute("mt", this.iMaterialTypesBIZ.getMaterialTypesList(materialTypes));
			this.getRequest().setAttribute("MMap", BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1704));
			
		} catch (Exception e) {
			log("保存监理资料工序对应信息错误！", e);
			throw new BaseException("保存监理资料工序对应信息错误！", e);
		}
		
		return "subjects";
		
	}
	/**
	 * 保存监理资料工序对应信息
	 * @return
	 * @throws BaseException 
	 */
	public String saveMaterialStages() throws BaseException {
		
		try{
			String ms = this.getRequest().getParameter("str");
			String str [] = ms.split(",");
			for(int i=0;i<str.length;i++){
				MaterialStages mss=new MaterialStages();
				mss.setStageId(materialStages.getStageId());
				mss.setMnId(new Long (str[i]));
				this.iMaterialStagesBiz.saveMaterialStages(mss);
			}
			
		} catch (Exception e) {
			log("保存监理资料工序对应信息错误！", e);
			throw new BaseException("保存监理资料工序对应信息错误！", e);
		}
		
		return ADD;
		
	}
	
	/**
	 * 修改监理资料工序对应信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String updateMaterialStagesInit() throws BaseException {
		
		try{
			materialStages=this.iMaterialStagesBiz.getMaterialStages( materialStages.getMsId());
		} catch (Exception e) {
			log("修改监理资料工序对应信息初始化错误！", e);
			throw new BaseException("修改监理资料工序对应信息初始化错误！", e);
		}
		return MODIFY_INIT;
		
	}
	
	/**
	 * 修改监理资料工序对应信息
	 * @return
	 * @throws BaseException 
	 */
	public String updateMaterialStages() throws BaseException {
		
		try{
			this.iMaterialStagesBiz.updateMaterialStages( materialStages );
		} catch (Exception e) {
			log("修改监理资料工序对应信息错误！", e);
			throw new BaseException("修改监理资料工序对应信息错误！", e);
		}
		return MODIFY;
		
	}
	
	/**
	 * 删除监理资料工序对应信息
	 * @return
	 * @throws BaseException 
	 */
	public String deleteMaterialStages() throws BaseException {
		try{
			materialStages=this.iMaterialStagesBiz.getMaterialStages(materialStages.getMsId());
			iMaterialStagesBiz.deleteMaterialStages( materialStages  );
		} catch (Exception e) {
			log("删除监理资料工序对应信息错误！", e);
			throw new BaseException("删除监理资料工序对应信息错误！", e);
		}
		return DELETE;
		
	}
	
	/**
	 * 查看监理资料工序对应明细信息
	 * @return
	 * @throws BaseException 
	 */
	public String viewMaterialStagesDetail() throws BaseException {
		
		try{
			materialNames=this.iMaterialNamesBiz.getMaterialNames(materialNames.getMnId());
		} catch (Exception e) {
			log("查看监理资料工序对应明细信息错误！", e);
			throw new BaseException("查看监理资料工序对应明细信息错误！", e);
		}
		return DETAIL;
		
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

	public IMaterialStagesBiz getIMaterialStagesBiz() {
		return iMaterialStagesBiz;
	}

	public void setIMaterialStagesBiz(IMaterialStagesBiz materialStagesBiz) {
		iMaterialStagesBiz = materialStagesBiz;
	}

	public MaterialStages getMaterialStages() {
		return materialStages;
	}

	public void setMaterialStages(MaterialStages materialStages) {
		this.materialStages = materialStages;
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

	public Stages getStages() {
		return stages;
	}

	public void setStages(Stages stages) {
		this.stages = stages;
	}

	public Subjects getSubjects() {
		return subjects;
	}

	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}

	public String getTree() {
		return tree;
	}

	public void setTree(String tree) {
		this.tree = tree;
	}

	public MaterialTypes getMaterialTypes() {
		return materialTypes;
	}

	public void setMaterialTypes(MaterialTypes materialTypes) {
		this.materialTypes = materialTypes;
	}

	public IMaterialTypesBIZ getIMaterialTypesBIZ() {
		return iMaterialTypesBIZ;
	}

	public void setIMaterialTypesBIZ(IMaterialTypesBIZ materialTypesBIZ) {
		iMaterialTypesBIZ = materialTypesBIZ;
	}
	
}
