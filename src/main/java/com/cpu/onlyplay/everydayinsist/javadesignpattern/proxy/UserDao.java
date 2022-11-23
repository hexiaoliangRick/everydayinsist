package com.cpu.onlyplay.everydayinsist.javadesignpattern.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: cpuRick
 * @createTime: 2022/08/17 14:40
 * @description: 用户接口
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("保存数据");
    }
}
