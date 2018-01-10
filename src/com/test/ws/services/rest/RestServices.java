package com.test.ws.services.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.List;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import com.test.ws.constant.ResultCode;
import com.test.ws.exception.CommandException;
import com.test.ws.logger.Logger;
import com.test.ws.requestobject.Response;
import com.test.ws.service.impl.LoginServiceImpl;

@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.MULTIPART_FORM_DATA})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class RestServices {

    private static final String MODULE = "RestServices";
    private static final String UPLOAD_FOLDER = "/opt/uploadedFiles/";
    public static final String CLASS = RestServices.class.getSimpleName();

    /**
     * To get Method name
     *
     * @return
     */
    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    @POST
    @Path("/login")
    public Response login(@QueryParam("email") String email,
                          @QueryParam("password") String password)
            throws NumberFormatException, ParseException, CommandException {

        LoginServiceImpl blManager = new LoginServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called login() of "+CLASS);
        Logger.logInfo(MODULE, "Method called login() with LogLin request: "
                + email + "and " + password);

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

        LoginServiceImpl blManager = new LoginServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called getContactList()");

        try {
            response = blManager.getUserContactList();
        } catch (Exception e) {
            return new Response(ResultCode.INPUT_PARAMETER_MISSING_401.code,
                    ResultCode.INPUT_PARAMETER_MISSING_401.name, null,
                    e.getMessage(), null);
        }
        return response;
    }

    @POST
    @Path("/uploadFile")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadTextFile(List<Attachment> attachments, @Context HttpServletRequest request) throws ParseException {

        String fileName = null;
        for (Attachment attachment : attachments) {
            DataHandler dataHandler = attachment.getDataHandler();
            try {
                // get filename to be uploaded
                MultivaluedMap<String, String> multivaluedMap = attachment.getHeaders();
                fileName = getFileName(multivaluedMap);

                createFolderIfNotExists("AnkitTest");
                // write & upload file to server
                InputStream inputStream = dataHandler.getInputStream();
                saveToFile(inputStream, fileName);
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                // release resources, if any
            }
        }
        return new Response(ResultCode.SUCCESS_200.code, "File saved to " + fileName, null, null, null);
    }

    private void saveToFile(InputStream inStream, String target)
            throws IOException {
        OutputStream out = null;
        int read = 0;
        byte[] bytes = new byte[1024];
        out = new FileOutputStream(new File(target));
        while ((read = inStream.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        out.flush();
        out.close();
    }

    private void createFolderIfNotExists(String dirName)
            throws SecurityException {
        File theDir = new File(dirName);
        if (!theDir.exists()) {
            theDir.mkdir();
        }
    }

    private String getFileName(MultivaluedMap<String, String> multivaluedMap) {

        String[] contentDisposition = multivaluedMap.getFirst("Content-Disposition").split(";");
        for (String filename : contentDisposition) {

            if ((filename.trim().startsWith("filename"))) {
                String[] name = filename.split("=");
                String exactFileName = name[1].trim().replaceAll("\"", "");
                return exactFileName;
            }
        }
        return "unknownFile";
    }

    @GET
    @Path("/getBirthday")
    public Response getBirthday(@QueryParam("id") String cakeId) {
        LoginServiceImpl blManager = new LoginServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called getBirthday() of ");

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

        LoginServiceImpl blManager = new LoginServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called getSSP() of " + CLASS);
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
        LoginServiceImpl blManager = new LoginServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called getManadal() of " + CLASS);
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
        LoginServiceImpl blManager = new LoginServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called getArea() of " + CLASS);
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
        LoginServiceImpl blManager = new LoginServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called doCreateSabha() of " + CLASS);
        try {
            response = blManager.doCreateSabha();
        } catch (NumberFormatException ne) {
            return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
        }
        return response;
    }

    @POST
    @Path("/getSabhaDetails")
    public Response getSabhaDetails() {
        LoginServiceImpl blManager = new LoginServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called getSabhaDetails() of " + CLASS);
        try {
            response = blManager.getSabhaDetails();
        } catch (NumberFormatException ne) {
            return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
        }
        return response;
    }
}
