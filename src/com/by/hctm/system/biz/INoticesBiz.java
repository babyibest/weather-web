package com.by.hctm.system.biz;

import java.util.List;

import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.system.entity.Notices;

public interface INoticesBiz {

	/**
	 * 根据主键获得公告信息表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	abstract Notices getNotices(Long id) throws BaseException;

	/**
	 * 添加公告信息信息
	 * @param Notices 公告信息表实例
	 * @throws BaseException 
	 */
	abstract void saveNotices(Notices notices) throws BaseException;

	/**
	 * 更新公告信息表实例
	 * @param Notices 公告信息表实例
	 * @throws BaseException 
	 */
	abstract void updateNotices(Notices notices) throws BaseException;

	/**
	 * 删除公告信息表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteNotices(String id) throws BaseException;

	/**
	 * 删除公告信息表实例
	 * @param Notices 公告信息表实例
	 * @throws BaseException 
	 */
	abstract void deleteNotices(Notices notices) throws BaseException;

	/**
	 * 删除公告信息表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	abstract void deleteNoticess(String[] id) throws BaseException;

	/**
	 * 获得所有公告信息表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getNoticesList( RollPage rollPage,int index,String type  ) throws BaseException ;
	
	/**
	 * 获得所有公告信息表数据集
	 * @param Notices 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getNoticesList(  Notices notices ) throws BaseException ;
	
	/**
	 * 获得所有公告信息表数据集
	 * @param rollPage 分页对象
	 * @param Notices 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	abstract List getNoticesList(RollPage rollPage, Notices notices)
			throws BaseException;

}