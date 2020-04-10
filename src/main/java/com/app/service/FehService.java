package com.app.service;

import java.util.List;

import com.app.dto.ActerInfoDto;
import com.app.dto.AjaxResponseDto;
import com.app.dto.FehBaseDto;
import com.app.dto.TeamResultDto;
import com.app.form.FehCharActerForm;

public interface FehService {

    FehBaseDto getIndexData();

    /**
     * 取得角色信息和不同皮肤头像
     * @param acterId 角色ID
     * @return
     */
    ActerInfoDto getSameActerList(String acterId);
    
    /**
     * 保存
     * @param form
     * @return
     */
    AjaxResponseDto doSave(FehCharActerForm form);

    /**
     * 保存图片信息
     * @param imageList
     * @return
     */
    AjaxResponseDto saveFavImg(List<String> imageList);

    /**
     * 队伍情报初始表示
     * 
     * @return
     */
    TeamResultDto getTeamInfo();

    /**
     * 更新组队情报
     * 
     * @param teamNo
     * @param acterId
     */
    void updateTeam(String teamNo, String acterId);
}
