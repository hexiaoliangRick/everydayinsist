package com.cpu.onlyplay.everydayinsist.javadesignpattern.combinator;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author: cpuRick
 * @createTime: 2022/08/29 9:36
 * @description:
 */
public interface UserValidation extends Function<User, ValidationResult> {

    static UserValidation nameIsNotEmpty() {
        return holds(u ->
                        u.getName().isEmpty()
                , "name is empty");
    }


    static UserValidation eMailContainsAtSign() {
        return holds(u -> u.getEmail().contains("@"), "Missing@");
    }

    default UserValidation and(UserValidation other) {
        return user -> {
            final ValidationResult result = this.apply(user);
            return result.isValid() ? other.apply(user) : result;
        };
    }

    default UserValidation all(UserValidation... validations) {
        return user -> {
            int index = 0;
            while (index < validations.length) {
                final ValidationResult result = validations[index].apply(user);
                if (result.isValid()) {
                    return result;
                }
                index++;
            }
            return ValidationResult.valid();
        };
    }

    static UserValidation holds(Predicate<User> p, String message) {
        return user -> p.test(user) ? ValidationResult.valid() : ValidationResult.inValid(message);
    }
}
