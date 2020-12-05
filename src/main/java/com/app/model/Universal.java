package com.app.model;

/**
 * 检索杂类
 *
 * @author dylsw
 *
 */
public class Universal {

    /**
     * 当前值
     */
    public Integer localVal;

    /**
     * 排位
     */
    public Integer roundVal;

    /**
     * 排位
     */
    public Integer totalVal;

    /**
     * 最大值
     */
    public Integer maxVal;

    public Integer getLocalVal() {
        return localVal;
    }

    public void setLocalVal(Integer localVal) {
        this.localVal = localVal;
    }

    public Integer getRoundVal() {
        return roundVal;
    }

    public void setRoundVal(Integer roundVal) {
        this.roundVal = roundVal;
    }

    public Integer getMaxVal() {
        return maxVal;
    }

    public void setMaxVal(Integer maxVal) {
        this.maxVal = maxVal;
    }

    public Integer getTotalVal() {
        return totalVal;
    }

    public void setTotalVal(Integer totalVal) {
        this.totalVal = totalVal;
    }

}
