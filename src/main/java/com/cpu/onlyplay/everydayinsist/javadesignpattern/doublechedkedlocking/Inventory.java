package com.cpu.onlyplay.everydayinsist.javadesignpattern.doublechedkedlocking;

import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: cpuRick
 * @createTime: 2022/09/27 9:43
 * @description:
 */
public class Inventory {

    private static final List<Item> items = new LinkedList<>();

    private static final Integer MAX_SIZE = 10;

    private static final ReentrantLock itemLock = new ReentrantLock();

    public static boolean add(Item item) {
        //第一次检查
        if (items.size() > MAX_SIZE) {
            return false;
        }
        itemLock.lock();
        try {
            if (items.size() > MAX_SIZE) {
                return false;
            }
            items.add(item);
            return true;
        } finally {
            itemLock.unlock();
        }
    }
}
