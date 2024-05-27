package org.example.test;

import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {

    // ApplicationContext底层对BeanFactory进行封装，本身是对BeanFactory的拓展和增强
    // 配置文件建议命名为 application.xml

    // Application继承了BeanFactory 但内部也维护了BeanFactory的对象 既有继承关系也有融合关系

    // BeanFactory 在调用getBean方法的时候实例化Bean对象(延迟加载) ApplicationContext 在配置文件加载完毕就创建Bean对像(立即加载)
    public static void main(String[] args) {
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        System.out.println(userService);
        UserService userService2 = (UserService) applicationContext.getBean("userService");
        System.out.println(userService2);
    }

}
