package com.app.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class FehCharacter {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 称号(伟大的女爵)
     */
    private String titlename;

    /**
     * 角色名(琳)
     */
    @NotNull(message = "输入角色名")
    @Size(min = 1, message = "输入角色名")
    private String basename;

    /**
     * 简称(弓琳)
     */
    private String name;

    /**
     * 连接feh_character_master
     */
    private Integer masterId;

    /**
     * 卡池名
     */
    private String pool;

    /**
     * 角色头像
     */
    private String faceImg;

    /**
     * 角色Q版点阵图
     */
    private String qImg;

    /**
     * 普通立绘
     */
    private String standImg;

    /**
     * 攻击立绘
     */
    private String attImg;

    /**
     * 必杀立绘
     */
    private String extraImg;

    /**
     * 被弹立绘
     */
    private String defImg;

    private Integer hp;

    private Integer att;

    private Integer spd;

    private Integer def;

    private Integer mdf;

    private Integer baseHp;

    private Integer baseAtt;

    private Integer baseSpd;

    private Integer baseDef;

    private Integer baseMdf;

    private String weapon;

    /**
     * A技能
     */
    private String skillA;

    /**
     * B技能
     */
    private String skillB;

    /**
     * C技能
     */
    private String skillC;

    /**
     * 可装选圣印技能
     */
    private String skillD;

    /**
     * 辅助技能
     */
    private String skillS;

    /**
     * 必杀技
     */
    private String skillE;

    @NotNull(message = "选择兵种")
    private String moveType;

    private String weaponType;

    private String race;

    private String blessing;

    private String origin;

    private Integer levelPlus;

    private Integer color;

    /**
      * 图片路径
     */
    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitlename() {
        return titlename;
    }

    public void setTitlename(String titlename) {
        this.titlename = titlename;
    }

    public String getBasename() {
        return basename;
    }

    public void setBasename(String basename) {
        this.basename = basename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    public String getqImg() {
        return qImg;
    }

    public void setqImg(String qImg) {
        this.qImg = qImg;
    }

    public String getStandImg() {
        return standImg;
    }

    public void setStandImg(String standImg) {
        this.standImg = standImg;
    }

    public String getAttImg() {
        return attImg;
    }

    public void setAttImg(String attImg) {
        this.attImg = attImg;
    }

    public String getExtraImg() {
        return extraImg;
    }

    public void setExtraImg(String extraImg) {
        this.extraImg = extraImg;
    }

    public String getDefImg() {
        return defImg;
    }

    public void setDefImg(String defImg) {
        this.defImg = defImg;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getAtt() {
        return att;
    }

    public void setAtt(Integer att) {
        this.att = att;
    }

    public Integer getSpd() {
        return spd;
    }

    public void setSpd(Integer spd) {
        this.spd = spd;
    }

    public Integer getDef() {
        return def;
    }

    public void setDef(Integer def) {
        this.def = def;
    }

    public Integer getMdf() {
        return mdf;
    }

    public void setMdf(Integer mdf) {
        this.mdf = mdf;
    }

    public Integer getBaseHp() {
        return baseHp;
    }

    public void setBaseHp(Integer baseHp) {
        this.baseHp = baseHp;
    }

    public Integer getBaseAtt() {
        return baseAtt;
    }

    public void setBaseAtt(Integer baseAtt) {
        this.baseAtt = baseAtt;
    }

    public Integer getBaseSpd() {
        return baseSpd;
    }

    public void setBaseSpd(Integer baseSpd) {
        this.baseSpd = baseSpd;
    }

    public Integer getBaseDef() {
        return baseDef;
    }

    public void setBaseDef(Integer baseDef) {
        this.baseDef = baseDef;
    }

    public Integer getBaseMdf() {
        return baseMdf;
    }

    public void setBaseMdf(Integer baseMdf) {
        this.baseMdf = baseMdf;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getSkillA() {
        return skillA;
    }

    public void setSkillA(String skillA) {
        this.skillA = skillA;
    }

    public String getSkillB() {
        return skillB;
    }

    public void setSkillB(String skillB) {
        this.skillB = skillB;
    }

    public String getSkillC() {
        return skillC;
    }

    public void setSkillC(String skillC) {
        this.skillC = skillC;
    }

    public String getSkillD() {
        return skillD;
    }

    public void setSkillD(String skillD) {
        this.skillD = skillD;
    }

    public String getSkillS() {
        return skillS;
    }

    public void setSkillS(String skillS) {
        this.skillS = skillS;
    }

    public String getSkillE() {
        return skillE;
    }

    public void setSkillE(String skillE) {
        this.skillE = skillE;
    }

    public String getMoveType() {
        return moveType;
    }

    public void setMoveType(String moveType) {
        this.moveType = moveType;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getBlessing() {
        return blessing;
    }

    public void setBlessing(String blessing) {
        this.blessing = blessing;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getLevelPlus() {
        return levelPlus;
    }

    public void setLevelPlus(Integer levelPlus) {
        this.levelPlus = levelPlus;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

}
