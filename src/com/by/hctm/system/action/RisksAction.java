package com.by.hctm.system.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringEscapeUtils;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.BaseDataInfosUtil;
import com.by.hctm.system.biz.IRisksBIZ;
import com.by.hctm.system.biz.IStagesBiz;
import com.by.hctm.system.biz.ISubjectsBIZ;
import com.by.hctm.system.entity.Risks;
import com.by.hctm.system.entity.Stages;
import com.by.hctm.system.entity.Subjects;

public class RisksAction extends BaseAction {
	private IRisksBIZ iRisksBiz  ;
	private IStagesBiz iStagesBiz;
	private ISubjectsBIZ iSubjectsBIZ;
	private Risks risks ;
	private Subjects subjects;
	private Stages stages;
	private String tree;
	private Map risksMap;

	/**
	 * 查看标准信息首页列表
	 * 
	 * @return
	 * @throws BaseException
	 * @Action
	 */
	public String viewSubjectsIndex() {

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
				count = iSubjectsBIZ.getSubjectsCount(subjects);
				// 判断是否有子节点
				if (count > 0) {
					script.append("tree.add( rti = new WebFXLoadTreeItem(\""
							+ name+ "("+count+")"
							+ "\", \"viewSubjectsTree_risks.action?&subjects.standardId="
							+ id + "\",\"\"));\n");
				} else {
					script.append("tree.add( new WebFXTreeItem(\"" + name + "("+count+")"
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
				name = StringEscapeUtils
						.escapeXml(subList.getSubjName().trim());
				stages.setBelongSubjid(new Long(id));
				count= this.iStagesBiz.getStagesCount(stages);
				script.append("<tree text=\"" + name + "("+count+")"+"\" id=\"" + id	+ "\" action=\"javascript:\" ");
				// 判断是否有子节点
				 if ( count>0 ) {
				script.append(
						" src=\"viewStagesTree_risks.action?stages.belongSubjid=")
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
			int count = 0;
			String name = "";
			risks = new Risks();
			List stagestList = this.iStagesBiz.getStagesList(stages);
			StringBuffer script = new StringBuffer();
			script.append("<?xml version=\"1.0\"?>");
			script.append("<tree>");
			Iterator it = stagestList.iterator();
			while (it.hasNext()) {
				Stages stsList = (Stages) it.next();
				id = stsList.getStageId();
				name = StringEscapeUtils.escapeXml(stsList.getStageName().trim());
				risks.setStageId(new Long(id));
				count = this.iRisksBiz.getRisksCount(risks);
				script.append("<tree text=\"" + name +"("+count+")" +"\" id=\"" + id	+ "\" action=\"javascript:folderview('" + id + "')\" ");
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
	 * 查看工序信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewRisks() throws BaseException {
		
		try{
			this.setListValue( this.iRisksBiz.getRisksList( this.getRollPage(), risks ) ) ;
			
			if(stages!=null){
				System.out.println(risks.getStageId());
				stages =this.iStagesBiz.getStages(risks.getStageId());
			}
			
		} catch (Exception e) {
			log.error("查看工序信息列表错误！", e);
			throw new BaseException("查看工序信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 保存工序信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String saveRisksInit() throws BaseException {
		try{
			stages=this.iStagesBiz.getStages(risks.getStageId());
			risksMap = BaseDataInfosUtil.getDictInfoToMap("1703");
		} catch (Exception e) {
			log("保存工序信息初始化错误！", e);
			throw new BaseException("保存工序信息初始化错误！", e);
		}
		return ADD_INIT;
		
	}
	
	/**
	 * 保存工序信息
	 * @return
	 * @throws BaseException 
	 */
	public String saveRisks() throws BaseException {
		
		try{
			this.iRisksBiz.saveRisks( risks );
		} catch (Exception e) {
			log("保存工序信息错误！", e);
			throw new BaseException("保存工序信息错误！", e);
		}
		
		return ADD;
		
	}
	
	/**
	 * 修改工序信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String updateRisksInit() throws BaseException {
		
		try{
			risks=this.iRisksBiz.getRisks( risks.getRiskId() );
			stages=this.iStagesBiz.getStages(risks.getStageId());
			risksMap = BaseDataInfosUtil.getDictInfoToMap("1703");
		} catch (Exception e) {
			log("修改工序信息初始化错误！", e);
			throw new BaseException("修改工序信息初始化错误！", e);
		}
		return MODIFY_INIT;
		
	}
	
	/**
	 * 修改工序信息
	 * @return
	 * @throws BaseException 
	 */
	public String updateRisks() throws BaseException {
		
		try{
			this.iRisksBiz.updateRisks( risks );
		} catch (Exception e) {
			log("修改工序信息错误！", e);
			throw new BaseException("修改工序信息错误！", e);
		}
		return MODIFY;
		
	}
	
	/**
	 * 删除工序信息
	 * @return
	 * @throws BaseException 
	 */
	public String deleteRisks() throws BaseException {
		try{
			risks=this.iRisksBiz.getRisks(risks.getRiskId());
			risks.setIsUsable("1");
			//this.iRisksBiz.deleteRisks( risks);
		} catch (Exception e) {
			log("删除工序信息错误！", e);
			throw new BaseException("删除工序信息错误！", e);
		}
		return DELETE;
		
	}
	
	/**
	 * 查看工序明细信息
	 * @return
	 * @throws BaseException 
	 */
	public String viewRisksDetail() throws BaseException {
		
		try{
			risks=this.iRisksBiz.getRisks( risks.getRiskId() );
		} catch (Exception e) {
			log("查看工序明细信息错误！", e);
			throw new BaseException("查看工序明细信息错误！", e);
		}
		return DETAIL;
		
	}
	
	/**
	 * 提交工序信息
	 * @return
	 * @throws BaseException 
	 */
	public String submitRisks() throws BaseException {
		
		try{
//			this.RisksBiz.submitSubjects( subjects  );
		} catch (Exception e) {
			log("提交工序信息错误！", e);
			throw new BaseException("提交工序信息错误！", e);
		}
		return SUBMIT;
		
	}


	/**
	 * 综合条件查询信息
	 * @return
	 * @throws BaseException
	 */
	public String conditionViewRisks()throws BaseException {
		try{
			this.setListValue(iRisksBiz.getRisksList(this.getRollPage(),risks));
		}catch (Exception e) {
			log("提交工序信息错误！", e);
			throw new BaseException("提交工序信息错误！", e);
		}
		return "condition";
	}
	
	
	
	public IRisksBIZ getIRisksBiz() {
		return iRisksBiz;
	}

	public void setIRisksBiz(IRisksBIZ risksBiz) {
		iRisksBiz = risksBiz;
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

	public Risks getRisks() {
		return risks;
	}

	public void setRisks(Risks risks) {
		this.risks = risks;
	}

	public Subjects getSubjects() {
		return subjects;
	}

	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}

	public Stages getStages() {
		return stages;
	}

	public void setStages(Stages stages) {
		this.stages = stages;
	}

	public String getTree() {
		return tree;
	}

	public void setTree(String tree) {
		this.tree = tree;
	}

	public Map getRisksMap() {
		return risksMap;
	}

	public void setRisksMap(Map risksMap) {
		this.risksMap = risksMap;
	}

	
}
