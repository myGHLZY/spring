package org.example.processor;

import org.example.utils.BaseClassScanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.util.Map;

public class MyComponentBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //动态注册注解
        //扫描
        Map<String, Class> map = BaseClassScanUtils.scanMyComponentAnnotation("org.example");
//        System.out.println(map);
        //创建BeanDefinition
        map.forEach((beanName,clazz)->{
            String name = clazz.getName();
            BeanDefinition definition = new RootBeanDefinition();
            definition.setBeanClassName(name);
            //注册
            registry.registerBeanDefinition(name,definition);
        });


    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinitionRegistryPostProcessor.super.postProcessBeanFactory(beanFactory);
    }
}
