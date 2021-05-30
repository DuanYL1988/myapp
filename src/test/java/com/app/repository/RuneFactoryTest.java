package com.app.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.model.Farm;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml" })
public class RuneFactoryTest {

    @Autowired
    FarmRepository farmRepo;

    @Test
    public void testInsert() {
        for (int parent = 1; parent <= 16; parent++) {

            for (int cell = 1; cell <= 4; cell++) {
                Farm farm = new Farm();
                farm.setLocation("家门口");
                farm.setParentFarm(parent);
                farm.setIndexNum(cell);
                farmRepo.insert(farm);
            }
        }
    }
}
