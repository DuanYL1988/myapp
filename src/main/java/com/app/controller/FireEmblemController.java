package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.dto.ActerInfoDto;
import com.app.dto.AjaxResponseDto;
import com.app.dto.FehBaseDto;
import com.app.dto.TeamResultDto;
import com.app.form.FehCharActerForm;
import com.app.form.TeamEditForm;
import com.app.model.ContentMaster;
import com.app.model.FehCharacter;
import com.app.model.Skill;
import com.app.repository.ContentMasterRepository;
import com.app.repository.FehCharacterRepository;
import com.app.repository.SkillRepository;
import com.app.service.FehService;
import com.app.util.CommonUtils;
import com.app.util.JsonUtil;

@Controller
@RequestMapping(value = "/fireEmblem")
public class FireEmblemController {

    @Autowired
    FehCharacterRepository fireEmblemRepository;

    @Autowired
    ContentMasterRepository contentMasterRepository;

    @Autowired
    CommonUtils commonUtil;

    @Autowired
    FehService fehService;

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    JsonUtil jsonUtil;

    /**
     * 初期表示
     */
    @RequestMapping(value = "init")
    public String goToDesktop(Model model) {
        FehBaseDto result = fehService.getIndexData();
        model.addAttribute("fehActer", result.getFehActerMap());
        return "feh/index";
    }

    @RequestMapping(value = "master/{category}")
    public String goToMaster(@PathVariable("category") String category, Model model) {

        return "feh/master";
    }

    /**
     * 打开角色登陆画面（追加，更新）
     */
    @RequestMapping(value = "fehActerRegist/{type}/{acterId}")
    public String acterRegist(@PathVariable("type") String type, @PathVariable("acterId") String acterId,
            FehCharActerForm charActerForm, BindingResult result, Model model) {
        //
        FehCharActerForm form = new FehCharActerForm();
        form.setWeaponType(contentMasterRepository.getContentByCategoryId("0001"));
//        form.setSkillMap(commonUtil.getSkillMap());
        form.setOrigin(contentMasterRepository.getContentByCategoryId("0004"));
        //
        if (StringUtils.isEmpty(type) || "init".equals(type)) {
            form.setCharActer(new FehCharacter());
            //
        } else if ("update".equals(type) && !StringUtils.isEmpty(acterId)) {
            Integer id = Integer.parseInt(acterId);
            FehCharacter acter = fireEmblemRepository.selectOne(id, "");
            if (null != acter) {
                form.setCharActer(acter);
            } else {
                form.setCharActer(new FehCharacter());
            }
        }

        model.addAttribute("form", form);
        return "feh/acterinfo";
    }

    /**
     * 打开角色图片画面
     *
     * @param acterId
     * @param model
     * @return
     */
    @RequestMapping(value = "acterInfo/{acterId}")
    public String acterInfo(@PathVariable("acterId") String acterId, Model model) {
        ActerInfoDto outPutDto = fehService.getSameActerList(acterId);
        model.addAttribute("acter", outPutDto.getActer());
        model.addAttribute("sameList", outPutDto.getSameActerList());
        return "feh/acterImage";
    }

    /**
     * @param form
     * @param result
     * @param model
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseDto insertOrUpdate(@RequestBody @Validated FehCharActerForm form, BindingResult result,
            Model model) {
        AjaxResponseDto response = fehService.doSave(form);
        return response;
    }

    /**
     * @param contentMaster
     * @param model
     * @return
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insertContentMaster(ContentMaster contentMaster, Model model) {
        contentMasterRepository.insert(contentMaster);
        return "feh/index";
    }

    /**
     * @param type
     * @param model
     * @return
     */
    @RequestMapping(value = "favorite/{type}", method = RequestMethod.GET)
    public String favImage(@PathVariable("type") String type, Model model) {
        model.addAttribute("imageList", null);
        return "feh/gallery";
    }

    /**
     * 队伍编组
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "normalTeam", method = RequestMethod.GET)
    public String normalTeam(Model model) {
        TeamResultDto result = fehService.getTeamInfo();
        //
        model.addAttribute("alertnative", result.getAlertnative());
        model.addAttribute("teamMap", result.getTeamMap());
        return "feh/team";
    }

    /**
     * 保存队伍
     *
     * @param acterIdList
     * @param teamId
     * @return
     */
    @RequestMapping(value = "saveTeam", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponseDto saveTeam(@RequestParam("acterIdList") String acterIdList,
            @RequestParam("teamId") String teamId) {
        fehService.updateTeam(teamId, acterIdList);
        AjaxResponseDto response = new AjaxResponseDto();
        response.setMessage("TEAM SAVE COMPLETE");
        return response;
    }

    @RequestMapping(value = "searchTeam")
    @ResponseBody
    public AjaxResponseDto searchTeam(@RequestBody TeamEditForm searchForm) {
        List<String> imgidList = fireEmblemRepository.selectAlertnativeImgId(searchForm);
        AjaxResponseDto response = new AjaxResponseDto();
        response.setData(imgidList);
        response.setMessage("TEAM SAVE COMPLETE");
        return response;
    }

    /**
     * 保存编辑后技能信息
     *
     * @param form
     * @return
     */
    @RequestMapping(value = "saveSkill")
    @ResponseBody
    public AjaxResponseDto saveSkill(@RequestBody Skill form) {
        AjaxResponseDto response = new AjaxResponseDto();
        return response;
    }

    @RequestMapping(value = "sample")
    public String sample() {
        return "feh/sample";
    }
}
