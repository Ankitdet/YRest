package com.test.ws.entities;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class AttendanceRequest {

	private Long sabha_id;
	private Long mandal_id;
	
	@JsonProperty(value="data")
	private List<YuAttendance> data;
	
	public Long getSabha_id() {
		return sabha_id;
	}
	public void setSabha_id(Long sabha_id) {
		this.sabha_id = sabha_id;
	}
	public Long getMandal_id() {
		return mandal_id;
	}
	public void setMandal_id(Long mandal_id) {
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
