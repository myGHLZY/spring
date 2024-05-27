package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "org.example")
@EnableAspectJAutoProxy //<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
public class AopConfig {
}
