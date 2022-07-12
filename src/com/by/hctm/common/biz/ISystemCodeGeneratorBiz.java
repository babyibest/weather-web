package com.by.hctm.common.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.entity.SystemCodeGenerator;

public interface ISystemCodeGeneratorBiz {

	/**
	 * 根据主键获得单据编码表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public abstract SystemCodeGenerator getSystemCodeGenerator(Long id)
			throws BaseException;

	/**
	 * 获得单据编码表实例
	 * @param SystemCodeGenerator 单据编码表实例
	 * @return
	 * @throws BaseException 
	 */
	public abstract SystemCodeGenerator getSystemCodeGenerator(
			SystemCodeGenerator SystemCodeGenerator) throws BaseException;

	/**
	 * 添加单据编码信息
	 * @param SystemCodeGenerator 单据编码表实例
	 * @throws BaseException 
	 */
	public abstract void saveSystemCodeGenerator(
			SystemCodeGenerator SystemCodeGenerator) throws BaseException;

	/**
	 * 更新单据编码表实例
	 * @param SystemCodeGenerator 单据编码表实例
	 * @throws BaseException 
	 */
	public abstract void updateSystemCodeGenerator(
			SystemCodeGenerator SystemCodeGenerator) throws BaseException;

	/**
	 * 删除单据编码表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public abstract void deleteSystemCodeGenerator(String id)
			throws BaseException;

	/**
	 * 删除单据编码表实例
	 * @param SystemCodeGenerator 单据编码表实例
	 * @throws BaseException 
	 */
	public abstract void deleteSystemCodeGenerator(
			SystemCodeGenerator SystemCodeGenerator) throws BaseException;

	/**
	 * 删除单据编码表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public abstract void deleteSystemCodeGenerators(String[] id)
			throws BaseException;

	/**
	 * 获得所有单据编码表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public abstract List getSystemCodeGeneratorList(RollPage rollPage)
			throws BaseException;

	/**
	 * 获得所有单据编码表数据集
	 * @param SystemCodeGenerator 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public abstract List getSystemCodeGeneratorList(
			SystemCodeGenerator SystemCodeGenerator) throws BaseException;

	/**
	 * 获得所有单据编码表数据集
	 * @param rollPage 分页对象
	 * @param SystemCodeGenerator 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public abstract List getSystemCodeGeneratorList(RollPage rollPage,
			SystemCodeGenerator SystemCodeGenerator) throws BaseException;

	/**
	 * 编号生成器, 按年重置
	 * @param systemCodeGenerator  
	 * @return
	 * @throws BaseException
	 */
	public abstract String geGeneratCommonCode(  SystemCodeGenerator systemCodeGenerator  ) throws BaseException ;
	
}