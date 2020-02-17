package com.by.hctm.common.action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;

import com.by.base.action.BaseAction;
import com.by.base.exception.BaseException;
import com.by.hctm.common.utils.DateUtil;
import com.by.hctm.common.utils.FtpUtil;
import com.by.hctm.common.utils.GlobalSetting;

/**
 * @author ted 上传附件的action。 上传的目录结构为：2004\\09\\contract_<%=contractId%>
 */
public class WebTraceAction extends BaseAction {
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	// private static final int MaxMemorySize = 1024 * 1024 * 10;
	private static final int MaxMemorySize = 1024 * 16;

	private static final int MaxRequestSize = 1024 * 1024 * 10;

	// Process the HTTP Post request
	public void uploadTemplate( ) throws BaseException {
		try {
			this.getResponse().setContentType(CONTENT_TYPE);
			PrintWriter out = this.getResponse().getWriter();
			FtpUtil ftpUtil = new FtpUtil();
			
			/*
			 * String encoding = request.getCharacterEncoding(); encoding =
			 * encoding== null ? "GBK" :encoding; InputStreamReader isr = new
			 * InputStreamReader( request.getInputStream(),encoding); char[]
			 * chbuf = new char[4096]; for( int count=0; ( count = isr.read(
			 * chbuf)) != -1 ; ) { System.out.println(new String(chbuf)); }
			 */
			DiskFileUpload upload = new DiskFileUpload();

			// Set upload parameters
			upload.setSizeThreshold(MaxMemorySize);
			upload.setSizeMax(MaxRequestSize);
			String temppath = System.getProperty("java.io.tmpdir");

			upload.setRepositoryPath(temppath);

			String docpath = "";
			// Parse the request FileItem
			List items = upload.parseRequest( this.getRequest() );
			Iterator iter = items.iterator();

			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString();
				} else {

					/** 登录人的姓名
					 * 注:初始化时还没有登录时，不填写编制人
					 */
					String sLoginName = null;
					String sChineseName = null;
					if (this.getSession().getAttribute("loginName") != null
							&& this.getSession().getAttribute("loginName").toString().length() > 0) {
						sLoginName = (String) this.getSession().getAttribute("loginName");
						sChineseName = "";
					}

					String filename = item.getName();
					// 获取主键（根据附件名称）
					int index = filename.lastIndexOf("_");
					int indexDot = filename.lastIndexOf(".");
					String id = filename.substring(index + 1, indexDot);

					int i;
					i = filename.lastIndexOf('\\');
					filename = filename.substring(i + 1);
					filename.replace(':', '_');

					filename.replace('\\', '_');
					log.info("this is upload:" + filename);

					// 如果文件名是以@-@开头，则不上传
					if (filename.startsWith("@-@")) {
						log.info(filename + "不需要上传!");
						return;
					}

					// 获取访问参数，决定上传的是合同还是招标文件
					String type = this.getRequest().getParameter("type");
					if (type == null || type.equals("")) {
						throw new ServletException("请检查调用当前servlet的url的参数type！");
					}
					
					// -----------------------------------------------------------------------------
					// 默认是合同服务，提供合同上传

//					if (type.equals(GlobalSetting.contractType)) {
					if (type.equals("0")) {	
						// 获取合同信息
//						ContractManager manager = MmsFactory.getInstance()
//								.getPurchaseFactory().getContractManager();
//						// 查询合同，session在查询完后就关闭
//						Contracts contract = (Contracts) dao.load(Contracts.class, new Long(id), true);

						// GlobalSetting.getRealContractUploadLocation();
						docpath = GlobalSetting.getContractUploadLoaction();

//						String dir = docpath + DateUtil.getDirectoryByDate(contract
//										.getWriteDate());
						String dir = docpath + DateUtil.getDirectoryByDate( new Date() );
						
						log.info("this is upload:" + filename);
						

						ftpUtil.upload(dir, item.getInputStream(), filename, false);
						
						// -----------更新合同信息，将合同名称写入到数据酷中，如果合同中有合同文本名称，则表明合同文本已生成-------------------------------------------------------
//						String contractWordName = manager.getContractWordFileName(contract);
//						contract.setContractFileName(contractWordName);
//						dao.update(contract, true);

					}
					// -------------------------------------------------------------------------------------

				}
			}

		} catch (Exception ex) {
			log.error("用户登陆校验错误！", ex);
			throw new BaseException("用户登陆校验错误！", ex);
		}
	}
 
}