package com.example.demo1;


import com.example.demo1.config.AppConfig;

import com.example.demo1.vo.DataBaseProperties;
import com.example.demo2.BusinessPerson;
import com.example.demo2.Person;
import com.example.demo2.bean.ScopeBean;
import com.example.demo2.bean.Squirrel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOCTest {
    private static Logger logger = LoggerFactory.getLogger(IOCTest.class);
    public static void main(String[] args) {
        //将AppConfig传递给AnnotationConfigApplicationContext的构造方法
 //       ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//        UserPO userPO = (UserPO)ctx.getBean("user");
//        System.out.println(userPO.getId() + userPO.getUserName());

//        UserPO userPO2 = ctx.getBean(UserPO.class);
//        System.out.println(userPO2);
//
//        StudentPO studentPO = ctx.getBean(StudentPO.class);
//        System.out.println(studentPO.getStuName());
//        logger.info(studentPO.getStuName());
//
////        UserVO userPO = (UserVO)ctx.getBean("user");
////        System.out.println(userPO.getId() + userPO.getUserName());
////
//        UserVO userPO2 = ctx.getBean(UserVO.class);
//        System.out.println(userPO2);
//
//       // logger.info(userPO.getNote());
//        logger.info(userPO2.getNote());
////
//        UserVO userVO = ctx.getBean(UserVO.class);
//        logger.info(userVO.toString());

//        DataSource dataSource = ctx.getBean(DataSource.class);
//        logger.info(dataSource.toString());


//        Person person = ctx.getBean(BusinessPerson.class);
//        person.service();


//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
////        Person person = ctx.getBean(BusinessPerson.class);
////        person.service();
//        ctx.close();

//
        ApplicationContext act = new AnnotationConfigApplicationContext(AppConfig.class);
//        DataBaseProperties dbp = act.getBean(DataBaseProperties.class);
//        System.out.println("dbp.url" + dbp.getUrl());

        ScopeBean scopeBean1 = act.getBean(ScopeBean.class);
 //       ScopeBean scopeBean2 = act.getBean(ScopeBean.class);
        System.out.println(scopeBean1.getName());
//        System.out.println(scopeBean1 == scopeBean2);
//        scopeBean1.setName("AAA");
//        System.out.println(scopeBean2.getName());
//        Squirrel squirrel = act.getBean(Squirrel.class);
//        squirrel.use();
    }
}
