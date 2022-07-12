package com.by.base.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BaseException extends Exception {
	private static final long serialVersionUID = 5404766056023341965L;

	// 异常级联(异常�?
	protected Throwable rootCause = null;

	// 异常集合（多元化�?
	private List exceptions = new ArrayList();

	// 消息key
	private String messageKey = null;

	// 复合式消�?
	private Object[] messageArgs = null;

	/**
	 * 构�?函数
	 */
	public BaseException() {
		super();
	}

	/**
	 * 构�?函数
	 * 
	 * @param key
	 *            消息Key
	 */
	public BaseException(String key) {
		this.messageKey = key;
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * 构�?函数
	 * 
	 * @param key
	 *            消息Key
	 * @param info
	 *            消息�?
	 */
	public BaseException(String key, String[] info) {
		this.messageKey = key;
		this.messageArgs = info;
	}

	/**
	 * 构�?函数
	 * 
	 * @param rootCause
	 *            异常级联
	 */
	public BaseException(Throwable rootCause) {
		this.rootCause = rootCause;
	}

	/**
	 * 取出异常集合
	 * 
	 * @return List
	 */
	public List getExceptions() {
		return exceptions;
	}

	/**
	 * 添加异常
	 * 
	 * @param baseException
	 *            异常
	 */
	public void setExceptions(BaseException baseException) {
		exceptions.add(baseException);
	}

	/**
	 * 取得消息�?
	 * 
	 * @return
	 */
	public Object[] getMessageArgs() {
		return messageArgs;
	}

	/**
	 * 设置消息�?
	 * 
	 * @param messageArgs
	 *            消息�?
	 */
	public void setMessageArgs(Object[] messageArgs) {
		this.messageArgs = messageArgs;
	}

	/**
	 * 取得消息Key
	 * 
	 * @return
	 */
	public String getMessageKey() {
		return messageKey;
	}

	/**
	 * 设置消息Key
	 * 
	 * @param messageKey
	 *            消息Key
	 * @return
	 */
	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	/**
	 * 取得异常级联
	 * 
	 * @return
	 */
	public Throwable getRootCause() {
		return rootCause;
	}

	/**
	 * 设置异常级联�?
	 * 
	 * @param rootCause
	 */
	public void setRootCause(Throwable rootCause) {
		this.rootCause = rootCause;
	}

	/**
	 * 控制台输出（异常�?
	 */
	public void printStackTrace() {
		printStackTrace(System.err);
	}

	/**
	 * 控制台输出（异常�?
	 */
	public void printStackTrace(PrintStream out) {
		printStackTrace(new PrintWriter(out));
	}

	/**
	 * 控制台输出（异常�?
	 */
	public void printStackTrace(PrintWriter writer) {
		super.printStackTrace(writer);

		if (getRootCause() != null) {
			getRootCause().printStackTrace(writer);
		}

		writer.flush();
	}

}
