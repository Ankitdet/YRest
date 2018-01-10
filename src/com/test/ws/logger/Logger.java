package com.test.ws.logger;

import com.test.ws.exception.CustomTestException;

public class Logger {
   
	private static ILogger logger = new Log4jLogger();

	// private static ILogger logger = Log4jLogger.getLogger();
	public static void logError(String strModule, String strMessage) {
		logger.error("[ " + strModule + " ] : " + strMessage);
	}

	public static void logDebug(String strModule, String strMessage) {
		logger.debug("[ " + strModule + " ] : " + strMessage);
	}

	public static void logInfo(String strModule, String strMessage) {
		logger.info("[ " + strModule + " ] : " + strMessage);
	}

	public static void logWarn(String strModule, String strMessage) {
		logger.warn("[ " + strModule + " ] : " + strMessage);
	}

	public static void logFatal(String strModule, String strMessage) {
		logger.fatal("[ " + strModule + " ] : " + strMessage);
	}

	public static void logTrace(String strModule, String strMessage) {
		logger.trace("[ " + strModule + " ] : " + strMessage);
	}

	public static void logError(String strModule, Object strMessage) {
		logger.error("[ " + strModule + " ] : " + strMessage);
	}

	public static void logDebug(String strModule, Object strMessage) {
		logger.debug("[ " + strModule + " ] : " + strMessage);
	}

	public static void logInfo(String strModule, Object strMessage) {
		logger.info("[ " + strModule + " ] : " + strMessage);
	}

	public static void logWarn(String strModule, Object strMessage) {
		logger.warn("[ " + strModule + " ] : " + strMessage);
	}

	public static void logFatal(String strModule, Object strMessage) {
		logger.fatal("[ " + strModule + " ] : " + strMessage);
	}

	public static void logTrace(String strModule, Object strMessage) {
		logger.trace("[ " + strModule + " ] : " + strMessage);
	}

	public static void logTrace(String strModule, Throwable exception) {
		logger.trace("[ " + strModule + " ] : " + "\n" + CustomTestException.getRootCauseStackTraceAsString(exception));
	}

	public void error(String strModule, String strMessage) {
		logger.error("[ " + strModule + " ] : " + strMessage);
	}

	public void debug(String strModule, String strMessage) {
		logger.debug("[ " + strModule + " ] : " + strMessage);
	}

	public void info(String strModule, String strMessage) {
		logger.info("[ " + strModule + " ] : " + strMessage);
	}

	public void warn(String strModule, String strMessage) {
		logger.warn("[ " + strModule + " ] : " + strMessage);
	}

	public void trace(String strModule, String strMessage) {
		logger.trace("[ " + strModule + " ] : " + strMessage);
	}

	public void trace(Throwable exception) {
		logger.trace("[ TRACE ] : " + "\n" + CustomTestException.getRootCauseStackTraceAsString(exception));
	}

	public void trace(String paramString, Throwable paramThrowable) {
		logger.trace("[ " + paramString + " ] : " + "\n"
				+ CustomTestException.getRootCauseStackTraceAsString(paramThrowable));
	}

	public static void setLogger(ILogger newlogger) {
		logger = newlogger;
	}

	public static ILogger getLogger() {
		return logger;
	}

}
