package com.test.ws.service.intrf;

import java.text.ParseException;

import com.test.ws.exception.CommandException;
import com.test.ws.requestobject.Response;

public interface LoginService {

	Response validateLogin(String email, String password) throws CommandException, ParseException;

    Response getBirthday(String cakeId) throws CommandException;

    Response getSSP();

    Response getManadal();

    Response getArea();

    Response doCreateSabha();

    Response getSabhaDetails();
}
