package com.example.demo.config;

import com.example.demo.po.StudentPO;
import com.example.demo.po.UserPO;
import com.example.demo.vo.UserVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置文件
 */
@Configuration
@ComponentScan(basePackages = "com.example.demo.po",basePackageClasses = UserVO.class,includeFilters = {@ComponentScan.Filter})
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
}
