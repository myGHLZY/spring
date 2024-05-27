package org.example.service.impl;

import org.example.dao.UserDao;
import org.example.service.UserService;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

public class UserServiceImpl2 implements UserService {

    public UserServiceImpl2(){
        System.out.println("无参构造");
    }

    private UserDao userDao;
    private String username;
    public void setUserDao(UserDao userDao) {
        System.out.println("bean对象的属性填充");
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUsername(String username) {
        this.username = username;
    }


//    @Override
//    public void setServletContext(ServletContext servletContext) {
//
//    }
}
