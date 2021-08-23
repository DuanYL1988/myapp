package com.app.form;

import com.app.model.Hero;

/**
 * 登录页面输入情报
 *
 * @author dylsw
 *
 */
public class HeroSearchForm extends BaseForm {

    private Hero hero;

    private Integer teamNo;

    private String teamMembers;

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Integer getTeamNo() {
        return teamNo;
    }

    public void setTeamNo(Integer teamNo) {
        this.teamNo = teamNo;
    }

    public String getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(String teamMembers) {
        this.teamMembers = teamMembers;
    }

}
