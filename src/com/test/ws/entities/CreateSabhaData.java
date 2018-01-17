package com.test.ws.entities;

public class CreateSabhaData {
	
	private Long user_id;
	private String user_uniqueid;
	private Boolean is_Attended;
	private String user_name;
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getUser_uniqueid() {
		return user_uniqueid;
	}
	public void setUser_uniqueid(String user_uniqueid) {
		this.user_uniqueid = user_uniqueid;
	}
	public Boolean getIs_Attended() {
		return is_Attended;
	}
	public void setIs_Attended(Boolean is_Attended) {
		this.is_Attended = is_Attended;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	@Override
	public String toString() {
		return "CreateSabhaData [user_id=" + user_id + ", user_uniqueid=" + user_uniqueid + ", is_Attended="
				+ is_Attended + ", user_name=" + user_name + "]";
	}
}
