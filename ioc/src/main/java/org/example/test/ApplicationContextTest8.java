package org.example.test;

import org.apache.ibatis.session.SqlSessionFactory;
import org.example.service.RoomService;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.mybatis.spring.SqlSessionFactoryBean;

public class ApplicationContextTest8 {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("application8.xml");
        RoomService roomService = (RoomService) applicationContext.getBean("roomService");
        roomService.show();
//        SqlSessionFactoryBean
//        SqlSessionFactoryBean 主要是产生SqlSessionFactory
//        MapperScannerConfigurer 扫描指定的包，产生对应的对象

    }

}
