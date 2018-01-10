package com.test.ws.constant;

import java.util.HashMap;
import java.util.Map;

public enum ResultCode {

	SUCCESS_200(200, "SUCCESS"),
 	INPUT_PARAMETER_MISSING_401(401, "Required Input Parameter Missing/Invalid Parameter"), // Missing parameter
 	NOT_FOUND_404(404, "Request parameter not found"),
	ALREADY_EXIST_450(450, "already exist"),
	INTERNAL_ERROR_500(500, "Internal Server Error"), // DB Query failed
	SERVICE_UNAVAILABLE_503(503, "Service unavailable"),
	OPERATION_NOT_SUPPORTED_599(599, "Operation not supported"),
	PRECONDITION_FAILED_412(412, "Precondition failed");
	
	public int code;
	public String name;
	public static Map<Integer,ResultCode> resultCodeMap = new HashMap<Integer, ResultCode>();
	static{
		for(ResultCode resultCode : ResultCode.values()){
			resultCodeMap.put(resultCode.code, resultCode);
		}
	}
	private ResultCode(int code, String name) {
		this.code = code;
		this.name = name;
	}
	public static ResultCode fromVal(int code){
		return resultCodeMap.get(code);
	}

}
