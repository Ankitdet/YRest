package com.test.ws.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TokenGenerator {

	public static Map<String,String> tokenMap = null;
	static {
		tokenMap = new HashMap<String, String>();
	}
	public static String uniqueUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
