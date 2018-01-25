package com.test.ws.entities;

import java.sql.Date;
import java.sql.Timestamp;

public class SabhaData {
	
	private Long id;
	private Integer mandal_id;
	private Date sabha_date;
	private String sabha_title;
	private String start_time;
	private String end_time;
	private Integer status;
	private Date created_date;
	private Date updated_date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getMandal_id() {
		return mandal_id;
	}
	public void setMandal_id(Integer mandal_id) {
		this.mandal_id = mandal_id;
	}
	public Date getSabha_date() {
		return sabha_date;
	}
	public void setSabha_date(Date sabha_date) {
		this.sabha_date = sabha_date;
	}
	public String getSabha_title() {
		return sabha_title;
	}
	public void setSabha_title(String sabha_title) {
		this.sabha_title = sabha_title;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public Integer isStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}
	@Override
	public String toString() {
		return "SabhaData [id=" + id + ", mandal_id=" + mandal_id + ", sabha_date=" + sabha_date + ", sabha_title="
				+ sabha_title + ", start_time=" + start_time + ", end_time=" + end_time + ", status=" + status
				+ ", created_date=" + created_date + ", updated_date=" + updated_date + "]";
	}
	
}
