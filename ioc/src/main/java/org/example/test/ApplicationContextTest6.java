package org.example.test;

import org.example.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest6 {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("application6.xml");
        // postProcessBeforeInitialization 和 postProcessAfterInitialization 之间是初始化方法
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");

        // 日志增强demo
        userDao.show();

    }

}
