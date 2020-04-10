package com.app.dto;

import java.util.List;

import com.app.model.FehCharacter;

public class ActerInfoDto {

    /**
     * 角色信息
     */
    private FehCharacter acter;

    /**
     * 同一角色集合
     */
    private List<FehCharacter> sameActerList;

    public FehCharacter getActer() {
        return acter;
    }

    public void setActer(FehCharacter acter) {
        this.acter = acter;
    }

    public List<FehCharacter> getSameActerList() {
        return sameActerList;
    }

    public void setSameActerList(List<FehCharacter> sameActerList) {
        this.sameActerList = sameActerList;
    }
    
    
}
