package com.by.hctm.manpower.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.manpower.entity.Certificates;
import com.by.hctm.system.entity.Departments;

public interface ICertificatesBiz {

	/**
	 * 根据主键获得资质表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract Certificates getCertificates(Long id) throws BaseException;

	/**
	 * 添加资质信息
	 * @param user 资质表实例
	 * @throws BaseException 
	 */
	abstract void saveCertificates(Certificates certificates) throws BaseException;

	/**
	 * 更新资质表实例
	 * @param user 资质表实例
	 * @throws BaseException 
	 */
	abstract void updateCertificates(Certificates certificates) throws BaseException;

	/**
	 * 删除资质表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteCertificates(String id) throws BaseException;

	/**
	 * 删除资质表实例
	 * @param user 资质表实例
	 * @throws BaseException 
	 */
	abstract void deleteCertificates(Certificates certificates) throws BaseException;

	/**
	 * 删除资质表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteCertificatess(String[] id) throws BaseException;
	
	/**
	 * 删除资质表实例
	 * @param list 对象数组
	 * @throws BaseException 
	 */
	abstract void deleteCertificates(List list) throws BaseException;

	/**
	 * 获得所有资质表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getCertificatesList(RollPage rollPage) throws BaseException;

	/**
	 * 获得所有资质表数据集
	 * @param user 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getCertificatesList(Certificates certificates) throws BaseException;

	/**
	 * 获得所有资质表数据集
	 * @param rollPage 分页对象
	 * @param user 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getCertificatesList(RollPage rollPage, Certificates certificates)
			throws BaseException;

	/**
	 * 获得所有资质表数据集
	 * @param rollPage 分页对象
	 * @param user 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getCertificatesList(RollPage rollPage, Certificates certificates, Departments departments)
			throws BaseException;
	
	/**
	 * 获得所有相同人员的资质表数据集
	 * @param id 合同表实例主键
	 * @return
	 * @throws BaseException
	 */
	abstract List getCertificatesListById(Long id) throws BaseException;
	
	/**
	 * 资质表数量供资质树使用
	 * 谢磊
	 * 
	 * 
	 * */
	public int getCertificatesCount(Certificates certificates) throws BaseException ;
}