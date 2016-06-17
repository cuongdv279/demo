package com.projecttlc.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Topic_User {

    private Posts post_ID;
    private Users user_ID;
    private Date date_Join;
    private int status;
    public Topic_User() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Topic_User(Posts post_ID, Users user_ID, Date date_Join, int status) {
        super();
        this.post_ID = post_ID;
        this.user_ID = user_ID;
        this.date_Join = date_Join;
        this.status = status;
    }
    public Posts getPost_ID() {
        return post_ID;
    }
    public void setPost_ID(Posts post_ID) {
        this.post_ID = post_ID;
    }
    public Users getUser_ID() {
        return user_ID;
    }
    public void setUser_ID(Users user_ID) {
        this.user_ID = user_ID;
    }
    public Date getDate_Join() {
        return date_Join;
    }
    public void setDate_Join(String date_join) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date;
        String arrdate[] ;
        if(date_join == null) {
            arrdate = new String[1];
        } else {
            arrdate = date_join.split("/");
        }
        String dateFormat;
        if(arrdate.length > 1) {
            dateFormat = arrdate[2]+"-"+arrdate[1]+"-"+arrdate[0];
            try {
                date = sdf.parse(dateFormat);
                java.sql.Date sqlStartDate = new Date(date.getTime());
                this.date_Join = sqlStartDate;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if(date_join == null){
            date = null;
            this.date_Join = (Date) date;
        } else {
            dateFormat = date_join;
            try {
                date = sdf.parse(dateFormat);
                java.sql.Date sqlStartDate = new Date(date.getTime());
                this.date_Join = sqlStartDate;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
