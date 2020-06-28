package com.app.model;

import java.util.Date;

public class Hero{
    /**
     * PRIMARYKEY
     */
    private Integer id;

    /**
     * 关联主表主键
     */
    private String masterId;

    /**
     * 称号EXISTCOL
     */
    private String titleName;

    /**
     * 角色名EXISTCOL
     */
    private String name;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 立绘图片文件夹名
     */
    private String imgName;

    /**
     * 角色作品
     */
    private String origin;

    /**
     * 生命值
     */
    private Integer hp;

    /**
     * 攻击
     */
    private Integer attact;

    /**
     * 速度
     */
    private Integer speed;

    /**
     * 防御
     */
    private Integer def;

    /**
     * 魔防
     */
    private Integer mdf;

    /**
     * 武器名
     */
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
     * 圣印技能
     */
    private String skillD;

    /**
     * 支援技能
     */
    private String skillS;

    /**
     * 必杀技能
     */
    private String skillE;

    /**
     * 突破极限
     */
    private Integer limitPlus;

    /**
     * 支援对象
     */
    private String supportMate;

    /**
     * 祝福
     */
    private String blessing;

    /**
     * 兵种
     */
    private String moveType;

    /**
     * 武器类型
     */
    private String weaponType;

    /**
     * 宝珠颜色
     */
    private String color;

    /**
     * 种族
     */
    private String race;

    /**
     * 英雄类型(连翼/传承)
     */
    private String heroType;

    /**
     * 队伍
     */
    private Integer team;

    /**
     * 技能点
     */
    private Integer skillPoint;

    /**
     * 英雄点
     */
    private Integer heroPoint;

    /**
     * 特效标签
     */
    private String specTag;

    /**
     * 卡池
     */
    private String pool;

    /**
     * 喜欢
     */
    private String favorite;

    /**
     * 登录日期
     */
    private Date createDatetime;

    /**
     * 更新日期
     */
    private Date updateDatetime;

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
     * 设定关联主表主键
     */
    public void setMasterid(String masterId){
        this.masterId = masterId;
    }

    /**
     * 取得关联主表主键
     */
    public String getMasterid(){
        return masterId;
    }
    /**
     * 设定称号EXISTCOL
     */
    public void setTitlename(String titleName){
        this.titleName = titleName;
    }

    /**
     * 取得称号EXISTCOL
     */
    public String getTitlename(){
        return titleName;
    }
    /**
     * 设定角色名EXISTCOL
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 取得角色名EXISTCOL
     */
    public String getName(){
        return name;
    }
    /**
     * 设定昵称
     */
    public void setNickname(String nickName){
        this.nickName = nickName;
    }

    /**
     * 取得昵称
     */
    public String getNickname(){
        return nickName;
    }
    /**
     * 设定立绘图片文件夹名
     */
    public void setImgname(String imgName){
        this.imgName = imgName;
    }

    /**
     * 取得立绘图片文件夹名
     */
    public String getImgname(){
        return imgName;
    }
    /**
     * 设定角色作品
     */
    public void setOrigin(String origin){
        this.origin = origin;
    }

    /**
     * 取得角色作品
     */
    public String getOrigin(){
        return origin;
    }
    /**
     * 设定生命值
     */
    public void setHp(Integer hp){
        this.hp = hp;
    }

    /**
     * 取得生命值
     */
    public Integer getHp(){
        return hp;
    }
    /**
     * 设定攻击
     */
    public void setAttact(Integer attact){
        this.attact = attact;
    }

    /**
     * 取得攻击
     */
    public Integer getAttact(){
        return attact;
    }
    /**
     * 设定速度
     */
    public void setSpeed(Integer speed){
        this.speed = speed;
    }

    /**
     * 取得速度
     */
    public Integer getSpeed(){
        return speed;
    }
    /**
     * 设定防御
     */
    public void setDef(Integer def){
        this.def = def;
    }

    /**
     * 取得防御
     */
    public Integer getDef(){
        return def;
    }
    /**
     * 设定魔防
     */
    public void setMdf(Integer mdf){
        this.mdf = mdf;
    }

    /**
     * 取得魔防
     */
    public Integer getMdf(){
        return mdf;
    }
    /**
     * 设定武器名
     */
    public void setWeapon(String weapon){
        this.weapon = weapon;
    }

    /**
     * 取得武器名
     */
    public String getWeapon(){
        return weapon;
    }
    /**
     * 设定A技能
     */
    public void setSkilla(String skillA){
        this.skillA = skillA;
    }

    /**
     * 取得A技能
     */
    public String getSkilla(){
        return skillA;
    }
    /**
     * 设定B技能
     */
    public void setSkillb(String skillB){
        this.skillB = skillB;
    }

