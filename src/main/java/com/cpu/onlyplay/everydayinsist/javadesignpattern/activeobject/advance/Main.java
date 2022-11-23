package com.cpu.onlyplay.everydayinsist.javadesignpattern.activeobject.advance;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: cpuRick
 * @createTime: 2022/08/17 14:20
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        try {
            SampleActiveObject sao = ActiveObjectProxy.newInstance(
                    SampleActiveObject.class, new SampleActiveObjectImpl(),
                    Executors.newCachedThreadPool());
            Future<String> ft = null;
            try {
                ft = sao.process("Something", 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread.sleep(500);
            System.out.println(ft.get());
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
