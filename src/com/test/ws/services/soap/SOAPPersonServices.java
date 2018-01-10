package com.test.ws.services.soap;


import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.ws.services.rest.RestServices;

@WebService(name="PersonWS")
public class SOAPPersonServices {

	private static final String MODULE = "PERSON-SOAP-WS";
	protected final Logger logger = LoggerFactory.getLogger(RestServices.class);

	/*@WebMethod(operationName = "methodName")
	public PersonWSResponse wsConfigureVoIPAccount(PersonWSRequest personRequest){
		PersonWSResponse response =null;
		logger.info(MODULE, "Called" + getMethodName() + " with Request: "+personRequest);

		try {
			*//**
			 * Write your logic
			 *//*
		} catch (NumberFormatException e) {
			logger.error(MODULE,"Error While creating Subscriber : "+e.getMessage());
			logger.trace(MODULE,e);
		} catch (ParseException e) {
			logger.error(MODULE,"Error While creating Subscriber : "+e.getMessage());
			logger.trace(MODULE,e);
		}
		return response;
	}
	public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }*/
}
