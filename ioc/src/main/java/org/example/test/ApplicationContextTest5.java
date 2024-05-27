package org.example.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.dao.UserDao;
import org.example.service.UserService;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

public class ApplicationContextTest5 {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("application5.xml");
        Object userDao =  applicationContext.getBean("userDao");
        /*
        Spring容器在进行初始化时，会将xml配置的<bean>的信息封装成一个BeanDefinition对象，所有的
        BeanDefinition存储到一个名为beanDefinitionMap的Map集合中去，Spring框架在对该Map进行遍历，使用反
        射创建Bean实例对象，创建好的Bean对象存储在一个名为singletonObjects的Map集合中，当调用getBean方法
        时则最终从该Map集合中取出Bean实例对象返回。
         */

        // BeanDefinition填充完成 -> (BeanFactoryPostProcessor) -> 遍历BeanDefinition创建Bean -> (BeanPostProcessor) -> 填充singletonObjects
        // BeanFactoryPostProcessor执行一次 BeanPostProcessor在每个Bean创建之后都执行一次
        System.out.println(userDao);

        Object userServiceImpl2 = applicationContext.getBean("userServiceImpl2");
        System.out.println(userServiceImpl2);

        //自定义注解 @MyComponent
        Object otherBean = applicationContext.getBean("org.example.myComponent.OtherBean");
        System.out.println(otherBean);

        //


    }

}
