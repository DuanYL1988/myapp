package com.app.entity;

import java.util.List;

import com.app.jdbc.FieldInfo;
import com.app.jdbc.JdbcConnectUtil;

public class FeEntity {

    private List<FieldInfo> allColumns;

    public static final String TABLE_NAME = "feh_skill_master";

    /**
     * 构造方法
     */
    public FeEntity() {
        // 取得數據庫連接類
        JdbcConnectUtil dbManagement = new JdbcConnectUtil();
        // 设置连接数据库是mysql
        dbManagement.mode = 2;
        // 取得表字段信息
        String descQuery = "desc " + TABLE_NAME + ";";
        // 设置全字段信息
        allColumns = dbManagement.getFieldInfo(descQuery);
    }

    public List<FieldInfo> getAllColumns() {
        return allColumns;
    }

    private Integer id;

    private String skillType;

    private String skillName;

    private String skillColour;

    private Integer skillExtend;

    private Integer skillPower;

    private String skillInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillColour() {
        return skillColour;
    }

    public void setSkillColour(String skillColour) {
        this.skillColour = skillColour;
    }

    public Integer getSkillExtend() {
        return skillExtend;
    }

    public void setSkillExtend(Integer skillExtend) {
        this.skillExtend = skillExtend;
    }

    public Integer getSkillPower() {
        return skillPower;
    }

    public void setSkillPower(Integer skillPower) {
        this.skillPower = skillPower;
    }

    public String getSkillInfo() {
        return skillInfo;
    }

    public void setSkillInfo(String skillInfo) {
        this.skillInfo = skillInfo;
    }

}
