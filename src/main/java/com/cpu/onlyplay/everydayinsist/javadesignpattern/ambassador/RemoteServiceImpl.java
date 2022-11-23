package com.cpu.onlyplay.everydayinsist.javadesignpattern.ambassador;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author: cpuRick
 * @createTime: 2022/08/19 9:08
 * @description:
 */
@Slf4j
public class RemoteServiceImpl implements IRemoteService {


    @Override
    public Long doRemoteFunction(int value) {
        try {
            Random random = new Random();
            int millSeconds = random.nextInt(100);
            TimeUnit.MILLISECONDS.sleep(millSeconds);
            return new Long(millSeconds);
        } catch (InterruptedException e) {
            log.info("{}", e);
            return 0l;
        }
    }
}
