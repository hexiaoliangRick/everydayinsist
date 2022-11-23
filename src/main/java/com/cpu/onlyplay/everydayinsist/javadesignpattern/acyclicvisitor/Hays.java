package com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor;

import com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor.visitor.HaysVisitor;
import com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor.visitor.ModemVisitor;

/**
 * @author: cpuRick
 * @createTime: 2022/08/18 9:20
 * @description: 基础类
 */
public class Hays extends Modem {
    @Override
    public void accept(ModemVisitor visitor) {
        if (visitor instanceof HaysVisitor) {
            ((HaysVisitor) visitor).visit(this);
        }
    }
}
