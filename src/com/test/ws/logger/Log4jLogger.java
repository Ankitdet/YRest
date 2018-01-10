/**
 * 
 */

package com.test.ws.logger;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.lf5.LogLevel;

import com.test.ws.exception.CustomTestException;


public class Log4jLogger implements ILogger {
	public static Logger logger = null;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
	private static final String MODULE  = "LOGGER";
	
	
	
	public static void setLogger(Logger logger){
		Log4jLogger.logger=logger;
	}
	
	public Log4jLogger(){
		logger = Logger.getLogger("EliteLog4j");
		System.out.println("Logger is going to init()");
		String fileName = null;
		Layout layout = new PatternLayout("%m%n");
		ConsoleAppender consolAppender= null;
		RollingFileAppender appender = null;

		try {
			File logFile = new File("/tmp/ServerManager.log");
			
			if(! logFile.isFile() ){
				FileUtils.touch(logFile);
			}
			
			fileName =logFile.getAbsolutePath(); 
			System.out.println("Logfile :" + fileName);
			consolAppender = new ConsoleAppender(layout);
			//appender = new FileAppender(layout,fileName,true);
			
			appender = new RollingFileAppender();
			appender.setLayout(layout);
			appender.setFile(fileName);
			appender.setAppend(true);
			appender.setMaxBackupIndex(4);
			appender.setMaxFileSize("1KB");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not able to get File appender");
		}

		logger.addAppender(consolAppender);
		logger.addAppender(appender);
		logger.setLevel(Level.TRACE);
		
		logger.info("[" + dateToString(new Date()) + "] " +  "[ WARN  ] "+ "["+ MODULE +"]"  +"  :  Server Started on "+ dateToString(new Date()));
	}
	
	
	/*public Log4jLogger(){
		logger = Logger.getLogger("EliteLog4j");
		System.out.println("Logget is going to init()");
		String fileName = null;
		Layout layout = new PatternLayout("%m%n");
		ConsoleAppender consolAppender= null;
		RollingFileAppender appender = null;

		try {
			File logFile = new File("../logs/ServerManager.log");
			
			if(! logFile.isFile() ){
				FileUtils.touch(logFile);
			}
			
			fileName =logFile.getAbsolutePath(); 
			System.out.println("Logfile :" + fileName);
			consolAppender = new ConsoleAppender(layout);
			//appender = new FileAppender(layout,fileName,true);
			appender = new RollingFileAppender();
			appender.setLayout(layout);
			appender.setFile(fileName);
			appender.setAppend(true);
			appender.setMaxBackupIndex(4);
			appender.setMaxFileSize("10KB");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not able to get File appender");
		}

		logger.addAppender(consolAppender);
		logger.addAppender(appender);
		logger.setLevel(Level.TRACE);
		
		logger.info("[" + dateToString(new Date()) + "] " +  "[ WARN  ] "+ "["+ MODULE +"]"  +"  :  Server Started on "+ dateToString(new Date()));

	}*/

	public void trace(String strMessage) {

		logger.trace("[" + dateToString(new Date()) + "] " + "[ TRACE ] "+ getClientAddress()+strMessage);

	}

	public void debug(String strMessage) {
		logger.debug("[" + dateToString(new Date()) + "] " + "[ DEBUG ] "+ getClientAddress()+strMessage);
	}

	public void info(String strMessage) {
		logger.info("[" + dateToString(new Date()) + "] " + "[ INFO  ] "+getClientAddress()+ strMessage);
	}


	public void warn(String strMessage) {
		logger.warn("[" + dateToString(new Date()) + "] " + "[ WARN ] "+getClientAddress()+ strMessage);
	}

	public void error(String strMessage) {
		logger.error("[" + dateToString(new Date()) + "] " + "[ ERROR ] "+ getClientAddress()+strMessage);
	}

	public void fatal(String strMessage) {
		logger.fatal("[" + dateToString(new Date()) + "] " + "[ FATAL ] "+getClientAddress()+ strMessage);
	}

	/*public void trace( Throwable exception ) {                    


	}*/


	protected String dateToString(Date date) {
		return sdf.format(date);
	}
	private static String getClientAddress(){

		String clientAddress = "";


		String remoteAddress = (String)MDC.get("remoteaddress");


		if(remoteAddress!=null){
			clientAddress  = "["+remoteAddress+"] ";
		}
		return clientAddress;
	}

	public void error(String strModule, String strMessage) {
		logger.error("[" + dateToString(new Date()) + "] " +"[ ERROR ][ " + strModule + " ] : " + strMessage);
	}

	public void debug(String strModule, String strMessage) {
		logger.debug("[" + dateToString(new Date()) + "] " +"[ DEBUG ][ " + strModule + " ] : " + strMessage);
	}

	public void info(String strModule, String strMessage) {
		logger.info("[" + dateToString(new Date()) + "] " +"[ INFO ][ " + strModule + " ] : " + strMessage);
	}

	public void warn(String strModule, String strMessage) {
		logger.warn("[" + dateToString(new Date()) + "] " +"[ WARN ][ " + strModule + " ] : " + strMessage);
	}

	public void trace(String strModule, String strMessage) {
		logger.trace("[" + dateToString(new Date()) + "] " +"[ TRACE ][ " + strModule + " ] : " + strMessage);
	}

	public void trace(Throwable exception) {
		logger.trace("[" + dateToString(new Date()) + "] " +"[ TRACE ] : " + "\n" + CustomTestException.getRootCauseStackTraceAsString(exception));
	}

	@Override
	public void trace(String paramString, Throwable paramThrowable) {
		logger.trace("[" + dateToString(new Date()) + "] " + "[ TRACE ]["+paramString+"] "+ "\n" + CustomTestException.getRootCauseStackTraceAsString(paramThrowable));
	}

	@Override
	public boolean isLogLevel(LogLevel paramLogLevel) {
		return true;
	}
}
