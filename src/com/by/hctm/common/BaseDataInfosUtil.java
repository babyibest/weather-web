package com.by.hctm.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.by.base.exception.BaseException;
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

public class BaseDataInfosUtil {

	/**
	 * 取得SEQUENCE的值
	 * @param seqName  SEQUENCE名称 
	 * @throws BaseException 
	 */
	public static String findSequenceValue(String seqName ) throws BaseException {
		return iCacheInfoBiz.findSequenceValue(seqName)  ;
	}
	
	/**
	 * 取用户中文名
	 * @param userId 用户Id(主键)
	 * @return 用户中文名
	 * @throws BaseException
	 */
	public static String convertUserIdToChnName( Long userId ) throws BaseException {
		String rValue = "" ;
		
		if( StringUtil.isNotBlank(userId) ) {
			Object obj = getInitInfos(userId, TableStatus.BASE_DATA_TYPE_01) ;
			if( StringUtil.isNotBlank( obj ) ) {
				Users users = (Users) obj ;
				if( StringUtil.isNotBlank( users.getUserChinesename() ) ) {
					rValue = users.getUserChinesename() ;
				}
			}
		}
		return rValue ;
	}
	
	/**
	 * 取用户登录名
	 * @param userId 用户Id(主键)
	 * @return 用户登录名
	 * @throws BaseException
	 */
	public static String convertUserIdToEnnName( Long userId ) throws BaseException {
		String rValue = "" ;
		
		if( StringUtil.isNotBlank(userId) ) {
			Object obj = getInitInfos(userId, TableStatus.BASE_DATA_TYPE_01) ;
			if( StringUtil.isNotBlank( obj ) ) {
				Users users = (Users) obj ;
				if( StringUtil.isNotBlank( users.getUserName() ) ) {
					rValue = users.getUserName() ;
				}
			}
		}
		return rValue ;
	}
	
	/**
	 * 取用户中文名
	 * @param loginName 用户登录名(英文)
	 * @return 用户中文名
	 * @throws BaseException
	 */
	public static String convertLoginNameToChnName( String loginName ) throws BaseException {
		String rValue = "" ;
		
		if( StringUtil.isNotBlank(loginName) ) {
			Object obj = getInitInfos(loginName, TableStatus.BASE_DATA_TYPE_01) ;
			if( StringUtil.isNotBlank( obj ) ) {
				Users users = (Users) obj ;
				if( StringUtil.isNotBlank( users.getUserChinesename() ) ) {
					rValue = users.getUserChinesename() ;
				}
			}
		}

		return rValue ;
	}
	
	/**
	 * 取用户中文名,以指定分割类型显示, 
	 * 如userId={'11','lisi'}, splitType="/", 结果= 张三/李四, 如不指定分割类型则以,分割显示
	 * @param userId 用户登录名(英文)数组,如{'zhansan','lisi'}
	 * @param splitType 显示分割类型 , 如为null则取默认值','
	 * @return 
	 * @throws BaseException
	 */
	public static String convertUserIdToChnName( String[] userId, String splitType ) throws BaseException {
		StringBuffer rValue = new StringBuffer( "" ) ;
		
		if( StringUtil.isNotBlank(userId) ) {
			for( int i=0; i<userId.length;i++ ) {
				Object obj = getInitInfos( new Long( userId[i] ), TableStatus.BASE_DATA_TYPE_01) ;
				if( StringUtil.isNotBlank( obj ) ) {
					Users users = (Users) obj ;
					
					if( i == userId.length-1 ) {
						if( StringUtil.isNotBlank( users.getUserChinesename() ) ) {
							rValue.append( users.getUserChinesename() ) ;
						}
					}else {
						if( StringUtil.isNotBlank(splitType) ) {
							if( StringUtil.isNotBlank( users.getUserChinesename() ) ) {
								rValue.append( users.getUserChinesename() ).append( splitType ) ;
							}
						}else {
							if( StringUtil.isNotBlank( users.getUserChinesename() ) ) {
								rValue.append( users.getUserChinesename() ).append(",") ;
							}
						}
					}
				}
			}
		}

		return rValue.toString() ;
	}
	
