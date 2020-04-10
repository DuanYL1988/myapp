package com.app.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FileUtils {

    public static void main(String[] args) {
        FileUtils thisClass = new FileUtils();
        String localPath = thisClass.getPath();
        File[] files = new File(localPath).listFiles();
        for (File file : files) {
            String fileName = file.getName();
            if (fileName.indexOf(".") >0) {
                String targetName = fileName.substring(fileName.indexOf(".")+1)+".java";
                String fileType = fileName.substring(fileName.indexOf(".")+1);
                if ("xml".equals(fileType)) {
                    List<String> fileTxtList = thisClass.getFileText(file);
                    BufferedWriter bw = thisClass.getWriter(localPath+"\\"+targetName);
                    for (String line : fileTxtList) {
                        thisClass.writeFileAndPrintConsole(line, bw);
                    }
                    thisClass.closeWriteSteam(bw);
                }
            } 
        }
    }

    /**
     * 取得文件内容
     * @param file
     * @return
     */
    public List<String> getFileText(File file){
        List<String> fileTxtList = new ArrayList<String>();
        try {
            @SuppressWarnings("resource")
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while(null != (line=br.readLine())) {
                fileTxtList.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileTxtList;
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
            bw.write(txt+"\r\n");
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

    public String getPath() {
        File localFile = new File("");
        return localFile.getAbsolutePath();
    }
}
