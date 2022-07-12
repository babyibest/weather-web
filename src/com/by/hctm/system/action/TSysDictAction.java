package com.by.hctm.system.action;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.BaseDataInfosUtil;
import com.by.hctm.common.TableStatus;
import com.by.hctm.common.UserRightInfoUtil;
import com.by.hctm.system.biz.ITSysDictBiz;
import com.by.hctm.system.entity.TSysDict;

public class TSysDictAction extends BaseAction {
	private ITSysDictBiz iTSysDictBiz  ;
	private TSysDict dict ;
	private TSysDict parentDict ;
	private String tree ;
	private String message ;
	
	/**
	 * 查看字典信息首页列表
	 * 
	 * @return
	 * @throws BaseException
	 * @Action
	 */
	public String viewDictIndex() {

		return INDEX;
	}

	/**
	 * 查看字典信息表初始树列表 getTree
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewDictInitTree() throws BaseException {
		
		try{
			Long id;
			String name = "";
			
			// 初始父ID为零
			TSysDict dict = new TSysDict() ;
			dict.setParentDictId( new Long(1) ) ;
			List deptList = iTSysDictBiz.getTSysDictList( dict );
			
			StringBuffer script = new StringBuffer();
			script.append("var tree = new WebFXTree(\"字典类型树\");\n");
			Iterator it=	deptList.iterator();
			
			while (it.hasNext()) {
				TSysDict	sdict=(TSysDict)it.next();
				id = sdict.getDictId();
				name = StringEscapeUtils.escapeXml(sdict.getDictName().trim());
				
				// 判断是否有子节点
				if ("0".equals( sdict.getIsHaveChild() )) {
					script.append("tree.add( rti = new WebFXLoadTreeItem(\"" + name + "\", \"viewDictTree_dict.action?dict.parentDictId=" + id + "\",\"\"));\n");
					
				} else {
					script.append("tree.add( new WebFXTreeItem(\"" + name + "\",\"javascript:folderview('" + id + "')\"));\n");
				}
			}
			
			script.append("document.write(tree);\n");
			script.append("tree.expand();\n"); 

			tree = script.toString() ;
			
		} catch (Exception e) {
			log("查看字典信息表初始树列表错误！", e);
			throw new BaseException("查看字典信息表初始树列表错误！", e);
		}
		
		return TREE ;
	}
	
	/**
	 * 查看字典信息表树列表 
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewDictTree() throws BaseException {
		
		try{
			Long id;
			String name = "";
			
			List deptList = iTSysDictBiz.getTSysDictList( dict );
			StringBuffer script = new StringBuffer();
			script.append("<?xml version=\"1.0\"?>");
			script.append("<tree>");
			Iterator it=deptList.iterator();
			while (it.hasNext()) {
				TSysDict sdict = (TSysDict)it.next();
				id 		= sdict.getDictId();
				name 	= StringEscapeUtils.escapeXml(sdict.getDictName().trim());
				
				script.append("<tree text=\"" + name + "\" id=\"" + id + "\" action=\"javascript:folderview('" + id + "')\" ");
				// 判断是否有子节点
//				if ( "0".equals( departments.getIsHaveChild() ) ) {
//					script.append(" src=\"viewDepartmentsTree_dept.action?departments.parentDeptId=").append(id).append("\" ");
//				}
				
				script.append("/>");
				
			}
			
			script.append("</tree>");
			
			getResponse().getWriter().println(script.toString());
			
		} catch (Exception e) {
			log("查看字典信息表初始树列表错误！", e);
			throw new BaseException("查看字典信息表初始树列表错误！", e);
		}
		
		return null ;
	}
	
	/**
	 * 查看字典信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewTSysDict() throws BaseException {
		
		try{
			parentDict = this.iTSysDictBiz.getTSysDict( dict.getParentDictId() ) ;
			this.setListValue( this.iTSysDictBiz.getTSysDictList( dict ) ) ;
		} catch (Exception e) {
			log.error("查看字典信息列表错误！", e);
			throw new BaseException("查看字典信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 保存字典信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String saveTSysDictInit() throws BaseException {
		try{
			parentDict = this.iTSysDictBiz.getTSysDict( dict.getParentDictId() ) ;
		} catch (Exception e) {
			log("保存字典信息初始化错误！", e);
			throw new BaseException("保存字典信息初始化错误！", e);
		}
		return ADD_INIT;
		
	}
	
	/**
	 * 保存字典信息
	 * @return
	 * @throws BaseException 
	 */
	public String saveTSysDict() throws BaseException {
		
		try{
			dict.setCreateMan( UserRightInfoUtil.getUserName( this.getRequest() ) ) ;
			dict.setCreateTime( this.getCurrentDateTime() ) ;
			
			this.iTSysDictBiz.saveTSysDict( dict );
			
			BaseDataInfosUtil.initBaseIndexInfos( TableStatus.BASE_DATA_TYPE_03 ) ;
		} catch (Exception e) {
			log("保存字典信息错误！", e);
			throw new BaseException("保存字典信息错误！", e);
		}
		
		return ADD;
		
	}
	
