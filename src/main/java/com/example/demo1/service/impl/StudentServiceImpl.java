package com.example.demo1.service.impl;

import com.example.demo1.config.AppConfig;
import com.example.demo1.po.UserPO;
import com.example.demo1.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    public UserPO getUserPo(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        UserPO userPO = ctx.getBean(UserPO.class);
        return userPO;
    }
}
