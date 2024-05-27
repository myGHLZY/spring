package org.example.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanDefinition填充完成，回调BeanFactoryPostProcessor方法");

        // 修改beanFactory内维护的BeanDefinitionMap
//        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userDao");
//        beanDefinition.setBeanClassName("org.example.service.impl.UserServiceImpl2");

        //动态注册一个Bean
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClassName("org.example.service.impl.UserServiceImpl2");
        DefaultListableBeanFactory defaultListableBeanFactory =(DefaultListableBeanFactory) beanFactory;

        defaultListableBeanFactory.registerBeanDefinition("userServiceImpl2",beanDefinition);


    }
}
