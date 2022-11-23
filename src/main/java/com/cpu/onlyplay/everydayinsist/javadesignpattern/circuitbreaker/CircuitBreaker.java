package com.cpu.onlyplay.everydayinsist.javadesignpattern.circuitbreaker;

/**
 * @author: cpuRick
 * @createTime: 2022/08/23 9:24
 * @description: 熔断器
 */
public interface CircuitBreaker {
    void recordSuccess();

    void recordFailure(String response);

    State getState();

    void setState(State state);

    String attemptRequest();
}
