package org.example.test;

import org.example.service.UserService;
import org.example.service.impl.UserServiceImpl2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest3 {

    public static void main(String[] args) {
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("application3.xml");
        // 获取Bean对象的三种API
        UserServiceImpl2 userService = (UserServiceImpl2) applicationContext.getBean("userService2");
        UserService userService2 = applicationContext.getBean("userService2", UserService.class);
        UserService userService3= applicationContext.getBean(UserService.class);
        System.out.println(userService);
        System.out.println(userService2);
        System.out.println(userService3);
        if(userService.getUserDao()==null){
            System.out.println("userDao为空");
        }

    }

}
