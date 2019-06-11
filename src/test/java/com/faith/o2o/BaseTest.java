package com.faith.o2o;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-11
 * @Description: 初始化spring的配置  junit启动加载spring容器
 * @version: 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
// 下一步告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class BaseTest {
}
