package com.app.creater;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.app.util.CommonUtils;
import com.app.util.Field;
import com.app.util.FileUtils;

/**
 * MYBATIS的映射xml内容生成类
 *
 * @author dylsw
 *
 */
public class MybatisCreater {

    /* 资源路径 */
    private static final String RESOUCE_LOCATION = "src\\main\\resources\\dbRes\\";
    /* 实体类路径 */
    private static final String MODEL_LOCATION = "src\\main\\java\\com\\app\\model\\";
    /* Repository路径 */
    private static final String REPOSITORY_LOCATION = "src\\main\\java\\com\\app\\repository\\";
    /* MYBATIS匹配XML路径 */
    private static final String MAPPING_XML_LOCATION = "src\\main\\java\\com\\app\\mapping\\";
    /* 换行 */
    private static final String CRLF = "\r\n";
    /* 4空格 */
    private static final String FOUR_SPACE = "    ";
    /* 2空格 */
    private static final String TWO_SPACE = "  ";
    /* 2空格 */
    private static boolean FILE_OUTPUT_FLAG = false;
    /* 表名 */
    private String TABLE_NM = "";

    /* 函数-通过ID查找唯一记录 */
    private static final String METHOD_SELECT_ONE_BY_ID = "selectOneById";
    /* 函数-通过逻辑字段查找唯一记录 */
    private static final String METHOD_SELECT_ONE_BY_UNIQUE_KEY = "selectOneByUniqueKey";
    /* 自定義SQL */
    private static final String METHOD_CUSTOM_QUARY = "customQuary";

    /* 工程路径 */
    private String projectPath = "";
    /* DB实体类名 */
    private String modelClassNm = "";
    /* repository名 */
    private String repositoryNm = "";
    /* MYBATIS的匹配resultMap */
    private String resultMapNm = "";
    /* MYBATIS的参数parameterType */
    private String parameterType = "";

    /* 表字段集合 */
    private List<Field> fields = new ArrayList<Field>();

    /* 逻辑上不重复字段 */
    private List<Field> uniqueCol = new ArrayList<Field>();

    /* 日期字段判断FLAG */
    private boolean dateColFlag = false;

    FileUtils fileUtil;

    CommonUtils commonUtil;

    public MybatisCreater(String tblNm) {
        fileUtil = new FileUtils();
        commonUtil = new CommonUtils();
        projectPath = fileUtil.getPath();
        TABLE_NM = tblNm;
        modelClassNm = commonUtil.changeNm(TABLE_NM, true);
        resultMapNm = modelClassNm + "ResultMap";
        repositoryNm = modelClassNm + "Repository";
        File tableDDL = new File(projectPath + RESOUCE_LOCATION + TABLE_NM + ".sql");
        // 取得DDL内容
        fields = fileUtil.getFieldListFromDDL(tableDDL);
        uniqueCol = getExistColumn();
        parameterType = "com.app.model." + modelClassNm;
    }

    public static void main(String[] args) {
        FILE_OUTPUT_FLAG = true;
        // 需要创建的匹配表名称
        String[] targetTblList = new String[] { "HERO" };
        for (String tbl : targetTblList) {
            MybatisCreater thisClass = new MybatisCreater(tbl);
            thisClass.createMybatisFileSet();
        }
    }

    /**
     * 创建持久层相关文件群
     */
    public void createMybatisFileSet() {
        // DB映射实体类
        String modelClassPath = projectPath + MODEL_LOCATION + modelClassNm + ".java";
        String modelClassInfo = createModel();
        // Mybatis映射xml
        String xmlPath = projectPath + MAPPING_XML_LOCATION + modelClassNm + "Mapper.xml";
        String xmlInfo = createMappingXml();
        // Repository类
        String repostioryPath = projectPath + REPOSITORY_LOCATION + repositoryNm + ".java";
        String repostioryInfo = createRepository();
        // 是否生成文件
        if (FILE_OUTPUT_FLAG) {
            fileUtil.writeFile(modelClassPath, modelClassInfo);
            fileUtil.writeFile(xmlPath, xmlInfo);
            fileUtil.writeFile(repostioryPath, repostioryInfo);
        } else {
            System.out.println(modelClassInfo);
            System.out.println(xmlInfo);
            System.out.println(repostioryInfo);
        }
    }

