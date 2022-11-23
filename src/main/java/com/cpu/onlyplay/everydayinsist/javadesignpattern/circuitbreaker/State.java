package com.cpu.onlyplay.everydayinsist.javadesignpattern.circuitbreaker;

/**
 * @author: cpuRick
 * @createTime: 2022/08/23 9:32
 * @description: 状态
 */
public enum State {
    CLOSED,
    HALF_OPEN,
    OPEN;
}
