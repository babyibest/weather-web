package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.Rights;

public interface IRightsBIZ {

	/**
	 * 根据主键获得权限表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract Rights getRights(Long id) throws BaseException;

	/**
	 * 添加权限表信息
	 * @param Rights 权限表实例
	 * @throws BaseException 
	 */
	abstract void saveRights(Rights rights) throws BaseException;

	/**
	 * 更新权限表实例
	 * @param rights 权限表实例
	 * @throws BaseException 
	 */
	abstract void updateRights(Rights rights) throws BaseException;

	/**
	 * 删除权限表实例
	 * @param id 主键
	 * @throws BaseException 
	 */
	abstract void deleteRights(Long id) throws BaseException;
	/**
	 * 删除权限表实例
	 * @param rights 权限表实例
	 * @throws BaseException 
	 */
	abstract void deleteRights(Rights rights) throws BaseException;

	/**
	 * 删除权限表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteDemos(String[] id) throws BaseException;

	/**
	 * 获得所有权限数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<Rights> getRightsList(RollPage rollPage) throws BaseException;

	/**
	 * 获得所有权限数据集
	 * @param rights 权限对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<Rights> getRightsList(Rights rights) throws BaseException;

	/**
	 * 获得所有权限数据集
	 * @param rollPage 分页对象
	 * @param rights 权限对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<Rights> getRightsList(RollPage rollPage, Rights rights)
			throws BaseException;

}