    /**
     * 创建MYBATIS的xml
     *
     */
    public String createMappingXml() {
        // myBatis的xml
        StringBuilder MYBATISXml = new StringBuilder();
        MYBATISXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" + CRLF);
        MYBATISXml.append(
                "<!DOCTYPE mapper PUBLIC \"-//MYBATIS.org//DTD Mapper 3.0//EN\" \"http://MYBATIS.org/dtd/MYBATIS-3-mapper.dtd\" >"
                        + CRLF);
        MYBATISXml.append("<mapper namespace=\"com.app.repository." + repositoryNm + "\" >" + CRLF);
        // <resultMap>
        MYBATISXml.append(createResultMap());
        // <sql id="select_column_list">
        MYBATISXml.append(createSelectCol());
        // <sql id="insert_column_list">
        MYBATISXml.append(createInsertCol());
        // <select id="selectOneById">
        MYBATISXml.append(createSelectOneById());
        // <select id="selectOneByUniqueKey">
        MYBATISXml.append(createSelectOneByUniqueKey());
        // <select id="selectByDto">
        MYBATISXml.append(createSelectByDto());
        // <select id="uniqueCheck">
        MYBATISXml.append(createExistCheck());
        // <update>
        MYBATISXml.append(createUpdate());
        // <insert>
        MYBATISXml.append(createInsert());
        // <select id="customQuary">
        MYBATISXml.append(createCustomQuery());

        // 结束标签
        MYBATISXml.append("</mapper>" + CRLF);
        return MYBATISXml.toString();
    }

    /**
     * 创建Repository
     */
    public String createRepository() {
        StringBuilder repository = new StringBuilder();
        // package和import
        repository.append("package com.app.repository;" + CRLF + CRLF);
        repository.append("import java.util.List;" + CRLF);
        repository.append("import org.apache.ibatis.annotations.Param;" + CRLF);
        repository.append("import org.springframework.stereotype.Repository;" + CRLF + CRLF);
        repository.append("import com.app.model." + modelClassNm + ";" + CRLF + CRLF);
        repository.append("@Repository" + CRLF);
        repository.append("public interface " + repositoryNm + "{" + CRLF);
        // selectOneById
        repository.append(FOUR_SPACE + modelClassNm + " " + METHOD_SELECT_ONE_BY_ID + "(@Param(\"id\")Integer id);"
                + CRLF + CRLF);
        // 通过检索Dto查找
        repository.append(FOUR_SPACE + "List<" + modelClassNm + "> selectByDto(" + modelClassNm + " "
                + commonUtil.changeNm(TABLE_NM, false) + ");" + CRLF + CRLF);
        // 插入
        repository.append(FOUR_SPACE + "void insert(" + modelClassNm + " " + commonUtil.changeNm(TABLE_NM, false) + ");"
                + CRLF + CRLF);
        // 更新
        repository.append(FOUR_SPACE + "void update(" + modelClassNm + " " + commonUtil.changeNm(TABLE_NM, false) + ");"
                + CRLF + CRLF);

        // 逻辑字段编辑
        StringBuilder uniqueCondition = new StringBuilder();
        for (int i = 0; i < uniqueCol.size(); i++) {
            String mark = ",";
            if (i == uniqueCol.size() - 1) {
                mark = ");" + CRLF + CRLF;
            }
            String javaNm = uniqueCol.get(i).getJavaNm();
            uniqueCondition.append("@Param(\"" + javaNm + "\")String " + javaNm + mark);
        }

        // 排他check以及鉴证用
        repository.append(FOUR_SPACE + "int uniqueCheck(");
        repository.append(uniqueCondition.toString());
        // selectOneByUniqueKey
        repository.append(FOUR_SPACE + modelClassNm + " " + METHOD_SELECT_ONE_BY_UNIQUE_KEY + "(");
        repository.append(uniqueCondition.toString());
        // 自定義查找
        repository.append(FOUR_SPACE + "List<" + modelClassNm + "> " + METHOD_CUSTOM_QUARY + "(" + modelClassNm + " "
                + commonUtil.changeNm(TABLE_NM, false) + ");" + CRLF + CRLF);

        repository.append("}");
        return repository.toString();
    }

