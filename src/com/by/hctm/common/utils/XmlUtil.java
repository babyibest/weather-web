/**
 * 
 */
package com.by.hctm.common.utils;

import java.io.File;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.hibernate.HibernateException;

import freemarker.core.Environment;
/**
 * @author ted
 *
 */
public class XmlUtil {
	
	/**
	 * Logger for this class
	 */
	private static final Log log = LogFactory.getLog(XmlUtil.class);
	
	/**
	 * 读取xml返回document。
	 * @param path
	 * @return  liuqing
	 * @throws DocumentException
	 */
	public static Document parse(File path) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(path);
        return document;
    }
	/**
	 * 
	 * @param is
	 * @return
	 * @throws DocumentException
	 */
	public static Document parse(InputStream is) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(is);
        return document;
    }
	
	/**
	 * 
	 * @param is
	 * @return
	 * @throws DocumentException
	 */
	public static Document parse(String resource) throws DocumentException {
		InputStream stream = null;
		Document document = null;
		
		try {
			stream = getConfigurationInputStream(resource);
			SAXReader reader = new SAXReader();
		    document = reader.read(stream);
		} catch (HibernateException e) {
			log.info("DB Configuration resource: " + e.getMessage() );
			e.printStackTrace();
		}
       
        return document;
    }
	
	/**
	 * Get the configuration file as an <tt>InputStream</tt>. Might be overridden
	 * by subclasses to allow the configuration to be located by some arbitrary
	 * mechanism.
	 */
	public static InputStream getConfigurationInputStream(String resource) throws HibernateException {

		log.info("Configuration resource: " + resource);

		InputStream stream = Environment.class.getResourceAsStream(resource);
		if (stream==null) {
			log.warn(resource + " not found");
			throw new HibernateException(resource + " not found");
		}
		return stream;

	}

}
