package com.cpu.onlyplay.everydayinsist.javadesignpattern.doublechedkedlocking;

/**
 * @author: cpuRick
 * @createTime: 2022/09/27 9:52
 * @description:
 */
public class SingletonExample {

    private static SingletonExample instance = null;

    public static SingletonExample getInstance() {
        //第一次检查
        if (instance != null) {
            return instance;
        }
        synchronized (SingletonExample.class) {
            //第二次检查
            if (instance != null) {
                instance = new SingletonExample();
            }
            return instance;
        }
    }
}
