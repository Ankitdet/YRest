package com.test.ws.datamanager.intrf;

import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONObject;

import com.test.ws.entities.AttendanceRequest;
import com.test.ws.entities.CreateSabhaData;
import com.test.ws.entities.MandalYuvak;
import com.test.ws.entities.SabhaData;
import com.test.ws.entities.Ssp;
import com.test.ws.entities.UsersFieldData;
import com.test.ws.exception.CommandException;
import com.test.ws.requestobject.Response;

public interface UserDao {
	public List<UsersFieldData> validateLogin(String email, String password) throws CommandException;

	public List<UsersFieldData> getUserContactList() throws CommandException;
	
	public List<UsersFieldData> getYuvakList() throws CommandException;
	
	public Response getBirthday(String cakeId) throws CommandException;

    Response getSSP();

	Response getArea();

	Response getManadal();

	Response doCreateSabha(SabhaData sabhaData);

	Response getSabhaDetails();

	public Response uploadDataByExcel(List<Object[]> list);

	public List<MandalYuvak> getMandalYuvakList(Integer mandal_id);

	public List<UsersFieldData> getYuvakProfile(Integer user_id);


	public Response getSabhaMandalList(Integer sabha_id);

	public List<CreateSabhaData> getSabhaYuvakList(Integer sabha_id, Integer mandal_id);

	public Response createYuvakSabhaAttendance(AttendanceRequest request);

	public Response registerYuvakDetail(UsersFieldData userFieldsData)  throws CommandException;

	public Response getExtraData()  throws CommandException;

	public Response getDependentData()  throws CommandException;
}
