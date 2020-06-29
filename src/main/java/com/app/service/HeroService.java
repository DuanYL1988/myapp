package com.app.service;

import com.app.dto.AjaxResponseDto;
import com.app.form.HeroRegistForm;

public interface HeroService {

    /**
     * 新英雄登录处理
     *
     * @param form
     * @return
     */
    AjaxResponseDto heroRegist(HeroRegistForm form);

}
