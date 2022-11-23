package com.cpu.onlyplay.everydayinsist.javadesignpattern.combinator;

import java.util.Optional;

/**
 * @author: cpuRick
 * @createTime: 2022/08/29 9:34
 * @description:
 */
final class Invalid implements ValidationResult {

    private final String reason;

    Invalid(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public Optional<String> getReason() {
        return Optional.ofNullable(reason);
    }
}
