package com.app.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
        String folderPath = "";
        folderPath = "D:\\project\\myapp\\src\\main\\webapp\\resources\\images\\feh\\acter";

        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择需要执行的处理");
        System.out.println("0:FEH");
        System.out.println("1:FGO");
        String type = scanner.nextLine();

        if ("1".equals(type)) {
            folderPath = "D:\\project\\myapp\\src\\main\\webapp\\resources\\images\\fgo\\servants";
        }

        System.out.println("请选择需要执行的处理");
        System.out.println("0:重命名");
        System.out.println("1:删除多余文件");
        System.out.println("2:重命名文件夹");
        String mode = scanner.nextLine();

        FehFileUtils thisUtils = new FehFileUtils();
        thisUtils.fehImgRename(folderPath, mode, type);
        scanner.close();
        System.out.println("处理文件数：" + COUNT);
    }

    /**
     * @param 文件夹目录
     */
    public void fehImgRename(String folderPath, String mode, String type) throws Exception {
        // 取得文件夾文件對象
        File folder = new File(folderPath);
        // 取得文件夹目录下文件
        File[] fileList = folder.listFiles();

        //
        boolean firstFlag = true;
        if (null != fileList) {
            for (File file : fileList) {
                // 子文件是文件夹的情况
                if (file.isDirectory()) {
                    if (MODE_RENAME_FOLDER.equals(mode)) {
                        // reNameFolder(file);
                    } else {
                        // 重命名
                        fehImgRename(file.getPath(), mode, type);
                    }

                } else {
                    if (firstFlag && "1".equals(type)) {
                        String fireNm = file.getName();
                        if (fireNm.indexOf("_Stage") > 0) {
                            String id = fireNm.split("_")[0];
                            String msg = id + "," + folder.getName();
                            System.out.println(msg);
                            firstFlag = false;
                        }
                    }

                    if (MODE_RENAME.equals(mode)) {
                        // 重命名文件
                        if ("0".equals(type)) {
                            getRenameByName(file);
                        } else {
                            getFgoRenameByName(file);
                        }
                    } else if (MODE_DELETE.equals(mode)) {
                        deletePngFile(file);
                    }
                }
            }
        }
    }

    /**
     * 重命名文件(FEH)
     *
     * @param file
     */
    private void getRenameByName(File file) {
        if (MAPPING_NAME_MAP == null) {
            MAPPING_NAME_MAP = initNameMappingMap();
        }
        reName(file);
    }

    /**
     * 重命名文件(FGO)
     *
     * @param file
     */
    private void getFgoRenameByName(File file) {
        if (MAPPING_NAME_MAP == null) {
            MAPPING_NAME_MAP = initFgoNameMappingMap();
        }
        reName(file);
    }

    /**
     * 文件重命名
     *
     * @param file
     * @param rename
     */
    private void reName(File file) {
        Set<String> mappingName = MAPPING_NAME_MAP.keySet();
        for (String name : mappingName) {
            String rename = MAPPING_NAME_MAP.get(name);
            String fileNm = file.getName().toLowerCase();
            String keyNm = name.toLowerCase();
            if (fileNm.indexOf(keyNm) >= 0) {
                // reName(file, rename);
                System.out.println("png file name before :" + file.getPath());
                file.renameTo(new File(file.getParent() + FOLDER_PATH_MARK + rename));
                System.out.println("png file name after :" + rename);
                COUNT++;
                break;
            }
        }
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
     * FEH立绘图片名修正匹配
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

    /**
     * FGO立绘图片名修正匹配
     *
     * @return
     */
    private Map<String, String> initFgoNameMappingMap() {
        MAPPING_NAME_MAP = new HashMap<String, String>();
        MAPPING_NAME_MAP.put("_Stage1.png", "Stage1.png");
        MAPPING_NAME_MAP.put("_Stage2.png", "Stage2.png");
        MAPPING_NAME_MAP.put("_Stage3.png", "Stage3.png");
        MAPPING_NAME_MAP.put("_Stage4.png", "Stage4.png");
        MAPPING_NAME_MAP.put("Icon.png", "Icon.png");
        return MAPPING_NAME_MAP;
    }

}
