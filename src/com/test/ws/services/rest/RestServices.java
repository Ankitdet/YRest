package com.test.ws.services.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;

import com.test.ws.constant.ResultCode;
import com.test.ws.exception.BusinessException;
import com.test.ws.exception.CommandException;
import com.test.ws.logger.Logger;
import com.test.ws.requestobject.Response;
import com.test.ws.service.impl.LoginServiceImpl;
import com.test.ws.utils.HibernateUtil;
import com.test.ws.utils.ReadWriteExcel;

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
        Logger.logInfo(MODULE, "Method called getBirthday() of "+CLASS);

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

/*    @POST
    @Path("/")
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
    }*/
    
    /** 
     * To demonstrate Accept Object and convert Into LinkedHashMap<?,?>
     * 
     * */
    @POST
    @Path("/takeSimpleObject")
    public Response takeRequest(Object obj) {
        LoginServiceImpl blManager = new LoginServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called getSabhaDetails() of " + CLASS);
        try {
           // response = blManager.getSabhaDetails();
        	ObjectMapper mapper = new ObjectMapper();
			try {
				String mapToJson = mapper.writeValueAsString(obj);
				Map<String, Object> map = new HashMap<String, Object>();
				map = mapper.readValue(mapToJson, new TypeReference<Map<String, String>>(){});
				System.out.println(map);
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } catch (NumberFormatException ne) {
            return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, "Can't convert from String", null);
        }
        return response;
    }
    
    @POST
    @Path("/uplodaData")
    public String uploadTranslationCSV() {
		
    	List<Object[]> list = ReadWriteExcel.getExcelSheetData();
    	
    	Session session = HibernateUtil.getSessionFactory().openSession();
		PreparedStatement ps = null;
		Statement st = null;
		int failedDataConunt = 0;
		int successDataCount = 0;

		try {
			SessionImplementor sessImpl = (SessionImplementor) session;
			Connection connection = sessImpl.connection();
			connection.setAutoCommit(false);
			st = connection.createStatement();


			// batch insert

			String sql = "INSERT INTO users(ROLE_ID,FIRST_NAME,MIDDLE_NAME,LAST_NAME,USERNAME,EMAIL,PASSWORD,PHONE,WHATSAPP_NUMBER,EMAIL_VERIFIED,BIRTH_DATE,USER_IMAGE,LATITUDE,LONGITUDE,ADDRESS,AREA_ID,MANDAL_ID,AUTH_TOKEN,RELATIONSHIP_STATUS,CREATED_AT,UPDATED_AT,STATUS,DEVICE_TYPE,DEVICE_TOKEN,BADGE_COUNT) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			for (Object[] newData : list) {
				if (newData != null) {
					
					ps.setInt(1, 3);
					ps.setString(2, (String)newData[0]);
					ps.setString(3, "");
					ps.setString(4, "");
					ps.setString(5, ((String)newData[0]).toLowerCase());
					ps.setString(6, ((String)newData[0]).toLowerCase() + "@gmail.com");
					ps.setString(7, ((String)newData[0]).toLowerCase());
					
					String phno = String.valueOf((String)newData[2]).replace("+", "");
					ps.setString(8, phno);
					
					String Whatsapp = String.valueOf((String)newData[3]).replace("+", "");
					ps.setString(9, Whatsapp);
					ps.setInt(10, 1);
					
					String str = (String)newData[5];
					ps.setTimestamp(11,simpleDateFormat(newData[5]));
					
					ps.setInt(12, 0);
					ps.setInt(13, 0);
					ps.setInt(14, 0);
					ps.setString(15, (String)newData[6]);
					ps.setInt(16, 5);
					ps.setInt(17, 6);
					ps.setString(18, "c6afb0c3d6da4caea486f3df36a9436a");
					ps.setInt(19, 0);
					ps.setTimestamp(20, getFormatedDate());
					ps.setTimestamp(21, getFormatedDate());
					ps.setInt(22, 0);
					ps.setInt(23, 0);
					ps.setInt(24, 0);
					ps.setInt(25, 0);
					
					ps.addBatch();
					successDataCount++;
					if (successDataCount % 100 == 0) {
						ps.executeBatch();
					}
				}
			}
			ps.executeBatch();
		} catch (BatchUpdateException e) {
			int[] updateCounts = e.getUpdateCounts();
			Logger.logDebug(MODULE, "UpdateCounts :" + updateCounts.length);
			throw new BusinessException("Upload Translation Mapping Data Failed, Reason " + e.getMessage());
		} catch (HibernateException hExp) {
			throw new BusinessException(hExp.getMessage(), hExp);
		} catch (Exception exp) {
			throw new BusinessException(exp.getMessage(), exp);
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (st != null)
					st.close();
			} catch (SQLException sExp) {
				//throw new DataManagerException(sExp.getMessage(), sExp);
			}
		}
		return "Inserted Record:" +successDataCount + "\nSkipped Record:" +failedDataConunt;
	}
    
    private Timestamp getFormatedDate() {
        java.util.Date date = new java.util.Date();
        return new Timestamp(date.getTime());
    }
    private Timestamp simpleDateFormat(Object obj) throws ParseException{
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		Timestamp ts = new Timestamp(((java.util.Date)df.parse((String)obj)).getTime());
		return ts;
    }
    
}
