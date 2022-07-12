package com.by.hctm.common.entity;

import java.io.Serializable;

public class ProgressChart implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// 显示名称
	private String label;
	// 显示数量
	private Object value;
	// 显示颜色
	private String color;
	// 链接到同一页面
	private String linkSelf;
	// 链接到新窗口
	private String linkNew;
	// 
	private String linkJs;
	// 
	private String linkFrame; 
	
	
	public ProgressChart() {
		super();
	}

	public ProgressChart(long value) {
		super();
		this.value = value;
	}

	public ProgressChart(String label, Object value) {
		super();
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLinkSelf() {
		return linkSelf;
	}

	public void setLinkSelf(String linkSelf) {
		this.linkSelf = linkSelf;
	}

	public String getLinkNew() {
		return linkNew;
	}

	public void setLinkNew(String linkNew) {
		this.linkNew = linkNew;
	}

	public String getLinkJs() {
		return linkJs;
	}

	public void setLinkJs(String linkJs) {
		this.linkJs = linkJs;
	}

	public String getLinkFrame() {
		return linkFrame;
	}

	public void setLinkFrame(String linkFrame) {
		this.linkFrame = linkFrame;
	}

	/**
	 * 取得图形所需的数据
	 * @return
	 */
	public String getChartData() {
		StringBuffer sb = new StringBuffer(" <set ") ;
		
		sb.append(" label='" + this.getLabel() + "' ") ;
		sb.append(" value='" + this.getValue() + "' ") ;
		
		// 不赋值取默认值
		if( this.getColor() != null && this.getColor().length()>0 ) {
			sb.append(" color='" + this.getColor() + "' ") ;
		}
		
		if( this.getLinkSelf() != null && this.getLinkSelf().length()>0 ) {
			sb.append(" link='" + this.getLinkSelf() + "' ") ;
			
		}else if( this.getLinkNew() != null && this.getLinkNew().length()>0 ) {
			sb.append(" link='n-" + this.getLinkNew() + "' ") ;
			
		}else if( this.getLinkFrame() != null && this.getLinkFrame().length()>0 ) {
			sb.append(" link='" + this.getLinkFrame() + "' ") ;
			
		}else if( this.getLinkJs() != null && this.getLinkJs().length()>0 ) {
			sb.append(" link='" + this.getLinkJs() + "' ") ;
		}
		
		sb.append("/>") ;
		return sb.toString() ;
	}
}
