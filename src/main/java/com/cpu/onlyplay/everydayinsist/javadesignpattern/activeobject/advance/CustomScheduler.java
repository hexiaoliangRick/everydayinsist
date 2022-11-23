package com.cpu.onlyplay.everydayinsist.javadesignpattern.activeobject.advance;

import javafx.concurrent.Task;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: cpuRick
 * @createTime: 2022/08/17 9:18
 * @description: 自定义调度
 */
@Slf4j
public class CustomScheduler implements Runnable {

    private LinkedBlockingQueue<Runnable> activeQueue = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        dispatch();
    }


    public <T> Future<T> enqueue(Callable<T> methodRequest) {
        FutureTask<T> task = new FutureTask<T>(methodRequest) {
            @Override
            public void run() {
                try {
                    super.run();
                } catch (Exception e) {
                    this.setException(e);
                }
            }
        };

        //非阻塞式投递任务
        if (activeQueue.offer(task)) {
            return task;
        }
        return null;
    }


    public void dispatch() {
        while (true) {
            Runnable methodRequest;
            try {
                //阻塞式取出任务
                methodRequest = activeQueue.take();
                if (methodRequest != null) {
                    methodRequest.run();
                }
            } catch (InterruptedException e) {
                log.error("{}", e);
            }
        }
    }
}
