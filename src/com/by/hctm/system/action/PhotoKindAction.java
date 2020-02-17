package com.by.hctm.system.action;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringEscapeUtils;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.BaseDataInfosUtil;
import com.by.hctm.common.DictStatus;
import com.by.hctm.system.biz.IPhotoKindBiz;
import com.by.hctm.system.entity.PhotoKind;

public class PhotoKindAction extends BaseAction {
	private IPhotoKindBiz photoKindBiz  ;
	private PhotoKind photoKind ;
	private String tree;
	
	
	/**数码照片树维护*/
	/**
	 * 查看标准信息首页列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewStandardsIndex() {
		return INDEX ;
	}
	
	/**
	 * 查看标准信息表初始树列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewStandardsInitTree() throws BaseException {
			
			try{
				Long id;
				String name = "";
				
				// 初始父ID为零
				Set gSet = BaseDataInfosUtil.getDictInfoToMap(DictStatus.COMMON_DICT_TYPE_1700).keySet() ;
				StringBuffer script = new StringBuffer();
				script.append("var tree = new WebFXTree(\"机构树\");\n");
				Iterator it = gSet.iterator();
				while (it.hasNext()) {
					String  mapentry = (String) it.next();  
					//Map map=(Map)it.next();
					id = new Long(mapentry);
					name = BaseDataInfosUtil.convertDictCodeToName(mapentry, DictStatus.COMMON_DICT_TYPE_1700);
					// 判断是否有子节点
					photoKind =new PhotoKind();
					photoKind.setParentId(id);
					int conut = this.photoKindBiz.getPhotoKindChild(photoKind).size();
					if (conut != 0) { 
						script.append("tree.add( rti = new WebFXLoadTreeItem(\"" + name + "\", \"viewPhotoKindTree_photoKind.action?photoKind.parentId=" + id + "\",\"javascript:folderview('" + id + "')\"));\n");
						
					} else {
						script.append("tree.add( new WebFXTreeItem(\"" + name + "\",\"\"));\n");
					}
				}
				
				script.append("document.write(tree);\n");
				script.append("tree.expand();\n"); 

				tree = script.toString() ;
				
			} catch (Exception e) {
				log("查看部门信息表初始树列表错误！", e);
				throw new BaseException("查看部门信息表初始树列表错误！", e);
			}
			
			return TREE ;
		}
		
		/**
		 * 查看部门信息表树列表 
		 * @return
		 * @throws BaseException 
		 * @Action
		 */
		public void viewPhotoKindTree() throws BaseException {
			
			try{
				Long id;
				String name = "";
				List<PhotoKind> photoKindList =(List<PhotoKind>) photoKindBiz.getPhotoKindList( photoKind  );
				StringBuffer script = new StringBuffer();
				script.append("<?xml version=\"1.0\"?>");
				script.append("<tree>");
				Iterator it=photoKindList.iterator();
				while (it.hasNext()) {
					PhotoKind pk = (PhotoKind) it.next() ;
					id 		= pk.getPkId() ;
					name 	= StringEscapeUtils.escapeXml(pk.getPkName().trim());
					script.append("<tree text=\"" + name + "\" id=\"" + id + "\" action=\"javascript:folderview('" + id + "')\" ");
					// 判断是否有子节点
					PhotoKind pkd =new PhotoKind();
					pkd.setParentId(id);
					int conut = this.photoKindBiz.getPhotoKindChild(pkd).size();
					if (conut != 0) { 
						script.append(" src=\"viewPhotoKindTree_photoKind.action?photoKind.parentId=").append(id).append("\" ");
						
					}

					script.append("/>");
				}
				
				script.append("</tree>");
				
				getResponse().getWriter().println(script.toString());
				
			} catch (Exception e) {
				log("查看部门信息表初始树列表错误！", e);
				throw new BaseException("查看部门信息表初始树列表错误！", e);
			}
			
			
		}
	

