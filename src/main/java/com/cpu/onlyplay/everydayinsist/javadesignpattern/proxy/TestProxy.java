package com.cpu.onlyplay.everydayinsist.javadesignpattern.proxy;

import com.cpu.onlyplay.everydayinsist.javadesignpattern.proxy.jdk.ProxyFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: cpuRick
 * @createTime: 2022/08/17 14:44
 * @description: 测试代理模式
 */
@Slf4j
public class TestProxy {

    public static void main(String[] args) {
        IUserDao target = new UserDao();
        System.out.println(target.getClass());
        ProxyFactory proxyFactory = new ProxyFactory(target);
        IUserDao proxy = (IUserDao) (proxyFactory.getInstance());
        System.out.println(proxy.getClass());
        proxy.save();
    }


}
