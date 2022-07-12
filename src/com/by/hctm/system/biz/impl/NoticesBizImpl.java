package com.by.hctm.system.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.utils.DateUtil;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.system.biz.INoticesBiz;
import com.by.hctm.system.entity.Notices;

public class NoticesBizImpl extends BaseBizImpl implements INoticesBiz  {
	
	/**
	 * 根据主键获得公告信息表实例
	 * @param id 主键
	 * @return
	 * @throws BaseException 
	 */
	public Notices getNotices(Long id) throws BaseException {
		return (Notices)this.getObject(Notices.class, id);
	}
	
	/**
	 * 添加公告信息信息
	 * @param notices 公告信息表实例
	 * @throws BaseException 
	 */
	public void saveNotices(Notices notices) throws BaseException{
		this.saveObject( notices ) ;
	}
	
	/**
	 * 更新公告信息表实例
	 * @param notices 公告信息表实例
	 * @throws BaseException 
	 */
	public void updateNotices(Notices notices) throws BaseException{
		this.updateObject( notices ) ;
	}
	
	/**
	 * 删除公告信息表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteNotices(String id) throws BaseException {
		this.removeObject( this.getNotices( new Long(id) ) ) ;
	}
	
	/**
	 * 删除公告信息表实例
	 * @param notices 公告信息表实例
	 * @throws BaseException 
	 */
	public void deleteNotices(Notices notices) throws BaseException {
		this.removeObject( notices ) ;
	}
	
	/**
	 * 删除公告信息表实例
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteNoticess(String[] id) throws BaseException {
		this.removeBatchObject(Notices.class, id) ;
	}
	
	/**
	 * 获得所有公告信息表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @throws BaseException 
	 */
	public List getNoticesList( RollPage rollPage ,int index,String type ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Notices de where 1 = 1 " );
		//判断公告发布的类型 type  1.通知2.公告3.发文4.其他
		if ( ! StringUtil.isBlank( type ) ) {
			hql.append( " and de.type = '" );
			hql.append( type.trim() );
			hql.append( "'" );
		}
		//有效的
		hql.append( " and de.isUsable = '0'" );
		hql.append( " and ROWNUM <=  " ).append( index );
		hql.append(" order by de.publishDate desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有公告信息表数据集
	 * @param notices 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getNoticesList(  Notices notices ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Notices de where 1 = 1 " );
		
		hql.append(" and isUsable = '0' order by de.id desc ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有公告信息表数据集
	 * @param rollPage 分页对象
	 * @param notices 查询参数对象
	 * @return
	 * @throws BaseException 
	 */
	public List getNoticesList( RollPage rollPage, Notices notices ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Notices de where 1 = 1 " );
		if(notices!=null){
			if(notices.getTitle()!=null&&notices.getTitle().length()>0){
				hql.append(" and de.title like '%").append(notices.getTitle()).append("%'");
			}
			if(notices.getKeyword()!=null&&notices.getKeyword().length()>0){
				hql.append(" and de.keyword like '%").append(notices.getKeyword()).append("%'");
			}
			if(notices.getType()!=null&&notices.getType().length()>0){
				hql.append(" and de.type like'%").append(notices.getType()).append("%'");
			}
			if(notices.getPublisherDepartment()!=null){
				hql.append(" and de.publisherDepartment like '%").append(notices.getPublisherDepartment()).append("%'");
			}
			if(notices.getPublishDate()!=null){
				hql.append(" and de.publishDate >= ").append("to_date('").append(DateUtil.getDefaultDateFormat(notices.getPublishDate())).append("','yyyy-mm-dd')");
			}
		}
		hql.append(" and isUsable = '0' order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
}
