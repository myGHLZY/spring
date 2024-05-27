package org.example.test;


import org.aspectj.weaver.Advice;
import org.example.service.UserService;
import org.example.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application2 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application2.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
//        userService.toString();
        userService.show1();
        userService.show2();

//        UserServiceImpl userService2 =  applicationContext.getBean(UserServiceImpl.class);
//        System.out.println(userService2);
//        userService2.show1();


    }

}
