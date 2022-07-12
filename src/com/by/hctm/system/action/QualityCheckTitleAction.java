package com.by.hctm.system.action;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.utils.ChineseCurrencyConverter;
import com.by.hctm.system.biz.IQualityCheckTitleBIZ;
import com.by.hctm.system.entity.QualityCheckKind;
import com.by.hctm.system.entity.QualityCheckTitle;

public class QualityCheckTitleAction extends BaseAction {
	private IQualityCheckTitleBIZ iQualityCheckTitleBIZ;
	private QualityCheckKind qualityCheckKind;
	private QualityCheckTitle qualityCheckTitle ;
	private String tree ;
	
	/**
	 * 查看巡检记录类别首页列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewQualityCheckIndex() {
		
		return INDEX ;
	}
	
	/**
	 * 查看巡检记录类别表初始树列表 getTree
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewQualityCheckInitTree() throws BaseException {
		
		try{
			Long id;
			String name = "";
			
			// 初始父ID为零
			QualityCheckKind qck = new QualityCheckKind() ;
			qck.setParentQckId( new Long(0) ) ;
			List qckList = iQualityCheckTitleBIZ.getQualityCheckKindList( qck  );
			
			StringBuffer script = new StringBuffer();
			script.append("var tree = new WebFXTree(\"巡检树\");\n");
			Iterator it=	qckList.iterator();
			
			while (it.hasNext()) {
				QualityCheckKind	checkKind =(QualityCheckKind)it.next();
				id = checkKind .getQckId();
				name = StringEscapeUtils.escapeXml(checkKind .getQckName().trim());
				
				// 判断是否有子节点
				if ("0".equals( checkKind .getIsHaveChild() )) {
					script.append("tree.add( rti = new WebFXLoadTreeItem(\"" + name + "\", \"viewQualityCheckITree_qcheck.action?&qualityCheckKind.parentQckId=" + id + "\",\"\"));\n");
					
				} else {
//					script.append("tree.add( new WebFXTreeItem(\"" + name + "\",\"javascript:folderview('" + id + "')\"));\n");
					script.append("tree.add( new WebFXTreeItem(\"" + name + "\",\"\"));\n");
				}
			}
			
			script.append("document.write(tree);\n");
			script.append("tree.expand();\n"); 

			tree = script.toString() ;
			
		} catch (Exception e) {
			log("查看巡检记录类别表初始树列表错误！", e);
			throw new BaseException("查看巡检记录类别表初始树列表错误！", e);
		}
		
		return TREE ;
	}
	
	/**
	 * 查看巡检记录类别表树列表 
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewQualityCheckITree() throws BaseException {
		
		try{
			Long id;
			String name = "";
			
			QualityCheckKind qck = new QualityCheckKind() ;
			qck.setParentQckId( qualityCheckKind.getParentQckId() ) ;
			
			List deptList = iQualityCheckTitleBIZ.getQualityCheckKindList( qck );

			StringBuffer script = new StringBuffer();
			script.append("<?xml version=\"1.0\"?>");
			script.append("<tree>");
			Iterator it=deptList.iterator();
			while (it.hasNext()) {
				QualityCheckKind checkKind = (QualityCheckKind) it.next() ;
				id 		= checkKind.getQckId() ;
				name 	= StringEscapeUtils.escapeXml(checkKind.getQckName().trim());
				
				// 判断是否有子节点
				if ( "0".equals( checkKind.getIsHaveChild() ) ) {
//					script.append("<tree text=\"" + name + "\" id=\"" + id + "\" action=\"javascript:folderview('" + id + "')\" ");
					script.append("<tree text=\"" + name + "\" id=\"" + id + "\" action=\"\" ");
					script.append(" src=\"viewQualityCheckITree_qcheck.action?qualityCheckKind.parentQckId=").append(id).append("\" ");
				}else {
					script.append("<tree text=\"" + name + "\" id=\"" + id + "\" action=\"javascript:folderview('" + id + "')\" ");
					
				}
				
				script.append("/>");
				
			}
			
			script.append("</tree>");
			
			getResponse().getWriter().println(script.toString());
			
		} catch (Exception e) {
			log("查看巡检记录类别表树列表错误！", e);
			throw new BaseException("查看巡检记录类别表树列表错误！", e);
		}
		
		return null ;
	}
	
	/**
	 * 查看巡检记录标题信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewQualityCheckTitle() throws BaseException {
		
		try{
			this.setListValue( this.iQualityCheckTitleBIZ.getQualityCheckTitleList(qualityCheckTitle ) ) ;
			//qualityCheckTitle.getQckId();
		} catch (Exception e) {
			log.error("查看巡检记录标题信息列表错误！", e);
			throw new BaseException("查看巡检记录标题信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 保存巡检记录标题信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String saveQualityCheckTitleInit() throws BaseException {
		try{
			qualityCheckTitle.getQckId();
		} catch (Exception e) {
			log("保存巡检记录标题信息初始化错误！", e);
			throw new BaseException("保存巡检记录标题信息初始化错误！", e);
		}
		return ADD_INIT;
		
	}
	
	/**
	 * 保存巡检记录标题信息
	 * @return
	 * @throws BaseException 
	 */
	public String saveQualityCheckTitle() throws BaseException {
		
		try{
			if ( qualityCheckTitle.getQctOrder() != null ) {
				qualityCheckTitle.setQctOrderCn( ChineseCurrencyConverter.convertChineseNumber( qualityCheckTitle.getQctOrder() ) );
			}
			this.iQualityCheckTitleBIZ.saveQualityCheckTitle( qualityCheckTitle );
		} catch (Exception e) {
			log("保存巡检记录标题信息错误！", e);
			throw new BaseException("保存巡检记录标题信息错误！", e);
		}
		
		return ADD;
		
	}
	
