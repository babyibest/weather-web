package com.by.hctm.system.action;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringEscapeUtils;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.BaseDataInfosUtil;
import com.by.hctm.system.biz.IStagesBiz;
import com.by.hctm.system.biz.ISubjectsBIZ;
import com.by.hctm.system.entity.Stages;
import com.by.hctm.system.entity.Subjects;

@SuppressWarnings("serial")
public class StagesAction extends BaseAction {
	private IStagesBiz iStagesBiz;
	private Stages stages;
	private Subjects subjects;
	private ISubjectsBIZ iSubjectsBIZ;
	private String tree;

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
				name = StringEscapeUtils
						.escapeXml(BaseDataInfosUtil.getDictInfoToMap("1700").get(id).toString());
				subjects.setStandardId(new Long(id));

				count = this.iSubjectsBIZ.getSubjectsCount(subjects);
				// 判断是否有子节点
				if (count > 0) {
					script.append("tree.add( rti = new WebFXLoadTreeItem(\""
							+ name+"("+count+")"+ "\", \"viewSubjectsTree_stages.action?&subjects.standardId="
							+ id + "\",\"\"));\n");

				} else {
					script.append("tree.add( new WebFXTreeItem(\"" + name+"("+count+")"+ "\",\"\"));\n");
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
			int count;
			Long id;
			String name = "";

			List subtList = this.iSubjectsBIZ.getSubjectsList(subjects);

			StringBuffer script = new StringBuffer();
			script.append("<?xml version=\"1.0\"?>");
			script.append("<tree>");
			Iterator it = subtList.iterator();
			while (it.hasNext()) {
				Subjects subList = (Subjects) it.next();
				id = subList.getSubjId();
				name = StringEscapeUtils.escapeXml(subList.getSubjName().trim());
				stages = new Stages();
				stages.setBelongSubjid(id);
				count = this.iStagesBiz.getStagesCount(stages);
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
	 * 查看工序信息列表
	 * 
	 * @return
	 * @throws BaseException
	 * @Action
	 */
	public String viewStages() throws BaseException {

		try {
			this.setListValue(this.iStagesBiz.getStagesList(this.getRollPage(),	stages));
				subjects=this.iSubjectsBIZ.getSubjects(stages.getBelongSubjid());
		} catch (Exception e) {
			log.error("查看工序信息列表错误！", e);
			throw new BaseException("查看工序信息列表错误！", e);
		}

		return VIEW;

	}


	/**
	 * 保存工序信息初始化
	 * 
	 * @return
	 * @throws BaseException
	 */
	public String saveStagesInit() throws BaseException {
		try {
			
			subjects = this.iSubjectsBIZ.getSubjects(subjects.getSubjId());

		} catch (Exception e) {
			log("保存工序信息初始化错误！", e);
			throw new BaseException("保存工序信息初始化错误！", e);
		}
		return ADD_INIT;

	}

	/**
	 * 保存工序信息
	 * 
	 * @return
	 * @throws BaseException
	 */
	public String saveStages() throws BaseException {

		try {
			this.iStagesBiz.saveStages(stages);
		} catch (Exception e) {
			log("保存工序信息错误！", e);
			throw new BaseException("保存工序信息错误！", e);
		}

		return ADD;

	}

	/**
	 * 修改工序信息初始化
	 * 
	 * @return
	 * @throws BaseException
	 */
	public String updateStagesInit() throws BaseException {

		try {
			stages = this.iStagesBiz.getStages(stages.getStageId());
			subjects = this.iSubjectsBIZ.getSubjects(stages.getBelongSubjid());
		} catch (Exception e) {
			log("修改工序信息初始化错误！", e);
			throw new BaseException("修改工序信息初始化错误！", e);
		}
		return MODIFY_INIT;

	}

	/**
	 * 修改工序信息
	 * 
	 * @return
	 * @throws BaseException
	 */
	public String updateStages() throws BaseException {

		try {
			this.iStagesBiz.updateStages(stages);
		} catch (Exception e) {
			log("修改工序信息错误！", e);
			throw new BaseException("修改工序信息错误！", e);
		}
		return MODIFY;

	}

	/**
	 * 删除工序信息
	 * 
	 * @return
	 * @throws BaseException
	 */
	public String deleteStages() throws BaseException {
		try {
			stages=this.iStagesBiz.getStages(stages.getStageId());
			stages.setIsUsable("1");
			//this.iStagesBiz.deleteStages(stages.getStageId());
		
		} catch (Exception e) {
			log("删除工序信息错误！", e);
			throw new BaseException("删除工序信息错误！", e);
		}
		return DELETE;

	}

	/**
	 * 查看工序明细信息
	 * 
	 * @return
	 * @throws BaseException
	 */
	public String viewStagesDetail() throws BaseException {

		try {
			stages = this.iStagesBiz.getStages(stages.getStageId());
		} catch (Exception e) {
			log("查看工序明细信息错误！", e);
			throw new BaseException("查看工序明细信息错误！", e);
		}
		return DETAIL;

	}

	/**
	 * 根据专业获取工序信息信息
	 * 
	 * @return
	 * @throws BaseException
	 */
	public String subIdStages() throws BaseException {

		try {
			// this.StagesBiz.submitSubjects( subjects );
			this.iStagesBiz.getStagesList(stages);
		} catch (Exception e) {
			log("提交工序信息错误！", e);
			throw new BaseException("提交工序信息错误！", e);
		}
		return SUBMIT;

	}

	/**
	 * 提交工序信息
	 * 
	 * @return
	 * @throws BaseException
	 */
	public String submitStages() throws BaseException {

		try {
			// this.StagesBiz.submitSubjects( subjects );
		} catch (Exception e) {
			log("提交工序信息错误！", e);
			throw new BaseException("提交工序信息错误！", e);
		}
		return SUBMIT;

	}

	/**
	 * 提交获取工序信息
	 * 
	 * @return
	 * @throws BaseException
	 */
	public String codeStages() throws BaseException {

		try {
			// this.StagesBiz.submitSubjects( subjects );
		} catch (Exception e) {
			log("提交工序信息错误！", e);
			throw new BaseException("提交工序信息错误！", e);
		}
		return SUBMIT;

	}

	public IStagesBiz getiStagesBiz() {
		return iStagesBiz;
	}

	public void setiStagesBiz(IStagesBiz iStagesBiz) {
		this.iStagesBiz = iStagesBiz;
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


}
