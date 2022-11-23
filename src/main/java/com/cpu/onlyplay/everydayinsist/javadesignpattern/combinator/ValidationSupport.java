package com.cpu.onlyplay.everydayinsist.javadesignpattern.combinator;

import java.util.Optional;

/**
 * @author: cpuRick
 * @createTime: 2022/08/29 9:35
 * @description:
 */
public final class ValidationSupport {
    private static final ValidationResult valid = new ValidationResult() {
        @Override
        public boolean isValid() {
            return true;
        }

        @Override
        public Optional<String> getReason() {
            return Optional.empty();
        }
    };

    static ValidationResult valid() {
        return valid;
    }
}
