package com.app.model;

public class HeroMaster extends ExpandCondition {
    /**
     * PRIMARYKEY
     */
    private Integer id;

    /**
     * 作品IDEXISTCOL
     */
    private String originId;

    /**
     * 作品名
     */
    private String originName;

    /**
     * 人物名EXISTCOL
     */
    private String name;

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
     * 设定作品IDEXISTCOL
     */
    public void setOriginId(String originId){
        this.originId = originId;
    }

    /**
     * 取得作品IDEXISTCOL
     */
    public String getOriginId(){
        return originId;
    }
    /**
     * 设定作品名
     */
    public void setOriginName(String originName){
        this.originName = originName;
    }

    /**
     * 取得作品名
     */
    public String getOriginName(){
        return originName;
    }
    /**
     * 设定人物名EXISTCOL
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 取得人物名EXISTCOL
     */
    public String getName(){
        return name;
    }

}
