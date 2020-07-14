package com.example.demo2.bean;

import com.example.demo2.iter.Animal;

/**
 * 松鼠类
 */
public class Squirrel implements Animal {

    @Override
    public void use(){
        System.out.println("松鼠可以采集松果");
    }
}
