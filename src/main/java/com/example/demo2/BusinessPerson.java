package com.example.demo2;

import com.example.demo2.bean.Cat;
import com.example.demo2.iter.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BusinessPerson implements Person, BeanNameAware, BeanFactoryAware,
        ApplicationContextAware, InitializingBean, DisposableBean {
    private Logger logger = LoggerFactory.getLogger(BusinessPerson.class);
    //@Autowired
    private Animal animal = null;

    @Override
    public void service() {
        animal.use();
    }

    public BusinessPerson(@Autowired @Qualifier("dog") Animal animal) {
        this.animal = animal;
    }

    @Override
    @Autowired
    public void setAnimal(Animal animal) {
        System.out.println("查看Bean初始化");
        //logger.info("info的测试打印");
        this.animal = animal;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("[" + this.getClass().getSimpleName() + "]调用BeanNameAware的setBeanName");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        System.out.println("[" + this.getClass().getSimpleName() + "]调用BeanFactoryAware的setBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        System.out.println("[" + this.getClass().getSimpleName() + "]调用ApplicationContextAware的setApplicationContext");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("[" + this.getClass().getSimpleName() + "]调用InitializingBean的afterPropertiesSet方法");
    }

    @PostConstruct
    public void init() {
        System.out.println("[" + this.getClass().getSimpleName() + "]注解了@PostConstruct定义的自定义初始化方法");
    }

    @PreDestroy
    public void destroy1() {
        System.out.println("[" + this.getClass().getSimpleName() + "]注解了@PreDestroy方法");
    }

    @Override
    public void destroy(){
        System.out.println("[" + this.getClass().getSimpleName() + "]DisposableBean方法");

    }
}
