package com.projecttlc.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Posts_Local {
    private int post_ID;
    private String post_Name;
    private Categories cate_ID;
    private Users user_ID;
    private String post_Content;
    private Date public_Date;
    private Date last_Edit;
    private String image;
    private int num_View;
    private int status;
    
    public Posts_Local() {

    }

    public Posts_Local(int post_ID, String post_Name, Categories cate_ID,
            Users user_ID, String post_Content, Date public_Date,
            Date last_Edit, String image, int num_View, int status) {
        super();
        this.post_ID = post_ID;
        this.post_Name = post_Name;
        this.cate_ID = cate_ID;
        this.user_ID = user_ID;
        this.post_Content = post_Content;
        this.public_Date = public_Date;
        this.last_Edit = last_Edit;
        this.image = image;
        this.num_View = num_View;
        this.status = status;
    }

    public int getPost_ID() {
        return post_ID;
    }

    public void setPost_ID(int post_ID) {
        this.post_ID = post_ID;
    }

    public String getPost_Name() {
        return post_Name;
    }

    public void setPost_Name(String post_Name) {
        this.post_Name = post_Name;
    }

    public Categories getCate_ID() {
        return cate_ID;
    }

    public void setCate_ID(Categories cate_ID) {
        this.cate_ID = cate_ID;
    }

    public Users getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(Users user_ID) {
        this.user_ID = user_ID;
    }

    public String getPost_Content() {
        return post_Content;
    }

    public void setPost_Content(String post_Content) {
        this.post_Content = post_Content;
    }

    public Date getPublic_Date() {
        return public_Date;
    }

    public void setPublic_Date(String public_Date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date;
        String arrdate[] ;
        if(public_Date == null) {
            arrdate = new String[1];
        } else {
            arrdate = public_Date.split("/");
        }
        String dateFormat;
        if(arrdate.length > 1) {
            dateFormat = arrdate[2]+"-"+arrdate[1]+"-"+arrdate[0];
            try {
                date = sdf.parse(dateFormat);
                java.sql.Date sqlStartDate = new Date(date.getTime());
                this.public_Date = sqlStartDate;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if(public_Date == null){
            date = null;
            this.public_Date = (Date) date;
        } else {
            dateFormat = public_Date;
            try {
                date = sdf.parse(dateFormat);
                java.sql.Date sqlStartDate = new Date(date.getTime());
                this.public_Date = sqlStartDate;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public Date getLast_Edit() {
        return last_Edit;
    }

    public void setLast_Edit(String last_Edit) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date;
        String arrdate[] ;
        if(last_Edit == null) {
            arrdate = new String[1];
        } else {
            arrdate = last_Edit.split("/");
        }
        String dateFormat;
        if(arrdate.length > 1) {
            dateFormat = arrdate[2]+"-"+arrdate[1]+"-"+arrdate[0];
            try {
                date = sdf.parse(dateFormat);
                java.sql.Date sqlStartDate = new Date(date.getTime());
                this.last_Edit = sqlStartDate;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if(last_Edit == null){
            date = null;
            this.last_Edit = (Date) date;
        } else {
            dateFormat = last_Edit;
            try {
                date = sdf.parse(dateFormat);
                java.sql.Date sqlStartDate = new Date(date.getTime());
                this.last_Edit = sqlStartDate;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNum_View() {
        return num_View;
    }

    public void setNum_View(int num_View) {
        this.num_View = num_View;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    

}
