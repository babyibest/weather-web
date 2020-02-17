package com.by.hctm.manpower.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.manpower.biz.ICertificatesKindBiz;
import com.by.hctm.manpower.entity.CertificatesKind;

public class CertificatesKindBizImpl extends BaseBizImpl implements ICertificatesKindBiz  {
	
	/**
	 * 根据主键获得人员资质树表实例
	 * @param id 主键
	 * @author ted 2012-10-18
	 * @return
	 * @throws BaseException 
	 */
	public CertificatesKind getCertificatesKind(Long id) throws BaseException {
		return (CertificatesKind)this.getObject(CertificatesKind.class, id);
	}
	
	/**
	 * 获得人员资质树表实例
	 * @param certificatesKind 人员资质树表实例
	 * @author ted 2012-10-18
	 * @return
	 * @throws BaseException 
	 */
	public CertificatesKind getCertificatesKind( CertificatesKind certificatesKind ) throws BaseException {
		return (CertificatesKind)this.getObject(CertificatesKind.class, certificatesKind.getCertKindId() );
	}
	
	/**
	 * 添加人员资质树信息
	 * @param certificatesKind 人员资质树表实例
	 * @author ted 2012-10-18
	 * @throws BaseException 
	 */
	public void saveCertificatesKind(CertificatesKind certificatesKind) throws BaseException{
		this.saveObject( certificatesKind ) ;
	}
	
	/**
	 * 更新人员资质树表实例
	 * @param certificatesKind 人员资质树表实例
	 * @author ted 2012-10-18
	 * @throws BaseException 
	 */
	public void updateCertificatesKind(CertificatesKind certificatesKind) throws BaseException{
		this.updateObject( certificatesKind ) ;
	}
	
	/**
	 * 删除人员资质树表实例
	 * @param id 主键数组
	 * @author ted 2012-10-18
	 * @throws BaseException 
	 */
	public void deleteCertificatesKind(String id) throws BaseException {
		this.removeObject( this.getCertificatesKind( new Long(id) ) ) ;
	}
	
	/**
	 * 删除人员资质树表实例
	 * @param certificatesKind 人员资质树表实例
	 * @author ted 2012-10-18
	 * @throws BaseException 
	 */
	public void deleteCertificatesKind(CertificatesKind certificatesKind) throws BaseException {
		this.removeObject( certificatesKind ) ;
	}
	
	/**
	 * 删除人员资质树表实例
	 * @param id 主键数组
	 * @author ted 2012-10-18
	 * @throws BaseException 
	 */
	public void deleteCertificatesKinds(String[] id) throws BaseException {
		this.removeBatchObject(CertificatesKind.class, id) ;
	}
	
	/**
	 * 获得所有人员资质树表数据集
	 * @param rollPage 分页对象
	 * @author ted 2012-10-18
	 * @return
	 * @throws BaseException 
	 */
	public List getCertificatesKindList( RollPage rollPage  ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from CertificatesKind de where 1 = 1 " );

		hql.append(" and de.isUsable = '0' order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有人员资质树表数据集
	 * @param certificatesKind 查询参数对象
	 * @author ted 2012-10-18
	 * @return
	 * @throws BaseException 
	 */
	public List getCertificatesKindList(  CertificatesKind certificatesKind ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from CertificatesKind de where 1 = 1 " );
		if(StringUtil.isNotBlank(certificatesKind)){
			if(StringUtil.isNotBlank(certificatesKind.getCertKindId())){
				hql.append(" and de.certKindId = '").append(certificatesKind.getCertKindId()).append("'");
				
			}
			if(StringUtil.isNotBlank(certificatesKind.getCertKindParentId())){
				hql.append(" and de.certKindParentId = '").append(certificatesKind.getCertKindParentId()).append("'");
			}
		}
		hql.append(" and de.isUsable = '0' order by de.certOrder ASC ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有人员资质树表数据集
	 * @param rollPage 分页对象
	 * @param certificatesKind 查询参数对象
	 * @author ted 2012-10-18
	 * @return
	 * @throws BaseException 
	 */
	public List getCertificatesKindList( RollPage rollPage, CertificatesKind certificatesKind ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from CertificatesKind de where 1 = 1 " );

		hql.append(" and de.isUsable = '0' order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
}
