package com.cpu.onlyplay.everydayinsist.javadesignpattern.doubledispatch;

/**
 * @author: cpuRick
 * @createTime: 2022/09/02 9:37
 * @description:
 */
public class Client {
    public static void main(String[] args) {
        AbstractCommand commandA = new CommandA();
        AbstractReceiver receiverX = new ReceiverX();
        receiverX.foo(commandA);

        AbstractCommand commandB=new CommandB();
        AbstractReceiver receiverY=new ReceiverY();
        receiverY.foo(commandB);
    }
}
