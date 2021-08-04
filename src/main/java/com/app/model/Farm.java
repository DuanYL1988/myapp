package com.app.model;

public class Farm extends ExpandCondition {
    /**
     * ID
     */
    private Integer id;

    /**
     * 位置
     */
    private String location;

    /**
     * 父田
     */
    private Integer parentFarm;

    /**
     * 编号
     */
    private Integer indexNum;

    /**
     * 作物ID
     */
    private String cropId;

    /**
     * 作物名
     */
    private String cropNm;

    /**
     * 作物HP
     */
    private Integer cropHp;

    /**
     * 售价
     */
    private Integer cropPrice;

    /**
     * 种植日期
     */
    private String startDate;

    /**
     * 土地等级
     */
    private Double totalLevel;

    /**
     * 大小等级
     */
    private Double sizeLevel;

    /**
     * 速度等级
     */
    private Double speedLevel;

    /**
     * 质量等级
     */
    private Double qualityLevel;

    /**
     * 数量等级
     */
    private Double countLevel;

    /**
     * 健康度
     */
    private Integer health;

    /**
     * 设定ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 取得ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设定位置
     */
    public void setLocation(String location) {
        this.location = null == location ? "" : location;
    }

    /**
     * 取得位置
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设定父田
     */
    public void setParentFarm(Integer parentFarm) {
        this.parentFarm = parentFarm;
    }

    /**
     * 取得父田
     */
    public Integer getParentFarm() {
        return parentFarm;
    }

    /**
     * 设定编号
     */
    public void setIndexNum(Integer indexNum) {
        this.indexNum = indexNum;
    }

    /**
     * 取得编号
     */
    public Integer getIndexNum() {
        return indexNum;
    }

    /**
     * 设定作物ID
     */
    public void setCropId(String cropId) {
        this.cropId = null == cropId ? "" : cropId;
    }

    /**
     * 取得作物ID
     */
    public String getCropId() {
        return cropId;
    }

    /**
     * 设定作物名
     */
    public void setCropNm(String cropNm) {
        this.cropNm = null == cropNm ? "" : cropNm;
    }

    /**
     * 取得作物名
     */
    public String getCropNm() {
        return cropNm;
    }

    /**
     * 设定作物HP
     */
    public void setCropHp(Integer cropHp) {
        this.cropHp = cropHp;
    }

    /**
     * 取得作物HP
     */
    public Integer getCropHp() {
        return cropHp;
    }

    /**
     * 设定售价
     */
    public void setCropPrice(Integer cropPrice) {
        this.cropPrice = cropPrice;
    }

    /**
     * 取得售价
     */
    public Integer getCropPrice() {
        return cropPrice;
    }

    /**
     * 设定种植日期
     */
    public void setStartDate(String startDate) {
        this.startDate = null == startDate ? "" : startDate;
    }

    /**
     * 取得种植日期
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 设定土地等级
     */
    public void setTotalLevel(Double totalLevel) {
        this.totalLevel = totalLevel;
    }

    /**
     * 取得土地等级
     */
    public Double getTotalLevel() {
        return totalLevel;
    }

    /**
     * 设定大小等级
     */
    public void setSizeLevel(Double sizeLevel) {
        this.sizeLevel = sizeLevel;
    }

    /**
     * 取得大小等级
     */
    public Double getSizeLevel() {
        return sizeLevel;
    }

    /**
     * 设定速度等级
     */
    public void setSpeedLevel(Double speedLevel) {
        this.speedLevel = speedLevel;
    }

    /**
     * 取得速度等级
     */
    public Double getSpeedLevel() {
        return speedLevel;
    }

    /**
     * 设定质量等级
     */
    public void setQualityLevel(Double qualityLevel) {
        this.qualityLevel = qualityLevel;
    }

    /**
     * 取得质量等级
     */
    public Double getQualityLevel() {
        return qualityLevel;
    }

    /**
     * 设定数量等级
     */
    public void setCountLevel(Double countLevel) {
        this.countLevel = countLevel;
    }

    /**
     * 取得数量等级
     */
    public Double getCountLevel() {
        return countLevel;
    }

    /**
     * 设定健康度
     */
    public void setHealth(Integer health) {
        this.health = health;
    }

    /**
     * 取得健康度
     */
    public Integer getHealth() {
        return health;
    }

}
