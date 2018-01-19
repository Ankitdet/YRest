package com.test.ws.utils;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

import com.test.ws.exception.BusinessException;
import com.test.ws.logger.Logger;

@Provider
@PreMatching
public class WebServiceRequestInterceptor implements ContainerRequestFilter {

    public static final String MODULE = WebServiceRequestInterceptor.class.getSimpleName();

    @Override
    public void filter(ContainerRequestContext request) throws IOException {

        String token = request.getHeaderString("token");
        Logger.logInfo(MODULE, "Method called filter() with token :"+ token);
        final java.net.URI absolutePath = request.getUriInfo().getAbsolutePath();
        String path = absolutePath.getPath();
        Logger.logInfo(MODULE, "URL called :" + path);

        if (!path.contains("/login")) {

            if(token == null){
                throw new BusinessException("Token has expired! Try new...");
            }

            if(TokenGenerator.tokenMap.get(token) == null ||
                    TokenGenerator.tokenMap.get(token) == "")
                throw new BusinessException("bad login requested!");
        }
    }
}
