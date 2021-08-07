package com.app.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class FehFileUtils {

    private static final String FOLDER_PATH_MARK = "\\";

    private static Map<String, String> MAPPING_NAME_MAP = null;

    private static final String MODE_RENAME = "0";

    private static final String MODE_DELETE = "1";

    private static final String MODE_RENAME_FOLDER = "2";

    private static final String NORMAL_BEF = "_Face.";

    private static final String ATTACT_BEF = "BtlFace.";

    private static final String BREAK_BEF = "BtlFace_D.";

    private static final String EXTRA_BEF = "BtlFace_C.";

    private static final String NORMAL_AFT = "normal.png";

    private static final String ATTACT_AFT = "attact.png";

    private static final String BREAK_AFT = "break.png";

    private static final String EXTRA_AFT = "extra.png";

    private static final String FACE = "face.png";

    private static int COUNT = 0;

    public static void main(String[] args) throws Exception {
        String folderPath = "D:\\project\\myapp\\src\\main\\webapp\\resources\\images\\feh\\acter";
        System.out.println("请选择需要执行的处理");
        System.out.println("0:重命名");
        System.out.println("1:删除多余文件");
        System.out.println("2:重命名文件夹");
        Scanner scanner = new Scanner(System.in);
        String mode = scanner.nextLine();
        FehFileUtils thisUtils = new FehFileUtils();
        thisUtils.fehImgRename(folderPath, mode);
        scanner.close();
        System.out.println("处理文件数：" + COUNT);
    }

    /**
     * @param 文件夹目录
     */
    public void fehImgRename(String folderPath, String mode) throws Exception {
        // 取得文件夾文件對象
        File folder = new File(folderPath);
        // 取得文件夹目录下文件
        File[] fileList = folder.listFiles();

        if (null != fileList) {
            for (File file : fileList) {
                // 子文件是文件夹的情况
                if (file.isDirectory()) {
                    if (MODE_RENAME_FOLDER.equals(mode)) {
                        // reNameFolder(file);
                    } else {
                        // 重命名
                        fehImgRename(file.getPath(), mode);
                    }

                } else {

                    if (MODE_RENAME.equals(mode)) {
                        // 重命名文件
                        getRenameByName(file);
                    } else if (MODE_DELETE.equals(mode)) {
                        deletePngFile(file);
                    }
                }
            }
        }
    }

    /**
     * 重命名文件
     *
     * @param file
     */
    private void getRenameByName(File file) {
        if (MAPPING_NAME_MAP == null) {
            MAPPING_NAME_MAP = initNameMappingMap();
        }
        String rename = MAPPING_NAME_MAP.get(file.getName());
        if (null != rename && rename.length() > 0) {
            reName(file, rename);
        } else if (file.getName().indexOf(EXTRA_BEF) >= 0) {
            reName(file, EXTRA_AFT);
        } else if (file.getName().indexOf(BREAK_BEF) >= 0) {
            reName(file, BREAK_AFT);
        } else if (file.getName().indexOf(ATTACT_BEF) >= 0) {
            reName(file, ATTACT_AFT);
        } else if (file.getName().indexOf(NORMAL_BEF) >= 0) {
            reName(file, NORMAL_AFT);
        } else if (file.getName().indexOf("拷贝") >= 0) {
            reName(file, FACE);
        }
    }

    /**
     * 文件重命名
     *
     * @param file
     * @param rename
     */
    private void reName(File file, String rename) {
        System.out.println("png file name before :" + file.getPath());
        file.renameTo(new File(file.getParent() + FOLDER_PATH_MARK + rename));
        System.out.println("png file name after :" + rename);
        COUNT++;
    }

    /**
     * 删除文件
     *
     * @param file
     */
    private void deletePngFile(File file) {
        String fileName = file.getName();
        if (fileName.indexOf(NORMAL_AFT) < 0 && fileName.indexOf(ATTACT_AFT) < 0 && fileName.indexOf(BREAK_AFT) < 0
                && fileName.indexOf(EXTRA_AFT) < 0 && fileName.indexOf(FACE) < 0) {
            System.out.println("DELETE FILE NAME IS :" + file.getPath());
            file.delete();
            COUNT++;
        }
    }

    /**
     * 立绘图片名修正匹配
     *
     * @return
     */
    private Map<String, String> initNameMappingMap() {
        MAPPING_NAME_MAP = new HashMap<String, String>();
        MAPPING_NAME_MAP.put(NORMAL_BEF, NORMAL_AFT);
        MAPPING_NAME_MAP.put(ATTACT_BEF, ATTACT_AFT);
        MAPPING_NAME_MAP.put(BREAK_BEF, BREAK_AFT);
        MAPPING_NAME_MAP.put(EXTRA_BEF, EXTRA_AFT);
        return MAPPING_NAME_MAP;
    }

}
