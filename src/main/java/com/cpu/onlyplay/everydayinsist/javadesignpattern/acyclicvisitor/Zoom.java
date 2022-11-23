package com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor;

import com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor.visitor.ModemVisitor;
import com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor.visitor.ZoomVisitor;

/**
 * @author: cpuRick
 * @createTime: 2022/08/18 9:15
 * @description: 基础类
 */
public class Zoom extends Modem {
    @Override
    public void accept(ModemVisitor visitor) {
        if (visitor instanceof ZoomVisitor) {
            ((ZoomVisitor) visitor).visit(this);
        }
    }
}
