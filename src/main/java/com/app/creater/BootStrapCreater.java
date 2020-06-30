package com.app.creater;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.thymeleaf.util.StringUtils;

import com.app.util.CommonUtils;
import com.app.util.FileUtils;

public class BootStrapCreater {

    public static final String TAP_SPACE = "  ";
    public static final String FOUR_SPACE = "    ";
    public static final String CRLF = "\r\n";
    private static final String  FORM_OBJECT_NM = "inputForm";
    public static final int ROW_WIDTH = 12;

    public static final String RES_PATH = "C:\\Workspaces\\myapp\\src\\main\\resources\\template\\";

    private final String paramObject;
    private final FileUtils fileUtil;
    private final CommonUtils commUtil;
    List<String> fileLineList = new ArrayList<String>();
    public BootStrapCreater(String name) {
        fileUtil = new FileUtils();
        commUtil = new CommonUtils();
        paramObject = commUtil.changeNm(name, false);
        fileLineList = fileUtil.getFileText(new File(RES_PATH+name+".txt"));
    }

    public static void main(String[] args) {
        BootStrapCreater thisClass = new BootStrapCreater("HERO");

        String html = thisClass.createValitionFormHtml();
        System.out.println(html);
    }


    public String createValitionFormHtml() {
        StringBuilder html = new StringBuilder();
        html.append("<div class=\"col-md-8 order-md-1\">"+CRLF);
        html.append("<form class=\"needs-validation\" th:action=\"@{hero/index}\" th:object=\"${"+FORM_OBJECT_NM+"}\" novalidate>"+CRLF);
        int cntWidth = 0;
        boolean rowLengthCheck = true;

        for(String line : fileLineList) {
            if("<br>".equals(line)) {
                html.append(TAP_SPACE+"</div>"+CRLF+CRLF);
                cntWidth = 0;
                continue;
            }
            // 判断区域
            if(line.indexOf("inputType=")>=0) {
                // 是否有标题
                if(line.indexOf("title=")>=0) {
                    String tit = line.substring(line.lastIndexOf("=")+1);
                    html.append(TAP_SPACE+"<h4 class=\"mb-3\">"+tit+"</h4>"+CRLF);
                }
                String type = line.split(",")[0];
                type = type.substring(type.indexOf("=")+1);
                rowLengthCheck = "click".equals(type) ? false : true;
                continue;
            }

            String[] lineInfo = line.split(",");
            String propNm = commUtil.changeNm(lineInfo[0], false);
            String required = lineInfo[1];
            String titleNm = lineInfo[2];
            String inputType = lineInfo[3];
            String placeholder = lineInfo[4];
            int width = Integer.parseInt(lineInfo[5]);
            String classNm = lineInfo[6];
            if (rowLengthCheck) {
                // 行开始
                if(cntWidth == 0) {
                    html.append(TAP_SPACE+"<div class=\"row\">"+CRLF);
                }
                html.append(FOUR_SPACE+"<div class=\"col-md-"+width+"\">"+CRLF);
                // 入力框
                if ("text".equals(inputType)) {

                    editInputText(html,propNm,required,titleNm,inputType,placeholder,classNm);
                } else if ("select".equals(inputType)){

                    editSelect(html,propNm,required,titleNm,inputType,placeholder,classNm);
                } else if ("checkbox".equals(inputType)) {

                    editCheckBox(html, propNm, required, titleNm, inputType, placeholder, classNm, false, 0);
                }
                html.append(FOUR_SPACE+"</div>"+CRLF);
                // 行结束
                cntWidth += width;
                if (cntWidth>=12){
                    html.append(TAP_SPACE+"</div>"+CRLF+CRLF);
                    cntWidth = 0;
                }

                // 单选及复选框
            } else if ("radio".equals(inputType) || "checkbox".equals(inputType)){
                html.append(TAP_SPACE+"<div class=\"row\">"+CRLF);
                html.append(FOUR_SPACE+"<h4 class=\"mb-3\" dyl:"+inputType+"Image=\"\" >"+lineInfo[2]+"</h4>"+CRLF);
                for(int i=1;i<=2;i++) {
                    if("radio".equals(inputType)) {
                        html.append(FOUR_SPACE+"<div class=\"d-block my-1\">"+CRLF);
                        html.append(FOUR_SPACE+TAP_SPACE+"<div class=\"custom-control custom-radio\">"+CRLF);
                        html.append(editLableInput("input", propNm,required,titleNm, inputType,placeholder,classNm,true,i));
                        html.append(FOUR_SPACE+TAP_SPACE+"</div>"+CRLF);
                        html.append(FOUR_SPACE+"</div>"+CRLF);
                    } else {
                        editCheckBox(html, propNm, required, titleNm, inputType, placeholder, classNm, true,i);
                    }

                }
                html.append(TAP_SPACE+"</div>"+CRLF+CRLF);
            }
        }
        html.append(TAP_SPACE+"<button class=\"btn btn-primary btn-lg btn-block\" type=\"submit\">Continue to checkout</button>"+CRLF);
        html.append("</form>"+CRLF);
        html.append("</div>");
        return html.toString();
    }

