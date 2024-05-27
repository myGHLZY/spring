package org.example.factory;

import org.example.dao.UserDao;
import org.example.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.FactoryBean;

public class MyBeanFactory3 implements FactoryBean<UserDao> {


    @Override
    public UserDao getObject() throws Exception {
        System.out.println("getObject方法执行");
        return new UserDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
    }
}
