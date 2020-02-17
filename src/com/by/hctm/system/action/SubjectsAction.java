package com.by.hctm.system.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang.StringEscapeUtils;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.BaseDataInfosUtil;
import com.by.hctm.common.DictStatus;
import com.by.hctm.system.biz.ISubjectsBIZ;
import com.by.hctm.system.entity.Subjects;

public class SubjectsAction extends BaseAction  {

	private ISubjectsBIZ ISubjectsBIZ;
	private Subjects subjects;
	private String tree ;
	
	/**
	 * 查看标准信息首页列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewStandardsIndex() {
		return INDEX ;
	}
	
	/**
	 * 查看标准信息表初始树列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewStandardsInitTree() throws BaseException {
		
		try{
			String id;
			String name = "";
			int count = 0 ; 
			StringBuffer script = new StringBuffer();
			script.append("var tree = new WebFXTree(\"监理标准树\");\n");
			
			// 取所有标准
			Set gSet = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1700).keySet() ;
			
			Iterator it= gSet.iterator();
			
			while (it.hasNext()) {
				id = it.next().toString() ;
				name = StringEscapeUtils.escapeXml( BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1700).get( id ).toString() );
				subjects = new Subjects();
				subjects.setStandardId(new Long(id));
				count = this.ISubjectsBIZ.getSubjectsCount(subjects);
					
				// 判断是否有子节点
//				if ( count > 0 ) {
//					script.append("tree.add( rti = new WebFXLoadTreeItem(\"" + name + "\", \"viewDepartmentsTree_dept.action?&departments.parentDeptId=" + id + "\",\"\"));\n");
					
//				} else {
					script.append("tree.add( new WebFXTreeItem(\"" + name +"("+count+")"+"\",\"javascript:folderview('" + id + "')\"));\n");
//				}
			}
			
			script.append("document.write(tree);\n");
			script.append("tree.expand();\n"); 

			tree = script.toString() ;
			
		} catch (Exception e) {
			log("查看标准信息表初始树列表错误！", e);
			throw new BaseException("查看标准信息表初始树列表错误！", e);
		}
		
		return TREE ;
	}
	
	/**
	 * 查看项目专业信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewSubjects()  throws BaseException {
		
		try{

			if(subjects!=null){
				if( subjects.getStandardId() != null && subjects.getStandardId().longValue() == 0 ) {
					subjects.setBelongStandard( "所有" ) ;
				}else {
					subjects.setBelongStandard( BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1700).get( subjects.getStandardId().toString() ).toString() ) ;
				}
		}
			this.setListValue( this.ISubjectsBIZ.getSubjectsList( subjects ) ) ;
		} catch (Exception e) {
			log("查看项目专业信息列表错误！", e);
			throw new BaseException("查看项目专业信息列表错误！", e);
		}
		
		return VIEW ;
	}
	

	/**
	 * 保存项目专业信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String saveSubjectsInit() throws BaseException {
		try{

		} catch (Exception e) {
			log("保存项目专业信息初始化错误！", e);
			throw new BaseException("保存项目专业信息初始化错误！", e);
		}
		return ADD_INIT;
		
	}
	
	/**
	 * 保存项目专业信息
	 * @return
	 * @throws BaseException 
	 */
	public String saveSubjects() throws BaseException {

		try{
			this.ISubjectsBIZ.saveSubjects( subjects );
			this.message("保存成功");
		} catch (Exception e) {
			log("保存项目专业信息错误！", e);
			throw new BaseException("保存项目专业信息错误！", e);
		}
		
		return ADD;
		
	}
	
	/**
	 * 修改项目专业信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String updateSubjectsInit() throws BaseException {
		try{
			subjects=this.ISubjectsBIZ.getSubjects( subjects.getSubjId() );
		} catch (Exception e) {
			log("修改项目专业信息初始化错误！", e);
			throw new BaseException("修改项目专业信息初始化错误！", e);
		}
		return MODIFY_INIT;
		
	}
	
	/**
	 * 修改项目专业信息
	 * @return
	 * @throws BaseException 
	 */
	public String updateSubjects() throws BaseException {
		try{
			this.ISubjectsBIZ.updateSubjects( subjects );
			this.message("删除成功");
		} catch (Exception e) {
			log("修改项目专业信息错误！", e);
			throw new BaseException("修改项目专业信息错误！", e);
		}
		return MODIFY;
		
	}
	
	/**
	 * 删除项目专业信息
	 * @return
	 * @throws BaseException 
	 */
	public String delSubjects() throws BaseException {
		try{
			//伪删除数据
			subjects =this.ISubjectsBIZ.getSubjects(subjects.getSubjId());
			subjects.setIsUsable("1");
			this.ISubjectsBIZ.updateSubjects(subjects);
			//this.ISubjectsBIZ.deleteSubjects( subjects  );
			
		} catch (Exception e) {
			log("删除项目专业信息错误！", e);
			throw new BaseException("删除项目专业信息错误！", e);
		}
		return DELETE;
		
	}
	@SuppressWarnings("unused")
	private  void message(String str) throws IOException{
		this.getResponse().setContentType("text/html; charset=UTF-8"); //转码
	    PrintWriter out = this.getResponse().getWriter();
	    out.flush();
	    out.println("<script>");
	    out.println("alert('"+str+"!');");
	    out.println("parent.location.reload();");
	    out.println("</script>");
	}

	
	public ISubjectsBIZ getISubjectsBIZ() {
		return ISubjectsBIZ;
	}

	public void setISubjectsBIZ(ISubjectsBIZ subjectsBIZ) {
		ISubjectsBIZ = subjectsBIZ;
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
	
}
