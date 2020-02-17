package com.by.hctm.system.action;

import java.util.List;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.BaseDataInfosUtil;
import com.by.hctm.common.DictStatus;
import com.by.hctm.common.UserRightInfoUtil;
import com.by.hctm.system.biz.IRightsBIZ;
import com.by.hctm.system.biz.ITSysRoleBiz;
import com.by.hctm.system.biz.ITSysRoleRightInfoBiz;
import com.by.hctm.system.entity.Rights;
import com.by.hctm.system.entity.TSysRole;
import com.by.hctm.system.entity.TSysRoleRightInfo;

public class TSysRoleAction extends BaseAction {
	private ITSysRoleBiz iTSysRoleBiz  ;
	private TSysRoleRightInfo sysRoleRightInfo;
	private ITSysRoleRightInfoBiz iSysRoleRightInfoBiz;
	private TSysRole sysRole ;
	private IRightsBIZ IRightsBIZ;
	private Rights rights;

	
	/**
	 * 查看角色表信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewTSysRole() throws BaseException {
		
		try{
			this.setListValue( this.iTSysRoleBiz.getTSysRoleList( this.getRollPage(), sysRole ) ) ;
			
		} catch (Exception e) {
			log.error("查看角色表信息列表错误！", e);
			throw new BaseException("查看角色表信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 保存角色表信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String saveTSysRoleInit() throws BaseException {
		try{
		} catch (Exception e) {
			log("保存角色表信息初始化错误！", e);
			throw new BaseException("保存角色表信息初始化错误！", e);
		}
		return ADD_INIT;
		
	}
	
	/**
	 * 保存角色表信息
	 * @return
	 * @throws BaseException 
	 */
	public String saveTSysRole() throws BaseException {
		
		try{
			sysRole.setWriter( UserRightInfoUtil.getChineseName(this.getRequest()) );
			sysRole.setWriteDate( this.getCurrentDateTime() );
			this.iTSysRoleBiz.saveTSysRole( sysRole );
		} catch (Exception e) {
			log("保存角色表信息错误！", e);
			throw new BaseException("保存角色表信息错误！", e);
		}
		
		return ADD;
		
	}
	
	/**
	 * 修改角色表信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String updateTSysRoleInit() throws BaseException {
		
		try{
			sysRole=this.iTSysRoleBiz.getTSysRole( sysRole.getRoleId() );
		} catch (Exception e) {
			log("修改角色表信息初始化错误！", e);
			throw new BaseException("修改角色表信息初始化错误！", e);
		}
		return MODIFY_INIT;
		
	}
	
	/**
	 * 修改角色表信息
	 * @return
	 * @throws BaseException 
	 */
	public String updateTSysRole() throws BaseException {
		
		try{
			sysRole.setWriter( UserRightInfoUtil.getChineseName(this.getRequest()) );
			sysRole.setWriteDate( this.getCurrentDateTime() );
			this.iTSysRoleBiz.updateTSysRole(sysRole);
		} catch (Exception e) {
			log("修改角色表信息错误！", e);
			throw new BaseException("修改角色表信息错误！", e);
		}
		return MODIFY;
		
	}
	
	/**
	 * 删除角色表信息
	 * @return
	 * @throws BaseException 
	 */
	public String deleteTSysRole() throws BaseException {
		try{
			sysRole = this.iTSysRoleBiz.getTSysRole(sysRole.getRoleId());
			sysRole.setIsUsable("1");
			//this.iTSysRoleBiz.deleteTSysRole(sysRole.getRoleId().toString());
			
		} catch (Exception e) {
			log("删除角色表信息错误！", e);
			throw new BaseException("删除角色表信息错误！", e);
		}
		return DELETE;
		
	}
	
	/**
	 * 查看角色表明细信息
	 * @return
	 * @throws BaseException 
	 */
	public String viewTSysRoleDetail() throws BaseException {
		
		try{
			sysRole=this.iTSysRoleBiz.getTSysRole( sysRole.getRoleId() );
		} catch (Exception e) {
			log("查看角色表明细信息错误！", e);
			throw new BaseException("查看角色表明细信息错误！", e);
		}
		return DETAIL;
		
	}
	
