package com.cpu.onlyplay.everydayinsist.algorithm;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @program: everydayinsist
 * @description: 二进制操作测试类
 * @author: cpuRick
 * @create: 2022-08-11 21:13
 **/
@Slf4j
public class BinaryOperatorTest {

    @Test
    public void test_operate() {
        int a = 0, b = 1, c = 2;
        int value = a ^ c;
        log.info("{}", value);
    }

    @Test
    public void test_multi_freq_value() {
        int nums[] = new int[]{3, 2, 3};

        int value = majorityElement(nums);
        Assertions.assertEquals(value, 3);
    }

    public int majorityElement(int[] nums) {
        int major = 0;
        int maxFreq = nums.length / 2;
        int mask = 1;
        for (int index = 0; index < 32; index++) {
            int bitFreq = 0;
            for (int value : nums) {
                if ((mask & value) == mask) {
                    bitFreq++;
                }
            }
            if (bitFreq > maxFreq) {
                major = major | mask;
            }
            mask = mask << 1;
        }
        return major;
    }
}

