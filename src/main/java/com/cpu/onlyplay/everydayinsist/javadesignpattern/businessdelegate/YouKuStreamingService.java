package com.cpu.onlyplay.everydayinsist.javadesignpattern.businessdelegate;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: cpuRick
 * @createTime: 2022/08/23 8:55
 * @description: 优酷
 */
@Slf4j
public class YouKuStreamingService implements VideoStreamingService {
    @Override
    public void processing() {
        log.info("you ku playing video....{}");
    }
}