    /**
     * 取得B技能
     */
    public String getSkillb(){
        return skillB;
    }
    /**
     * 设定C技能
     */
    public void setSkillc(String skillC){
        this.skillC = skillC;
    }

    /**
     * 取得C技能
     */
    public String getSkillc(){
        return skillC;
    }
    /**
     * 设定圣印技能
     */
    public void setSkilld(String skillD){
        this.skillD = skillD;
    }

    /**
     * 取得圣印技能
     */
    public String getSkilld(){
        return skillD;
    }
    /**
     * 设定支援技能
     */
    public void setSkills(String skillS){
        this.skillS = skillS;
    }

    /**
     * 取得支援技能
     */
    public String getSkills(){
        return skillS;
    }
    /**
     * 设定必杀技能
     */
    public void setSkille(String skillE){
        this.skillE = skillE;
    }

    /**
     * 取得必杀技能
     */
    public String getSkille(){
        return skillE;
    }
    /**
     * 设定突破极限
     */
    public void setLimitplus(Integer limitPlus){
        this.limitPlus = limitPlus;
    }

    /**
     * 取得突破极限
     */
    public Integer getLimitplus(){
        return limitPlus;
    }
    /**
     * 设定支援对象
     */
    public void setSupportmate(String supportMate){
        this.supportMate = supportMate;
    }

    /**
     * 取得支援对象
     */
    public String getSupportmate(){
        return supportMate;
    }
    /**
     * 设定祝福
     */
    public void setBlessing(String blessing){
        this.blessing = blessing;
    }

    /**
     * 取得祝福
     */
    public String getBlessing(){
        return blessing;
    }
    /**
     * 设定兵种
     */
    public void setMovetype(String moveType){
        this.moveType = moveType;
    }

    /**
     * 取得兵种
     */
    public String getMovetype(){
        return moveType;
    }
    /**
     * 设定武器类型
     */
    public void setWeapontype(String weaponType){
        this.weaponType = weaponType;
    }

    /**
     * 取得武器类型
     */
    public String getWeapontype(){
        return weaponType;
    }
    /**
     * 设定宝珠颜色
     */
    public void setColor(String color){
        this.color = color;
    }

    /**
     * 取得宝珠颜色
     */
    public String getColor(){
        return color;
    }
    /**
     * 设定种族
     */
    public void setRace(String race){
        this.race = race;
    }

    /**
     * 取得种族
     */
    public String getRace(){
        return race;
    }
    /**
     * 设定英雄类型(连翼/传承)
     */
    public void setHerotype(String heroType){
        this.heroType = heroType;
    }

    /**
     * 取得英雄类型(连翼/传承)
     */
    public String getHerotype(){
        return heroType;
    }
    /**
     * 设定队伍
     */
    public void setTeam(Integer team){
        this.team = team;
    }

    /**
     * 取得队伍
     */
    public Integer getTeam(){
        return team;
    }
    /**
     * 设定技能点
     */
    public void setSkillpoint(Integer skillPoint){
        this.skillPoint = skillPoint;
    }

    /**
     * 取得技能点
     */
    public Integer getSkillpoint(){
        return skillPoint;
    }
    /**
     * 设定英雄点
     */
    public void setHeropoint(Integer heroPoint){
        this.heroPoint = heroPoint;
    }

    /**
     * 取得英雄点
     */
    public Integer getHeropoint(){
        return heroPoint;
    }
    /**
     * 设定特效标签
     */
    public void setSpectag(String specTag){
        this.specTag = specTag;
    }

    /**
     * 取得特效标签
     */
    public String getSpectag(){
        return specTag;
    }
    /**
     * 设定卡池
     */
    public void setPool(String pool){
        this.pool = pool;
    }

    /**
     * 取得卡池
     */
    public String getPool(){
        return pool;
    }
    /**
     * 设定喜欢
     */
    public void setFavorite(String favorite){
        this.favorite = favorite;
    }

    /**
     * 取得喜欢
     */
    public String getFavorite(){
        return favorite;
    }
    /**
     * 设定登录日期
     */
    public void setCreatedatetime(Date createDatetime){
        this.createDatetime = createDatetime;
    }

    /**
     * 取得登录日期
     */
    public Date getCreatedatetime(){
        return createDatetime;
    }
    /**
     * 设定更新日期
     */
    public void setUpdatedatetime(Date updateDatetime){
        this.updateDatetime = updateDatetime;
    }

    /**
     * 取得更新日期
     */
    public Date getUpdatedatetime(){
        return updateDatetime;
    }

}