    /**
     * 生成DB映射实体类
     *
     */
    public String createModel() {
        StringBuilder javaClass = new StringBuilder();
        javaClass.append("package com.app.model;" + CRLF + CRLF);
        // 有日期字段时引入Data类
        if (dateColFlag) {
            javaClass.append("import java.util.Date;" + CRLF + CRLF);
        }

        javaClass.append("public class " + modelClassNm + " extends ExpandCondition {" + CRLF);
        // 参数部分
        StringBuilder param = new StringBuilder();
        // get和set部分
        StringBuilder setAndGet = new StringBuilder();

        for (Field field : fields) {
            String logicNm = field.getLogicNm();
            String javaNm = field.getJavaNm();
            String type = field.getJavaType();
            // 说明doc
            param.append(FOUR_SPACE + "/**" + CRLF);
            param.append(FOUR_SPACE + " * " + logicNm + CRLF);
            param.append(FOUR_SPACE + " */" + CRLF);

            // 输出参数
            param.append(FOUR_SPACE + "private " + field.getJavaType() + " " + field.getJavaNm() + ";" + CRLF + CRLF);

            // 输出set和get
            setAndGet.append(FOUR_SPACE + "/**" + CRLF);
            setAndGet.append(FOUR_SPACE + " * 设定" + logicNm + CRLF);
            setAndGet.append(FOUR_SPACE + " */" + CRLF);
            setAndGet.append(FOUR_SPACE + "public void set" + commonUtil.changeNm(field.getDbNm(), true) + "(" + type
                    + " " + javaNm + "){" + CRLF);
            // this.location = null == location ? "" : location;
            if ("String".equals(type)) {
                setAndGet.append(FOUR_SPACE + "    this." + javaNm + " = null == " + javaNm + " ? \"\" : " + javaNm
                        + ";" + CRLF);
            } else {
                setAndGet.append(FOUR_SPACE + "    this." + javaNm + " = " + javaNm + ";" + CRLF);
            }
            setAndGet.append(FOUR_SPACE + "}" + CRLF + CRLF);
            setAndGet.append(FOUR_SPACE + "/**" + CRLF);
            setAndGet.append(FOUR_SPACE + " * 取得" + logicNm + CRLF);
            setAndGet.append(FOUR_SPACE + " */" + CRLF);
            setAndGet.append(
                    FOUR_SPACE + "public " + type + " get" + commonUtil.changeNm(field.getDbNm(), true) + "(){" + CRLF);
            setAndGet.append(FOUR_SPACE + "    return " + javaNm + ";" + CRLF);
            setAndGet.append(FOUR_SPACE + "}" + CRLF);
        }

        javaClass.append(param.toString());
        javaClass.append(setAndGet.toString());
        javaClass.append(CRLF + "}");
        return javaClass.toString();
    }

    /**
     * MYBATIS的XML的resultMap
     */
    public String createResultMap() {
        StringBuilder resultMap = new StringBuilder();
        resultMap.append(TWO_SPACE + "<resultMap id=\"" + resultMapNm + "\" type=\"" + parameterType + "\" >" + CRLF);
        for (Field field : fields) {
            String tag = "result";
            if ("ID".equals(field.getDbNm())) {
                tag = "id";
            }
            String jdbcType = field.getDbType();
            if ("NUMBER".equals(jdbcType)) {
                jdbcType = "INTEGER";
            } else if ("VARCHAR2".equals(jdbcType)) {
                jdbcType = "VARCHAR";
            }
            resultMap.append(FOUR_SPACE + "<" + tag + " column=\"" + field.getDbNm() + "\" property=\""
                    + field.getJavaNm() + "\" jdbcType=\"" + jdbcType + "\" />" + CRLF);
        }
        resultMap.append(TWO_SPACE + "</resultMap>" + CRLF + CRLF);
        return resultMap.toString();
    }

    /**
     * select字段
     */
    public String createSelectCol() {
        StringBuilder selectColumns = new StringBuilder();
        selectColumns.append(TWO_SPACE + "<sql id=\"select_column_list\">" + CRLF);
        boolean firstLine = true;
        for (Field field : fields) {
            String comma = ",";
            if (firstLine) {
                comma = "";
                firstLine = false;
            }
            selectColumns.append(FOUR_SPACE + comma + TABLE_NM + "." + field.getDbNm() + CRLF);
            firstLine = false;
        }
        selectColumns.append(TWO_SPACE + "</sql>" + CRLF + CRLF);
        return selectColumns.toString();
    }

