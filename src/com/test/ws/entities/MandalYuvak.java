package com.test.ws.entities;

import java.util.Arrays;

public class MandalYuvak {

	private String name ;
	private String image;
	private String sector;
	private Integer user_id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "MandalYuvak [name=" + name + ", image="
				+ (image) + ", sector=" + sector + ", user_id="
				+ user_id + "]";
	}
	
	
	
}
