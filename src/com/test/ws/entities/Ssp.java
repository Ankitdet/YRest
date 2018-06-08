package com.test.ws.entities;

// Generated Jan 1, 2018 2:31:13 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Ssp generated by hbm2java
 */
@Entity
public class Ssp implements java.io.Serializable {

	@JsonProperty("sspId")
	private Integer sspId;

	@JsonProperty("sspTitle")
	private String sspTitle;

	public Ssp() {
	}

	public Ssp(String sspTitle) {
		this.sspTitle = sspTitle;
	}


	public Integer getSspId() {
		return this.sspId;
	}

	public void setSspId(Integer sspId) {
		this.sspId = sspId;
	}

	@Column(name = "ssp_title", nullable = false)
	public String getSspTitle() {
		return this.sspTitle;
	}

	public void setSspTitle(String sspTitle) {
		this.sspTitle = sspTitle;
	}

}
