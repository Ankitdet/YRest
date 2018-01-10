package com.test.ws.entities;

// Generated Jan 1, 2018 2:31:13 PM by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Attendance generated by hbm2java
 */
@Entity
@Table(name = "attendance", catalog = "xboxlive_akdm")
public class Attendance implements java.io.Serializable {

	private AttendanceId id;

	public Attendance() {
	}

	public Attendance(AttendanceId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "attendanceId", column = @Column(name = "attendance_id", nullable = false)),
			@AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false)),
			@AttributeOverride(name = "sabhaId", column = @Column(name = "sabha_id", nullable = false)),
			@AttributeOverride(name = "isAttended", column = @Column(name = "is_attended", nullable = false)) })
	public AttendanceId getId() {
		return this.id;
	}

	public void setId(AttendanceId id) {
		this.id = id;
	}

}
