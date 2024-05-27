package org.example.test;

import org.example.beans.OtherBeanAnno;
import org.example.config.SpringConfig;
import org.example.dao.UserDao;
import org.example.myComponent.OtherBean;
import org.example.service.RoomService;
import org.example.service.UserService;
import org.example.service.impl.RoomServiceImpl;
import org.example.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class ApplicationContextTest9 {

    public static void main(String[] args) throws Exception {

        // 注解方式加载核心配置类
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

//        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("application9.xml");

        UserDao userDao =(UserDao) applicationContext.getBean("userDaoAnno");
        System.out.println(userDao);
        userDao.show();

        UserService userService = (UserService) applicationContext.getBean("userServiceAnno");
        System.out.println(userService);

        DataSource dataSource =(DataSource) applicationContext.getBean("dataSource");
        System.out.println(dataSource);

        // @Component ->  @Import(OtherBeanAnno.class)  ->  @Import({}) 实现ImportSelector接口 [ImportDefinitionRegistry]
        System.out.println(applicationContext.getBean(OtherBeanAnno.class));

        // 注解整合MyBatis框架
        RoomService roomService = applicationContext.getBean(RoomServiceImpl.class);
        roomService.show();

//        System.out.println(applicationContext.getBean(OtherBean.class));

    }

}
