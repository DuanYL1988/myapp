package com.app.model;

public class SkillInfo extends ExpandCondition {
    /**
     * PRIMARYKEY
     */
    private Integer id;

    /**
     * 技能名EXISTCOL
     */
    private String name;

    /**
     * 类别EXISTCOL
     */
    private String type;

    /**
     * 继承
     */
    private String extend;

    /**
     * 描述
     */
    private String info;

    /**
     * 武器威力
     */
    private Integer weaponPower;

    /**
     * 特殊效果
     */
    private String effects;

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
     * 设定技能名EXISTCOL
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 取得技能名EXISTCOL
     */
    public String getName(){
        return name;
    }
    /**
     * 设定类别EXISTCOL
     */
    public void setType(String type){
        this.type = type;
    }

    /**
     * 取得类别EXISTCOL
     */
    public String getType(){
        return type;
    }
    /**
     * 设定继承
     */
    public void setExtend(String extend){
        this.extend = extend;
    }

    /**
     * 取得继承
     */
    public String getExtend(){
        return extend;
    }
    /**
     * 设定描述
     */
    public void setInfo(String info){
        this.info = info;
    }

    /**
     * 取得描述
     */
    public String getInfo(){
        return info;
    }
    /**
     * 设定武器威力
     */
    public void setWeaponPower(Integer weaponPower){
        this.weaponPower = weaponPower;
    }

    /**
     * 取得武器威力
     */
    public Integer getWeaponPower(){
        return weaponPower;
    }
    /**
     * 设定特殊效果
     */
    public void setEffects(String effects){
        this.effects = effects;
    }

    /**
     * 取得特殊效果
     */
    public String getEffects(){
        return effects;
    }

}
