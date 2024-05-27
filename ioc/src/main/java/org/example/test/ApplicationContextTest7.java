package org.example.test;

import org.example.dao.UserDao;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContextTest7 {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("application7.xml");

        //bean对象的初始化阶段
        applicationContext.getBean("userService");
        //bean对象创建时，按照配置文件的顺序

        /*
        private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);
        单例池，一级缓存，存储完整Bean

        private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>(16);
        三级缓存，存储一个早期Bean且未被其他对象引用(在加入的Bean对象创建一个对应的ObjectFactory，调用其中的getObject获得对象)

        private final Map<String, Object> earlySingletonObjects = new ConcurrentHashMap<>(16);
        早期单例池，二级缓存，存储早期Bean,早期Bean被其他对象引用
         */

        /*
        UserService 实例化对象，但尚未初始化，将UserService存储到三级缓存；
        UserService 属性注入，需要UserDao，从缓存中获取，没有UserDao；
        UserDao实例化对象，但尚未初始化，将UserDao存储到到三级缓存；
        UserDao属性注入，需要UserService，从三级缓存获取UserService，UserService从三级缓存移入二级缓存；
        UserDao执行其他生命周期过程，最终成为一个完成Bean，存储到一级缓存，删除二三级缓存；
        UserService 注入UserDao；
        UserService执行其他生命周期过程，最终成为一个完成Bean，存储到一级缓存，删除二三级缓存。
         */

    }

}
