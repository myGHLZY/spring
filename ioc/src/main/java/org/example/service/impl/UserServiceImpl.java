package org.example.service.impl;

import org.example.dao.UserDao;
import org.example.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public class UserServiceImpl implements UserService {

    private UserDao userDao;
    //BeanFactory调用该方法 将UserDao注入
    public void setUserDao(UserDao userDao){
        System.out.println("UserServiceImpl的setUserDao方法被调用");
    }

//    public UserServiceImpl(){
//        System.out.println("无参构造方法执行");
//    }

    public UserServiceImpl(String name){
        System.out.println(name);
    }
//
//    void init(){
//        System.out.println("初始化方法");
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("InitializingBean中的afterPropertiesSet执行");
//    }

    /*
    set方法最先执行 -> afterPropertiesSet其次 -> init初始化方法最后
     */


    //注入一个List
    private List<String> list;
    public void setList(List<String> list) {
        System.out.println("serServiceImpl的setList方法被调用");
//        System.out.println(list);
        this.list = list;
    }

    //注入set
    private Set<UserDao> userDaos;

    public void setUserDaos(Set<UserDao> userDaos) {
        System.out.println("serServiceImpl的setUserDaos方法被调用");
        this.userDaos = userDaos;
    }
}
