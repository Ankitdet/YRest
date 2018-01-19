package com.test.ws.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.test.ws.datamanager.impl.LoginDaoImpl;

public class AkdmUtils {

	public static String getMethodName() {
		LoginDaoImpl.counter = 0;
        return Thread.currentThread().getStackTrace()[2].getMethodName() + "()";
    }
	
	public static Timestamp getFormatedDate() {
	        java.util.Date date = new java.util.Date();
	        return new Timestamp(date.getTime());
	}
	
    public static <T> T getObject(Object o, Class<T> clazz) {
        try {
        	
        	if(o instanceof BigDecimal){
        		if(clazz == Integer.class){
        			o = ((BigDecimal) o).intValue();
        		}else if(clazz == Double.class){
        			o = ((BigDecimal) o).doubleValue();
        		}else if(clazz == Long.class){
        			o = ((BigDecimal) o).longValue();
        		}else if(clazz == Float.class){
        			o = ((BigDecimal) o).floatValue();
        		}
        	}
        	
        	if(o instanceof BigInteger){
        		if(clazz == Integer.class){
        			o = ((BigInteger) o).intValue();
        		}else if(clazz == Double.class){
        			o = ((BigInteger) o).doubleValue();
        		}else if(clazz == Long.class){
        			o = ((BigInteger) o).longValue();
        		}else if(clazz == Float.class){
        			o = ((BigInteger) o).floatValue();
        		}
        	}
        	
        	if(o instanceof Date){
        		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        		o = new Date((df.parse((String)o)).getTime());
        	}
        	
           return clazz.cast(o);
        } catch(ClassCastException e) {
            return null;
        } catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }
}
