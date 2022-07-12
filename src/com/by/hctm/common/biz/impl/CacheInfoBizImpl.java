package com.by.hctm.common.biz.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import com.by.base.biz.impl.BaseBizImpl;
import com.by.base.exception.BaseException;
import com.by.hctm.common.BaseDataInfosUtil;
import com.by.hctm.common.TableStatus;
import com.by.hctm.common.biz.ICacheInfoBiz;
import com.by.hctm.common.exception.PersistenceException;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.manpower.entity.Users;
import com.by.hctm.system.entity.ConstructionSubjects;
import com.by.hctm.system.entity.Departments;
import com.by.hctm.system.entity.MaterialTypes;
import com.by.hctm.system.entity.Subjects;
import com.by.hctm.system.entity.TSysDict;
import com.by.hctm.system.entity.TSysRole;
 
public class CacheInfoBizImpl extends BaseBizImpl implements ICacheInfoBiz   {
	 
	CacheManager manager;
	
	/**
	 * 取得指定缓存的总数
	 * @param cacheName 缓存名称 
	 * @return
	 */
	public int getCacheInfoSize( String cacheName ) {
		return manager.getEhcache( cacheName ).getSize() ;
	}
	
	/**
	 * 转换缓存信息为Map方式 key: id value: po
	 * @param cacheName 缓存名称 
	 * @return
	 */
	public Map convertCacheInfoToMap( Object cacheName ) {
		Map map 		= new TreeMap();
		Ehcache cache 	= manager.getEhcache( cacheName.toString() ) ;
		Element element = null ;
		
		if( cache != null ) {
			List gList = cache.getKeys() ;
			for ( int k=0; k<gList.size(); k++ ) {
				element =  cache.get( gList.get(k) ) ;
				if( element != null ) {
					map.put( element.getObjectKey(), element.getObjectValue() ) ;
				}
		    }
		}
		return map ;
	}
	
	/**
	 * 转换缓存信息为Map方式 key: id value: po
	 * @param cacheName 缓存名称 
	 * @return
	 */
	public Map convertCacheInfoToMap( Object keyValue, Object cacheName ) {
		Map map 		= new TreeMap();
		Ehcache cache 	= manager.getEhcache( cacheName.toString() ) ;
		Element element = null ;
		
		element =  cache.get( keyValue ) ;
		if( element != null ) {
			map.put( element.getObjectKey(), element.getObjectValue() ) ;
		}
		
		return map ;
	}
	
