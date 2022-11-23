package com.cpu.onlyplay.everydayinsist.juc.threadpool;

import lombok.extern.slf4j.Slf4j;
import sun.nio.ch.ThreadPool;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: cpuRick
 * @createTime: 2022/10/11 15:15
 * @description:
 */
@Slf4j
public class ThreadPoolClient {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 10, 1l, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        threadPool.prestartAllCoreThreads();
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        log.error("{}", e);
                    }
                }
            }
        });
        threadPool.shutdown();
    }
}
