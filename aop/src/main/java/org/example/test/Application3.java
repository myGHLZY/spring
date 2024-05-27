package org.example.test;


import org.example.service.UserService;
import org.example.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application3 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application3.xml");
        UserService userService = applicationContext.getBean(UserService.class);
//        userService.toString();
        userService.show1();
        userService.show2();

    }

}
