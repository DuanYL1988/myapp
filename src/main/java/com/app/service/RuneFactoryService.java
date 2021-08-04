package com.app.service;

import java.util.List;

import com.app.dto.AjaxResponseDto;
import com.app.form.FarmForm;
import com.app.model.Farm;

public interface RuneFactoryService {

    /**
     * 保存
     *
     * @param form
     * @return
     */
    AjaxResponseDto seedBatch(FarmForm form);

    public void updateFarmInfo(FarmForm form);

    public List<Farm> getFreeCntByLocation();
}
