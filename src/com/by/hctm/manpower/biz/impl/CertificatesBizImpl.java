package com.by.hctm.manpower.biz.impl;

import java.util.List;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.base.utils.RollPage;
import com.by.hctm.common.TableStatus;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.manpower.biz.ICertificatesBiz;
import com.by.hctm.manpower.entity.Certificates;
import com.by.hctm.system.entity.Departments;

public class CertificatesBizImpl extends BaseBizImpl implements
		ICertificatesBiz {

	/**
	 * 根据主键获得资质表实例
	 * @param id 主键
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public Certificates getCertificates(Long id) throws BaseException {
		return (Certificates)this.getObject(Certificates.class, id);
	}
	
	/**
	 * 添加资质信息
	 * @author zwp 2012-10-19
	 * @param user 资质表实例
	 * @throws BaseException 
	 */
	public void saveCertificates(Certificates certificates) throws BaseException{
		this.saveObject( certificates ) ;
	}
	
	/**
	 * 更新资质表实例
	 * @author zwp 2012-10-19
	 * @param user 资质表实例
	 * @throws BaseException 
	 */
	public void updateCertificates(Certificates certificates) throws BaseException{
		this.updateObject( certificates ) ;
	}
	
	/**
	 * 删除资质表实例
	 * @author zwp 2012-10-19
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteCertificates(String id) throws BaseException {
		this.removeObject( this.getCertificates( new Long(id) ) ) ;
	}
	
	/**
	 * 删除资质表实例
	 * @author zwp 2012-10-19
	 * @param user 资质表实例
	 * @throws BaseException 
	 */
	public void deleteCertificates(Certificates certificates) throws BaseException {
		this.removeObject( certificates ) ;
	}
	
	/**
	 * 删除资质表实例
	 * @author zwp 2012-10-19
	 * @param id 主键数组
	 * @throws BaseException 
	 */
	public void deleteCertificatess(String[] id) throws BaseException {
		this.removeBatchObject(Certificates.class, id) ;
	}
	
	/**
	 * 删除资质表实例
	 * @author zwp 2012-10-19
	 * @param list 对象数组
	 * @throws BaseException 
	 */
	public void deleteCertificates(List list) throws BaseException {
		if(list!=null && list.size()!=0){
			for(int i=0;i<list.size();i++){
			deleteCertificates((Certificates)list.get(i));
			}
		}
	}
	
	/**
	 * 获得所有资质表数据集
	 * @param rollPage 分页对象
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public List getCertificatesList( RollPage rollPage  ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Certificates de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有资质表数据集
	 * @param user 查询参数对象
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public List getCertificatesList(  Certificates certificates ) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Certificates de where 1 = 1 " );

		hql.append(" order by de.id desc ");
		return this.getObjects( hql.toString() );
	}
	
	/**
	 * 获得所有资质表数据集
	 * @param rollPage 分页对象
	 * @param user 查询参数对象
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public List getCertificatesList( RollPage rollPage, Certificates certificates ) throws BaseException {
		StringBuffer hql = new StringBuffer(" select t from  Users t,Certificates c  where t.userId = c.user.userId " );
		if( StringUtil.isNotBlank( certificates ) && StringUtil.isNotBlank( certificates.getCertField() ) ){
			hql.append(" and c.certField ='").append(certificates.getCertField()+"'");
		}
		if( StringUtil.isNotBlank( certificates ) ){
			if(StringUtil.isNotBlank(certificates.getCertName())){
				hql.append(" and c.certName = '").append(certificates.getCertName()).append("'");
			}
			if(StringUtil.isNotBlank( certificates.getUser() )&&StringUtil.isNotBlank( certificates.getUser().getUserChinesename() )){
				
				hql.append(" and t.userChinesename  like '%").append(certificates.getUser().getUserChinesename()+"%'");
			}
		}
		
		hql.append(" and c.isUsable = 0 order by c.id desc ");
		return this.getObjects(rollPage, hql.toString() );
	}
	/**
	 * 获得所有资质表数据集
	 * @param rollPage 分页对象
	 * @param user 查询参数对象
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException 
	 */
	public List getCertificatesList(RollPage rollPage, Certificates certificates, Departments departments) throws BaseException {
		StringBuffer hql = new StringBuffer(" from Certificates as u where 1 = 1 " );
		  //查询
//		if(user!=null){
//			if(user.getUserChinesename()!=null && user.getUserChinesename()!="" && user.getUserChinesename().length()!=0){
//				hql.append(" and u.userChinesename like '%").append(user.getUserChinesename()).append("%' ");
//				user.setUserChinesename(user.getUserChinesename());
//			}
//		}
//		  if(departments!=null){
//			  if(departments.getDepId()!=null){
//				  hql.append(" and u.depId=").append(departments.getDepId()).append(" ");
//			  }
//		  }
//         System.out.println(hql);
		hql.append(" order by u.id ");
		return this.getObjects(rollPage, hql.toString() );
	}
	
	/**
	 * 获得所有相同人员的资质表数据集
	 * @param id 资质表实例主键
	 * @return
	 * @author zwp 2012-10-19
	 * @throws BaseException
	 */
	public List getCertificatesListById(Long id) throws BaseException {
		String hql = "from Certificates as c where c.user.userId ="+id+" and c.isUsable='"+TableStatus.COMMON_STATUS_VALID+"'";
		return this.getObjects(hql);
	}
	/**
	 * 资质表数量供资质树使用
	 * 谢磊
	 * 
	 * 
	 * */
	public int getCertificatesCount(Certificates certificates) throws BaseException {
		StringBuffer hql = new StringBuffer(" select count(*) from Users t,Certificates c  where t.userId = c.user.userId" );
		if( StringUtil.isNotBlank( certificates ) && StringUtil.isNotBlank( certificates.getCertField() ) ){
			hql.append(" and c.certField ='").append(certificates.getCertField()+"'");
		}
		if( StringUtil.isNotBlank( certificates ) && StringUtil.isNotBlank( certificates.getCertName() ) ){
			hql.append(" and c.certName ='").append(certificates.getCertName()+"'");
		}
		hql.append(" and c.isUsable = 0 ");
		return this.countObjects(hql.toString());
	}
	

}
