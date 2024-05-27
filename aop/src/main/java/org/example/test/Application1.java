package org.example.test;


import org.example.service.UserService;
import org.example.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application1 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
//        userService.toString();
        userService.show1();
        userService.show2();



    }

}
