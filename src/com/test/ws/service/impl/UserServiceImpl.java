package com.test.ws.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.test.ws.constant.ResultCode;
import com.test.ws.datamanager.impl.UserDaoImpl;
import com.test.ws.datamanager.intrf.UserDao;
import com.test.ws.entities.AttendanceRequest;
import com.test.ws.entities.CreateSabhaData;
import com.test.ws.entities.Mandals;
import com.test.ws.entities.SabhaData;
import com.test.ws.entities.UsersFieldData;
import com.test.ws.exception.BusinessException;
import com.test.ws.exception.CommandException;
import com.test.ws.exception.InfrastructureException;
import com.test.ws.logger.Logger;
import com.test.ws.requestobject.LoginResponse;
import com.test.ws.requestobject.Response;
import com.test.ws.service.intrf.UserService;
import com.test.ws.utils.AkdmUtils;
import com.test.ws.utils.ReadWriteExcel;

public class UserServiceImpl implements UserService {

	public static final String MODULE = UserServiceImpl.class.getName();
	
	@Override
	public Response validateLogin(String email,String password) throws CommandException, ParseException {
		
		List<UsersFieldData> usersFieldDatas = new ArrayList<UsersFieldData>();
		UserDao loginDao = new UserDaoImpl();
    	Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName());
		try {
			usersFieldDatas = loginDao.validateLogin(email,password);
			 if(usersFieldDatas == null){
				 return new Response(ResultCode.NOT_FOUND_404.code, "Invalid credential!", null, "email or password doesn't match",usersFieldDatas);
			 }

		} catch (InfrastructureException ex) {
			throw new CommandException(ex);

		} catch (BusinessException ex) {
			throw new CommandException(ex);
		} finally {
			
		}
		return new Response(ResultCode.SUCCESS_200.code, "Login successfully", null, null,usersFieldDatas);
	}

	@Override
	public Response getBirthday(String cakeId) throws CommandException {

		UserDao loginDao = new UserDaoImpl();
		List<UsersFieldData> list = null;
		Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName());

		try {
			Long myBirthdayDigit = Long.valueOf(cakeId);
			list = loginDao.getBirthday(cakeId);
		} catch (InfrastructureException ex) {
			throw new InfrastructureException(ex);
		} catch (BusinessException ex) {
			throw new BusinessException(ex);
		} finally {

		}
		
		if(list == null)
			return new Response(ResultCode.NOT_FOUND_404.code, "Invalid value passed " +cakeId, null, null, list);
		
		if(!list.isEmpty()){
			return new Response(ResultCode.SUCCESS_200.code, "successfully get data", null, null, list);
		}else{
			return new Response(ResultCode.SUCCESS_200.code, "No record found", null, null, list);
		}

	}

	public Response getUserContactList() throws CommandException, ParseException {
		UserDao loginDao = new UserDaoImpl();
		List<UsersFieldData> list = null;
		Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName());

	
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

	@Override
	public Response getSSP() {
		UserDao loginDao = new UserDaoImpl();
		Response response = new Response();
		Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName());


		try {
			response = loginDao.getSSP();
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} finally {
		}
		return response;
	}

	@Override
	public Response getManadal() {
		UserDao loginDao = new UserDaoImpl();
		Response response = new Response();
		Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName());


		try {
			response = loginDao.getManadal();
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} finally {
		}
		return response;
	}

	@Override
	public Response getArea() {
		UserDao loginDao = new UserDaoImpl();
		Response response = new Response();
		Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName());


		try {
			response = loginDao.getArea();
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} finally {
		}
		return response;
	}

	@Override
	public Response doCreateSabha() {
		UserDao loginDao = new UserDaoImpl();
		Response response = new Response();
		Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName());


		try {
			response = loginDao.doCreateSabha();
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} finally {
		}
		return response;
	}

	@Override
	public Response getSabhaDetails() {
		UserDao loginDao = new UserDaoImpl();
		Response response = new Response();
		Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName());


		try {
			response = loginDao.getSabhaDetails();
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} finally {
		}
		return response;
	}

	public Response uploadDataByExcel() {
		
		UserDao loginDao = new UserDaoImpl();
		Response response = new Response();
		Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName());
;

		try {
			List<Object[]> list = ReadWriteExcel.getExcelSheetData();
			response = loginDao.uploadDataByExcel(list);
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} finally {
		}
		return response;
	}

	public Response getMandalYuvakList(Integer mandal_id) {
		
		UserDao loginDao = new UserDaoImpl();
		Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName());
		List<UsersFieldData> list = new ArrayList<UsersFieldData>();
		
		try {
			list = loginDao.getMandalYuvakList(mandal_id);
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} finally {
		}
		return new Response(ResultCode.SUCCESS_200.code, "successfully get data", null, null, list);
	}

	public Response getYuvakProfile(Integer user_id) {
	
		UserDao loginDao = new UserDaoImpl();
		Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName());
		List<UsersFieldData> list = new ArrayList<UsersFieldData>();
		
		try {
			list = loginDao.getYuvakProfile(user_id);
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} finally {
		}
		return new Response(ResultCode.SUCCESS_200.code, "successfully get data", null, null, list);
	}

	public Response getSabhaList() {
		
		UserDao loginDao = new UserDaoImpl();
		Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName());
		List<SabhaData> list = new ArrayList<SabhaData>();
		
		try {
			list = loginDao.getSabhaList();
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} finally {
		}
		return new Response(ResultCode.SUCCESS_200.code, "successfully get data", null, null, list);
	}

	public Response getSabhaMandalList(Integer sabha_id) {
		UserDao loginDao = new UserDaoImpl();
		Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName());
		List<Mandals> list = new ArrayList<Mandals>();
		
		try {
			list = loginDao.getSabhaMandalList(sabha_id);
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} finally {
		}
		return new Response(ResultCode.SUCCESS_200.code, "successfully get data", null, null, list);
	}

	public Response getSabhaYuvakList(Integer sabha_id, Integer mandal_id) {
		
		UserDao loginDao = new UserDaoImpl();
		Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName());
		List<CreateSabhaData> list = new ArrayList<CreateSabhaData>();

		try {
			list = loginDao.getSabhaYuvakList(sabha_id,mandal_id);
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} finally {
		}
		return new Response(ResultCode.SUCCESS_200.code, "successfully get data", null, null, list);

	}

	public Response createYuvakSabhaAttendance(AttendanceRequest request) {

		UserDao loginDao = new UserDaoImpl();
		Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName());
		Response response = null;
		
		try {
			response = loginDao.createYuvakSabhaAttendance(request);
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, ex.getMessage());
		} finally {
		}
		return response;
	}
}
