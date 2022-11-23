package com.cpu.onlyplay.everydayinsist.javadesignpattern.combinator;

import java.util.Optional;

/**
 * @author: cpuRick
 * @createTime: 2022/08/29 9:32
 * @description: 验证结果
 */
public interface ValidationResult {

    static ValidationResult valid() {
        return ValidationSupport.valid();
    }

    static ValidationResult inValid(String message) {
        return new Invalid(message);
    }

    boolean isValid();

    Optional<String>getReason();
}
