package com.test.ws.services.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.IOUtils;

import com.test.ws.constant.QueryUrlNameConstant;
import com.test.ws.constant.ResultCode;
import com.test.ws.entities.AttendanceRequest;
import com.test.ws.entities.SabhaData;
import com.test.ws.exception.CommandException;
import com.test.ws.logger.Logger;
import com.test.ws.requestobject.Response;
import com.test.ws.service.impl.UserServiceImpl;
import com.test.ws.utils.AkdmUtils;

@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.MULTIPART_FORM_DATA})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class UserRestWS {

    private static final String MODULE = UserRestWS.class.getSimpleName();

    @POST
    @Path(QueryUrlNameConstant.login)
    public Response login(@QueryParam(QueryUrlNameConstant.email) String email,
    		@QueryParam(QueryUrlNameConstant.password) String password)
            throws NumberFormatException, ParseException, CommandException {

        UserServiceImpl blManager = new UserServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called "+AkdmUtils.getMethodName());
        Logger.logInfo(MODULE, "Parameters are : email-" + email + ",password-" + password);

        try {

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
        Logger.logInfo(MODULE, "Method called "+AkdmUtils.getMethodName());

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
        Logger.logInfo(MODULE, "Method called "+AkdmUtils.getMethodName());
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
        Logger.logInfo(MODULE, "Method called "+AkdmUtils.getMethodName());
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
        Logger.logInfo(MODULE, "Method called "+AkdmUtils.getMethodName());
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
        Logger.logInfo(MODULE, "Method called "+AkdmUtils.getMethodName());
        try {
            response = blManager.getArea();
        } catch (NumberFormatException ne) {
            return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
        }
        return response;
    }

    @POST
    @Path(QueryUrlNameConstant.createSabha)
    public Response doCreateSabha(SabhaData sabhaData) {
        UserServiceImpl blManager = new UserServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called "+AkdmUtils.getMethodName());

        try {
            response = blManager.doCreateSabha(sabhaData);
        } catch (NumberFormatException ne) {
            return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
        }
        return response;
    }

    @GET
    @Path(QueryUrlNameConstant.getSabhaList)
    public Response getSabhaDetails() {
        UserServiceImpl blManager = new UserServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called "+AkdmUtils.getMethodName());

        try {
            response = blManager.getSabhaDetails();
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
          Logger.logInfo(MODULE, "Method called "+AkdmUtils.getMethodName());
          Logger.logInfo(MODULE, "Parameters are : mandal_id-"+mandal_id);
          
          try {
              response = blManager.getMandalYuvakList(mandal_id);
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
          Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName());
          Logger.logInfo(MODULE, "Parameters are : sabha_id-"+sabha_id);
          
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
        Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName());
        Logger.logInfo(MODULE, "Parameters are : sabha_id-"+sabha_id+",mandal_id-"+mandal_id);
        
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
          Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName());
          try {
              response = blManager.createYuvakSabhaAttendance(request);
          } catch (NumberFormatException ne) {
              return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
          }
          return response;
	}
    
    
    @POST
    @Path(QueryUrlNameConstant.uploadFile)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFiles(@Context HttpServletRequest request, @Context ServletContext context) {

      File dir = AkdmUtils.getWorkingDir(context);
      List<String> uploaded = new ArrayList<String>();
      List<String> uploadedFileNames = new ArrayList<String>();
      
      Logger.logDebug(MODULE,"request Content Type:-"+request.getContentType());

      // checks whether there is a file upload request or not
      if (ServletFileUpload.isMultipartContent(request)) {
        final FileItemFactory factory = new DiskFileItemFactory();
        final ServletFileUpload fileUpload = new ServletFileUpload(factory);
        try {
          /*
           * parseRequest returns a list of FileItem but in old (pre-java5) style
           */
          // final List items = fileUpload.parseRequest(request);

          FileItemIterator iter = fileUpload.getItemIterator(request);

          while (iter.hasNext()) {
            final FileItemStream item = iter.next();
            final String itemName = item.getName();
            final String fieldName = item.getFieldName();

            uploadedFileNames.add(fieldName);
            InputStream stream = item.openStream();

            if (item.isFormField()) {
            	Logger.logDebug(MODULE,"Field Name: " + fieldName + ", andidate Name: "
                  + Streams.asString(stream));
            } else {
             Logger.logDebug(MODULE,"File field " + fieldName + " with file name " + item.getName()
                  + " detected.");

              final File targetFile =
                  new File(dir.getPath() + File.separator + itemName.toLowerCase());

              OutputStream outStream = new FileOutputStream(targetFile);
              byte[] buffer = new byte[8 * 1024];
              int bytesRead;
              while ((bytesRead = stream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
              }
              IOUtils.closeQuietly(stream);
              IOUtils.closeQuietly(outStream);
              uploaded.add(dir.getPath() + File.separator + itemName.toLowerCase());
            }
          }
        } catch (FileUploadException e) {
            return new Response(ResultCode.INTERNAL_ERROR_500.code,e.getMessage(), null , null, null);

        } catch (Exception e) {
            return new Response(ResultCode.INTERNAL_ERROR_500.code,e.getMessage(), null , null, null);

        }finally {
			
		}
      }
      return new Response(ResultCode.SUCCESS_200.code,"Successfully uploaded file",null,null, uploadedFileNames);
    }
    

	@POST
	@Path(QueryUrlNameConstant.uploadAndRead)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadAndReadFile(@Context HttpServletRequest request, @Context ServletContext context) {

		UserServiceImpl blManager = new UserServiceImpl();
		Logger.logInfo(MODULE, "Method called " + AkdmUtils.getMethodName());

		File dir = AkdmUtils.getWorkingDirForUploadExcelFile(context);
		List<String> uploaded = new ArrayList<String>();
		String itemName = "";
		String fieldName = "";

		Logger.logDebug(MODULE, "request Content Type:-" + request.getContentType());

		// checks whether there is a file upload request or not
		if (ServletFileUpload.isMultipartContent(request)) {
			final FileItemFactory factory = new DiskFileItemFactory();
			final ServletFileUpload fileUpload = new ServletFileUpload(factory);
			try {

				/*
				 * parseRequest returns a list of FileItem but in old
				 * (pre-java5) style
				 */
				// final List items = fileUpload.parseRequest(request);

				FileItemIterator iter = fileUpload.getItemIterator(request);

				while (iter.hasNext()) {
					final FileItemStream item = iter.next();
					itemName = item.getName();
					fieldName = item.getFieldName();
					InputStream stream = item.openStream();

					if (item.isFormField()) {
						Logger.logDebug(MODULE,
								"Field Name: " + fieldName + ", andidate Name: " + Streams.asString(stream));
					} else {
						Logger.logDebug(MODULE,
								"File field " + fieldName + " with file name " + item.getName() + " detected.");

						final File targetFile = new File(dir.getPath() + File.separator + itemName.toLowerCase());

						OutputStream outStream = new FileOutputStream(targetFile);
						byte[] buffer = new byte[8 * 1024];
						int bytesRead;
						while ((bytesRead = stream.read(buffer)) != -1) {
							outStream.write(buffer, 0, bytesRead);
						}
						IOUtils.closeQuietly(stream);
						IOUtils.closeQuietly(outStream);
						uploaded.add(dir.getPath() + File.separator + itemName.toLowerCase());
					}
				}
			} catch (FileUploadException e) {
				return new Response(ResultCode.INTERNAL_ERROR_500.code, e.getMessage(), null, null, null);

			} catch (Exception e) {
				return new Response(ResultCode.INTERNAL_ERROR_500.code, e.getMessage(), null, null, null);

			} finally {

			}
		}
		return blManager.uploadDataByExcel(dir.getPath() + File.separator + itemName.toLowerCase());
	}
}
