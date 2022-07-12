package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.UserRights;

public interface IUserRightsBIZ {

	/**
	 * 根据主键获得权限表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract UserRights getUserRights(Long id) throws BaseException;

	/**
	 * 添加权限表信息
	 * @param UserRights 权限表实例
	 * @throws BaseException 
	 */
	abstract void saveUserRights(UserRights userRights) throws BaseException;

	/**
	 * 更新权限表实例
	 * @param UserRights 权限表实例
	 * @throws BaseException 
	 */
	abstract void updateUserRights(UserRights userRights) throws BaseException;

	/**
	 * 删除权限表实例
	 * @param id 主键
	 * @throws BaseException 
	 */
	abstract void deleteUserRights(String id) throws BaseException;

	/**
	 * 删除权限表实例
	 * @param UserRights 权限表实例
	 * @throws BaseException 
	 */
	abstract void deleteUserRights(UserRights userRights) throws BaseException;

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
	abstract List<UserRights> getUserRightsList(RollPage rollPage)
			throws BaseException;

	/**
	 * 获得所有权限数据集
	 * @param UserRights 权限对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<UserRights> getUserRightsList(UserRights userRights)
			throws BaseException;

	/**
	 * 获得所有权限数据集
	 * @param rollPage 分页对象
	 * @param UserRights 权限对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List<UserRights> getUserRightsList(RollPage rollPage,
			UserRights userRights) throws BaseException;

}