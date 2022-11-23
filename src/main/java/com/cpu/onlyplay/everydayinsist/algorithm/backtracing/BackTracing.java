package com.cpu.onlyplay.everydayinsist.algorithm.backtracing;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @program: everydayinsist
 * @description: 回溯算法
 * @author: cpuRick
 * @create: 2022-08-16 22:09
 **/
public class BackTracing {


    public static void main(String[] args) {
        combine(3, 3);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        int[] array = IntStream.range(1, n + 1).toArray();
        Deque<Integer> roundValues = new LinkedList<>();
        for (int value : array) {
            roundValues.addLast(value);
            backtracing(array, value, n, result, roundValues, k);
            roundValues.removeLast();
        }
        return result;

    }

    private static void backtracing(int[] array, int startIndex, int end, List<List<Integer>> result, Deque<Integer> vistedValues, int maxDeepth) {
        if (vistedValues.size() >= maxDeepth) {
            result.add(new LinkedList<Integer>(vistedValues));
            return;
        }
        for (Integer value = startIndex + 1; value <= end; value++) {
            if (!vistedValues.contains(value)) {
                vistedValues.addLast(value);
                backtracing(array, value, end, result, vistedValues, maxDeepth);
                vistedValues.pollLast();
            }
        }
    }
}
