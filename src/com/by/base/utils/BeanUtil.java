package com.by.base.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//import org.apache.commons.beanutils.BeanUtils;
//
//import com.wellsoon.base.web.form.BaseForm;

public class BeanUtil {

	/**
	 * 得到fields的属�?
	 * 
	 * @param Class
	 *            objClass 当前对象的Class对象
	 * @return Map 对象属�?地图(属�?名称，属性类�?
	 */
	public static Map getFilds(Class objClass) {
		Map map = null;
		try {
			// 得到�?��的属�?
			Field[] fields = objClass.getDeclaredFields();
			int size = fields.length;
			if (size > 0) {
				map = new HashMap();
				for (int i = 0; i < size; i++) {
					map.put(fields[i].getName(), fields[i].getType());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 对首字母进行专大�?
	 */
	public static String upFirstChar(String str) {
		String first = (str.substring(0, 1)).toUpperCase();
		String other = str.substring(1);
		return first + other;
	}

	/**
	 * 得到�?��Method对照Map
	 * 
	 * @param Class
	 *            objClass 当前对象的Class对象
	 * @return Map 对象方法地图(方法名，方法)
	 */
	public static Map getMethods(Class objClass) {
		Map map = null;
		try {
			// 得到�?��的方�?
			Method[] methods = objClass.getDeclaredMethods();
			int size = methods.length;
			if (size > 0) {
				map = new HashMap();
				for (int i = 0; i < size; i++) {
					map.put(methods[i].getName(), methods[i]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 通过Map生成Pojo
	 * 
	 * @param objClass
	 * @param map
	 * @return
	 */
	public static Object convertObject(Class objClass, Map map) {
//		try {
//			Class cla = Class.forName(objClass.getName());
//			Object obj = cla.newInstance();
//			BeanUtils.populate(obj, map);
//			return obj;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return null;
	}

	  
//	public static Object convertObject(Class objClass, Object obj1) {
//		try {
//			Class cla = Class.forName(objClass.getName());
//			Object obj = cla.newInstance();
//			BeanUtils.copyProperties(obj, obj1);
//			return obj;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	public static Object convertObject(Class objClass, BaseForm baseForm) {
//		// 属�?的名称及类型
//		Map fileds = getFilds(objClass);
//		// 方法名称及方�?
//		Map methods = getMethods(objClass);
//		// 返回类型及方�?
//		Map returns = getMethodsReturn(baseForm.getClass());
//
//		try {
//			Class cla = Class.forName(objClass.getName());
//			Object obj = cla.newInstance();
//
//			for (Iterator it = fileds.entrySet().iterator(); it.hasNext();) {
//				Map.Entry entry = (Map.Entry) it.next();
//
//				// 属�?名称
//				String filed = (String) entry.getKey();
//				// 属�?类型
//				Class type = (Class) (entry.getValue());
//
//				// 转换成SET方法(首字母大�?
//				StringBuffer sub = new StringBuffer("set");
//				sub.append(upFirstChar(filed));
//				// SET方法名称
//				String setFiled = sub.toString();
//				// 获取SET方法
//				Method setMethod = (Method) methods.get(setFiled);
//
//				if (setMethod != null) {
//					// 根据类型找出对应的方�?
//					Method rMethod = (Method) returns.get(type);
//					if (rMethod != null) {
//						// 从baseForm中取出对应的�?
//						Object temp = rMethod.invoke(baseForm,
//								new String[] { filed });
//						// 注入到对象中相应的属�?
//						setMethod.invoke(obj, new Object[] { temp != null
//								&& !temp.equals("") ? temp : null });
//					}
//				}
//
//			}
//			return obj;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return null;
//	}

	/**
	 * 得到�?��Method及返回�?对照Map
	 * 
	 * @param Class
	 *            objClass 当前对象的Class对象
	 * @return Map 对象方法地图(返回类型,方法)
	 */
	public static Map getMethodsReturn(Class objClass) {
		Map map = null;
		try {
			// 得到�?��的方�?
			Method[] methods = objClass.getDeclaredMethods();
			int size = methods.length;
			if (size > 0) {
				map = new HashMap();
				for (int i = 0; i < size; i++) {
					map.put(methods[i].getReturnType(), methods[i]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 将对象的属�?转换成为对象相应方法的名�?转换在get方法名，类型)
	 */
	public static Map getFildsToSetName(Class objClass) {
		Map maps = null;
		Map map = getFilds(objClass);
		if (map != null) {
			maps = new HashMap();
			for (Iterator it = map.entrySet().iterator(); it.hasNext();) {
				Map.Entry entry = (Map.Entry) it.next();
				StringBuffer sub = new StringBuffer("set");
				String str = (String) entry.getKey();
				str = upFirstChar(str);
				sub.append(str);
				maps.put(sub.toString(), entry.getValue());
			}
		}
		return maps;
	}
}