	/**
	 * 取用户中文名,以指定分割类型显示, 
	 * 如login={'zhansan','lisi'}, splitType="/", 结果= 张三/李四, 如不指定分割类型则以,分割显示
	 * @param loginName 用户登录名(英文)数组,如{'zhansan','lisi'}
	 * @param splitType 显示分割类型 , 如为null则取默认值','
	 * @return 
	 * @throws BaseException
	 */
	public static String convertLoginNameToChnName( String[] loginName, String splitType ) throws BaseException {
		StringBuffer rValue = new StringBuffer( "" ) ;
		
		if( StringUtil.isNotBlank(loginName) ) {
			for( int i=0; i<loginName.length;i++ ) {
				Object obj = getInitInfos(loginName[i], TableStatus.BASE_DATA_TYPE_01) ;
				if( StringUtil.isNotBlank( obj ) ) {
					Users users = (Users) obj ;
					
					if( i == loginName.length-1 ) {
						rValue.append( users.getUserChinesename() ) ;
					}else {
						if( StringUtil.isNotBlank(splitType) ) {
							if( StringUtil.isNotBlank( users.getUserChinesename() ) ) {
								rValue.append( users.getUserChinesename() ).append( splitType ) ;
							}
						}else {
							if( StringUtil.isNotBlank( users.getUserChinesename() ) ) {
								rValue.append( users.getUserChinesename() ).append(",") ;
							}
						}
					}
				}
			}
		}

		return rValue.toString() ;
	}
	
	/**
	 * 取用户部门中文名
	 * @param deptId 部门Id(主键)
	 * @return 部门中文名
	 * @throws BaseException
	 */
	public static String convertDeptIdToName( Long deptId ) throws BaseException {
		String rValue = "" ;
		
		if( StringUtil.isNotBlank(deptId) ) {
			Object obj = getInitInfos(deptId, TableStatus.BASE_DATA_TYPE_02) ;
			if( StringUtil.isNotBlank( obj ) ) {
				Departments dept = (Departments) obj ;
				if( StringUtil.isNotBlank( dept.getDeptName() ) ) {
					rValue = dept.getDeptName() ;
				}
			} 
		}
		
		return rValue ;
	}
	
	/**
	 * 取监理标准中文名
	 * @param subId 监理标准Id(主键)
	 * @return 监理标准中文名
	 * @throws BaseException
	 */
	public static String convertStandardIdToName( Long subId ) throws BaseException {
		String rValue = "" ;
		
		if( StringUtil.isNotBlank(subId) ) {
			Object obj = getDictInfoToMap("1700").get( subId )  ;
			if( StringUtil.isNotBlank( obj ) ) {
				rValue = obj.toString() ;
			}
		}
		
		return rValue ;
	}
	
	/**
	 * 取监理专业中文名
	 * @param subId 监理专业Id(主键)
	 * @return 监理专业中文名
	 * @throws BaseException
	 */
	public static String convertSubjectIdToName( Long subId ) throws BaseException {
		String rValue = "" ;
		
		if( StringUtil.isNotBlank(subId) ) {
			Object obj = getInitInfos(subId, TableStatus.BASE_DATA_TYPE_04) ;
			if( StringUtil.isNotBlank( obj ) ) {
				Subjects sub = (Subjects) obj ;
				rValue = sub.getSubjName() ;
			} 
		}
		
		return rValue ;
	}
	
	/**
	 * 取专业中文名,以指定分割类型显示, 
	 * 如subId={'221','262'}, splitType="/", 结果= 输电专业/变电专业, 如不指定分割类型则以,分割显示
	 * @param subjId 专业Id(long数字)数组,如{'262','263'}
	 * @param splitType 显示分割类型 , 如为null则取默认值','
	 * @return 
	 * @throws BaseException
	 * 谢磊 取专业
	 */
	
	public static String convertSubjectIdToName( String[] subId, String splitType ) throws BaseException {
		StringBuffer rValue = new StringBuffer( "" ) ;
		
		if( StringUtil.isNotBlank(subId) ) {
			for( int i=0; i<subId.length;i++ ) {
				Object obj = getInitInfos(new Long(subId[i]), TableStatus.BASE_DATA_TYPE_04) ;
				if( StringUtil.isNotBlank( obj ) ) {
					Subjects sub = (Subjects) obj ;
					
					if( i == subId.length-1 ) {
						rValue.append( sub.getSubjName() ).append("("+sub.getBelongStandard()+")<br>") ;
					}else {
						if( StringUtil.isNotBlank(splitType) ) {
							if( StringUtil.isNotBlank( sub.getSubjName() ) ) {
								rValue.append( sub.getSubjName() ).append("("+sub.getBelongStandard()+")").append( "<br>" ) ;
							}
						}else {
							if( StringUtil.isNotBlank( sub.getSubjName() ) ) {
								rValue.append( sub.getSubjName() ).append("("+sub.getBelongStandard()+")").append("<br>") ;
							}
						}
					}
				}
			}
		}

		return rValue.toString() ;
	}
	/**
	 * 取监造专业中文名
	 * @param subId 监造专业Id(主键)
	 * @return 监造专业中文名
	 * @throws BaseException
	 */
	public static String convertConSubjectIdToName( Long subId ) throws BaseException {
		String rValue = "" ;
		
		if( StringUtil.isNotBlank(subId) ) {
			Object obj = getInitInfos(subId, TableStatus.BASE_DATA_TYPE_05) ;
			if( StringUtil.isNotBlank( obj ) ) {
				ConstructionSubjects sub = (ConstructionSubjects) obj ;
				rValue = sub.getCsubjName() ;
			} 
		}
		
		return rValue ;
	}
	
