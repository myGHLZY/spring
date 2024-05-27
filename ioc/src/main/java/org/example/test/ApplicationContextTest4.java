package org.example.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.SimpleThreadScope;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApplicationContextTest4 {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("application4.xml");

//        DruidDataSource druidDataSource =new DruidDataSource();
        //无参构造注入基本信息
        DruidDataSource dataSource = (DruidDataSource)applicationContext.getBean("dataSource");
        System.out.println(dataSource);
        System.out.println("==========================");

//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connection = DriverManager.getConnection("","","");
        //静态工厂构造
        Connection connection = (Connection) applicationContext.getBean("connection");
        System.out.println(connection);
        System.out.println("==========================");

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = simpleDateFormat.parse("2023-10-10 12:12:12");
        //非静态工厂构造
        Object data = applicationContext.getBean("data");
        System.out.println(data);
        System.out.println("==========================");

        //静态工厂
//        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //无参构造实例化
//        SqlSessionFactoryBuilder build = new SqlSessionFactoryBuilder();
        //实例工厂
//        SqlSessionFactory sqlSessionFactory = build.build(in);

        SqlSessionFactory sqlSessionFactory =(SqlSessionFactory) applicationContext.getBean("sqlSessionFactory");
        System.out.println(sqlSessionFactory);
        SqlSession sqlSession = sqlSessionFactory.openSession();


    }

}
