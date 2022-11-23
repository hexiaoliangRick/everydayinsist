package com.cpu.onlyplay.everydayinsist.javadesignpattern.activeobject;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author: cpuRick
 * @createTime: 2022/08/17 9:08
 * @description:
 */
@Slf4j
public class main {

    public static void main(String[] args) {
        ActiveCreature creature;
        try {
            for (int i = 0; i < 10; i++) {
                creature = new Orc(Orc.class.getSimpleName().toString() + i);
                creature.eat();
                creature.roam();
            }
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        Runtime.getRuntime().exit(1);
    }
}


