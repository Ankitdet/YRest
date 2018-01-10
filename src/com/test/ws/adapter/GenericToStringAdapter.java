package com.test.ws.adapter;

import java.text.NumberFormat;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class GenericToStringAdapter extends XmlAdapter<String,Number> {

	@Override
	public Number unmarshal(String str) throws Exception {
		  if(str == null || str.trim().isEmpty() == true){
		         return null;
		      }
		      try{
		         return NumberFormat.getInstance().parse(str.trim());
		      }catch(Exception ex){
		         return NumberFormat.getInstance().getMinimumIntegerDigits();
		     }
	}

	@Override
	public String marshal(Number longVal) throws Exception {
		if(longVal == null){
	         return "";
	      }
	      return longVal.toString();
	}

}
