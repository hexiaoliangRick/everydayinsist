package com.cpu.onlyplay.everydayinsist.javadesignpattern.bridge;

/**
 * @author: cpuRick
 * @createTime: 2022/08/19 9:44
 * @description: 三角形
 */
public class Triangle extends Shape {

    public Triangle(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        color.applyColor();
    }
}
