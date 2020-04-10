package com.app.repository;

import java.util.List;

import com.app.model.OracleKeyword;
import com.app.model.OracleTip;

public interface OracleMasterRepository {

    void insertTip(OracleTip obj);
    
    List<OracleTip> selectTipByDto(OracleTip dto);
    
    void insertKeyword(OracleKeyword obj);
    
    List<OracleTip> selectKeywordByDto(OracleKeyword dto);
}
