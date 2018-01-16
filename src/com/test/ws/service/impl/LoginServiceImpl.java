package com.test.ws.service.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.test.ws.constant.ResultCode;
import com.test.ws.datamanager.impl.LoginDaoImpl;
import com.test.ws.datamanager.intrf.LoginDao;
import com.test.ws.entities.AttendanceRequest;
import com.test.ws.entities.Mandals;
import com.test.ws.entities.SabhaData;
import com.test.ws.entities.Users;
import com.test.ws.entities.UsersFieldData;
import com.test.ws.exception.BusinessException;
import com.test.ws.exception.CommandException;
import com.test.ws.exception.InfrastructureException;
import com.test.ws.logger.Logger;
import com.test.ws.requestobject.LoginResponse;
import com.test.ws.requestobject.Response;
import com.test.ws.service.intrf.LoginService;
import com.test.ws.utils.ReadWriteExcel;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class LoginServiceImpl implements LoginService {

	public static final String CLASS = LoginServiceImpl.class.getName();
	public static final String MODULE = LoginServiceImpl.class.getSimpleName();
	
	@Override
	public Response validateLogin(String email,String password) throws CommandException, ParseException {
		
		LoginResponse loginResponse = null;
		LoginDao loginDao = new LoginDaoImpl();
		Logger.logDebug("Test", "Enter into create method of "+CLASS);
		
		try {
			 loginResponse = loginDao.validateLogin(email,password);
			 if(loginResponse == null){
				 return new Response(ResultCode.NOT_FOUND_404.code, "Invalid credential!", null, "email or password doesn't match",loginResponse);
			 }

		} catch (InfrastructureException ex) {
			throw new CommandException(ex);

		} catch (BusinessException ex) {
			throw new CommandException(ex);
		} finally {
			
		}
		return new Response(ResultCode.SUCCESS_200.code, "Login successfully", null, null,loginResponse);
	}

	@Override
	public Response getBirthday(String cakeId) throws CommandException {
		String message = "";
		LoginResponse loginResponse = null;
		LoginDao loginDao = new LoginDaoImpl();
		List<UsersFieldData> list = null;
		Logger.logDebug("Test", "Enter into create method of " + CLASS);

		try {
			Long myBirthdayDigit = Long.valueOf(cakeId);
			list = loginDao.getBirthday(cakeId);
		} catch (InfrastructureException ex) {
			throw new InfrastructureException(ex);
		} catch (BusinessException ex) {
			throw new BusinessException(ex);
		} finally {

		}
		if(!list.isEmpty()){
			return new Response(ResultCode.SUCCESS_200.code, "successfully get data", null, null, list);
		}else{
			return new Response(ResultCode.SUCCESS_200.code, "No record found", null, null, list);
		}

	}

	public Response getUserContactList() throws CommandException, ParseException {
		LoginDao loginDao = new LoginDaoImpl();
		List<UsersFieldData> list = null;
		Logger.logDebug("Test", "Enter into getUserContactList() method of "+CLASS);
	
		try {
			 list = loginDao.getUserContactList();
		} catch (InfrastructureException ex) {
			throw new CommandException(ex);

		} catch (BusinessException ex) {
			throw new CommandException(ex);
		} finally {
			
		}
		return new Response(ResultCode.SUCCESS_200.code, "successfully get data", null, null, list);
	}

	public void getData(){
		DateTime dt = new DateTime();
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("YYYY-MM-DD HH:mm:ss");
		System.out.println("dateTimeFormatter:" +dateTimeFormatter);
	}

	@Override
	public Response getSSP() {
		LoginDao loginDao = new LoginDaoImpl();
		Response response = new Response();
		Logger.logDebug("Test", "Enter into getSSP() method of "+CLASS);

		try {
			response = loginDao.getSSP();
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} finally {
		}
		return response;
	}

	@Override
	public Response getManadal() {
		LoginDao loginDao = new LoginDaoImpl();
		Response response = new Response();
		Logger.logDebug("Test", "Enter into getSSP() method of "+CLASS);

		try {
			response = loginDao.getManadal();
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} finally {
		}
		return response;
	}

	@Override
	public Response getArea() {
		LoginDao loginDao = new LoginDaoImpl();
		Response response = new Response();
		Logger.logDebug("Test", "Enter into getSSP() method of "+CLASS);

		try {
			response = loginDao.getArea();
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} finally {
		}
		return response;
	}

	@Override
	public Response doCreateSabha() {
		LoginDao loginDao = new LoginDaoImpl();
		Response response = new Response();
		Logger.logDebug("Test", "Enter into getSSP() method of "+CLASS);

		try {
			response = loginDao.doCreateSabha();
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} finally {
		}
		return response;
	}

	@Override
	public Response getSabhaDetails() {
		LoginDao loginDao = new LoginDaoImpl();
		Response response = new Response();
		Logger.logDebug("Test", "Enter into getSabhaDetails() method of "+CLASS);

		try {
			response = loginDao.getSabhaDetails();
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} finally {
		}
		return response;
	}

	public Response uploadDataByExcel() {
		
		LoginDao loginDao = new LoginDaoImpl();
		Response response = new Response();
		Logger.logDebug("Test", "Enter into uploadDataByExcel() method of "+CLASS);

		try {
			List<Object[]> list = ReadWriteExcel.getExcelSheetData();
			response = loginDao.uploadDataByExcel(list);
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} finally {
		}
		return response;
	}

	public Response getMandalYuvakList(Integer mandal_id) {
		
		LoginDao loginDao = new LoginDaoImpl();
		Logger.logDebug("Test", "Enter into getMandalYuvakList() method of "+CLASS);
		List<UsersFieldData> list = new ArrayList<UsersFieldData>();
		
		try {
			list = loginDao.getMandalYuvakList(mandal_id);
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} finally {
		}
		return new Response(ResultCode.SUCCESS_200.code, "successfully get data", null, null, list);
	}

	public Response getYuvakProfile(Integer user_id) {
	
		LoginDao loginDao = new LoginDaoImpl();
		Logger.logDebug("Test", "Enter into getYuvakProfile() method of "+CLASS);
		List<UsersFieldData> list = new ArrayList<UsersFieldData>();
		
		try {
			list = loginDao.getYuvakProfile(user_id);
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} finally {
		}
		return new Response(ResultCode.SUCCESS_200.code, "successfully get data", null, null, list);
	}

	public Response getSabhaList() {
		
		LoginDao loginDao = new LoginDaoImpl();
		Logger.logDebug("Test", "Enter into getSabhaList() method of "+CLASS);
		List<SabhaData> list = new ArrayList<SabhaData>();
		
		try {
			list = loginDao.getSabhaList();
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} finally {
		}
		return new Response(ResultCode.SUCCESS_200.code, "successfully get data", null, null, list);
	}

	public Response getSabhaMandalList(Integer sabha_id) {
		LoginDao loginDao = new LoginDaoImpl();
		Logger.logDebug("Test", "Enter into getSabhaList() method of "+CLASS);
		List<Mandals> list = new ArrayList<Mandals>();
		
		try {
			list = loginDao.getSabhaMandalList(sabha_id);
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} finally {
		}
		return new Response(ResultCode.SUCCESS_200.code, "successfully get data", null, null, list);
	}

	public Response getSabhaYuvakList(Integer sabha_id, Integer mandal_id) {
		
		LoginDao loginDao = new LoginDaoImpl();
		Logger.logDebug("Test", "Enter into getSabhaYuvakList() method of "+CLASS);
		List<UsersFieldData> list = new ArrayList<UsersFieldData>();

		try {
			list = loginDao.getSabhaYuvakList(sabha_id,mandal_id);
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} finally {
		}
		return new Response(ResultCode.SUCCESS_200.code, "successfully get data", null, null, list);

	}

	public Response createYuvakSabhaAttendance(AttendanceRequest request) {

		LoginDao loginDao = new LoginDaoImpl();
		Logger.logDebug("Test", "Enter into createYuvakSabhaAttendance() method of "+CLASS);
		List<UsersFieldData> list = new ArrayList<UsersFieldData>();

		try {
			list = loginDao.createYuvakSabhaAttendance(request);
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
		} finally {
		}
		return new Response(ResultCode.SUCCESS_200.code, "successfully get data", null, null, list);

	}
}
