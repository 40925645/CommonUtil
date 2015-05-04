package com.stepsoft.common.configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 属性文件工具类，用于加载属性文件，并读取相关属性。
 *
 */
public class PropertiesUtil {
	public final static Map<String, Properties> PROPERTIES_MAP = new HashMap<String, Properties>();

	/***
	 * 加载.properties属性文件，并将属性文件添加到缓存中。
	 * 
	 * @param name
	 *            ，属性文件名称
	 * @param propPath
	 *            ，文件路径
	 * @return 属性文件
	 */
	public synchronized static Properties loadFromProp(String name, String propPath) {
		return load(name, propPath, PropertiesFileType.PROP);
	}

	/***
	 * 加载xml属性文件，并将属性文件添加到缓存中。
	 * 
	 * @param name
	 *            ，属性文件名称
	 * @param xmlPath
	 *            ，文件路径
	 * @return 属性文件
	 */
	public synchronized static Properties loadFromXml(String name, String xmlPath) {
		return load(name, xmlPath, PropertiesFileType.XML);
	}

	/***
	 * 
	 * @param name
	 *            ，属性文件名称
	 * @param path
	 *            ，文件路径
	 * @param type
	 *            ，文件类型
	 * @return 属性文件
	 */
	private static Properties load(String name, String path, String type) {
		// 从缓存读取
		Properties properties = PROPERTIES_MAP.get(name);
		if (properties != null) {
			return properties;
		}

		// 加载属性文件
		properties = new Properties();
		try {
			if (type.equals(PropertiesFileType.PROP)) {
				properties.load(PropertiesUtil.class.getResourceAsStream(path));
			} else if (type.equals(PropertiesFileType.XML)) {
				properties.loadFromXML(PropertiesUtil.class.getResourceAsStream(path));
			}
			PROPERTIES_MAP.put(name, properties);
			return properties;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/***
	 * 根据名称获取属性文件
	 * 
	 * @param name
	 *            ，属性文件名称
	 * @return
	 */
	public static Properties getProperties(String name) {
		Properties properties = PROPERTIES_MAP.get(name);
		return properties;
	}

	/***
	 * 根据名称和关键字获取属性值
	 * 
	 * @param name
	 *            ，属性文件名称
	 * @param key
	 *            ，关键字
	 * @return
	 */
	public static String getValue(String name, String key) {
		Properties properties = PROPERTIES_MAP.get(name);
		return properties.getProperty(key, "");
	}

	/***
	 * 属性文件类型
	 * 
	 * @author sam
	 *
	 */
	static class PropertiesFileType {
		public static final String XML = "XML";
		public static final String PROP = "PROP";

	}
}
