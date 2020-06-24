package com.app.creater;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.app.util.Field;
import com.app.util.FileUtils;

/**
 * mybatis的映射xml内容生成类
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
    /* mybatis匹配xml路径 */
    private static final String MAPPING_XML_LOCATION = "src\\main\\java\\com\\app\\mapping\\";
    /* 换行 */
    private static final String CRLF = "\r\n";
    /* 4空格 */
    private static final String FOUR_SPACE = "    ";
    /* 2空格 */
    private static final String TWO_SPACE = "  ";
    /* 2空格 */
    private String TABLE_NM = "";
    /* 工程路径 */
    private String projectPath = "";
    /* DB实体类名 */
    private String modelClassNm = "";
    /* repository名 */
    private String repositoryNm = "";
    /* mybatis的匹配resultMap */
    private String resultMapNm = "";
    /* mybatis的参数parameterType */
    private String parameterType = "";

    private List<Field> fields = new ArrayList<Field>();
    FileUtils fileUtil;

    public MybatisCreater(String tblNm) {
        fileUtil = new FileUtils();
        projectPath = fileUtil.getPath();
        TABLE_NM = tblNm;
        modelClassNm =fileUtil.changeNm(TABLE_NM, true);
        resultMapNm = modelClassNm+"ResultMap";
        repositoryNm = modelClassNm+"Repository";
        File tableDDL = new File(projectPath + RESOUCE_LOCATION + TABLE_NM + ".sql");
        // 取得DDL内容
        fields = fileUtil.getFieldListFromDDL(tableDDL);
        parameterType = "com.app.model."+modelClassNm;
    }

    public static void main(String[] args) {
        String[] targetTblList = new String[] {"HERO"};
        for(String tbl : targetTblList) {
            MybatisCreater thisClass = new MybatisCreater(tbl);
            thisClass.createMybatisFileSet();
        }
    }

    /**
     * 创建持久层相关文件群
     */
    public void createMybatisFileSet() {
        createModel();
        createMappingXml();
    }

    /**
     * 创建model实体类
     *
     */
    public void createModel() {
      //DB映射实体类
        String modelClassInfo = createModel(fields);
        String modelClassPath = projectPath+MODEL_LOCATION+modelClassNm+".java";
        fileUtil.writeFile(modelClassPath, modelClassInfo);
    }

    /**
     * 创建mybatis的xml
     *
     */
    public List<Field> createMappingXml() {
        // myBatis的xml
        StringBuilder mybatisXml = new StringBuilder();
        mybatisXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"+CRLF);
        mybatisXml.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >"+CRLF);
        mybatisXml.append("<mapper namespace=\"com.app.repository."+repositoryNm+"\" >"+CRLF);
        // <resultMap>
        mybatisXml.append(createResultMap(fields));
        // <sql id="select_column_list">
        mybatisXml.append(createSelectCol(fields));
        // <sql id="insert_column_list">
        mybatisXml.append(createInsertCol(fields));
        // <select id="selectOne">
        mybatisXml.append(createSelectOne(fields));
        // <select id="selectByDto">
        mybatisXml.append(createSelectByDto(fields));
        // <update>
        mybatisXml.append(createUpdate(fields));
        // <insert>
        mybatisXml.append(createInsert(fields));
        mybatisXml.append("</mapper>"+CRLF);
        String xmlPath = projectPath + MAPPING_XML_LOCATION +modelClassNm+"Mapper.xml";
        fileUtil.writeFile(xmlPath, mybatisXml.toString());
        return fields;
    }

    /**
     * 创建Repository
     */
    public void createRepository() {
        String repostioryPath = projectPath + REPOSITORY_LOCATION +repositoryNm+".java";
        StringBuilder repository = new StringBuilder();
        fileUtil.writeFile(repostioryPath, repository.toString());
    }

    /**
     * 生成DB映射实体类
     *
     * @param tableNm
     * @param fields
     */
    public String createModel(List<Field> fields) {
        StringBuilder javaClass = new StringBuilder();
        javaClass.append("package com.app.model;"+CRLF+CRLF);
        javaClass.append("import java.util.Date;"+CRLF+CRLF);
        javaClass.append("public class "+modelClassNm+"{"+CRLF);
        StringBuilder param = new StringBuilder();
        StringBuilder setAndGet = new StringBuilder();
        for(Field field : fields) {
            String logicNm = field.getLogicNm();
            String javaNm = field.getJavaNm();
            String type = field.getJavaType();
            param.append(FOUR_SPACE+"/**"+CRLF);
            param.append(FOUR_SPACE+" * "+logicNm+CRLF);
            param.append(FOUR_SPACE+" */"+CRLF);
            param.append(FOUR_SPACE+"private "+field.getJavaType()+" "+field.getJavaNm()+";"+CRLF+CRLF);

            setAndGet.append(FOUR_SPACE+"/**"+CRLF);
            setAndGet.append(FOUR_SPACE+" * 设定"+logicNm+CRLF);
            setAndGet.append(FOUR_SPACE+" */"+CRLF);
            setAndGet.append(FOUR_SPACE+"public void set"+fileUtil.changeNm(javaNm, true)+"("+type+" "+javaNm+"){"+CRLF);
            setAndGet.append(FOUR_SPACE+"    this."+javaNm+" = "+javaNm+";"+CRLF);
            setAndGet.append(FOUR_SPACE+"}"+CRLF+CRLF);
            setAndGet.append(FOUR_SPACE+"/**"+CRLF);
            setAndGet.append(FOUR_SPACE+" * 取得"+logicNm+CRLF);
            setAndGet.append(FOUR_SPACE+" */"+CRLF);
            setAndGet.append(FOUR_SPACE+"public "+type+" get"+fileUtil.changeNm(javaNm, true)+"(){"+CRLF);
            setAndGet.append(FOUR_SPACE+"    return "+javaNm+";"+CRLF);
            setAndGet.append(FOUR_SPACE+"}"+CRLF);
        }
        javaClass.append(param.toString());
        javaClass.append(setAndGet.toString());
        javaClass.append(CRLF+"}");
        return javaClass.toString();
    }

    /**
     * mybatis的xml的resultMap
     */
    public String createResultMap(List<Field> fields) {
        StringBuilder resultMap = new StringBuilder();
        resultMap.append(TWO_SPACE+"<resultMap id=\""+resultMapNm+"\" type=\""+parameterType+"\" >"+CRLF);
        for(Field field : fields) {
            String tag = "result";
            if("ID".equals(field.getDbNm())) {
                tag = "id";
            }
            resultMap.append(FOUR_SPACE+"<"+tag+" column=\""+field.getDbNm()+"\" property=\""+field.getJavaNm()+"\" jdbcType=\""+field.getDbType()+"\" />"+CRLF);
        }
        resultMap.append(TWO_SPACE+"</resultMap>"+CRLF+CRLF);
        return resultMap.toString();
    }

    /**
     * select字段
     */
    public String createSelectCol(List<Field> fields) {
        StringBuilder selectColumns = new StringBuilder();
        selectColumns.append(TWO_SPACE+"<sql id=\"select_column_list\">"+CRLF);
        boolean firstLine = true;
        for(Field field : fields) {
            String comma = ",";
            if (firstLine) {
                comma = "";
                firstLine = false;
            }
            selectColumns.append(FOUR_SPACE+comma+TABLE_NM+"."+field.getDbNm()+CRLF);
            firstLine = false;
        }
        selectColumns.append(TWO_SPACE+"</sql>"+CRLF+CRLF);
        return selectColumns.toString();
    }

    /**
     * insert字段
     */
    public String createInsertCol(List<Field> fields) {
        StringBuilder selectColumns = new StringBuilder();
        selectColumns.append(TWO_SPACE+"<sql id=\"insert_column_list\">"+CRLF);
        boolean first = true;
        for(Field field : fields) {
            String comma = ",";
            if (first) {
                comma = "";
                first = false;
            }
            selectColumns.append(FOUR_SPACE+comma+field.getDbNm()+CRLF);
        }
        selectColumns.append(TWO_SPACE+"</sql>"+CRLF+CRLF);
        return selectColumns.toString();
    }

    /**
     * 通过ID主键查找唯一1条
     */
    public String createSelectOne(List<Field> fields) {
        StringBuilder selectOne = new StringBuilder();
        selectOne.append(TWO_SPACE+"<select id=\"selectOne\" resultMap=\""+resultMapNm+"\">"+CRLF);
        selectOne.append(FOUR_SPACE+"SELECT"+CRLF);
        selectOne.append(FOUR_SPACE+"<include refid=\"insert_column_list\"></include>"+CRLF);
        selectOne.append(FOUR_SPACE+"FROM "+TABLE_NM+CRLF);
        selectOne.append(FOUR_SPACE+"WHERE"+CRLF);
        for(Field field : fields) {
            if (field.isPrimaryKey()) {
                selectOne.append(FOUR_SPACE+TWO_SPACE+field.getDbNm()+" = "+"#{"+field.getJavaNm()+"}"+CRLF);
            }
        }
        selectOne.append(TWO_SPACE+"</select>"+CRLF+CRLF);
        return selectOne.toString();
    }

    /**
     * 复杂查询
     */
    public String createSelectByDto(List<Field> fields) {
        StringBuilder selectByDto = new StringBuilder();
        selectByDto.append(TWO_SPACE+"<select id=\"selectByDto\" parameterType=\""+parameterType+"\" resultMap=\""+resultMapNm+"\">"+CRLF);
        selectByDto.append(FOUR_SPACE+"SELECT"+CRLF);
        selectByDto.append(FOUR_SPACE+"<include refid=\"insert_column_list\"></include>"+CRLF);
        selectByDto.append(FOUR_SPACE+"FROM "+TABLE_NM+CRLF);
        selectByDto.append(FOUR_SPACE+"<where>"+CRLF);
        selectByDto.append(createColCheck(fields,"select"));
        selectByDto.append(FOUR_SPACE+"</where>"+CRLF);
        selectByDto.append(FOUR_SPACE+"</select>"+CRLF+CRLF);
        return selectByDto.toString();
    }

    /**
     * 更新
     */
    public String createUpdate(List<Field> fields) {
        StringBuilder update = new StringBuilder();
        update.append(TWO_SPACE+"<update id=\"update\" parameterType=\""+parameterType+"\" >"+CRLF);
        update.append(FOUR_SPACE+"UPDATE"+CRLF);
        update.append(FOUR_SPACE+TWO_SPACE+TABLE_NM+CRLF);
        update.append(FOUR_SPACE+"SET"+CRLF);
        update.append(createColCheck(fields,"update"));
        update.append(FOUR_SPACE+"WHERE"+CRLF);
        for(Field field : fields) {
            if (field.isPrimaryKey()) {
                update.append(FOUR_SPACE+TWO_SPACE+field.getDbNm()+" = "+"#{"+field.getJavaNm()+"}"+CRLF);
            }
        }
        update.append(TWO_SPACE+"</update>"+CRLF+CRLF);
        return update.toString();
    }

    public String createInsert(List<Field> fields) {
        StringBuilder insert = new StringBuilder();
        insert.append(TWO_SPACE+"<insert id=\"insert\" parameterType=\""+parameterType+"\" >"+CRLF);
        insert.append(FOUR_SPACE+"INSERT INTO "+TABLE_NM+"("+CRLF);
        insert.append(FOUR_SPACE+"<include refid=\"insert_column_list\"></include>"+CRLF);
        insert.append(FOUR_SPACE+")VALUES("+CRLF);
        boolean firstFlg = true;
        for(Field field : fields) {
            String comma = ",";
            if (firstFlg) {
                comma = "";
            }
            insert.append(FOUR_SPACE+TWO_SPACE+comma+"#{"+field.getJavaNm()+"}"+CRLF);
        }
        insert.append(FOUR_SPACE+")"+CRLF);
        insert.append(TWO_SPACE+"</insert>"+CRLF);
        return insert.toString();
    }


    /**
     * mybatis的字段空判断
     */
    private String createColCheck(List<Field> fields,String kbn) {
        StringBuilder condition = new StringBuilder();
        boolean firstKbn = true;
        for(Field field : fields) {
            if (field.isPrimaryKey()) {
                continue;
            }
            String comma = ",";
            if (firstKbn || "select".equals(kbn)) {
                comma = "";
                firstKbn = false;
            }
            condition.append(FOUR_SPACE+TWO_SPACE+"<if test=\""+field.getJavaNm()+"!=null\">"+CRLF);
            condition.append(FOUR_SPACE+TWO_SPACE+comma+field.getDbNm()+" = "+"#{"+field.getJavaNm()+"}"+CRLF);
            condition.append(FOUR_SPACE+TWO_SPACE+"</if>"+CRLF);
        }
        return condition.toString();
    }
}
