package com.cpu.onlyplay.everydayinsist.javadesignpattern.businessdelegate;

/**
 * @author: cpuRick
 * @createTime: 2022/08/23 8:55
 * @description: 业务寻找类
 */
public class BusinessLookup {
    private YouKuStreamingService youKuStreamingService;

    private NetfixStreamingService netfixStreamingService;

    public VideoStreamingService getBusinessService(String movie) {
        if (movie.toLowerCase().contains("die hard")) {
            return netfixStreamingService;
        } else {
            return youKuStreamingService;
        }

    }
}
