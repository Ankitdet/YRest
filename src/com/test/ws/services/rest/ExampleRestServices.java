package com.test.ws.services.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.test.ws.constant.ResultCode;
import com.test.ws.logger.Logger;
import com.test.ws.requestobject.Response;
import com.test.ws.service.impl.UserServiceImpl;
import com.test.ws.utils.AkdmUtils;

@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.MULTIPART_FORM_DATA})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ExampleRestServices {

    private static final String MODULE = "RestServices";
    public static final String CLASS = UserRestWS.class.getSimpleName();
    
	   /** 
     * To demonstrate Accept Object and convert Into LinkedHashMap<?,?>
     * 
     * */
    @POST
    @Path("/takeSimpleObject")
    public Response takeRequest(Object obj) {
        UserServiceImpl blManager = new UserServiceImpl();
        Response response = null;
        Logger.logInfo(MODULE, "Method called "+AkdmUtils.getMethodName()+ " of " + CLASS);

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

    
}
