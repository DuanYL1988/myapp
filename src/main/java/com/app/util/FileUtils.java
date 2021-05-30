package com.app.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class FileUtils {

    CommonUtils commonUtil = new CommonUtils();

    public static void main(String[] args) {
        FileUtils thisClass = new FileUtils();
        String localPath = thisClass.getPath();
        System.out.println(localPath);
    }

    /**
     * 取得文件内容
     *
     * @param file
     * @return
     */
    public List<String> getFileText(File file) {
        List<String> fileTxtList = new ArrayList<String>();
        try {
            @SuppressWarnings("resource")
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while (null != (line = br.readLine())) {
                fileTxtList.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileTxtList;
    }

    /**
     * 从DDL中取得FIELD集合信息
     *
     * @param file
     * @return
     */
    public List<Field> getFieldListFromDDL(File file) {
        List<Field> fieldList = new ArrayList<Field>();
        try {
            @SuppressWarnings("resource")
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while (null != (line = br.readLine())) {
                Field field = getFieldInfoFromDDL(line);
                if (null != field) {
                    fieldList.add(field);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fieldList;
    }

    /**
     * 取得写文件流
     *
     * @param fullpath
     * @return
     */
    public BufferedWriter getWriter(String fullpath) {
        File writeFile = new File(fullpath);
        BufferedWriter bw = null;
        try {
            if (!writeFile.exists()) {
                writeFile.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(writeFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bw;
    }

    /**
     * 使用写文件流写入内容
     *
     * @param txt
     * @param bw
     */
    public void writeFileAndPrintConsole(String txt, BufferedWriter bw) {
        System.out.println(txt);
        try {
            bw.write(txt + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭流
     *
     * @param bw
     */
    public void closeWriteSteam(BufferedWriter bw) {
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成有内容的文件
     */
    public void writeFile(String fullpath, String text) {
        BufferedWriter bw = getWriter(fullpath);
        writeFileAndPrintConsole(text, bw);
        closeWriteSteam(bw);
    }

    /**
     * 取得工程路径
     *
     * @return
     */
    public String getPath() {
        File localFile = new File("");
        return localFile.getAbsolutePath() + "\\";
    }

    /**
     * 数据库类型与java类型匹配
     *
     * @param type   类型
     * @param direct 匹配方向<br>
     *               1:db→java<br>
     *               2:java→db
     * @return
     */
    public String changeType(String type, String direct) {
        Map<String, String> mapping = new HashMap<String, String>();
        mapping.put("VARCHAR2", "String");
        mapping.put("NUMBER", "Integer");
        mapping.put("TIMESTAMP", "Date");
        Set<String> keys = mapping.keySet();
        for (String db : keys) {
            String javaNm = mapping.get(db);
            if ("1".equals(direct)) {
                if (db.equals(type)) {
                    return javaNm;
                }
            } else {
                if (javaNm.equals(type)) {
                    return db;
                }
            }
        }
        return "";
    }

    /**
     * 取得表字段信息
     *
     * @param line
     * @return
     */
    private Field getFieldInfoFromDDL(String line) {
        // 去除第一行和最后一行
        line = line.toUpperCase();
        if (line.indexOf("CREATE TABLE") >= 0 || line.indexOf("PRIMARY KEY(") >= 0) {
            return null;
        } else {
            Field field = new Field();
            // 根据space分割
            String[] lineInfo = line.split(" ");
            // 去除双引号和逗号
            String dbNm = lineInfo[0].replaceAll("\"", "");
            dbNm = lineInfo[0].replaceAll(",", "");
            // 字段名
            field.setDbNm(dbNm);
            // java命名方式
            field.setJavaNm(commonUtil.changeNm(dbNm, false));
            // 字段类型
            String type = lineInfo[1];
            // 取得字段长度
            if (type.indexOf("(") >= 0) {
                type = lineInfo[1].substring(0, lineInfo[1].indexOf("("));
                String length = lineInfo[1].substring(lineInfo[1].indexOf("(") + 1, lineInfo[1].indexOf(")"));
                int len = 16;
                if (length.indexOf(",") > 0) {
                    len = Integer.parseInt(length.split(",")[0]) + Integer.parseInt(length.split(",")[1]) + 1;
                } else {
                    len = Integer.parseInt(length);
                }
                field.setSize(len);
            }
            field.setDbType(type);
            // 匹配java的类型
            field.setJavaType(changeType(type, "1"));
            // 取得注释后的伦理名
            String logicNm = (lineInfo[lineInfo.length - 1].replace("--", ""));
            logicNm = logicNm.toUpperCase();
            // 是否是主键PRIMARYKEY
            if (logicNm.indexOf("PRIMARYKEY") > 0) {
                field.setPrimaryKey(true);
            }
            // 业务上唯一标识
            if (logicNm.indexOf("EXISTCOL") > 0 || logicNm.indexOf("UNIQUE") > 0) {
                field.setExistColumn(true);
            }
            logicNm = logicNm.replaceAll("PRIMARYKEY", "");
            logicNm = logicNm.replaceAll("EXISTCOL", "");
            logicNm = logicNm.replaceAll("UNIQUE", "");
            field.setLogicNm(logicNm);
            return field;
        }
    }

}
