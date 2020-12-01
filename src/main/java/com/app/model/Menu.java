package com.app.model;

public class Menu extends ExpandCondition {
    /**
     * PRIMARYKEY
     */
    private Integer id;

    /**
     * 父菜单ID
     */
    private Integer parentId;

    /**
     * 菜单等级
     */
    private String menuLevel;

    /**
     * 分类EXISTCOL
     */
    private String categore;

    /**
     * 名称EXISTCOL
     */
    private String name;

    /**
     * 活动URL
     */
    private String actionUrl;

    /**
     * 静态页面URL
     */
    private String htmlUrl;

    /**
     * 图片位置
     */
    private String imageSrc;

    /**
     * 静态页面图片位置
     */
    private String htmlImageSrc;

    /**
     * 设定PRIMARYKEY
     */
    public void setId(Integer id){
        this.id = id;
    }

    /**
     * 取得PRIMARYKEY
     */
    public Integer getId(){
        return id;
    }
    /**
     * 设定父菜单ID
     */
    public void setParentId(Integer parentId){
        this.parentId = parentId;
    }

    /**
     * 取得父菜单ID
     */
    public Integer getParentId(){
        return parentId;
    }
    /**
     * 设定菜单等级
     */
    public void setMenuLevel(String menuLevel){
        this.menuLevel = menuLevel;
    }

    /**
     * 取得菜单等级
     */
    public String getMenuLevel(){
        return menuLevel;
    }
    /**
     * 设定分类EXISTCOL
     */
    public void setCategore(String categore){
        this.categore = categore;
    }

    /**
     * 取得分类EXISTCOL
     */
    public String getCategore(){
        return categore;
    }
    /**
     * 设定名称EXISTCOL
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 取得名称EXISTCOL
     */
    public String getName(){
        return name;
    }
    /**
     * 设定活动URL
     */
    public void setActionUrl(String actionUrl){
        this.actionUrl = actionUrl;
    }

    /**
     * 取得活动URL
     */
    public String getActionUrl(){
        return actionUrl;
    }
    /**
     * 设定静态页面URL
     */
    public void setHtmlUrl(String htmlUrl){
        this.htmlUrl = htmlUrl;
    }

    /**
     * 取得静态页面URL
     */
    public String getHtmlUrl(){
        return htmlUrl;
    }
    /**
     * 设定图片位置
     */
    public void setImageSrc(String imageSrc){
        this.imageSrc = imageSrc;
    }

    /**
     * 取得图片位置
     */
    public String getImageSrc(){
        return imageSrc;
    }
    /**
     * 设定静态页面图片位置
     */
    public void setHtmlImageSrc(String htmlImageSrc){
        this.htmlImageSrc = htmlImageSrc;
    }

    /**
     * 取得静态页面图片位置
     */
    public String getHtmlImageSrc(){
        return htmlImageSrc;
    }

}
