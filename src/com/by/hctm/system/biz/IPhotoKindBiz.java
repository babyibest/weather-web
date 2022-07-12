package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.PhotoKind;

public interface IPhotoKindBiz {

	/**
	 * 根据主键获得数码照片类别表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract PhotoKind getPhotoKind(Long id) throws BaseException;

	/**
	 * 添加数码照片类别信息
	 * @param demo 数码照片类别表实例
	 * @throws BaseException 
	 */
	abstract void savePhotoKind(PhotoKind PhotoKind) throws BaseException;

	/**
	 * 更新数码照片类别表实例
	 * @param PhotoKind 数码照片类别表实例
	 * @throws BaseException 
	 */
	abstract void updatePhotoKind(PhotoKind PhotoKind) throws BaseException;

	/**
	 * 删除数码照片类别表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deletePhotoKind(String id) throws BaseException;

	/**
	 * 删除数码照片类别表实例
	 * @param PhotoKind 数码照片类别表实例
	 * @throws BaseException 
	 */
	abstract void deletePhotoKind(PhotoKind PhotoKind) throws BaseException;

	/**
	 * 删除数码照片类别表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deletePhotoKinds(String[] id) throws BaseException;

	/**
	 * 获得所有数码照片类别表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getPhotoKindList( RollPage rollPage  ) throws BaseException ;
	
	/**
	 * 获得所有数码照片类别表数据集
	 * @param PhotoKind 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getPhotoKindList(  PhotoKind PhotoKind ) throws BaseException ;
	
	/**
	 * 获得所有数码照片类别表数据集
	 * @param rollPage 分页对象
	 * @param PhotoKind 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getPhotoKindList(RollPage rollPage, PhotoKind PhotoKind)
			throws BaseException;

	/**
	 * 获得根据父ID所有子类数码照片类别表数据集
	 * @param photoKind 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getPhotoKindChild(  PhotoKind photoKind ) throws BaseException ;
}