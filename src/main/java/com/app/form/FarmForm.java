package com.app.form;

import com.app.model.Farm;

/**
 * 登录页面输入情报
 *
 * @author dylsw
 *
 */
public class FarmForm extends BaseForm {

    private Farm farm;

    private String farmType;

    private String gameDate;

    private String cropId;

    private String farmIdList;

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }

    public String getCropId() {
        return cropId;
    }

    public void setCropId(String cropId) {
        this.cropId = cropId;
    }

    public String getFarmIdList() {
        return farmIdList;
    }

    public void setFarmIdList(String farmIdList) {
        this.farmIdList = farmIdList;
    }

    public String getFarmType() {
        return farmType;
    }

    public void setFarmType(String farmType) {
        this.farmType = farmType;
    }

}
