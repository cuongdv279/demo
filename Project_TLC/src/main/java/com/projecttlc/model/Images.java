package com.projecttlc.model;

import java.sql.Date;

public class Images {
    private Integer imageId;
    private String imageName;
    private String imageGuid;
    private String imageDesc;
    private Date uploadDate;
//-----------    Contructor    ---------------------
    public Images(Integer imageId, String imageName, String imageGuid,
            String imageDesc, Date uploadDate) {
        super();
        this.imageId = imageId;
        this.imageName = imageName;
        this.imageGuid = imageGuid;
        this.imageDesc = imageDesc;
        this.uploadDate = uploadDate;
    }
    public Images() {
        
    }
//----------    end Contructor  ---------------------
    public Integer getImageId() {
        return imageId;
    }
    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }
    public String getImageName() {
        return imageName;
    }
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    public String getImageGuid() {
        return imageGuid;
    }
    public void setImageGuid(String imageGuid) {
        this.imageGuid = imageGuid;
    }
    public Date getUploadDate() {
        return uploadDate;
    }
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
    public String getImageDesc() {
        return imageDesc;
    }
    public void setImageDesc(String imageDesc) {
        this.imageDesc = imageDesc;
    }
    
}
