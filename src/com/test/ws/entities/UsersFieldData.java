package com.test.ws.entities;

import java.sql.Date;

public class UsersFieldData {

    private Long id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String whatsapp_number;
    private boolean email_verified;
    private String user_image;
    private double latitude;
    private double longitude;
    private String address;
    private int area_id;
    private int mandal_id;
    private String auth_token;
    private String relationship_status;
    private int device_type;
    private boolean status;
    private String device_token;
    private int badge_count;
    private Date created_at;
    private Date updated_at;
    private Date birth_date;
    private int role_id;
    private String role_name;
    private String area_title;
    private String mandal_title;


    public int getRole_id(){
        return role_id;
    }

    public void setRole_id(int role_id){
        this.role_id=role_id;
    }

    public String getFirst_name(){
        return first_name;
    }

    public void setFirst_name(String first_name){
        this.first_name=first_name;
    }

    public String getMiddle_name(){
        return middle_name;
    }

    public void setMiddle_name(String middle_name){
        this.middle_name=middle_name;
    }

    public String getLast_name(){
        return last_name;
    }

    public void setLast_name(String last_name){
        this.last_name=last_name;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username=username;
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

    public double getLatitude(){
        return latitude;
    }

    public void setLatitude(double latitude){
        this.latitude=latitude;
    }

    public double getLongitude(){
        return longitude;
    }

    public void setLongitude(double longitude){
        this.longitude=longitude;
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

    public String getAuth_token(){
        return auth_token;
    }

    public void setAuth_token(String auth_token){
        this.auth_token=auth_token;
    }

    public String getRelationship_status(){
        return relationship_status;
    }

    public void setRelationship_status(String relationship_status){
        this.relationship_status=relationship_status;
    }

    public int getDevice_type(){
        return device_type;
    }

    public void setDevice_type(int device_type){
        this.device_type=device_type;
    }

    public String getDevice_token(){
        return device_token;
    }

    public void setDevice_token(String device_token){
        this.device_token=device_token;
    }

    public int getBadge_count(){
        return badge_count;
    }

    public void setBadge_count(int badge_count){
        this.badge_count=badge_count;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getEmail_verified() {
        return email_verified;
    }

    public void setEmail_verified(boolean email_verified) {
        this.email_verified = email_verified;
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
}
