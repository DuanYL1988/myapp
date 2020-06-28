package com.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.app.common.CommonContent;
import com.app.dto.ActerInfoDto;
import com.app.dto.AjaxResponseDto;
import com.app.dto.FehBaseDto;
import com.app.dto.TeamResultDto;
import com.app.form.FehCharActerForm;
import com.app.form.TeamEditForm;
import com.app.model.FehCharacter;
import com.app.repository.FehCharacterRepository;
import com.app.service.FehService;
import com.app.util.CommonUtils;

@Service
public class FehServiceImpl implements FehService {

    @Autowired
    FehCharacterRepository fehRepository;

    @Autowired
    CommonUtils commonUtil;

    @Value("${location}")
    private String location;

    /**
     * 取得角色信息和不同皮肤头像
     */
    @Override
    public ActerInfoDto getSameActerList(String acterId) {
        ActerInfoDto result = new ActerInfoDto();
        String imagePath = location+CommonContent.FEH_IMG_PATH;
        FehCharacter acter = fehRepository.selectOne(Integer.parseInt(acterId),imagePath);
        result.setActer(acter);
        //
        FehCharacter dto = acter;
        dto.setImagePath(imagePath);
        List<FehCharacter> sameActerList = fehRepository.findSameActer(dto);
        result.setSameActerList(sameActerList);
        return result;
    }

    @Override
    public FehBaseDto getIndexData() {
        FehBaseDto result = new FehBaseDto();
        FehCharacter acter = new FehCharacter();
        acter.setImagePath(location+CommonContent.FEH_IMG_PATH);
        List<FehCharacter> fehActerList = fehRepository.selectByDto(acter);
        Map<String, List<FehCharacter>> fehActerMap = commonUtil.groupByList(
                "weaponType", fehActerList);
        result.setFehActerMap(fehActerMap);
        return result;
    }
    @Override
    public AjaxResponseDto doSave(FehCharActerForm form) {
        AjaxResponseDto result = new AjaxResponseDto();
        // 取得图片目录
        FehCharacter acter = form.getCharActer();
        String imgPath = acter.getFaceImg();
        if(null != imgPath){
            imgPath = imgPath.split("feh\\acter")[1];
            imgPath = imgPath.substring(0, imgPath.lastIndexOf("\\")+1);
            imgPath = imgPath.replace("\\", "/");
            //
            acter.setqImg(imgPath+CommonContent.Q_IMG);
            acter.setFaceImg(imgPath+CommonContent.FACE_IMG);
            acter.setAttImg(imgPath+CommonContent.ATTACT_IMG);
            acter.setDefImg(imgPath+CommonContent.BREAK_IMG);
            acter.setExtraImg(imgPath+CommonContent.EXTRA_IMG);
            acter.setStandImg(imgPath+CommonContent.NORMAL_IMG);
        }
        //
        int cnt = fehRepository.countByName(acter.getTitlename(), acter.getBasename());
        result.setCode(CommonContent.RESULT_SUCCESS);
        result.setMessage("更新成功");
        if (CommonContent.MODE_UPDATE.equals(form.getMode())) {
            if(cnt > 0){
                fehRepository.updateFehCharacter(acter);
            } else {
                result.setCode(CommonContent.RESULT_WARRING);
                result.setMessage("更新失败，没有这条数据");
            }
        } else {
            if(cnt == 0) {
                fehRepository.insertToActer(acter);
            } else {
                result.setCode(CommonContent.RESULT_WARRING);
                result.setMessage("登陆失败，已有这条数据");
            }
        }
        return result;
    }


    /**
     * @param form
     * @return
     */
    public List<FehCharacter> teamEdit(TeamEditForm form){
        FehCharacter dto = new FehCharacter();
        List<FehCharacter> acterList = fehRepository.selectByDto(dto);

        return acterList;
    }

    /**
     * 队伍情报初始表示
     */
    @Override
    public TeamResultDto getTeamInfo() {
        TeamResultDto result = new TeamResultDto();
        // 备选
        List<FehCharacter> alertnative = fehRepository.selectByTeamNo(null,location+CommonContent.FEH_IMG_PATH);
        result.setAlertnative(alertnative);
        //
        Map<String,List<FehCharacter>> teamMap = new HashMap<String, List<FehCharacter>>();
        for(int i=1;i<=15;i++) {
            // 查找队员
            List<FehCharacter> teamSelect = fehRepository.selectByTeamNo(Integer.toString(i),location+CommonContent.FEH_IMG_PATH);
            //
            if(teamSelect.size() < 4) {
                for(int j = teamSelect.size();j<4;j++) {
                    FehCharacter acter = new FehCharacter();
                    teamSelect.add(acter);
                }
            }
            teamMap.put("team"+i, teamSelect);
        }
        result.setTeamMap(teamMap);
        return result;
    }

    /**
     * 更新组队情报
     * @param teamNo
     * @param acterId
     */
    @Override
    public void updateTeam(String teamNo,String acterId) {
        // 队伍队员重置
        fehRepository.initialTeam(teamNo);
        // 队伍更新
        fehRepository.saveTeam(teamNo, acterId);
    }
}
