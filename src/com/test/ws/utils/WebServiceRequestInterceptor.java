package com.test.ws.utils;

import com.test.ws.exception.BusinessException;
import com.test.ws.logger.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

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
                throw new BusinessException("Token is null! Please send valid token.");
            }

            if(TokenGenerator.tokenMap.get(token) == null ||
                    TokenGenerator.tokenMap.get(token) == "")
                throw new BusinessException("Invalid token access! Login Again.");
        }
    }
}