	/**
	 * 取监造资料类别中文名
	 * @param mtId 监造资料类别Id(主键)
	 * @return 监造资料类别中文名
	 * @throws BaseException
	 */
	public static String convertMaterialTypeIdToName( Long mtId ) throws BaseException {
		String rValue = "" ;
		
		if( StringUtil.isNotBlank(mtId) ) {
			Object obj = getInitInfos(mtId, TableStatus.BASE_DATA_TYPE_07) ;
			if( StringUtil.isNotBlank( obj ) ) {
				MaterialTypes mt = (MaterialTypes) obj ;
				rValue = mt.getMtName() ;
			} 
		}
		
		return rValue ;
	}
	
	/**
	 * 取角色中文名
	 * @param subId 角色Id(主键)
	 * @return 角色中文名
	 * @throws BaseException
	 */
	public static String convertRoleIdToName( Long subId ) throws BaseException {
		String rValue = "" ;
		
		if( StringUtil.isNotBlank(subId) ) {
			Object obj = getInitInfos(subId, TableStatus.BASE_DATA_TYPE_06) ;
			if( StringUtil.isNotBlank( obj ) ) {
				TSysRole sub = (TSysRole) obj ;
				rValue = sub.getRoleName() ;
			} 
		}
		
		return rValue ;
	}
	
	/**
	 * 取工程部门信息, 以Map形式(key=deptId, value=deptName)显示
	 * @param deptId 部门id
	 * @return 
	 * @throws BaseException
	 */
	public static Map getDeptInfoWithProjectToMap( ) throws BaseException {
		Map rValue 			= new TreeMap() ;
		Departments dept 	= null ;
		Object obj 			= getAllInitInfos(false, TableStatus.BASE_DATA_TYPE_02) ;
		
		if( StringUtil.isNotBlank( obj ) ) {
			List<Departments> deptList = (List<Departments>) obj ;
			
			for( Departments depts : deptList) {
				if( "0".equals( depts.getIsProject() ) ) {
					rValue.put( depts.getDepId(), depts.getDeptName() ) ;
				}
			}
		} 
		
		return rValue ;
	}
	
	/**
	 * 取字典表编码对应中文名称 
	 * @param dictCode 字典表编码, 如01
	 * @param dictType 字典表类型, 如1700
	 * @return 字典表编码中文名称
	 * @throws BaseException
	 */
	public static String convertDictCodeToName( String dictCode, String dictType ) throws BaseException {
		String rValue = "" ;
		TSysDict dict = null ;
		
		if( StringUtil.isNotBlank(dictType ) && StringUtil.isNotBlank(dictCode ) ) {
			Object obj = getInitInfos(dictType, TableStatus.BASE_DATA_TYPE_03) ;
			if( StringUtil.isNotBlank( obj ) ) {
				List<TSysDict> dictList = (List<TSysDict>) obj ;
				for( int i=0; i<dictList.size(); i++ ) {
					dict = dictList.get(i) ;
					if( dictCode.equals( dict.getDictCode() ) ) {
						rValue = dict.getDictName() ;
						break ;
					}
				}
			} 
		}
		
		return rValue ;
	}
	
	/**
	 * 取字典表信息数据, 以Map形式(key=dictCode, value=dictName)显示
	 * @param dictType 字典表类型
	 * @return 字典表信息
	 * @throws BaseException
	 */
	public static Map getDictInfoToMap( String dictType ) throws BaseException {
		Map rValue = new TreeMap() ;
		
		if( StringUtil.isNotBlank(dictType ) ) {
			Object obj = getInitInfos(dictType, TableStatus.BASE_DATA_TYPE_03) ;
			if( StringUtil.isNotBlank( obj ) ) {
				List<TSysDict> dictList = (List<TSysDict>) obj ;
				for( TSysDict tdict : dictList ) {
					rValue.put(tdict.getDictCode(), tdict.getDictName() ) ;
				}
			} 
		}
		
		return rValue ;
	}
	
