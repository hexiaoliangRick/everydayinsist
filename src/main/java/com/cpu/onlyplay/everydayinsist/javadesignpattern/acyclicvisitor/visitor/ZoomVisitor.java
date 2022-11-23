package com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor.visitor;

import com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor.Modem;
import com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor.Zoom;

/**
 * @author: cpuRick
 * @createTime: 2022/08/18 9:16
 * @description: 访问类
 */
public interface ZoomVisitor extends ModemVisitor {
    void visit(Zoom zoom);
}
