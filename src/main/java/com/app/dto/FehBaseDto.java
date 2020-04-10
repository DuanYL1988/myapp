package com.app.dto;

import java.util.List;
import java.util.Map;

import com.app.model.FehCharacter;

public class FehBaseDto {

    /**
     * 角色对象
     */
    private FehCharacter acter;
    
    /**
     * 角色集合
     */
    private List<FehCharacter> acterList;
    
    /**
     * 結果Map
     */
    private Map<String, List<FehCharacter>> fehActerMap;
    
    public FehCharacter getActer() {
        return acter;
    }
    public void setActer(FehCharacter acter) {
        this.acter = acter;
    }
    public List<FehCharacter> getActerList() {
        return acterList;
    }
    public void setActerList(List<FehCharacter> acterList) {
        this.acterList = acterList;
    }
    public Map<String, List<FehCharacter>> getFehActerMap() {
        return fehActerMap;
    }
    public void setFehActerMap(Map<String, List<FehCharacter>> fehActerMap) {
        this.fehActerMap = fehActerMap;
    }
    
}
