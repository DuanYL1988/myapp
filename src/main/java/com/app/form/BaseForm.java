package com.app.form;

public class BaseForm {

    private String mode = "1";

    private String pageSize;

    private String pageNo;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

}
