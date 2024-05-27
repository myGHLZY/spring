package org.example.factory;

import org.example.dao.impl.UserDaoImpl;

public class MyBeanFactory2 {

    public UserDaoImpl userDao(){
        System.out.println("非静态工厂构造");
        return new UserDaoImpl();
    }

}
