package com.by.base.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import net.sf.jftp.net.BasicConnection;
import net.sf.jftp.net.ConnectionListener;
import net.sf.jftp.net.FtpConnection;
import net.sf.jftp.net.FtpConstants;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FtpUtilBase implements ConnectionListener {

	private boolean isThere = false;

	private FtpConnection ftpConn = null;

	private static final Log logger = LogFactory.getLog(FtpUtilBase.class);

	/**
	 * 连接文件服务�?
	 */
	public void connectServer() {
		try {
			ftpConn = new FtpConnection( GlobalSettingBase.getAttachdmentPlacedFtpAddress(), 
					Integer.parseInt( GlobalSettingBase.getAttachdmentPlacedFtpAddressPort() ), null );
			
			ftpConn.addConnectionListener(this);

			ftpConn.login(GlobalSettingBase.getFileServerFtpUser(), GlobalSettingBase
					.getFileServerFtpPassword());

			ftpConn.binary();

			while (!isThere) {
				try {
					Thread.sleep(10);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			
			logger.info("login success");
		} catch (Exception ex) {
			logger.error(ex);
		}
	}
	 
	/**
	 * 关闭文件服务器连�?
	 */
	public void closeConnect() {
		try {
			ftpConn.disconnect();

		} catch (Exception ex) {
			logger.error("logout fail！：" + ex);
		}
	}
	
	/**
	 * 实现文件的FTP上传
	 * 
	 * @param vsUpLoadPath
	 *            //上传的路�?
	 * @param vsLocalPathAndFileName
	 *            //本地路径和文件名
	 * @param vsaFileName
	 *            //上传的文件名
	 * @return String //返回实际采用的上传文件名
	 * @author ted 2005-11-1
	 * @throws Exception
	 */
	public String upload(String vsUpLoadPath, String vsLocalPathAndFileName,
			String vsaFileName, boolean reName) throws Exception {
		String sUpLoadFileName = null;

		try {
			// 连接服务�?
			this.connectServer();

			// 文件上传
			sUpLoadFileName = this.uploadfile(vsUpLoadPath,
					vsLocalPathAndFileName, vsaFileName, reName);

			// 关闭连接
			this.closeConnect();

		} catch (IOException ex) {
			logger.error(ex);
			throw ex;
		}
		return sUpLoadFileName;
	}

	/**
	 * 实现文件的FTP上传
	 * 
	 * @param vsUpLoadPath
	 *            //上传的路�?
	 * @param is
	 *            //上传文件�?
	 * @param vsaFileName
	 *            //上传的文件名
	 * @author ted 2005-11-01
	 * @return
	 * @throws Exception
	 */
	public String upload(String vsUpLoadPath, InputStream is,
			String vsaFileName, boolean reName) throws Exception {
		String sUpLoadFileName = null;

		try {
			// 连接服务�?
			this.connectServer();

			// 文件上传
			sUpLoadFileName = this.uploadfile(vsUpLoadPath, is, vsaFileName,
					reName);

			// 关闭连接
			this.closeConnect();

		} catch (IOException ex) {
			logger.error(ex);
			throw ex;
		}
		return sUpLoadFileName;
	}

	/**
	 * 实现文件上传的部分，不包括创�?释放连接的功�?
	 * 
	 * @param vsUpLoadPath
	 *            //上传的路�?
	 * @param vsLocalPathAndFileName
	 *            //本地路径和文件名
	 * @param vsaFileName
	 *            //上传的文件名
	 * @return String //返回实际采用的上传文件名
	 * @throws IOException 异常处理
	 * @author ted 2005-11-1
	 */
	private String uploadfile(String vsUpLoadPath,
			String vsLocalPathAndFileName, String vsaFileName, boolean reName)
			throws IOException {
		java.io.File file_in = new java.io.File(vsLocalPathAndFileName); // 本地的路�?

		InputStream is = new FileInputStream(file_in);
		return uploadfile(vsUpLoadPath, is, vsaFileName, reName);
	}

	/**
	 * 实现文件上传的部分，不包括创�?释放连接的功�?
	 * 
	 * @param vsUpLoadPath
	 *            //上传的路�?
	 * @param is
	 *            //上传文件�?
	 * @param vsaFileName
	 *            //上传的文件名
	 * @param reName
	 *            是否从命�?
	 * @return String //返回实际采用的上传文件名
	 * @throws IOException
	 *             异常处理
	 * @author ted 2005-11-01
	 * @throws IOException
	 */
	public String uploadfile(String vsUpLoadPath, InputStream is,
			String vsaFileName, boolean reName) throws IOException {

		String sUpLoadFileName = "";
		// 创建目录
		try {
			makeWorkingDirectory(vsUpLoadPath);

			if (reName) {
				// 判断文件是否存在
				if (!ftpConn.rename(vsaFileName, vsaFileName)) {

					logger.debug("File is not found! -- " + vsaFileName);
				} else {
					sUpLoadFileName = "Copy of ";

					logger.debug("File is found !!!!!!!!!! -- " + vsaFileName);
				}
			}
			// 上传到文件服务器上的名称
			sUpLoadFileName += vsaFileName;

			// 上传文件
			logger.info("start to upload file !!!!!!!!!!!!");
			ftpConn.binary();
			ftpConn.upload(sUpLoadFileName, is);
			is.close();
		} catch (IOException e) {
			logger.error("upload file error!" + e);
			throw e;

		}
		return sUpLoadFileName;
	}
	
    /**
     * 
     * @param is
     * @param vsaFileName
     * @param reName
     * @return
     * @throws IOException
     */
	public String uploadfile(InputStream is, String vsaFileName, boolean reName)
			throws IOException {

		String sUpLoadFileName = "";
		
		try {

			if (reName) {
				// 判断文件是否存在
				if (!ftpConn.rename(vsaFileName, vsaFileName)) {

					logger.debug("File is not found! -- " + vsaFileName);
				} else {
					sUpLoadFileName = "Copy of ";

					logger.debug("File is found !!!!!!!!!! -- " + vsaFileName);
				}
			}
			// 上传到文件服务器上的名称
			sUpLoadFileName += vsaFileName;

			// 上传文件
			logger.info("start to upload file !!!!!!!!!!!!");
			ftpConn.binary();
			ftpConn.upload(sUpLoadFileName, is);
			is.close();
		} catch (IOException e) {
			logger.error("upload file error!" + e);
			throw e;

		}
		return sUpLoadFileName;
	}

	/**
	 * 创建目录
	 * 
	 * @param vsUpLoadPath
	 * @throws IOException
	 */
	public void makeWorkingDirectory(String vsUpLoadPath) throws IOException {
		String path[] = convertUpLoadPath(vsUpLoadPath);
		for (int i = 0; i < path.length; i++) {
			String currentDir = path[i];
			if (!currentDir.equals("")) {
				// 判断目录是否存在

				// 判断路径是否创建成功

				if (!ftpConn.chdir(currentDir)) {
					logger.debug("Not Found Directory!!!!");

					// 创建目录
					boolean createDir = ftpConn.mkdir(currentDir);
					if (createDir) {
						logger.info("create dir " + currentDir + "success");
						logger.info("set working dir " + currentDir);
						boolean setWorkingDir = ftpConn.chdir(currentDir);
						if (setWorkingDir) {
							logger.info("set working dir " + currentDir
									+ "success");

						}

					}
				} else {
					logger.debug("Found Directory!!!!");
				}

			}

		}

	}

	// ----------------------------下载--------------------------------------
	/**
	 * 下载时首先进入到文件�?��目录
	 * 
	 * @author ted
	 * @param vsUpLoadPath
	 *            //文件�?��路径
	 */
	private void changeWorkingDirectory(String vsUpLoadPath) throws IOException {
		String path[] = convertUpLoadPath(vsUpLoadPath);
		// 重置路径

		for (int i = 0; i < path.length; i++) {
			String currentDir = path[i];
			if (!currentDir.equals("")) {
				// 判断目录是否存在

				if (!ftpConn.chdir(currentDir)) {
					// 目录不存�?
					logger.debug("Not Found Directory!!!!");
					return;
				} else {
					logger.debug("Found Directory!!!!");
				}
			}
		}
	}
 
	/**
	 * 下载服务,向输出流写从ftp服务器获取的流默认不指定下载文件名，
	 * 
	 * @param vsUpLoadPath
	 * @param vsaFileName
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public boolean download(String vsUpLoadPath, String vsaFileName,
			HttpServletResponse response) throws IOException {
		return download(vsUpLoadPath, vsaFileName, null, response);
	}

	/**
	 * 下载服务,向输出流写从ftp服务器获取的�?
	 * 
	 * @param vsUpLoadPath
	 *            //文件�?��路径
	 * @param vsaFileName
	 *            //文件�?
	 * @param saveAsFileName
	 *            //下载时指定的文件�?
	 * @param response
	 * @return
	 * @author ted
	 * @throws IOException
	 */
	public boolean download(String vsUpLoadPath, String vsaFileName,
			String saveAsFileName, HttpServletResponse response)
			throws IOException {
		boolean result = false;
		try {
			// 连接服务�?
			this.connectServer();
			ftpConn.binary();
			changeWorkingDirectory(vsUpLoadPath);
			// 判断当前目录文件是否存在
			if (!ftpConn.rename(vsaFileName, vsaFileName)) {
				// 文件不存�?
				logger.debug("File is not found! -- " + vsaFileName);
			} else {
				String isoFilename = "";
				response.setContentType("application/x-msdownload");
				// 当需要指定下载文件名称时使用
				if (!StringUtil.isBlank(saveAsFileName)) {

					isoFilename = saveAsFileName;
				} else {
					isoFilename = vsaFileName;
				}

				response.addHeader("Content-Disposition",
						"attachment; filename=\""
								+ StringUtil.getISO(isoFilename) + "\"");

				response.setHeader("Accept-ranges", "bytes");

				OutputStream os = ((HttpServletResponse) response)
						.getOutputStream();
				InputStream is = ftpConn.getDownloadInputStream(vsaFileName);
				// FileOutputStream fos=new FileOutputStream("c:\\xx.doc");

				byte[] bytes = new byte[1024];
				int c;
				while ((c = is.read(bytes)) != -1) {
					os.write(bytes, 0, c);
					// fos.write(bytes, 0, c);
				}
				is.close();
				os.close();
				// fos.close();
				// Ted 2008-01-19 
				result = true ;
			}

			// 关闭连接
			this.closeConnect();
		} catch (IOException e) {
			logger.error("下载失败");
		}
		return result;
	}
	
	/**
	 * 删除服务器上的文�?
	 * 
	 * @author ted 2005-11-02
	 * @param vsUpLoadPath
	 * @param vsaFileName
	 * @return
	 */
	public boolean deleteFile(String vsUpLoadPath, String vsaFileName) {
		boolean result = false;
		try {

			// 连接服务�?
			this.connectServer();
			ftpConn.binary();
			changeWorkingDirectory(vsUpLoadPath);
			// 判断当前目录文件是否存在
			if (!ftpConn.rename(vsaFileName, vsaFileName)) {
				// 文件不存�?
				logger.debug("File is not found! -- " + vsaFileName);

			} else {

				result = FtpConstants.REMOVE_SUCCESSFUL == ftpConn
						.removeFileOrDir(vsaFileName);

			}

			// 关闭连接
			this.closeConnect();
		} catch (IOException e) {
			logger.error("删除附件错误");
		}
		return result;
	}

	/**
	 * 处理上传路径
	 * 
	 * @param vsUpLoadPath
	 * @return 返回路径数组
	 */
	private String[] convertUpLoadPath(String vsUpLoadPath) {
		vsUpLoadPath = StringUtil.replace(vsUpLoadPath, File.separator, "/");
		vsUpLoadPath = StringUtil.replace(vsUpLoadPath, "//", "/");

		if (vsUpLoadPath.charAt(0) == '/') {
			vsUpLoadPath = vsUpLoadPath.substring(1);
		}
		if (vsUpLoadPath.endsWith("/")) {
			vsUpLoadPath = vsUpLoadPath.substring(0, vsUpLoadPath.length() - 1);

		}
		return vsUpLoadPath.split("/");
	}

	public void updateRemoteDirectory(BasicConnection con) {
		logger.info("new path is: " + con.getPWD());
	}

	public void connectionInitialized(BasicConnection con) {
		isThere = true;
	}

	public void updateProgress(String file, String type, long bytes) {
	}

	public void connectionFailed(BasicConnection con, String why) {
		logger.info("connection failed!");
	}

	public void actionFinished(BasicConnection con) {
	}

	public static String getFileExtendName(String oriFileName) {
		if (StringUtil.isBlank(oriFileName)) {
			return "file.file";

		}
		String extendName = "";
		int index = oriFileName.lastIndexOf(".");
		if (index > -1) {
			extendName = oriFileName.substring(index);

		}
		return extendName;
	}
 
	/**
	 * 下载服务,取得从ftp服务器获取的�?
	 * @param vsUpLoadPath  //文件�?��路径
	 * @param vsaFileName //文件�?
	 * @param response
	 * @author ted add  2008-11-17
	 * @return
	 */
	public InputStream downloadMFSBidPricesFiles(String vsUpLoadPath, String vsaFileName )
			 {
		InputStream is = null ;
		try {
			// 判断当前目录文件是否存在
			changeWorkingDirectory(vsUpLoadPath);
			if (!ftpConn.rename(vsaFileName, vsaFileName)) {
				// 文件不存�?
				logger.debug("File is not found! -- " + vsaFileName);
			} else {
				is = ftpConn.getDownloadInputStream( vsaFileName );
			}
		} catch (IOException e) {
			logger.error("下载流失败！", e);
		} catch( Exception ex){
			logger.error("FTP服务器未连接�?", ex ) ;
		}
		return is;
	}
	
	public FtpConnection getFtpConn() {
		return ftpConn;
	}

	public void setFtpConn(FtpConnection ftpConn) {
		this.ftpConn = ftpConn;
	}
	
}
