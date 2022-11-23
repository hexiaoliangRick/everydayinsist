package com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor.demo;

import com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor.demo.visitor.DesensitizationProcessor;
import com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor.demo.visitor.DetectSampleVisitor;
import com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor.demo.visitor.DicomImageProcessor;

/**
 * @author: cpuRick
 * @createTime: 2022/08/18 9:52
 * @description: 医学影像
 */
public class DicomImage extends AbstractDetectSample {
    @Override
    public void visit(DetectSampleVisitor visitor) {
        if (visitor instanceof DicomImageProcessor) {
            ((DicomImageProcessor) visitor).accept(this);
        }
        if (visitor instanceof DesensitizationProcessor) {
            ((DesensitizationProcessor) visitor).accept();
        }
    }
}
