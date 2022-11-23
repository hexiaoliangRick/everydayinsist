package com.cpu.onlyplay.everydayinsist.javadesignpattern.activeobject.advance;

import java.util.concurrent.Future;

/**
 * @author: cpuRick
 * @createTime: 2022/08/17 14:22
 * @description:
 */
public interface SampleActiveObject {
    public Future<String> process(String args, int i);
}
