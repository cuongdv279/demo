package com.projecttlc.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Users {

    private int user_ID;
    private String first_Name;
    private String last_Name;
    private int gender;
    private String email;
    private String password;
    private String user_Role;
    private Date activation_Date;
    private String avatar;
    private String address;
    private String phone_Number;
    private Date birthday;
    private String job;
    private String country;
    private String website;
    private int status;


    //    Contructor
    
    public Users(int user_ID, String first_Name, String last_Name, int gender,
            String email, String password, String user_Role, Date activation_Date,
            String avatar, String address, String phone_Number, Date birthday,
            String job, String country, String website,int status) {
        super();
        this.user_ID = user_ID;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.user_Role = user_Role;
        this.activation_Date = activation_Date;
        this.avatar = avatar;
        this.address = address;
        this.phone_Number = phone_Number;
        this.birthday = birthday;
        this.job = job;
        this.country = country;
        this.website = website;
        this.status = status;
    }
    
    public Users() {
       
    }

    public int getUser_ID() {
        return user_ID;
    }
    
    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }
    public String getFirst_Name() {
        return first_Name;
    }
    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }
    public String getLast_Name() {
        return last_Name;
    }
    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }
    public int getGender() {
        return gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUser_Role() {
        return user_Role;
    }
    public void setUser_Role(String user_Role) {
        this.user_Role = user_Role;
    }
    public Date getActivation_Date() {
        return activation_Date;
    }
    public void setActivation_Date(String activation_Date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date;
        String arrdate[] ;
        if(activation_Date == null) {
            arrdate = new String[1];
        } else {
            arrdate = activation_Date.split("/");
        }
        String dateFormat;
        if(arrdate.length > 1) {
            dateFormat = arrdate[2]+"-"+arrdate[1]+"-"+arrdate[0];
            try {
                date = sdf.parse(dateFormat);
                java.sql.Date sqlStartDate = new Date(date.getTime());
                this.activation_Date = sqlStartDate;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if(activation_Date == null){
            date = null;
            this.activation_Date = (Date) date;
        } else {
            dateFormat = activation_Date;
            try {
                date = sdf.parse(dateFormat);
                java.sql.Date sqlStartDate = new Date(date.getTime());
                this.activation_Date = sqlStartDate;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone_Number() {
        return phone_Number;
    }
    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date;
        String arrdate[] ;
        if(birthday == null) {
            arrdate = new String[1];
        } else {
            arrdate = birthday.split("/");
        }
        String dateFormat;
        if(arrdate.length > 1) {
            dateFormat = arrdate[2]+"-"+arrdate[1]+"-"+arrdate[0];
            try {
                date = sdf.parse(dateFormat);
                java.sql.Date sqlStartDate = new Date(date.getTime());
                this.birthday = sqlStartDate;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if(birthday == null){
            date = null;
            this.birthday = (Date) date;
        } else {
            dateFormat = birthday;
            try {
                date = sdf.parse(dateFormat);
                java.sql.Date sqlStartDate = new Date(date.getTime());
                this.birthday = sqlStartDate;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
