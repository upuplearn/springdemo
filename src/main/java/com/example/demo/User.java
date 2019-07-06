package com.example.demo;

import java.io.Serializable;

/**
 * @author xyys
 * @version 1.0
 * @description com.example.demo
 * @date 2019/6/6 0006
 */
public class User implements Serializable{
    private String name;
    private  String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
