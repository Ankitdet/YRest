package com.test.ws.entities;

public class CreateSabhaData {
	
	private String yuvak_name; 
	public String getYuvak_name() {
		return yuvak_name;
	}
	public void setYuvak_name(String yuvak_name) {
		this.yuvak_name = yuvak_name;
	}
	private Long mandal_id;
	public Long getMandal_id() {
		return mandal_id;
	}
	public void setMandal_id(Long mandal_id) {
		this.mandal_id = mandal_id;
	}

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
