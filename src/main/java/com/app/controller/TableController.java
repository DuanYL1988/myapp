package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.app.jdbc.FieldInfo;
import com.app.jdbc.JdbcConnectUtil;
import com.app.jdbc.SqlUtil;
import com.app.util.JsonUtil;

@Controller
@RequestMapping(value = "/rigstTable")
public class TableController {

    private static final String RETURN_PATH = "table/index";

    private String tableName;

    @Autowired
    JdbcConnectUtil jdbcUtil;

    @Autowired
    SqlUtil sqlUtil;

    @Autowired
    JsonUtil jsonUtil;

    @RequestMapping(value = "/init")
    public String init(Model model) {
        return RETURN_PATH;
    }

    @RequestMapping(value = "/findTable")
    public String getDatabaseTable(int database,String tablename,Model model) {
        // 选择数据库
        jdbcUtil.mode = database;
        tableName = tablename;
        // oracle時取得sequence的nextval
        if (1 == database) {
            model.addAttribute("nextId", 0);
        }

        // 查询表结构SQL
        List<FieldInfo> columnList = jdbcUtil.getFieldInfo(tablename);
        // 查找数据
        String json = jsonUtil.praseObjToJson(jdbcUtil.excuteSelectQuery(sqlUtil.createSelectQuery(tablename, columnList)));

        model.addAttribute("columnList", columnList);
        // slickgrid表示用
        model.addAttribute("json", json);
        return RETURN_PATH;
    }

    @RequestMapping(value = "/regist")
    @ResponseBody
    public Object regist(@RequestBody String fieldList, Model model) {
        //
        System.out.println(fieldList);
        List<FieldInfo> fields = JSONArray.parseArray(fieldList, FieldInfo.class);
        //
        jdbcUtil.excuteInsertOrUpdateSQL(sqlUtil.doInsert(this.tableName, fields));
        return "SUCCESS";
    }
}
