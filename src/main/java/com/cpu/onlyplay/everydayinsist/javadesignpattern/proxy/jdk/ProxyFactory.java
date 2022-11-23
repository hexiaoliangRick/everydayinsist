package com.cpu.onlyplay.everydayinsist.javadesignpattern.proxy.jdk;

import com.cpu.onlyplay.everydayinsist.javadesignpattern.proxy.IUserDao;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: cpuRick
 * @createTime: 2022/08/17 14:41
 * @description: 代理工厂
 */

public class ProxyFactory {

    private final Object target;


    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), new Class[]{IUserDao.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开启事务");
                Object returnValue = method.invoke(target, args);
                System.out.println("提交事务");
                return null;
            }
        });
    }
}
