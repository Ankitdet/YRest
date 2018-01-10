package com.test.ws.exception;

import org.apache.commons.lang.exception.ExceptionUtils;


public class CustomTestException {
	 public static String convertToString( String[] args0 ) {
	       StringBuffer sb = new StringBuffer();
	        if (args0 != null) {
	            for ( int i = 0; i < args0.length; i++ ) {
	               sb.append("\n");
	               sb.append(args0[i]);
	            }
	        }
	        return sb.toString();
	  }
	
	
	public static String getRootCauseStackTraceAsString(Throwable args) {
		String trace =  ExceptionUtils.getStackTrace(args);
		return trace;
	}
}
