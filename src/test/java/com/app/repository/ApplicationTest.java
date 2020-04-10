package com.app.repository;

import java.io.BufferedWriter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.jdbc.JdbcConnectUtil;
import com.app.jdbc.SqlUtil;
import com.app.util.CommonUtils;
import com.app.util.FileUtils;
import com.app.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml",
        "classpath:spring/spring-mvc.xml" })
public class ApplicationTest {

    @Autowired
    SqlUtil sqlUtil;

    @Autowired
    CommonUtils commonUtils;

    @Autowired
    JdbcConnectUtil dbManagement;

    @Autowired
    JsonUtil jsonUtil;

    @Autowired
    FileUtils fileUtils;
    @Test
    public void testSelectToObject() {
        dbManagement.mode = 2;
        String tablename = "oracle_chapter_tips";
        String desc = "desc " + tablename;
        System.out.println(jsonUtil.praseObjToJson(dbManagement.getFieldInfo(desc)));
//        String select = sqlUtil.createSelectQuery(tablename,dbManagement.getFieldInfo(desc));
//        String json = jsonUtil.praseObjToJson(dbManagement.excuteSelectQuery(select));
//        System.out.println(json);
    }

    @Test
    public void testOcalConnUtil() {
        JdbcConnectUtil util = new JdbcConnectUtil();
        util.mode = 2;
        util.excuteSelectQuery(
                "select code_Id,REPLACE(code_name_img,'../../../resources/images/feh/','') as code_name_img from feh_content_master where CATEGORY_ID = '0003'");
    }

    @Test
    public void testFile() {
        String folderPath = fileUtils.getPath();
        System.out.println(folderPath);
        BufferedWriter bw = fileUtils.getWriter(folderPath+"TmpEtcUriSalesRecoder.java");
        fileUtils.writeFileAndPrintConsole("public class TmpEtcUriSalesRecoder {", bw);
        fileUtils.writeFileAndPrintConsole("}", bw);
        fileUtils.closeWriteSteam(bw);
    }
}
