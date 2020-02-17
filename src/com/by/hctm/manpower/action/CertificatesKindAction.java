package com.by.hctm.manpower.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.utils.StringUtil;
import com.by.hctm.manpower.biz.ICertificatesKindBiz;
import com.by.hctm.manpower.entity.CertificatesKind;

public class CertificatesKindAction extends BaseAction {
	// 人员资质树 服务类
	private ICertificatesKindBiz certificatesKindBiz  ;
	// 人员资质树 实例
	private CertificatesKind certificatesKind ;
	private String tree;
	
	/**
	 * 人员资质树index
	 * 定向页面
	 * 谢磊
	 * */
	
	public String CertificatesKindIndex(){
		
		return INDEX;
	}
	
	
	/**
	 * 查看标准类别信息表初始树列表 getTree
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewCertificatesKindInitTree() throws BaseException {
		
		try{
			Long id;
			List certList = new ArrayList() ;
			String name = "";
			
			// 初始父ID为零
			if(StringUtil.isNotBlank(certificatesKind) && StringUtil.isNotBlank(certificatesKind.getCertKindParentId())){
				certList = this.certificatesKindBiz.getCertificatesKindList(certificatesKind);
				System.out.println(certList.size());
			}else{
				CertificatesKind certKind = new CertificatesKind();
				certKind.setCertKindParentId(new Long(0));
				certList = this.certificatesKindBiz.getCertificatesKindList(certKind);
				System.out.println(certList.size());
			
			}
				if(StringUtil.isNotBlank(certList)){
				
			
			
			StringBuffer script = new StringBuffer();
			script.append("var tree = new WebFXTree(\"人员资质类别树\");\n");
			Iterator it=	certList.iterator();
			
			while (it.hasNext()) {
				CertificatesKind	certKind=(CertificatesKind)it.next();
				id = certKind.getCertKindId();
				name = StringEscapeUtils.escapeXml(certKind.getCertKindName().trim());
				
				
				// 判断是否有子节点
				if ("0".equals( certKind.getIsHaveChild() )) {
					script.append("tree.add( rti = new WebFXLoadTreeItem(\"" + name + "\", \"viewCertificatesKindTree_CertificatesKind.action?certificatesKind.certKindParentId=" + id + "\",\"javascript:folderview('" + id + "')\"));\n");
				} else {
					script.append("tree.add( new WebFXTreeItem(\"" + name + "\",\"javascript:folderview('" + id + "')\"));\n");
				}
			}
			
			script.append("document.write(tree);\n");
			script.append("tree.expand();\n"); 

			tree = script.toString() ;
				}

		} catch (Exception e) {
			log("查看标准类别信息表初始树列表错误！", e);
			throw new BaseException("查看标准类别信息表初始树列表错误！", e);
		}
		
		return TREE ;
	}
	
	/**
	 * 查看标准类别信息表树列表 
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	
	public void viewCertificatesKindTree() throws BaseException {
		
		try{
			Long id;
			String name = "";
			
			List certList = this.certificatesKindBiz.getCertificatesKindList(certificatesKind);

			StringBuffer script = new StringBuffer();
			script.append("<?xml version=\"1.0\"?>");
			script.append("<tree>");
			Iterator it=certList.iterator();
			while (it.hasNext()) {
				CertificatesKind certificatesKind = (CertificatesKind) it.next() ;
				id 		= certificatesKind.getCertKindId() ;
				name 	= StringEscapeUtils.escapeXml(certificatesKind.getCertKindName().trim());
				
				script.append("<tree text=\"" + name + "\" id=\"" + id + "\" action=\"javascript:folderview('" + id + "')\" ");
				// 判断是否有子节点
				if ( "0".equals( certificatesKind.getIsHaveChild() ) ) {
					script.append(" src=\"viewCertificatesKindTree_CertificatesKind.action?certificatesKind.certKindParentId=").append(id).append("\" ");
				}
				
				script.append("/>");
				
			}
			
			script.append("</tree>");
			
			getResponse().getWriter().println(script.toString());
			
		} catch (Exception e) {
			log("查看标准类别信息表初始树列表错误！", e);
			throw new BaseException("查看标准类别信息表初始树列表错误！", e);
		}
		
//		return null ;
	}
	
	/**
	 * 查看人员资质树信息列表
	 * @return
	 * @throws BaseException 
	 * @Action
	 */
	public String viewCertificatesKind() throws BaseException {
		
		try{
			// 人员资质树 列表信息
			this.setListValue( this.certificatesKindBiz.getCertificatesKindList( this.getRollPage(), certificatesKind ) ) ;
		} catch (Exception e) {
			log.error("查看人员资质树信息列表错误！", e);
			throw new BaseException("查看人员资质树信息列表错误！", e);
		}
		
		return VIEW ;
		
	}
	
