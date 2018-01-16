package com.test.ws.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YuAttendance {

	private Long yuvak_id;
	private boolean is_attended;
	
	public Long getYuvak_id() {
		return yuvak_id;
	}
	public void setYuvak_id(Long yuvak_id) {
		this.yuvak_id = yuvak_id;
	}
	public boolean isIs_attended() {
		return is_attended;
	}
	public void setIs_attended(boolean is_attendence) {
		this.is_attended = is_attendence;
	}
	@Override
	public String toString() {
		return "YuAttendance [yuvak_id=" + yuvak_id + ", is_attended=" + is_attended + "]";
	}
}
