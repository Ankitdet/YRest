package com.test.ws.utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.test.ws.logger.Logger;

public class HttpRequestCounter {

	public static final String MODULE = HttpRequestCounter.class
			.getSimpleName();

	public static ConcurrentHashMap<String, AtomicInteger> requestCountMap = new ConcurrentHashMap<String, AtomicInteger>();

	public static void httpRequestCount(String url) {

		AtomicInteger count = requestCountMap.get(url);

		if (count == null) {
			count = new AtomicInteger(1);
			requestCountMap.put(url, count);
		} else {
			count.getAndAdd(1);
		}
		Logger.logDebug(MODULE, "{" + url + "} requested counts:" + count);
	}
}
