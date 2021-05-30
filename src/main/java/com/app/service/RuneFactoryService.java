package com.app.service;

import com.app.dto.AjaxResponseDto;
import com.app.form.FarmForm;

public interface RuneFactoryService {

    /**
     * 保存
     *
     * @param form
     * @return
     */
    AjaxResponseDto seedBatch(FarmForm form);

}
