package org.example.test;


import org.example.config.AopConfig;
import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application4 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
//        userService.toString();
        userService.show1();
        userService.show2();

    }

}
