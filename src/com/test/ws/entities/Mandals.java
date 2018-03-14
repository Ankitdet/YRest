package com.test.ws.entities;

public class Mandals  {

	private Integer mandalId;
	private String mandalTitle;
	private Integer total_yuvak;

	
	public Integer getTotal_yuvak() {
		return total_yuvak;
	}

	public void setTotal_yuvak(Integer total_yuvak) {
		this.total_yuvak = total_yuvak;
	}

	public Mandals() {
	}

	public Mandals(String mandalTitle) {
		this.mandalTitle = mandalTitle;
	}

	public Integer getMandalId() {
		return this.mandalId;
	}

	public void setMandalId(Integer mandalId) {
		this.mandalId = mandalId;
	}

	public String getMandalTitle() {
		return this.mandalTitle;
	}

	public void setMandalTitle(String mandalTitle) {
		this.mandalTitle = mandalTitle;
	}

}
