package com.cpu.onlyplay.everydayinsist.javadesignpattern.businessdelegate;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: cpuRick
 * @createTime: 2022/08/23 8:54
 * @description: 网飞服务
 */
@Slf4j
public class NetfixStreamingService implements VideoStreamingService {
    @Override
    public void processing() {
        log.info(" netfix playing video...{}");
    }
}
