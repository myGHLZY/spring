package org.example.factory;

import org.example.dao.impl.UserDaoImpl;

public class MyBeanFactory1 {

    public static UserDaoImpl userDao(String name){
        System.out.println(name);
        System.out.println("静态工厂构造");
        return new UserDaoImpl();
    }

}
