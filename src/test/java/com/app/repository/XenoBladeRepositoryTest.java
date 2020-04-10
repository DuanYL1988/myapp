package com.app.repository;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.service.XenobladeHeroService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml",
        "classpath:spring/spring-mvc.xml" })
public class XenoBladeRepositoryTest {

    @Inject
    XenobladeHeroService xenobladeService;

    @Inject
    TodoRepository todoRepository;
    
    @Test
    public void TestCase01() {
        String path = "D:\\apache-tomcat-8.5.6\\webapps\\myapp\\/resources/images/feh/acter/Lin_F_Normal/normal.png";
        System.out.println(path);
        path = path.replaceAll("\\\\", "/");
        System.out.println(path);
    }

    @Test
    public void TestCase02() {
        todoRepository.deleteByPrimaryKey(10000);
    }
}
