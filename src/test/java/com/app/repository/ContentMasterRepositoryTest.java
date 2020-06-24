package com.app.repository;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.model.ContentMaster;
import com.app.model.FehCharacter;
import com.app.model.Skill;
import com.app.util.CommonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml",
        "classpath:spring/spring-mvc.xml" })
@SuppressWarnings("unused")
public class ContentMasterRepositoryTest {

    public static final int FILED_TO_LOWERCASE = 0;

    public static final int CHANGE_TO_RESULTMAP = 1;

    public static final int PRINT_SELECT_WHERE = 2;

    public static final int PRINT_JAVA_SETGET = 3;

    public static final int PRINT_INSERT = 4;

    public static final int PRINT_UPDATE = 5;
    @Inject
    ContentMasterRepository cmRepository;

    @Inject
    FehCharacterRepository fehRepository;

    @Inject
    SkillRepository skillRepository;

    @Inject
    CommonUtils commonUtil;

    @Value("${location}")
    String location;

    @Test
    public void selectOneTest() {
    }

    @Test
    public void skillInsertTest() {
        Skill skill = new Skill();
        skill.setSkillType("E");
        skill.setSkillName("疾风迅雷");
        // skill.setSkillColour("红剑");
        // skill.setSkillPower(18);
        skill.setSkillExtend(0);
        skill.setSkillInfo("再次行动");
        skillRepository.insert(skill);
    }

    @Test
    public void testGetAllSkill() {
        ContentMaster result = cmRepository.selectOne("0004", "7");
        System.out.println(result.getCatagoryName());
    }

    @Test
    public void testSelectAllSkill() {
        skillRepository.getAllSkill();
    }

    @Test
    public void testInsert() {
        ContentMaster dto = new ContentMaster();
        dto.setCatagoryId("0001");
        dto.setCatagoryName("武器属性");
        dto.setCodeId("23");
        dto.setCodeName("无色兽族");
        cmRepository.insert(dto);
    }

    @Test
    public void testSelect() {
        List<ContentMaster> result = cmRepository
                .getContentByCategoryId("0001");
        System.out.println(result.get(0).getCodeName());
        Assert.assertTrue(result.size() > 0);
    }

    @Test
    public void testInsertToFCM() {
        FehCharacter acter = new FehCharacter();
        acter.setBasename("琳迪斯");
        acter.setOrigin("烈火之剑");
        fehRepository.insertToMaster(acter);
    }

    @Test
    public void testSelectByDto() {
        FehCharacter acter = new FehCharacter();
        acter.setBasename("琳迪斯");
        List<FehCharacter> result = fehRepository.selectByDto(acter);
    }

    @Test
    public void testInsertActer() {
        FehCharacter acter = new FehCharacter();
        acter.setTitlename("伟大的");
        acter.setBasename("琳迪斯");
        acter.setName("弓琳");
        fehRepository.insertToActer(acter);
    }

    @Test
    public void testJava01() {
        String path = "D:\\Workspaces\\myapp\\src\\main\\webapp\\resources\\images\\feh\\acter\\Lin_F_ELECTION01\\face.png";
        path = path.split("webapp")[1];
        System.out.println(path);
        path = "@{" + path.substring(0, path.lastIndexOf("\\") + 1);
        path = path.replace("\\", "/");
        System.out.println(path);
    }

    @Test
    public void testQuery(){
        List<FehCharacter> list = fehRepository.selectByCustomize("CHARACTER_ID = '2'");
    }
}
