package com.projecttlc.model;

public class App_params {
    private Integer parId;
    private String parType;
    private String parName;
    private String parDesc;
    private int parCode;
    private int parStatus;
    private int parOrder;
    private String parColor;
//  ---------   Contructor  ---------
    public App_params() {
        
    }
    
    public App_params(Integer parId, String parType, String parName,
        String parDesc, int parCode, int parStatus, int parOrder,
        String parColor) {
    super();
    this.parId = parId;
    this.parType = parType;
    this.parName = parName;
    this.parDesc = parDesc;
    this.parCode = parCode;
    this.parStatus = parStatus;
    this.parOrder = parOrder;
    this.parColor = parColor;
    }
//  ---------   End Contructor  ---------
    public Integer getParId() {
        return parId;
    }
    public void setParId(Integer parId) {
        this.parId = parId;
    }
    public String getParType() {
        return parType;
    }
    public void setParType(String parType) {
        this.parType = parType;
    }
    public int getParCode() {
        return parCode;
    }
    public void setParCode(int parCode) {
        this.parCode = parCode;
    }
    public int getParStatus() {
        return parStatus;
    }
    public void setParStatus(int parStatus) {
        this.parStatus = parStatus;
    }
    public int getParOrder() {
        return parOrder;
    }
    public void setParOrder(int parOrder) {
        this.parOrder = parOrder;
    }
    public String getParColor() {
        return parColor;
    }
    public void setParColor(String parColor) {
        this.parColor = parColor;
    }
    public String getParName() {
        return parName;
    }
    public void setParName(String parName) {
        this.parName = parName;
    }
    public String getParDesc() {
        return parDesc;
    }
    public void setParDesc(String parDesc) {
        this.parDesc = parDesc;
    }
    
}
