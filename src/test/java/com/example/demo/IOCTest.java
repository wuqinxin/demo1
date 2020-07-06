package com.example.demo;


import com.example.demo.config.AppConfig;
import com.example.demo.po.StudentPO;

import com.example.demo.po.UserPO;
import com.example.demo.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest {
    private static Logger logger = LoggerFactory.getLogger(IOCTest.class);
    public static void main(String[] args) {
        //将AppConfig传递给AnnotationConfigApplicationContext的构造方法
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        UserPO userPO = (UserPO)ctx.getBean("user");
        System.out.println(userPO.getId() + userPO.getUserName());

        UserPO userPO2 = ctx.getBean(UserPO.class);
        System.out.println(userPO2);

        StudentPO studentPO = ctx.getBean(StudentPO.class);
        System.out.println(studentPO.getStuName());
        logger.info(studentPO.getStuName());

//        UserVO userPO = (UserVO)ctx.getBean("user");
//        System.out.println(userPO.getId() + userPO.getUserName());
//
//        UserVO userPO2 = ctx.getBean(UserVO.class);
//        System.out.println(userPO2);

        logger.info(userPO.getNote());
        logger.info(userPO2.getNote());

        UserVO userVO = ctx.getBean(UserVO.class);
        logger.info(userVO.toString());
    }
}
