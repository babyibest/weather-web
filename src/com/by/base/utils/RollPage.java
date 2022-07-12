package com.by.base.utils;

import com.by.hctm.common.utils.GlobalSetting;

public class RollPage {

	int rowCount = 0; // 记录总数

	int pageNum = 0;// 页�?�?

	int pageCur = 0;// 当前页数

	int pagePer = GlobalSetting.getMaxPageSize();// 页显示记录数

	int pageFirst = 0;

	public void setPageCur(int pageCur) {
		this.pageCur = pageCur;
	}

	public RollPage() {

	}

	/**
	 * 转入页数
	 */
	public RollPage(int pageCur) {
		this.pageCur = pageCur;
	}

	// construtor
	public RollPage(String pageString) {
		if ("".equals(pageString) || pageString == null) {
			this.pageCur = 0;
		} else {
			this.pageCur = Integer.parseInt(pageString);
		}
	}

	/**
	 * 输入总页数后进行初始�?
	 */
	public void init() {
		pageCount();
		firstResult();
	}

	/**
	 * 计算出�?页数
	 */
	private void pageCount() {
		if (this.rowCount % this.pagePer == 0) {
			this.pageNum = rowCount / this.pagePer;
		} else {
			this.pageNum = (rowCount / this.pagePer) + 1;
		}
	}

	/**
	 * 记录起始�?
	 */
	private void firstResult() {
		this.pageFirst = (this.pageCur) * this.pagePer;
		if (this.pageFirst < 0) {
			this.pageFirst = 0;
		}
	}

	/**
	 * 返回当前页数
	 */
	public int getPageCur() {
		return pageCur;
	}

	/**
	 * 返回页�?�?
	 */
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * 设置�?��显示记录�?
	 */
	public void setPagePer(int pagePer) {
		this.pagePer = pagePer;
	}

	/**
	 * 返回�?��显示记录�?
	 */
	public int getPagePer() {
		return pagePer;
	}

	/**
	 * 设置记录总数
	 */
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * 返回记录总数
	 */
	public int getRowCount() {
		return rowCount;
	}

	/**
	 * 记录�?��位置
	 */
	public int getPageFirst() {
		return pageFirst;
	}
}
