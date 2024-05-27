package org.example.test;

import org.example.dao.UserDao;
import org.example.service.UserService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class beanFactoryTest {
    public static void main(String[] args) {
        //创建工厂对象
        DefaultListableBeanFactory beanFactory =new DefaultListableBeanFactory();
        //读取Xml文件
        XmlBeanDefinitionReader reader =new XmlBeanDefinitionReader(beanFactory);
        //配置文件绑定工厂
        reader.loadBeanDefinitions("beans.xml");
        //根据id获取Bean对象实例

        UserService userService = (UserService) beanFactory.getBean("userService");
        System.out.println("获得UserService实例  "+userService);

        UserDao userDao = (UserDao) beanFactory.getBean("userDao");
        System.out.println("获得UserDao实例  "+userDao);
    }
}
