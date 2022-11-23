package com.cpu.onlyplay.everydayinsist.algorithm.backtracing;

import org.springframework.util.Assert;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: everydayinsist
 * @description: 分隔回文串
 * @author: cpuRick
 * @create: 2022-08-17 22:15
 **/
public class SplitPalindrome {


    public static void main(String[] args) {
//        boolean result = isPalindrome("aab");
//        Assert.isTrue(result);
        partition("cdd");
    }


    public static List<List<String>> partition(String s) {

        List<List<String>> result = new LinkedList<>();
        backtracing(s, 0, s.length(), new LinkedList<>(), result);
        return result;
    }

    private static void backtracing(String input, int startIndex, int max, Deque<String> paths, List<List<String>> result) {
        if (startIndex >= max) {
            result.add(new LinkedList<>(paths));
            return;
        }

        for (int index = startIndex + 1; index <= max; index++) {
            String current = input.substring(startIndex, index);
            if (isPalindrome(current)) {
                paths.addLast(current);
                backtracing(input, index, max, paths, result);
                paths.removeLast();
            }
        }
    }

    private static boolean isPalindrome(String value) {
        int start = 0, end = value.length() - 1;
        while (start < end) {
            if (value.charAt(start) != value.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


}
