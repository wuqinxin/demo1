package com.example.demo1.po;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 用户对象
 */
@Component
public class UserPO {
    @Value("1")
    private Long id;
    @Value("超级管理员")
    private String userName;
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "UserPO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public void setNote(String note) {
        this.note = note;
    }
}
