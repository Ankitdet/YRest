package com.test.ws.datamanager.intrf;

import java.util.List;

import com.test.ws.entities.AttendanceRequest;
import com.test.ws.entities.CreateSabhaData;
import com.test.ws.entities.Mandals;
import com.test.ws.entities.SabhaData;
import com.test.ws.entities.UsersFieldData;
import com.test.ws.exception.CommandException;
import com.test.ws.requestobject.LoginResponse;
import com.test.ws.requestobject.Response;

public interface UserDao {
	public List<UsersFieldData> validateLogin(String email, String password) throws CommandException;

	public List<UsersFieldData> getUserContactList() throws CommandException;

	public List<UsersFieldData> getBirthday(String cakeId) throws CommandException;

    Response getSSP();

	Response getArea();

	Response getManadal();

	Response doCreateSabha(SabhaData sabhaData);

	Response getSabhaDetails();

	public Response uploadDataByExcel(List<Object[]> list);

	public List<UsersFieldData> getMandalYuvakList(Integer mandal_id);

	public List<UsersFieldData> getYuvakProfile(Integer user_id);


	public List<Mandals> getSabhaMandalList(Integer sabha_id);

	public List<CreateSabhaData> getSabhaYuvakList(Integer sabha_id, Integer mandal_id);

	public Response createYuvakSabhaAttendance(AttendanceRequest request);
}