    /**
     * insert字段
     */
    public String createInsertCol() {
        StringBuilder selectColumns = new StringBuilder();
        selectColumns.append(TWO_SPACE + "<sql id=\"insert_column_list\">" + CRLF);
        boolean first = true;
        for (Field field : fields) {
            String comma = ",";
            if (first) {
                comma = "";
                first = false;
            }
            selectColumns.append(FOUR_SPACE + comma + field.getDbNm() + CRLF);
        }
        selectColumns.append(TWO_SPACE + "</sql>" + CRLF + CRLF);
        return selectColumns.toString();
    }

    /**
     * 通过ID主键查找唯一1条
     */
    public String createSelectOneById() {
        StringBuilder selectOne = new StringBuilder();
        selectOne.append(
                TWO_SPACE + "<select id=\"" + METHOD_SELECT_ONE_BY_ID + "\" resultMap=\"" + resultMapNm + "\">" + CRLF);
        selectOne.append(FOUR_SPACE + "SELECT" + CRLF);
        selectOne.append(FOUR_SPACE + TWO_SPACE + "<include refid=\"select_column_list\"></include>" + CRLF);
        selectOne.append(FOUR_SPACE + "FROM " + CRLF);
        selectOne.append(FOUR_SPACE + TWO_SPACE + TABLE_NM + CRLF);
        selectOne.append(FOUR_SPACE + "WHERE" + CRLF);
        for (Field field : fields) {
            if (field.isPrimaryKey()) {
                selectOne.append(
                        FOUR_SPACE + TWO_SPACE + field.getDbNm() + " = " + "#{" + field.getJavaNm() + "}" + CRLF);
            }
        }
        selectOne.append(TWO_SPACE + "</select>" + CRLF + CRLF);
        return selectOne.toString();
    }

    /**
     * 通过ID主键查找唯一1条
     */
    public String createSelectOneByUniqueKey() {
        StringBuilder selectOne = new StringBuilder();
        selectOne.append(TWO_SPACE + "<select id=\"" + METHOD_SELECT_ONE_BY_UNIQUE_KEY + "\" resultMap=\"" + resultMapNm
                + "\">" + CRLF);
        selectOne.append(FOUR_SPACE + "SELECT" + CRLF);
        selectOne.append(FOUR_SPACE + TWO_SPACE + "<include refid=\"select_column_list\"></include>" + CRLF);
        selectOne.append(FOUR_SPACE + "FROM " + CRLF);
        selectOne.append(FOUR_SPACE + TWO_SPACE + TABLE_NM + CRLF);
        selectOne.append(FOUR_SPACE + "<where>" + CRLF);
        for (Field field : uniqueCol) {
            appendCheckCols(selectOne, field, "AND");
        }
        selectOne.append(FOUR_SPACE + "</where>" + CRLF);
        selectOne.append(TWO_SPACE + "</select>" + CRLF + CRLF);
        return selectOne.toString();
    }

    /**
     * 复杂查询
     */
    public String createSelectByDto() {
        StringBuilder selectByDto = new StringBuilder();
        selectByDto.append(TWO_SPACE + "<select id=\"selectByDto\" parameterType=\"" + parameterType + "\" resultMap=\""
                + resultMapNm + "\">" + CRLF);
        selectByDto.append(FOUR_SPACE + "SELECT" + CRLF);
        selectByDto.append(FOUR_SPACE + TWO_SPACE + "<include refid=\"select_column_list\"></include>" + CRLF);
        selectByDto.append(FOUR_SPACE + "FROM " + CRLF);
        selectByDto.append(FOUR_SPACE + TWO_SPACE + TABLE_NM + CRLF);
        selectByDto.append(FOUR_SPACE + "<where>" + CRLF);
        selectByDto.append(createColCheck(fields, "select"));
        selectByDto.append(FOUR_SPACE + TWO_SPACE + "<if test=\"condition!=null and condition!=''\">" + CRLF);
        selectByDto.append(FOUR_SPACE + FOUR_SPACE + "${condition}" + CRLF);
        selectByDto.append(FOUR_SPACE + TWO_SPACE + "</if>" + CRLF);
        selectByDto.append(FOUR_SPACE + "</where>" + CRLF);
        selectByDto.append(FOUR_SPACE + "<if test=\"orderBy!=null\">" + CRLF);
        selectByDto.append(FOUR_SPACE + "  ORDER BY ${orderBy}" + CRLF);
        selectByDto.append(FOUR_SPACE + "</if>" + CRLF);
        selectByDto.append(TWO_SPACE + "</select>" + CRLF + CRLF);
        return selectByDto.toString();
    }

