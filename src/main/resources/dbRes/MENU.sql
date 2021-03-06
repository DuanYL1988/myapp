CREATE TABLE "FIREEMBLEM"."MENU" (
"ID" NUMBER(11) NOT NULL ENABLE, --PRIMARYKEY
"PARENT_ID" NUMBER(11) DEFAULT NULL, --父菜单ID
"MENU_LEVEL" VARCHAR2(30) DEFAULT NULL, --菜单等级
"CATEGORE" VARCHAR2(30) DEFAULT NULL, --分类EXISTCOL
"NAME" VARCHAR2(30) NOT NULL ENABLE, --名称EXISTCOL
"ACTION_URL" VARCHAR2(80) NOT NULL ENABLE, --活动URL
"HTML_URL" VARCHAR2(30) DEFAULT NULL, --静态页面URL
"IMAGE_SRC" VARCHAR2(30) DEFAULT NULL, --图片位置
"HTML_IMAGE_SRC" VARCHAR2(80) DEFAULT NULL, --静态页面图片位置
PRIMARY KEY ("ID"));