package com.app.model;

public class Skill extends ExpandCondition {
    /**
     * ID
     */
    private Integer id;

    /**
     * 技能名
     */
    private String name;

    /**
     * 技能类型
     */
    private String type;

    /**
     * 介绍
     */
    private String info;

    /**
     * 继承
     */
    private String extendFlag;

    /**
     * 武器威力
     */
    private Integer power;

    /**
     * HP加成
     */
    private Integer hpPlus;

    /**
     * POW加成
     */
    private Integer powPlus;

    /**
     * SPD加成
     */
    private Integer spdPlus;

    /**
     * DEF加成
     */
    private Integer defPlus;

    /**
     * MDF加成
     */
    private Integer mdfPlus;

    /**
     * HP增益
     */
    private Integer hpBuff;

    /**
     * POW增益
     */
    private Integer powBuff;

    /**
     * SPD增益
     */
    private Integer spdBuff;

    /**
     * DEF增益
     */
    private Integer defBuff;

    /**
     * MDF增益
     */
    private Integer mdfBuff;

    /**
     * HP减益
     */
    private Integer hpDebuff;

    /**
     * POW减益
     */
    private Integer powDebuff;

    /**
     * SPD减益
     */
    private Integer spdDebuff;

    /**
     * DEF减益
     */
    private Integer defDebuff;

    /**
     * MDF减益
     */
    private Integer mdfDebuff;

    /**
     * 设定ID
     */
    public void setId(Integer id){
        this.id = id;
    }

    /**
     * 取得ID
     */
    public Integer getId(){
        return id;
    }
    /**
     * 设定技能名
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 取得技能名
     */
    public String getName(){
        return name;
    }
    /**
     * 设定技能类型
     */
    public void setType(String type){
        this.type = type;
    }

    /**
     * 取得技能类型
     */
    public String getType(){
        return type;
    }
    /**
     * 设定介绍
     */
    public void setInfo(String info){
        this.info = info;
    }

    /**
     * 取得介绍
     */
    public String getInfo(){
        return info;
    }
    /**
     * 设定继承
     */
    public void setExtendFlag(String extendFlag){
        this.extendFlag = extendFlag;
    }

    /**
     * 取得继承
     */
    public String getExtendFlag(){
        return extendFlag;
    }
    /**
     * 设定武器威力
     */
    public void setPower(Integer power){
        this.power = power;
    }

    /**
     * 取得武器威力
     */
    public Integer getPower(){
        return power;
    }
    /**
     * 设定HP加成
     */
    public void setHpPlus(Integer hpPlus){
        this.hpPlus = hpPlus;
    }

    /**
     * 取得HP加成
     */
    public Integer getHpPlus(){
        return hpPlus;
    }
    /**
     * 设定POW加成
     */
    public void setPowPlus(Integer powPlus){
        this.powPlus = powPlus;
    }

    /**
     * 取得POW加成
     */
    public Integer getPowPlus(){
        return powPlus;
    }
    /**
     * 设定SPD加成
     */
    public void setSpdPlus(Integer spdPlus){
        this.spdPlus = spdPlus;
    }

    /**
     * 取得SPD加成
     */
    public Integer getSpdPlus(){
        return spdPlus;
    }
    /**
     * 设定DEF加成
     */
    public void setDefPlus(Integer defPlus){
        this.defPlus = defPlus;
    }

    /**
     * 取得DEF加成
     */
    public Integer getDefPlus(){
        return defPlus;
    }
    /**
     * 设定MDF加成
     */
    public void setMdfPlus(Integer mdfPlus){
        this.mdfPlus = mdfPlus;
    }

    /**
     * 取得MDF加成
     */
    public Integer getMdfPlus(){
        return mdfPlus;
    }
    /**
     * 设定HP增益
     */
    public void setHpBuff(Integer hpBuff){
        this.hpBuff = hpBuff;
    }

    /**
     * 取得HP增益
     */
    public Integer getHpBuff(){
        return hpBuff;
    }
    /**
     * 设定POW增益
     */
    public void setPowBuff(Integer powBuff){
        this.powBuff = powBuff;
    }

    /**
     * 取得POW增益
     */
    public Integer getPowBuff(){
        return powBuff;
    }
    /**
     * 设定SPD增益
     */
    public void setSpdBuff(Integer spdBuff){
        this.spdBuff = spdBuff;
    }

    /**
     * 取得SPD增益
     */
    public Integer getSpdBuff(){
        return spdBuff;
    }
    /**
     * 设定DEF增益
     */
    public void setDefBuff(Integer defBuff){
        this.defBuff = defBuff;
    }

    /**
     * 取得DEF增益
     */
    public Integer getDefBuff(){
        return defBuff;
    }
    /**
     * 设定MDF增益
     */
    public void setMdfBuff(Integer mdfBuff){
        this.mdfBuff = mdfBuff;
    }

    /**
     * 取得MDF增益
     */
    public Integer getMdfBuff(){
        return mdfBuff;
    }
    /**
     * 设定HP减益
     */
    public void setHpDebuff(Integer hpDebuff){
        this.hpDebuff = hpDebuff;
    }

    /**
     * 取得HP减益
     */
    public Integer getHpDebuff(){
        return hpDebuff;
    }
    /**
     * 设定POW减益
     */
    public void setPowDebuff(Integer powDebuff){
        this.powDebuff = powDebuff;
    }

    /**
     * 取得POW减益
     */
    public Integer getPowDebuff(){
        return powDebuff;
    }
    /**
     * 设定SPD减益
     */
    public void setSpdDebuff(Integer spdDebuff){
        this.spdDebuff = spdDebuff;
    }

    /**
     * 取得SPD减益
     */
    public Integer getSpdDebuff(){
        return spdDebuff;
    }
    /**
     * 设定DEF减益
     */
    public void setDefDebuff(Integer defDebuff){
        this.defDebuff = defDebuff;
    }

    /**
     * 取得DEF减益
     */
    public Integer getDefDebuff(){
        return defDebuff;
    }
    /**
     * 设定MDF减益
     */
    public void setMdfDebuff(Integer mdfDebuff){
        this.mdfDebuff = mdfDebuff;
    }

    /**
     * 取得MDF减益
     */
    public Integer getMdfDebuff(){
        return mdfDebuff;
    }

}