	/**
	 * 查看数码照片类别信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewPhotoKind() throws BaseException {
		
		try{
			this.setListValue( this.photoKindBiz.getPhotoKindList( this.getRollPage(), photoKind ) ) ;
		} catch (Exception e) {
			log.error("查看数码照片类别信息列表错误！", e);
			throw new BaseException("查看数码照片类别信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 保存数码照片类别信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String savePhotoKindInit() throws BaseException {
		try{
			//判断数码照片
			if(photoKind !=null && photoKind.getParentId()>10  ){
				photoKind = photoKindBiz.getPhotoKind(photoKind.getParentId());
			}
			else{
				this.getRequest().setAttribute("pkId",photoKind.getParentId());
			}
		} catch (Exception e) {
			log("保存数码照片类别信息初始化错误！", e);
			throw new BaseException("保存数码照片类别信息初始化错误！", e);
		}
		return ADD_INIT;
		
	}
	
	/**
	 * 保存数码照片类别信息
	 * @return
	 * @throws BaseException 
	 */
	public String savePhotoKind() throws BaseException {
		
		try{
			System.out.println(photoKind.getParentId());
			
			photoKind.setIsHaveChild("0");
			this.photoKindBiz.savePhotoKind( photoKind );
		} catch (Exception e) {
			log("保存数码照片类别信息错误！", e);
			throw new BaseException("保存数码照片类别信息错误！", e);
		}
		
		return ADD;
		
	}
	
	/**
	 * 修改数码照片类别信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String updatePhotoKindInit() throws BaseException {
		
		try{
			//List<PhotoKind> pkd=this.photoKindBiz.getPhotoKindList(photoKind);
			
			if(photoKind !=null && photoKind.getParentId()>=10){
				photoKind = photoKindBiz.getPhotoKind(this.photoKind.getParentId());
				if(this.photoKindBiz.getPhotoKindChild(photoKind).size()>0){
					photoKind.setIsHaveChild("0");
				}else{
					photoKind.setIsHaveChild("1");
				}
				this.getRequest().setAttribute("pkId", photoKind);
			}else{
				photoKind.setPkId(photoKind.getParentId());
				this.getRequest().setAttribute("pkId", photoKind);
			}
		} catch (Exception e) {
			log("修改数码照片类别信息初始化错误！", e);
			throw new BaseException("修改数码照片类别信息初始化错误！", e);
		}
		return MODIFY_INIT;
		
	}
	
	/**
	 * 修改数码照片类别信息
	 * @return
	 * @throws BaseException 
	 */
	public String updatePhotoKind() throws BaseException {
		
		try{
			this.photoKindBiz.updatePhotoKind( photoKind );
			System.out.println(photoKind.getParentId());
		} catch (Exception e) {
			log("修改数码照片类别信息错误！", e);
			throw new BaseException("修改数码照片类别信息错误！", e);
		}
		return MODIFY;
		
	}
	
	/**
	 * 删除数码照片类别信息
	 * @return
	 * @throws BaseException 
	 */
	public String deletePhotoKind() throws BaseException {
		try{
			if(this.photoKindBiz.getPhotoKindList(photoKind).size()==0){
				this.photoKindBiz.deletePhotoKind( photoKind.getPkId().toString() );
			}else{
				
			};
		} catch (Exception e) {
			log("删除数码照片类别信息错误！", e);
			throw new BaseException("删除数码照片类别信息错误！", e);
		}
		return DELETE;
		
	}
	
	/**
	 * 查看数码照片类别明细信息
	 * @return
	 * @throws BaseException 
	 */
	public String viewPhotoKindDetail() throws BaseException {
		
		try{
			photoKind=this.photoKindBiz.getPhotoKind( photoKind.getPkId() );
		} catch (Exception e) {
			log("查看数码照片类别明细信息错误！", e);
			throw new BaseException("查看数码照片类别明细信息错误！", e);
		}
		return DETAIL;
		
	}
	
	/**
	 * 提交数码照片类别信息
	 * @return
	 * @throws BaseException 
	 */
	public String submitPhotoKind() throws BaseException {
		
		try{
//			this.photoKindBiz.submitSubjects( subjects  );
		} catch (Exception e) {
			log("提交数码照片类别信息错误！", e);
			throw new BaseException("提交数码照片类别信息错误！", e);
		}
		return SUBMIT;
		
	}

	public IPhotoKindBiz getPhotoKindBiz() {
		return photoKindBiz;
	}

	public void setPhotoKindBiz(IPhotoKindBiz photoKindBiz) {
		this.photoKindBiz = photoKindBiz;
	}

	public PhotoKind getPhotoKind() {
		return photoKind;
	}

	public void setPhotoKind(PhotoKind photoKind) {
		this.photoKind = photoKind;
	}

	public String getTree() {
		return tree;
	}

	public void setTree(String tree) {
		this.tree = tree;
	}

	
	
}
