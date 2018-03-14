package com.test.ws.table.metadata;

public class SqlStaticQuery {

	public static String getSSPQuery = "select ssp_id,ssp_title from ssp";
	public static String getAreaQuery = "select area_id,area_title from areas";
	public static String getMandalQuery = "select mandal_id,mandal_title from mandals";
	public static String getMandalYuvalCount = "select count(*) from users where mandal_id=" ;
	
}
