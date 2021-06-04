package com.app.model;

public class Recipe extends ExpandCondition {
    /**
     * ID
     */
    private Integer id;

    /**
     * 大分类
     */
    private String categoryMain;

    /**
     * 小分类
     */
    private String categorySub;

    /**
     * 名称
     */
    private String name;

    /**
     * 售价
     */
    private Integer price;

    /**
     * 技能等级
     */
    private Integer skillLevel;

    /**
     * 材料1
     */
    private String recipe1;

    /**
     * 材料2
     */
    private String recipe2;

    /**
     * 材料3
     */
    private String recipe3;

    /**
     * 材料4
     */
    private String recipe4;

    /**
     * 材料5
     */
    private String recipe5;

    /**
     * 材料6
     */
    private String recipe6;

    /**
     * 设定ID
     */
    public void setId(Integer id){
        this.id = id;
    }

    /**
     * 取得ID
     */
    public Integer getId(){
        return id;
    }
    /**
     * 设定大分类
     */
    public void setCategoryMain(String categoryMain){
        this.categoryMain = categoryMain;
    }

    /**
     * 取得大分类
     */
    public String getCategoryMain(){
        return categoryMain;
    }
    /**
     * 设定小分类
     */
    public void setCategorySub(String categorySub){
        this.categorySub = categorySub;
    }

    /**
     * 取得小分类
     */
    public String getCategorySub(){
        return categorySub;
    }
    /**
     * 设定名称
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 取得名称
     */
    public String getName(){
        return name;
    }
    /**
     * 设定售价
     */
    public void setPrice(Integer price){
        this.price = price;
    }

    /**
     * 取得售价
     */
    public Integer getPrice(){
        return price;
    }
    /**
     * 设定技能等级
     */
    public void setSkillLevel(Integer skillLevel){
        this.skillLevel = skillLevel;
    }

    /**
     * 取得技能等级
     */
    public Integer getSkillLevel(){
        return skillLevel;
    }
    /**
     * 设定材料1
     */
    public void setRecipe1(String recipe1){
        this.recipe1 = recipe1;
    }

    /**
     * 取得材料1
     */
    public String getRecipe1(){
        return recipe1;
    }
    /**
     * 设定材料2
     */
    public void setRecipe2(String recipe2){
        this.recipe2 = recipe2;
    }

    /**
     * 取得材料2
     */
    public String getRecipe2(){
        return recipe2;
    }
    /**
     * 设定材料3
     */
    public void setRecipe3(String recipe3){
        this.recipe3 = recipe3;
    }

    /**
     * 取得材料3
     */
    public String getRecipe3(){
        return recipe3;
    }
    /**
     * 设定材料4
     */
    public void setRecipe4(String recipe4){
        this.recipe4 = recipe4;
    }

    /**
     * 取得材料4
     */
    public String getRecipe4(){
        return recipe4;
    }
    /**
     * 设定材料5
     */
    public void setRecipe5(String recipe5){
        this.recipe5 = recipe5;
    }

    /**
     * 取得材料5
     */
    public String getRecipe5(){
        return recipe5;
    }
    /**
     * 设定材料6
     */
    public void setRecipe6(String recipe6){
        this.recipe6 = recipe6;
    }

    /**
     * 取得材料6
     */
    public String getRecipe6(){
        return recipe6;
    }

}
