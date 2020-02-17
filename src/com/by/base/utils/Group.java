package com.by.base.utils;

import java.util.ArrayList;
import java.util.List;

public class Group {

	/**
	 * �����ѯ��� count
	 */
	public static final int SQL_GROUP_COUNT = 1;

	/**
	 * �����ѯ��� avg
	 */
	public static final int SQL_GROUP_AVG = 2;

	/**
	 * �����ѯ��� max
	 */
	public static final int SQL_GROUP_MAX = 3;

	/**
	 * �����ѯ��� min
	 */
	public static final int SQL_GROUP_MIN = 4;

	/**
	 * �����ѯ��� row Count
	 */
	public static final int SQL_GROUP_ROWCOUNT = 5;

	/**
	 * �����ѯ��� count Distinct
	 */
	public static final int SQL_GROUP_COUNT_DISTINCT = 6;

	/**
	 * �����ѯ��� sum
	 */
	public static final int SQL_GROUP_SUM = 7;


	// �����?
	private List column = new ArrayList();

	// ���������?
	private List groupColumn = new ArrayList();

	// ���?
	/**
	 * �����ѯ������� And
	 */
	private List parameterAnd = new ArrayList();

	/**
	 * �����ѯ������� Or
	 */
	private List parameterOr = new ArrayList();

	public Group() {
	}

	public List getGroupColumn() {
		return groupColumn;
	}

	public void setGroupColumn(List groupColumn) {
		this.groupColumn = groupColumn;
	}

	public List getColumn() {
		return column;
	}

	public void setColumn(List column) {
		this.column = column;
	}

	public List getParameterAnd() {
		return parameterAnd;
	}

	public void setParameterAnd(List parameterAnd) {
		this.parameterAnd = parameterAnd;
	}

	public List getParameterOr() {
		return parameterOr;
	}

	public void setParameterOr(List parameterOr) {
		this.parameterOr = parameterOr;
	}

	public void addColumn(String column, int operator) {
		this.column.add(new Column(column, operator));
	}

	public void addColumn(String column, int operator, String alias) {
		this.column.add(new Column(column, operator, alias));
	}

	public void addGroupColumn(String column) {
		this.groupColumn.add(column);
	}

	public void addParameterAnd(String column, int operator, Object[] value) {
		this.parameterAnd.add(new Parameter(column, operator, value));
	}

	public void addParameterOr(String column, int operator, Object[] value) {
		this.parameterOr.add(new Parameter(column, operator, value));
	}
}
