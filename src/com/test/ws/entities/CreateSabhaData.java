package com.test.ws.entities;

public class CreateSabhaData {
	
	private Long user_id;
	private Long sabha_id;
	private Boolean is_Attended;
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getSabhaId() {
		return sabha_id;
	}
	public void setSabhaId(Long user_uniqueid) {
		this.sabha_id = user_uniqueid;
	}
	public Boolean getIs_Attended() {
		return is_Attended;
	}
	public void setIs_Attended(Boolean is_Attended) {
		this.is_Attended = is_Attended;
	}
	@Override
	public String toString() {
		return "CreateSabhaData [user_id=" + user_id + ", user_uniqueid=" + sabha_id + ", is_Attended="
				+ is_Attended + "]";
	}
}
