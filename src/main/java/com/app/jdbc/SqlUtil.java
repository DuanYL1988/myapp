package com.app.jdbc;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class SqlUtil {

    public static final String UNDERLINE = "_";

    public static final String APOSTROPHE = "'";

    public static final String BLANK = " ";

    public static final String COMMA = ",";

    public static final String EQUAL_SIGN = "=";

    public static final String DB_TYPE_VARCHAR = "VARCHAR";

    public static final String DB_TYPE_INT = "INT";

    /**
     * 数据库字段名转为java变量名
     * 
     * @param fieldName
     * @return
     */
    public String dbNameToJavaName(String fieldName) {
        String javaName = "";
        // 大写转小写
        fieldName = fieldName.toLowerCase();
        //
        String[] name = fieldName.split(UNDERLINE);
        // 转换
        javaName = name[0];
        for (int i = 1; i < name.length; i++) {
            // 首字母大写
            javaName += name[i].substring(0, 1).toUpperCase();
            javaName += name[i].substring(1);
        }
        return javaName;
    }

    /**
     * 生成select部分
     * 
     * @param tableName
     * @param fields
     * @return
     */
    public String createSelectQuery(String tableName, List<FieldInfo> fields) {
        StringBuilder select = new StringBuilder("SELECT ");
        int index = 0;
        for (FieldInfo field : fields) {
            if (index == fields.size() - 1) {
                select.append(field.getName() + BLANK + " FROM " + tableName);
            } else {
                select.append(field.getName() + COMMA);
            }
            index++;
        }
        return select.toString();
    }

    /**
     * 生成where部分
     * 
     * @param map
     * @return
     */
    public String createWhereQuery(Map<String, String> map) {
        StringBuilder where = new StringBuilder(" WHERE 1=1 ");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            String value = map.get(key);
            if (StringUtils.isNotEmpty(value)) {
                where.append(" AND " + key + EQUAL_SIGN + APOSTROPHE + value
                        + APOSTROPHE);
            }
        }
        return where.toString();
    }


    /**
     * 万能插入数据
     * 
     * @param tableName
     * @param fields
     */
    public String doInsert(String tableName, List<FieldInfo> fields) {
        StringBuilder sqlBuilder = new StringBuilder(
                "INSERT INTO " + tableName + "(");
        StringBuilder valueBuilder = new StringBuilder(" VALUES (");
        for (int i = 0; i < fields.size(); i++) {
            // mysql的自增主键,跳过设置SQL
            if (fields.get(i).getExtra().toLowerCase()
                    .equals("auto_increment")) {
                continue;
            }
            if (!StringUtils.isEmpty(fields.get(i).getValue())) {
                sqlBuilder.append(fields.get(i).getName() + COMMA);
                if (fields.get(i).getValue().indexOf("CURRENT_") >= 0) {
                    valueBuilder.append(fields.get(i).getValue() + COMMA);
                } else {
                    valueBuilder.append(APOSTROPHE + fields.get(i).getValue() + "',");
                }
            }
        }
        // 去除最后的一个,
        sqlBuilder = new StringBuilder(
                sqlBuilder.substring(0, sqlBuilder.length() - 1).toString());
        sqlBuilder.append(")");
        valueBuilder = new StringBuilder(valueBuilder
                .substring(0, valueBuilder.length() - 1).toString());
        valueBuilder.append(")");
        // 连接
        sqlBuilder.append(valueBuilder);
        System.out.println("生产的insert文 :" + sqlBuilder.toString());
        return sqlBuilder.toString();
    }

    /**
     * 万能更新数据 主键的值必须设上
     * 
     * @param tableName
     * @param fields
     */
    public String doUpdate(String tableName, List<FieldInfo> fields) {
        StringBuilder sqlBuilder = new StringBuilder(
                "UPDATE  " + tableName + " SET ");
        StringBuilder whereBuilder = new StringBuilder(" WHERE 1 = 1 ");
        boolean errorFlg = false;
        for (int i = 0; i < fields.size(); i++) {
            // 主键作为更新条件
            if (!StringUtils.isEmpty(fields.get(i).getKeyInfo())) {
                whereBuilder.append(" AND " + fields.get(i).getName() + " = '"
                        + fields.get(i).getValue() + APOSTROPHE);
                continue;
            } else {
                // 不能为空的字段判断
                if (!fields.get(i).isNull()) {
                    if (StringUtils.isEmpty(fields.get(i).getValue())) {
                        System.out.println("--> 有不能为空的字段没有设值,字段名:"
                                + fields.get(i).getName());
                        errorFlg = true;
                    }
                }
                // 字段设值
                if (!StringUtils.isEmpty(fields.get(i).getValue())) {
                    sqlBuilder.append(fields.get(i).getName() + " = '"
                            + fields.get(i).getValue() + "',");
                }
            }
        }
        if (errorFlg) {
            return "";
        }
        sqlBuilder = new StringBuilder(
                sqlBuilder.substring(0, sqlBuilder.length() - 1).toString());
        // 连接
        sqlBuilder.append(whereBuilder);
        System.out.println("生产的update文 :" + sqlBuilder.toString());
        return sqlBuilder.toString();
    }

}
