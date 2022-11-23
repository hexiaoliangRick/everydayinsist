package com.cpu.onlyplay.everydayinsist.javadesignpattern.activeobject;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: cpuRick
 * @createTime: 2022/08/17 9:00
 * @description: 活动对象
 */
@Slf4j
public abstract class ActiveCreature {

    private BlockingQueue<Runnable> requests;

    private String name;

    private Thread thread;


    public ActiveCreature(String name) {
        this.name = name;
        this.requests = new LinkedBlockingQueue<Runnable>();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        requests.take().run();
                    } catch (InterruptedException e) {
                        log.error("{}", e);
                    }
                }
            }
        });
        thread.start();
    }

    public void eat() throws InterruptedException {
        requests.put(new Runnable() {
            @Override
            public void run() {
                log.info("{} is eating", name);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    log.error("{}", e);
                }
                log.info("{} finished eating");
            }
        });
    }


    public void roam() throws InterruptedException {
        requests.put(new Runnable() {
            @Override
            public void run() {
                log.info("{} has started to roam the wastelands", name);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    log.error("{}", e);
                }
                log.info("{} finished has started to roam the wastelands", name);
            }
        });
    }


}
