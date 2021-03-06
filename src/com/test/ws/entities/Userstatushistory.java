package com.test.ws.entities;

// Generated Jan 1, 2018 2:31:13 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Userstatushistory generated by hbm2java
 */
@Entity
@Table(name = "userstatushistory", catalog = "xboxlive_akdm")
public class Userstatushistory implements java.io.Serializable {

	private long historyId;
	private String username;
	private String resource;
	private String lastIpAddress;
	private String lastLoginDate;
	private String lastLogoffDate;

	public Userstatushistory() {
	}

	public Userstatushistory(long historyId, String username, String resource,
			String lastIpAddress, String lastLoginDate, String lastLogoffDate) {
		this.historyId = historyId;
		this.username = username;
		this.resource = resource;
		this.lastIpAddress = lastIpAddress;
		this.lastLoginDate = lastLoginDate;
		this.lastLogoffDate = lastLogoffDate;
	}

	@Id
	@Column(name = "historyID", unique = true, nullable = false)
	public long getHistoryId() {
		return this.historyId;
	}

	public void setHistoryId(long historyId) {
		this.historyId = historyId;
	}

	@Column(name = "username", nullable = false, length = 64)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "resource", nullable = false, length = 64)
	public String getResource() {
		return this.resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	@Column(name = "lastIpAddress", nullable = false, length = 15)
	public String getLastIpAddress() {
		return this.lastIpAddress;
	}

	public void setLastIpAddress(String lastIpAddress) {
		this.lastIpAddress = lastIpAddress;
	}

	@Column(name = "lastLoginDate", nullable = false, length = 15)
	public String getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@Column(name = "lastLogoffDate", nullable = false, length = 15)
	public String getLastLogoffDate() {
		return this.lastLogoffDate;
	}

	public void setLastLogoffDate(String lastLogoffDate) {
		this.lastLogoffDate = lastLogoffDate;
	}

}
