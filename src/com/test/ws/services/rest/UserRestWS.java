package com.test.ws.services.rest;

import java.text.ParseException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.test.ws.constant.QueryUrlNameConstant;
import com.test.ws.constant.ResultCode;
import com.test.ws.entities.AttendanceRequest;
import com.test.ws.exception.CommandException;
import com.test.ws.logger.Logger;
import com.test.ws.requestobject.Response;
import com.test.ws.service.impl.UserServiceImpl;
import com.test.ws.utils.AkdmUtils;

@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.MULTIPART_FORM_DATA})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class UserRestWS {

    private static final String MODULE = UserRestWS.class.getName();
    public static final String CLASS = UserRestWS.class.getSimpleName();

    @POST
    @Path(QueryUrlNameConstant.login)
    public Response login(@QueryParam(QueryUrlNameConstant.email) String email,
    		@QueryParam(QueryUrlNameConstant.password) String password)
            throws NumberFormatException, ParseException, CommandException {

        UserServiceImpl blManager = new UserServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called "+AkdmUtils.getMethodName()+ " of " + CLASS);
        Logger.logInfo(MODULE, "Parameters are : email-" + email + ",password-" + password);

        try {
            if (email == null || email.trim() == "") {
                return new Response(
                        ResultCode.INPUT_PARAMETER_MISSING_401.code,
                        "email must not blank", null, null, null);
            }
            if (password == null || password.trim() == "") {
                return new Response(
                        ResultCode.INPUT_PARAMETER_MISSING_401.code,
                        "password must not blank", null, null, null);
            }

            response = blManager.validateLogin(email, password);

        } catch (NumberFormatException e) {
            return new Response(ResultCode.INPUT_PARAMETER_MISSING_401.code,
                    ResultCode.INPUT_PARAMETER_MISSING_401.name, null,
                    e.getMessage(), null);
        } catch (ParseException e) {
            return new Response(ResultCode.INPUT_PARAMETER_MISSING_401.code,
                    ResultCode.INPUT_PARAMETER_MISSING_401.name, null,
                    e.getMessage(), null);
        } catch (CommandException e) {
            return new Response(ResultCode.INPUT_PARAMETER_MISSING_401.code,
                    ResultCode.INPUT_PARAMETER_MISSING_401.name, null,
                    e.getMessage(), null);
        }
        return response;
    }

    @GET
    @Path(QueryUrlNameConstant.getContactList)
    public Response getContactList() throws ParseException {

        UserServiceImpl blManager = new UserServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called "+AkdmUtils.getMethodName()+ " of " + CLASS);

        try {
            response = blManager.getUserContactList();
        } catch (Exception e) {
            return new Response(ResultCode.INPUT_PARAMETER_MISSING_401.code,
                    ResultCode.INPUT_PARAMETER_MISSING_401.name, null,
                    e.getMessage(), null);
        }
        return response;
    }

    
    @GET
    @Path(QueryUrlNameConstant.getBirthday)
    public Response getBirthday(@QueryParam(QueryUrlNameConstant.id) String cakeId) {
        UserServiceImpl blManager = new UserServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called "+AkdmUtils.getMethodName()+ " of " + CLASS);
        Logger.logInfo(MODULE, "Parameters are : Id-" + cakeId);
        
        try {
            if (cakeId == null || cakeId.trim() == "") {
                return new Response(ResultCode.NOT_FOUND_404.code, ResultCode.NOT_FOUND_404.name, null, "id not found", null);
            }
            response = blManager.getBirthday(cakeId);

        } catch (NumberFormatException ne) {
            return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
        } catch (CommandException e) {
            return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
        }
        return response;
    }

    @GET
    @Path(QueryUrlNameConstant.getSSP)
    public  Response getSSP() {

        UserServiceImpl blManager = new UserServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called "+AkdmUtils.getMethodName()+ " of " + CLASS);
        try {
            response = blManager.getSSP();
        } catch (NumberFormatException ne) {
            return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
        }
        return response;
    }

    @GET
    @Path(QueryUrlNameConstant.getMandal)
    public  Response getManadal() {
        UserServiceImpl blManager = new UserServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called "+AkdmUtils.getMethodName()+ " of " + CLASS);
        try {
            response = blManager.getManadal();
        } catch (NumberFormatException ne) {
            return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
        }
        return response;
    }

    @GET
    @Path(QueryUrlNameConstant.getArea)
    public Response getArea() {
        UserServiceImpl blManager = new UserServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called "+AkdmUtils.getMethodName()+ " of " + CLASS);
        try {
            response = blManager.getArea();
        } catch (NumberFormatException ne) {
            return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
        }
        return response;
    }

    @POST
    @Path(QueryUrlNameConstant.createSabha)
    public Response doCreateSabha() {
        UserServiceImpl blManager = new UserServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called "+AkdmUtils.getMethodName()+ " of " + CLASS);

        try {
            response = blManager.doCreateSabha();
        } catch (NumberFormatException ne) {
            return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
        }
        return response;
    }

    @GET
    @Path(QueryUrlNameConstant.getSabhaDetails)
    public Response getSabhaDetails() {
        UserServiceImpl blManager = new UserServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called "+AkdmUtils.getMethodName()+ " of " + CLASS);

        try {
            response = blManager.getSabhaDetails();
        } catch (NumberFormatException ne) {
            return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
        }
        return response;
    }
    
    @POST
    @Path(QueryUrlNameConstant.uploadUserData)
    public Response uploadDataByExcel() {
    	  UserServiceImpl blManager = new UserServiceImpl();
          Response response = null;
          Logger.logInfo(MODULE, "Method called "+AkdmUtils.getMethodName()+ " of " + CLASS);

          try {
              response = blManager.uploadDataByExcel();
          } catch (NumberFormatException ne) {
              return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
          }
          return response;
	}
    
    @GET
    @Path(QueryUrlNameConstant.getMandalYuvakList)
    public Response getMandalYuvakList(@QueryParam(QueryUrlNameConstant.mandal_id) Integer mandal_id) {
    	  UserServiceImpl blManager = new UserServiceImpl();
          Response response = null;
          Logger.logInfo(MODULE, "Method called "+AkdmUtils.getMethodName()+ " of " + CLASS);
          Logger.logInfo(MODULE, "Parameters are : mandal_id-"+mandal_id);
          
          if(mandal_id == null || mandal_id  <= 0){
              return new Response(ResultCode.NOT_FOUND_404.code, ResultCode.NOT_FOUND_404.name, null, "mandal id not found", null);
          }
 
          try {
              response = blManager.getMandalYuvakList(mandal_id);
          } catch (NumberFormatException ne) {
              return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
          }
          return response;
	}
    
    @GET
    @Path(QueryUrlNameConstant.getSabhaList)
    public Response getSabhaList() {
    	  UserServiceImpl blManager = new UserServiceImpl();
          Response response = null;
          Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);
          try {
              response = blManager.getSabhaList();
          } catch (NumberFormatException ne) {
              return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
          }
          return response;
	}
    
    @GET
    @Path(QueryUrlNameConstant.getSabhaMandalList)
    public Response getSabhaMandalList(@QueryParam(QueryUrlNameConstant.sabha_id) Integer sabha_id) {
    	  UserServiceImpl blManager = new UserServiceImpl();
          Response response = null;
          Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);
          Logger.logInfo(MODULE, "Parameters are : sabha_id-"+sabha_id);
          
          if(sabha_id == null || sabha_id  <= 0){
              return new Response(ResultCode.NOT_FOUND_404.code, ResultCode.NOT_FOUND_404.name, null, "sabha id not found", null);
          }
          
          try {
              response = blManager.getSabhaMandalList(sabha_id);
          } catch (NumberFormatException ne) {
              return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
          }
          return response;
	}
    
    @GET
    @Path(QueryUrlNameConstant.getSabhaYuvakList)
    public Response getSabhaYuvakList(@QueryParam(QueryUrlNameConstant.sabha_id) Integer sabha_id
    		,@QueryParam(QueryUrlNameConstant.mandal_id) Integer mandal_id) {
    	  
    	UserServiceImpl blManager = new UserServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);
        Logger.logInfo(MODULE, "Parameters are : sabha_id-"+sabha_id+",mandal_id-"+mandal_id);
        
        if(sabha_id == null || sabha_id  <= 0){
            return new Response(ResultCode.NOT_FOUND_404.code, ResultCode.NOT_FOUND_404.name, null, "sabha id not found", null);
        }
        
        if(mandal_id == null || mandal_id  <= 0){
            return new Response(ResultCode.NOT_FOUND_404.code, ResultCode.NOT_FOUND_404.name, null, "mandal id not found", null);
        }
        try {
              response = blManager.getSabhaYuvakList(sabha_id,mandal_id);
          } catch (NumberFormatException ne) {
              return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
          }
          return response;
	}
    
    @POST
    @Path(QueryUrlNameConstant.createYuvakSabhaAttendance)
    public Response createYuvakSabhaAttendance(AttendanceRequest request) {
    	  UserServiceImpl blManager = new UserServiceImpl();
          Response response = null;
          Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);
          try {
              response = blManager.createYuvakSabhaAttendance(request);
          } catch (NumberFormatException ne) {
              return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
          }
          return response;
	}
}
