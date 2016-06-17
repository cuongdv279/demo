package com.projecttlc.model;

public class Categories {
    private Integer cateId;
    private String cateName;
    private String cateDesc;
//  ---------   Contructor  ---------    
    public Categories(){
        
    }
    
    public Categories(Integer cateId, String cateName, String cateDesc) {
        super();
        this.cateId = cateId;
        this.cateName = cateName;
        this.cateDesc = cateDesc;
    }
//  ---------   End Contructor  ---------
    public Integer getCateId() {
        return cateId;
    }
    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }
    public String getCateName() {
        return cateName;
    }
    public void setCateName(String cateName) {
        this.cateName = cateName;
    }
    public String getCateDesc() {
        return cateDesc;
    }
    public void setCateDesc(String cateDesc) {
        this.cateDesc = cateDesc;
    }
    
}