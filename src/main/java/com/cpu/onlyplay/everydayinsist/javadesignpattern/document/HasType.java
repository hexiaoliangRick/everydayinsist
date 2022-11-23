package com.cpu.onlyplay.everydayinsist.javadesignpattern.document;

import java.util.Optional;

/**
 * @author: cpuRick
 * @createTime: 2022/08/16 10:04
 * @description: 是否有type类型
 */
public interface HasType extends Document {

    default Optional<String> getType() {
        return Optional.ofNullable((String) get(Property.TYPE.toString()));
    }
}
