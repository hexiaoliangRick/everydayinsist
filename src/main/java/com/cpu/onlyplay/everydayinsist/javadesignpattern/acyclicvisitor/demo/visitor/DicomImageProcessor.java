package com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor.demo.visitor;

import com.cpu.onlyplay.everydayinsist.javadesignpattern.acyclicvisitor.demo.DicomImage;

/**
 * @author: cpuRick
 * @createTime: 2022/08/18 9:54
 * @description: 影像处理类
 */
public interface DicomImageProcessor extends DetectSampleVisitor {
    void accept(DicomImage dicomImage);
}
