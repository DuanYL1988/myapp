package com.app.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.jdbc.JdbcConnectUtil;
import com.app.model.HeroMaster;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml" })
public class HeroRepositoryTest {

    @Autowired
    HeroRepository heroRepo;

    @Autowired
    HeroMasterRepository heroMstRepo;

    @Autowired
    OracleCommonRepository oracleRepository;

    @Test
    public void testAutoInsert() {
        HeroMaster master = new HeroMaster();
        master.setOrigin("烈火之剑");
        master.setName("琳迪斯");
        heroMstRepo.insert(master);
    }

    @Test
    public void testGetNextvalFromSeq() {
        System.out.println(oracleRepository.getNextval("SEQ_HERO_MASTER"));
        System.out.println(oracleRepository.getCurrentval("SEQ_HERO_MASTER"));
    }

    public static void main(String[] args) {
        JdbcConnectUtil jdbcUtil = new JdbcConnectUtil();
        jdbcUtil.mode = 1;
        jdbcUtil.getFieldInfo("HERO_MASTER");
    }
}
