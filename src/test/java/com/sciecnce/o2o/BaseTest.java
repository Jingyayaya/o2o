package com.sciecnce.o2o;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * configure spring and junit integration. load springIOC container when junit starts
 */
@RunWith(SpringJUnit4ClassRunner.class)
// tell junit where is spring configuration file
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class BaseTest {
}
