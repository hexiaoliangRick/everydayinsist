package com.cpu.onlyplay.everydayinsist.javadesignpattern.document;

import java.util.Optional;

/**
 * @author: cpuRick
 * @createTime: 2022/08/16 10:05
 * @description: 是否有价格
 */
public interface HasPrice extends Document {
    default Optional<Number> getPrice() {
        return Optional.ofNullable((Number) get(Property.PRICE.toString()));
    }
}