	/**
	 * 修改字典信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String updateTSysDictInit() throws BaseException {
		
		try{
			dict=this.iTSysDictBiz.getTSysDict( dict.getDictId() );
			parentDict = this.iTSysDictBiz.getTSysDict( dict.getParentDictId() ) ;
		} catch (Exception e) {
			log("修改字典信息初始化错误！", e);
			throw new BaseException("修改字典信息初始化错误！", e);
		}
		return MODIFY_INIT;
		
	}
	
	/**
	 * 修改字典信息
	 * @return
	 * @throws BaseException 
	 */
	public String updateTSysDict() throws BaseException {
		
		try{
			dict.setCreateMan( UserRightInfoUtil.getUserName( this.getRequest() ) ) ;
			dict.setCreateTime( this.getCurrentDateTime() ) ;
			
			this.iTSysDictBiz.updateTSysDict( dict );
			
			BaseDataInfosUtil.initBaseIndexInfos( TableStatus.BASE_DATA_TYPE_03 ) ;
		} catch (Exception e) {
			log("修改字典信息错误！", e);
			throw new BaseException("修改字典信息错误！", e);
		}
		return MODIFY;
		
	}
	
	/**
	 * 删除字典信息
	 * @return
	 * @throws BaseException 
	 */
	public String deleteTSysDict() throws BaseException {
		try{
			dict=this.iTSysDictBiz.getTSysDict( dict.getDictId() );
			dict.setIsUsable( TableStatus.COMMON_STATUS_INVALID ) ;
			this.iTSysDictBiz.updateTSysDict( dict );
			
			BaseDataInfosUtil.initBaseIndexInfos( TableStatus.BASE_DATA_TYPE_03 ) ;
		} catch (Exception e) {
			log("删除字典信息错误！", e);
			throw new BaseException("删除字典信息错误！", e);
		}
		return DELETE;
		
	}
	
	/**
	 * 查看字典明细信息
	 * @return
	 * @throws BaseException 
	 */
	public String viewTSysDictDetail() throws BaseException {
		
		try{
			dict=this.iTSysDictBiz.getTSysDict( dict.getDictId() );
		} catch (Exception e) {
			log("查看字典明细信息错误！", e);
			throw new BaseException("查看字典明细信息错误！", e);
		}
		return DETAIL;
		
	}

	public ITSysDictBiz getTSysDictBiz() {
		return iTSysDictBiz;
	}

	public void setTSysDictBiz(ITSysDictBiz iTSysDictBiz) {
		this.iTSysDictBiz = iTSysDictBiz;
	}

	public TSysDict getParentDict() {
		return parentDict;
	}

	public void setParentDict(TSysDict parentDict) {
		this.parentDict = parentDict;
	}

	public TSysDict getDict() {
		return dict;
	}

	public void setDict(TSysDict dict) {
		this.dict = dict;
	}

	public ITSysDictBiz getITSysDictBiz() {
		return iTSysDictBiz;
	}

	public void setITSysDictBiz(ITSysDictBiz sysDictBiz) {
		iTSysDictBiz = sysDictBiz;
	}

	public String getTree() {
		return tree;
	}

	public void setTree(String tree) {
		this.tree = tree;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
