package com.cpu.onlyplay.everydayinsist.javadesignpattern.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: cpuRick
 * @createTime: 2022/09/27 8:41
 * @description:
 */
@Slf4j
public class SimpleCar implements Car {
    @Override
    public void running() {
        log.error("sample car is running.....");
    }
}
