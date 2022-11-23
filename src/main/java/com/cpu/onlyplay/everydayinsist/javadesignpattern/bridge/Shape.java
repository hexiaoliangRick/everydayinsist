package com.cpu.onlyplay.everydayinsist.javadesignpattern.bridge;

/**
 * @author: cpuRick
 * @createTime: 2022/08/19 9:42
 * @description: 形状
 */
public abstract class Shape {

    protected final Color color;


    public Shape(Color color) {
        this.color = color;
    }

    public abstract void applyColor();
}
