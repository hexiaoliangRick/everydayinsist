package com.cpu.onlyplay.everydayinsist.javadesignpattern.combinator;

/**
 * @author: cpuRick
 * @createTime: 2022/08/29 9:36
 * @description:
 */
public class User {

    private final String name;


    private final String email;


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
