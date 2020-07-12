package com.example.demo2.bean;

import com.example.demo2.iter.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {
    private Logger logger = LoggerFactory.getLogger(Dog.class);

    @Override
    public void use(){
        logger.info("汪汪汪！");
    }
}
