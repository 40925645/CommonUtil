package com.stepsoft.common.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * 应用程序日志文件类，用于记录日志文件，目前使用slf4j来记录日志。<br />
 * 请在samplelogger.properties文件中设置日志信息。
 * 
 * @author sam
 *
 */
public class AppLogger {

	public static void debug(Class<?> clazz, String message) {
		Logger logger = LoggerFactory.getLogger(clazz);
		logger.debug(message);
	}

	public static void info(Class<?> clazz, String message) {
		Logger logger = LoggerFactory.getLogger(clazz);
		logger.info(message);
	}

	public static void error(Class<?> clazz, String message) {
		Logger logger = LoggerFactory.getLogger(clazz);
		logger.error(message);
	}

	public static void trace(Class<?> clazz, String message) {
		Logger logger = LoggerFactory.getLogger(clazz);
		logger.trace(message);
	}

	public static void warn(Class<?> clazz, String message) {
		Logger logger = LoggerFactory.getLogger(clazz);
		logger.warn(message);
	}
}
