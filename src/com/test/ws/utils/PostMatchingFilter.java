package com.test.ws.utils;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.MDC;

import com.test.ws.logger.Logger;

@Provider
public class PostMatchingFilter implements ContainerResponseFilter {

	private static final String MODULE = PostMatchingFilter.class.getName();

	@Override
	public void filter(ContainerRequestContext arg0, ContainerResponseContext arg1) throws IOException {
		// TODO Auto-generated method stub
		String stTime = (String) MDC.get("start-time");
		if (null == stTime || stTime.length() == 0) {
			return;
		}
		long startTime = Long.parseLong(stTime);
		long executionTime = System.currentTimeMillis() - startTime;
		Logger.logInfo(MODULE, "Total execution time : ["+executionTime+" ms]");
		// clear the context on exit
		MDC.clear();
	}
}
