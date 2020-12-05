package com.app.dto;

public class AjaxResponseDto {

    private String code;

    private String message;

    private Object data;

    private Object listData01;

    private Object listData02;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getListData01() {
        return listData01;
    }

    public void setListData01(Object listData01) {
        this.listData01 = listData01;
    }

    public Object getListData02() {
        return listData02;
    }

    public void setListData02(Object listData02) {
        this.listData02 = listData02;
    }

}
