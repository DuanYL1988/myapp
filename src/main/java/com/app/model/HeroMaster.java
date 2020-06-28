package com.app.model;

public class HeroMaster{
    /**
     * PRIMARYKEY
     */
    private Integer id;

    /**
     * 关联主表主键EXISTCOL
     */
    private String name;

    /**
     * 称号EXISTCOL
     */
    private String origin;

    /**
     * 扩展字段1
     */
    private String expandCol1;

    /**
     * 扩展字段2
     */
    private String expandCol2;

    /**
     * 扩展字段3
     */
    private String expandCol3;

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
     * 设定关联主表主键EXISTCOL
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 取得关联主表主键EXISTCOL
     */
    public String getName(){
        return name;
    }
    /**
     * 设定称号EXISTCOL
     */
    public void setOrigin(String origin){
        this.origin = origin;
    }

    /**
     * 取得称号EXISTCOL
     */
    public String getOrigin(){
        return origin;
    }
    /**
     * 设定扩展字段1
     */
    public void setExpandcol1(String expandCol1){
        this.expandCol1 = expandCol1;
    }

    /**
     * 取得扩展字段1
     */
    public String getExpandcol1(){
        return expandCol1;
    }
    /**
     * 设定扩展字段2
     */
    public void setExpandcol2(String expandCol2){
        this.expandCol2 = expandCol2;
    }

    /**
     * 取得扩展字段2
     */
    public String getExpandcol2(){
        return expandCol2;
    }
    /**
     * 设定扩展字段3
     */
    public void setExpandcol3(String expandCol3){
        this.expandCol3 = expandCol3;
    }

    /**
     * 取得扩展字段3
     */
    public String getExpandcol3(){
        return expandCol3;
    }

}
