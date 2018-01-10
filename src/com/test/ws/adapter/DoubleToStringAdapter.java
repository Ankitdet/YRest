package com.test.ws.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DoubleToStringAdapter extends XmlAdapter<String,Double> {

	@Override
	public Double unmarshal(String str) throws Exception {
		  if(str == null || str.trim().isEmpty() == true){
		         return null;
		      }
		      try{
		         return Double.parseDouble(str.trim());
		      }catch(Exception ex){
		         return 0d;
		     }
	}

	@Override
	public String marshal(Double longVal) throws Exception {
		if(longVal == null){
	         return "";
	      }
	      return longVal.toString();
	}

}
