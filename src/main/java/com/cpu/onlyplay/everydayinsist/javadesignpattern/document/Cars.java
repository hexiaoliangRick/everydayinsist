package com.cpu.onlyplay.everydayinsist.javadesignpattern.document;

import java.util.Map;
import java.util.Optional;

/**
 * @author: cpuRick
 * @createTime: 2022/08/16 10:39
 * @description: 动态car类
 */
public class Cars extends AbstractDocument implements HasType, HasPrice, HasParts {
    protected Cars(Map<String, Object> properties) {
        super(properties);
    }

}
