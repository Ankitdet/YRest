package com.test.ws.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class StringToStringAdapter extends XmlAdapter<String,String> {

	@Override
	public String unmarshal(String str) throws Exception {
		  if(str == null || str.trim().isEmpty() == true){
		         return null;
		      }
		      try{
		         return String.valueOf(str.trim());
		      }catch(Exception ex){
		         return "";
		     }
	}

	@Override
	public String marshal(String longVal) throws Exception {
		if(longVal == null){
	         return "";
	      }
	      return longVal.toString();
	}

}
