package com.test.ws.entities;

import java.sql.Date;
import java.sql.Timestamp;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.joda.time.DateTime;


public class UsersFieldData  implements Comparable<UsersFieldData>{

    private Long id;
    private String user_name;
    private String email;
    private String password;
    private String phone;
    private String l_name;
    private String f_name;
    private String m_name;
    private String whatsapp_number;
    private String user_image;
    private String address;
    private int area_id;
    private int mandal_id;
    public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	@JsonIgnore
	private int badge_count;
    private String created_at;
    private String updated_at;
    private String birth_date;
    private int role_id;
    private String role_name;
    private String area_title;
    private String mandal_title;
    private String attendance;
    
    // red_chief

    public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}

	public int getRole_id(){
        return role_id;
    }

    public void setRole_id(int role_id){
        this.role_id=role_id;
    }


    public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone=phone;
    }

    public String getWhatsapp_number(){
        return whatsapp_number;
    }

    public void setWhatsapp_number(String whatsapp_number){
        this.whatsapp_number=whatsapp_number;
    }

    public String getUser_image(){
        return user_image;
    }

    public void setUser_image(String user_image){
        this.user_image=user_image;
    }


    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public int getArea_id(){
        return area_id;
    }

    public void setArea_id(int area_id){
        this.area_id=area_id;
    }

    public int getMandal_id(){
        return mandal_id;
    }

    public void setMandal_id(int mandal_id){
        this.mandal_id=mandal_id;
    }


    public int getBadge_count(){
        return badge_count;
    }

    public void setBadge_count(int badge_count){
        this.badge_count=badge_count;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getArea_title() {
        return area_title;
    }

    public void setArea_title(String area_title) {
        this.area_title = area_title;
    }

    public String getMandal_title() {
        return mandal_title;
    }

    public void setMandal_title(String mandal_title) {
        this.mandal_title = mandal_title;
    }

	@Override
	public int compareTo(UsersFieldData o) {
		return this.getArea_title().compareTo(o.getArea_title());
	}
}
