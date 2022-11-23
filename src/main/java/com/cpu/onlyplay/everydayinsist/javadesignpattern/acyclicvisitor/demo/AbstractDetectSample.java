package com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor.demo;

import com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor.demo.visitor.DetectSampleVisitor;

/**
 * @author: cpuRick
 * @createTime: 2022/08/18 9:49
 * @description: 抽象样本类
 */
public abstract class AbstractDetectSample {

    public abstract void visit(DetectSampleVisitor visitor);
}
