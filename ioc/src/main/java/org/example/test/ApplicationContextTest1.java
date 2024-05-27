package org.example.test;

import org.example.dao.UserDao;
import org.example.dao.impl.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest1 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserDao userDao=(UserDao) applicationContext.getBean("userDaoStaticFactory");
        System.out.println(userDao);

        UserDao userDao2=(UserDao) applicationContext.getBean("userDaoFactory2");
        System.out.println(userDao2);

        /*
        上述代码结果如下
            静态工厂构造
            非静态工厂构造
            org.example.dao.impl.UserDaoImpl@6a472554
            org.example.dao.impl.UserDaoImpl@7ff2a664
        这是ApplicationContext的立即加载
         */
        System.out.println("===========");
//        userDao3 (规范延迟实例化) 会在项目启动时被加载进beanFactory中，但是，此时value实际上是FactoryBean对象
//        只有在调用getBean时，才会调用FactoryBean对象的getObject方法，返回此对象，并存入cache中
        UserDao userDao3 = (UserDao) applicationContext.getBean("userDaoFactoryBean");
        System.out.println(userDao3);


    }



}
