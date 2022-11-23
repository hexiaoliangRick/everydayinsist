package com.cpu.onlyplay.everydayinsist.javadesignpattern.document;

import java.util.Optional;

/**
 * @author: cpuRick
 * @createTime: 2022/08/16 10:06
 * @description:
 */
public interface HasModel extends Document {
    default Optional<Number> getModel() {
        return Optional.ofNullable((Number) get(Property.MODEL.toString()));
    }
}