	/**
	 * 初始化数据字典数据同步到内存
	 * @param cacheName 缓存名称 
	 * @return
	 * @throws BaseException 
	 */
	public List initCacheInfos( String cacheName ) throws BaseException{
		Element element = null ;
		List gList 		= new ArrayList();
		
		Ehcache cache 	= manager.getEhcache( cacheName ) ;
		cache.removeAll() ;
		
		if( cacheName !=null && cacheName.length()>0 ) {
			
			if(TableStatus.BASE_DATA_TYPE_01.equals( cacheName ) ) { 		//用户表信息
				Users user ;
				
				gList =  this.getObjects( " from Users u order by u.userId asc " ) ;
				
				if( gList.size()>0 ) {
					for (Iterator<Users> iter = gList.iterator(); iter.hasNext(); ) {
						user =  iter.next() ;
						cache.put( initElement( user.getUserId() , user ) ) ;
						cache.put( initElement( user.getUserName() , user ) ) ;
				    }
				}
			}else if(TableStatus.BASE_DATA_TYPE_02.equals( cacheName ) ) { //部门表信息
				Departments depart ;
				
				gList = this.getObjects( " from Departments " ) ;
				
				if( gList.size()>0 ) {
					for (Iterator<Departments> iter = gList.iterator(); iter.hasNext(); ) {
						depart 	=  iter.next() ;
						cache.put( initElement( depart.getDepId() , depart ) ) ;
				    }
				}
				
			}else if(TableStatus.BASE_DATA_TYPE_03.equals( cacheName ) ) { 	//字典表信息
				TSysDict dict ;
				Map dictMap =  new TreeMap() ;
//				gList = this.getObjects( " from TSysDict t where t.dictLevel = 3 " ) ;
				gList = this.getObjects( " from TSysDict t where t.isUsable = '0' order by t.dictOrder  " ) ;
				if( gList.size()>0 ) {
					for (Iterator<TSysDict> iter = gList.iterator(); iter.hasNext(); ) {
						dict 	=  iter.next() ;
						if( cache.getKeys().contains( dict.getParentDictCode() ) ) {
							Element selement = cache.getQuiet( dict.getParentDictCode() ) ;
							
							List<TSysDict> dictList = (List<TSysDict>) selement.getValue();
							dictList.add( dict ) ;
							cache.put( initElement( dict.getParentDictCode() , dictList ) ) ;
							
						}else {
							List<TSysDict> dictList = new ArrayList<TSysDict>() ;
							dictList.add( dict ) ;
							cache.put( initElement( dict.getParentDictCode() , dictList ) ) ;
						}
				    }
				}
				
			}else if(TableStatus.BASE_DATA_TYPE_04.equals( cacheName ) ) { //监理专业信息
				Subjects subjects ;
				
				gList = this.getObjects( " from Subjects " ) ;
				
				if( gList.size()>0 ) {
					for (Iterator<Subjects> iter = gList.iterator(); iter.hasNext(); ) {
						subjects 	=  iter.next() ;
						cache.put( initElement( subjects.getSubjId() , subjects ) ) ;
				    }
				}
				
			}else if(TableStatus.BASE_DATA_TYPE_05.equals( cacheName ) ) { //监造专业信息
				ConstructionSubjects conSubjects ;
				
				gList = this.getObjects( " from ConstructionSubjects " ) ;
				
				if( gList.size()>0 ) {
					for (Iterator<ConstructionSubjects> iter = gList.iterator(); iter.hasNext(); ) {
						conSubjects 	=  iter.next() ;
						cache.put( initElement( conSubjects.getCsubjId() , conSubjects ) ) ;
				    }
				}
			}else if(TableStatus.BASE_DATA_TYPE_06.equals( cacheName ) ) { //角色信息
				TSysRole role ;
				
				gList = this.getObjects( " from TSysRole " ) ;
				
				if( gList.size()>0 ) {
					for (Iterator<TSysRole> iter = gList.iterator(); iter.hasNext(); ) {
						role 	=  iter.next() ;
						cache.put( initElement( role.getRoleId() , role ) ) ;
				    }
				}
			}else if(TableStatus.BASE_DATA_TYPE_07.equals( cacheName ) ) { //监理资料类别
				MaterialTypes mtypes ;
				
				gList = this.getObjects( " from MaterialTypes mt where mt.isUsable = '" + TableStatus.COMMON_STATUS_VALID + "' ") ;
				
				if( gList.size()>0 ) {
					for (Iterator<MaterialTypes> iter = gList.iterator(); iter.hasNext(); ) {
						mtypes 	=  iter.next() ;
						cache.put( initElement( mtypes.getMtId() , mtypes ) ) ;
				    }
				}
			}
		}
		
		return gList ;
	}
	
	/**
	 * 取得SEQUENCE的值
	 * @param seqName  SEQUENCE名称 
	 * @throws BaseException 
	 */
	public String findSequenceValue(String seqName ) throws BaseException {
		return getSequenceValue(seqName) ;
	}
	
	/**
	 * 取得流程申请信息
	 * @param billId 单据编号 可为空
	 * @param billType 流程类型（流程编号） 可为空
	 * @param isUsable 是否有效 0 有效 1 无效 可为空
	 * @author dq 2012-11-12
	 * @return
	 * @throws PersistenceException
	 */
	public String getProcessInfo(Long billId, String billType, String isUsable ) throws BaseException {
		
		WfProcessRequest pi = null ;
		
		StringBuffer hql = new StringBuffer(" from WfProcessRequest p where 1=1 " ) ;
		
		if( ! StringUtil.isBlank( billId ) ) {
			hql.append(" and p.billId = ").append( billId )  ;
		}
		
		if( billType != null && billType.length()>0 ) {
			hql.append(" and p.billType = '" ).append( billType ).append("' ");
		}
		
		if( isUsable != null && isUsable.length()>0 ) {
			hql.append(" and p.isUsable = '").append( isUsable ).append("' ") ;
		}
		
		List result = this.getObjects( hql.toString() );
		
		if ( result != null && result.size() > 0) {
			pi = ( WfProcessRequest )result.get(0) ;
		}
		//得到下级节点审批人中文名
		String auditp = "" ;
		if( pi != null && ! StringUtil.isBlank( pi.getNextNameEn() ) ) {
			auditp = "(" + BaseDataInfosUtil.convertLoginNameToChnName( pi.getNextNameEn() ) + ")" ;
			
		}
		return auditp ;
	
	}

	private Element initElement( Object obj1, Object obj2 ){
		return new Element( obj1 , obj2 ) ;
	}
	
	public CacheManager getManager() {
		return manager;
	}

	public void setManager(CacheManager manager) {
		this.manager = manager;
	}
}