	/**
	 * 授权表信息
	 * @return
	 * @throws BaseException 
	 */
	public String rightSysRole() throws BaseException {
		String str  = "";
		try{
			this.getRequest().setAttribute("right", this.IRightsBIZ.getRightsList(rights));
			this.getRequest().setAttribute("map", BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1705));
			List<TSysRoleRightInfo>  glist=this.iSysRoleRightInfoBiz.getTSysRoleRightInfoList(sysRoleRightInfo);
			System.out.println(glist.size());
			
				for (int i = 0; i < glist.size(); i++) {
					str+=glist.get(i).getRightId()+",";
				}
				this.getRequest().setAttribute("str", str);
			// 得到角色已取得的权限集合
			
		} catch (Exception e) {
			log("提交角色表信息错误！", e);
			throw new BaseException("提交角色表信息错误！", e);
		}
		return "roleRight";
		
	}
	
	/**
	 * 授权表信息
	 * @return
	 * @throws BaseException 
	 */
	public String saveSysRoleRight() throws BaseException {
		
		try{
			//获取权限 和角色Id
			String str= this.getRequest().getParameter("rr");
			if(str.length()>0 &&str!=""&& str !=null){
				String sr [] = str.split(",");
				List<TSysRoleRightInfo> glist = this.iSysRoleRightInfoBiz.getTSysRoleRightInfoList(sysRoleRightInfo);
					for (int i = 0; i < glist.size(); i++) {
						this.iSysRoleRightInfoBiz.deleteTSysRoleRightInfo(glist.get(i).getRrId().toString());
					}
				
				// 批量保存角色权限集合
				for (int i = 0; i < sr.length; i++) {
					TSysRoleRightInfo tsi = new TSysRoleRightInfo();
					tsi.setRoleId(sysRoleRightInfo.getRoleId());
					tsi.setRightId(new Long(sr[i]));
					this.iSysRoleRightInfoBiz.saveTSysRoleRightInfo(tsi);
				}
			}
			
			
		} catch (Exception e) {
			log("提交角色表信息错误！", e);
			throw new BaseException("提交角色表信息错误！", e);
		}
		return "role";
		
	}
	
	/**
	 * 模糊查询角色表明细信息
	 * @return
	 */
	public String queryViewTSysRole() throws BaseException{
		try{
			this.setListValue(this.iTSysRoleBiz.getQuerySysRoleList(this.getRollPage(), sysRole));
		}catch(Exception e){
			log("提交监造大纲信息错误！", e);
			e.printStackTrace();
			throw new BaseException("提交监造大纲信息错误！", e);
			
		}
		return "query";
	}
	
	

	public ITSysRoleBiz getITSysRoleBiz() {
		return iTSysRoleBiz;
	}

	public void setITSysRoleBiz(ITSysRoleBiz sysRoleBiz) {
		iTSysRoleBiz = sysRoleBiz;
	}

	public TSysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(TSysRole sysRole) {
		this.sysRole = sysRole;
	}

	public IRightsBIZ getIRightsBIZ() {
		return IRightsBIZ;
	}

	public void setIRightsBIZ(IRightsBIZ rightsBIZ) {
		IRightsBIZ = rightsBIZ;
	}

	public Rights getRights() {
		return rights;
	}

	public void setRights(Rights rights) {
		this.rights = rights;
	}

	public TSysRoleRightInfo getSysRoleRightInfo() {
		return sysRoleRightInfo;
	}

	public void setSysRoleRightInfo(TSysRoleRightInfo sysRoleRightInfo) {
		this.sysRoleRightInfo = sysRoleRightInfo;
	}

	public ITSysRoleRightInfoBiz getISysRoleRightInfoBiz() {
		return iSysRoleRightInfoBiz;
	}

	public void setISysRoleRightInfoBiz(ITSysRoleRightInfoBiz sysRoleRightInfoBiz) {
		iSysRoleRightInfoBiz = sysRoleRightInfoBiz;
	}
	

}
