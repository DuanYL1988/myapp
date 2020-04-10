package com.app.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.jdbc.JdbcConnectUtil;
import com.app.model.OracleKeyword;
import com.app.model.OracleTip;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml",
        "classpath:spring/spring-mvc.xml" })
public class OracleRepositoryTest {
    @Autowired
    OracleMasterRepository repository;
    
    JdbcConnectUtil management;
    
    @Test
    public void testSql() {
        management.excuteSelectQuery("select code_id,REPLACE(code_name_img,'../../../resources/images/feh/','') code_name_img from feh_content_master where CATEGORY_ID = '0001'");
    }
    @Test
    public void testInsert() {
        OracleTip dto = new OracleTip();
        
        dto.setChapterId("2");
        dto.setChapterName("SELECT相关");
        dto.setKeyWord("SELECT");
        dto.setTipInfo("SELECT文有射影,选择,结合三个技能,射影是去除特定列,选择是取出特定行,结合是连接多个表");
        
        repository.insertTip(dto);
    }
    
    @Test
    public void testInsert2() {
        OracleKeyword dto = new OracleKeyword();
        
        dto.setTipId("");
        dto.setKeyWord("SELECT");
        dto.setInfo("");
        dto.setGrammar("SELECT COL1[,COL2] FROM TABLE");
        
        repository.insertKeyword(dto);
    }
}
