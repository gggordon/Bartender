package com.caribresort.logging;

import org.apache.log4j.Logger;

/**
 * <h4>Logger</h4>
 * <p>Default Logger that will be used by application</p>
 * <p>Will include an instance of logger and implement main functions</p>
 * */

public class DefaultLogger {

	private static Logger logger = Logger.getLogger(DefaultLogger.class);

	public static void info(Object message){
		logger.info(message);
	}

	public static void fatal(Object message){
		logger.fatal(message);
	} 

	public static void warn(Object message){
		logger.warn(message);
	}

	public static void debug(Object message){
		logger.debug(message);
	}

	public static void error(Object message){
		logger.error(message);
		
	}
	
	public static void error(Object message, Throwable t){
		logger.error(message, t);
	}

	public static void trace(Object message){
		logger.trace(message);
	}
}
