package com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor.visitor;

import com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor.Hays;
import com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor.Modem;

/**
 * @author: cpuRick
 * @createTime: 2022/08/18 9:20
 * @description:
 */
public interface HaysVisitor extends ModemVisitor {
    void visit(Hays hayes);
}
