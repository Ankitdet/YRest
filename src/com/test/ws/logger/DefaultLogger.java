
/**
 * @author baiju DefaultLogger 
 */
package com.test.ws.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.lf5.LogLevel;


public class DefaultLogger implements ILogger {
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");

    public void error(String strMessage) {
        System.out.println("[ " + dateToString(new Date())+" ]" + " [ ERROR ] " + strMessage);
    }
    public void debug(String strMessage) {
        System.out.println("[ " + dateToString(new Date())+" ]" + " [ DEBUG ] " + strMessage);
    }
    public void info(String strMessage) {
        System.out.println("[ " + dateToString(new Date())+" ]" + " [ INFO ] " + strMessage);
    }
    public void warn(String strMessage) {
        System.out.println("[ " + dateToString(new Date())+" ]" + " [ WARN ] " + strMessage);
    }
    public void fatal(String strMessage) {
        System.out.println("[ " + dateToString(new Date())+" ]" + " [ FATAL ] " + strMessage);
    }
    public void trace(String strMessage) {
        System.out.println("[ " + dateToString(new Date())+" ]" + " [ TRACE ] " + strMessage);
    }

    protected String dateToString(Date date){
    	return sdf.format(date);
    }
	@Override
	public void error(String paramString1, String paramString2) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void debug(String paramString1, String paramString2) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void info(String paramString1, String paramString2) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void warn(String paramString1, String paramString2) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void trace(String paramString1, String paramString2) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void trace(Throwable paramThrowable) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void trace(String paramString, Throwable paramThrowable) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isLogLevel(LogLevel paramLogLevel) {
		// TODO Auto-generated method stub
		return false;
	}
    
}
