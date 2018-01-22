package com.test.ws.utils;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

public class AkdmUtils {

	public static String getMethodName() {
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
        	if(o instanceof Timestamp){
        		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        		o = dateFormat.format(new Date(((Timestamp) o).getTime()));
        	}

        	return clazz.cast(o);
        } catch(ClassCastException e) {
            return null;
        } 
    }
    
    public static File getWorkingDir(@Context ServletContext context) {
        String path = context.getRealPath("/WEB-INF/images");         
        File exDir = new File(path);
            if (!exDir.exists()) {
            	exDir.mkdirs();
            }
            return exDir;
          }
    
    public static File getWorkingDirForUploadExcelFile(@Context ServletContext context) {
        String path = context.getRealPath("/WEB-INF/excel");         
        File exDir = new File(path);
            if (!exDir.exists()) {
            	exDir.mkdirs();
            }
            return exDir;
          }
}
