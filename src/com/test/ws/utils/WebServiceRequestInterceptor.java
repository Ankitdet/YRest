package com.test.ws.utils;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.MDC;

import com.test.ws.constant.QueryUrlNameConstant;
import com.test.ws.exception.BusinessException;
import com.test.ws.logger.Logger;

@Provider
@PreMatching
public class WebServiceRequestInterceptor implements ContainerRequestFilter {

    public static final String MODULE = WebServiceRequestInterceptor.class.getSimpleName();

    @Override
    public void filter(ContainerRequestContext request) throws IOException {

    	MDC.put("start-time", String.valueOf(System.currentTimeMillis()));
        String token = request.getHeaderString("token");
        Logger.logInfo(MODULE, "Method called filter() with token :"+ token);
        final java.net.URI absolutePath = request.getUriInfo().getAbsolutePath();
        String path = absolutePath.getPath();
        Logger.logInfo(MODULE, "URL called :" + path);
        
        String calledURL = path.substring(path.lastIndexOf("/"), path.length());
        checkParameter(request.getUriInfo(),calledURL);
        
        if (!path.contains("/login")) {
            if(token == null){
                throw new BusinessException("Bad login request !");
            }
            if(TokenGenerator.tokenMap.get(token) == null || TokenGenerator.tokenMap.get(token) == "")
                throw new BusinessException("Token has expired !");
        }
    }
    
	public void checkParameter(@Context UriInfo uriInfo,String calledURL) {

		if(!QueryUrlNameConstant.queryParam.containsKey(calledURL)){
			return ;
		}

		String queryParamName = QueryUrlNameConstant.queryParam.get(calledURL);
		MultivaluedMap<String, String> params = uriInfo.getQueryParameters();
		
		if(queryParamName != null && !"".equals(queryParamName)){
			String[] seperateParam = queryParamName.split(",");
			for(String str : seperateParam){
				if(!params.containsKey(str)){
					throw new BusinessException("query parameter "+str+" is missing.");
				}
			}
			
			for (String str : params.keySet()) {
				Object object = (String) params.getFirst(str);
				if (object == null || "".equals(object)) {
					throw new BusinessException("query parameter "+str+" is blank or not set.");
				}
			}
		}
	}
}
