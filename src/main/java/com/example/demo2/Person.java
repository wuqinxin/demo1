package com.example.demo2;

import com.example.demo2.iter.Animal;

/**
 * 人类接口
 */
public interface Person {

    //使用动物提供服务
    void service();

    void setAnimal(Animal animal);
}
