package org.example.annotation;

import org.example.imports.MyImportBeanDefinition;
import org.mybatis.spring.annotation.MapperScannerRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import({MyImportBeanDefinition.class})
public @interface MyMapperScan {
}