	/**
	 * 保存人员资质树信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String saveCertificatesKindInit() throws BaseException {
		try{
			this.getRequest().setAttribute("cert",  this.certificatesKindBiz.getCertificatesKind(certificatesKind.getCertKindId()) );
		} catch (Exception e) {
			log("保存人员资质树信息初始化错误！", e);
			throw new BaseException("保存人员资质树信息初始化错误！", e);
		}
		return ADD_INIT;
		
	}
	
	/**
	 * 保存人员资质树信息
	 * @return
	 * @throws BaseException 
	 */
	public String saveCertificatesKind() throws BaseException {
		
		try{
			// 保存人员资质树信息
			this.certificatesKindBiz.saveCertificatesKind( certificatesKind );
			CertificatesKind cd =  new CertificatesKind();
			cd = this.certificatesKindBiz.getCertificatesKind(certificatesKind.getCertKindParentId());
			cd.setIsHaveChild("0");
			this.certificatesKindBiz.updateCertificatesKind(cd);
			this.message("保存成功");
		} catch (Exception e) {
			log("保存人员资质树信息错误！", e);
			throw new BaseException("保存人员资质树信息错误！", e);
		}
		
		return ADD;
		
	}
	
	/**
	 * 修改人员资质树信息初始化
	 * @return
	 * @throws BaseException 
	 */
	public String updateCertificatesKindInit() throws BaseException {
		
		try{
			// 取得人员资质树信息
			certificatesKind=this.certificatesKindBiz.getCertificatesKind( certificatesKind.getCertKindId() );
			

			
		} catch (Exception e) {
			log("修改人员资质树信息初始化错误！", e);
			throw new BaseException("修改人员资质树信息初始化错误！", e);
		}
		return MODIFY_INIT;
		
	}
	
	/**
	 * 修改人员资质树信息
	 * @return
	 * @throws BaseException 
	 */
	public String updateCertificatesKind() throws BaseException {
		
		try{
			// 修改人员资质树信息
			this.certificatesKindBiz.updateCertificatesKind( certificatesKind );
			this.message("修改成功");
		} catch (Exception e) {
			log("修改人员资质树信息错误！", e);
			throw new BaseException("修改人员资质树信息错误！", e);
		}
		return MODIFY;
		
	}
	
	/**
	 * 删除人员资质树信息
	 * @return
	 * @throws BaseException 
	 */
	public String deleteCertificatesKind() throws BaseException {
		try{
			// 删除人员资质树信息
			CertificatesKind ck = new CertificatesKind();
			ck.setCertKindParentId(certificatesKind.getCertKindId());
			List si=this.certificatesKindBiz.getCertificatesKindList(ck);
			if(si.size()== 0){
				CertificatesKind pk = new CertificatesKind();
				pk.setCertKindParentId(this.certificatesKindBiz.getCertificatesKind(certificatesKind.getCertKindId()).getCertKindParentId());
				List cpt=this.certificatesKindBiz.getCertificatesKindList(pk);
				if(cpt.size()<=1){
					CertificatesKind cd = new CertificatesKind();
					cd = this.certificatesKindBiz.getCertificatesKind(ck.getCertKindParentId());
					CertificatesKind cf = new CertificatesKind();
					cf=this.certificatesKindBiz.getCertificatesKind(cd.getCertKindParentId());
					cf.setIsHaveChild("1");
					this.certificatesKindBiz.updateCertificatesKind(cf);
				}
				
				System.out.println(certificatesKind.getCertKindId());
				this.certificatesKindBiz.deleteCertificatesKind( certificatesKind.getCertKindId().toString()  );
				this.message("删除成功");
				
			}else{
				
				System.out.println("有子节点，不能删除");
			}
			
		} catch (Exception e) {
			log("删除人员资质树信息错误！", e);
			throw new BaseException("删除人员资质树信息错误！", e);
		}
		return DELETE;
		
	}
	
	/**
	 * 查看人员资质树明细信息
	 * @return
	 * @throws BaseException 
	 */
	public String viewCertificatesKindDetail() throws BaseException {
		
		try{
			// 取人员资质树信息
			certificatesKind=this.certificatesKindBiz.getCertificatesKind( certificatesKind.getCertKindId() );
		} catch (Exception e) {
			log("查看人员资质树明细信息错误！", e);
			throw new BaseException("查看人员资质树明细信息错误！", e);
		}
		return DETAIL;
		
	}
	
	/**
	 * 提交人员资质树信息
	 * @return
	 * @throws BaseException 
	 */
	public String submitCertificatesKind() throws BaseException {
		
		try{
//			this.certificatesKindBiz.submitSubjects( subjects  );
		} catch (Exception e) {
			log("提交人员资质树信息错误！", e);
			throw new BaseException("提交人员资质树信息错误！", e);
		}
		return SUBMIT;
		
	}
	
	private  void message(String str) throws IOException{
		this.getResponse().setContentType("text/html; charset=UTF-8"); //转码
	    PrintWriter out = this.getResponse().getWriter();
	    out.flush();
	    out.println("<script>");
	    out.println("alert('"+str+"!');");
	    out.println("parent.location.reload();");
	    out.println("</script>");
	}

	public ICertificatesKindBiz getCertificatesKindBiz() {
		return certificatesKindBiz;
	}

	public void setCertificatesKindBiz(ICertificatesKindBiz certificatesKindBiz) {
		this.certificatesKindBiz = certificatesKindBiz;
	}

	public CertificatesKind getCertificatesKind() {
		return certificatesKind;
	}

	public void setCertificatesKind(CertificatesKind certificatesKind) {
		this.certificatesKind = certificatesKind;
	}


	public String getTree() {
		return tree;
	}


	public void setTree(String tree) {
		this.tree = tree;
	}

	
	
}
