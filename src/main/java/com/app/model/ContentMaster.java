package com.app.model;

public class ContentMaster {

    private Integer id;

    private String catagoryId;

    private String catagoryName;

    private String codeId;

    private String codeName;

    private String codeNameImg;

    private Integer orderBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(String catagoryId) {
        this.catagoryId = catagoryId;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public String getCodeNameImg() {
        return codeNameImg;
    }

    public void setCodeNameImg(String codeNameImg) {
        this.codeNameImg = codeNameImg;
    }
}
