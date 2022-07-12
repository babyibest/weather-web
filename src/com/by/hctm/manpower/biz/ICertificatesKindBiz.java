package com.by.hctm.manpower.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.manpower.entity.CertificatesKind;

public interface ICertificatesKindBiz {

	/**
	 * 根据主键获得人员资质树表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract CertificatesKind getCertificatesKind(Long id) throws BaseException;

	/**
	 * 添加人员资质树信息
	 * @param certificatesKind 人员资质树表实例
	 * @throws BaseException 
	 */
	abstract void saveCertificatesKind(CertificatesKind certificatesKind) throws BaseException;

	/**
	 * 更新人员资质树表实例
	 * @param certificatesKind 人员资质树表实例
	 * @throws BaseException 
	 */
	abstract void updateCertificatesKind(CertificatesKind certificatesKind) throws BaseException;

	/**
	 * 删除人员资质树表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteCertificatesKind(String id) throws BaseException;

	/**
	 * 删除人员资质树表实例
	 * @param certificatesKind 人员资质树表实例
	 * @throws BaseException 
	 */
	abstract void deleteCertificatesKind(CertificatesKind certificatesKind) throws BaseException;

	/**
	 * 删除人员资质树表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteCertificatesKinds(String[] id) throws BaseException;

	/**
	 * 获得所有人员资质树表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getCertificatesKindList( RollPage rollPage  ) throws BaseException ;
	
	/**
	 * 获得所有人员资质树表数据集
	 * @param certificatesKind 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getCertificatesKindList(  CertificatesKind certificatesKind ) throws BaseException ;
	
	/**
	 * 获得所有人员资质树表数据集
	 * @param rollPage 分页对象
	 * @param certificatesKind 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getCertificatesKindList(RollPage rollPage, CertificatesKind certificatesKind)
			throws BaseException;

}