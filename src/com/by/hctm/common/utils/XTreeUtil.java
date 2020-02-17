package com.by.hctm.common.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringEscapeUtils;

import com.by.base.exception.BaseException;

public class XTreeUtil {
	
	/**
	 * 取树型主节点信息-Map类型
	 * @param treePara 树型参数对象
	 * @param list 树型节点对象数据集
	 * @return
	 * @throws BaseException
	 */
	public String getIndexTreeInfoWithMap( XTreePara treePara, 
			Map<String, String> map ) throws BaseException{
//		String treeName, String childUrl, boolean clickFlag
		// 初始父ID为零
		Set<String> gSet = map.keySet() ;
		
		StringBuffer script = new StringBuffer();
		script.append("var tree = new WebFXTree(\"" + treePara.getRootTreeName() + "\");\n");
		
		for( String id : gSet ) {
			if( treePara.isClickFlag() ) {
				script.append("tree.add( rti = new WebFXLoadTreeItem(\"" + map.get( id ) + "\", \"" + treePara.getChildUrl() + "=" + id + "\",\"\"));\n");
			}else {
				script.append("tree.add( rti = new WebFXLoadTreeItem(\"" + map.get( id ) + "\", \"" + treePara.getChildUrl() + "=" + id + "\",\"javascript:folderview('" + id + "')\"));\n");
			}
		}
		
		script.append("document.write(tree);\n");
		script.append("tree.expand();\n"); 

		return script.toString() ;
	}
	
	/**
	 * 取树型主节点信息-List类型  
	 * @param treePara 树型参数对象
	 * @param list 树型节点对象数据集
	 * @return
	 * @throws BaseException
	 */
	public String getIndexTreeInfoWithList( XTreePara treePara, 
			List<XTreeBean> list ) throws BaseException{
		// String treeName, String childUrl, boolean clickFlag
		// viewPhotoKindTree_photoKind.action?photoKind.parentId
		String name = "";
		StringBuffer script = new StringBuffer();
		script.append("var tree = new WebFXTree(\"" + treePara.getRootTreeName() + "\");\n");
		
		for( XTreeBean treeBean : list ) {
			name = StringEscapeUtils.escapeXml( treeBean.getNodeName().trim() );
			
			// 判断是否有子节点
			if ( treeBean.isHaveChild() ) { 
				if( treePara.isClickFlag() ) {
					script.append("tree.add( rti = new WebFXLoadTreeItem(\"" + name + "\", \"" + treePara.getChildUrl() + "=" + treeBean.getNodeId() + "\",\"\"));\n");
				}else {
					script.append("tree.add( rti = new WebFXLoadTreeItem(\"" + name + "\", \"" + treePara.getChildUrl() + "=" + treeBean.getNodeId() + "\",\"javascript:folderview('" + treeBean.getNodeId() + "')\"));\n");
				}
			} else {
				script.append("tree.add( new WebFXTreeItem(\"" + name + "\",\"\"));\n");
			}
		}
		
		script.append("document.write(tree);\n");
		script.append("tree.expand();\n"); 

		return script.toString() ;
	}
	
	/**
	 * 取树型子节点信息 
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String getTreeInfo( XTreePara treePara, List<XTreeBean> list ) throws BaseException {
		
		String name = "";
		
		StringBuffer script = new StringBuffer();
		script.append("<?xml version=\"1.0\"?>");
		script.append("<tree>");
		
		for( XTreeBean treeBean : list ) {
			name = StringEscapeUtils.escapeXml( treeBean.getNodeName().trim() );
			
			script.append("<tree text=\"" + name + "\" id=\"" + treeBean.getNodeId() + "\" action=\"javascript:folderview('" + treeBean.getNodeId() + "')\" ");
			// 判断是否有子节点
			if ( treeBean.isHaveChild() ) {
				script.append(" src=\"" + treePara.getChildUrl() + "=").append( treeBean.getNodeId() ).append("\" ");
			}
			
			script.append("/>");
		}
		
		script.append("</tree>");
			
		return script.toString() ;
	}
}

class XTreePara{
	// 树根名称
	private String rootTreeName ;
	// 字节点URL
	private String childUrl ;
	// 是否存在点击事件
	private boolean clickFlag ;
	
	
	public XTreePara(String childUrl) {
		super();
		this.childUrl = childUrl;
	}
	
	public XTreePara(String rootTreeName, String childUrl, boolean clickFlag) {
		super();
		this.rootTreeName = rootTreeName;
		this.childUrl = childUrl;
		this.clickFlag = clickFlag;
	}

	public String getRootTreeName() {
		return rootTreeName;
	}
	public void setRootTreeName(String rootTreeName) {
		this.rootTreeName = rootTreeName;
	}
	public String getChildUrl() {
		return childUrl;
	}
	public void setChildUrl(String childUrl) {
		this.childUrl = childUrl;
	}
	public boolean isClickFlag() {
		return clickFlag;
	}
	public void setClickFlag(boolean clickFlag) {
		this.clickFlag = clickFlag;
	}
}

class XTreeBean{ 
	// 节点ID
	private String nodeId ;
	// 节点名称
	private String nodeName ;
	// 是否存在子节点
	private boolean isHaveChild ;
	
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public boolean isHaveChild() {
		return isHaveChild;
	}
	public void setHaveChild(boolean isHaveChild) {
		this.isHaveChild = isHaveChild;
	} 
}
