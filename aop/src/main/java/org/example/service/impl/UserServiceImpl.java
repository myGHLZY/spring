package org.example.service.impl;

import org.example.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Override
    public void show1() {
        System.out.println("show1......");
    }

    @Override
    public void show2() {
        System.out.println("show2......");
    }
}
