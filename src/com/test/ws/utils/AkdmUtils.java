package com.test.ws.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

public class AkdmUtils {

	public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName() + "()";
    }
	
	public static Timestamp getFormatedDate() {
	        java.util.Date date = new java.util.Date();
	        return new Timestamp(date.getTime());
	}
	
    public static Object setObject(Object obj) {

        if (obj instanceof BigInteger) {
            return String.valueOf(((BigInteger) obj).intValue());
        } else if (obj instanceof BigDecimal) {
            return String.valueOf(((BigDecimal) obj).intValue());
        } else if (obj instanceof Timestamp) {
            return new Date(((Timestamp) obj).getTime());
        }
        return obj;
    }
}
