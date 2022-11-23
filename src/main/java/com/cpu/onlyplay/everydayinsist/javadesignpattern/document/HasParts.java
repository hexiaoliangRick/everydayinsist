package com.cpu.onlyplay.everydayinsist.javadesignpattern.document;

import java.util.Optional;

/**
 * @author: cpuRick
 * @createTime: 2022/08/16 10:07
 * @description: 是否有部分
 */
public interface HasParts extends Document {
    default Optional<Number> getParts() {
        return Optional.ofNullable((Number) get(Property.PARTS.toString()));
    }
}
