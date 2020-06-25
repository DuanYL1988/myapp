package com.app.model;

public class HeroContent{
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
     * 扩展字段1
     */
    private String nameExpand1;

    /**
     * 扩展字段2
     */
    private String nameExpand2;

    /**
     * 扩展字段3
     */
    private String nameExpand3;

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
    public void setCategoryid(String categoryId){
        this.categoryId = categoryId;
    }

    /**
     * 取得類別EXISTCOL
     */
    public String getCategoryid(){
        return categoryId;
    }
    /**
     * 设定類別名
     */
    public void setCategoryname(String categoryName){
        this.categoryName = categoryName;
    }

    /**
     * 取得類別名
     */
    public String getCategoryname(){
        return categoryName;
    }
    /**
     * 设定codeIdEXISTCOL
     */
    public void setCodeid(String codeId){
        this.codeId = codeId;
    }

    /**
     * 取得codeIdEXISTCOL
     */
    public String getCodeid(){
        return codeId;
    }
    /**
     * 设定code名
     */
    public void setCodename(String codeName){
        this.codeName = codeName;
    }

    /**
     * 取得code名
     */
    public String getCodename(){
        return codeName;
    }
    /**
     * 设定图片路径
     */
    public void setImgsrc(String imgSrc){
        this.imgSrc = imgSrc;
    }

    /**
     * 取得图片路径
     */
    public String getImgsrc(){
        return imgSrc;
    }
    /**
     * 设定扩展字段1
     */
    public void setNameexpand1(String nameExpand1){
        this.nameExpand1 = nameExpand1;
    }

    /**
     * 取得扩展字段1
     */
    public String getNameexpand1(){
        return nameExpand1;
    }
    /**
     * 设定扩展字段2
     */
    public void setNameexpand2(String nameExpand2){
        this.nameExpand2 = nameExpand2;
    }

    /**
     * 取得扩展字段2
     */
    public String getNameexpand2(){
        return nameExpand2;
    }
    /**
     * 设定扩展字段3
     */
    public void setNameexpand3(String nameExpand3){
        this.nameExpand3 = nameExpand3;
    }

    /**
     * 取得扩展字段3
     */
    public String getNameexpand3(){
        return nameExpand3;
    }

}
