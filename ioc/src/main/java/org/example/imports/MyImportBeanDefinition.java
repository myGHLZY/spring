package org.example.imports;

import org.example.beans.OtherBeanAnno;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinition implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        BeanDefinition definition =new RootBeanDefinition();
        definition.setBeanClassName(OtherBeanAnno.class.getName());

        registry.registerBeanDefinition("MyImportBeanDefinitionOtherBeanAnno",definition);

    }
}
