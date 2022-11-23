package com.cpu.onlyplay.everydayinsist.juc.quque;

import java.util.Deque;

/**
 * @author: cpuRick
 * @createTime: 2022/10/19 14:43
 * @description: 数组队列
 */
public class ArrayDeque {

    public static void main(String[] args) {
        Deque<Integer> deque = new java.util.ArrayDeque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.add(2);
        deque.add(3);
        deque.add(4);

        deque.addLast(11);

    }
}
