package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.system.biz.IPhotoKindBiz;
import com.by.hctm.system.entity.PhotoKind;
public class PhotoKindBizImpl extends BaseBizImpl implements IPhotoKindBiz  {
	
	/**
	 * 根据主键获得数码照片类别表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public PhotoKind getPhotoKind(Long id) throws BaseException {
		return (PhotoKind)this.getObject(PhotoKind.class, id);
	}
	
	/**
	 * 获得数码照片类别表实例
	 * @param demo 数码照片类别表实例
	 * @return
	 * @throws BaseException 
	 */
	public PhotoKind getPhotoKind( PhotoKind photoKind ) throws BaseException {
		return (PhotoKind)this.getObject(PhotoKind.class, photoKind.getPkId() );
	}
	
	/**
	 * 添加数码照片类别信息
	 * @param photoKind 数码照片类别表实例
	 * @throws BaseException 
	 */
	public void savePhotoKind(PhotoKind photoKind) throws BaseException{
		this.saveObject( photoKind ) ;
	}
	
	/**
	 * 更新数码照片类别表实例
	 * @param photoKind 数码照片类别表实例
	 * @throws BaseException 
	 */
	public void updatePhotoKind(PhotoKind photoKind) throws BaseException{
		this.updateObject( photoKind ) ;
	}
	
	/**
	 * 删除数码照片类别表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deletePhotoKind(String id) throws BaseException {
		this.removeObject( this.getPhotoKind( new Long(id) ) ) ;
	}
	
	/**
	 * 删除数码照片类别表实例
	 * @param photoKind 数码照片类别表实例
	 * @throws BaseException 
	 */
	public void deletePhotoKind(PhotoKind photoKind) throws BaseException {
		this.removeObject( photoKind ) ;
	}
	
	/**
	 * 删除数码照片类别表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deletePhotoKinds(String[] id) throws BaseException {
		this.removeBatchObject(PhotoKind.class, id) ;
	}
	
	/**
	 * 获得所有数码照片类别表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List getPhotoKindList( RollPage rollPage  ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from PhotoKind de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有数码照片类别表数据集
	 * @param photoKind 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getPhotoKindList(  PhotoKind photoKind ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from PhotoKind de where 1 = 1 " );
		if(photoKind!=null){
			if(!StringUtil.isBlank(photoKind.getStandardId())){
				hql.append(" and de.standardId = ").append(photoKind.getStandardId());
			}
			if(!StringUtil.isBlank(photoKind.getParentId())){
				hql.append(" and de.parentId = ").append(photoKind.getParentId());
			}
			if(!StringUtil.isBlank(photoKind.getPkId())){
				hql.append(" and de.pkId = ").append(photoKind.getPkId());
			}
		}
		hql.append(" order by de.pkId desc ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有数码照片类别表数据集
	 * @param rollPage 分页对象
	 * @param photoKind 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getPhotoKindList( RollPage rollPage, PhotoKind photoKind ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from PhotoKind de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	
	/**
	 * 获得根据父ID所有子类数码照片类别表数据集
	 * @param photoKind 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getPhotoKindChild(  PhotoKind photoKind ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from PhotoKind de where 1 = 1 " );
		if(photoKind!=null){
			
			if(!StringUtil.isBlank(photoKind.getParentId())){
				hql.append(" and de.parentId = ").append(photoKind.getParentId());
			}
			
		}
		hql.append(" order by de.pkId desc ");
		return this.getObjects( hql.toString() );
	}
}
