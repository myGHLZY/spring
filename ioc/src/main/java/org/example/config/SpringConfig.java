package org.example.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.example.annotation.MyMapperScan;
import org.example.beans.OtherBeanAnno;
import org.example.imports.MyImportBeanDefinition;
import org.example.imports.MyImportSelector;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration  //标注当前是一个配置类 替代配置文件
@ComponentScan(basePackages = {"org.example"})  //组件扫描
@PropertySource({"classpath:jdbc.properties"})
//@Import(OtherBeanAnno.class)  //替代了OtherBean的@Component注解
@Import(MyImportSelector.class)
//@Import({MyImportBeanDefinition.class})
//@MyMapperScan
@MapperScan("org.example.mapper")  //Mapper接口扫描
public class SpringConfig {

    @Bean
    public DataSource dataSource(
            @Value("${jdbc.driver}") String driver,
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.username}") String username,
            @Value("${jdbc.password}") String password
    ){
        DruidDataSource dataSource =new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean("sqlSessionFactoryBean")
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

}
