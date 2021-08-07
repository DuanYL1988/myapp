package com.app.common;

import java.util.HashMap;
import java.util.Map;

import com.app.dto.AjaxResponseDto;

public class CommonContent {

    public static final String MODE_UPDATE = "update";

    public static final String MODE_INSERT = "insert";

    public static final String Q_IMG = "q.png";

    public static final String FACE_IMG = "face.png";

    public static final String ATTACT_IMG = "attact.png";

    public static final String BREAK_IMG = "break.png";

    public static final String NORMAL_IMG = "normal.png";

    public static final String EXTRA_IMG = "extra.png";

    /* 火纹图片路径 */
    public static final String IMG_MYAPP_FEH = "/myapp/resources/images/feh/";

    /* 火纹角色图片路径 */
    public static final String FEH_IMG_PATH = "/myapp/resources/images/feh/acter/";

    /* 请求成功 */
    public static final String RESULT_SUCCESS = "200";

    /* 请求警告 */
    public static final String RESULT_WARRING = "400";

    /* 逗号 */
    public static final String COMMA = ",";

    /* 上次操作的数据ID */
    public static final String SESSION_PRE_ID = "PRE_ID";

    public static final String WINDOWS_ENTRY = "\r\n";

    public static final String SPACE_4 = "    ";
    public static final String SPACE_8 = "        ";
    public static final String SPACE_12 = "            ";

    /**
     * 自定义标签使用
     *
     * @param key master表中类别ID
     * @return 类别名
     */
    public static String getMapping(String key) {
        Map<String, String> contentList = new HashMap<String, String>();
        contentList.put("0001", "color");
        contentList.put("0002", "weaponType");
        contentList.put("0003", "blessing");
        contentList.put("0004", "origin");
        contentList.put("0005", "moveType");
        contentList.put("0006", "specTag");

        return contentList.get(key);
    }

    public static AjaxResponseDto setResponseDto(String code, String message, Object data) {
        AjaxResponseDto result = new AjaxResponseDto();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
