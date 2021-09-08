package com.app.service;

import java.util.List;
import java.util.Map;

import com.app.dto.AjaxResponseDto;
import com.app.form.HeroRegistForm;
import com.app.form.HeroSearchForm;
import com.app.model.Hero;

public interface HeroService {

    /**
     * 新英雄登录处理
     *
     * @param form
     * @return
     */
    AjaxResponseDto heroRegist(HeroRegistForm form);

    /**
     * 检索处理
     *
     * @param 检索条件Form form
     * @return
     */
    public List<Hero> doSearch(HeroSearchForm form);

    /**
     * 分组检索处理
     *
     * @param 检索条件Form form
     * @return
     */
    Map<String, List<Hero>> doGroupSearch(HeroSearchForm form);

    /**
     * @param id
     */
    AjaxResponseDto getAjaxHeroInfo(Integer id);

    /**
     * 编队更新
     *
     * @param 更新form
     * @return
     */
    AjaxResponseDto updateTeam(HeroRegistForm form);
}
