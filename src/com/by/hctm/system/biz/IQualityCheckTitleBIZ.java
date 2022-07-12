package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.QualityCheckKind;
import com.by.hctm.system.entity.QualityCheckTitle;

public interface IQualityCheckTitleBIZ {

	/**
	 * 根据主键获得巡检记录标题项表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract QualityCheckTitle getQualityCheckTitle(Long id)
			throws BaseException;

	/**
	 * 根据主键获得巡检记录标题项表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract QualityCheckKind getQualityCheckKind(Long id) throws BaseException;

	/**
	 * 添加巡检记录标题项表信息
	 * @param qualityCheckTitle 巡检记录标题项表实例
	 * @throws BaseException 
	 */
	abstract void saveQualityCheckTitle(QualityCheckTitle qualityCheckTitle)
			throws BaseException;

	/**
	 * 更新巡检记录标题项表实例
	 * @param qualityCheckTitle 巡检记录标题项表实例
	 * @throws BaseException 
	 */
	abstract void updateQualityCheckTitle(QualityCheckTitle qualityCheckTitle)
			throws BaseException;

	/**
	 * 删除巡检记录标题项表实例
	 * @param id 主键
	 * @throws BaseException 
	 */
	abstract void deleteQualityCheckTitle(Long id) throws BaseException;

	/**
	 * 删除巡检记录标题项表实例
	 * @param qualityCheckTitle 巡检记录标题项表实例
	 * @throws BaseException 
	 */
	abstract void deleteQualityCheckTitle(QualityCheckTitle qualityCheckTitle)
			throws BaseException;

	/**
	 * 删除巡检记录标题项表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteQualityCheckTitles(String[] id) throws BaseException;

	/**
	 * 获得所有巡检记录类别项数据集
	 * @param QualityCheckCheck 巡检记录类别项对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<QualityCheckKind> getQualityCheckKindList(
			QualityCheckKind qualityCheckKind) throws BaseException;

	/**
	 * 获得所有巡检记录标题项数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<QualityCheckTitle> getQualityCheckTitleList(RollPage rollPage)
			throws BaseException;

	/**
	 * 获得所有巡检记录标题项数据集
	 * @param qualityCheckTitle 巡检记录标题项对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<QualityCheckTitle> getQualityCheckTitleList(
			QualityCheckTitle qualityCheckTitle) throws BaseException;

	/**
	 * 获得所有巡检记录标题项数据集
	 * @param rollPage 分页对象
	 * @param qualityCheckTitle 巡检记录标题项对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<QualityCheckTitle> getQualityCheckTitleList(
			RollPage rollPage, QualityCheckTitle qualityCheckTitle)
			throws BaseException;

	/**
	 * 获得所有巡检记录标题项数据集
	 * @return
	 * @throws BaseException 
	 */
	abstract List<QualityCheckTitle> getQualityCheckTitleList()
			throws BaseException;
	
	/**
	 * 获得非一级父节点的巡检记录类别项数据集
	 * @param QualityCheckCheck 巡检记录类别项对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<QualityCheckKind> getqckList(
			QualityCheckKind qualityCheckKind) throws BaseException;

}