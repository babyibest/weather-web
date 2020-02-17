package com.by.base.utils;

public class Parameter {

	// ï¿½ï¿½ï¿½ï¿½ï¿?
	private String column;

	// lï¿½Ó·ï¿½ï¿?
	private int operator;

	// Öµ
	private Object[] value;

	public Parameter() {
	}

	public Parameter(String column, int operator, Object[] value) {
		this.column = column;
		this.operator = operator;
		this.value = value;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}

	public Object[] getValue() {
		return value;
	}

	public void setValue(Object[] value) {
		this.value = value;
	}

}
