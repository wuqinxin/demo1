package com.example.demo2;

import com.example.demo2.iter.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BusinessPerson implements Person{

    @Autowired
    private Animal animal = null;

    @Override
    public void service(){
        animal.use();
    }

    public BusinessPerson(@Autowired@Qualifier("dog") Animal animal) {
        this.animal = animal;
    }

    //    @Override
//    public void setAnimal(Animal animal){
//        this.animal = animal;
//    }
}
