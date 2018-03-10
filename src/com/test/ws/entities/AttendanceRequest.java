package com.test.ws.entities;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class AttendanceRequest {

	private Integer sabha_id;
	private Integer mandal_id;
	
	@JsonProperty(value="data")
	private List<YuAttendance> data;
	
	public Integer getSabha_id() {
		return sabha_id;
	}
	public void setSabha_id(Integer sabha_id) {
		this.sabha_id = sabha_id;
	}
	public Integer getMandal_id() {
		return mandal_id;
	}
	public void setMandal_id(Integer mandal_id) {
		this.mandal_id = mandal_id;
	}
	public List<YuAttendance> getListOfAttendance() {
		return data;
	}
	public void setListOfAttendance(List<YuAttendance> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "AttendanceRequest [sabha_id=" + sabha_id + ", mandal_id=" + mandal_id + ", listOfAttendance="
				+ data + "]";
	}
}
