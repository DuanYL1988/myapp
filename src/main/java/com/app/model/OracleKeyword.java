package com.app.model;

public class OracleKeyword {

    private int id;

    private String tipId;

    private String keyWord;

    private boolean functionFlg;

    private String grammar;

    private String exampleText;

    private String exampleResult;

    private String info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipId() {
        return tipId;
    }

    public void setTipId(String tipId) {
        this.tipId = tipId;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public boolean isFunctionFlg() {
        return functionFlg;
    }

    public void setFunctionFlg(boolean functionFlg) {
        this.functionFlg = functionFlg;
    }

    public String getGrammar() {
        return grammar;
    }

    public void setGrammar(String grammar) {
        this.grammar = grammar;
    }

    public String getExampleText() {
        return exampleText;
    }

    public void setExampleText(String exampleText) {
        this.exampleText = exampleText;
    }

    public String getExampleResult() {
        return exampleResult;
    }

    public void setExampleResult(String exampleResult) {
        this.exampleResult = exampleResult;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
