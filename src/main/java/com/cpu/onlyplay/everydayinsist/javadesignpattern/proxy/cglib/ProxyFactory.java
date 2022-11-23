package com.cpu.onlyplay.everydayinsist.javadesignpattern.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: cpuRick
 * @createTime: 2022/08/17 15:18
 * @description: 代理类
 */
public class ProxyFactory implements MethodInterceptor {
    private final Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");
//        methodProxy.invoke(target, args);
        method.invoke(target, args);
        System.out.println("关闭事务");
        return null;
    }


    public Object getInstance() {
        Enhancer en = new Enhancer();
        en.setSuperclass(target.getClass());
        en.setCallback(this);
        return en.create();
    }
}
