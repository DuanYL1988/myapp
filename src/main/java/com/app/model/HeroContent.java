package com.app.model;

public class HeroContent extends ExpandCondition {
    /**
     * PRIMARYKEY
     */
    private Integer id;

    /**
     * 類別EXISTCOL
     */
    private String categoryId;

    /**
     * 類別名
     */
    private String categoryName;

    /**
     * codeIdEXISTCOL
     */
    private String codeId;

    /**
     * code名
     */
    private String codeName;

    /**
     * 图片路径
     */
    private String imgSrc;

    /**
     * 设定PRIMARYKEY
     */
    public void setId(Integer id){
        this.id = id;
    }

    /**
     * 取得PRIMARYKEY
     */
    public Integer getId(){
        return id;
    }
    /**
     * 设定類別EXISTCOL
     */
    public void setCategoryId(String categoryId){
        this.categoryId = categoryId;
    }

    /**
     * 取得類別EXISTCOL
     */
    public String getCategoryId(){
        return categoryId;
    }
    /**
     * 设定類別名
     */
    public void setCategoryName(String categoryName){
        this.categoryName = categoryName;
    }

    /**
     * 取得類別名
     */
    public String getCategoryName(){
        return categoryName;
    }
    /**
     * 设定codeIdEXISTCOL
     */
    public void setCodeId(String codeId){
        this.codeId = codeId;
    }

    /**
     * 取得codeIdEXISTCOL
     */
    public String getCodeId(){
        return codeId;
    }
    /**
     * 设定code名
     */
    public void setCodeName(String codeName){
        this.codeName = codeName;
    }

    /**
     * 取得code名
     */
    public String getCodeName(){
        return codeName;
    }
    /**
     * 设定图片路径
     */
    public void setImgSrc(String imgSrc){
        this.imgSrc = imgSrc;
    }

    /**
     * 取得图片路径
     */
    public String getImgSrc(){
        return imgSrc;
    }

}
