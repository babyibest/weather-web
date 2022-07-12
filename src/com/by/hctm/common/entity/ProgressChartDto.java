package com.by.hctm.common.entity;

import java.io.Serializable;
import java.util.List;

public class ProgressChartDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// 主标题
	private String caption = "" ;
	// 子标题
	private String subcaption ;
	// 字体大小
	private String baseFontSize = "15" ;
	// 显示后缀
	private String numberSuffix = "" ;
	// X横坐标标题
	private String xAxisName = "" ;
	// Y纵坐标标题
	private String yAxisName = "数量" ;
	
	private List<ProgressChart> pcharList ;

	
	public ProgressChartDto() {
		super();
	}
	
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getSubcaption() {
		return subcaption;
	}
	public void setSubcaption(String subcaption) {
		this.subcaption = subcaption;
	}
	public String getBaseFontSize() {
		return baseFontSize;
	}
	public void setBaseFontSize(String baseFontSize) {
		this.baseFontSize = baseFontSize;
	}
	public String getNumberSuffix() {
		return numberSuffix;
	}
	public void setNumberSuffix(String numberSuffix) {
		this.numberSuffix = numberSuffix;
	}
	public String getXAxisName() {
		return xAxisName;
	}
	public void setXAxisName(String axisName) {
		xAxisName = axisName;
	}
	public String getYAxisName() {
		return yAxisName;
	}
	public void setYAxisName(String axisName) {
		yAxisName = axisName;
	}
	
	public List<ProgressChart> getPcharList() {
		return pcharList;
	}
	public void setPcharList(List<ProgressChart> pcharList) {
		this.pcharList = pcharList;
	}
	/**
	 * 取得图形所需的数据
	 * @return
	 */
	public String getImageData() {
		StringBuffer sb = new StringBuffer(" <chart formatNumberScale='0' ") ;
		
		if( this.getCaption() != null && this.getCaption().length()>0 ) {
			sb.append(" caption='" + this.getCaption() + "' ") ;
		}
		if( this.getSubcaption() != null && this.getSubcaption().length()>0 ) {
			sb.append(" subcaption='" + this.getSubcaption() + "' ") ;
		}
		if( this.getBaseFontSize() != null && this.getBaseFontSize().length()>0 ) {
			sb.append(" baseFontSize='" + this.getBaseFontSize() + "' ") ;
		}
		if( this.getNumberSuffix() != null && this.getNumberSuffix().length()>0 ) {
			sb.append(" numberSuffix='" + this.getNumberSuffix() + "' ") ;
		}
		if( this.getXAxisName() != null && this.getXAxisName().length()>0 ) {
			sb.append(" xAxisName='" + this.getXAxisName() + "' ") ;
		}
		if( this.getYAxisName() != null && this.getYAxisName().length()>0 ) {
			sb.append(" yAxisName='" + this.getYAxisName() + "' ") ;
		}
		sb.append(" > ") ;
		
		for( ProgressChart chart  :pcharList) {
			sb.append( chart.getChartData() ) ;
		}
		
		sb.append("</chart>") ;
		return sb.toString() ;
	}
}
