package com.example.demo1.po;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StudentPO {
    @Value("gtc110")
    private String stuNo;
    @Value("普通学生")
    private String stuName;

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    @Override
    public String toString() {
        return "StudentPO{" +
                "stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                '}';
    }
}
