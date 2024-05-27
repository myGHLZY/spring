package org.example.init;

import org.example.config.SpringConfig;
import org.example.config.SpringMVCConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyAbstractAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    // 提供Spring容器核心配置类信息
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    // 提供SpringMVC容器核心配置类信息
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfig.class};
    }

    @Override
    // 提供前端控制器的映射路径
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