    /**
     * 更新
     */
    public String createUpdate() {
        StringBuilder update = new StringBuilder();
        update.append(TWO_SPACE + "<update id=\"update\" parameterType=\"" + parameterType + "\" >" + CRLF);
        update.append(FOUR_SPACE + "UPDATE" + CRLF);
        update.append(FOUR_SPACE + TWO_SPACE + TABLE_NM + CRLF);
        update.append(FOUR_SPACE + "<set>" + CRLF);
        update.append(createColCheck(fields, "update"));
        update.append(FOUR_SPACE + "</set>" + CRLF);
        update.append(FOUR_SPACE + "WHERE" + CRLF);
        for (Field field : fields) {
            if (field.isPrimaryKey()) {
                update.append(FOUR_SPACE + TWO_SPACE + field.getDbNm() + " = " + "#{" + field.getJavaNm() + "}" + CRLF);
            }
        }
        update.append(FOUR_SPACE + "<if test=\"condition!=null\">" + CRLF);
        update.append(FOUR_SPACE + "    OR ${condition}" + CRLF);
        update.append(FOUR_SPACE + "</if>" + CRLF);
        update.append(TWO_SPACE + "</update>" + CRLF + CRLF);
        return update.toString();
    }

    /**
     * 追加
     */
    private String createInsert() {
        StringBuilder insert = new StringBuilder();
        insert.append(TWO_SPACE + "<insert id=\"insert\" parameterType=\"" + parameterType + "\" >" + CRLF);
        insert.append(FOUR_SPACE + FOUR_SPACE
                + "<selectKey resultType=\"java.lang.Integer\" order=\"BEFORE\" keyProperty=\"id\">" + CRLF);
        insert.append(FOUR_SPACE + FOUR_SPACE + TWO_SPACE + "SELECT SEQ_" + TABLE_NM + ".NEXTVAL FROM DUAL" + CRLF);
        insert.append(FOUR_SPACE + FOUR_SPACE + "</selectKey>" + CRLF);
        insert.append(FOUR_SPACE + "INSERT INTO " + TABLE_NM + "(" + CRLF);
        insert.append(FOUR_SPACE + "<include refid=\"insert_column_list\"></include>" + CRLF);
//        insert.append(FOUR_SPACE+") VALUES ("+CRLF);
        insert.append(FOUR_SPACE + ") SELECT " + CRLF);
        boolean firstFlg = true;
        String uniqueCondition = FOUR_SPACE + " WHERE 1=1 ";
        for (Field field : fields) {
            String comma = ",";
            if (firstFlg) {
                comma = "";
                firstFlg = false;
            }
            insert.append(FOUR_SPACE + TWO_SPACE + comma + " #{" + field.getJavaNm() + "}" + CRLF);
        }
        for (int i = 0; i < uniqueCol.size(); i++) {

            String javaNm = uniqueCol.get(i).getJavaNm();
            String dbNm = uniqueCol.get(i).getDbNm();
            uniqueCondition += CRLF + FOUR_SPACE + FOUR_SPACE + " AND " + dbNm + " = " + "#{" + javaNm + "} ";
        }
//        insert.append(FOUR_SPACE+")"+CRLF);
        insert.append(FOUR_SPACE + " FROM DUAL " + CRLF);
        insert.append(FOUR_SPACE + " WHERE 1=1 " + CRLF);
        insert.append(FOUR_SPACE + " AND NOT EXISTS " + CRLF);
        insert.append(FOUR_SPACE + " (SELECT 1 FROM " + TABLE_NM + CRLF);
        insert.append(FOUR_SPACE + uniqueCondition + ")" + CRLF);
        insert.append(FOUR_SPACE + " AND ROWNUM = 1" + CRLF);
        insert.append(TWO_SPACE + "</insert>" + CRLF + CRLF);
        return insert.toString();
    }

