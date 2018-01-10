package com.test.ws.datamanager.intrf;

import java.util.List;

import com.test.ws.entities.UsersFieldData;
import com.test.ws.exception.CommandException;
import com.test.ws.requestobject.LoginResponse;
import com.test.ws.requestobject.Response;

public interface LoginDao {
	public LoginResponse validateLogin(String email, String password) throws CommandException;

	public List<UsersFieldData> getUserContactList() throws CommandException;

	public List<UsersFieldData> getBirthday(String cakeId) throws CommandException;

    Response getSSP();

	Response getArea();

	Response getManadal();

	Response doCreateSabha();

	Response getSabhaDetails();
}
