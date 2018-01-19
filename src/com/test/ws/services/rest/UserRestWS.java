package com.test.ws.services.rest;

import java.text.ParseException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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

    private static final String MODULE = "RestServices";
    public static final String CLASS = UserRestWS.class.getSimpleName();

    @POST
    @Path("/login")
    public Response login(@QueryParam("email") String email,
                          @QueryParam("password") String password)
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
    @Path("/getContactList")
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
    @Path("/getBirthday")
    public Response getBirthday(@QueryParam("id") String cakeId) {
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
    @Path("/getSSP")
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
    @Path("/getMandal")
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
    @Path("/getArea")
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
    @Path("/createSabha")
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
    @Path("/getSabhaDetails")
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
    @Path("/uploadUserData")
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
    @Path("/getMandalYuvakList")
    public Response getMandalYuvakList(@QueryParam("mandal_id") Integer mandal_id) {
    	  UserServiceImpl blManager = new UserServiceImpl();
          Response response = null;
          Logger.logInfo(MODULE, "Method called "+AkdmUtils.getMethodName()+ " of " + CLASS);
          Logger.logInfo(MODULE, "Parameters are : mandal_id-"+mandal_id);
          
          try {
              response = blManager.getMandalYuvakList(mandal_id);
          } catch (NumberFormatException ne) {
              return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
          }
          return response;
	}
    
    @GET
    @Path("/getSabhaList")
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
    @Path("/getSabhaMandalList")
    public Response getSabhaMandalList(@QueryParam("sabha_id") Integer sabha_id) {
    	  UserServiceImpl blManager = new UserServiceImpl();
          Response response = null;
          Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);
          Logger.logInfo(MODULE, "Parameters are : sabha_id-"+sabha_id);
          
          try {
              response = blManager.getSabhaMandalList(sabha_id);
          } catch (NumberFormatException ne) {
              return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
          }
          return response;
	}
    
    @GET
    @Path("/getSabhaYuvakList")
    public Response getSabhaYuvakList(@QueryParam("sabha_id") Integer sabha_id
    		,@QueryParam("mandal_id") Integer mandal_id) {
    	  
    	UserServiceImpl blManager = new UserServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);
        Logger.logInfo(MODULE, "Parameters are : sabha_id-"+sabha_id+",mandal_id-"+mandal_id);
        
        try {
              response = blManager.getSabhaYuvakList(sabha_id,mandal_id);
          } catch (NumberFormatException ne) {
              return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
          }
          return response;
	}
    
    @POST
    @Path("/createYuvakSabhaAttendance")
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
