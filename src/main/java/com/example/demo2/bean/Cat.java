package com.example.demo2.bean;

import com.example.demo2.iter.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Cat implements Animal {
    private Logger logger = LoggerFactory.getLogger(Cat.class);

    @Override
    public void use(){
        logger.info("喵喵喵！");
    }
}
