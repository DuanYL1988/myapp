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
    public void writeFile(String fullpath,String text) {
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
        return localFile.getAbsolutePath()+"\\";
    }

    /**
     * 数据库字段名转为java变量名
     */
    public String changeNm(String dbNm, boolean upFlag) {
        String javaNm = "";
        String[] nms = dbNm.split("_");
        if (nms.length == 1) {
            javaNm = dbNm.toLowerCase();
        } else {
            StringBuilder sb = new StringBuilder(nms[0].toLowerCase());
            for (int i = 1; i < nms.length; i++) {
                String tmp = nms[i];
                sb.append(tmp.substring(0, 1));
                sb.append(tmp.substring(1).toLowerCase());
            }
            javaNm = sb.toString();
        }
        if (upFlag) {
            javaNm = javaNm.substring(0, 1).toUpperCase() + javaNm.substring(1);
        }
        return javaNm.toString();
    }

    /**
     * 数据库类型与java类型匹配
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
                if(db.equals(type)) {
                    return javaNm;
                }
            } else {
                if(javaNm.equals(type)) {
                    return db;
                }
            }
        }
        return "";
    }

    private Field getFieldInfoFromDDL(String line) {
        if (line.indexOf("CREATE TABLE") >= 0 || line.indexOf("PRIMARY KEY") >= 0 ) {
            return null;
        } else {
            Field field = new Field();
            String[] lineInfo = line.split(" ");
            String dbNm = lineInfo[0].replaceAll("\"", "");
            field.setDbNm(dbNm);
            field.setJavaNm(changeNm(dbNm, false));
            String type = lineInfo[1];
            if (type.indexOf("(")>=0) {
                type = lineInfo[1].substring(0, lineInfo[1].indexOf("("));
                field.setSize(Integer.parseInt(lineInfo[1].substring(lineInfo[1].indexOf("(")+1, lineInfo[1].indexOf(")"))));
            }
            field.setDbType(type);
            field.setJavaType(changeType(type, "1"));
            String logicNm = (lineInfo[lineInfo.length-1].replace("--", ""));
            field.setLogicNm(logicNm);
            if("PRIMARYKEY".equals(logicNm)) {
                field.setPrimaryKey(true);
            }
            return field;
        }
    }

}
