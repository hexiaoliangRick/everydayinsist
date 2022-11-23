package com.cpu.onlyplay.everydayinsist.javadesignpattern.doublechedkedlocking;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: cpuRick
 * @createTime: 2022/09/27 9:59
 * @description:
 */
@Slf4j
public class App {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int index = 0; index < 3; index++) {
            executorService.execute(() -> {
                Inventory.add(new Item());
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("{}", e);
        }
    }
}