    /**
     * 编辑入力框
     */
    private void editInputText(StringBuilder html,String propNm,String required,String titleNm,String inputType,String placeholder,String classNm) {
        html.append(editLableInput("input", propNm,required,titleNm, inputType,placeholder,classNm,false,0));
        // 入力验证
        editRequired(html, propNm,required,"text");
    }

    /**
     * 编辑下拉框
     */
    private void editSelect(StringBuilder html,String propNm,String required,String titleNm,String inputType,String placeholder,String classNm) {
        html.append(editLableInput("select", propNm,required,titleNm, inputType,placeholder,classNm,false,0));
        // 入力验证
        editRequired(html, propNm,required,"select");
    }

    private void editCheckBox(StringBuilder html,String propNm,String required,String titleNm,String inputType,String placeholder,String classNm,boolean loogFlag,int index) {
        if (loogFlag) {
            html.append(FOUR_SPACE+TAP_SPACE+"<div class=\"custom-control custom-checkbox\">"+CRLF);
        } else {
            html.append(FOUR_SPACE+TAP_SPACE+"<div class=\"custom-checkbox\" style=\"padding-top:2.2em\">"+CRLF);
        }
        html.append(editLableInput("input", propNm,required,titleNm, inputType,placeholder,classNm,loogFlag,index));
        html.append(FOUR_SPACE+TAP_SPACE+"</div>"+CRLF);
    }

    /**
     *
     * 通用入力项目生成
     *
     * @param 标签 tag
     * @param 属性名 propNm
     * @param 是否验证 required
     * @param 标题 titleNm
     * @param 输入类型 inputType
     * @param 默认值 placeholder
     * @param 类 classNm
     * @param 循环 loopFlag
     * @return
     */
    private String editLableInput(String tag,String propNm,String required,String titleNm,String inputType,String placeholder,String classNm,boolean loopFlag,int index) {
        String id = propNm;
        if (loopFlag) {
            id += index;
        }
        StringBuilder inputHtml = new StringBuilder();

        String clickClass = " class=\"custom-control-label\"";
        if("checkbox".equals(inputType) || "radio".equals(inputType)) {
            // radio或checkbox时不进行页面入力验证
            exitInput(inputHtml, tag, id, propNm, "NO", inputType, placeholder, classNm);
            exitLable(inputHtml, id, inputType, titleNm, clickClass);
        } else {
            exitLable(inputHtml, id, inputType, titleNm, "");
            exitInput(inputHtml, tag, id, propNm, required, inputType, placeholder, classNm);
        }
        return inputHtml.toString();
    }

    /**
     * 编辑LABEL标签
     */
    private void exitLable(StringBuilder inputHtml,String id,String inputType,String titleNm,String clickClass) {
        inputHtml.append(FOUR_SPACE+TAP_SPACE+"<label for=\""+id+"\"");
        inputHtml.append(clickClass);
        inputHtml.append(">"+titleNm+"</label>"+CRLF);
    }

    /**
     * 编辑INPUT标签
     */
    private void exitInput(StringBuilder inputHtml,String tag,String id,String propNm,String required,String inputType,String placeholder,String classNm) {
        inputHtml.append(FOUR_SPACE+TAP_SPACE+"<"+tag+" id=\""+id+"\"");
        inputHtml.append(" class=\""+classNm+"\"");
        if(!"select".equals(inputType)) {
            inputHtml.append(" type=\""+inputType+"\"");
        } else {
            inputHtml.append(" dyl:options=\"0004\"");
        }
        inputHtml.append(" th:name=\""+paramObject+"."+propNm+"\" name=\""+propNm+"\"");
        if ("text".equals(inputType)) {
            inputHtml.append(" th:value=\"${"+FORM_OBJECT_NM+"."+paramObject+"."+propNm+"}\"");

            if(!StringUtils.isEmpty(placeholder)) {
                inputHtml.append(" placeholder=\""+placeholder+"\"");
            }
        }
        String txt = "YES".equals(required) ? " required>" : ">";
        inputHtml.append(txt+CRLF);
    }

    /**
     *
     * 验证错误区域
     * @param html
     * @param propNm
     * @param required
     * @param kbn
     */
    private void editRequired(StringBuilder html,String propNm,String required,String kbn) {

        if ("select".equals(kbn)) {
            html.append(FOUR_SPACE+FOUR_SPACE+"<option value=\"\">Choose...</option>"+CRLF);
            html.append(FOUR_SPACE+TAP_SPACE+"</select>"+CRLF);
        }

        if ("YES".equals(required)) {
            html.append(FOUR_SPACE+TAP_SPACE+"<div class=\"invalid-feedback\">"+CRLF);
            html.append(FOUR_SPACE+FOUR_SPACE+propNm+" is required"+CRLF);
            html.append(FOUR_SPACE+TAP_SPACE+"</div>"+CRLF);
        }
    }

}
