package com.test.ws.utils;

import com.test.ws.constant.ResultCode;
import com.test.ws.exception.BusinessException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;


public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {


    @Override
    public Response toResponse(BusinessException e) {
        com.test.ws.requestobject.Response responseObject = new com.test.ws.requestobject.Response(ResultCode.INTERNAL_ERROR_500.code
                ,ResultCode.INTERNAL_ERROR_500.name,null,e.getMessage(),null);
            Response.ResponseBuilder r = Response.status(Response.Status.BAD_REQUEST);
        r.type(MediaType.APPLICATION_JSON);
        r.entity(responseObject);
        return r.build();
    }
}
