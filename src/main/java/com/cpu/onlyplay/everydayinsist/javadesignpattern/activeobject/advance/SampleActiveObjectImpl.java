package com.cpu.onlyplay.everydayinsist.javadesignpattern.activeobject.advance;

import java.util.concurrent.Future;

/**
 * @author: cpuRick
 * @createTime: 2022/08/17 14:23
 * @description:
 */
public class SampleActiveObjectImpl {
    public String doProcess(String arg, int i) {
        try {
            // 模拟一个比较耗时的操作
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return arg + "-" + i;
    }
}
