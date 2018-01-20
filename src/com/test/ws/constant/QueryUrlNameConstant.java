package com.test.ws.constant;

import java.util.HashMap;
import java.util.Map;

public class QueryUrlNameConstant {

	public static Map<String, String> queryParam = new HashMap<String, String>();

	public static final String comma = ",";
	public static final String getContactList = "/getContactList";
	public static final String login = "/login";
	public static final String getBirthday = "/getBirthday";
	public static final String getSSP = "/getSSP";
	public static final String getMandal = "/getMandal";
	public static final String getArea = "/getArea";
	public static final String createSabha = "/createSabha";
	public static final String getSabhaDetails = "/getSabhaDetails";
	public static final String uploadUserData = "/uploadUserData";
	public static final String getMandalYuvakList = "/getMandalYuvakList";
	public static final String getSabhaList = "/getSabhaList";
	public static final String getSabhaMandalList = "/getSabhaMandalList";
	public static final String getSabhaYuvakList ="/getSabhaYuvakList";
	public static final String createYuvakSabhaAttendance ="/createYuvakSabhaAttendance";
	
	
	// All @QueryParam's are below 
	public static final String email = "email";
	public static final String password = "password";
	public static final String id = "id";
	public static final String mandal_id = "mandal_id"; 
	public static final String sabha_id = "sabha_id";
	
	
	//URL + It's parameter 
	public static final String login_request_param = email + comma + password ;
	public static final String getBirthday_request_param = id;
	public static final String getMandalYuvakList_request_param = mandal_id;
	public static final String getSabhaMandalList_request_param = sabha_id;
	public static final String getSabhaYuvakList_request_param = sabha_id + comma + mandal_id;
	
	
	public static void initializedQueryParameter() {
		System.out.println("Initializing QueryParameter");
		queryParam.put(QueryUrlNameConstant.login,QueryUrlNameConstant.login_request_param);
		queryParam.put(QueryUrlNameConstant.getBirthday,QueryUrlNameConstant.getBirthday_request_param);
		queryParam.put(QueryUrlNameConstant.getMandalYuvakList,QueryUrlNameConstant.getMandalYuvakList_request_param);
		queryParam.put(QueryUrlNameConstant.getSabhaMandalList,QueryUrlNameConstant.getSabhaMandalList_request_param);
		queryParam.put(QueryUrlNameConstant.getSabhaYuvakList,QueryUrlNameConstant.getSabhaYuvakList_request_param);
	}
			
}
