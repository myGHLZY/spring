package org.example.config;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;


//@HandlesTypes()
public class MyAnnotationConfigApplicationContext extends AnnotationConfigWebApplicationContext {

    public MyAnnotationConfigApplicationContext(){
        super.register(SpringMVCConfig.class);
    }

}
