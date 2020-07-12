package com.example.demo2;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 后置Bean初始化器，对所有的bean有效
 */
@Component
public class BeanPostProcessorExample{ //implements BeanPostProcessor {

//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName){
//        System.out.println("BeanPostProcessor调用" +
//                "postProcessorBeforeInitialization方法，参数[" +
//                bean.getClass().getSimpleName() + "][" + beanName + "]");
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName){
//        System.out.println("BeanPostProcessor调用" +
//                "postProcessAfterInitialization方法，参数[" +
//                bean.getClass().getSimpleName() + "][" + beanName + "]");
//        return bean;
//    }
}
