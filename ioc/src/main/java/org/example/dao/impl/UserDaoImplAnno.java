package org.example.dao.impl;


import org.example.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// <beans id="userDao" class="org.example.dao.impl.UserDaoImplAnno">
@Repository("userDaoAnno")
public class UserDaoImplAnno implements UserDao {

    @Value("haohao")
    String username;

    @Value("${jdbc.username}")
    String jdbc;

    @Override
    public void show() {
        System.out.println(username);
        System.out.println(jdbc);
    }
}
