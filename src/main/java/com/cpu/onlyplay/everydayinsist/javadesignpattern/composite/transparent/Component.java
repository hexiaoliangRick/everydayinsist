package com.cpu.onlyplay.everydayinsist.javadesignpattern.composite.transparent;

import java.util.List;

/**
 * @author: cpuRick
 * @createTime: 2022/08/25 9:35
 * @description: 抽象类
 */
public abstract class Component {

    abstract void add(Component component);

    abstract List<Component> children();


    abstract void remove(Component component);
}
