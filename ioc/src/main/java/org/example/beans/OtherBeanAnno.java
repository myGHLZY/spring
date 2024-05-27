package org.example.beans;

import com.alibaba.druid.pool.DruidDataSource;
import org.example.dao.UserDao;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

//@Component
public class OtherBeanAnno {


    @Bean("dataSource")
    /*
        注入数据，有多个直接(按名称注入)用Qualifier 按类型注入不用注解
     */
    public DataSource getDataSource(@Value("${jdbc.driver}") String driverClassNane,
                                    @Qualifier("userDaoAnno2") UserDao userDaoAnno2,
                                    UserService userService

    ){

        System.out.println(driverClassNane);
        System.out.println(userDaoAnno2);
        System.out.println(userService);

        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName(driverClassNane);
        return dataSource;
    }


}
