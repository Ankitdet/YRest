package com.test.ws.requestobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginResponse {

	private String uId;
	private String uType;
	private String uTypeName;
	private String token;
	private String email;
	private String firstName;
	private String middleName;
	private String lastName;


	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuType() {
		return uType;
	}
	public void setuType(String uType) {
		this.uType = uType;
	}
	public String getuTypeName() {
		return uTypeName;
	}
	public void setuTypeName(String uTypeName) {
		this.uTypeName = uTypeName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