	/**
	 * 取字典表编码对应资料模板页面 
	 * @param dictCode 字典表编码, 如01
	 * @param dictType 字典表类型, 如1706
	 * @return 字典表编码中文名称
	 * @throws BaseException
	 */
	public static String convertDictCodeToUrlpage( String dictCode, String dictType ) throws BaseException {
		String rValue = "" ;
		TSysDict dict = null ;
		
		if( StringUtil.isNotBlank(dictType ) && StringUtil.isNotBlank(dictCode ) ) {
			Object obj = getInitInfos(dictType, TableStatus.BASE_DATA_TYPE_03) ;
			if( StringUtil.isNotBlank( obj ) ) {
				List<TSysDict> dictList = (List<TSysDict>) obj ;
				for( int i=0; i<dictList.size(); i++ ) {
					dict = dictList.get(i) ;
					if( dictCode.equals( dict.getDictCode() ) ) {
						rValue = dict.getRemark() ;
						break ;
					}
				}
			} 
		}
		
		return rValue ;
	}
	
	
	/**
	 * 取基础信息 ,如 keyValue=userId, initName=usersCache, 返回值为整个Users对象实例
	 * @param keyValue 主键ID
	 * @param initName 基础信息
	 * @return
	 * @throws BaseException
	 */
	public static Object  getInitInfos( Object keyValue, Object initName) throws BaseException {
        return iCacheInfoBiz.convertCacheInfoToMap(keyValue, initName).get( keyValue )  ;
	}
	
	/**
	 * 取基础信息中的所有信息, 如initName=usersCache, 返回值为所有的用户信息
	 * @param vInit true  从数据库重新装载 false 从内存装载
	 * @param initName 基础信息
	 * @return
	 * @throws BaseException
	 */
	public static List getAllInitInfos( boolean vInit, String initName) throws BaseException {
		List gList = new ArrayList();
		if (vInit || getBaseIndexInfoSize(initName) == 0) {
        	
            // 取得所有数据
            gList = initBaseIndexInfos( initName ) ;
            
        } else {
            gList.addAll( iCacheInfoBiz.convertCacheInfoToMap(initName).values() );
        }

		return gList ;
	}
	
	/**
	 * 初始化基础数据同步到缓存, 重新加载缓存
	 * @param initType 同步类型 
	 * @return
	 * @throws BaseException 
	 */
	public static List initBaseIndexInfos( String initType ) throws BaseException{
		return iCacheInfoBiz.initCacheInfos( initType ) ;
	}
	
	/**
	 * 取基础信息的数量
	 * @param cacheName 基础信息类型 
	 * @return
	 */
	public static int getBaseIndexInfoSize( String cacheName ) {
		return iCacheInfoBiz.getCacheInfoSize( cacheName ) ;
	}
	
	private static void initBaseData( ) throws BaseException {
		initBaseIndexInfos( TableStatus.BASE_DATA_TYPE_01 );
		initBaseIndexInfos( TableStatus.BASE_DATA_TYPE_02 );
		initBaseIndexInfos( TableStatus.BASE_DATA_TYPE_03 );
		initBaseIndexInfos( TableStatus.BASE_DATA_TYPE_04 );
		initBaseIndexInfos( TableStatus.BASE_DATA_TYPE_05 );
	}
	
	private static ICacheInfoBiz iCacheInfoBiz ;
	
	public static ICacheInfoBiz getICacheInfoBiz() {
		return iCacheInfoBiz;
	}

	public static boolean setICacheInfoBiz(ICacheInfoBiz cacheInfoBiz) throws BaseException {
		iCacheInfoBiz = cacheInfoBiz;
		initBaseData ( );
		return true; 
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Ehcache ehcache = iCacheInfoBiz.getEhcache("dictsCache") ;
//		
//		List gList = ehcache.getKeys();
//		for( int i=0; i<gList.size(); i++ ) {
//			Element element = ehcache.get( gList.get( i ) ) ;
//			
//			System.out.println( element.getValue()  ) ;
//		}
//		
//		System.out.println( gList.size() ) ;
		
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
	public static String getProcessInfo( Long billId, String billType, String isUsable ) throws BaseException {
		return iCacheInfoBiz.getProcessInfo( billId , billType , isUsable )  ;
	}
}
