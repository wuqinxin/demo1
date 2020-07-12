package com.example.demo1.config;

import com.example.demo1.po.UserPO;
import com.example.demo1.vo.UserVO;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 配置文件
 */
@Configuration
@ComponentScan(basePackages = "com.example.demo1.vo")
//@ComponentScan(basePackages = "com.example.demo1.po",basePackageClasses = UserVO.class,
//       // includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = UserVO.class)})
//        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = UserPO.class)})
public class AppConfig {
//    @Bean(name = "user")
//    public UserPO initUser(){
//        UserPO userPO = new UserPO();
//        userPO.setId(1L);
//        userPO.setUserName("张三");
//        userPO.setNote("张三的信息");
//        return userPO;
//    }

//    @Bean(name = "user2")
//    public UserPO initUser2(){
//        UserPO userPO = new UserPO();
//        userPO.setId(1L);
//        userPO.setUserName("张三");
//        userPO.setNote("张三的信息");
//        return userPO;
//    }

//    @Bean(name = "user3")
//    public StudentPO initUser3(){
//        StudentPO studentPO = new StudentPO();
//        studentPO.setStuName("学生1");
//        studentPO.setStuNo("AAA");
//        return studentPO;
//    }

    @Bean
    public DataSource getDataSource() {
        Properties properties = new Properties();
        properties.setProperty("driver","com.mysql.jdbc.Driver");
        properties.setProperty("url","jdbc:mysql://localhost:3306/demo");
        properties.setProperty("username","root");
        properties.setProperty("password","root");
        DataSource dataSource = null;
        try{
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e){
            e.printStackTrace();
        }
        return  dataSource;
    }
}
