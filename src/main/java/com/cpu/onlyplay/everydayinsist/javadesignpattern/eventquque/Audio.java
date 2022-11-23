//package com.cpu.onlyplay.everydayinsist.javadesignpattern.eventquque;
//
///**
// * @author: cpuRick
// * @createTime: 2022/11/08 11:38
// * @description:
// */
//public class Audio {
//
//    private static final Audio INSTANCE = new Audio();
//
//    private static final int MAX_PENDING = 16;
//
//    private int headIndex;
//
//    private int tailIndex;
//
//
//    private volatile Thread updateThread = null;
//
//
//    private final PlayMessage[] pendingAudio = new PlayMessage[MAX_PENDING];
//
//
//    Audio() {
//    }
//
//
//    public static Audio getInstance() {
//        return INSTANCE;
//    }
//
//
//    public synchronized void stopService() throws InterruptedException {
//        if (updateThread != null) {
//            updateThread.interrupt();
//        }
//        updateThread.join();
//        updateThread = null;
//    }
//
//
//    public synchronized boolean isServiceRunning() {
//        return updateThread != null && updateThread.isAlive();
//    }
//
//    public void init() {
//        if (updateThread == null) {
//            updateThread = new Thread(() -> {
//                while (!Thread.currentThread().isInterrupted()) {
//                    update();
//                }
//            });
//        }
//    }
//
//    private synchronized void startThread() {
//        if (!updateThread.isAlive()) {
//            updateThread.start();
//            headIndex = 0;
//            tailIndex = 0;
//        }
//    }
//
//
//    public void playSound()
//
//
//    private void update() {
//
//    }
//}
