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
    private static boolean FILE_OUTPUT_FLAG = false;
    /* 表名 */
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
    private List<Field> existCol = new ArrayList<Field>();

    private boolean dateColFlag = false;

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
        existCol = getExistColumn();
        parameterType = "com.app.model."+modelClassNm;
    }

    public static void main(String[] args) {
        FILE_OUTPUT_FLAG = true;
        String[] targetTblList = new String[] {"HERO","HERO_CONTENT","HERO_MASTER","SKILL_INFO"};
        for(String tbl : targetTblList) {
            MybatisCreater thisClass = new MybatisCreater(tbl);
            thisClass.createMybatisFileSet();
        }
    }

    /**
     * 创建持久层相关文件群
     */
    public void createMybatisFileSet() {
        //DB映射实体类
        String modelClassPath = projectPath+MODEL_LOCATION+modelClassNm+".java";
        String modelClassInfo = createModel();
        //
        String xmlPath = projectPath + MAPPING_XML_LOCATION +modelClassNm+"Mapper.xml";
        String xmlInfo = createMappingXml();
        //
        String repostioryPath = projectPath + REPOSITORY_LOCATION +repositoryNm+".java";
        String repostioryInfo = createRepository();
        if (FILE_OUTPUT_FLAG) {
            fileUtil.writeFile(modelClassPath, modelClassInfo);
            fileUtil.writeFile(xmlPath, xmlInfo);
            fileUtil.writeFile(repostioryPath, repostioryInfo);
        }
    }

    /**
     * 创建mybatis的xml
     *
     */
    public String createMappingXml() {
        // myBatis的xml
        StringBuilder mybatisXml = new StringBuilder();
        mybatisXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"+CRLF);
        mybatisXml.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >"+CRLF);
        mybatisXml.append("<mapper namespace=\"com.app.repository."+repositoryNm+"\" >"+CRLF);
        // <resultMap>
        mybatisXml.append(createResultMap());
        // <sql id="select_column_list">
        mybatisXml.append(createSelectCol());
        // <sql id="insert_column_list">
        mybatisXml.append(createInsertCol());
        // <select id="selectOne">
        mybatisXml.append(createSelectOne());
        // <select id="selectByDto">
        mybatisXml.append(createSelectByDto());
        // <select id="uniqueCheck">
        mybatisXml.append(createExistCheck());
        // <update>
        mybatisXml.append(createUpdate());
        // <insert>
        mybatisXml.append(createInsert());
        mybatisXml.append("</mapper>"+CRLF);
        return mybatisXml.toString();
    }

    /**
     * 创建Repository
     */
    public String createRepository() {
        StringBuilder repository = new StringBuilder();
        repository.append("package com.app.repository;"+CRLF+CRLF);
        repository.append("import java.util.List;"+CRLF);
        repository.append("import org.apache.ibatis.annotations.Param;"+CRLF);
        repository.append("import org.springframework.stereotype.Repository;"+CRLF+CRLF);
        repository.append("import com.app.model."+modelClassNm+";"+CRLF+CRLF);
        repository.append("@Repository"+CRLF);
        repository.append("public interface "+repositoryNm+"{"+CRLF);
        repository.append(FOUR_SPACE+modelClassNm+" selectOne(@Param(\"id\")Integer id);"+CRLF+CRLF);
        repository.append(FOUR_SPACE+"List<"+modelClassNm+"> selectByDto("+modelClassNm+" " +fileUtil.changeNm(TABLE_NM, false)+");"+CRLF+CRLF);
        repository.append(FOUR_SPACE+"void insert("+modelClassNm+" " +fileUtil.changeNm(TABLE_NM, false)+");"+CRLF+CRLF);
        repository.append(FOUR_SPACE+"void update("+modelClassNm+" " +fileUtil.changeNm(TABLE_NM, false)+");"+CRLF+CRLF);
        repository.append(FOUR_SPACE+"int uniqueCheck(");
        for(int i=0;i<existCol.size();i++) {
            String mark = ",";
            if (i==existCol.size()-1) {
                mark=");"+CRLF+CRLF;
            }
            String javaNm = existCol.get(i).getJavaNm();
            repository.append("@Param(\""+javaNm+"\")String "+javaNm+mark);
        }
        repository.append("}");
        return repository.toString();
    }

    /**
     * 生成DB映射实体类
     *
     * @param tableNm
     * @param fields
     */
    public String createModel() {
        StringBuilder javaClass = new StringBuilder();
        javaClass.append("package com.app.model;"+CRLF+CRLF);
        if(dateColFlag) {
            javaClass.append("import java.util.Date;"+CRLF+CRLF);
        }
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
    public String createResultMap() {
        StringBuilder resultMap = new StringBuilder();
        resultMap.append(TWO_SPACE+"<resultMap id=\""+resultMapNm+"\" type=\""+parameterType+"\" >"+CRLF);
        for(Field field : fields) {
            String tag = "result";
            if("ID".equals(field.getDbNm())) {
                tag = "id";
            }
            String jdbcType = field.getDbType();
            if ("NUMBER".equals(jdbcType)) {
                jdbcType = "INTEGER";
            } else if ("VARCHAR2".equals(jdbcType)) {
                jdbcType = "VARCHAR";
            }
            resultMap.append(FOUR_SPACE+"<"+tag+" column=\""+field.getDbNm()+"\" property=\""+field.getJavaNm()+"\" jdbcType=\""+jdbcType+"\" />"+CRLF);
        }
        resultMap.append(TWO_SPACE+"</resultMap>"+CRLF+CRLF);
        return resultMap.toString();
    }

    /**
     * select字段
     */
    public String createSelectCol() {
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
    public String createInsertCol() {
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
    public String createSelectOne() {
        StringBuilder selectOne = new StringBuilder();
        selectOne.append(TWO_SPACE+"<select id=\"selectOne\" resultMap=\""+resultMapNm+"\">"+CRLF);
        selectOne.append(FOUR_SPACE+"SELECT"+CRLF);
        selectOne.append(FOUR_SPACE+"<include refid=\"select_column_list\"></include>"+CRLF);
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
    public String createSelectByDto() {
        StringBuilder selectByDto = new StringBuilder();
        selectByDto.append(TWO_SPACE+"<select id=\"selectByDto\" parameterType=\""+parameterType+"\" resultMap=\""+resultMapNm+"\">"+CRLF);
        selectByDto.append(FOUR_SPACE+"SELECT"+CRLF);
        selectByDto.append(FOUR_SPACE+"<include refid=\"select_column_list\"></include>"+CRLF);
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
    public String createUpdate() {
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

    /**
     * 追加
     */
    public String createInsert() {
        StringBuilder insert = new StringBuilder();
        insert.append(TWO_SPACE+"<insert id=\"insert\" parameterType=\""+parameterType+"\" >"+CRLF);
        insert.append(FOUR_SPACE+FOUR_SPACE+"<selectKey resultType=\"java.lang.Integer\" order=\"BEFORE\" keyProperty=\"id\">"+CRLF);
        insert.append(FOUR_SPACE+FOUR_SPACE+"SELECT SEQ_"+TABLE_NM+".NEXTVAL FROM DUAL"+CRLF);
        insert.append(FOUR_SPACE+FOUR_SPACE+"</selectKey>"+CRLF);
        insert.append(FOUR_SPACE+"INSERT INTO "+TABLE_NM+"("+CRLF);
        insert.append(FOUR_SPACE+"<include refid=\"insert_column_list\"></include>"+CRLF);
        insert.append(FOUR_SPACE+") VALUES ("+CRLF);
        boolean firstFlg = true;
        for(Field field : fields) {
            String comma = ",";
            if (firstFlg) {
                comma = "";
                firstFlg = false;
            }
            insert.append(FOUR_SPACE+TWO_SPACE+comma+"#{"+field.getJavaNm()+"}"+CRLF);
        }
        insert.append(FOUR_SPACE+")"+CRLF);
        insert.append(TWO_SPACE+"</insert>"+CRLF);
        return insert.toString();
    }

    /**
     * 业务逻辑上不重复check
     */
    public String createExistCheck() {
        StringBuilder uniqueCheck = new StringBuilder();
        uniqueCheck.append(TWO_SPACE+"<select id=\"uniqueCheck\"  resultType=\"Integer\">"+CRLF);
        uniqueCheck.append(FOUR_SPACE+"SELECT COUNT(*) AS count FROM "+TABLE_NM+CRLF);
        uniqueCheck.append(FOUR_SPACE+"WHERE"+CRLF);
        boolean firstCol = true;
        for(Field field : existCol) {
                String comma = "AND ";
                if (firstCol) {
                    comma = "";
                    firstCol = false;
                }
                uniqueCheck.append(FOUR_SPACE+TWO_SPACE+comma+field.getDbNm()+" = "+"#{"+field.getJavaNm()+"}"+CRLF);
        }
        uniqueCheck.append(TWO_SPACE+"</select>"+CRLF+CRLF);
        return uniqueCheck.toString();
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

    /**
     * 业务唯一值字段取得
     */
    private List<Field> getExistColumn(){
        if (existCol.size()>0) {
            return existCol;
        } else {
            for(Field field : fields) {
                if (field.isExistColumn()) {
                    existCol.add(field);
                }
                if ("TIMESTAMP".equals(field.getDbType())) {
                    dateColFlag = true;
                }
            }
            return existCol;
        }
    }
}
