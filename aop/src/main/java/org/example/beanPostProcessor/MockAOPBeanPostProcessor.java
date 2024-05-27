package org.example.beanPostProcessor;

import org.example.advice.MyAdvice;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MockAOPBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {

    private ApplicationContext applicationContext;

    //对UserServiceImpl中的show1和show2进行增强 增强方法在Advice中
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {

        // 筛选出UserServiceImpl 或Service.impl中下的方法都增强
        // 从Spring容器中获得Advice
        if(bean.getClass().getPackage().getName().equals("org.example.service.impl")){
            //生成Bean的Proxy对象
            Object userServiceProxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            //  执行 before 方法

                            MyAdvice myAdvice = (MyAdvice) applicationContext.getBean(MyAdvice.class);
                            myAdvice.beforeAdvice();
                            //  执行目标对象方法
                            Object invoke = method.invoke(bean, args);

                            //执行after方法
                            myAdvice.afterAdvice();
                            return invoke;
                        }
                    });
            return userServiceProxy;
        }

        return bean;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
