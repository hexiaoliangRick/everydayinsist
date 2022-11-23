package com.cpu.onlyplay.everydayinsist.javadesignpattern.ambassador;

/**
 * @author: cpuRick
 * @createTime: 2022/08/19 9:10
 * @description: ambassador
 */
public class ServiceAmbassador implements IRemoteService {
    private final IRemoteService remoteService;

    public ServiceAmbassador(IRemoteService remoteService) {
        this.remoteService = remoteService;
    }

    @Override
    public Long doRemoteFunction(int value) {
        return null;
    }


    private long checkLatency(int value) {
        Long timeMills = System.currentTimeMillis();
        Long result = remoteService.doRemoteFunction(value);
        Long timeTaken = System.currentTimeMillis() - timeMills;
        return result;
    }

}
