package org.example.test;

import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest2 {

    public static void main(String[] args) {
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("application2.xml");
        UserService userService=(UserService) applicationContext.getBean("userService");
        System.out.println(userService);

    }

}
