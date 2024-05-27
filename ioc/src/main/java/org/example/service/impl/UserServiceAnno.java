package org.example.service.impl;

import org.example.dao.UserDao;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userServiceAnno")
public class UserServiceAnno implements UserService {

    @Autowired //根据类型注入 如果类型有多个根据名字匹配 不成功报错
    @Qualifier("userDaoAnno2")  //此注释结合Autowired一起使用 根据名称注入相应Bean对象
//    @Resource
    UserDao userDao;

}