    private String createCustomQuery() {
        StringBuilder custom = new StringBuilder();

        custom.append("  <select id=\"customQuary\" parameterType=\"" + parameterType + "\" resultType=\""
                + parameterType + "\">" + CRLF);
        custom.append(FOUR_SPACE + "SELECT" + CRLF);
        custom.append("       ${selectQuary}" + CRLF);
        custom.append("    FROM" + CRLF);
        custom.append(FOUR_SPACE + TWO_SPACE + TABLE_NM + CRLF);
        custom.append("    <if test=\"joinPart!=null\">" + CRLF);
        custom.append("        ${joinPart}" + CRLF);
        custom.append("    </if>" + CRLF);
        custom.append("    <where>" + CRLF);
        custom.append("        1 = 1" + CRLF);
        custom.append("        <if test=\"condition!=null\">" + CRLF);
        custom.append("         AND ${condition}" + CRLF);
        custom.append("        </if>" + CRLF);
        custom.append("    </where>" + CRLF);
        custom.append("    <if test=\"groupBy!=null\">" + CRLF);
        custom.append("      GROUP BY ${groupBy}" + CRLF);
        custom.append("    </if>" + CRLF);
        custom.append("    <if test=\"having!=null\">" + CRLF);
        custom.append("      HAVING ${having}" + CRLF);
        custom.append("    </if>" + CRLF);
        custom.append("    <if test=\"orderBy!=null\">" + CRLF);
        custom.append("      ORDER BY ${orderBy}" + CRLF);
        custom.append("    </if>" + CRLF);
        custom.append("  </select>" + CRLF + CRLF);

        return custom.toString();
    }

    /**
     * 业务逻辑上不重复check
     */
    private String createExistCheck() {
        StringBuilder uniqueCheck = new StringBuilder();
        uniqueCheck.append(TWO_SPACE + "<select id=\"uniqueCheck\"  resultType=\"Integer\">" + CRLF);
        uniqueCheck.append(FOUR_SPACE + "SELECT count(*) AS count" + CRLF);
        uniqueCheck.append(FOUR_SPACE + "FROM " + CRLF);
        uniqueCheck.append(FOUR_SPACE + TWO_SPACE + TABLE_NM + CRLF);
        uniqueCheck.append(FOUR_SPACE + "<where>" + CRLF);
        for (Field field : uniqueCol) {
            appendCheckCols(uniqueCheck, field, "AND");
        }
        uniqueCheck.append(FOUR_SPACE + "</where>" + CRLF);
        uniqueCheck.append(TWO_SPACE + "</select>" + CRLF + CRLF);
        return uniqueCheck.toString();
    }

    /**
     * MYBATIS的字段空判断 创建select文时KBN传入"select" select文因为在<where>标签中所以不用加[,]
     *
     * @param 构筑函数中取得的表中所有的字段集合 fields
     * @param select和update的区分  KBN
     * @return
     */
    private String createColCheck(List<Field> fields, String kbn) {
        StringBuilder condition = new StringBuilder();
        boolean updateFlag = "update".equals(kbn);
        String comma = "AND";
        if (updateFlag) {
            comma = ",";
        }
        for (Field field : fields) {
            // update时不更新主键
            if (field.isPrimaryKey() && updateFlag) {
                continue;
            }
            appendCheckCols(condition, field, comma);
        }
        return condition.toString();
    }

    /**
     * MYBATIS使用tag自动去除AND,逗号时使用
     */
    private void appendCheckCols(StringBuilder condition, Field field, String mark) {
        String javaNm = field.getJavaNm();
        condition.append(FOUR_SPACE + TWO_SPACE + "<if test=\"" + javaNm + "!=null and " + javaNm + "!=''\">" + CRLF);
        if ("AND".equals(mark)) {
            condition.append(
                    FOUR_SPACE + FOUR_SPACE + mark + " " + field.getDbNm() + " = " + "#{" + javaNm + "}" + CRLF);
        } else if (",".equals(mark)) {
            condition.append(FOUR_SPACE + FOUR_SPACE + field.getDbNm() + " = " + "#{" + javaNm + "}" + mark + CRLF);
        }
        condition.append(FOUR_SPACE + TWO_SPACE + "</if>" + CRLF);
    }

    /**
     * 业务唯一值字段取得
     */
    private List<Field> getExistColumn() {
        // 业务逻辑上唯一记录的字段集合
        if (uniqueCol.size() > 0) {
            return uniqueCol;
        } else {
            for (Field field : fields) {
                if (field.isExistColumn()) {
                    uniqueCol.add(field);
                }
                // 顺带判断表中是否有日期字段
                if ("TIMESTAMP".equals(field.getDbType())) {
                    dateColFlag = true;
                }
            }
            return uniqueCol;
        }
    }
}
