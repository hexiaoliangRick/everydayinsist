package com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor;

import com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor.visitor.ModemVisitor;

/**
 * @author: cpuRick
 * @createTime: 2022/08/18 9:13
 * @description: 抽象类
 */
public abstract class Modem {

    public abstract void accept(ModemVisitor visitor);
}
