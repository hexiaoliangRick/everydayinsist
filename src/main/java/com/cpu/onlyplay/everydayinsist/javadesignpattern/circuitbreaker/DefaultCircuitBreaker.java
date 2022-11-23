package com.cpu.onlyplay.everydayinsist.javadesignpattern.circuitbreaker;

/**
 * @author: cpuRick
 * @createTime: 2022/08/23 9:26
 * @description: 默认熔断器
 */
public class DefaultCircuitBreaker implements CircuitBreaker {


    private State state;
    private final long timeOut;

    private final long retryTimePeriod;

    private final RemoteService remoteService;

    long lastFailureTime;
    int failureCount;

    private String lastFailureResponse;

    private final int failureThreshold;

    private final long futureTime = 1000 * 1000 * 1000 * 1000;


    /**
     * @param timeOut             api 超时时间
     * @param retryTimePeriod     远程服务状态检测周期
     * @param remoteService
     * @param lastFailureResponse
     * @param failureThreshold    远程服务被熔断的调用失败阈值
     */
    public DefaultCircuitBreaker(long timeOut, long retryTimePeriod, RemoteService remoteService, String lastFailureResponse, int failureThreshold) {
        this.timeOut = timeOut;
        this.retryTimePeriod = retryTimePeriod;
        this.remoteService = remoteService;
        this.state = State.CLOSED;
        this.lastFailureResponse = lastFailureResponse;
        this.failureThreshold = failureThreshold;
    }


    /**
     * 重置
     */
    @Override
    public void recordSuccess() {
        this.failureCount = 0;
        this.lastFailureTime = System.nanoTime() + futureTime;
        this.state = State.CLOSED;
    }

    @Override
    public void recordFailure(String response) {
        this.failureCount = this.failureCount + 1;
        this.lastFailureTime = System.nanoTime();
        //缓存失败的响应
        this.lastFailureResponse = response;
    }

    protected void evaluateState() {
        if (failureCount >= failureThreshold) {
            if (System.nanoTime() - lastFailureTime > retryTimePeriod) {
                state = State.HALF_OPEN;
            } else {
                state = State.OPEN;
            }
        } else {
            state = State.CLOSED;
        }
    }

    @Override
    public State getState() {
        evaluateState();
        return state;
    }

    @Override
    public void setState(State state) {
        this.state = state;
        switch (state) {
            case CLOSED:
                break;
            case HALF_OPEN:
                this.failureCount = failureThreshold;
                this.lastFailureTime = System.nanoTime() - retryTimePeriod;
                break;
            case OPEN:
                this.failureCount = failureThreshold;
                this.lastFailureTime = System.nanoTime();
                break;
        }
    }

    @Override
    public String attemptRequest() {
        evaluateState();
        if (state == State.OPEN) {
            return this.lastFailureResponse;
        } else {
            try {
                String response = remoteService.call();
                recordSuccess();
                return response;
            } catch (Exception e) {
                recordFailure(e.getMessage());
                throw e;
            }
        }
    }
}