	/**
	 * 修改巡检记录标题信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String updateQualityCheckTitleInit() throws BaseException {
		
		try{
			qualityCheckTitle=this.iQualityCheckTitleBIZ.getQualityCheckTitle( qualityCheckTitle.getQctId() );
		} catch (Exception e) {
			log("修改巡检记录标题信息初始化错误！", e);
			throw new BaseException("修改巡检记录标题信息初始化错误！", e);
		}
		return MODIFY_INIT;
		
	}
	
	/**
	 * 修改巡检记录标题信息
	 * @return
	 * @throws BaseException 
	 */
	public String updateQualityCheckTitle() throws BaseException {
		
		try{
			if ( qualityCheckTitle.getQctOrder() != null ) {
				qualityCheckTitle.setQctOrderCn( ChineseCurrencyConverter.convertChineseNumber( qualityCheckTitle.getQctOrder() ) );
			}
			this.iQualityCheckTitleBIZ.updateQualityCheckTitle( qualityCheckTitle );
		} catch (Exception e) {
			log("修改巡检记录标题信息错误！", e);
			throw new BaseException("修改巡检记录标题信息错误！", e);
		}
		return MODIFY;
		
	}
	
	/**
	 * 删除巡检记录标题信息
	 * @return
	 * @throws BaseException 
	 */
	public String deleteQualityCheckTitle() throws BaseException {
		try{
			//伪删除数据
			qualityCheckTitle=this.iQualityCheckTitleBIZ.getQualityCheckTitle(qualityCheckTitle.getQctId());
			qualityCheckTitle.setIsUsable("1");
			//this.iQualityCheckTitleBIZ.deleteQualityCheckTitle( qualityCheckTitle );
			
		} catch (Exception e) {
			log("删除巡检记录标题信息错误！", e);
			throw new BaseException("删除巡检记录标题信息错误！", e);
		}
		return DELETE;
		
	}

	public IQualityCheckTitleBIZ getIQualityCheckTitleBIZ() {
		return iQualityCheckTitleBIZ;
	}

	public void setIQualityCheckTitleBIZ(IQualityCheckTitleBIZ qualityCheckTitleBIZ) {
		iQualityCheckTitleBIZ = qualityCheckTitleBIZ;
	}

	public QualityCheckKind getQualityCheckKind() {
		return qualityCheckKind;
	}

	public void setQualityCheckKind(QualityCheckKind qualityCheckKind) {
		this.qualityCheckKind = qualityCheckKind;
	}

	public QualityCheckTitle getQualityCheckTitle() {
		return qualityCheckTitle;
	}

	public void setQualityCheckTitle(QualityCheckTitle qualityCheckTitle) {
		this.qualityCheckTitle = qualityCheckTitle;
	}

	public String getTree() {
		return tree;
	}

	public void setTree(String tree) {
		this.tree = tree;
	}

}
