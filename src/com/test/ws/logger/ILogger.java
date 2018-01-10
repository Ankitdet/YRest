package com.test.ws.logger;

import org.apache.log4j.lf5.LogLevel;

public interface ILogger {

    public void error(String strMessage);
    
    public void debug(String strMessage);
    
    public void info(String strMessage);
    
    public void warn(String strMessage);

    public void fatal(String strMessage);
    
    public void trace(String strMessage);
 
    public void error(String paramString1, String paramString2);

	public void debug(String paramString1, String paramString2);

	public void info(String paramString1, String paramString2);

	public void warn(String paramString1, String paramString2);

	public void trace(String paramString1, String paramString2);

	public void trace(Throwable paramThrowable);
	
	public void trace(String paramString, Throwable paramThrowable);
	
	public boolean isLogLevel(LogLevel paramLogLevel);
}
