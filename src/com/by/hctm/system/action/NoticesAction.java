package com.by.hctm.system.action;
import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.BaseDataInfosUtil;
import com.by.hctm.common.DictStatus;
import com.by.hctm.common.UserRightInfoUtil;
import com.by.hctm.manpower.biz.IUsersBiz;
import com.by.hctm.manpower.entity.Users;
import com.by.hctm.system.biz.IDepartmentsBIZ;
import com.by.hctm.system.biz.INoticesBiz;
import com.by.hctm.system.entity.Departments;
import com.by.hctm.system.entity.Notices;

@SuppressWarnings("serial")
public class NoticesAction extends BaseAction {
	private INoticesBiz noticesBiz  ;
	private Notices notices ;
	private IUsersBiz iUsersBiz;
	private String id;
	private Users ur;
	private IDepartmentsBIZ IDepartmentsBIZ;
	private Departments dept;
	
	/**
	 * 查看公告信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewNotices() throws BaseException {
		
		try{
			this.setListValue( this.noticesBiz.getNoticesList( this.getRollPage(), notices ) ) ;
			this.getRequest().setAttribute("notice",BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1702));
		} catch (Exception e) {
			log.error("查看公告信息列表错误！", e);
			throw new BaseException("查看公告信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 保存公告信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String saveNoticesInit() throws BaseException {
		try{
				 ur=(Users)this.iUsersBiz.getUsersList(UserRightInfoUtil.getSessionInfo(this.getRequest()).getUsers()).get(0);
				 dept=this.IDepartmentsBIZ.getDepartments(ur.getDepId());
				 this.getRequest().setAttribute("notice",BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1702));
		} catch (Exception e) {
			log("保存公告信息初始化错误！", e);
			throw new BaseException("保存公告信息初始化错误！", e);
		}
		return ADD_INIT;
		
	}
	
	/**
	 * 保存公告信息
	 * @return
	 * @throws BaseException 
	 */
	public String saveNotices() throws BaseException {
		
		try{
			this.noticesBiz.saveNotices( notices );
		} catch (Exception e) {
			log("保存公告信息错误！", e);
			throw new BaseException("保存公告信息错误！", e);
		}
		
		return ADD;
		
	}
	
	/**
	 * 修改公告信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String updateNoticesInit() throws BaseException {
		
		try{
			notices=this.noticesBiz.getNotices( notices.getNoticeId() );
		 this.getRequest().setAttribute("notice",BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1702));

		} catch (Exception e) {
			log("修改公告信息初始化错误！", e);
			throw new BaseException("修改公告信息初始化错误！", e);
		}
		return MODIFY_INIT;
		
	}
	
	/**
	 * 修改公告信息
	 * @return
	 * @throws BaseException 
	 */
	public String updateNotices() throws BaseException {
		
		try{
			this.noticesBiz.updateNotices( notices );
		} catch (Exception e) {
			log("修改公告信息错误！", e);
			throw new BaseException("修改公告信息错误！", e);
		}
		return MODIFY;
		
	}
	
	/**
	 * 删除公告信息
	 * @return
	 * @throws BaseException 
	 */
	public String deleteNotices() throws BaseException {
		try{
			String str [] =id.split(";");
			for (int i = 0; i < str.length; i++) {
				notices=this.noticesBiz.getNotices(new Long(str[i]));
				notices.setIsUsable("1");
				//this.noticesBiz.deleteNotices( str[i]  );
			}
			
		} catch (Exception e) {
			log("删除公告信息错误！", e);
			throw new BaseException("删除公告信息错误！", e);
		}
		return DELETE;
		
	}
	
	/**
	 * 查看公告明细信息
	 * @return
	 * @throws BaseException 
	 */
	public String viewNoticesDetail() throws BaseException {
		
		try{
			notices=this.noticesBiz.getNotices( notices.getNoticeId() );
		} catch (Exception e) {
			log("查看公告明细信息错误！", e);
			throw new BaseException("查看公告明细信息错误！", e);
		}
		return DETAIL;
		
	}
	


	public INoticesBiz getNoticesBiz() {
		return noticesBiz;
	}

	public void setNoticesBiz(INoticesBiz noticesBiz) {
		this.noticesBiz = noticesBiz;
	}

	public Notices getNotices() {
		return notices;
	}

	public void setNotices(Notices notices) {
		this.notices = notices;
	}

	public IUsersBiz getiUsersBiz() {
		return iUsersBiz;
	}

	public void setiUsersBiz(IUsersBiz iUsersBiz) {
		this.iUsersBiz = iUsersBiz;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public IDepartmentsBIZ getIDepartmentsBIZ() {
		return IDepartmentsBIZ;
	}

	public void setIDepartmentsBIZ(IDepartmentsBIZ iDepartmentsBIZ) {
		IDepartmentsBIZ = iDepartmentsBIZ;
	}

	public Users getUr() {
		return ur;
	}

	public void setUr(Users ur) {
		this.ur = ur;
	}

	public Departments getDept() {
		return dept;
	}

	public void setDept(Departments dept) {
		this.dept = dept;
	}
	
}
