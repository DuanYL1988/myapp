package com.app.form;

import com.app.model.Hero;

/**
 * 登录页面输入情报
 *
 * @author dylsw
 *
 */
public class HeroRegistForm extends BaseForm{

    private Hero hero;

    private String extendWeapon;

    private String extendA;

    private String extendB;

    private String extendC;

    private String extendS;

    private String extendE;

    private String weaponInfo;

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public String getExtendWeapon() {
        return extendWeapon;
    }

    public void setExtendWeapon(String extendWeapon) {
        this.extendWeapon = extendWeapon;
    }

    public String getExtendA() {
        return extendA;
    }

    public void setExtendA(String extendA) {
        this.extendA = extendA;
    }

    public String getExtendB() {
        return extendB;
    }

    public void setExtendB(String extendB) {
        this.extendB = extendB;
    }

    public String getExtendC() {
        return extendC;
    }

    public void setExtendC(String extendC) {
        this.extendC = extendC;
    }

    public String getExtendS() {
        return extendS;
    }

    public void setExtendS(String extendS) {
        this.extendS = extendS;
    }

    public String getExtendE() {
        return extendE;
    }

    public void setExtendE(String extendE) {
        this.extendE = extendE;
    }

    public String getWeaponInfo() {
        return weaponInfo;
    }

    public void setWeaponInfo(String weaponInfo) {
        this.weaponInfo = weaponInfo;
    }

}
