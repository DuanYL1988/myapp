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
        for (int parent = 1; parent <= 40; parent++) {

            for (int cell = 1; cell <= 4; cell++) {
                Farm farm = new Farm();
                farm.setLocation("04");
                farm.setParentFarm(parent);
                farm.setIndexNum(cell);

                farm.setTotalLevel(1.00d);
                farm.setSizeLevel(1.00d);
                farm.setSpeedLevel(1.00d);
                farm.setQualityLevel(1.00d);
                farm.setCountLevel(1.00d);
                farm.setHealth(64);
                farmRepo.insert(farm);
            }
        }
    }

    @Test
    public void testSelect() {
        Farm inDto = new Farm();
        inDto.setLocation("01");
        farmRepo.selectByDto(inDto);
    }
}
