package com.app.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.model.Hero;
import com.app.model.Menu;
import com.app.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml" })
public class HeroRepositoryTest {

    @Autowired
    MenuRepository menuRepo;

    @Autowired
    HeroRepository heroRepo;

    @Autowired
    OracleCommonRepository oracleRepository;

    @Autowired
    JsonUtil jsonUtil;

    @Test
    public void testGetNextvalFromSeq() {
        System.out.println(oracleRepository.getNextval("SEQ_HERO_MASTER"));
        System.out.println(oracleRepository.getCurrentval("SEQ_HERO_MASTER"));
    }

    @Test
    public void testheroRepo() {
        Hero condition = new Hero();
        condition.setTitleName("0001");
        condition.setName("0001");

        List<Hero> heroList = heroRepo.selectByDto(condition);
        assertTrue(0 == heroList.size());

        Hero result = heroRepo.selectOneByUniqueKey("0001", "01");
        assertTrue(null == result);
    }


    @Test
    public void testMenuRepo() {
        Menu condition = new Menu();
        condition.setCategore("火纹");
        List<Menu> menuList = menuRepo.selectByDto(null);
        assertTrue(menuList.size() > 0);

        condition.setId(1);
        condition.setMenuLevel("2");
        menuRepo.update(condition);

        String jsonText = jsonUtil.praseObjToJson(menuList);
        System.out.println(jsonText);
    }

}
