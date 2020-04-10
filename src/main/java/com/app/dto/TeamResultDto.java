package com.app.dto;

import java.util.List;
import java.util.Map;

import com.app.model.FehCharacter;

public class TeamResultDto {

    /**
     * 备选结果
     */
    private List<FehCharacter> alertnative;

    /**
     * 队伍Map
     */
    private Map<String,List<FehCharacter>> teamMap;

    public List<FehCharacter> getAlertnative() {
        return alertnative;
    }

    public void setAlertnative(List<FehCharacter> alertnative) {
        this.alertnative = alertnative;
    }

    public Map<String, List<FehCharacter>> getTeamMap() {
        return teamMap;
    }

    public void setTeamMap(Map<String, List<FehCharacter>> teamMap) {
        this.teamMap = teamMap;
    }

}
