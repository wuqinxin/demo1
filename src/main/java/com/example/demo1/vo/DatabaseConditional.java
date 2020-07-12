package com.example.demo1.vo;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;



/**
 * 定义初始化数据库的条件，配漏属性连接不上时不配置数据源
 */
public class DatabaseConditional implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata){
        //取出环境配置
        Environment env = context.getEnvironment();
        //判断属性文件是否存在对应的数据库配置
        return env.containsProperty("database.driverName") && env.containsProperty("database.url")
                && env.containsProperty("database.username") && env.containsProperty("databse.password");
    }
}
