package com.cpu.onlyplay.everydayinsist.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.stream.IntStream;

/**
 * @program: everydayinsist
 * @description: 字符串操作
 * @author: cpuRick
 * @create: 2022-08-15 20:59
 **/
@Slf4j
public class CharacterOperatorTest {

    @Test
    public void test_character_judge() {
        Character.isLetterOrDigit('.');
        StringBuilder stringBuilder = new StringBuilder();

        boolean result = isPalindrome("0P");
        log.info("{}", result);
    }

    public boolean isPalindrome(String s) {
        String normalStr = s.replaceAll("[^a-zA-Z1-9]", "").toLowerCase();
        StringBuilder reverseBuilder = new StringBuilder(normalStr).reverse();
        String reverseString = reverseBuilder.toString();
        return normalStr.equals(reverseString);
    }
}
